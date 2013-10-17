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
    
    protected RequestDataDefault data = new RequestDataDefault();
    
    public ControllerHelper ( HttpServlet servlet, HttpServletRequest request, HttpServletResponse response) {
        super(servlet, request, response);
    }
    
    public Object getData(){
        return data;
        
    }
    
    public void doGet() throws IOException, ServletException{
        request.getSession().setAttribute("myMovies", this);
        
        data.setTitle(request.getParameter("title"));
        data.setNote(request.getParameter("note"));
        data.setRating(request.getParameter("rating"));
        
        String address;
        
        if (request.getParameter("processButton") != null) {
            address = "process.jsp";
        } else if (request.getParameter("confirmButton") != null) {
            address = "confirm.jsp";
        } else {
            address = "edit.jsp";
        }

        //Create a request dispatcher for the address 
        //and forward the request and response objects to it.
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
        
    }
}
