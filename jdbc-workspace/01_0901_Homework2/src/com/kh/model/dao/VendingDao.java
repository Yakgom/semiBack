package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.model.dto.VendingDTO;
import com.kh.model.vo.Vending;

public class VendingDao {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private final String URL ="jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "KBJ01";
	private final String PASSWORD = "KBJ1234";
    

    public int save(Vending vending) {
    	
    	
    	
    	
    	int result = 0;
    	
    	String sql ="""
    				   INSERT
    				     INTO
    				          TB_VENDING
    				          (
    				          DRINK_ID
    				        , DRINK_NAME
    				        , DRINK_TYPE
    				        , PRICE
    				        , STOCK
    				        , MANUFACTURE_DT
    				        , EXPIRY_DT
    				        , VENDOR
    				        )
    				   VALUES
    				          (
    				          SEQ_DRINK_ID.NEXTVAL
    				        , ?
    				        , ?
    				        , ?
    				        , ?
    				        , ?
    				        , ?
    				        , ? 
    				          )     
    			    """;
    	
    	
    	try(
    			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement pstmt = conn.prepareStatement(sql)
    			
    			){
    		
    		
    		
    			pstmt.setString(1,vending.getDrinkName());
    			pstmt.setString(2, vending.getDrinkType());
    			pstmt.setInt(3, vending.getPrice());
    			pstmt.setInt(4, vending.getStock());
    			pstmt.setDate(5, vending.getManufactureDate());
    			pstmt.setDate(6, vending.getExpiryDate());
    			pstmt.setString(7, vending.getVendor());
    			
    			
    			
    		
    			result = pstmt.executeUpdate();
    			
    			
    		
    		
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return result;
    	
    }
    
    public List<Vending> findAll(){
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	
    	
    	List<Vending> vendings = new ArrayList<Vending>();
    	
    	String sql = """
    				    SELECT
    				           DRINK_ID
    				         , DRINK_NAME
    				         , DRINK_TYPE
    				         , PRICE
    				         , STOCK
    				         , MANUFACTURE_DT
    				         , EXPIRY_DT
    				         , VENDOR
    				      FROM
    				           TB_VENDING 
    				     ORDER
    				        BY
    				           MANUFACTURE_DT DESC          
    			     """;
    	
    	
    	try {
    		
    		conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    		pstmt = conn.prepareStatement(sql);
    		
    		rset = pstmt.executeQuery();
    		
    		
    		while(rset.next()) {
    			
    			vendings.add(new Vending(
    						rset.getInt("DRINK_ID")
    					   ,rset.getString("DRINK_NAME")
    					   ,rset.getString("DRINK_TYPE")
    					   ,rset.getInt("PRICE")
    					   ,rset.getInt("STOCK")
    					   ,rset.getDate("MANUFACTURE_DT")
    					   ,rset.getDate("EXPIRY_DT")
    					   ,rset.getString("VENDOR")
    					   ));    			
    		}
    		
    		
    		
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		
    		
    		try {
    			if(rset!=null) {
				rset.close();
    			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
    		try {
    			if(pstmt!=null) {
				pstmt.close();
    			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
    		try {
    			if(conn!=null) {
				conn.close();
    			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
 
    return 	vendings;
    	
    }
    
    public Vending findByName(String drinkName) {
    	
    	Vending vending = new Vending();
    	ResultSet rset = null;
    	
    	
    	String sql = """
    					SELECT
    					       DRINK_ID
    					     , DRINK_NAME
    					     , DRINK_TYPE
    					     , PRICE
    					     , STOCK
    					     , MANUFACTURE_DT
    					     , EXPIRY_DT
    					     , VENDOR
    					  FROM
    					       TB_VENDING
    					 WHERE
    					       DRINK_NAME = ?      

    			     """;
    	
    	try(
    			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			
    			){
    		
    			pstmt.setString(1, drinkName);
    			
    			rset = pstmt.executeQuery();
    			
    			if(rset.next()) {
    				
    				vending = new Vending(
    						   rset.getInt("DRINK_ID")
    						  ,rset.getString("DRINK_NAME")
    						  ,rset.getString("DRINK_TYPE")
    						  ,rset.getInt("PRICE")
    						  ,rset.getInt("STOCK")
    						  ,rset.getDate("MANUFACTURE_DT")
    						  ,rset.getDate("EXPIRY_DT")
    						  ,rset.getString("VENDOR")
    						);		
    			}
    			
    		
    	} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {if(rset!=null) {
				rset.close();
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
    	
    	
    	return vending;
    }
    
    public List<Vending> findByKeyword(String vendor){
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rset = null;
    	
    	List<Vending> vendings = new ArrayList<Vending>();
    	
    	String sql = """
    				 SELECT
    				       	DRINK_ID
    				      ,	DRINK_NAME
    				      , DRINK_TYPE
    				      , PRICE
    				      , STOCK
    				      , MANUFACTURE_DT
    				      , EXPIRY_DT
    				      , VENDOR
    				   FROM
    				        TB_VENDING
    				  WHERE
    				        VENDOR LIKE '%'||?||'%' 
    				  ORDER     
    				     BY
    				        MANUFACTURE_DT                	
    			     """;
    	try {
    			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			pstmt = conn.prepareStatement(sql);
    			
    			pstmt.setString(1, vendor);
    			
    			rset = pstmt.executeQuery();
    		
    			
    			while(rset.next()) {
    				
    				vendings.add(new Vending(
    						     rset.getInt("DRINK_ID")
    						   , rset.getString("DRINK_NAME")
    						   , rset.getString("DRINK_TYPE")
    						   , rset.getInt("PRICE")
    						   , rset.getInt("STOCK")
    						   , rset.getDate("MANUFACTURE_DT")
    						   , rset.getDate("EXPIRY_DT")
    						   , rset.getString("VENDOR")
    						    ));
    			}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		
    		try {
    			if(rset!=null) {
				rset.close();
    			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
    		try {
    			if(pstmt!=null) {
    				pstmt.close();
    			}
    			}catch(SQLException e) {
    				e.printStackTrace();
    			}
    			
    		}
    		
    	return vendings;
    	
    }
    
    public int update(VendingDTO vd) {
    	int result =0;
    	
    	String sql = """
    					UPDATE
    					       TB_VENDING
    					   SET
    					       STOCK = ?
    					 WHERE         
    					       DRINK_NAME =?
    			     """;
    	
    	try(
    			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			
    			){
    		
    		
    			pstmt.setInt(1, vd.getChangeStock());
    			pstmt.setString(2, vd.getDrinkName());
    			
    			
    			result = pstmt.executeUpdate();
    		
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return result;
    }
    
    public int delete(String drinkName , String vendor) {
    	
    	int result =0;
    	
    	String sql = """
    				 DELETE
    				   FROM
    				        TB_VENDING
    				  WHERE
    				        DRINK_NAME = ?
    				    AND
    				        VENDOR = ?          
    			     """;
    	
    	try(
    			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			
    			){
    		
    		
    			pstmt.setString(1, drinkName);
    			pstmt.setString(2, vendor);
    			
    			result = pstmt.executeUpdate();
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return result;
    }


    }
