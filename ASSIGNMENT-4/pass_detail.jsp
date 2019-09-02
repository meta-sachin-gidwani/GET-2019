<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pass Detail</title>
<script src="allFunctionJs.js">	
</script>
</head>
<body align="center">
<form name="passesPrice" action="PassDetailServlet" method="post" onsubmit="return currencySelectionValidation(this)">
        <h1>Select Plan</h1>
        <input name="emp_id" type="hidden" value="<%=request.getAttribute("emp_id")%>">
        <input id="selectedVehicle" name="selectedVehicle" type="hidden" value="<%=request.getAttribute("vehicleType")%>">
        <table id="priceTable" name="priceTable" border="1px" align="center">
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
            <option disabled selected>--Select-Type--</option>
            <option value="INR">INR</option>
            <option value="USD">USD</option>
            <option value="YEN">YEN</option>
        </select><br><br>
        <label><input type="radio" name="planType" value="Daily" required/>Daily</label>
        <label><input type="radio" name="planType" value="Monthly" />Monthly</label>
        <label><input type="radio" name="planType" value="Yearly" />Yearly</label><br><br>
         <input type="hidden"  name="final_price" id="final_price" >
        <input type="submit" id="getPassButton" value="Get Pass">
        </form>
</body>
</html>