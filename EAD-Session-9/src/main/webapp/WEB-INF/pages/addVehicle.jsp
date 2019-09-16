<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
<title>Register Vehicle</title>
</head>
<body>
<h4 align="center">Congrats Your Registration Id is ${empId}</h4>
	<div class="container" style="margin-left: 20%">
		<div class="card">
			<div class="card-header">
				<h3>Add Vehicle</h3>
			</div>
			<div class="card-body">
				<form:form modelAttribute="vehicleForm">
					<form:errors cssClass="text-danger" />
					<div class="form-group">
						<form:label path="vehicleName">Vehicle Name</form:label>
						<form:input path="vehicleName" cssClass="form-control col-lg-6"
							placeholder="Enter vehicle name" />
						<form:errors path="vehicleName" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="vehicleNumber">Vehicle number</form:label>
						<form:input path="vehicleNumber" cssClass="form-control col-lg-6"
							placeholder="Enter vehicle number" />
						<form:errors path="vehicleNumber" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="vehicleType">Vehicle Type</form:label>
						<form:select path="vehicleType" cssClass="form-control col-lg-6">
							<option value="" disabled="true" selected="true">Select
								vehicle type</option>
							<form:option value="Cycle">Cycle</form:option>
							<form:option value="MotorCycle">MotorCycle</form:option>
							<form:option value="Four Wheeler">Four Wheeler</form:option>
						</form:select>
						<form:errors path="vehicleType" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<form:label path="empId">Employee Id</form:label>
						<form:input path="empId" value="${empId}"
							cssClass="form-control col-lg-6" readonly="true" />
					</div>
					<div class="form-group">
						<form:label path="identification">Identification</form:label>
						<form:input path="identification" cssClass="form-control col-lg-6"
							placeholder="Enter vehicle identification" />
					</div>
					<button type="submit" class="btn btn-primary">Add Vehicle</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>