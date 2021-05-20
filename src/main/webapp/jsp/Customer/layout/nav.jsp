<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<div class="col-sm-3 sidenav">
	<div></div>
	<h4>${currentCustomer.getCusName()} - Inventory</h4>
	<br> <br>
	<ul class="nav nav-pills nav-stacked">
		<li ><a href="<%=request.getContextPath() %>/jsp/Customer/home.jsp">Home</a></li>
		<li><a href="<%= request.getContextPath() %>/customer/addOrder">Add Order</a></li>
		
	</ul>
	<br>
</div>