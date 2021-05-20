<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<%@include file="../layout/header.jsp" %>
<body>

	<div class="container-fluid">
		<div class="row content">
			<%@include file="../layout/nav.jsp" %>
			<div class="col-sm-9">
				<h4>
					<small>Caregory Edit</small>
				</h4>
				<hr>
				<form action="<%= request.getContextPath() %>/updateCategory" method = "post">
				<input type="hidden" name="id" value="<c:out value='${category.id}' />" />
					<div class="form-group">
						<label for="text">Category:</label> <input type="text"
							class="form-control" id="category" value="<c:out value='${category.category_name}'/>" name="category" required >
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
				</form>
				

			</div>
		</div>
	</div>
</body>
</html>