<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<%@include file="../layout/header.jsp"%>

<body>
	<div class="container-fluid">
		<div class="row content">
			<%@include file="../layout/nav.jsp"%>
			<div class="col-sm-9">
				<h4>
					<small>Product Add</small>
				</h4>
				<hr>
				<br>
				<table class="table">
					<thead>
						<tr>
						<th>#</th>
							<th scope="col">Order Id</th>
							<th scope="col">Date</th>
							<th scope="col">Amount</th>
							
						</tr>
					</thead>
					<tbody>
					<c:forEach var="order" items="${listOrder}">
				
                			<tr>
								<td>$</td>
								<td><c:out value="${order.orderId}" /></td>
								<td><c:out value="${order.date}" /></td>
								<td><c:out value="${order.amount}" /></td>
								
				
								                                                       
							</tr>
            			</c:forEach>
						
					</tbody>
				</table>
				


			</div>
		</div>
	</div>
</body>
</html>