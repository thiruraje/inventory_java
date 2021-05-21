package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.test.model.Customer;

public class CustomerDao {
	
	public  boolean registerCustomer(Customer cus){ 
		boolean rowInserted =false;

		try{  
			Connection con=MySqlConnection.getConnection();  
			PreparedStatement ps=con.prepareStatement("INSERT INTO customer (name, mobile, address,password) VALUES (?, ?, ?,?)");
			ps.setString(1, cus.getCusName() );
			ps.setString(2, cus.getCusMobile());
			ps.setString(3, cus.getCusAddress());
			ps.setString(4, cus.getCusPass());
			PreparedStatement ps1=con.prepareStatement("SELECT * FROM customer WHERE mobile='" + cus.getCusMobile() + "' ");  
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				rowInserted = false;
			}else {
				rowInserted = true;
				rowInserted = ps.executeUpdate() > 0;
			}
			ps.close();
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return rowInserted;  
		
	}
	public  Customer loginCustomer(String name,String pass){  
		Customer cus =null;
		try{  
			Connection con=MySqlConnection.getConnection();  
			PreparedStatement ps=con.prepareStatement("SELECT * FROM customer WHERE name='" + name + "' and password='" + pass + "'");  
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String name1 = rs.getString("name");
				String mobile = rs.getString("mobile");
				String address = rs.getString("address");
				String pass1 = rs.getString("password");
				cus=new Customer(name1,address,mobile,pass1);
			}
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  
		
		return cus;

	}
	

}
