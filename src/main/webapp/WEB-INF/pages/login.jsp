<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>
<style>
* {
  box-sizing: border-box;
}
.container {
  position: absolute;
  top : 200px;
  right: 350px;
  left:800px;
  margin: 20px;
  max-width: 300px;
  max-height:600px;
  padding: 16px;
  background-color: white;
}


body{

background-image:url("logh.png");
}

h2
{
color:green;
}
h1
{
color:red;}



 .error {color:red;}  
 
 
</style>
</head>
<body >
<div align="center"><h1>..........Welcome to Book My Show :) ...........</h1></div>



<div class="container">
<h2>Login</h2>

<form:form action="/verify"  modelAttribute="login">
<table>
<tr><td>UserName</td><td><form:input path="usName" name="uName" placeholder="username"/></td></tr>
<tr><td></td><td><form:errors path="usName" cssClass="error"/></td><td><font color="red">${username}</font></td></tr>
<tr></tr>
<tr></tr>
<tr><td>Password</td><td><form:input path="passwrd" name="pass" type="password" placeholder="password"/></td></tr>
<tr><td></td><td><form:errors path="passwrd" cssClass="error"/></td><td><font color="red">${password}</font></td></tr>

<tr></tr>
<tr><td></td><td><input type ="submit"></td></tr>

</table>


</form:form>
</div>

</body>
</html>