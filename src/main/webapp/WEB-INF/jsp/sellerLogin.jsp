<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script src="bootstrap/js/bootstrap.min.js"> </script>
  <script src="bootstrap/js/bootstrap.js">
</script>
<!-- <script src="https://code.jquery.com/jquery-2.2.4.min.js">
</script> -->
<script src="jquery-1.8.3.js"></script>

   <style type="text/css">
   body {
	background: #eee !important;	
}

.wrapper {	
	margin-top: 80px;
  margin-bottom: 80px;
}

.form-signin {
  max-width: 380px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  

  .form-signin-heading,
	.checkbox {
	  margin-bottom: 30px;
	}

	.checkbox {
	  font-weight: normal;
	}

	.form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}

	input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}

	input[type="password"] {
	  margin-bottom: 20px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
}
   
   </style>
</head>
<body>
	<div class="wrapper">
			<form:form id="myForm" method="post"
							class="form-signin" modelAttribute="sellerCredential">
      <h2 class="form-signin-heading">Please Login</h2>
      <form:input type="text" class="form-control" path="userName" id="userNameInput" placeholder="User Name" /><br>
	<form:input type="text" class="form-control" path="password" id="passwordInput" placeholder="Password" />
     <br>
     <span style="color: red">${message}</span><br><br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>   
        <br>
      	Not a member yet? Join today.<a href="sellerSignup.html">SignUp</a>
    </form:form>
  </div>
</body>
</html>