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

import com.test.model.Customer;
import com.test.model.Order;
import com.test.model.Product;
import com.test.model.Shipment;

public class ShippingDao {

	public List<Order> listAllOrders() throws SQLException {
		List<Order> listOrder = new ArrayList<>();
		Connection con=MySqlConnection.getConnection();

		String sql = "SELECT * FROM orders";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery(sql);
		while (resultSet.next()) {
			int orderId = resultSet.getInt("orderId");
			Date date = resultSet.getDate("date");
			String product_id = resultSet.getString("product_id");
			String customer_mobile = resultSet.getString("customer_mobile");
			int qty = resultSet.getInt("qty");
			int amount = resultSet.getInt("amount");
			
			Order order = new Order(customer_mobile,product_id,orderId,qty,amount,date);
			listOrder.add(order);
		}
		resultSet.close();
		preparedStatement.close();
		con.close();         
		return listOrder;
	}
	public static Order getOrder(int id) throws SQLException
	{
		Order order=null;
		Connection con=MySqlConnection.getConnection();
		String sql = "SELECT * FROM orders WHERE orderId = '" +id + "'";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery(sql);
		if (resultSet.next()) {
			int orderId = resultSet.getInt("orderId");
			Date date = resultSet.getDate("date");
			String product_id = resultSet.getString("product_id");
			String customer_mobile = resultSet.getString("customer_mobile");
			int qty = resultSet.getInt("qty");
			int amount = resultSet.getInt("amount");
			
			order = new Order(customer_mobile,product_id,orderId,qty,amount,date);
		}	         
		resultSet.close();
		preparedStatement.close();
		return order;
		
	}
	public static boolean reduceProductQty(String proId,int orderQty) throws SQLException
	{
		Connection con=MySqlConnection.getConnection();
		String sql = "SELECT * FROM product WHERE proId = '" +proId + "'";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery(sql);
		int qty=0;
		int remainQty = 0;
		if (resultSet.next()) {
			qty = resultSet.getInt("qty"); 
		}
		remainQty = qty - orderQty;
		resultSet.close();
		preparedStatement.close();
		String sql1 = "UPDATE product SET qty = ?";
        sql1 += " WHERE proId = ?";
         
        PreparedStatement ps = con.prepareStatement(sql1);
        ps.setInt(1, remainQty );
		ps.setString(2, proId);
		
		boolean productUpated = ps.executeUpdate() > 0;
		ps.close();	
		con.close();		

		return productUpated;
	}
	public static void removeOrder(int order_id) throws SQLException {
		String sql = "DELETE FROM orders where orderId = ?";

		Connection con=MySqlConnection.getConnection();

		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, order_id);

		boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();	
		con.close();
	}
	public static void changeShipment(int id) throws SQLException {
		Random rand = new Random();
		int n = rand.nextInt(90000) + 10000;
		Date shipping_date= new Date(System.currentTimeMillis());
		Connection con=MySqlConnection.getConnection();
		Order order = ShippingDao.getOrder(id);
		
		String sql = "INSERT INTO shipment (shipment_id,orderId,date,customer_mobile,product_id,qty,amount,shipment_date) "
				+ "VALUES ('" + n +"','" + id +"','" + order.getDate() +"','" + order.getCustomerMobile() +"',"
						+ "'" + order.getProductId() +"','" + order.getQty() +"','" + order.getAmount() +"','" + shipping_date +"')";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	
	}
	public boolean shipping(int order_id) throws SQLException {
		
		Connection con=MySqlConnection.getConnection();
		Order order = ShippingDao.getOrder(order_id);
//		System.out.println(order.getAmount());
		boolean result = ShippingDao.reduceProductQty(order.getProductId(),order.getQty());
		if(result) {
			ShippingDao.changeShipment(order_id);
			ShippingDao.removeOrder(order_id);
			return true;
		}else {
			return false;
		}	         
	}
	
	public List<Shipment> listAllShipment() throws SQLException {
		List<Shipment> listShipment = new ArrayList<>();
		Connection con=MySqlConnection.getConnection();

		String sql = "SELECT * FROM shipment";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery(sql);
		while (resultSet.next()) {
			int shipment_id = resultSet.getInt("shipment_id");
			int orderId = resultSet.getInt("orderId");
			Date date = resultSet.getDate("date");
			String product_id = resultSet.getString("product_id");
			String customer_mobile = resultSet.getString("customer_mobile");
			
			int qty = resultSet.getInt("qty");
			int amount = resultSet.getInt("amount");
			Date shipped_date = resultSet.getDate("shipment_date");
			
			Shipment sh = new Shipment(shipment_id,orderId,date,customer_mobile,product_id,qty,amount,shipped_date);
			listShipment.add(sh);
		}
		resultSet.close();
		preparedStatement.close();
		con.close();         
		return listShipment;
	}
	
	public Shipment getShipment(int shipid) throws SQLException {
		Shipment shipment = null;
		String sql = "SELECT * FROM shipment WHERE shipment_id = ?";
		Connection con=MySqlConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, shipid);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			int shipment_id = resultSet.getInt("shipment_id");
			int orderId = resultSet.getInt("orderId");
			Date date = resultSet.getDate("date");
			String product_id = resultSet.getString("product_id");
			String customer_mobile = resultSet.getString("customer_mobile");
			int qty = resultSet.getInt("qty");
			int amount = resultSet.getInt("amount");
			Date shipped_date = resultSet.getDate("shipment_date");
			shipment = new Shipment(shipment_id,orderId,date,customer_mobile,product_id,qty,amount,shipped_date);
		}	         
		resultSet.close();
		preparedStatement.close();
		return shipment;
	}
}
