<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Edit Page</title>
        <link rel="stylesheet" href="${request.contextPath}../styles/style.css" type="text/css" />

        
    </head>
    <body>
        <h3>Add A Movie</h3>
         <div id="intro">
                <p>Add information about a movie such as title, a note (ex. great movie!), and the rating.  Adding a movie to your wishlist
                   will allow you to keep track of movies you want to see or have seen.
                </p>
         </div>
        <form action="Controller">
            <p>Title: <input type="text" name="title" value="${myMovies.data.title}"></p> 
            <p>My Note: <input type="text" name="note" value="${myMovies.data.note}"></p> 
            <p>Rating: <input type="text" name="rating" value="${myMovies.data.rating}"></p> 

            <input type="submit" name="confirmButton" value="Confirm">
        </form>
    </body>
</html>