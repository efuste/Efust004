<%@include file="includes/header.jsp" %>
        
    <body>
    
         
    <div id="container">
        
        
            <div id="intro">
                <h1>Add A Movie</h1>
                    <p>Add information about a movie such as title, a description (ex. about the movie!), the rating, quantity and price.  Adding a movie to your wishlist
                    will allow you to keep track of movies you want to see or have seen and purchase them.
                    </p>
            </div>
            <form action="Controller" method="post">
                <table id="movie_form">
                    
                    <tbody>
                        <tr>
                            <td>
                                <label for="title">Movie Title </label>
                                <input type="text" name="title" id ="title" value="${movieHelper.movieData.title}" > 
                                <span class="error">${movieHelper.errors.title}</span>
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                <label for="rating">Rating (NR, G, PG, PG13, R) </label> 
                                <input type="text"  id="rating" name="rating" value="${movieHelper.movieData.rating}" >
                                <span class="error">${movieHelper.errors.rating}</span>
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                <label for="quantity">Quantity ( available movies in stock )</label> 
                                <input type="text" name="quantity" id="quantity" value="${movieHelper.movieData.quantity}" >
                                <span class="error">${movieHelper.errors.quantity}</span>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="price">Movie Price</label> 
                                <input type="text" id="price" name="price" value="${movieHelper.movieData.price}" >
                                <span class="error">${movieHelper.errors.price}</span>
                            </td>
                        </tr> 
                        <tr>
                            <td>
                                <label for="embedCode">Embed Code (Search <a href="http://www.youtube.com" target="_blank">YouTube</a> For An Embed Code)</label> 
                                <textarea rows="5" cols="50" id="embedCode" name="embedCode">${movieHelper.movieData.embedCode}</textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="description">Movie Description</label> 
                                <textarea rows="10" cols="50" id="description" name="description">${movieHelper.movieData.description}</textarea>
                                <span class="error">${movieHelper.errors.description}</span>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
                
                <input type="submit" name="confirmButton" value="Confirm" />
        
            </form>
    </div>
    </body>
</html>