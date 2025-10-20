package com.kh.chop05.model.vo;

public abstract class Music{
	
	// 클라이언트 요구사항
	private String title;
	private String runningTime;
	private String code;
	
	public Music() {
		
	}
	
	public Music(String title , String runningTime , String code ) {
		this.title = title;
		this.runningTime = runningTime;
		this.code = code;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRunningTime() {
		return runningTime;
	}
	
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
