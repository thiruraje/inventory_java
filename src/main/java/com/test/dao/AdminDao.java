package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class AdminDao {
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
	
	public  int loginAdmin(String name,String pass){  
		int result=0;
		try{  
			Connection con=AdminDao.getConnection();  
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
