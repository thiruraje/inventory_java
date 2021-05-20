<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<%@include file="../layout/header.jsp" %>
<body>

	<div class="container-fluid">
		<div class="row content">
			<%@include file="../layout/nav.jsp" %>
			<div class="col-sm-9">
				<h4>
					<small>Caregory Add</small>
				</h4>
				<hr>
				<form action="<%= request.getContextPath() %>/insertCategory" method = "post">
					<div class="form-group">
						<label for="text">Category:</label> <input type="text"
							class="form-control" id="category" name="category" required >
					</div>
					<button type="submit" class="btn btn-success">Submit</button>
				</form>
				

			</div>
		</div>
	</div>
</body>
</html>