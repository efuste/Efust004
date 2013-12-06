<%@include file="includes/header.jsp" %>

    <body>
         
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
                   prefix="movieCore" %>
        
         <div id="container">
            <div id="intro">
                <h1>The Process Page</h1>
            </div>
        
            <div class="wishlist">
                ${movieHelper.movieData.movieInfo}
            </div>
            
             
            <p>Potential Profit: ${movieHelper.movieData.formattedTotal}</p>
       
            
             <movieCore:forEach var="rows" items ="${movieDatabase}" >
                ${rows.id},
                ${rows.title},
                ${rows.description},
                ${rows.rating},
                ${rows.price},
                ${rows.embedCode},
                ${rows.quantity},
                <br />
            </movieCore:forEach>
            
            <form action="Controller" method="post" >
                <input type="submit" name="editButton" value="Edit" />
                <input type="submit" name="viewButton" value="View All Movies" />

            </form> 
        
            <form action="Controller" method="get" >

                <input type="submit" name="editButton" value="Start Over" />
            </form>  
            
            
             
        
            
         </div>
    </body>

</html>