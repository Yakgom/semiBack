package com.kh.employee.model.dto;

import java.util.Objects;

public class EmployeeDTO {
	private String jobName;
	private String deptName;
	private String empId;
	
	
	
	
	public EmployeeDTO() {
		super();
	}
	public EmployeeDTO(String jobName, String deptName, String empId) {
		super();
		this.jobName = jobName;
		this.deptName = deptName;
		this.empId = empId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEMP_ID() {
		return empId;
	}
	public void setEMP_ID(String eMP_ID) {
		empId = eMP_ID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empId, deptName, jobName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(deptName, other.deptName)
				&& Objects.equals(jobName, other.jobName);
	}
	
	
	
	
	
	
	
	
	
	
}
