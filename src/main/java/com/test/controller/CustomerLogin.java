package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.AdminDao;
import com.test.dao.CustomerDao;
import com.test.model.Customer;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("pass");
		out.println(name);


		CustomerDao customerDao = new CustomerDao();

		try {
			Customer cus= customerDao.loginCustomer(name,password);
			if(cus != null ) {
				request.getSession().setAttribute("currentCustomer", cus);
				response.sendRedirect("jsp/Customer/home.jsp");
			}else {
				out.println("Incorrect username and password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
