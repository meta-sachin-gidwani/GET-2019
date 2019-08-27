function registerEmp() {
    var name = document.getElementById("empName").value;
    var validName = /[A-z a-z]+$/;
    var minLength = 2;
    if ((name.length < minLength) || !(name.match(validName))) {
        alert(" Name length min 2 and should not be numeric");
        return false;
    }

    var email = document.getElementById("empEmail").value;
    var positionOfAt = email.indexOf("@");
    var positionOfDot = email.lastIndexOf(".");
    if (positionOfAt < 1 || positionOfDot <= (positionOfAt + 1) || (positionOfDot + 2) >= email.length) {
        alert("not a valid email");
        return false;
    }

    var number = document.getElementById("empNumber").value;
    if (isNaN(number) || number.length < 9) {
        alert("not a valid contact number");
        return false;
    }

    var password = document.getElementById("empPassword").value;
    var confirmPassword = document.getElementById("empConfirmPassword").value;
    var validPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
    if (!(password.match(validPassword))) {
        alert("Password should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8")
    } else if (password != confirmPassword) {
        alert("password does not match");
        return false;
    }

    var empId = "E19/1220";
    document.getElementById("empl_Id").value = empId;
    document.getElementById("empRegistrationForm").innerHTML = "Congratulation ! You have Successfully Registered.Your Registration Id is" + empId;
}

function addVehicle(vehicleType) {
    document.getElementById("typeOfVehicleLabel").value = vehicleType;
    var table = document.getElementById("priceTable");
    switch (vehicleType) {
        case "Cycle":
            table.rows[1].cells[1].innerHTML = 5;
            table.rows[2].cells[1].innerHTML = 100;
            table.rows[3].cells[1].innerHTML = 500;
            break;
        case "MotorCycle":
            table.rows[1].cells[1].innerHTML = 40;
            table.rows[2].cells[1].innerHTML = 200;
            table.rows[3].cells[1].innerHTML = 1000;
            break;
        case "Four Wheelers":
            table.rows[1].cells[1].innerHTML = 20;
            table.rows[2].cells[1].innerHTML = 500;
            table.rows[3].cells[1].innerHTML = 3500;
            break;
    }
    document.getElementById("addVehicleForm").innerHTML = "Vehicle successfully Add";
}

function changeCurrency() {
    var table = document.getElementById("priceTable");
    switch (document.getElementById("typeOfVehicleLabel").value) {
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
        return 0.014 * INRPrice;
    } else if (currencyType == "YEN") {
        return 1.47 * INRPrice;
    } else {
        return INRPrice;
    }
}

function getPass() {
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
            document.getElementById("passesPrice").innerHTML = "Your plan price is " + table.rows[1].cells[1].innerHTML + " " + document.getElementById("typeOfCurrency").value;
            break;
        case "Monthly":
            document.getElementById("passesPrice").innerHTML = "Your plan price is " + table.rows[2].cells[1].innerHTML + " " + document.getElementById("typeOfCurrency").value;
            break;
        case "Yearly":
            document.getElementById("passesPrice").innerHTML = "Your plan price is " + table.rows[3].cells[1].innerHTML + " " + document.getElementById("typeOfCurrency").value;
            break;
    }
}