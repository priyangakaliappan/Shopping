<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
body {
	height: 100%;
	margin: 0;
	background: url(assets/img/books.jpg);
	background-size: 1440px 800px;
	background-repeat: no-repeat;
	display: compact;
}

.jumbo{
height: 725px;
overflow: scroll;
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
				<li class="active"><a href="#">Home</a></li>
				<li><a href="admin.html">Admin</a></li>
				<li><a href="#">Cart</a></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<div class="container test">
		<div class="jumbotron jumbo">
			<h2 style="text-align: center;">Cart&nbsp;[ ${list.size()} ]</h2>
			
		<table class="table table-striped">
    <thead>
      <tr>
      <th>Product</th>
        <th>Product Name</th>
        <th>Date Created</th>
      </tr>
    </thead>
     <c:if test="${list !=null}">
     <c:forEach items="${list}" var="product">
     <tr>
     <td><img alt="ss" src="webapp/product/${product.getImage()}" height="200px;" width="200px;"> </td>
     <td style="text-align: center;">${product.getProductName()}ss</td>
     <td>${product.getRowCreated()}</td>
     </tr>
     </c:forEach>
     </c:if> 
    </tbody>
  </table>

		</div>
	</div>
	<script src="jquery-1.8.3.js">
</script>

	<script src="bootstrap/js/bootstrap.js">
</script>


</body>
</html>
