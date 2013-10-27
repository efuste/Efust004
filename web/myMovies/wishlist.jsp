<!doctype html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Confirm Page</title>
        <link rel="stylesheet" href="${request.contextPath}../styles/style.css" type="text/css" />

    </head>
    <body>
        <h3>My Movie Wish List</h3>
        <div id="intro">
             <p>A wish list for users to store movie information.    
                I hope to expand this to the point where a movie title can be clicked and information about that movie can be 
                viewed and other more advanced feature can be applied such as a rating system, ability to buy the movie etc. etc..
             </p>
        </div>
        
        <div class="wishlist">
           ${myMovies.data.movieInfo}
        </div>
        
        <form action="Controller" >
             <input type="hidden" name="title" value="${myMovies.data.title}"> 
             <input type="hidden" name="note" value="${myMovies.data.note}"> 
            <input type="hidden" name="rating" value="${myMovies.data.rating}">
            <input type="submit" name="editButton" value="Edit" />
            <input type="submit" name="confirmButton" value="Confirm" />

        </form>        
    </body>

</html>