package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {

	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	
	public int[] personCount() {
		int sCount = 0;
		
		int eCount = 0;
		
		for(int i=0; i<s.length; i++) {
			if(s[i] != null) {
				sCount ++;
			}
		}
		
		for(int i=0; i<e.length; i++) {
			if(e[i] != null) {
				eCount ++;
			}
		}
		
		int[] counts = {sCount , eCount};
		
		return counts;
	
	}
	
	public void insertStudent(String name , int age, double height , double weight , int grade , String major) {

		for(int i=0; i<s.length; i++) {
		  if(s[i] == null) {
			  s[i] = new Student(name,age,height,weight,grade,major);
			  break;
		  }
		  
		 
		}

	}
	
	public Student[] printStudent() {
		
		for(int i=0; i<s.length; i++) {
			if(s[i] != null) {
				System.out.println(s[i].toString());
			}
		}
		
		return s;
		
 	}
	
	public void insertEmployee(String name , int age, double height , double weight, int salary , String dept) {
		for(int i=0; i<e.length; i++) {
			  if(e[i] == null) {
				  e[i] = new Employee(name,age,height,weight,salary,dept);
				  break;
			  }
			  
			 
			}
	}
	
	public Employee[] printEmployee() {
		for(int i=0; i<e.length; i++) {
			if(e[i] != null) {
				System.out.println(e[i].toString());
			}
		}
		
		return e;
		
 	}
	
	
	
	
	
	
	
}
