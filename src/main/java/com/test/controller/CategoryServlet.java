package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.CategoryDao;
import com.test.model.Category;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet(name="/CategoryServlet", urlPatterns = {"/addCategory","/insertCategory","/updateCategory","/deleteCategory","/editCategory"})
public class CategoryServlet extends HttpServlet {
	private CategoryDao categoryDao;
	public void init() {
		categoryDao = new CategoryDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/addCategory":
				System.out.println("addCategory");
				showNewForm(request, response);
				break;
			case "/insertCategory":
				System.out.println("insert");
				insertCategory(request, response);
				break;
			case "/deleteCategory":
				System.out.println("delete");
				deleteCategory(request, response);
				break;
			case "/editCategory":
				System.out.println("edit");
				showEditForm(request, response);
				break;
			case "/updateCategory":
				System.out.println("update");

				updateCategory(request, response);
				break;
			default:
				System.out.println("list");
				listCategory(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<Category> listCategory = categoryDao.listAllCategory();
		request.setAttribute("listCategory", listCategory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Admin/category/viewCategory.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Admin/category/addCategory.jsp");
		dispatcher.forward(request, response);
	}

	private void insertCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String category = request.getParameter("category");

		categoryDao.insertCategory(category);
		response.sendRedirect("viewCategory");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category existingCategory = categoryDao.getCategory(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Admin/category/editCategory.jsp");
		request.setAttribute("category", existingCategory);
		dispatcher.forward(request, response);

	}
	private void updateCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String category_name = request.getParameter("category");


		Category category = new Category(id, category_name);
		categoryDao.updateCategory(category);
		response.sendRedirect("list");
	}
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        categoryDao.deleteCategory(id);
        response.sendRedirect("list");
 
    }
}


