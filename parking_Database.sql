DROP DATABASE PARKING_Database;
CREATE DATABASE PARKING_Database;
USE PARKING_Database;
CREATE TABLE EMPLOYEE(
    email VARCHAR(40) PRIMARY KEY,
    name VARCHAR(40),
    gender VARCHAR(1),
    password VARCHAR(20),
    contact_number VARCHAR(10),
    organization VARCHAR(40)
);
 
CREATE TABLE VEHICLE(
    employee_Id VARCHAR(40) PRIMARY KEY,
    vehicle_name VARCHAR(40),
    type VARCHAR(20),
    vehicle_number VARCHAR(30),
    identification VARCHAR(100),
    FOREIGN KEY (employee_Id)
        REFERENCES Employee (email)
);

CREATE TABLE PASS(
    emp_id VARCHAR(40) PRIMARY KEY,
    planType VARCHAR(20),
    price VARCHAR(30),
    FOREIGN KEY (emp_id)
        REFERENCES Employee (email)
);

CREATE TABLE IMAGE(
    empId VARCHAR(40) PRIMARY KEY,
    imageSrc VARCHAR(80),
    FOREIGN KEY (empId)
        REFERENCES Employee (email)
);
SELECT 
    *
FROM
    employee;