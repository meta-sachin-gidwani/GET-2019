<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Search Student</title>
</head>
<body>
	<div class="card">
		<div align="center" class="card-header">
			<h3>Search Student</h3>
		</div>
		<div class="card-body">
			<div class="container">
				<form:form modelAttribute="std">
					<form:errors cssClass="text-danger" />
					<div class="form-group">
						<form:label path="std">Class</form:label>
						<form:input path="std" type="number" cssClass="form-control"
							placeholder="Class" />
						<form:errors path="std" cssClass="text-danger" />
					</div>
					<button type="submit" class="btn btn-primary">Search</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>