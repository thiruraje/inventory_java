<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="col-sm-3 sidenav">
	<div></div>
	<h4>Thiru - Inventory</h4>
	<br> <br>
	<ul class="nav nav-pills nav-stacked">
		<li ><a href="home.jsp">Home</a></li>
		<li><a href="<%= request.getContextPath() %>/addCategory">Add Category</a></li>
		<li><a href="<%= request.getContextPath() %>/viewCategory">View Category</a></li>
		<li><a href="<%= request.getContextPath() %>/product/addProduct">Add Products</a></li>
		<li><a href="<%= request.getContextPath() %>/product/viewProduct">View Products</a></li>
		<li><a href="">Customers</a></li>
	</ul>
	<br>
</div>