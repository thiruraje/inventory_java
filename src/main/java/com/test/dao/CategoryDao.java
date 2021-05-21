package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.model.Category;

public class CategoryDao {
	public boolean  insertCategory(String category) throws SQLException{ 
		Connection con=MySqlConnection.getConnection();  
		String sql = "INSERT INTO category (category_name) VALUES (?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,category);
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		con.close();
		return rowInserted;		

	}

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
	public Category getCategory(int id) throws SQLException {
		Category category = null;
		String sql = "SELECT * FROM category WHERE id = ?";

		Connection con=MySqlConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			String category_name = resultSet.getString("category_name");
			category = new Category(id, category_name);
		}	         
		resultSet.close();
		preparedStatement.close();

		return category;
	}
	public boolean updateCategory(Category category) throws SQLException {
		String sql = "UPDATE category SET category_name = ?";
		sql += " WHERE id = ?";
		Connection con=MySqlConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,category.getCategory_name());
		preparedStatement.setInt(2, category.getId());
		boolean rowInserted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();	
		con.close();
		return rowInserted;     
	}
	public boolean deleteCategory(int id) throws SQLException {
		String sql = "DELETE FROM category where id = ?";

		Connection con=MySqlConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();	
		con.close();
		return rowDeleted;     
	}

}
