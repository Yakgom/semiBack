package com.kh.practice.vending;

import java.sql.*;

public class VendingSelectRun {
    public static void main(String[] args) {

        ResultSet rset = null;
        StringBuilder sb = new StringBuilder();

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
                FROM TB_VENDING
                """;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01", "KBJ1234");
                Statement stmt = conn.createStatement();
        ) {
            rset = stmt.executeQuery(sql);

            while (rset.next()) {
                // NOT NULL 컬럼은 null 체크 생략
                int drinkId = rset.getInt("DRINK_ID");
                String drinkName = rset.getString("DRINK_NAME");
                String drinkType = rset.getString("DRINK_TYPE");
                int price = rset.getInt("PRICE");
                int stock = rset.getInt("STOCK");
                Date manuDate = rset.getDate("MANUFACTURE_DT");
                String vendor = rset.getString("VENDOR");

                // NULL 가능 컬럼만 체크
                Date expiryDate = rset.getDate("EXPIRY_DT");
                if (expiryDate == null) expiryDate = new Date(0);

                // StringBuilder에 포맷팅
                sb.append(drinkId).append(" | ")
                        .append(drinkName).append(" | ")
                        .append(drinkType).append(" | ")
                        .append(price).append(" | ")
                        .append(stock).append(" | ")
                        .append(manuDate).append(" | ")
                        .append(expiryDate).append(" | ")
                        .append(vendor).append("\n");
            }

            // 출력
            System.out.println(sb);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

