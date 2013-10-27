<!doctype html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Confirm Page</title>
        <link rel="stylesheet" href="${request.contextPath}../styles/style.css" type="text/css" />

    </head>
    <body>
        <p>The Movie Title Entered was <strong>${myMovies.data.title}</strong></p>
        <p>Note: <strong>${myMovies.data.note}</strong></p>
        <p>The Movie is Rated: <strong>${myMovies.data.rating}</strong></p>

        

        <form action="Controller" >
            <input type="hidden" name="title" value="${myMovies.data.title}" /> 
            <input type="hidden" name="note" value="${myMovies.data.note}" /> 
            <input type="hidden" name="rating" value="${myMovies.data.rating}" />
            <textarea type="hidden" name="embedCode" value=""${myMovies.data.emdedcode} /></p>

            <input type="submit" name="editButton" value="Edit" />
            <input type="submit" name="processButton" value="Process" />
        </form>
       
        
    </body>

</html>