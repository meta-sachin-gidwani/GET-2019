CREATE DATABASE PARKING_SYSTEM;
USE PARKING_SYSTEM;
CREATE TABLE EMPLOYEE(
    regi_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(40),
    gender VARCHAR(1),
    email VARCHAR(40) UNIQUE,
    password VARCHAR(20),
    contact_number VARCHAR(10),
    organization VARCHAR(40)
);
 
CREATE TABLE VEHICLE(
    employee_Id int(10) primary key,
    vehicle_name VARCHAR(40),
    type VARCHAR(20),
    vehicle_number VARCHAR(30),
    identification VARCHAR(100),
    FOREIGN KEY (employee_Id)
        REFERENCES Employee(REGI_ID)
);

CREATE TABLE PASS(
emp_id int primary key,
price varchar(30),
 FOREIGN KEY (emp_Id)
        REFERENCES Employee(regi_id)
);
