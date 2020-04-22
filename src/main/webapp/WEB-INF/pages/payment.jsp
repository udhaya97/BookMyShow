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
<style>

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
  
  



div.relative {
  position: relative;
  left: 40px;
  top:100px;

}



</style>
</head>
<body background="pay.jpg">
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
 <h2>Payment Page</h2>

<div class="relative">
<br/>Ticket value is ${prizze}
<br/>

<h3>New User Add Bank here <button type="button" class="btn btn-warning"><a href="/bsaved" style="color:white">AddBank</a></button></h3><br/>

<table>
<form:form action="/fetchamount" method="get" modelAttribute="bal">
<tr><td>
<select name="bname">
<option>select Bank</option>
<c:forEach items="${lisbank}" var="lbk">


<option >${lbk.bName}</option>


</c:forEach>

</select>
</td>
<td></td><td><input type="submit" value="fetch balance"></td></tr></form:form>

<form:form action="/ticketgen/${balance.balance}/${balance.bId}" method="get" modelAttribute="lismovies"><tr></tr>



<tr><td>Bank Balance is  ${balance.balance} </td>
<td></td><td><button type="button" class="btn btn-primary"><a href="/listbanks" style="color:white">Change Account</a></button></td></tr><tr>

<td>
<c:set var="balance" value="${bnc}"/>
<c:set var="price" value="${prizze}"/>
 
  <c:if test="${price >= balance}">
  <br>
    Change the account or Add new Bank . Balance is low
    
    <br>
  

  </c:if>
 <c:if test="${price <= balance}">
 
    <input type="submit" value ="get ticket" >
 
</c:if>
</td></tr>


</form:form>
</table></div></div>
</body>
</html>