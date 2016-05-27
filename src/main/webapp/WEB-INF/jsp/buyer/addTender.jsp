<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Enrollment Signup</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="datepicker/css/datepicker.css" rel="stylesheet" />
<script src="jquery-1.8.3.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="datepicker/js/bootstrap-datepicker.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
.green {
	font-weight: bold;
	color: green;
}

.message {
	margin-bottom: 10px;
}

.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

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
	border: 1px solid rgba(0, 0, 0, 0.1);
	.
	form-signin-heading
	,
	.checkbox
	{
	margin-bottom
	:
	30px;
}

.checkbox {
	font-weight: normal;
}

.form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	@
	include
	box-sizing(border-box);
	&:
	focus
	{
	z-index
	:
	2;
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

		<form id="myForm" method="post"
			class="bs-example form-horizontal form-signin" commandName="student">
			<span style="color: red">${message}</span>
			<h2 class="form-signin-heading" align="center">Register</h2>
			<input type="text" class="form-control" name="referenceNo"
				placeholder="Reference No" required="" autofocus="" /><br> 
			<input
				type="text" class="form-control" name="productName"
				placeholder="Product Name" required="" /><br> 
			<input
				type="text" class="form-control" name="description"
				placeholder="Description" required="" /><br> 
			<input
				type="number" class="form-control" name="quantity"
				placeholder="quantity" required="" /><br>
			<div class="date form_date col-lg-9" data-date-format="mm/dd/yyyy"
				data-date-viewmode="years">
				<input type="text" class="form-control" id="closeDate"
					name="closeTime" placeholder="Closing Time" required />
			</div>
			<br>
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				onclick="return check()">Register</button>






		</form>

	</div>
	<script>
		$(function() {
			$('#closeDate').datepicker();
		});
	</script>




</body>
</html>