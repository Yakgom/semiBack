package com.kh.chop02.model.vo;

public class RiceWineDrinker extends Drinker {

	private int age;
	
	
	
	public RiceWineDrinker() {
		
	}
	
	public RiceWineDrinker(int age) {
		this.age = age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public void drink() {
		System.out.println("막걸리를 흔들어 마셔보아요.");
	}
	
	@Override
	public void eat() {
		System.out.println("파전을 한 입 먹습니다.");
	}
}
