package com.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.test.model.Category;
import com.test.model.Customer;
import com.test.model.Product;

public class OrderDao {
	public static Connection getConnection(){  
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		// Database name to access
		String dbName = "inventory";
		String dbUsername = "root";
		String dbPassword = "";
		Connection con=null;  
		try{  
			Class.forName(dbDriver).newInstance();
			con= DriverManager
					.getConnection(dbURL + dbName,
							dbUsername, 
							dbPassword);  
		}catch(Exception e){System.out.println(e);}  
		return con;  
	}
	
	public List<Category> listAllCategory() throws SQLException {
		List<Category> listCategory = new ArrayList<>();
		Connection con=OrderDao.getConnection();

		String sql = "SELECT * FROM category";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String category_name = resultSet.getString("category_name");

			Category category = new Category(id, category_name);
			listCategory.add(category);
		}

		resultSet.close();
		preparedStatement.close();
		con.close();         
		return listCategory;
	}
	public List<Product> listAllProduct()throws SQLException {
		List<Product> listProduct = new ArrayList<>();
		Connection con=OrderDao.getConnection();

		String sql = "SELECT * FROM product";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery(sql);

		while (resultSet.next()) {
			String name = resultSet.getString("name");
			String category = resultSet.getString("category");
			String color = resultSet.getString("color");
			String proId = resultSet.getString("proId");
			String image = resultSet.getString("image");
			String rate = resultSet.getString("rate");
			String description = resultSet.getString("description");
			int qty = resultSet.getInt("qty");
			Product product = new Product(name,category,color,proId,image,rate,description,qty);
			listProduct.add(product);
		}

		resultSet.close();
		preparedStatement.close();
		con.close();         
		return listProduct;
	}
	
	public boolean  insertOrder(Customer cus,String proId,int qty) throws SQLException{ 
		Random rand = new Random();
		int n = rand.nextInt(90000) + 10000;
		Date date= new Date(System.currentTimeMillis());
		Connection con=ProductDao.getConnection(); 
		
		PreparedStatement ps = con.prepareStatement("SELECT rate from product WHERE proId ='" + proId +"'");
		ResultSet resultSet = ps.executeQuery();
		System.out.println(resultSet);
		int totalAmt =0;
		if(resultSet.next()) {
			totalAmt = Integer.parseInt(resultSet.getString("rate")) * qty;
		}
		System.out.println(totalAmt);
 
		String sql = "INSERT INTO orders (orderId,date,customer_mobile,product_id,qty,amount) "
				+ "VALUES ('" + n +"','" + date +"','" + cus.getCusMobile() +"','" + proId +"','" + qty +"','" + totalAmt +"')";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		
		
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		con.close();
		return rowInserted;		

	}

}
