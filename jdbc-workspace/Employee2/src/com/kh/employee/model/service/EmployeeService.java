package com.kh.employee.model.service;

import static com.kh.employee.common.JDBCTemplate.close;
import static com.kh.employee.common.JDBCTemplate.commit;
import static com.kh.employee.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.model.dto.EmployeeDTO;
import com.kh.employee.model.vo.Employee;

public class EmployeeService {

	Connection conn = null;

	{

		conn = getConnection();

	}

	public List<Employee> findAll() {

		List<Employee> employees = new EmployeeDao().findAll(conn);

		return employees;
	}

	public List<Employee> findByDept(String deptTitle) {

		List<Employee> employees = new EmployeeDao().findByDept(conn, deptTitle);

		close(conn);

		return employees;

	}

	public List<Employee> findByJob(String jobName) {

		List<Employee> employees = new EmployeeDao().findByJob(conn, jobName);

		close(conn);

		return employees;

	}
	
	public Employee findById(String empId) {
		
		Employee employee = new EmployeeDao().findById(conn,empId);
		
		close(conn);
		
		return employee;
	}
	
	public List<Employee> findByHighSalary(){
		
		List<Employee> employees = new EmployeeDao().findByHighSalary(conn);
		
		close(conn);
		
		return employees;
		
	}
	
	public List<Employee> findByLowSalary(){
		
		List<Employee> employees = new EmployeeDao().findByLowSalary(conn);
		
		close(conn);
		
		return employees;
		
	}
	
	public int save(Employee employee) {
		
		int result = new EmployeeDao().save(conn , employee);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
		
		
	}
	
	public int update(EmployeeDTO edto) {
		
		int result = new EmployeeDao().update(conn,edto);
		
		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
		
		
	}
	
	public int delete(String empId) {
		
		int result = new EmployeeDao().delete(conn,empId);
		

		if(result > 0) {
			commit(conn);
		}
		
		close(conn);
		
		return result;
		
		
		
	}
	
	

}
