<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <jsp:include page="header.jsp"/>     
<p><c:out value="${subjectList.size()}"/> Record(s) Found for Subjects </p>
	<table border="1">
		<th>Subject Name</th>
		<c:forEach var="subject" items="${subjectList}">
			<tr>
				<td>     ${subject.subjectName}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>