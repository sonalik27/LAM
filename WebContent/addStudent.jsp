<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy - Add Student</title>
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
	
	<h3>Add New Student:</h3> <br/>

	<form action="addStudent" method="post">
		<table>
			<tr>
				<td>Student Name :</td>
				<td><input name="studentName" type="text"></td>
			</tr>
			<tr>
				<td>Date of Birth (MM/DD/YYYY) :</td>
				<td><input name="birthDate" type="text"></td>
			</tr>
			<tr>
				<td>Address Line1 :</td>
				<td><input name="addressLine1" type="text"></td>
			</tr>
			<tr>
				<td>Address Line2 :</td>
				<td><input name="addressLine2" type="text"></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><select name="selectCity">
						<c:forEach items="${cityList}" var="city">
							<option value="${city.cityId}">${city.cityName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>State :</td>
				<td><select name="selectState">
						<c:forEach items="${stateList}" var="state">
							<option value="${state.stateId}">${state.stateName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><select name="selectCountry">
						<c:forEach items="${countryList}" var="country">
							<option value="${country.countryId}">${country.countryName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Class Name :</td>
				<td><select name="selectClass">
						<option value="" selected></option>
						<c:forEach items="${classesList}" var="aclass">
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