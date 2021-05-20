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
				<div class="row">
					<div class="col-xs-12">
						<div class="box box-info">
							<div class="box-body">
								<form class="form-horizontal" method="post"
									action="<%=request.getContextPath()%>/customer/insertOrder">
									<div class="box-body">

										<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product Category</label> <select
															name="product_category" class="form-control">
															<option value="">Select Category</option>
															<c:forEach var="cat" items="${categoryList}">
                												
																	<option value="<c:out value="${cat.category_name}" />"><c:out
																		value="${cat.category_name}" /></option>
																	                                                       
            												</c:forEach>

														</select>
													</div>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product</label> <select
															name="product_id" class="form-control">
															<option value="">Select product</option>
															<c:forEach var="pro" items="${productList}">
                												
																	<option value="<c:out value="${pro.proId}" />"><c:out
																		value="${pro.proName}" /></option>
																	                                                       
            												</c:forEach>

														</select>
													</div>


												</div>
											</div>

										</div>
										<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product Qty</label> <input type="text"
															class="form-control" value=""
															placeholder="Enter product qty" name="product_qty"
															required>
													</div>
												</div>
											</div>

										</div>
										<br>
										<div align="center">
											<button type="submit" class="btn btn-info">Get
												Product</button>
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
				<br>
				


			</div>
		</div>
	</div>
</body>
</html>