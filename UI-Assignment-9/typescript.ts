var currentField: String;
let currentForm: number;
var label: HTMLElement;
var daily = 5, monthly = 100, yearly = 500;

/* Class representing employee */
class Employee {
    employeeName: string;
    employeeGender: string;
    employeeEmail: string;
    employeePassword: string;
    employeeMatchPassword: string;
    employeeContact: string;

    constructor() { };

    /* onclick of add employee
    shows name input */
    registerationForm(): void {

        document.body.style.backgroundColor = "#7FDBFF";
        document.getElementById("addEmp").style.display = "none";
        document.getElementById("u_Registration").style.display = "block";

        document.getElementById("label").style.display = "block";
        document.getElementById("empName").style.display = "block";

        currentField = "name";
        currentForm = 1;
        var image = document.getElementById("coverImg");
        image.style.display = "none";
    }

    employeeBlur(): boolean {
        if (currentForm == 2) {
            veh.vehicleBlur();
            return false;
        }
        var label = document.getElementById("labelText");

        switch (currentField) {
            case "name":
                this.employeeName = (<HTMLInputElement>document.getElementById("ename")).value;

                if (!(/^[A-z ]{2,}$/.test(this.employeeName))) {
                    document.getElementById("error").innerHTML = "Please Enter Valid Name";
                    return false;
                } else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Hi " + this.employeeName + " May I know your Gender?";
                document.getElementById("empName").style.display = "none";
                document.getElementById("empGender").style.display = "block";
                currentField = "gender";
                break;

            case "gender":
                if (!(<HTMLInputElement>document.getElementsByName("egender")[0]).checked &&
                    !(<HTMLInputElement>document.getElementsByName("egender")[1]).checked) {
                    document.getElementById("error").innerHTML = "Please select gender";
                    return false;
                } else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = " You must be having a email Id";
                document.getElementById("empGender").style.display = "none";
                document.getElementById("empEmail").style.display = "block";
                currentField = "email";
                break;

            case "email":
                this.employeeEmail = (<HTMLInputElement>document.getElementById("eemail")).value;
                if (!(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(this.employeeEmail))) {
                    document.getElementById("error").innerHTML = "Please Enter Valid Email Address";
                    return false;
                } else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Please choose a password";
                document.getElementById("empEmail").style.display = "none";
                document.getElementById("empPass").style.display = "block";
                document.getElementById("empCnfrmPass").style.display = "block";
                currentField = "password";
                break;

            case "password":
                this.employeePassword = (<HTMLInputElement>document.getElementById("epass")).value;
                this.employeePassword = (<HTMLInputElement>document.getElementById("epass")).value;
                var employeeMatchPassword = (<HTMLInputElement>document.getElementById("ecnfrmpass")).value;
                if (this.employeePassword != employeeMatchPassword) {
                    document.getElementById("error").innerHTML = "Password Doesn't Match";
                    return false;
                } else {
                    document.getElementById("error").innerHTML = " ";
                }
                label.innerHTML = "Please Enter your Contact Number  ...";
                document.getElementById("empPass").style.display = "none";
                document.getElementById("empCnfrmPass").style.display = "none";
                document.getElementById("empContact").style.display = "block";
                document.getElementById("next1").style.display = "block";
                currentField = "contact";
        }
    }
}
/* validating password against weak , moderate and strong */
function validatePassword() {

    var employeePassword = (<HTMLInputElement>document.getElementById("epass")).value;
    document.getElementById("epass").style.borderWidth = "thick";
    if (employeePassword.length < 8) {
        document.getElementById("epass").style.borderColor = "red";
        document.getElementById("error").innerHTML = "Password Should be of minimum 8 characters";
        return false;
    } else if (!(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/.test(employeePassword))) {
        document.getElementById("epass").style.borderColor = "orange";
        document.getElementById("error").innerHTML = "Password should contain Uppercase, Lowercase and Numeric";
        return false;
    } else {
        document.getElementById("epass").style.borderColor = "green";
        document.getElementById("error").innerHTML = " ";
        return true;
    }
}

/* class representing a vehicle */
class Vehicle {
    vehicleName: string;
    vehicleType: string;
    vehicleNumber: string;
    vehicleDescription: string;

    constructor() { };

    /*  shows first input of vehicle form */
    vehicleForm(): boolean {

        emp.employeeContact = (<HTMLInputElement>document.getElementById("ecnumber")).value;
        if (!(/^[0-9]{10}$/.test(emp.employeeContact))) {
            document.getElementById("error").innerHTML = "Please Enter Valid Contact Number";
            return false;
        } else {
            document.getElementById("error").innerHTML = " ";
        }

        document.getElementById("empContact").style.display = "none";
        document.getElementById("next1").style.display = "none";
        currentField = "vehName";
        currentForm = 2;
        document.body.style.backgroundColor = "#ffae68";
        let vehNameDiv: HTMLElement;
        vehNameDiv = document.getElementById("vehName");
        document.getElementById("u_Registration").style.display = "none";
        document.getElementById("v_Registration").style.display = "block";
        document.getElementById('labelText').innerHTML = "May I know the Name of your Vehicle";
        vehNameDiv.style.display = "block";
        document.getElementById("vname").focus();
        currentField = "vehName";
    }

    /* switch case for vehicle  form for switching input fields */
    vehicleBlur(): boolean {

        this.vehicleName = (<HTMLInputElement>document.getElementById("vname")).value;;
        switch (currentField) {
            case "vehName":
                if (this.vehicleName == "") {
                    document.getElementById("error").innerHTML = "This field is Required";
                    return;
                }
                document.getElementById("error").innerHTML = " ";
                document.getElementById("vehName").style.display = "none";
                document.getElementById('labelText').innerHTML = " Whats the type of " + this.vehicleName;
                document.getElementById("vehType").style.display = "block";
                currentField = "vehType";
                break;

            case "vehType":
                debugger;
                var vehicleType = (<HTMLInputElement>document.getElementById("vtype")).value;
                if (vehicleType == "") {
                    document.getElementById("error").innerHTML = "This field is Required";
                    return;
                }
                document.getElementById("error").innerHTML = "";
                document.getElementById("vehType").style.display = "none";
                document.getElementById('labelText').innerHTML = "Can you please Mention the number of " + this.vehicleName;
                document.getElementById("vehNumber").style.display = "block";
                currentField = "vehNumber";
                break;

            case "vehNumber":
                var vehNumber = (<HTMLInputElement>document.getElementById("vnumber")).value;
                if (!(/^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$/.test(vehNumber))) {
                    document.getElementById("error").innerHTML = "Vehicle Number should be of proper type.";
                    return;
                }
                if (vehNumber == "") {
                    document.getElementById("error").innerHTML = "This field is Required";
                    return;
                }
                document.getElementById("error").innerHTML = " ";
                document.getElementById("vehNumber").style.display = "none";
                document.getElementById('labelText').innerHTML = "Tell something about " + this.vehicleName;
                document.getElementById("vehDescription").style.display = "block";
                document.getElementById("next2").style.display = "block";
                currentField = "vehDescription";
        }
    }
}

/* class for Plans and pricing */
class Plan {
    constructor() { };

    currency: string;
    plan: HTMLInputElement;

    /* opens up the plan and pricing form */
    planForm(): void {

        document.getElementById("v_Registration").style.display = "none";
        document.getElementById("p_Registration").style.display = "block";

        document.body.style.backgroundColor = "#DDDDDD";
        document.getElementById("vehDescription").style.display = "none";
        document.getElementById("next2").style.display = "none";

        document.getElementById('labelText').innerHTML = "Choose Currency for your Plan";
        document.getElementById("currType").style.display = "block";

        currentField = "currency";
        currentForm = 3;
    }
    /* on submit of plan and pricing form */
    submitForm(): void {

        var moneypass = '';
        document.getElementById("p_Registration").style.display = "none";
        document.getElementsByName("passtype").forEach(function (item) { if ((<HTMLInputElement>item).checked) 
            { moneypass = (<HTMLInputElement>item).value } });
        if (moneypass == 'Daily') {
            moneypass = " USD " + (daily / 71.74).toFixed(2) + " on " + moneypass + " basis";
        }
        else if (moneypass == 'Monthly') {
            moneypass = "USD " + (monthly / 71.74).toFixed(2) + " on " + moneypass + " basis";
        }
        else if (moneypass == 'Yearly') {
            moneypass = "USD " + (yearly / 71.74).toFixed(2) + " on " + moneypass + " basis";
        }
        document.getElementById('labelText').innerHTML = "Thank you for registering " + (<HTMLInputElement>document.getElementById("ename")).value + " Kindly Pay:" + moneypass;
        document.getElementById("plans").style.display = "none";
        document.getElementById("submit").style.display = "none";
        document.getElementById("currency").style.display = "none";
    }
/* showing available plans according to vehicle selected */
 showPrice(): void {

    var curr = (<HTMLInputElement>document.getElementById("currency")).value;
    this.plan = <HTMLInputElement>document.getElementById("plans");

    this.plan.style.display = "block";
    var v = (<HTMLInputElement>document.getElementsByName("vehicleType")[0].children[0]).value;
    document.getElementById("submit").style.display = "block";

    if (v == "Motorcycle") {
        daily = 10;
        monthly = 200;
        yearly = 1000;
    } else if (v == "FourWheeler") {
        daily = 20;
        monthly = 500;
        yearly = 3500;
    }

    switch (curr) {
        case "INR":
            document.getElementById("daily").innerHTML = "" + daily;
            document.getElementById("monthly").innerHTML = "" + monthly;
            document.getElementById("yearly").innerHTML = "" + yearly;
            break;
        case "USD":
            document.getElementById("daily").innerHTML = (daily / 71.74).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 71.74).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 71.74).toFixed(2);
            break;
        case "YEN":
            document.getElementById("daily").innerHTML = (daily / 0.68).toFixed(2);
            document.getElementById("monthly").innerHTML = (monthly / 0.68).toFixed(2);
            document.getElementById("yearly").innerHTML = (yearly / 0.68).toFixed(2);

    }
}
}


var emp = new Employee();
var veh = new Vehicle();
var plan = new Plan();

/* event listener for enter key */
window.addEventListener('keypress', function (e) {
    if (e.keyCode == 13) {
        emp.employeeBlur();
    }
}, false);

/* redirects to emp registration form */
function registerEmployee() {
    emp.registerationForm();
}
/* redirects to vehicle form */
function registerVehicle() {
    veh.vehicleForm();
}

/* redirects to plan form */
function registerPlan() {
    plan.planForm();
}

/* redirects to submit form method*/
function formSubmition() {
    plan.submitForm();
}

/* redirects to show price method */
function showPriceDetails() {
    plan.showPrice();
}