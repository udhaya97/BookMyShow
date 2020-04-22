<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>
<style>
table, th,tr,td {
  border: 1px solid black;
  border-collapse: collapse;
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
<h3>Edit movies</h3>
<form:form action ="/editmval/${mv.mId}" method ="get" modelAttribute="editmovie">
<table >
<tr><td>Movie Id</td><td>Movie Name</td><td>Language</td><td>Duration</td><td>Place Id And Place</td><td>Update</td></tr>


<tr><td>${mv.mId}</td><td><form:input path="mName" value="${mv.mName}"/></td><td><form:input path="lang" value="${mv.lang}"/>
</td><td><form:input path="duration" value="${mv.duration}"/></td><td>
<select name="pidname" >
<option>Select PId and Place</option>
 
<c:forEach items="${plval}" var ="pval">
<option>${pval.pId}
,${pval.pName}</option>
</c:forEach>
</select></td><td><input type="submit" value="update"></td></tr></table></form:form>


<br/><a href="/editmov">Go to back to movie edit list</a></div>
</body>
</html>