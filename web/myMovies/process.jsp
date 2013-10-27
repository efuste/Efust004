<!doctype html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Confirm Page</title>
        <link rel="stylesheet" href="${request.contextPath}../styles/style.css" type="text/css" />

    </head>
    <body>
        <div id="intro">
            <p>Features I hope to add are a movie page that will display movie information and perhaps a trailer for the movie.</p>
        </div>
        
        <div class="wishlist">
           ${myMovies.data.movieInfo}
        </div>

        <form action="Controller" >
             <input type="hidden" name="title" value="${myMovies.data.title}"> 
             <input type="hidden" name="note" value="${myMovies.data.note}"> 
            <input type="hidden" name="rating" value="${myMovies.data.rating}">
            <input type="submit" name="editButton" value="Edit" />
        </form>        
    </body>

</html>