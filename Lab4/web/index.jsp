<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body  background="https://i2.wp.com/awdee.ru/wp-content/uploads/2017/08/jW4fvC_C6XE.jpg?ssl=1">
    <center>
        <h1 style="color:darkgreen"><b>Main Page</b></h1>
        
        <br> <br><br><br>
        
        
        
        <h3 style="color:darkgreen">Add New Faculty</h3>
        
        <form action="addNewFacultyServlet" >
            <p> Faculty Name</p> <input type="text" name="NameFaculty" placeholder="Write  The Name Of The  New Faculty"size="40">
         
         <button type="submit"  name="Add New Faculty"  > Add New Faculty</button>
        </form>
        
       <h2 style="color:darkgreen">List of Faculties</h2>
       
     
       <c:forEach var="faculty" items="${result}">
       <h3 style="color:darkgreen">------------------------------------------------------</h3>
         ${faculty.getName()} <br>
          <form action="deleteFacultyServlet" >
          
          <button type="submit"  name="NameFaculty" value="${faculty.getName()}" >Delete This Faculty</button>
         
        </form>
         <br><br>
      <form action="viewStudentsServlet" >

           <button type="submit"  name="NameFaculty" value="${faculty.getName()}" >To See The List Of Students</button>
        </form>
     </c:forEach>
    
    
    </center>
    </body>
</html>
