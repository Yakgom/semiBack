package com.kh.practice.vending;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VendingInsertRun {

    public static void main(String[] args) {

        int result = 0;
        StringBuilder sb = new StringBuilder();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 접속 실패");
        }

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Connection conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01", "KBJ1234");
                Statement stmt = conn.createStatement();
        ) {
            System.out.print("등록할 음료 이름을 입력하세요 > ");
            String drinkName = br.readLine();

            System.out.print("등록할 음료 종류를 입력하세요 > ");
            String drinkType = br.readLine();

            System.out.print("등록할 음료 가격을 입력하세요 > ");
            int price = Integer.parseInt(br.readLine());

            System.out.print("등록할 음료 재고를 입력하세요 > ");
            int stock = Integer.parseInt(br.readLine());

            System.out.print("제조일자를 입력하세요 (YYYY-MM-DD) > ");
            String manuDate = br.readLine();

            System.out.print("유통기한을 입력하세요 (YYYY-MM-DD) > ");
            String expiryDate = br.readLine();

            System.out.print("제조사를 입력하세요 > ");
            String vendor = br.readLine();

            // INSERT SQL 만들기
            sb.append("INSERT INTO TB_VENDING (DRINK_ID, DRINK_NAME, DRINK_TYPE, PRICE, STOCK, MANUFACTURE_DT, EXPIRY_DT, VENDOR) VALUES (");
            sb.append("SEQ_DRINK_ID.nextval,");
            sb.append("'").append(drinkName).append("',");
            sb.append("'").append(drinkType).append("',");
            sb.append(price).append(",");
            sb.append(stock).append(",");
            sb.append("TO_DATE('").append(manuDate).append("','YYYY-MM-DD'),");
            sb.append("TO_DATE('").append(expiryDate).append("','YYYY-MM-DD'),");
            sb.append("'").append(vendor).append("'");
            sb.append(")");

            System.out.println(sb.toString());
            String sql = sb.toString();

            result = stmt.executeUpdate(sql);

            if (result > 0) {
                System.out.println("INSERT 성공");
            } else {
                System.out.println("INSERT 실패");
            }

        } catch (SQLException e) {
            System.out.println("JDBC 또는 SQL 오류 발생");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("BufferedReader 오류");
        } catch (NumberFormatException e) {
            System.out.println("가격과 재고는 숫자로 입력해야 합니다.");
        }
    }
}
