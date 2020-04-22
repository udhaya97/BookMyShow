<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  
  
  

<title>BMS</title>
<style>
a{
 color: green;
}

.ali
{

top:30px;
right:10px;
left:1500px;
padding:16px;
position:absolute;

}

/*  body {
  
  background-image: url("place_img.jpg");
  opacity:0.3;
  
} */
div.relative {
  position: relative;
  left: 100px;
  top:100px;

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
<body background="plo.jpg" >
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
<h3>Click on the location to view movies</h3>
</div>
<form:form action="/listmovies" method="get" modelAttribute="lismovies">
<div class="relative">

<table>

<c:forEach items="${lspl}" var="place" >
<th><img src="${place.imgs}" class="img-thumbnail" alt="Cinque Terre" width="150" height="150"></th></c:forEach></tr><tr>
<c:forEach items="${lspl}" var="place" >
<td><div align="center"><button type="button" class="btn btn-success"><a href="/listmovies/${place.pId}" style="color:white" style="text-align:center">  &nbsp ${place.pName}  </a></button></div></td></c:forEach></tr>



</table>

</div>
</form:form>
<br>


</body>
</html>