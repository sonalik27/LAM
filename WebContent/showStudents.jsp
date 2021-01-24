<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Show Students</title>
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
 %>
	</font>
	<p>
		<c:out value="${studentList.size()}" />
		Record(s) Found for Students
	</p>

	<c:if test="${studentList.size()>0 }">
		<h3>All Students List:</h3>
		<br />

		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>DOB</th>
				<th>Class</th>
			</tr>
			<c:forEach var="student" items="${studentList}">
				<tr>
					<td>     ${student.studentId}</td>
					<td>     ${student.studentName}</td>
					<td>     ${student.addressLine1} <br />
						 ${student.addressLine2},  ${student.city.cityName},
						 ${student.state.stateName},  ${student.country.countryName}
					</td>
					<td>     ${student.dob}</td>
					<td>   ${student.aclass.className}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>