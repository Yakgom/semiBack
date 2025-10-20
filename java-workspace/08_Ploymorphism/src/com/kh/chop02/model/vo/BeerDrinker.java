package com.kh.chop02.model.vo;

public class BeerDrinker extends Drinker{

	private boolean gout;
	
	public BeerDrinker() {
		
	}
	
	public BeerDrinker(boolean gout) {
		this.gout = gout;
	}
	
	public void setGout(boolean gout) {
		this.gout=gout;
	}
	
	public boolean isGout() {
		return gout;
	}
	
	
	@Override
	public void drink() {
		System.out.println("맥주를 한 입 마십니다. 꿀꺽꿀꺽");
	}
	
	@Override
	public void eat() {
		System.out.println("치킨을 한입 먹습니다. 욤뇨뇸뇸");
	}
	
	
}
