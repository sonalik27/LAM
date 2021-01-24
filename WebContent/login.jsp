<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy Login</title>
<style>
 form { margin: 0 auto; }
</style>
</head>
<body>
     <jsp:include page="header.jsp"/>
     <form action="login" method="post">
       <br/><br/>
       <br/><br/>&nbsp;&nbsp;Please Login with Admin Credentials here:
       <br/><br/>&nbsp;&nbsp;User Name:&nbsp;&nbsp;<input name="username" type="text">
       <br/><br/>&nbsp;&nbsp;Password:&nbsp;&nbsp;&nbsp;&nbsp;<input name="password" type="password">
       <br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Submit"/>
       <br/><br/>&nbsp;&nbsp<font color="red">
         <% 
			String error=(String)session.getAttribute("error"); 
			out.print(error);
			session.setAttribute("error", "");
		%> 
       </font>       
     </form>

</body>
</html>