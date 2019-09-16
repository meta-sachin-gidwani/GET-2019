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
<title>Pass Detail</title>
<script src="js/script.js"></script>
</head>
<body align="center">
<form:form align="center" modelAttribute="pass" onsubmit="return currencySelectionValidation()">
        <h1>Select Plan</h1>
        <form:input id="empId" path="empId" type="hidden" value="${empId}"/>
         <input id="vehicleType" type="hidden" value="${vehicleType}"/>
        <table id="priceTable" border="1px" align="center">
            <tr>
                <th>Plan</th>
                <th>Prices</th>
            </tr>
            <tr>
                <td>Daily</td>
                <td></td>
            </tr>
            <tr>
                <td>Monthly</td>
                <td></td>
            </tr>
            <tr>
                <td>Yearly</td>
                <td></td>
            </tr>
        </table><br><br>

        <select id="typeOfCurrency" name="typeOfCurrency" onchange="changeCurrency()">
            <option value="" disabled selected>--Select-Type--</option>
            <option value="INR">INR</option>
            <option value="USD">USD</option>
            <option value="YEN">YEN</option>
        </select><br><br>
        <label><form:radiobutton path="planType" value="Daily" required="true"/>Daily</label>
        <label><form:radiobutton path="planType" value="Monthly"/>Monthly</label>
        <label><form:radiobutton path="planType" value="Yearly"/>Yearly</label><br><br>
         <form:input type="hidden"  path="price" id="price" />
        <input type="submit" id="getPassButton" value="Get Pass">
        </form:form>
</body>
</html>