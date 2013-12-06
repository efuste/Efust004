/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.movies;

import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
/**
 *
 * @author Erik
 */
@Entity
public class Movie {
    
    private Long id;
    protected String title;
    protected String description;
    protected String rating;
    protected int quantity;
    protected String embedCode;
    protected double price;
    
    protected Logger logger;
    
   
    public Movie() {
           
        logger = Logger.getLogger("errorhw3.movies.log");
        logger.setLevel(Level.toLevel("DEBUG"));
    
    }
    
     // used as primary key for entity RequestDataPersistent() 
    @Id
    @GeneratedValue
    public Long getId() {
        return this.id;
    }
    
    protected void setId( Long id) {
        this.id = id;
    }
    
    @NotNull
    @Pattern(regexp = ".*\\S.*" , message = "cannot be empty")
    public String getEmbedCode() {
        return this.embedCode;
    }
    
    @NotNull
    @Pattern(regexp = ".*\\S.*" , message = "cannot be empty")
    public String getTitle() {
        return this.title;
    }
    
    @NotNull
    @Pattern( regexp = ".*\\S.*" , message = "cannot be empty")
    public String getDescription() {
            return this.description;
    }
    
    @NotNull
    @Pattern ( regexp = "((?i)G)||((?i)PG)||((?i)PG13)||((?i)R)" , message = "Must be G, PG, PG13, R, NC17")
    public String getRating() {
        logger.info("Inside the getRating() method");
        
        return this.rating;
    }
    
    @NotNull
    @Min(value=1 , message ="Must be greater than 1.")
    @Max(value =100 , message = "Must be lower then 100.") 
    public int getQuantity() {
       return this.quantity;
    }
    
    @NotNull
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
    
   
    @Transient
    public String getFormattedTotal() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getPotentialProfit());
    }
    @Transient
    public double getPotentialProfit() {
        return this.getQuantity() * this.getPrice();
               
    }
    
    @Transient
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
