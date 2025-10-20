package com.kh.hw.person.model.vo;

public class Employee extends Person{

	private int salray;
	private String dept;
	
	
	public Employee() {
		
	}
	
	public Employee(String name,int age,double height , double weight,int salray, String dept) {
		super(name , age,height,weight);
		this.salray = salray;
		this.dept = dept;
	}
	public int getSalray() {
		return salray;
	}
	public void setSalray(int salray) {
		this.salray = salray;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		return super.toString() +", " +salray + ", " +dept;
	}
	
	
	
}
