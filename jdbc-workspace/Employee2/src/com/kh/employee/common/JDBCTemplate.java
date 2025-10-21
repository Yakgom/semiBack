package com.kh.employee.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	public static void registDriver() {

		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			Class.forName(prop.getProperty("DRIVER"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		Properties prop = new Properties();
		
		
		try {
			
			
			prop.load(new FileInputStream("resources/driver.properties"));
			
			//String keyA = prop.getProperty("A");
			
			//System.out.println("A키값의 vaule : " + keyA);
			
			//System.out.println(prop.getProperty("URL"));
			
			
			
			Connection conn = DriverManager.getConnection(prop.getProperty("URL"),prop.getProperty("USERNAME"),prop.getProperty("PASSWORD"));

			conn.setAutoCommit(false);

			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}
	

	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null) {
			conn.commit();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static void rollack(Connection conn) {
		
		
		try {
			if(conn != null) {
			conn.rollback();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	public static void close(Connection conn) {
		
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void close(Statement stmt) {
		
		try {
			
			if(stmt != null) {
				stmt.close();
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rset) {
		
		try {
			
			if(rset!=null) {
				rset.close();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
