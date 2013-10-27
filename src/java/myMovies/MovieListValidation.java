/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myMovies;

/**
 *
 * @author Erik
 */
public class MovieListValidation {
    protected String title;
    protected String note;
    protected String rating;

    public String getTitle() {
        if(isValidMovieTitle()){
            return this.title;
        }
        
        return "Movie Title Required";
    }

    public String getNote() {
        if(isValidMovieNote()){
            return this.note;
        }
        
        return "Movie Note Not Entered";
    }

    public String getRating() {
        if(isValidRating()){
            return this.rating;
        }
        return "No Rating Provided";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
      private boolean isValidMovieTitle() {
        return this.title != null && !title.equals("");
    }
    
    private boolean isValidMovieNote() {
        return this.note != null && !note.equals("");
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
               "<th> My Notes </th>\n" +
               "<th> Movie Rating </th>\n" +
               "</tr>\n" + 
               "<tr>\n" + 
               "<td>" + this.title + "</td>" + 
               "<td>" + this.note + "</td>" + 
               "<td>" + this.rating + "</td>" + 
               "</tr>\n" + 
               "</table>";
        
              
        
        return info;
    }
    
}

