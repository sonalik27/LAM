<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="error.jsp" isErrorPage="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Assign Subject For Classes</title>
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

	<h3>Assign subjects for the classes :</h3>
	<br />

	<form action="assignSubjectToClass" method="post">
		<table>
			<tr>
				<td>Class Name :</td>
				<td><select name="selectClass">
						<c:forEach items="${classList}" var="aclass">
							<option value="${aclass.classId}">${aclass.className}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Subject Name :</td>
				<td><select name="selectSubject">
						<c:forEach items="${allSubjectsList}" var="subject">
							<option value="${subject.subjectId}">${subject.subjectName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr align="right">
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

		<br />

		<c:if test="${classSubjectsList.size()>0}">
			<table>
				<tr align="right">
					<th colspan="2">Assigned subjects for class '${displayingClassSubjrectsForTeacher}':</th>
					<th>Class Name</th>
					<th>Subject Name</th>
					<c:forEach items="${classSubjectTeachersList}" var="cst">
						<td>${cst.aClass.className}</td>
						<td>${cst.subject.subjectName}</td>
					</c:forEach>					
				</tr>
				</c:if>
			</table>
	</form>


</body>
</html>
