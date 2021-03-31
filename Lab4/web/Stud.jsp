<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Stud
    Created on : 27.03.2021, 2:14:50
    Author     : Привет
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="https://i2.wp.com/awdee.ru/wp-content/uploads/2017/08/jW4fvC_C6XE.jpg?ssl=1">
        
       <h1 style="color:darkgreen"> Students List</h1>
        <c:set var="score" value="${['0' ,'1' ,'2' ,'3' ,'4' ,'5' ,'6' ,'7' ,'8' ,'9' ,'10' ,'11' ,'12' ,'13' ,'14' ,'15' ,'16' ,'17' ,'18' ,'19' ,'20' ,'21' ,'22' ,'23' ,'24' ,'25' ,'26' ,'27' ,'28' ,'29' ,'30' ,'31' ,'32' ,'33' ,'34' ,'35' ,'36' ,'37' ,'38' ,'39' ,'40' ,'41' ,'42' ,'43' ,'44' ,'45' ,'46' ,'47' ,'48' ,'49' ,'50' ,'51' ,'52' ,'53' ,'54' ,'55' ,'56' ,'57' ,'58' ,'59' ,'60' ,'61' ,'62' ,'63' ,'64' ,'65' ,'66' ,'67' ,'68' ,'69' ,'70' ,'71' ,'72' ,'73' ,'74' ,'75' ,'76' ,'77' ,'78' ,'79' ,'80' ,'81' ,'82' ,'83' ,'84' ,'85' ,'86' ,'87' ,'88' ,'89' ,'90' ,'91' ,'92' ,'93' ,'94' ,'95' ,'96' ,'97' ,'98' ,'99' ,'100' ]}" scope="page"/>
          <h3 style="color:darkgreen">Add New Student</h3>
          
        <form action="addNewStudentServlet" >
            <input type="text" name="FirstNameStudent" placeholder="Write The  First Name Of The Student " size="40">
           <input type="text" name="LastNameStudent" placeholder="Write The Last Name Of The Student " size="40">
           <input type="text" name="numberRecordBook" placeholder="Write The Number Of The Reacord Book Student " size="45">
           
           
            <h2 style="color:darkgreen">   Select Student Avarage Score </h2>
           <select name="AverageScore"   >
                <option disabled> Score </option>
              <c:forEach var="i" items="${score}">
                <option value="${i}">${i} </option>
              </c:forEach>
           </select>
           <br><br><br>
           <button type="submit"  name="AddNewStudent" value="${facultyName}" > Add New Student </button>
           
        </form>
        
        <c:forEach var="student" items="${facultyListStudents}">
        <h3 style="color:darkgreen">------------------------------------------------------</h3>
         ${student.getNumberRecordBook()} <br>
         ${student.getLastName()} <br>
         ${student.getFirstName()} <br>
         ${student.getAverageScore()}
         <br> <br>
         
          <form action="deleteStudentServlet" >
            
             <input type="hidden" name="facultyName" value="${facultyName}">
           <button type="submit"  name="Student" value="${student.getNumberRecordBook()}"   >Delete This Student</button>
           
        </form>
           <br>
           <br>
               </c:forEach>
           <h5><a href="index.jsp">Main Page</a></h5>
    </body>
    
   
</html>
