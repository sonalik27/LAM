<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Add Class</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<br />&nbsp;&nbsp
	<font color="red"> <%
 	String message = (String) session.getAttribute("message");
	if(message!=null && !message.isEmpty()){
		 out.print(message);
	}
	 session.setAttribute("message", "");
 %></font>
	
	<h3>Add New Class:</h3> <br/>

<form action="addClass">
		<table>
			<tr>
				<td>Class Name :</td>
				<td><input name="className" type="text"></td>
			</tr>
			<tr align="right">
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
			</table>    
  </form>


</body>
</html>
