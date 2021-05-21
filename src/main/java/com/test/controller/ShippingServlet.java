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
import com.test.dao.ProductDao;
import com.test.dao.ShippingDao;
import com.test.model.Customer;
import com.test.model.Order;
import com.test.model.Product;
import com.test.model.Shipment;

/**
 * Servlet implementation class ShippingServlet
 */
@WebServlet("/ShippingServlet")
public class ShippingServlet extends HttpServlet {
	
	private ShippingDao shippingDao;
	public void init() {
		shippingDao = new ShippingDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/order/addShipping":
				System.out.println("addShipping");
				addShipping(request, response);
				break;
				
			case "/order/viewShipping":
				System.out.println("viewShipping");
				viewShipping(request, response);
				break;
				
			case "/order/generateBill":
				System.out.println("generateBill");
				generateBill(request, response);
				break;
			
			default:
				System.out.println("ddfflist");
				listOrders(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Order> listOrder = shippingDao.listAllOrders();
		
		request.setAttribute("listOrder", listOrder);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Admin/order/viewOrder.jsp");
		dispatcher.forward(request, response);
	}
	private void addShipping(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		PrintWriter out= response.getWriter();
		int orderid = Integer.parseInt(request.getParameter("order_id"));
		boolean isShipped = shippingDao.shipping(orderid);
		if(isShipped) {
			out.println(orderid +" - "+"Successfully shipped !!!!!!!!!!!!!!");
		}else {
			out.println("Had some problem !!!!!!!!!!!!!!");
		}
	}
	private void viewShipping(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Shipment> listShipment = shippingDao.listAllShipment();

		request.setAttribute("listShipment", listShipment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Admin/shipment/viewShipment.jsp");
		dispatcher.forward(request, response);
	}
	private void generateBill(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		PrintWriter out= response.getWriter();
		int shipId = Integer.parseInt(request.getParameter("ship_id"));
		Shipment shipment = shippingDao.getShipment(shipId);
		Product product = ProductDao.getProduct(shipment.getProductId());
		
		request.setAttribute("shipment", shipment);
		request.setAttribute("product", product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Admin/shipment/generateBill.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
