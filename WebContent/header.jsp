<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  padding-top: 20px;
  padding-right: 50px;
  padding-bottom: 50px;
  padding-left: 50px;
  font-size:20px;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>
<meta charset="ISO-8859-1">
</head>
<body>
   <h1 align="center">Learner's Academy</h1><br/>
   <center><font color="green">Excellence and beyond...</font></center><align="center">
   
   <c:choose >
	<c:when test="${userId>0}">
	   <h5 right> 
	   <a href="home.jsp">Home</a>  
	    &nbsp;&nbsp;|&nbsp;&nbsp;
	   <a href="logout">Log Out</a></h5>	
	</c:when>
	
	</c:choose>
   <hr/>
      <!-- <h6 align="right"> <a href="home.jsp"></a>Home | Log In/Out </h6>-->
   
  
</body>
</html>