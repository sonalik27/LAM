<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Show Teachers</title>
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
	 %>
	</font>
	<p>
		<c:out value="${teacherList.size()}" /> Record(s) Found for Teachers
	</p>

 <c:if test="${teacherList.size()>0 }">
	<h3>All Teachers List:</h3>
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>dob</th>
			<th>Assigned Class-Subjects</th>
		</tr>
		<c:forEach var="teacher" items="${teacherList}">
			<tr>
				<td>     ${teacher.teacherId}</td>
				<td>     ${teacher.teacherName}</td>
				<td>     ${teacher.addressLine1} <br />
					 ${teacher.addressLine2},  ${teacher.city.cityName},
					 ${teacher.state.stateName},  ${teacher.country.countryName}
				</td>
				<td>     ${teacher.dob}</td>
				<td> 
					<c:forEach var="classSubject" items="${teacher.classSubjectList}">
					     ${classSubject.aclass.className} - ${classSubject.subject.subjectName},&nbsp;
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>