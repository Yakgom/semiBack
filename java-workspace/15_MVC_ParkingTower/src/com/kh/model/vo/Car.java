package com.kh.model.vo;

public class Car {

	private int parkingNum;
	private int carNum;
	private int carType;
	private String owner;
	private static int count = 1;
	
	
	
	
	public Car() {
		super();
	}

	
	
	public Car(int carNum, int carType, String owner) {
		
		this.parkingNum = count++;
		this.carNum = carNum;
		this.carType = carType;
		this.owner = owner;
	}

	public int getParkingNum() {
		return parkingNum;
	}

	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}

	public int getCarType() {
		return carType;
	}

	public void setCarType(int carType) {
		this.carType = carType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {

		String carType = "";

		switch (this.carType) {
		case 1:
			carType = "경차";
			break;
		case 2:
			carType = "세단";
			break;
		case 3:
			carType = "SUV";
			break;
		case 4:
			carType = "트럭";
			break;

		}
		return "Car [주차번호=" + parkingNum + ", 차량번호=" + carNum + ", 차량타입=" + carType + ", 차주=" + owner
				+ "]";
	}

}
