<%@page import="java.util.Random"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
Random rand = new Random();
Integer n = rand.nextInt(90000) + 10000;
%>
<!DOCTYPE html>
<html lang="en">
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
									action="<%=request.getContextPath()%>/product/insertProduct"
									enctype="multipart/form-data">
									<div class="box-body">
										<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product Name</label> <input type="text"
															class="form-control" value=""
															placeholder="Enter product Name" name="product_name"
															required>
													</div>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product Id</label> <input type="text"
															class="form-control" value="<%=String.valueOf(n)%>"
															placeholder="Enter product id" name="product_id" readonly>
													</div>
												</div>
											</div>
										</div>
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
														<label>Product Color</label> <input type="text"
															class="form-control" value=""
															placeholder="Enter product color" name="product_clr"
															required>
													</div>
												</div>
											</div>
										</div>
										<div class="row">

											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product Rate</label> <input type="text"
															class="form-control" value=""
															placeholder="Enter product rate" name="product_rate"
															required>
													</div>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product description</label> <input type="text"
															class="form-control" value=""
															placeholder="Enter product description"
															name="product_description" required>
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
											<div class="col-sm-6">
												<div class="form-group">
													<div class="col-sm-12">
														<label>Product Image</label> <input class="form-control"
															type="file" id="productImg" name="filename">

													</div>
												</div>
											</div>


										</div>


										<br>
										<div align="center">
											<button type="submit" class="btn btn-info">Save</button>
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
	</div>
</body>
</html>