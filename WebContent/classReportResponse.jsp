<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						   <c:choose>
						   	<c:when test="${aclass.classId == selectedClass.classId}">						   			
 								<option value="${aclass.classId}" selected>${aclass.className}</option>
						   	</c:when>
						   	<c:otherwise>
						   	<option value="${aclass.classId}">${aclass.className}</option>
						   	</c:otherwise>
						   </c:choose> 
						</c:forEach>
				</select></td>
			</tr>
			  <tr align="right">
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
			</table>
			<br/>
			   <table border="1">
			   		<th> Subjects List: </th>
					<c:forEach var="classsubject" items="${classReportSubjectList}">
						<tr>
							<td>     ${classsubject.subject.subjectId}</td>
							<td>     ${classsubject.subject.subjectName}</td>
						</tr>
					</c:forEach>
			   </table>
		      <br/>
			   <table border="1">
			   		<th> Students List: </th>
					<c:forEach var="student" items="${classReportStudentList}">
						<tr>
							<td>     ${student.studentId} </td>
							<td>     ${student.studentName} </td>
						</tr>
					</c:forEach>
			   </table>
			 <br/>
			   <table border="1">
			   		<th> Teachers List: </th>
					<c:forEach var="teacher" items="${classReportTracherList}">
						<tr>
							<td>     ${teacher.teacherId}</td>
							<td>     ${teacher.teacherName}</td>
						</tr>
					</c:forEach>
			   </table>

	</form>


</body>
</html>
