<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<style>

.navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
h3{

color:red;
}
h2
{

color:blue;}

body
{
 background-image:url("joker.jpg")}

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
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Gallery</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/createuser"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="jumbotron">
  <div class="container text-center">
  <div align="center">

<h1>Welcome To 

BookMyShow</h1>
<h2>Hello ${name} :)</h2>
  </div>
</div>
</div>

<div class="container-fluid bg-3 text-center">    
  <h3>Some of my Work</h3><br>
  <div class="row">
    <div class="col-sm-3">
      <p>Add Place</p>
    <a href="/addplace"><img src="place.jpg" class="img-responsive" style="width:100%" alt="Image"></a>  
    </div>
    <div class="col-sm-3"> 
      <p>Add Movies</p>
      <a href="/addmovies"><img src="movies.jpg" class="img-responsive" style="width:100%" alt="Image"></a>
    </div>
    <div class="col-sm-3"> 
      <p>Add Theatre</p>
     <a href="/addtheatre"> <img src="theatre.jpg" class="img-responsive" style="width:100%" alt="Image"></a>
    </div>
    <div class="col-sm-3">
      <p>Edit Theatre</p>
     <a href ="/edittheat"> <img src="setcreation.jpg" class="img-responsive" style="width:100%" alt="Image"></a>
    </div>
  </div>
</div><br>

<div class="container-fluid bg-3 text-center">    
  <div class="row">
    <div class="col-sm-3">
      <p>Edit Movie</p>
      <a href="/editmov"><img src="edit-movie.jpg" class="img-responsive" style="width:100%" alt="Image"></a>
    </div>
    <div class="col-sm-3"> 
      <p>Edit Place</p>
      <a href="/ediplace"><img src="location-edit.png" class="img-responsive" style="width:100%" alt="Image"></a>
    </div>
    <div class="col-sm-3"> 
      <p>Book ticket</p>
     <a href="/listplace"> <img src="bookticket.jpg" class="img-responsive" style="width:100%" alt="Image"></a>
    </div>
  </div>
</div><br><br>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

<!-- <table>

<tr><td><a href="/addplace">Add Place</a></td><td><a href="/addmovies">Add Movies</a></td><td> </td> <td><a href="/addtheatre">Add Theatre</a></td><td> </td>
<td><a href ="/edittheat">Edit Theatre</a></td><td> </td><td><a href="/editmov">Edit Movie</a></td><td> </td><td><a href="/ediplace">Edit Place</a></td></tr>

<tr><td><a href="/listplace">Book a ticket</a>

<br/>
<br/>
<a href="/createuser">Logout</a>


</table> -->
</body>
</html>