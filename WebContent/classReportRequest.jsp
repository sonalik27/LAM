<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp" isErrorPage="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Class Report</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<br />&nbsp;&nbsp
	<font color="red"> <%
 	String message = (String) session.getAttribute("message");
 if (message != null && !message.isEmpty()) {
 	out.print(message);
 }
 session.setAttribute("message", "");
 %></font>

	<h3>Select class for genereting report:</h3>
	<br />

	<form action="generateClassReport" method="post">
		<table>
			<tr>
				<td>Class Name :</td>
				<td><select name="selectClass">
						<c:forEach items="${allClassList}" var="aclass">
							<option value="${aclass.classId}">${aclass.className}</option>
						</c:forEach>
				</select></td>
			</tr>
		   <tr align="right">
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form>


</body>
</html>
