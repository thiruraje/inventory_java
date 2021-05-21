package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
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

}
