<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Assign Class-Subject For Teachers</title>
<script type="text/javascript">

function 

</script>
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

	<h3>Assign class-Subject for the teachers :</h3>
	<br />

	<form action="assignSubjectToTeacher" method="post">
		<table>
			<tr>
				<td>Teacher Name :</td> 
				<td><input type="text" value="${teacher.teacherName}" disabled="disabled"/>	
				    <input type="hidden" name="selectTeacher" value= "${teacher.teacherId}"/>
				</td>
			</tr>
			<tr>
				<td>Class Name :</td> 
				<td><input type="text" value="${aClass.className}" disabled="disabled"/>	
					<input type="hidden" name="selectClass" value="${aClass.classId}"/>
				</td>
			</tr>
			<tr>
				<td>Subject Name :</td>
				<td><select name="selectSubject">
						<c:forEach items="${classSubjectList}" var="cs">
							<option value="${cs.subject.subjectId}">${cs.subject.subjectName}</option>
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
