package com.kh.ep.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ep.model.service.EmployeeService;
import com.kh.ep.model.vo.Employee;


@WebServlet("/findAll.do")
public class FindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FindAllServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Employee> employees = new EmployeeService().findAll();

		System.out.println(employees);
		
		request.setAttribute("employeeList", employees);
		
		request.getRequestDispatcher("/WEB-INF/views/findlist.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
