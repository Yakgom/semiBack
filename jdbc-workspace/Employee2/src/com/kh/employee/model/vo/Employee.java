package com.kh.employee.model.vo;

import java.sql.Date;

public class Employee {

	private String empId; // SEQ_EMPID
	private String empName;
	private String empNo;
	private String email;
	private String phone;
	private String detpCode;
	private String jobCode;
	private String salLevel;
	private int salary;
	private double bonus;
    private String managerId;
    private Date hireDate; // sysdate
    private Date entDate;
    private String entyn; // 디폴드값 N
      
	public Employee() {
		super();
	}
	
	
	
	












	public Employee(String empName, String empNo, String email, String phone, String detpCode, String jobCode,
			String salLevel, int salary, double bonus, String managerId) {
		super();
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.detpCode = detpCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
	}
















	public Employee(String empId , String empName , int salary , String detpCode , String jobCode) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.detpCode = detpCode;
		this.jobCode = jobCode;
		this.salary = salary;
	}








	public Employee(String empId, String empName, String empNo, String email, String phone, String detpCode,
			String jobCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.detpCode = detpCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
	}








	public Employee(String empId, String empName, String empNo, String email, String phone, String detpCode,
			String jobCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDate,
			String entyn) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empNo = empNo;
		this.email = email;
		this.phone = phone;
		this.detpCode = detpCode;
		this.jobCode = jobCode;
		this.salLevel = salLevel;
		this.salary = salary;
		this.bonus = bonus;
		this.managerId = managerId;
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.entyn = entyn;
	}
	public String getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpNo() {
		return empNo;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getDetpCode() {
		return detpCode;
	}
	public String getJobCode() {
		return jobCode;
	}
	public String getSalLevel() {
		return salLevel;
	}
	public int getSalary() {
		return salary;
	}
	public double getBonus() {
		return bonus;
	}
	public String getManagerId() {
		return managerId;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public Date getEntDate() {
		return entDate;
	}
	public String getEntyn() {
		return entyn;
	}
    
    
    
	
}
