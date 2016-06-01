<%@page import="com.github.elizabetht.model.TenderQuotation"%>
<%@page import="com.github.elizabetht.model.Seller"%>
<%@page import="com.github.elizabetht.model.Buyer"%>
<%@page import="com.github.elizabetht.model.Tender"%>
<%@page import="com.github.elizabetht.mappers.SellerMapper"%>
<%@page import="com.github.elizabetht.mappers.BuyerMapper"%>
<%@page import="com.github.elizabetht.service.BuyerServiceImpl"%>
<%@page import="com.github.elizabetht.service.BuyerService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping</title>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" href="assets/css/jquery.countdownTimer.css"> -->
  <!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
  <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
  <script src="bootstrap/js/bootstrap.min.js"> </script>
  <script src="bootstrap/js/bootstrap.js">
</script>
<!-- <script src="https://code.jquery.com/jquery-2.2.4.min.js">
</script> -->
<script src="jquery-1.8.3.js"></script>
<script src="assets/js/jquery.countdownTimer.js">

</script>
  <script type="text/javascript">
  function doSomething(ids,dates){
	$(function(){
		$("#"+ids).countdowntimer({
            dateAndTime : $("."+ids).html(),
            size : "lg", 
            regexpMatchFormat: "([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})", 
            regexpReplaceWith: "$1<sup>days</sup> / $2<sup>hours</sup> / $3<sup>minutes</sup> / $4<sup>seconds</sup>"
});
		if($("#"+ids).html() == "00<sup>days</sup> / 00<sup>hours</sup> / 00<sup>minutes</sup> / 00<sup>seconds</sup>"){
			$("#action"+ids).html("time expired");
		}
		else{
			//alert($("#"+ids).html())
			//alert("no")
			// do nothing
			
		}
	});
}

</script>
  
  
  
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
        <th>Apply</th>
      </tr>
    </thead>
    <c:choose>
      <c:when test="${tendersList !=null}">
     <c:forEach items="${tendersList}" var="tender"> 
     <%
     BuyerMapper mapper = (BuyerMapper)  request.getAttribute("buyers");
     Tender res = (Tender) pageContext.getAttribute("tender");
     int buyerId = res.getBuyerFk();
     Buyer buyer  = mapper.getBuyer(buyerId);
     SellerMapper sellerMapper = (SellerMapper) request.getAttribute("sellers");
     int tenderId = res.getTenderId();
     TenderQuotation tenderQuote = sellerMapper.getQuotation(tenderId);
     %>
     
     
     
     <tr>
     <td><%=buyer.getFirstname()%> <%=buyer.getLastname()%> </td>
     <td>${tender.getProductName()}</td>
     <td> ${tender.getQuantity()} </td>  
     <td class="${tender.getTenderId()}"><fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss" value="${tender.getCloseTime()}" /></td>
     <td><span id="${tender.getTenderId()}"></span>
     </td>
     <td>${tender.getRowCreated()} </td>
     <td id="action${tender.getTenderId()}">
     <c:choose>
     <c:when test="<%=tenderQuote != null%>">
   <b> Applied</b>
     </c:when>
     <c:otherwise>
     <a href="quotation.html?tenderId=${tender.getTenderId()}">Apply</a>
     </c:otherwise>
     </c:choose>
     </td>
     </tr>
       <script>doSomething('${tender.getTenderId()}','${tender.getCloseTime()}');</script>
      </c:forEach>
     </c:when> 
     <c:otherwise>
     <tr>
     <td colspan="7">No results found</td>
     </tr>
     </c:otherwise>
      </c:choose>
    </tbody>
  </table>
  <div id="future_date"><span id="future_date"><span></div>
</div>


<!-- <script type="text/javascript">
$("document").ready(function(){
	 //setInterval(function(){ timerCalc() }, 3000);
	
	
	
	
	//function timerCalc(){}
	
	var start_actual_time  =  "01/17/2012 11:20:22";
	var end_actual_time    =  "01/18/2012 12:25:26";

	start_actual_time = new Date(start_actual_time);
	end_actual_time = new Date(end_actual_time);

	var diff = end_actual_time - start_actual_time;

	var diffSeconds = diff/1000;
	var HH = Math.floor(diffSeconds/3600);
	var MM = Math.floor(diffSeconds%3600)/60;
	//var ss = Math.floor((diffSeconds%3600)/60)/60;
	var formatted = ((HH < 10)?("0" + HH):HH) + ":" + ((MM < 10)?("0" + MM):MM)
	//alert(formatted);
	
});
</script> -->

</body>
</html>