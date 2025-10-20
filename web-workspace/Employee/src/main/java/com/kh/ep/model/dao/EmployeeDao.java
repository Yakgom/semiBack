package com.kh.ep.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.ep.model.vo.Employee;

public class EmployeeDao {

	
	public int insertEmployee(SqlSession session , Employee employee) {
		
		return session.insert("employeeMapper.insertEmployee",employee);
		
		
	}
	
	public List<Employee> findAll(SqlSession session){
		
		return session.selectList("employeeMapper.findAll");
	}
	
}
