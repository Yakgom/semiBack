package com.kh.ep.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.ep.common.Template;
import com.kh.ep.model.dao.EmployeeDao;
import com.kh.ep.model.vo.Employee;

public class EmployeeService {

	private EmployeeDao ed = new EmployeeDao();
	
	private SqlSession session = null;
	{
		
		session = Template.getSqlSession();
	}
	
public int insertEmployee(Employee employee) {
	
	
	
	int result = ed.insertEmployee(session , employee);
	
	if(result > 0 ) {
		session.commit();
	}
	
	session.close();
	
	return result;
	
}

public List<Employee> findAll(){
	
	List<Employee> employees = ed.findAll(session);
	
	session.close();
	
	return employees;
	
}
	
	
}
