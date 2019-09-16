
function currencySelectionValidation() {
	var selectedCurrencyType = document.getElementById("typeOfCurrency").value;
	if (selectedCurrencyType == ""){
		alert("please select Currency type");
		return false;
	}
	var plans = document.getElementsByName("planType");
    var checkedPlan;
    for (i = 0; i < plans.length; i++) {
        if (plans[i].checked) {
            checkedPlan = plans[i].value;
        }
    }
    var table = document.getElementById("priceTable");
    switch (checkedPlan) {
        case "Daily":
            document.getElementById("price").value = convertInUSD(table.rows[1].cells[1].innerHTML);
            break;
        case "Monthly":
            document.getElementById("price").value = convertInUSD(table.rows[2].cells[1].innerHTML);
            break;
        case "Yearly":
            document.getElementById("price").value = convertInUSD(table.rows[3].cells[1].innerHTML);
            break;
    }
    alert(document.getElementById("price").value +" "+selectedCurrencyType);
	return true;
}

function changeCurrency() {
		var table = document.getElementById("priceTable");
	    switch (document.getElementById("vehicleType").value) {
	        case "Cycle":
	            table.rows[1].cells[1].innerHTML = convertCurrency(5);
	            table.rows[2].cells[1].innerHTML = convertCurrency(100);
	            table.rows[3].cells[1].innerHTML = convertCurrency(500);
	            break;
	        case "MotorCycle":
	            table.rows[1].cells[1].innerHTML = convertCurrency(10);
	            table.rows[2].cells[1].innerHTML = convertCurrency(200);
	            table.rows[3].cells[1].innerHTML = convertCurrency(1000);
	            break;
	        case "Four Wheelers":
	            table.rows[1].cells[1].innerHTML = convertCurrency(20);
	            table.rows[2].cells[1].innerHTML = convertCurrency(500);
	            table.rows[3].cells[1].innerHTML = convertCurrency(3500);
	            break;
	    }
	}  

function convertCurrency(INRPrice) { 
    var currencyType = document.getElementById("typeOfCurrency").value;
    if (currencyType == "USD") {
        return (0.014 * INRPrice).toFixed(2);
    } else if (currencyType == "YEN") {
        return (1.47 * INRPrice).toFixed(2);
    } else {
        return INRPrice;
    }
}

function convertInUSD(amount){
	var currencyType = document.getElementById("typeOfCurrency").value;
	 if (currencyType == "INR") {
	        return (0.014 * amount).toFixed(2);
	    } else if (currencyType == "YEN") {
	        return (0.0093 * amount).toFixed(2);
	    } else {
	        return amount;
	    }
}