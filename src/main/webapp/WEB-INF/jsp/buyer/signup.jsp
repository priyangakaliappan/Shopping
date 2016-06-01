<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery-1.8.3.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
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
	
    <form:form class="form-signin" method="post" modelAttribute="buyerDetails" >       
    <span style="color: red">${message}</span>
      <h2 class="form-signin-heading" align="center">Register</h2>
      <form:input type="text" class="form-control" path="firstname" placeholder="First Name" required="" autofocus="" /><br>
      <form:input type="text" class="form-control" path="lastname" placeholder="Last Name" required=""  /><br>
      <form:input type="number" class="form-control" path="phoneNumber" placeholder="Phone Number" required=""  /><br>
      <form:input type="email" class="form-control" path="email" placeholder="Email Address" required="" /><br>
      <form:input type="text" class="form-control" path="address" placeholder="Address" required=""  /><br>
      <form:input type="password" class="form-control" path="password" placeholder="Password" required="" id="password"/>      <br>
      <input type="password" class="form-control" name="confirmPassword" placeholder="confirmPassword" required="" id="confirmPassword"/>     
     <br>
      <button class="btn btn-lg btn-primary" type="submit" onclick="return check()">Register</button>   
        <a href="buyer.html" class="btn btn-lg btn-primary" >Cancel</a>   
       
        <br> <br>
      Already a member? Sign In<a href="buyer.html"> Login</a>
    </form:form>
  </div>
  <script type="text/javascript">
  function check(){
	  if($("#password").val() != $("#confirmPassword").val()){
		  alert("Password doesnt match!");
		return false;
	  }
  }
  
  </script>
</body>
</html>