package com.kh.chap01.model.vo;

public class JapanFood {

	private String foodName;
	private String material;
	private int cookingTime;
	private int fresh;

	public JapanFood() {
	}

	public JapanFood(String foodName, String material, int cookingTime, int fresh) {
		this.foodName = foodName;
		this.material = material;
		this.cookingTime = cookingTime;
		this.fresh = fresh;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}

	public int getFresh() {
		return fresh;
	}

	public void setFresh(int fresh) {
		this.fresh = fresh;
	}

	public String informartion() {
		return "foodName : " + foodName + " ,material : " + material + " ,cookingTime : " + cookingTime + " ,fresh : "
				+ fresh;
	}



}
