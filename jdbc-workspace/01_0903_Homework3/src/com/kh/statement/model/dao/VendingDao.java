package com.kh.statement.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.kh.statement.model.vo.Vending;
import com.kh.statement.model.dto.VendingDTO;
import static com.kh.common.JDBCTemplate.close;

public class VendingDao {

    public int save(Connection conn, Vending vending) {
        String sql = """
            INSERT INTO TB_VENDING(
                DRINK_ID, DRINK_NAME, DRINK_TYPE, PRICE, STOCK, MANUFACTURE_DT, EXPIRY_DT, VENDOR
            ) VALUES (
                SEQ_DRINK_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?
            )
        """;
        int result = 0;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vending.getDrinkName());
            pstmt.setString(2, vending.getDrinkType());
            pstmt.setInt(3, vending.getPrice());
            pstmt.setInt(4, vending.getStock());
            pstmt.setDate(5, vending.getManufactureDate());
            pstmt.setDate(6, vending.getExpiryDate());
            pstmt.setString(7, vending.getVendor());
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }

    public List<Vending> findAll(Connection conn) {
        List<Vending> vendings = new ArrayList<>();
        String sql = "SELECT * FROM TB_VENDING ORDER BY MANUFACTURE_DT DESC";
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            while(rset.next()) {
                vendings.add(new Vending(
                        rset.getInt("DRINK_ID"),
                        rset.getString("DRINK_NAME"),
                        rset.getString("DRINK_TYPE"),
                        rset.getInt("PRICE"),
                        rset.getInt("STOCK"),
                        rset.getDate("MANUFACTURE_DT"),
                        rset.getDate("EXPIRY_DT"),
                        rset.getString("VENDOR")
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return vendings;
    }

    public Vending findByName(Connection conn, String drinkName) {
        String sql = "SELECT * FROM TB_VENDING WHERE DRINK_NAME = ?";
        Vending vending = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, drinkName);
            rset = pstmt.executeQuery();
            if(rset.next()) {
                vending = new Vending(
                        rset.getInt("DRINK_ID"),
                        rset.getString("DRINK_NAME"),
                        rset.getString("DRINK_TYPE"),
                        rset.getInt("PRICE"),
                        rset.getInt("STOCK"),
                        rset.getDate("MANUFACTURE_DT"),
                        rset.getDate("EXPIRY_DT"),
                        rset.getString("VENDOR")
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        return vending;
    }

    public List<Vending> findByKeyword(Connection conn, String vendor) {
        List<Vending> vendings = new ArrayList<>();
        String sql = "SELECT * FROM TB_VENDING WHERE VENDOR LIKE '%'||?||'%' ORDER BY MANUFACTURE_DT";
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vendor);
            rset = pstmt.executeQuery();
            while(rset.next()) {
                vendings.add(new Vending(
                        rset.getInt("DRINK_ID"),
                        rset.getString("DRINK_NAME"),
                        rset.getString("DRINK_TYPE"),
                        rset.getInt("PRICE"),
                        rset.getInt("STOCK"),
                        rset.getDate("MANUFACTURE_DT"),
                        rset.getDate("EXPIRY_DT"),
                        rset.getString("VENDOR")
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return vendings;
    }

    public int update(Connection conn, VendingDTO vd) {
        String sql = "UPDATE TB_VENDING SET STOCK = ? WHERE DRINK_NAME = ?";
        int result = 0;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vd.getChangeStock());
            pstmt.setString(2, vd.getDrinkName());
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int delete(Connection conn, String drinkName, String vendor) {
        String sql = "DELETE FROM TB_VENDING WHERE DRINK_NAME = ? AND VENDOR = ?";
        int result = 0;
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, drinkName);
            pstmt.setString(2, vendor);
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

}