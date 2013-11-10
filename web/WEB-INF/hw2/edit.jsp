<%@include file="includes/header.jsp" %>
        
    <body>
    <h3>Add A Movie</h3>
         <div id="intro">
                <p>Add information about a movie such as title, a description (ex. about the movie!), the rating, quantity and price.  Adding a movie to your wishlist
                   will allow you to keep track of movies you want to see or have seen and purchase them.
                </p>
         </div>
        <form action="Controller">
            <p>Title: <input type="text" name="title" value="${movieHelper.movieData.title}" required="required"></p>
            <p>Rating: <input type="text"  name="rating" value="${movieHelper.movieData.rating}" required="required"></p> 
            <p>Quantity ( available movies in stock ): <input type="text" name="quantity" value="${movieHelper.movieData.quantity}" required="required"></p>
            <p>Price ( Price of Movie ): <input type="text" name="price" value="${movieHelper.movieData.price}" required="required"></p>
            <p>Embed Code (Search <a href="http://www.youtube.com" target="_blank">YouTube</a> For An Embed Code)</p><textarea rows="5" cols="50" name="embedCode">${movieHelper.movieData.embedCode}</textarea>
            <p>Movie Description:</p><textarea rows="10" cols="50" name="description">${movieHelper.movieData.description}</textarea>
            <br />
            <input type="submit" name="confirmButton" value="Confirm" />
        </form>
    </body>
</html>