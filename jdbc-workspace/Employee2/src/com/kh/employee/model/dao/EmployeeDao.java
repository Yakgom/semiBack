package com.kh.employee.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.employee.common.JDBCTemplate;
import com.kh.employee.model.dto.EmployeeDTO;
import com.kh.employee.model.vo.Employee;

public class EmployeeDao {

	private Properties prop = new Properties();

	public EmployeeDao() {

		try {
			prop.loadFromXML(new FileInputStream("resources/employee-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Employee> findAll(Connection conn) {

		List<Employee> employees = new ArrayList();

		String sql = prop.getProperty("findAll");

		try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rset = pstmt.executeQuery();) {

			while (rset.next()) {

				Employee employee = new Employee(rset.getString("EMP_ID"), rset.getString("EMP_NAME"),
						rset.getInt("SALARY"), rset.getString("DEPT_TITLE"), rset.getString("JOB_NAME"));

				employees.add(employee);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;

	}

	public List<Employee> findByDept(Connection conn, String deptTitle) {

		List<Employee> employees = new ArrayList();

		String sql = prop.getProperty("findByDept");
		ResultSet rset = null;

		try (PreparedStatement pstmt = conn.prepareStatement(sql);

		) {

			pstmt.setString(1, deptTitle);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Employee employee = new Employee(rset.getString("EMP_ID"), rset.getString("EMP_NAME"),
						rset.getInt("SALARY"), rset.getString("DEPT_TITLE"), rset.getString("JOB_NAME"));

				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);

		}

		return employees;

	}

	public List<Employee> findByJob(Connection conn, String jobName) {

		List<Employee> employees = new ArrayList();

		String sql = prop.getProperty("findByJob");
		ResultSet rset = null;

		try (PreparedStatement pstmt = conn.prepareStatement(sql);

		) {

			pstmt.setString(1, jobName);
			rset = pstmt.executeQuery();

			while (rset.next()) {

				Employee employee = new Employee(rset.getString("EMP_ID"), rset.getString("EMP_NAME"),
						rset.getInt("SALARY"), rset.getString("DEPT_TITLE"), rset.getString("JOB_NAME"));

				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);

		}

		return employees;

	}

	public Employee findById(Connection conn, String empId) {

		Employee employee = new Employee();
		String sql = prop.getProperty("findById");
		ResultSet rset = null;

		try (PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			pstmt.setString(1, empId);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				employee = new Employee(rset.getString("EMP_ID"), rset.getString("EMP_NAME"), rset.getString("EMP_NO"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("DEPT_CODE"),
						rset.getString("JOB_CODE"), rset.getString("SAL_LEVEL"), rset.getInt("SALARY"),
						rset.getDouble("BONUS"), rset.getString("MANAGER_ID"), rset.getDate("HIRE_DATE"),
						rset.getDate("ENT_DATE"), rset.getString("ENT_YN"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
		}
		return employee;

	}

	public List<Employee> findByHighSalary(Connection conn){
		
		List<Employee> employees = new ArrayList<Employee>();
		
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("findByHighSalary");
		
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				
				){
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					
					Employee employee = new Employee(		
							rset.getString("EMP_ID")
						  , rset.getString("EMP_NAME")
						  , rset.getString("EMP_NO")
						  , rset.getString("EMAIL")
						  , rset.getString("PHONE")
						  , rset.getString("DEPT_CODE")
						  , rset.getString("JOB_CODE")
						  , rset.getString("SAL_LEVEL")
						  , rset.getInt("SALARY")
						  , rset.getDouble("BONUS")
						  , rset.getString("MANAGER_ID")
						  , rset.getDate("HIRE_DATE")
						  , rset.getDate("ENT_DATE")
						  , rset.getString("ENT_YN")
							);
					
					employees.add(employee);
					
				}
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
		}
		return employees;
		
		
		
		
	}
	
	public List<Employee> findByLowSalary(Connection conn){
		
		List<Employee> employees = new ArrayList<Employee>();
		
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("findByLowSalary");
		
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				
				){
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					
					Employee employee = new Employee(		
							rset.getString("EMP_ID")
						  , rset.getString("EMP_NAME")
						  , rset.getString("EMP_NO")
						  , rset.getString("EMAIL")
						  , rset.getString("PHONE")
						  , rset.getString("DEPT_CODE")
						  , rset.getString("JOB_CODE")
						  , rset.getString("SAL_LEVEL")
						  , rset.getInt("SALARY")
						  , rset.getDouble("BONUS")
						  , rset.getString("MANAGER_ID")
						  , rset.getDate("HIRE_DATE")
						  , rset.getDate("ENT_DATE")
						  , rset.getString("ENT_YN")
							);
					
					employees.add(employee);
					
				}
		}
		catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
		}
		return employees;
		
		
		
		
	}
	
	
	public int save(Connection conn , Employee employee) {
		
		int result = 0;
		
		String sql = prop.getProperty("save");
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
					pstmt.setString(1,employee.getEmpName());
				  	pstmt.setString(2, employee.getEmpNo());
				  	pstmt.setString(3, employee.getEmail());
				  	pstmt.setString(4, employee.getPhone());
				  	pstmt.setString(5, employee.getDetpCode());
				  	pstmt.setString(6, employee.getJobCode());
				  	pstmt.setString(7, employee.getSalLevel());
				  	pstmt.setInt(8, employee.getSalary());
				  	pstmt.setDouble(9, employee.getBonus());
				  	pstmt.setString(10, employee.getManagerId());				  	
			
				  	result = pstmt.executeUpdate();
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(Connection conn , EmployeeDTO edto) {
		
		String sql = prop.getProperty("update");
		int result = 0;
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
					
					pstmt.setString(1, edto.getDeptName());
					pstmt.setString(2, edto.getJobName());
					pstmt.setString(3,edto.getEMP_ID() );
					
					result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	public int delete(Connection conn , String empId) {
		
		String sql = prop.getProperty("delete");
		
		int result = 0;
		try( 
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			
					pstmt.setString(1, empId);
					
					result = pstmt.executeUpdate();
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
