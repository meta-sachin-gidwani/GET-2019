<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Log In</title>
</head>
<body>
	<h1 align="center">${welcomeMessage}</h1>
	<div class="container">
	<h5 class="text-danger">${msg}</h5>
	<h5 class="text-danger">${message}</h5>
		<form:form modelAttribute="employeeForm">
			<form:errors cssClass="text-danger" />
			<div class="form-group">
				<form:label path="email">Email address</form:label>
				<form:input path="email" type="email" cssClass="form-control"
					placeholder="Enter email" />
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" type="Password" cssClass="form-control"
					placeholder="Password" />
			</div>
			<button type="submit" class="btn btn-primary">LogIn</button>
		</form:form>
	</div>
	<h3 align="center">
		New here ? <a href="/registrationPage">Register</a>
	</h3>
</body>
</html>