package com.kh.employee.run;

import com.kh.employee.common.JDBCTemplate;
import com.kh.employee.view.EmployeeView;

public class EmployeeRun {
	public static void main(String[] args) {
		JDBCTemplate.registDriver();
		new EmployeeView().mainMenu();
		
		
		
		
		
		
	}
}
