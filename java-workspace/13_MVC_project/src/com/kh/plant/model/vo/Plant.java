package com.kh.plant.model.vo;

// Model : 데이터 관련 작업
// VO : 프로그램 실행 중 만들어진 값(Value)를 담는 객체(Object)
public class Plant {
	private String type;
	private String name;
	
	
	// VO 만들기 졸업
	// 기본생성자 , 매개변수생성자 , getter , setter , toString
	// Alt + Shift + s 
	public Plant() {};
	public Plant(String type , String name) {
		this.type = type;
		this.name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "식물정보 [이름 = "+name +" , 종류 = " +type + "]";
	}
	
}
