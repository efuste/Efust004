<%@include file="includes/header.jsp" %>

    <body>
        <div id="intro">
            <p>Features I hope to add are a movie page that will display movie information and perhaps a trailer for the movie.</p>
        </div>
        
        <div class="wishlist">
           ${movieHelper.movieData.movieInfo}
        </div>
        <p>Potential Profit: ${movieHelper.movieData.formattedTotal}</p>
        <form action="Controller" >
            
             <input type="submit" name="editButton" value="Edit" />
        </form>        
    </body>

</html>