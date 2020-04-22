<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
div.relative {
  position: relative;
  left: 50px;
  top:190px;

}

.all{

width:100%;
height:100%;
}

.th,tr,td
{

color:"yellow";
}
h3{
color:green;}
.errors{
color:red;}

.navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  
  
</style>
</head>

<body >
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
     
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/user">Home</a></li>
        <li><a href="#">About</a></li>
        
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/createuser"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="all">
<div align ="center">

<div class="relative">
<h3>Add Bank</h3>
<form:form action="/banksave" method="post" modelAttribute="bsave">

<table>
<tr><td>
Bank Name: </td><td><form:input path="bName"/></td></tr>
<tr><td></td><td><form:errors path="bName" cssClass="errors"/></td></tr>
<tr> <td>Branch:</td><td><form:input path="branch"/></td></tr>
<tr><td></td><td><form:errors path="branch" cssClass="errors"/></td></tr>
<tr>	<td>AccNo:</td><td><form:input path="accId"/></td></tr>
<tr><td></td><td><form:errors path="accId" cssClass="errors"/></td></tr>
<tr><td>	 accType:</td><td><form:input path="accType"/></td></tr>
<tr><td></td><td><form:errors path="accType" cssClass="errors"/></td></tr>
<tr><td>	 balance:</td><td><form:input path="balance"/></td></tr>
<tr><td></td><td><form:errors path="balance" cssClass="errors"/></td></tr>

<tr><td></td><td><input type="submit" value="savebank"></td></tr>

</table>


</form:form></div></div></div>
</body>

</html>