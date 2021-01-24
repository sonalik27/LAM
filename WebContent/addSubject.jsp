<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Add Subject</title>
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
	
	<h3>Add New Subject:</h3> <br/>

<form action="addSubject" method="post">
		<table>
			<tr>
				<td>Subject Name :</td>
				<td><input name="subjectName" type="text"></td>
			</tr>
			<tr align="right">
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
			</table>    
  </form>


</body>
</html>
