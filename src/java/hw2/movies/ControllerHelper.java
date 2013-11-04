/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.movies;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.ButtonMethod;
import shared.HelperBaseCh4;

/**
 *
 * @author Erik
 */
public class ControllerHelper extends HelperBaseCh4 {
    
    protected MovieListValidation movieData = new MovieListValidation();
    
    public ControllerHelper ( HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {
        super(servlet, request, response);
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
        return "/WEB-INF/hw2/" + page;
    }
    
    @ButtonMethod(buttonName="processButton")
    public String processMethod() {
        logger.debug("Process button called " + this.movieData.getTitle());
        return "process.jsp";
    }
    
    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() {
        fillBeanFromRequest(movieData);
        return "confirm.jsp";
    }
    
    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() {
        logger.warn("Call to editMethod " + request.getParameter("editButton"));
        return "edit.jsp";
    }

    public void doGet() throws IOException, ServletException {
        logger.info("Called doGet()");
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
