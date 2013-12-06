/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.movies;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.ButtonMethod;
import shared.HelperBaseCh5;
import shared.HibernateHelper;

/**
 *
 * @author Erik
 */
public class ControllerHelper extends HelperBaseCh5 {
    
    protected Movie movieData = new Movie();
    
    public ControllerHelper ( HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {
        super(servlet, request, response);
    }
    public static void initHibernate(HttpServlet servlet) {
        Properties props = new Properties();
        
        props.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.connection.driver_class",
                "com.mysql.jdbc.Driver");
        props.setProperty("hibernate.c3p0.min_size", "1");
        props.setProperty("hibernate.c3p0.max_size", "5");
        props.setProperty("hibernate.c3p0.timeout", "300");
        props.setProperty("hibernate.c3p0.max_statements",
                "50");
        props.setProperty("hibernate.c3p0.idle_test_period",
                "300");

        //The following properties must be updated with your information.
        //Replace the capitalized words with your database information.
        //The standard port for MySQL is 3306.
        //jdbc:mysql://SERVER:PORT/DATABASENAME
        props.setProperty("hibernate.connection.url",
                "jdbc:mysql://localhost:3306/cgs_4854");
        props.setProperty("hibernate.connection.username",
                "root");
        props.setProperty("hibernate.connection.password",
                "");
        
        boolean create = 
                Boolean.parseBoolean(servlet.getInitParameter("create"));
        
        if ( create ) {
            HibernateHelper.createTable( props, Movie.class );
        } 
        
        HibernateHelper.initSessionFactory(props, Movie.class);
    }
    
    public Object getMovieData(){
        return movieData;
        
    }
    
    @Override
    public void copyFromSession(Object sessionHelper) {
        logger.info("Method call copyFromSession(Object sessionHelper)");
        if (sessionHelper.getClass() == this.getClass()) {
            movieData = ((ControllerHelper)sessionHelper).movieData;
        }
    }
    
    String jspLocation(String page) {
        return "/WEB-INF/hw3/" + page;
    }
    
    @ButtonMethod(buttonName="processButton")
    public String processMethod() {
        logger.debug("Process button called " + this.movieData.getTitle());
        logger.debug("Movie ID" + this.movieData.getId());
         if ( !isValid( movieData )) {
            return "expired.jsp";
        }
         
        HibernateHelper.updateDB( movieData );
        List list = HibernateHelper.getListData( movieData.getClass());
        request.setAttribute("movieDatabase", list);
        return "process.jsp";
    }
    
    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() {
        fillBeanFromRequest(movieData);
        if( isValid(movieData)) {
            return "confirm.jsp";
        }
        return "edit.jsp";
    }
    
    @ButtonMethod (buttonName = "wishListButton" )
    public String wishListMethod() {
        return "wishlist.jsp";
    }
    
    @ButtonMethod(buttonName="viewButton")
    public String viewMethod() {
        return "view.jsp";
    }
    
    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() {
        logger.warn("Call to editMethod " + request.getParameter("editButton"));
        return "edit.jsp";
    }
    
   
    
   

    public void doGet() throws IOException, ServletException {
        logger.info("Called doGet()");
        addHelperToSession("movieHelper", SessionData.IGNORE);

        String address;
        String page;
        page = editMethod();
        address = jspLocation(page);

        //Create a request dispatcher for the address 
        //and forward the request and response objects to it always relave to root of web app not server.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
    
    void doPost() 
        throws IOException, ServletException {
        
        logger.info("Called doPost()");
        addHelperToSession("movieHelper", SessionData.READ);

        String address;
        String page;
        page = executeButtonMethod();
        address = jspLocation(page);

        //Create a request dispatcher for the address 
        //and forward the request and response objects to it always relave to root of web app not server.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
