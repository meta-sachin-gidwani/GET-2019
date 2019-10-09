function validName(name) {
    var validName = /[A-z a-z]+$/;
    var minLength = 2;
    if ((name.length < minLength) || !(name.match(validName))) {
        alert(" Name length min 2 and should not be numeric");
        return false;
    }
    return true;
}

function validEmail(email) {
    var positionOfAt = email.indexOf("@");
    var positionOfDot = email.lastIndexOf(".");
    if (positionOfAt < 1 || positionOfDot <= (positionOfAt + 1) || (positionOfDot + 2) >= email.length) {
        alert("not a valid email");
        return false;
    }
    return true;
}

function validPassword(password) {
    document.getElementById("password").style.borderColor = "red";
    var validPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
    if (password.length >= 8) {
        document.getElementById("password").style.borderColor = "yellow";
        if (password.match(validPassword)) {
            document.getElementById("password").style.borderColor = "green";
        }
    }
}

function validConfirmPassword(password, confirm_password) {
    if (password.style.borderColor != "green") {
        alert("password is not valid");
        return false;
    } else if (password.value != confirm_password) {
        alert("password does not match");
        return false;
    }
    return true;
}

function validContact(contact) {
    if (isNaN(contact) || contact.length != 10) {
        alert("not a valid contact number");
        return false;
    }
    return true;
}

var employee = {};
var input;
input = document.getElementById("full_name");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13 && validName(document.getElementById("full_name").value)) {
        document.getElementById("gender-div").style.display = "block";
        document.getElementById("welcome-heading").innerHTML = "Welcome " + document.getElementById("full_name").value;
        document.getElementById("label").innerHTML = "Please select your gender"
        document.getElementById("full_name").style.display = "none";
        employee.name = document.getElementById("full_name");
    }
});


input = document.getElementById("male");
input.addEventListener("click", function(event) {
    document.getElementById("email").style.display = "block";
    document.getElementById("email").focus();
    document.getElementById("welcome-heading").style.display = "none";
    document.getElementById("label").innerHTML = "Please enter your email"
    document.getElementById("gender-div").style.display = "none";
    employee.gender = document.getElementById("male").value;
});

input = document.getElementById("female");
input.addEventListener("click", function(event) {
    document.getElementById("email").style.display = "block";
    document.getElementById("email").focus();
    document.getElementById("welcome-heading").style.display = "none";
    document.getElementById("label").innerHTML = "Please enter your email"
    document.getElementById("gender-div").style.display = "none";
    employee.gender = document.getElementById("female").value;
});

input = document.getElementById("email");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13 && validEmail(document.getElementById("email").value)) {
        document.getElementById("password").style.display = "block";
        document.getElementById("password").focus();
        document.getElementById("confirm_password").style.display = "block";
        document.getElementById("label").innerHTML = "Please enter your password"
        document.getElementById("email").style.display = "none";
        employee.email = document.getElementById("email").value;
    }
});

input = document.getElementById("password");
input.addEventListener("keyup", function(event) {
    validPassword(document.getElementById("password").value);
});

input = document.getElementById("confirm_password");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13 && validConfirmPassword(document.getElementById("password"), document.getElementById("confirm_password").value)) {
        document.getElementById("contact").style.display = "block";
        document.getElementById("contact").focus();
        document.getElementById("label").innerHTML = "Please enter your contact number"
        document.getElementById("password").style.display = "none";
        document.getElementById("confirm_password").style.display = "none";
        employee.password = document.getElementById("password").value;
    }
});

input = document.getElementById("contact");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13 && validContact(document.getElementById("contact").value)) {
        document.getElementById("organization").style.display = "block";
        document.getElementById("organization").focus();
        document.getElementById("submit-organization").style.display = "block";
        document.getElementById("label").innerHTML = "Please select your organization"
        document.getElementById("contact").style.display = "none";
        employee.contact = document.getElementById("contact").value;
    }
});

for (i = 6; i < 10; i++) {
    document.getElementsByClassName("form-control")[i].style.backgroundColor = "#C7EA46";
    document.getElementsByClassName("form-control")[i].style.borderColor = "green";
}

input = document.getElementById("submit-organization");
input.addEventListener("click", function(event) {
    if (document.getElementById("organization").value != "--Select Organization--") {
        document.getElementsByTagName("body")[0].style.backgroundColor = "#C7EA46";
        document.getElementById("welcome-heading").style.display = "block";
        document.getElementById("welcome-heading").innerHTML = "Congratulations you are successfully registered.<br> Your employee ID is " + 'E19/1220';
        document.getElementById("vehicle_name").style.display = "block";
        document.getElementById("vehicle_name").focus();
        document.getElementById("label").innerHTML = "Please enter your vehicle name"
        document.getElementById("organization").style.display = "none";
        document.getElementById("submit-organization").style.display = "none";
        employee.organization = document.getElementById("organization").value;
    } else {
        alert("selct an organization");
    }
});

input = document.getElementById("vehicle_name");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13 && document.getElementById("vehicle_name").value.length > 2) {
        document.getElementById("welcome-heading").style.display = "none";
        document.getElementById("typeOfVehicle").style.display = "block";
        document.getElementById("typeOfVehicle").focus();
        document.getElementById("submit-vehicleType").style.display = "block";
        document.getElementById("label").innerHTML = "Please let us know the type of " + document.getElementById("vehicle_name").value;
        document.getElementById("vehicle_name").style.display = "none";
        employee.vehicleName = document.getElementById("vehicle_name").value;
    }
});

input = document.getElementById("submit-vehicleType");
input.addEventListener("click", function(event) {
    if (document.getElementById("typeOfVehicle").value != "--Select-Type--") {
        document.getElementById("welcome-heading").style.display = "none";
        document.getElementById("vehicleNumber").style.display = "block";
        document.getElementById("vehicleNumber").focus();
        document.getElementById("label").innerHTML = "Please enter your " + document.getElementById("typeOfVehicle").value + " number";
        document.getElementById("typeOfVehicle").style.display = "none";
        document.getElementById("submit-vehicleType").style.display = "none";
        employee.vehicleType = document.getElementById("typeOfVehicle").value;
    } else {
        alert("select a vehicle type");
    }
});

input = document.getElementById("vehicleNumber");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13 && document.getElementById("vehicleNumber").value.length > 8) {
        document.getElementById("vehicleIdentification").style.display = "block";
        document.getElementById("vehicleIdentification").focus();
        document.getElementById("label").innerHTML = "Please describe your " + document.getElementById("vehicle_name").value;
        document.getElementById("vehicleNumber").style.display = "none";
        employee.vehicleNumber = document.getElementById("vehicleNumber").value;
    }
});

input = document.getElementById("vehicleIdentification");
input.addEventListener("keyup", function(event) {
    if (event.keyCode === 13) {
        document.getElementsByTagName("body")[0].style.backgroundColor = "#5DB7E6";
        document.getElementById("welcome-heading").style.display = "block";
        document.getElementById("welcome-heading").innerHTML = "Vehicle successfully add";
        document.getElementById("pricingDiv").style.display = "block";
        for (i = 0; i < 3; i++) {
            document.getElementsByClassName("vehicleType")[i].innerHTML = document.getElementById("typeOfVehicle").value;
        }
        setPrice(document.getElementById("typeOfVehicle").value);
        document.getElementById("label").innerHTML = "Please select a plan";
        document.getElementById("vehicleIdentification").style.display = "none";
        employee.vehicleIdentification = document.getElementById("vehicleIdentification").value;
    }
});

var price = document.getElementsByTagName("strong");

function setPrice(vehicleType) {
    switch (vehicleType) {
        case "Cycle":
            price[0].innerHTML = "$5";
            price[1].innerHTML = "$100";
            price[2].innerHTML = "$500";
            break;
        case "MotorCycle":
            price[0].innerHTML = "$20";
            price[1].innerHTML = "$200";
            price[2].innerHTML = "$1000";
            break;
        case "Four Wheelers":
            price[0].innerHTML = "$40";
            price[1].innerHTML = "$500";
            price[2].innerHTML = "$3500";
            break;
    }
}

input = document.getElementById("btn1");
input.addEventListener("click", function(event) {
    document.getElementById("welcome-heading").style.display = "none";
    document.getElementById("label").innerHTML = "Your plan price is " + price[0].innerHTML;
    document.getElementById("pricingDiv").style.display = "none";
    employee.price = price[0].innerHTML;
    localStorage.setItem('employee', JSON.stringify(employee));
});

input = document.getElementById("btn2");
input.addEventListener("click", function(event) {
    document.getElementById("welcome-heading").style.display = "none";
    document.getElementById("label").innerHTML = "Your plan price is " + price[1].innerHTML;
    document.getElementById("pricingDiv").style.display = "none";
    employee.price = price[1].innerHTML;
    localStorage.setItem('employee', JSON.stringify(employee));
    console.log(JSON.parse(localStorage.getItem('employee')));
});

input = document.getElementById("btn3");
input.addEventListener("click", function(event) {
    document.getElementById("welcome-heading").style.display = "none";
    document.getElementById("label").innerHTML = "Your plan price is " + price[2].innerHTML;
    document.getElementById("pricingDiv").style.display = "none";
    employee.price = price[2].innerHTML;
    localStorage.setItem('employee', JSON.stringify(employee));
});