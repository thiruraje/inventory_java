package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.model.Category;
import com.test.model.Product;

public class ProductDao {
	
	public List<Category> listAllCategory() throws SQLException {
		List<Category> listCategory = new ArrayList<>();
		Connection con=MySqlConnection.getConnection();

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
	public boolean  insertProduct(Product product) throws SQLException{ 
		Connection con=MySqlConnection.getConnection();  
		String sql = "INSERT INTO product (name, category, color,proId,image,rate,description,qty) VALUES (?, ?, ?,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
//		preparedStatement.setString(1,category);
		preparedStatement.setString(1, product.getProName() );
		preparedStatement.setString(2, product.getProCategory());
		preparedStatement.setString(3, product.getProColor());
		preparedStatement.setString(4, product.getProId());
		preparedStatement.setString(5, product.getProImg());
		preparedStatement.setString(6, product.getProRate());
		preparedStatement.setString(7, product.getProDes());
		preparedStatement.setInt(8, product.getProQty());
		
		
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		con.close();
		return rowInserted;		

	}
	
	public List<Product> listAllProduct() throws SQLException {
		List<Product> listProduct = new ArrayList<>();
		Connection con=MySqlConnection.getConnection();

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
	public static Product getProduct(String proid) throws SQLException {
		Product product = null;
		String sql = "SELECT * FROM product WHERE proId = ?";

		Connection con=MySqlConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, proid);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			String name = resultSet.getString("name");
			String category = resultSet.getString("category");
			String color = resultSet.getString("color");
			String proId = resultSet.getString("proId");
			String image = resultSet.getString("image");
			String rate = resultSet.getString("rate");
			String description = resultSet.getString("description");
			int qty = resultSet.getInt("qty");
			product = new Product(name,category,color,proId,image,rate,description,qty);
		}	         
		resultSet.close();
		preparedStatement.close();

		return product;
	}
	
	public boolean updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET name = ?,category = ?,color = ?,proId = ?,image =?,rate = ?,description = ?, qty = ?";
        sql += " WHERE proId = ?";
        Connection con=MySqlConnection.getConnection();
         
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, product.getProName() );
		preparedStatement.setString(2, product.getProCategory());
		preparedStatement.setString(3, product.getProColor());
		preparedStatement.setString(4, product.getProId());
		preparedStatement.setString(5, product.getProImg());
		preparedStatement.setString(6, product.getProRate());
		preparedStatement.setString(7, product.getProDes());
		preparedStatement.setInt(8, product.getProQty());
		
		preparedStatement.setString(9, product.getProId());
		
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();	
		con.close();
		return rowInserted;     
    }
	
	public boolean deleteProduct(String proid) throws SQLException {
		String sql = "DELETE FROM product where proId = ?";

		Connection con=MySqlConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, proid);

		boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();	
		con.close();
		return rowDeleted;     
	}
	
	

}
