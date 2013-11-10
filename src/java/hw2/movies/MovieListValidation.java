/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.movies;

import java.text.NumberFormat;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
/**
 *
 * @author Erik
 */
public class MovieListValidation {
    protected String title;
    protected String description;
    protected String rating;
    protected int quantity;
    protected String embedCode;
    protected double price;
    
    protected Logger logger;
    
    public MovieListValidation() {
           
        logger = Logger.getLogger("errorhw2.movies.log");
        logger.setLevel(Level.toLevel("DEBUG"));
    
    }
    
   
    public String getEmbedCode() {
        if(isValidEmbedCode()) {
            return this.embedCode;
        }
        return "Movie Trailer Not Available";
    }
    
    public String getTitle() {
        if(isValidMovieTitle()){
            return this.title;
        }
        
        return "Movie Title Required";
    }

    public String getDescription() {
        if(isValidMovieDescription()){
            return this.description;
        }
        
        return "Movie Desc. Not Entered";
    }

    public String getRating() {
        logger.info("Inside the getRating() method");
        
        if(isValidRating()){
            return this.rating;
        }
        return "No Rating Provided";
    }
    
    public int getQuantity() {
        if ( isValidQuantity()) {
            return this.quantity;
        }
        
        return 1;
    }
  
    public double getPrice() {
        return this.price;
    }
    
    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public void setQuantity( int quantity ){
        this.quantity = quantity;
    }
    
    public void setPrice ( double price ) {
        this.price = price;
    }
    
    private boolean isValidQuantity() {
        
        return this.quantity> 0;
    }
    private boolean isValidMovieTitle() {
       return this.title != null && !this.title.equals(" ");
    }
    
    private boolean isValidMovieDescription() {
        return this.description != null && !this.description.equals("");
    }
    
    private boolean isValidEmbedCode() {
        return this.embedCode != null && !this.embedCode.equals(" ");
    }
    
    private boolean isValidRating(){
        String[] ratings = { "NR", "G", "PG", "PG13", "R", "NC-17"};
        if(this.rating != null && !this.rating.equals("")){
            for (String rating1 : ratings) {
                if (this.rating.replaceAll("\\W", "").equals(rating1)) {
                    return true;
                }
            }
        } 
       return false;
    }
    
    public String getFormattedTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getPotentialProfit());
    }
    
    private double getPotentialProfit() {
        return this.getQuantity() * this.getPrice();
               
    }
    public String getMovieInfo(){
        String info;
       
        info = "<h2>" + this.getTitle() + "</h2>" +
               "<div id=\"movie-trailer\">" + this.getEmbedCode() + "</div><br />" +
               "<table>\n" +
                    "<tr>\n" + 
                        "<th> Movie Rating </th>\n" +
                        "<th> Quantity </th>\n" +
                        "<th> Price </th>\n" +
                    "</tr>\n" + 
                
                    "<tr>\n" + 
                        "<td>" + this.getRating() + "</td>" +
                        "<td>" + this.getQuantity() + "</td>" +
                        "<td>" + this.getPrice() + "</td>" +
                   "</tr>\n" + 
               "</table>" + 
               
                "<div id=\"movie-description\"> " +
                    "<h4>Synopsis</h4>" + 
                        "<p>" + this.getDescription() + "</p>" + 
                "</div>";
               
       
               
                
                       
               
        
              
        
        return info;
    }
    

}
