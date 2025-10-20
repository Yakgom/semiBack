package com.kh.chap07.remote.model.vo;


// 필요한 값들을 저장하는 역할
public class Television {
	
	private boolean on;
	private String[] channel;
	
	
	
	
	public Television() {
		channel = new String[5];
		channel[0] = "대한민국 24 뉴스채널";
		channel[1] = "EPL";
		channel[2] = "스튜디오K";
		channel[3] = "EBS 평생학교 2교시";
		channel[4] = "치지직";
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public boolean isOn() {
		return on;
	}
	
	public String[] getChannel() {
		return channel;
	}
	
	
	
	
	
}
