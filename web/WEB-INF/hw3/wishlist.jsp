<%@include file="includes/header.jsp" %>

    <body>
        
        <div id="container">
            
            <div id="intro">
                <h1>Movie Wish List</h1>
                <p>A wish list for users to store movie information.    
                    I hope to expand this to the point where a movie title can be clicked and information about that movie can be 
                    viewed and other more advanced feature can be applied such as a rating system, ability to buy the movie etc. etc..
                </p>
            </div>
        
            <div class="wishlist">
                ${movieHelper.movieData.movieInfo}
            </div>
        
            <form action="Controller" method="post" >
                <input type="submit" name="editButton" value="Edit" />
            </form> 
        </div>
    </body>

</html>