/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myMovies;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erik
 */
public class ControllerHelper extends HelperBase {
    
    protected MovieListValidation movieData = new MovieListValidation();
    
    public ControllerHelper ( HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {
        super(servlet, request, response);
    }
    
    public Object getMovieData(){
        return movieData;
        
    }
    
    public void doGet() throws IOException, ServletException{
        request.getSession().setAttribute("myMovies", this);
        
        movieData.setTitle(request.getParameter("title"));
        movieData.setNote(request.getParameter("note"));
        movieData.setRating(request.getParameter("rating"));
        
        String address;
        
        if (request.getParameter("processButton") != null) {
            address = "process.jsp";
        } else if (request.getParameter("confirmButton") != null) {
            address = "confirm.jsp";
        } else if (request.getParameter("wishListButton") != null) {
            address = "wishlist.jsp";
        }    
        else {
            address = "edit.jsp";
        }

        //Create a request dispatcher for the address 
        //and forward the request and response objects to it.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
        
    }
}
