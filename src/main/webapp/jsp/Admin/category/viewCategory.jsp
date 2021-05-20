<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<%@include file="../layout/header.jsp"%>
<body>

	<div class="container-fluid">
		<div class="row content">
			<%@include file="../layout/nav.jsp"%>
			<div class="col-sm-9">
				<h4>
					<small>Caregory Add</small> <a
						href="<%= request.getContextPath() %>/addCategory"
						class="btn btn-info pull-right">Add Category</a>
				</h4>
				<hr>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Category</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cat" items="${listCategory}">
                			<tr>
								<td>$</td>               
								<td><c:out value="${cat.category_name}" /></td>
								<td><a href="<%= request.getContextPath() %>/editCategory?id=<c:out value='${cat.id}' />">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="<%= request.getContextPath() %>/deleteCategory?id=<c:out value='${cat.id}' />">Delete</a></td>
								                                                       
							</tr>
            			</c:forEach>
					</tbody>
				</table>


			</div>
		</div>
	</div>
</body>
</html>