<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Vehicle</title>
<script src="allFunctionJs.js">	
</script>
</head>
<body align="center">

	<form action="AddVehicleServlet" method="post" onsubmit="return vehicleSelectionValidation(this)">
		<h1>Add Your Vehicle</h1>
		<table align="center" style="text-align: left" cellpadding="10">
			<tr>
				<td><label>Vehicle Name</label></td>
				<td><input name="vehicle_name" type="text" placeholder="Vehicle Name"
					size="60%" pattern="[A-Z a-z]*" required></td>
			</tr>
			<tr>
				<td><label>Vehicle Type</label></td>
				<td><select name="typeOfVehicle">
						<option disabled selected>--Select-Type--</option>
						<option value="Cycle">Cycle</option>
						<option value="MotorCycle">MotorCycle</option>
						<option value="Four Wheelers">Four Wheelers</option>
				</select></td>
			</tr>
			<tr>
				<td><label>Vehicle Number</label></td>
				<td><input name="vehicleNumber" type="text"
					placeholder="Vehicle Number" size="60%" required ></td>
			</tr>
			<tr>
				<td><label>Employee ID</label></td>
				<td><input name="empl_Id" type="text" size="60%"
					value="<%=session.getAttribute("emp_id")%>" readonly ></td>
			</tr>
			<tr>
				<td><label>Identification</label></td>
				<td><textarea name="vehicleIdentification"
						placeholder="Identification" cols="60"></textarea></td>
			</tr>
		</table>
		<input name="addVehicleButton" type="submit" value="Add">
	</form>
</body>
</html>