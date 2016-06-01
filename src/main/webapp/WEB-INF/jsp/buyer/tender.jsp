<%@page import="com.github.elizabetht.mappers.BuyerMapper"%>
<%@page import="com.github.elizabetht.model.TenderQuotation"%>
<%@page import="com.github.elizabetht.model.Tender"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery-1.8.3.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
 
</head>
<body>
<div class="container">
  <h2>Tender Responses</h2>
 <a href="addTender.html" class="btn btn-default">CREATE TENDER</a>
 <a href="viewTender.html" class="btn btn-default">VIEW TENDER</a>
 
   <c:if test="${not empty message}">
		<div style="color: red">${message}</div>
	</c:if>
	<table class="table table-striped">
    <thead>
      <tr>
      	<th>Tender Id</th>
      	<th>Product</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total Price</th>
        <th>Date Created</th>
      </tr>
    </thead>
    <c:choose>
      <c:when test="${sellerResponse !=null}">
     <c:forEach items="${sellerResponse}" var="responses"> 
     
     <%
     BuyerMapper mapper = (BuyerMapper)  request.getAttribute("buyerMapper");
     TenderQuotation res = (TenderQuotation) pageContext.getAttribute("responses");
     int tenderId = res.getTenderFk();
     Tender tender  = mapper.getTenderById(tenderId);
     %>
     
     <tr>
     <td> ${responses.getTenderFk()}</td>
     <td> <%=tender.getProductName() %> </td>
     <td>${responses.getProductConfiguration()}</td>
     <td> <%=tender.getQuantity() %> </td>
     <td>${responses.getPrice()} </td>
     <td>${responses.getRowCreated()} </td>
     </tr>
      </c:forEach>
     </c:when> 
     <c:otherwise>
     <tr>
     <td colspan="6">No results found</td>
     </tr>
     </c:otherwise>
      </c:choose>
    </tbody>
  </table>
</div>
</body>
</html>