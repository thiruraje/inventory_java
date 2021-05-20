package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.AdminDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("pass");
		out.println(name);
		
		
		AdminDao adminDao = new AdminDao();

		try {
			int result= adminDao.loginAdmin(name,password);
			if(result ==1 ) {
				response.sendRedirect("jsp/Admin/home.jsp");
			}else {
				out.println("Incorrect username and password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
