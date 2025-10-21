package com.kh.practice.employee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;

public class EmployeeInsertRun {

    public static void main(String[] args) {

        int result = 0;

        StringBuilder sb= new StringBuilder();


        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 접속실패");
        }

        try (
                BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
                Connection conn = DriverManager
                        .getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE" , "KBJ01" , "KBJ1234");




                Statement stmt = conn.createStatement();

        ) {
            System.out.print("등록할 사원의 이름을 입력하세요 > ");
            String empName = br.readLine();

            System.out.print("등록할 사원의 주민등록번호를 입력하세요 > ");
            String empNo = br.readLine();

            System.out.print("등록할 사원의 이메일을 입력하세요 > ");
            String email = br.readLine();

            System.out.print("등록할 사원의 전화번호를 입력하세요 > ");
            String phone = br.readLine();

            System.out.print("등록할 사원의 부서 코드를 입력해주세요 > ");
            String deptCode = br.readLine();

            System.out.print("등록할 사원의 직급 코드를 입력해주세요 > ");
            String jobCode = br.readLine();

            System.out.print("등록할 사원의 급여 등급을 입력해주세요 > ");
            String salLevel = br.readLine();

            System.out.print("등록할 사원의 월급을 입력해주세요 > ");
            int salary = Integer.parseInt(br.readLine());

            System.out.print("등록할 사원의 보너스를 입력해주세요 > ");
            double bonus = Double.parseDouble(br.readLine());

            System.out.print("등록할 사원의 상사 사번을 입력해주세요 > ");
            String managerId = br.readLine();



            System.out.println("등록하는 사원임으로 입사일자는 오늘로 퇴사일자는x 재직여부는 Y로 자동으로 등록됩니다.");


            sb.append("Insert INTO EMPLOYEE( EMP_ID," +
                    " EMP_NAME," +
                    "EMP_NO," +
                    "EMAIL," +
                    "PHONE," +
                    "DEPT_CODE," +
                    "JOB_CODE," +
                    "SAL_LEVEL," +
                    "SALARY," +
                    "BONUS," +
                    "MANAGER_ID," +
                    "HIRE_DATE," +
                    "ENT_DATE," +
                    "ENT_YN) VALUES ( ");
            sb.append("TO_CHAR(SEQ_EID.nextval),");
            sb.append("'"+empName+"' ,");
            sb.append("'"+empNo+"' ,");
            sb.append("'"+email+"' ,");
            sb.append("'"+phone+"' ,");
            sb.append("'"+deptCode+"' ,");
            sb.append("'"+jobCode+"' ,");
            sb.append("'"+salLevel+"' ,");
            sb.append(salary+",");
            sb.append(bonus+",");
            sb.append("'"+managerId+"' ,");
            sb.append("SYSDATE ,");
            sb.append("NULL ,");
            sb.append("'N'");
            sb.append(")");
            System.out.println(sb.toString());
            String sql = sb.toString();


            result = stmt.executeUpdate(sql);

            if(result > 0) {

                System.out.println("insert 성공");

            }else{
                System.out.println("insert 실패");
            }



        } catch (SQLException e) {
            System.out.println("jdbc:oracle:thin을 제대로 입력하거나 아이디 비번을 확인해주세요");
            e.printStackTrace();
        } catch(IOException e){
            System.out.println("BufferedReader오류");
        } catch (InputMismatchException e){
            System.out.println("사원의 월급과 보너스는 숫자로만 넣어주세요.");
        }

    }

}