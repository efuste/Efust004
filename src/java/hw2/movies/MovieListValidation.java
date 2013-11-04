/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.movies;

import org.apache.log4j.Logger;
/**
 *
 * @author Erik
 */
public class MovieListValidation {
    protected String title;
    protected String description;
    protected String rating;
    protected int quanitity;
    protected double price;
    
    protected Logger logger;
    
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
        if(isValidRating()){
            return this.rating;
        }
        return "No Rating Provided";
    }
    
    public int getQuantity() {
        if ( isValidQuantity()) {
            return this.quanitity;
        }
        
        return 1;
    }
  
    public double getPrice() {
        return this.price;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        logger.info("Inside setRating method of Bean");
        this.rating = rating;
    }
    
    public void setQuantity( int quantity ){
        this.quanitity = quantity;
    }
    
    public void setPrice ( double price ) {
        this.price = price;
    }
    
    private boolean isValidQuantity() {
        if ( this.quanitity > 0 ) {
            return true;
        }
        
        return false;
    }
    private boolean isValidMovieTitle() {
       return this.title != null && !title.equals("");
    }
    
    private boolean isValidMovieDescription() {
        return this.description!= null && !description.equals("");
    }
    
   
    public double getTotal() {
        return this.quanitity * this.price;
               
    }
    
    private boolean isValidRating(){
        String[] ratings = { "NR", "G", "PG", "PG13", "R", "NC-17"};
        
        if(this.rating != null && !this.rating.equals(" ")){
            for (int i = 0; i < ratings.length ; i++){
                if(this.rating.replaceAll("\\W", "").equals(ratings[i])){
                    return true;
                }
            }
        } 
       return false;
    }
    
  
    public String getMovieInfo(){
        String info;
       
        info = "<table>\n" +
               "<tr>\n" + 
               "<th> Movie Title </th>\n" +
               "<th> My Description </th>\n" +
               "<th> Movie Rating </th>\n" +
                "<th> Quantity </th>\n" +
                "<th> Price </th>\n" +
               "</tr>\n" + 
               "<tr>\n" + 
               "<td>" + this.getTitle() + "</td>" + 
               "<td>" + this.getDescription() + "</td>" + 
               "<td>" + this.getRating() + "</td>" +
                "<td>" + this.getQuantity() + "</td>" +
                "<td>" + this.getPrice() + "</td>" +
               "</tr>\n" + 
               "</table>";
                       
               
        
              
        
        return info;
    }
    

}
