package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.OrderDao;
import com.test.model.Category;
import com.test.model.Customer;
import com.test.model.Product;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private OrderDao orderDao;
	public void init() {
		orderDao = new OrderDao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/customer/addOrder":
				System.out.println("addProduct");
				showNewForm(request, response);
				break;
			case "/customer/insertOrder":
				System.out.println("insertProduct");
				insertOrder(request, response);
				break;
			case "/customer/deleteOrder":
				System.out.println("deleteProduct");
//				deleteProduct(request, response);
				break;
			case "/customer/editOrder":
				System.out.println("editProduct");
//				showEditForm(request, response);
				break;
			case "/customer/updateOrder":
				System.out.println("updateProduct");

//				updateProduct(request, response);
				break;
			default:
				System.out.println("ddfflist");
//				listProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		List<Category> categoryList =orderDao.listAllCategory();
		List<Product> productList =orderDao.listAllProduct();
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("productList", productList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Customer/order/addOrder.jsp");
		dispatcher.forward(request, response);

	}
	private void insertOrder(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String product_category = request.getParameter("product_category");
		String product_id = request.getParameter("product_id");
		String product_qty = request.getParameter("product_qty");
		
		Customer cusObj=(Customer) request.getSession().getAttribute("currentCustomer");
		
		PrintWriter out= response.getWriter();
		System.out.println(cusObj);
		System.out.println(product_category);
		System.out.println(product_id);
		System.out.println(product_qty);
		orderDao.insertOrder(cusObj,product_id,Integer.parseInt(product_qty));

//		insertOrder.insertCategory(category);
//		response.sendRedirect("viewCategory");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
