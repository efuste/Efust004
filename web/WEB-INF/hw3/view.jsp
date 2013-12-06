<%@include file="includes/header.jsp" %>

    <body>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
                   prefix="movieCore" %>
        
         <div id="container">
            <div id="intro">
                <h1>All Movies</h1>
            </div>
        
          
       
            
        
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
            </form> 
        
            <form action="Controller" method="get" >
               <input type="submit" name="editButton" value="Start Over" />
            </form>  
         </div>
    </body>

</html>