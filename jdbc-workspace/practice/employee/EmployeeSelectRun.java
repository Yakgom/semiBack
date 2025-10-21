package com.kh.practice.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeSelectRun {

    public static void main(String[] args) {

        ResultSet rset = null;

        StringBuilder sb = new StringBuilder();


        String sql = """
					SELECT
						   EMP_ID
				         , EMP_NAME
				         , EMP_NO
					     , EMAIL
				         , PHONE
				         , DEPT_CODE
				         , JOB_CODE
				         , SAL_LEVEL
				         , SALARY
				         , BONUS
				         , MANAGER_ID
				         , HIRE_DATE
				         , ENT_DATE
				         , ENT_YN
				      FROM
				           Employee



				""";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("클래스 파일 못찾음 ");
        }
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE", "KBJ01",
                "KBJ1234");

             Statement stmt = conn.createStatement();

        ) {

            rset= stmt.executeQuery(sql);

            while(rset.next()) {


                String empId = rset.getString("EMP_ID");
                String empName = rset.getString("EMP_NAME");
                String empNo = rset.getString("EMP_NO");
                String email = rset.getString("EMAIL");
                if(email == null) email = "값이없습니다";
                String phone = rset.getString("PHONE");
                if(phone == null) phone = "값이없습니다";
                String salLevel = rset.getString("SAL_LEVEL");
                if(salLevel == null) salLevel = "값이없습니다";
                int salary = rset.getInt("SALARY");
                int bonus = rset.getInt("BONUS");
                String managerId = rset.getString("MANAGER_ID");
                if(managerId == null) managerId = "값이없습니다";
                Date hireDate = rset.getDate("HIRE_DATE");
                if(hireDate == null) hireDate = new Date(0);
                Date entDate = rset.getDate("ENT_DATE");
                if(entDate == null) entDate = new Date(0);
                char entYn = rset.getString("ENT_YN").charAt(0);



                sb.append(empId);
                sb.append(" | ");
                sb.append(empName);
                sb.append(" | ");
                sb.append(empNo);
                sb.append(" | ");
                sb.append(email);
                sb.append(" | ");
                sb.append(phone);
                sb.append(" | ");
                sb.append(salLevel);
                sb.append(" | ");
                sb.append(salary);
                sb.append(" | ");
                sb.append(bonus);
                sb.append(" | ");
                sb.append(managerId);
                sb.append(" | ");
                sb.append(hireDate);
                sb.append(" | ");
                sb.append(entDate);
                sb.append(" | ");
                sb.append(entYn);
                sb.append("\n");
            }

            System.out.println(sb);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}