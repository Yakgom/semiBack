package com.kh.ep.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ep.model.service.EmployeeService;
import com.kh.ep.model.vo.Employee;

@WebServlet("/ep.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeeController() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empNo = request.getParameter("empNo");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String deptCode = request.getParameter("deptCode");
		String jobCode = request.getParameter("jobCode");
		String salLevel = request.getParameter("salLevel");
		int salary = Integer.parseInt(request.getParameter("salary"));
		double bonus = Double.parseDouble(request.getParameter("bonus"));
		String managerId = request.getParameter("managerId");
		
		Employee employee = new Employee(empId,empName,empNo,email,phone,deptCode,jobCode,salLevel,salary,bonus,managerId);
		
		
		
		int result = new EmployeeService().insertEmployee(employee);
		
		if(result >0 ) {
			
			request.setAttribute("employee", employee);
			
			request.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(request, response);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
