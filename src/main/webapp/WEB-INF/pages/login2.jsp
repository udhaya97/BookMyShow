<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">

<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">

<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">

<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">

<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
<div class="limiter">
<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
<div class="wrap-login100 p-t-30 p-b-50">
<span class="login100-form-title p-b-41">
Account Login
</span>
<form:form action="/verify" method="get" modelAttribute="login">
<form class="login100-form validate-form p-b-33 p-t-5">
<div class="wrap-input100 validate-input" data-validate="Enter username">

<form:input path="uName" name="uName" class="input100"  placeholder="User name"/>
<span class="focus-input100" data-placeholder="&#xe82a;"></span>
</div>
<div class="wrap-input100 validate-input" data-validate="Enter password">
<form:input path="pass" class="input100" type="password" name="pass" placeholder="Password"/>
<span class="focus-input100" data-placeholder="&#xe80f;"></span>
</div>
<div class="container-login100-form-btn m-t-32">
<button class="login100-form-btn">
Login
</button>
</div>
</form></form:form>
</div>
</div>
</div>
<div id="dropDownSelect1"></div>

<script src="vendor/jquery/jquery-3.2.1.min.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>

<script src="vendor/animsition/js/animsition.min.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>

<script src="vendor/bootstrap/js/popper.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>

<script src="vendor/select2/select2.min.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>

<script src="vendor/daterangepicker/moment.min.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>
<script src="vendor/daterangepicker/daterangepicker.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>

<script src="vendor/countdowntime/countdowntime.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>

<script src="js/main.js" type="bc8232a93787b428d5e08b09-text/javascript"></script>

<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13" type="bc8232a93787b428d5e08b09-text/javascript"></script>
<script type="bc8232a93787b428d5e08b09-text/javascript">
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());

	  gtag('config', 'UA-23581568-13');
	</script>
<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/a2bd7673/cloudflare-static/rocket-loader.min.js" data-cf-settings="bc8232a93787b428d5e08b09-|49" defer="">
</script></body>
</html>
