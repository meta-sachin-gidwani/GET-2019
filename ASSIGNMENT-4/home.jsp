<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
</head>
<body>
	<div align="right">
		<form action="LogOutServlet" method="post">
			<input type="submit" name="log_out" value="Log Out">
		</form>
	</div>
	<div align="center">
		<form action="UserDetailServlet" method="post">
			<input name="emp_id" type="hidden"
				value="<%=request.getAttribute("emp_id")%>">
			 <input
				id="userDetail" type="submit" name="userDetail"
				value="Show User Profile">
		</form>
		<form action="FriendsListServlet" method="post">
			<input name="emp_id" type="hidden"
				value="<%=request.getAttribute("emp_id")%>"> <input
				id="friends" type="submit" name="friends" value="Friends">
		</form>
	</div>
</body>
</html>