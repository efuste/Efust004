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
                <p>Add information about a movie such as title, a description (ex. about the movie!), the rating, quantity and price.  Adding a movie to your wishlist
                   will allow you to keep track of movies you want to see or have seen and purchase them.
                </p>
         </div>
        <form action="Controller">
            <p>Title: <input type="text" name="title" value="${movieHelper.movieData.title}"></p> 
            <p>Movie Description: <input type="text" name="description" value="${movieHelper.movieData.description}"></p> 
            <p>Rating: <input type="text" name="rating" value="${movieHelper.movieData.rating}"></p> 
            <p>Quantity ( 1 or more ): <input type="text" name="quantity" value="${movieHelper.movieData.quantity}"></p>
            <p>Price ( Price of Movie ): <input type="text" name="price" value="${movieHelper.movieData.price}"></p>
            <input type="submit" name="confirmButton" value="Confirm" />
        </form>
    </body>
</html>