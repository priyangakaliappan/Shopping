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
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
<link href="datepicker/css/datepicker.css" rel="stylesheet" />
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />

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
</style>
</head>
<body>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/StudentEnrollmentWithMyBatis">Home</a></li>
				<li class="active"><a href="signup.html">Signup</a></li>
				<li><a href="login.html">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<script src="datepicker/js/bootstrap-datepicker.js">
		
	</script>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<form:form id="myForm" method="post" action="submitQuotation.html"
							class="bs-example form-horizontal" modelAttribute="tenderQuotation">
							<fieldset>
								<legend>Tender Quotation Form</legend>

								<div class="form-group">
									<label for="productName" class="col-lg-3 control-label">Product</label>
									<div class="col-lg-9">
										<%-- <form:input type="text" class="form-control" path="productConfiguration"
											id="userNameInput" placeholder="User Name" />
										<form:errors path="productConfiguration" cssClass="error" /> --%>
										<input type="text" id="productName" name="productName" class="form-control" value="${tender.getProductName()}" disabled="disabled">
									</div>
								</div>
							<div class="form-group">
									<label for="quantity" class="col-lg-3 control-label">Quantity</label>
									<div class="col-lg-9">
										<%-- <form:input type="text" class="form-control" path="productConfiguration"
											id="userNameInput" placeholder="User Name" />
										<form:errors path="productConfiguration" cssClass="error" /> --%>
										<input type="text" id="quantity" name="quantity" class="form-control" value="${tender.getQuantity()}" disabled="disabled">
									</div>
								</div>

								<form:hidden path="buyerFk" value="${tender.getBuyerFk()}"/>
								<form:hidden path="tenderFk" value="${tender.getTenderId()}"/>
								<div class="form-group">
									<label for="productConfig" class="col-lg-3 control-label">Product Configuration</label>
									<div class="col-lg-9">
										<form:textarea class="form-control"
											path="productConfiguration" id="productConfig" placeholder="Product Configuration" />
									</div>
								</div>

								<div class="form-group">
									<label for="price" class="col-lg-3 control-label">Price</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control" path="price"
											id="price" placeholder="Price" />
										<form:errors path="price" cssClass="error" />
									</div>
								</div>

								<div class="col-lg-9 col-lg-offset-3">
									<button class="btn btn-default">Cancel</button>

									<button class="btn btn-primary" type="submit">Submit</button>
									
								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	

</body>
</html>