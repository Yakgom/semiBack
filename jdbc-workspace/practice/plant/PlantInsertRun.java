package com.kh.practice.plant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PlantInsertRun {

    public static void main(String[] args) {

        int result = 0;
        StringBuilder sb = new StringBuilder();

        try {
            // 1. 드라이버 로딩
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 접속실패");
        }

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Connection conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01", "KBJ1234");
                Statement stmt = conn.createStatement();
        ) {

            // 2. 사용자 입력
            System.out.print("등록할 식물 이름을 입력하세요 > ");
            String plantName = br.readLine();

            System.out.print("식물 종류를 입력해주세요 > ");
            String plantType = br.readLine();

            System.out.print("식물 높이(cm)를 입력해주세요 > ");
            int plantHeight = Integer.parseInt(br.readLine());

            System.out.print("식물 위치를 입력해주세요 > ");
            String plantLocation = br.readLine();

            System.out.println("식물 등록일은 자동으로 오늘 날짜로 입력됩니다.");

            // 3. SQL 구성
            sb.append("INSERT INTO TB_PLANT (PLANT_ID, PLANT_NAME, PLANT_TYPE, PLANT_HEIGHT, PLANT_DATE, PLANT_LOCATION) VALUES (");
            sb.append("SEQ_PLANT_ID.nextval,");
            sb.append("'").append(plantName).append("' ,");
            sb.append("'").append(plantType).append("' ,");
            sb.append(plantHeight).append(" ,");
            sb.append("SYSDATE ,");
            sb.append("'").append(plantLocation).append("'");
            sb.append(")");

            System.out.println("실행할 SQL: " + sb.toString());

            // 4. 실행
            result = stmt.executeUpdate(sb.toString());

            if (result > 0) {
                System.out.println("INSERT 성공");
            } else {
                System.out.println("INSERT 실패");
            }

        } catch (SQLException e) {
            System.out.println("jdbc:oracle:thin을 제대로 입력하거나 아이디/비밀번호를 확인해주세요");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("BufferedReader 오류");
        } catch (NumberFormatException e) {
            System.out.println("식물 높이는 숫자로만 입력해주세요.");
        }

    }
}
