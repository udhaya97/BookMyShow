<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>


<style type="text/css">
body, html {
  height: 100%;
  width:100%;
  font-family: Arial, Helvetica, sans-serif;
  font-color:yellow;
}

body
{
background-image:url("log.jpg");
top right no-repeat; background-attachment:fixed;


}
* {
  box-sizing: border-box;
}
.container {
  position: absolute;
  top : 200px;
  right: 700px;
  margin: 20px;
  max-width: 1000px;
  padding: 16px;
  background-color: white;
}

}
td,th,tr,div{


color:yellow;
}
h1{
color:white;
}


        .error {color:red;}  
   </style>  
</head>

<body >


<div align="center">
<h1>..........Welcome to Book My Show :) ...........</h1><br>
</div>
<div class="container">
<div align="center">
<h3>Create Admin</h3>
</div>
<form:form action="/adtwo"  modelAttribute="Admin">

<table>
<tr><td>User Name</td><td><form:input path="uName"/></td></tr>
<tr><td></td><td><form:errors path="uName" cssClass="error"/></td></tr>

<tr><td>Password:</td><td><form:input path="pass" type="password"/></td></tr>
<tr><td></td><td><form:errors path="pass" cssClass="error"/></td></tr>

<tr><td>Dob:</td><td><form:input path="dob" type="date"/></td></tr>
<tr><td></td><td><form:errors path="dob" cssClass="error"/></td></tr>

<tr><td>Email:</td><td><form:input path="mailId" type="email"/></td></tr>

<tr><td></td><td><form:errors path="mailId" cssClass="error"/></td></tr>
<tr><td>Mobile Number:</td><td><form:input path="mobileNo"/></td></tr>
<tr><td></td><td><form:errors path="mobileNo" cssClass="error"/></td></tr>

<tr><td>Role:</td><td><form:input path="role" value="Admin" readonly="true"/></td></tr>
<tr></tr>
<tr><td></td><td><input type="submit"></td></tr>

<tr></tr><tr></tr>
<tr><td>Already User?just</td><td><font color="orange"><a href ="/logi">Login Here</a></font>



</table>




</form:form>

</div>

</body>
</html>

