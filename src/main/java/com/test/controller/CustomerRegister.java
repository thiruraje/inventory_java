package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.AdminDao;
import com.test.dao.CustomerDao;
import com.test.model.Customer;

/**
 * Servlet implementation class CustomerRegister
 */
@WebServlet("/CustomerRegister")
public class CustomerRegister extends HttpServlet {
	
	static boolean isPassword(String str) {
		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z]).{6,20}$");
		Matcher m = p.matcher(str);
		return m.matches();    
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String name = request.getParameter("username");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		String password = request.getParameter("pass");
		String conPassword = request.getParameter("conpass");
		out.println(name);
		CustomerDao customerDao = new CustomerDao();
		
		if(isPassword(password) && isPassword(conPassword) ) {
			if(password.equals(conPassword)) {
				Customer cusObj=new Customer(name,address,mobile,password);
				try {
					boolean result= customerDao.registerCustomer(cusObj);
					if(result ==true ) {
						request.getSession().setAttribute("currentCustomer", cusObj);
						response.sendRedirect("jsp/Customer/home.jsp");
					}else {
						out.println("Mobile number Already exit !!!");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				out.print("Conform password is wrong  !!!");
				RequestDispatcher rd=request.getRequestDispatcher("jsp/Customer/register.jsp");
				rd.include(request,response); 
			}
		}else {
			out.print("Max password size is 6 and have small letters  !!!"); 
			RequestDispatcher rd=request.getRequestDispatcher("jsp/Customer/register.jsp");
			rd.include(request,response); 
		}
		
		
	}

}
