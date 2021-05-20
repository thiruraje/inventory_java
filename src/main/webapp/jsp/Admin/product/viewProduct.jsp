<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<%@include file="../layout/header.jsp" %>
<body>

	<div class="container-fluid">
		<div class="row content">
			<%@include file="../layout/nav.jsp" %>
			<div class="col-sm-9">
				<h4>
					<small>Product View</small>
				</h4>
				<hr>
				
				<table class="table">
					<thead>
						<tr>
						<th>#</th>
							<th scope="col">Product img</th>
							<th scope="col">Name</th>
							<th scope="col">Category</th>
							<th scope="col">Id</th>
							<th scope="col">Rate</th>
							<th scope="col">Qty</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="pro" items="${listProduct}">
				
                			<tr>
								<td>$</td>
								<td><img src="../images/<c:out value="${pro.proImg}" />" width="60" height="60" alt=""/></td>
								<td><c:out value="${pro.proName}" /></td>
								<td><c:out value="${pro.proCategory}" /></td>
								<td><c:out value="${pro.proId}" /></td>
								<td><c:out value="${pro.proRate}" /></td>
								<td><c:out value="${pro.proQty}" /></td>
								<td><a href="<%= request.getContextPath() %>/product/editProduct?proid=<c:out value='${pro.proId}' />">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%= request.getContextPath() %>/product/deleteProduct?id=<c:out value='${pro.proId}' />">Delete</a></td>
				
								                                                       
							</tr>
            			</c:forEach>
						
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>