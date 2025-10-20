package com.kh.chap04_assist.movel.vo;

import java.io.Serializable;

public class Plant implements Serializable{

	private String name;
	private String type;
	public Plant(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Plant() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Plant [name=" + name + ", type=" + type + "]";
	}
	
	
	
}
