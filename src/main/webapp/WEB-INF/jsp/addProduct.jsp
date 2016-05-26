<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form class="form-horizontal"  method="POST" enctype="multipart/form-data">
  <fieldset>
    <div id="legend">
      <legend class="" align=""><center>Add Product</center></legend>
    </div>
    <div class="control-group">
      <label class="control-label">Product</label>
      <div class="controls">
        <input type="text" name="productName" required>
      </div>
    </div><br>
     <div class="control-group">
      <label  class="control-label" >Upload Image</label>
      <div class="controls">
        <input type="file" name="imageFile" required>
      </div>
    </div><br>
    
    <div class="control-group">
      <!-- Button -->
      <div class="controls">
        <button class="btn btn-success">Save</button>
      </div>
    </div>
  </fieldset>
</form>
</div>
</body>
</html>