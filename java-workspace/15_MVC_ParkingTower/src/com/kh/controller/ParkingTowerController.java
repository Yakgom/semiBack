package com.kh.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.model.vo.Car;

public class ParkingTowerController {

	private List<Car> carList = new ArrayList();
	
	public void insertCar(int carNum , int carType , String owner) {
		
		
		
		carList.add(new Car(carNum,carType,owner));
		
	}
	
	public int deleteCar(int carNum) {
		
		for(int i=0; i<carList.size(); i++) {
			
			if(carList.get(i).getCarNum()==carNum) {
				carList.remove(i);
				return 1;
			}
			
		}
		
		return 0;
	}
	
	 public ArrayList<Car> searchCar(String owner){
		 
		 ArrayList<Car> searchlist = new ArrayList<Car>();
		 
		 for(int i=0; i<carList.size(); i++) {
			 
			 if(carList.get(i).getOwner().equals(owner)) {
				 
				 searchlist.add(carList.get(i));
				 continue;
			 }
			 
		 }
		 
		 return searchlist;
	 }
	 
	 public ArrayList<Car> selectList(){
		 
		 
		 
		 
		 return (ArrayList<Car>) carList;
	 }
	
}
