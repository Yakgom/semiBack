package com.kh.employee.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.employee.model.dto.EmployeeDTO;
import com.kh.employee.model.vo.Employee;

public class EmployeeDao {

	

	public List<Employee> findAll(SqlSession session) {

		List<Employee> employees = session.selectList("employeeMapper.findAll");
		return employees;

	}

	public List<Employee> findByDept(SqlSession session, String deptTitle) {

		List<Employee> employees = session.selectList("employeeMapper.findByDept",deptTitle);

		

		return employees;

	}

	public List<Employee> findByJob(SqlSession session, String jobName) {

		List<Employee> employees = session.selectList("employeeMapper.findByJob",jobName);


		return employees;

	}

	public Employee findById(SqlSession session, String empId) {

		Employee employee =  session.selectOne("employeeMapper.findById",empId);
		
		return employee;

	}

	public List<Employee> findByHighSalary(SqlSession session){
		
		List<Employee> employees = session.selectList("employeeMapper.findByHighSalary");
		
		
		return employees;
		
		
		
		
	}
	
	public List<Employee> findByLowSalary(SqlSession session){
		
		List<Employee> employees = session.selectList("employeeMapper.findByLowSalary");
		
		
		return employees;
		
		
		
		
	}
	
	
	public int save(SqlSession session , Employee employee) {
		
		int result = session.update("employeeMapper.save", employee);
		
		
		return result;
	}
	
	public int update(SqlSession session , EmployeeDTO edto) {
		
		int result = session.update("employeeMapper.update", edto);
		
		
		return result;
		
	}
	
	public int delete(SqlSession session , String empId) {
		
		int result = session.delete("employeeMapper.delete",empId);
		
		return result;
	}
}
