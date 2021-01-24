<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learners Academy Home</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<center>
<c:choose>
<c:when test="${userId>0}">
    <a href="showStudents"> Show Students </a><br/>
    <a href="showAddStudents"> Add Student</a><br/>
    <a href="showTeachers"> Show Teachers </a><br/>
    <a href="showAddTeacher"> Add Teacher</a><br/>
    <a href="showClasses">Show Classes</a><br/>
    <a href="addClass.jsp">Add Class</a><br/>
    <a href="showSubjects">Show Subjects</a><br/>
    <a href="addSubject.jsp">Add Subject</a><br/>
    <a href="showAssignClassSubjects">Assign subjects for Classes</a><br/>    
    <a href="showAssignClassToTeacher"> Assign Class for Teacher</a><br/>
    <a href="showClassReportRequestPage"> Class Report</a><br/>
</c:when>
<c:otherwise>
     <marquee><h1> Welcome to Learners Academy's Admin Portal</h1></marquee>
</c:otherwise>
</c:choose>
</center>
</body>
</html>