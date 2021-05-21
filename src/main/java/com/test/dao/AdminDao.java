package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class AdminDao {
	
	
	public  int loginAdmin(String name,String pass){  
		int result=0;
		try{  
			Connection con=MySqlConnection.getConnection();  
			PreparedStatement ps=con.prepareStatement("SELECT * FROM admin WHERE username='" + name + "' and password='" + pass + "'");  
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result= 1;
			}else {
				result=  0;
			}
			con.close();  
		}catch(Exception ex){ex.printStackTrace();}  
		
		return result;

	}

}
