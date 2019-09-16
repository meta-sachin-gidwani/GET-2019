<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/imageUpload/${emp.email}" var="emp_id"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<script type="text/javascript">
	function editDetail() {
		document.getElementById("fullName").readOnly = false;
		document.getElementById("contact").readOnly = false;
		document.getElementById("gender").readOnly = false;
		document.getElementById("vehicleName").readOnly = false;
		document.getElementById("vehicleNumber").readOnly = false;
		document.getElementById("identification").readOnly = false;
		document.getElementById("saveButton").disabled = false;
		document.getElementById("editButton").disabled = true;
	}
</script>
<style type="text/css">
input {
	border: none;
}
</style>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
</head>
<body align="center">
	<div align="right">
		<form action="/logout">
			<input type="submit" id="logoutButton" name="logoutButton"
				value="Log Out" class="btn btn-primary" />
		</form>
		<form action="/friendList">
			<input name="email" type="hidden" value="${emp.email}" /> <input
				name="organization" type="hidden" value="${emp.organization}" /> <input
				type="submit" id="friendsButton" name="friendsButton"
				value="Friends" class="btn btn-primary">
		</form>
	</div>
	<div align="left">
		<input name="emp_id" type="hidden" value="${emp.email}" />
			<span style="font-weight: bold; font-size: 30px;">Welcome</span> <input
				id="pic" type="image" src="${emp.image}" alt="no image" height="60" onclick="window.location.href='/imageChange'"/>
			<span style="font-weight: bold; font-size: 30px;">${emp.fullName}</span>
	</div>
	<form align="center" action="/update">
		<table align="center" cellpadding="10%" style="text-align: left"
			border="1px">
			<tr>
				<td>Name</td>
				<td><input id="fullName" name="fullName"
					value="${emp.fullName}" pattern="[A-Z a-z]{2,30}"
					title="name should only have alphabates and length between{2,30}"
					readonly required /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input id="gender" name="gender" pattern="^F$|^M$"
					title="Male= M Female=F" value="${emp.gender}" readonly required /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input id="email" name="email" value="${emp.email}"
					readonly /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><input id="contact" name="contact" value="${emp.contact}"
					pattern="([0-9]){10}" readonly required /></td>
			</tr>
			<tr>
				<td>Organization</td>
				<td><input id="organization" name="organization"
					value="${emp.organization}" readonly /></td>
			</tr>
			<tr>
				<td>Vehicle Name</td>
				<td><input id="vehicleName" name="vehicleName"
					value="${emp.vehicleName}" pattern=".{2,10}" readonly required /></td>
			</tr>
			<tr>
				<td>Vehicle Type</td>
				<td><input id="vehicleType" name="vehicleType"
					value="${emp.vehicleType}" readonly /></td>
			</tr>
			<tr>
				<td>Vehicle Number</td>
				<td><input id="vehicleNumber" name="vehicleNumber"
					value="${emp.vehicleNumber}" pattern=".{4,10}" readonly="true"
					required></td>
			</tr>
			<tr>
				<td>Vehicle Identification</td>
				<td><input id="identification" name="identification"
					value="${emp.identification}" readonly /></td>
			</tr>
			<tr>
				<td>Plan Type</td>
				<td><input id="planType" name="planType"
					value="${emp.planType}" readonly /></td>
			</tr>
			<tr>
				<td>Pass Price</td>
				<td><input id="price" name="price" value="${emp.price} USD"
					readonly /></td>
			</tr>
		</table>
		</br> <input type="button" id="editButton" name="editButton" value="Edit"
			onclick="editDetail()" class="btn btn-primary"> <input
			type="submit" id="saveButton" name="saveButton" value="Save"
			class="btn btn-primary" disabled="true">
	</form>
</body>
</html>