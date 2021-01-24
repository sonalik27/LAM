<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Assign Class-Subject For Teacheres</title>
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

	<h3>Assign class for the teacheres :</h3>
	<br />

	<form action="assignClassToTeacher" method="post">
		<table>
			<tr>
				<td>Teacher Name :</td>
				<td><select name="selectTeacher">
						<c:forEach items="${teacherList}" var="teacher">
							<option value="${teacher.teacherId}">${teacher.teacherName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Class Name :</td>
				<td><select name="selectClass">
						<c:forEach items="${allClassList}" var="aClass">
							<option value="${aClass.classId}">${aClass.className}</option>
						</c:forEach>
				</select></td>
			</tr>
			
			<tr align="right">
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

		<br />

		<c:if test="${teacherClassList.size()>0}">
			<table>
				<tr align="right">
					<td>Assigned class for teacher '${displayingClassForTeacher}':</td>
					<td><c:forEach items="${teacherClassList}" var="teacherclass">
							${teacherclass.classSubject.aClass.className}<br />
						</c:forEach></td>
				</tr>
				
				
				</table>
				
		</c:if>
	</form>


</body>
</html>
