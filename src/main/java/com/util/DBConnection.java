package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	
	

	private static String userName ="ufqsynfehiohsm";
	private static String password ="89024f0f73e93dc85c419deed3519cc85c6b9200864db154796c7e9a1fb5be98";
	private static String connectionURL ="jdbc:postgresql://ec2-52-202-22-140.compute-1.amazonaws.com:5432/d4bpgdc56cgosa?sslmode=require";
	private static String driverClass = "org.postgresql.Driver";
	public static Connection getDBConnection(){
		
		Connection conn = null;
		
		try {
			Class.forName(driverClass);
			
			conn = DriverManager.getConnection(connectionURL, userName, password);
			
			if(conn!=null)
			{
				
				System.out.println("connected to db..");
			}
			else{
				
				System.out.println("connected to db..");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn; 
		
		
	}
	
	
	public static void main(String[] args) {
		
		DBConnection.getDBConnection();
	}
	
}
