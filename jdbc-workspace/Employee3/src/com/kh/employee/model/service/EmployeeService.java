package com.kh.employee.model.service;

import static com.kh.employee.common.JDBCTemplate.close;
import static com.kh.employee.common.JDBCTemplate.commit;
import static com.kh.employee.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

import org.apache.ibatis.session.SqlSession;

import com.kh.employee.common.Template;
import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.model.dto.EmployeeDTO;
import com.kh.employee.model.vo.Employee;

import oracle.net.ns.SessionAtts;

public class EmployeeService {

	private EmployeeDao employeeDao = new EmployeeDao();
	private SqlSession session = null;
	
	
	public EmployeeService() {
		
		session = Template.getSqlSession();
		
	}

	
	private List<Employee> executeQuery(Function<SqlSession, List<Employee>> query){
		
		try {
			return query.apply(session);
		} finally {
			
			session.close();
		}
		
	}
	
	
	private int executeUpdate(Function<SqlSession, Integer> query) {
		
		try {
			
			return query.apply(session);
		}finally {
			session.commit();
			session.close();
		}
		
	}
	
	public List<Employee> findAll() {

		
		
		List<Employee> employees = employeeDao.findAll(session);
		
		session.close();

		return employees;
	}

	public List<Employee> findByDept(String deptTitle) {

		List<Employee> employees = employeeDao.findByDept(session, deptTitle);

		session.close();
		
		return employees;

	}

	public List<Employee> findByJob(String jobName) {

		List<Employee> employees = employeeDao.findByJob(session, jobName);

		session.close();
		

		return employees;

	}

	
	public Employee findById(String empId) {
		
		Employee employee = employeeDao.findById(session, empId);
		

		
		return employee;
	}
	
	
	
	public List<Employee> findByHighSalary(){
		
		List<Employee> employees = executeQuery(e -> employeeDao.findByHighSalary(session));
		
		
		return employees;
		
	}
	
	public List<Employee> findByLowSalary(){
		
		List<Employee> employees = executeQuery(e -> employeeDao.findByLowSalary(session));
		
		
		
		return employees;
		
	}
	
	public int save(Employee employee) {
		
		int result = executeUpdate(e -> employeeDao.save(session, employee));
	
		return result;
		
		
	}
	
	public int update(EmployeeDTO edto) {
		
		int result = executeUpdate(e -> employeeDao.update(session, edto));
		
		
		
		return result;
		
		
	}
	
	public int delete(String empId) {
		
		int result = executeUpdate(e -> employeeDao.delete(session, empId));
		
		
		
		return result;
		
		
		
	}
	
	

}
