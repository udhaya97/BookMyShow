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



.ali
{

top:30px;
right:10px;
left:1500px;
padding:16px;
position:absolute;

}


table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

td, th,tr {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
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
<h3><b>Update Theatre</b></h3>
<form:form action ="/editthea/${theatrow.tId}" method ="get" modelAttribute="editTheatre">
<table>
<tr><td>Theatre Id</td><td>Theatre Name</td><td>timings</td><td>Movie Id And Name</td><td>Update</td></tr>


<tr><td>${theatrow.tId}</td><td><form:input path="tName" value="${theatrow.tName}"/></td><td><form:input path="timings" value="${theatrow.timings}"/>
<td>
<select name="midname" >
<option>Select Id and Movie</option>
 
<c:forEach items="${mapval}" var ="mval">
<option>${mval.key}
,${mval.value}</option>
</c:forEach>



<%-- 
<c:forEach var="entry" items="${map}">
   key is ${entry.key}
   <c:forEach var="info" items="${entry.value}">
        info is ${info}
   </c:forEach>
</c:forEach> --%>






</select></td>
<td><input type="submit" value="update"></td></tr>



</table><br/>
</form:form></div>
<div class="ali">
<a href="/edittheat" class="btn btn-info">Go back to list theatre</a></div>
</body>
</html>