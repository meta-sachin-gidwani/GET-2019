<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
	<input type="image" src="${emp.image}" alt="no image" height="60">
	<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			<td>Name</td>
			<td><input id="fullName" name="fullName" value="${emp.fullName}"
				readonly /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><input id="gender" name="gender" value="${emp.gender}"
				readonly /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input id="email" name="email" value="${emp.email}" readonly /></td>
		</tr>
		<tr>
			<td>Contact Number</td>
			<td><input id="contact" name="contact" value="${emp.contact}"
				readonly /></td>
		</tr>
		<tr>
			<td>Organization</td>
			<td><input id="organization" name="organization"
				value="${emp.organization}" readonly /></td>
		</tr>
		<tr>
			<td>Vehicle Name</td>
			<td><input id="vehicleName" name="vehicleName"
				value="${emp.vehicleName}" readonly /></td>
		</tr>
		<tr>
			<td>Vehicle Type</td>
			<td><input id="vehicleType" name="vehicleType"
				value="${emp.vehicleType}" readonly /></td>
		</tr>
		<tr>
			<td>Vehicle Number</td>
			<td><input id="vehicleNumber" name="vehicleNumber"
				value="${emp.vehicleNumber}" readonly="true"></td>
		</tr>
		<tr>
			<td>Vehicle Identification</td>
			<td><input id="identification" name="identification"
				value="${emp.identification}" readonly /></td>
		</tr>
		<tr>
			<td>Plan Type</td>
			<td><input id="planType" name="planType" value="${emp.planType}"
				readonly /></td>
		</tr>
		<tr>
			<td>Pass Price</td>
			<td><input id="price" name="price" value="${emp.price} USD"
				readonly /></td>
		</tr>
	</table>
</body>
</html>