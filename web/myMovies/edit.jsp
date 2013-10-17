<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Edit Page</title>
        <link rel="stylesheet" href="${request.contextPath}../styles/style.css" type="text/css" />

        
    </head>
    <body>
        <form action="">
            <p>This is a simple HTML page that has a form in it.</p>
            <p>Title: <input type="text" name="title" value="${myMovies.data.title}"></p> 
            <p>My Note: <input type="text" name="note" value="${myMovies.data.note}"></p> 
            <p>Rating: <input type="text" name="rating" value="${myMovies.data.rating}"></p> 

            <input type="submit" name="confirmButton" value="Confirm">
        </form>
    </body>
</html>