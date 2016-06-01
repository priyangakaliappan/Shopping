<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script src="jquery-1.8.3.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/dataTables/jquery.dataTables.js"></script>
<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>

</head>
<body>
<div class="container">
<br>
<a href="tender.html"> Go Back</a>
<br>
<c:if test="${not empty message}">
		<div style="color: red">${message}</div>
	</c:if>
	<table class="table table-striped table-bordered table-hover dataTables-example">
    <thead>
      <tr>
      	<th>Tender Id</th>
      	<th>Product</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Is Active</th>
        <th>Started Date</th>
        <th>Closing Date</th>
        <th>Action</th>
      </tr>
    </thead>
    <c:choose>
      <c:when test="${tenderList !=null}">
     <c:forEach items="${tenderList}" var="tender"> 
     
     <tr>
     <td> ${tender.getTenderId()}</td>
     <td>${tender.getProductName()}</td>
     <td>${tender.getProductDescription()}</td>
     <td> ${tender.getQuantity()} </td>
     <td>${tender.getIsActive()}</td>
     <td>${tender.getStartTime()}</td>
     <td>${tender.getCloseTime()}</td>
     <td><a href="tenderActions.html?tenderId=${tender.getTenderId()}&refNo=${tender.getReferenceNo()}&value=1">Activate</a>&nbsp;&nbsp;<a href="tenderActions.html?tenderId=${tender.getTenderId()}&refNo=${tender.getReferenceNo()}&value=0" >Suspend</a></td>
     </tr>
      </c:forEach>
     </c:when> 
     <c:otherwise>
     <tr>
     <td colspan="8">No results found</td>
     </tr>
     </c:otherwise>
      </c:choose>
    </tbody>
  </table>
</div>
<script type="text/javascript">
$(document).ready(function(){
	 $('.dataTables-example').dataTable();
});
</script>
</body>
</html>