package com.kh.chap04.model.vo;

import java.util.Objects;

public class Fish {

	private String taste;
	private String recipe;
	
	public Fish() {
		super();
	}
	
	public Fish(String taste, String recipe) {
		super();
		this.taste = taste;
		this.recipe = recipe;
	}
	
	public String getTaste() {
		return taste;
	}
	
	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public String getRecipe() {
		return recipe;
	}
	
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	

	@Override
	public String toString() {
		return "Fish [taste=" + taste + ", recipe=" + recipe + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
