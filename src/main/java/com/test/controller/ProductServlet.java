package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.test.dao.ProductDao;
import com.test.model.Category;
import com.test.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private ProductDao productDao;
	public void init() {
		productDao = new ProductDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);

		try {
			switch (action) {
			case "/product/addProduct":
				System.out.println("addProduct");
				showNewForm(request, response);
				break;
			case "/product/insertProduct":
				System.out.println("insertProduct");
				insertCategory(request, response);
				break;
			case "/product/deleteProduct":
				System.out.println("deleteProduct");
				deleteProduct(request, response);
				break;
			case "/product/editProduct":
				System.out.println("editProduct");
				showEditForm(request, response);
				break;
			case "/product/updateProduct":
				System.out.println("updateProduct");

				updateProduct(request, response);
				break;
			default:
				System.out.println("ddfflist");
				listProduct(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		List<Category> categoryList =productDao.listAllCategory();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Admin/product/addProduct.jsp");
		dispatcher.forward(request, response);

	}

	private void insertCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String proName = null;
		String proId = null;
		String proCategory = null;
		String proClr = null;
		String proRate =null;
		String proDes=null;
		String proQty=null;
		
		String file_name = null;
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List < FileItem > fields = upload.parseRequest(request);
			Iterator < FileItem > it = fields.iterator();
			if (!it.hasNext()) {
				return;
			}
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (file_name == null) {
						if (fileItem.getFieldName().equals("product_name")) {
							proName = fileItem.getString();
						}if (fileItem.getFieldName().equals("product_id")) {
							  proId = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_category")) {
				        	proCategory = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_clr")) {
				        	proClr = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_rate")) {
				        	proRate =fileItem.getString().toString();
				        }if (fileItem.getFieldName().equals("product_description")) {
				        	proDes = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_qty")) {
				        	proQty= fileItem.getString();
				        }
					}
				} else {
					if (fileItem.getSize() > 0) {
						file_name=fileItem.getName();						
						fileItem.write(new File("C:\\Users\\Thiru Raja\\eclipse-workspace\\Inventory\\src\\main\\webapp\\images\\" + fileItem.getName()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter out= response.getWriter();

		Product product = new Product(proName,proCategory,proClr,proId,file_name,proRate,proDes,Integer.parseInt(proQty));
		productDao.insertProduct(product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/viewProduct");
		dispatcher.forward(request, response);


	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listProduct = productDao.listAllProduct();
		request.setAttribute("listProduct", listProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Admin/product/viewProduct.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String proid = request.getParameter("proid");
		Product existingProduct = productDao.getProduct(proid);
		List<Category> categoryList =productDao.listAllCategory();
		request.setAttribute("categoryList", categoryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/Admin/product/editProduct.jsp");
		request.setAttribute("product", existingProduct);
		dispatcher.forward(request, response);


	}
	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String proName = null;
		String proId = null;
		String proCategory = null;
		String proClr = null;
		String proRate =null;
		String proDes=null;
		String proQty=null;
		
		String file_name = null;
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List < FileItem > fields = upload.parseRequest(request);
			Iterator < FileItem > it = fields.iterator();
			if (!it.hasNext()) {
				return;
			}
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (file_name == null) {
						if (fileItem.getFieldName().equals("product_name")) {
							proName = fileItem.getString();
						}if (fileItem.getFieldName().equals("product_id")) {
							  proId = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_category")) {
				        	proCategory = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_clr")) {
				        	proClr = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_rate")) {
				        	proRate =fileItem.getString().toString();
				        }if (fileItem.getFieldName().equals("product_description")) {
				        	proDes = fileItem.getString();
				        }if (fileItem.getFieldName().equals("product_qty")) {
				        	proQty= fileItem.getString();
				        }
					}
				} else {
					if (fileItem.getSize() > 0) {
						file_name=fileItem.getName();						
						fileItem.write(new File("C:\\Users\\Thiru Raja\\eclipse-workspace\\Inventory\\src\\main\\webapp\\images\\" + fileItem.getName()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintWriter out= response.getWriter();

		Product product = new Product(proName,proCategory,proClr,proId,file_name,proRate,proDes,Integer.parseInt(proQty));
		productDao.updateProduct(product);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/viewProduct");
		dispatcher.forward(request, response);

	}
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String proid = request.getParameter("id");
		productDao.deleteProduct(proid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/viewProduct");
		dispatcher.forward(request, response);
		


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
