package com.kh.practice.plant;

import java.sql.*;

public class PlantSelectRun {
    public static void main(String[] args) {

        ResultSet rset = null;
        StringBuilder sb = new StringBuilder();

        String sql = """
                SELECT
                	   PLANT_ID
                	 , PLANT_NAME
                	 , PLANT_TYPE
                	 , PLANT_HEIGHT
                	 , PLANT_DATE
                	 , PLANT_LOCATION
                FROM TB_PLANT
                """;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (

                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000", "KBJ01", "KBJ1234");
                Statement stmt = conn.createStatement();

        ) {
            rset = stmt.executeQuery(sql);

            while (rset.next()) {
                int plantId = rset.getInt("PLANT_ID");
                String plantName = rset.getString("PLANT_NAME");
                if (plantName == null) plantName = "값이없습니다";

                String plantType = rset.getString("PLANT_TYPE");
                if (plantType == null) plantType = "값이없습니다";

                int plantHeight = rset.getInt("PLANT_HEIGHT");

                Date plantDate = rset.getDate("PLANT_DATE");
                if (plantDate == null) plantDate = new Date(0);

                String plantLocation = rset.getString("PLANT_LOCATION");
                if (plantLocation == null) plantLocation = "값이없습니다";

                // 4. StringBuilder에 포맷팅
                sb.append(plantId).append(" | ")
                        .append(plantName).append(" | ")
                        .append(plantType).append(" | ")
                        .append(plantHeight).append(" | ")
                        .append(plantDate).append(" | ")
                        .append(plantLocation).append("\n");
            }

            // 5. 출력
            System.out.println(sb);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
