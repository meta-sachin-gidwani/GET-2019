<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Profile</title>
</head>
<body align="center">
	<table align="center" cellpadding = "10%" style="text-align:left" border="1px">
		<tr>
			<td>Employee Id</td>
			<td><%=request.getAttribute("emp_id")%></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><%=request.getAttribute("emp_name")%></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><%=request.getAttribute("gender")%></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=request.getAttribute("email")%></td>
		</tr>
		<tr>
			<td>Contact Number</td>
			<td><%=request.getAttribute("contact_number")%></td>
		</tr>
		<tr>
			<td>Organization</td>
			<td><%=request.getAttribute("organization")%></td>
		</tr>
		<tr>
			<td>Vehicle Name</td>
			<td><%=request.getAttribute("vehicle_name")%></td>
		</tr>
		<tr>
			<td>Vehicle Type</td>
			<td><%=request.getAttribute("vehicle_type")%></td>
		</tr>
		<tr>
			<td>Vehicle Number</td>
			<td><%=request.getAttribute("vehicle_number")%></td>
		</tr>
		<tr>
			<td>Vehicle Identification</td>
			<td><%=request.getAttribute("identification")%></td>
		</tr>
		<tr>
			<td>Pass Price</td>
			<td><%=request.getAttribute("price")%></td>
		</tr>
	</table>

</body>
</html>