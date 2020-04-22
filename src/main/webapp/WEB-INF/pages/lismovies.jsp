<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style type="text/css">
/* table {
  border-collapse: collapse;
}
td,td, th {
  border: 1px solid black;
}
th, td {
  padding: 15px;
  text-align: left;
} */




div.relative {
  position: relative;
  left: 80px;
  top:100px;
 background-image:url("log.jpg");

}
table {
    border-collapse: collapse;
    
  } 
  th, td {
    border: 1px solid #ccc;
    padding: 10px;
    text-align: left;
  }
  tr:nth-child(even) {
    background-color: #eee;
  }
  tr:nth-child(odd) {
    background-color: #fff;
  }      
     
  
  th, td {
  padding: 15px;
  text-align: left;
}


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
<body>
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
      <c:if test="${role eq 'Admin'}">
 <li class="active"><a href="/admin">Home</a></li>
</c:if>


       
        
        <c:if test="${role eq 'user'}">
 <li class="active"><a href="/user">Home</a></li>
</c:if>
        <li><a href="#">About</a></li>
        
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/createuser"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div align="center">
<h3> Select Movie</h3>

<form:form action="/hello" method="get" modelAttribute="lismovies">


<table background="log.jpg">

<tr><th>mId</th><th>mName</th><th>lang</th><th>duration</th><th>Select Theatre</tr>
<c:forEach items="${mvalues}" var="movi">
<tr><td>${movi.mId}</td><td>${movi.mName}</td><td>${movi.lang}</td><td>${movi.duration}</td><td><button type="button" class="btn btn-success"><a href="/listthetare/${movi.mId}" style="color:white">Click here</a></button></td></tr>

</c:forEach>


</table></form:form>
<br>

<a href="/listplace" class= "btn btn-info">Back to Place</a>

</div>
</body>
</html>