<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<style>
input {
	border: none;
}
</style>
</head>
<body>
	<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			<th>Employee Id</th>
			<th>Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="listValue" items="${friendList}">
			<tr>
				<form action="/friendProfile">
					<td><input name="email" value="${listValue.email}" size="60%" readonly></td>
					<td><input name="fullName" value='${listValue.fullName}' readonly></td>
					<td><input type="submit" value="View Profile"></td>
				</form>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
