<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Friend List</title>
</head>
<body align="center">
	<table align="center" cellpadding="10%" style="text-align: left"
		border="1px">
		<tr>
			<th>Employee Id</th>
			<th>Name</th>
		</tr>
		<%
			ResultSet resultSet = (ResultSet) request
					.getAttribute("friendList");
			while (resultSet.next()) {
		%>
		<tr>
			<form action="FriendDetailServlet" method="post">
			<td><input name="emp_id" type="text" size="1%"
				value="<%=resultSet.getInt(1)%>" readonly></td>
			<td><%=resultSet.getString(2)%></td>
			<td><input type="submit" value="View Profile"></td>
			</form>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>