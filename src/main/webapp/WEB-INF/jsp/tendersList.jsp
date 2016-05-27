<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Tenders</h2>
   
 <c:if test="${not empty message}">
		<div style="color: red">${message}</div>
	</c:if>
  <table class="table table-striped">
    <thead>
      <tr>
      <th>Buyer Name</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Closing Date</th>
        <th>Time remains</th>
        <th>Date Created</th>
      </tr>
    </thead>
      <c:if test="${tendersList !=null}">
     <c:forEach items="${tendersList}" var="tender"> 
     <tr>
     <td> ${tender.getBuyerFk()} </td>
     <td>${tender.getProductName()}</td>
     <td> ${tender.getQuantity()} </td>
     <td>${tender.getCloseTime()} </td>
     <td>&nbsp; </td>
     <td>${tender.getRowCreated()} </td>
     </tr>
      </c:forEach>
     </c:if>  
    </tbody>
  </table>
</div>
</body>
</html>