package com.kh.employee.controller;

import java.util.List;

import com.kh.employee.model.dao.EmployeeDao;
import com.kh.employee.model.dto.EmployeeDTO;
import com.kh.employee.model.service.EmployeeService;
import com.kh.employee.model.vo.Employee;

public class EmployeeController {

	public List<Employee> findAll() {

		List<Employee> employees = new EmployeeService().findAll();

		return employees;
	}

	public List<Employee> findByDept(String deptTitle) {

		List<Employee> employees = new EmployeeService().findByDept(deptTitle);

		return employees;

	}

	public List<Employee> findByJob(String jobName) {

		List<Employee> employees = new EmployeeService().findByJob(jobName);

		return employees;

	}

	public Employee findById(String empId) {

		Employee employee = new EmployeeService().findById(empId);

		return employee;

	}

	public List<Employee> findByHighSalary() {

		List<Employee> employees = new EmployeeService().findByHighSalary();

		return employees;

	}

	public List<Employee> findByLowSalary() {

		List<Employee> employees = new EmployeeService().findByLowSalary();

		return employees;

	}
	
	public int save(String empName,String empNo,String email,String phone,String deptCode,String jobCode,String salLevel,int salary,double bonus,String managerId) {
		
		Employee employee = new Employee(empName ,empNo,email,phone,deptCode,jobCode,salLevel,salary,bonus,managerId);
		
		
		
		int result = new EmployeeService().save(employee);
		
		return result;
		
	}
	
	public int update(String empId,String deptCode,String jobCode) {
		
		EmployeeDTO edto = new EmployeeDTO(deptCode, jobCode, empId);
		
		int result = new EmployeeService().update(edto);
		
		
		return result;
		
		
	}
	
	public int delete(String empId) {
		
		int result = new EmployeeService().delete(empId);
		
		return result;
		
		
	}

}
