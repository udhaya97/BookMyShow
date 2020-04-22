<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">

table {
width:700px;
table-layout:fixed;
}


rig
{

left:1500px;
top:20px;
position:absolute;
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



<form:form action="/getcode" method="get" modelAttribute="lismovies">

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
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>

<div align="center"><br/><h3>Select Seat</h3><br/>


<table border=1>

<c:if test="${values == 'process'}">
<tr>
<c:forEach items="${tabval}" var="sseat">

<td><input type="checkbox" name="seats" value="${sseat}">${sseat}</td>

<c:if test="${sseat%5==0}">
<tr></tr>
</c:if>

</c:forEach>






</c:if>

<c:if test="${values ne 'process'}">
<tr>

<c:forEach items="${tabval}" var="sseat">
<c:forEach items="${seatsval}" var="stseat">
<c:if test="${stseat eq sseat}">
<td><input type="checkbox"  checked="checked" name="seats"  disabled >${stseat}</td>
</c:if>
</c:forEach>
<c:forEach items="${lisrem}" var ="sec">
<c:if test="${sec eq sseat}">
<td><input type="checkbox" name="seats" value="${sseat}">${sseat}</td></c:if></c:forEach>

<c:if test="${sseat%5==0}">
<tr></tr>
</c:if>
</c:forEach>
<%-- <tr>
<c:if test="${values eq 'process'}">

<c:forEach items="${tabval}" var="sseat">

<td><input type="checkbox" name="seats" value="${sseat}">${sseat}</td>


</c:forEach>

</c:if>
 --%>





















<%-- <c:if test="${tabval ne sval}">
<td><input type="checkbox"  name="seats" value="${sseat}">${sseat}</td>

<c:if test="${sseat%5==0}">
<tr></tr>
</c:if>
</c:if> --%>


<%-- <c:if test="${tabval ne sval} ? 'flag=""' : '' ">
<td><input type="checkbox" checkbox="flag" name="seats" value="${sseat}">${sseat}</td>

<c:if test="${sseat%5==0}">
<tr></tr>
</c:if>
</c:if> --%>




<%-- </c:forEach> --%>
</tr>
</c:if>
</table>


<br>

<input type="submit" class="btn btn-success" value="Add Seats">


</div>
 </div>
</div>
 
</form:form>


<%
int i = (Integer) session.getAttribute("sid");
int mid=(Integer) session.getAttribute("mid");
%>
<div align="center">
<button type="button"class="btn btn-primary"><a href="/listthetare/<%= i %>" style="color:white">Back to Theater</a></button>
<button type="button"class="btn btn-primary"><a href="/listmovies/<%= mid %>" style="color:white">Back to Movies</a></button>
<button type="button"class="btn btn-primary"><a href="/listplace" style="color:white">Back to Place</a></button>
</div>

</body>
</html>