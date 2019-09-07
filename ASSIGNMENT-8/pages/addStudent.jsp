<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/js/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <title>Add Student</title>
  </head>
  <body>
  
  <div class="container">
  <form:form modelAttribute="student" action="/addStudentDone" method="post">
    <form:errors cssClass="text-danger"/>
  <div class="form-group">
    <form:label path="firstName">First Name</form:label>
    <form:input  path="firstName" cssClass="form-control" placeholder="First Name"/>
    <form:errors path="firstName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="lastName">Last Name</form:label>
    <form:input  path="lastName" cssClass="form-control" placeholder="Last Name"/>
    <form:errors path="lastName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="fatherName">Father Name</form:label>
    <form:input  path="fatherName" cssClass="form-control" placeholder="Father Name"/>
    <form:errors path="fatherName" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="email">Email address</form:label>
    <form:input path="email" type="email" cssClass="form-control"  placeholder="Enter email"/>
    <form:errors path="email" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="std">Class</form:label>
    <form:input path="std" type="number" cssClass="form-control" placeholder="Class"/>
    <form:errors path="std" cssClass="text-danger" />
  </div>
  <div class="form-group">
    <form:label path="age">Age</form:label>
    <form:input path="age" type="number" cssClass="form-control" placeholder="Age"/>
    <form:errors path="age" cssClass="text-danger" />
  </div>
  <button type="submit" class="btn btn-primary">Add Student</button>
	</form:form>
</div>
  </body>
</html>