package com.kh.model.dao;

import com.kh.model.vo.Vending;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendingDao {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public int save(Vending vending) {

        int result = 0;

        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01", "KBJ1234");
                Statement stmt = conn.createStatement()

        ) {
                String sql = "INSERT INTO TB_VENDING VALUES (" +"SEQ_DRINK_ID.nextval,'" +vending.getDrinkName() +"', '" + vending.getDrinkType() +"'," + vending.getPrice() + ","
                                                        + vending.getStock() +", '" + vending.getManufactureDate()+"' , '" + vending.getExpiryDate() +"' , '" + vending.getVendor() +"')";
                result = stmt.executeUpdate(sql);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Vending> findAll() {
        List<Vending> vendings = new ArrayList<>();

        String sql = "SELECT DRINK_ID, DRINK_NAME, DRINK_TYPE,PRICE,STOCK,MANUFACTURE_DT,EXPIRY_DT,VENDOR FROM TB_VENDING ORDER BY DRINK_ID";


       try(
               Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01", "KBJ1234");
               Statement stmt = conn.createStatement();
               ResultSet rset = stmt.executeQuery(sql)
       ){

                while(rset.next()){
                    vendings.add(new Vending(rset.getInt("DRINK_ID"),rset.getString("DRINK_NAME"),rset.getString("DRINK_TYPE"),rset.getInt("PRICE"),
                                             rset.getInt("STOCK"),rset.getDate("MANUFACTURE_DT"),rset.getDate("EXPIRY_DT"),rset.getString("VENDOR")));


                }


       }catch (SQLException e){
           e.printStackTrace();
       }

        return vendings;
    }

    public Vending findByName(String drinkName) {

        String sql = "SELECT  DRINK_ID, DRINK_NAME, DRINK_TYPE,PRICE,STOCK,MANUFACTURE_DT,EXPIRY_DT,VENDOR FROM TB_VENDING WHERE DRINK_Name = '" + drinkName + "'" ;
        Vending vending = null;

        try(
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01", "KBJ1234");
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery(sql)
        ){

            if(rset.next()) {
                vending = new Vending(rset.getInt("DRINK_ID"), rset.getString("DRINK_NAME"), rset.getString("DRINK_TYPE"), rset.getInt("PRICE"),
                        rset.getInt("STOCK"), rset.getDate("MANUFACTURE_DT"), rset.getDate("EXPIRY_DT"), rset.getString("VENDOR"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vending;

    }

    public List<Vending> findByKeyword(String vender) {
        List<Vending> vendings = new ArrayList<>();

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
                             VENDOR LIKE """;
        sql += "'%"+vender +"%'";

        try(
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01", "KBJ1234");
                Statement stmt = conn.createStatement();
                ResultSet rset = stmt.executeQuery(sql)
        ){

            while(rset.next()) {
                vendings.add(new Vending(rset.getInt("DRINK_ID"),rset.getString("DRINK_NAME"),rset.getString("DRINK_TYPE"),rset.getInt("PRICE"),
                        rset.getInt("STOCK"),rset.getDate("MANUFACTURE_DT"),rset.getDate("EXPIRY_DT"),rset.getString("VENDOR")));


            }


        }catch (SQLException e){
            e.printStackTrace();
        }

    return vendings;
    }


    }
