<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
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
				
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<div class="container test">
		<div class="jumbotron jumbo">
			<h2 style="text-align: center;">Welcome to Online SHOPPING!</h2>
			
			<div>
			<c:choose>
			<c:when test="${productList!=null}">
			<c:forEach var="i" items="${productList}">
			
   			<div class="col-sm-4" >
   			<figure>
  			<img src="webapp/product/${i.getImage()}" alt="The Pulpit Rock" width="304" height="228">
  			<figcaption>Fig.. ${i.getProductId()} - ${i.getProductName()}</figcaption>
  			
			</figure>
			 <a href="addToCart.html?id=${i.getProductId()}"><img alt="ss" src="assets/img/shop3.jpg" style="width: 167px;height: 40px;"></a>
			</div>
			</c:forEach>
			</c:when>
			<c:otherwise>
			No results found!....
			</c:otherwise>
			</c:choose>
			</div>
		</div>

		<div></div>
	</div>
	<script src="jquery-1.8.3.js">
</script>

	<script src="bootstrap/js/bootstrap.js">
</script>

</body>
</html>
