<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Registration</title>
<script src="/js/bootstrap-4.3.1-dist/js"></script>
</head>
<body>
	<div class="container">
		<h1 align="center">${welcomeMessage}Hello</h1>
		<div class="card">
			<div class="card-header">
				<h3>Add Details</h3>
			</div>
			<div class="card-body">
				<form:form modelAttribute="employeeForm">
					<form:errors cssClass="text-danger" />
					<div class="form-group">
						<form:label path="fullName">Full Name</form:label>
						<form:input path="fullName" cssClass="form-control"
							placeholder="Full Name" />
						<form:errors path="fullName" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="gender">Gender</form:label>
						<label><form:radiobutton path="gender" value="M" />Male</label> <label><form:radiobutton
								path="gender" value="F" />Female</label></br>
						<form:errors path="gender" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="email">Email address</form:label>
						<form:input path="email" type="email" cssClass="form-control"
							placeholder="Enter email" />
						<form:errors path="email" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="password">Password</form:label>
						<form:input path="password" type="Password"
							cssClass="form-control" placeholder="Password" />
						<form:errors path="password" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="confirmPassword">Confirm Password</form:label>
						<form:input path="confirmPassword" type="Password"
							cssClass="form-control" placeholder="Confirm Password" />
						<form:errors path="confirmPassword" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<form:label path="contact">Contact Number</form:label>
						<form:input path="contact" cssClass="form-control"
							placeholder="Contact Number" />
						<form:errors path="contact" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<form:select path="organization">
							<option value="" disabled="disabled" selected>Select
								Organization</option>
							<form:option value="Metacube">Metacube</form:option>
							<form:option value="TCS">TCS</form:option>
							<form:option value="INFOSYS">INFOSYS</form:option>
							<form:option value="WIPRO">WIPRO</form:option>
						</form:select>
						</br>
						<form:errors path="organization" cssClass="text-danger" />
					</div>
					<button type="submit" class="btn btn-primary">Register</button>
				</form:form>
			</div>
		</div>
	</div>
	<h3 align="center">
		Already a member ? <a href="/loginPage">LogIn</a>
	</h3>
</body>
</html>