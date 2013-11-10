<%@include file="includes/header.jsp" %>
    <body>
        <h3>Confirm Movie Information</h3>
        <div id="intro">
            <p>
                Hopefully once the movie information is confirmed it will be written to the database.  This will in the future allow 
                for the data to be persistent and dedicated movie pages can be added with the details nicely formatted with more advanced
                options.
            </p>
        </div>
        
        <div class="wishlist">
           ${movieHelper.movieData.movieInfo}
        </div>    
        

        <form action="Controller" >
            <input type="submit" name="editButton" value="Edit" />
            <input type="submit" name="processButton" value="Process" />
        </form>
       
        
    </body>

</html>