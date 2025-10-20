package com.kh.view.ParkingTowerView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.ParkingTowerController;
import com.kh.model.vo.Car;

public class ParkingTowerView {

	private Scanner sc = new Scanner(System.in);
	private ParkingTowerController ptc = new ParkingTowerController();

	public void mainMenu() {

		while (true) {
			System.out.println("🚗 메뉴 구성");

			System.out.println("1.차량 주차");
			System.out.println();
			System.out.println("2.차량 출차");
			System.out.println();
			System.out.println("3.주차된 차량 검색");
			System.out.println();
			System.out.println("4.전체 출력");
			System.out.println();
			System.out.println("0.프로그램 종료");

			try {
				System.out.print("사용할 메뉴를 입력해주세요 > ");
				int menuNo = sc.nextInt();
				sc.nextLine();

				switch (menuNo) {
				case 1:
					insertCar();
					break;
				case 2:
					deleteCar();
					break;
				case 3:
					searchCar();
					break;
				case 4:
					selectList();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다");
					return;
				default:
					System.out.println("잘못된 번호를 입력하셨습니다.");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요");
				sc.nextLine();
			}
		}

	}

	public void insertCar() {

		while (true) {
			try {
				System.out.print("주차할 차의 차량번호를 적어주세요 > ");
				int carNum = sc.nextInt();
				sc.nextLine();
				System.out.println("주차할 차량의 타입을 적어주세요 (1.경차 2.세단 3.SUV 4.트럭)");
				System.out.print("타입 > ");
				int carType = sc.nextInt();
				sc.nextLine();
				System.out.print("차량 주인의 성명을 적어주세요 > ");
				String owner = sc.nextLine();

				ptc.insertCar(carNum, carType, owner);

				break;
			}

			catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요.");
				sc.nextLine();
			}
		}

	}

	public void deleteCar() {
		while (true) {
			try {
				System.out.print("출차할 차량번호를 적어주세요 > ");
				int carNum = sc.nextInt();
				sc.nextLine();
				
				int result = ptc.deleteCar(carNum);
				
				if(result == 1) {
					System.out.println("출차가 완료되었습니다.");
				}
				else {
					System.out.println("적어주신 차량번호에 해당하는 차량이 없습니다.");
				}
				
				
				break;
			}

			catch (InputMismatchException e) {
				System.out.println("숫자만 입력해주세요.");
				sc.nextLine();
			}
		}
		
		
	}

	public void searchCar() {

	System.out.print("주차된 차주의 성명을 적어주세요 > ");
	String owner = sc.nextLine();
	
	ArrayList<Car> result = ptc.searchCar(owner);
	
	if(result.isEmpty()) {
		System.out.println("성명으로 조회된 차량이 없습니다.");
	}
	else {
		
		for(Car c : result) {
			System.out.println("조회된 차량" + c);
		}
		
	}
	
	
		
	}

	public void selectList() {

		System.out.println("전체 출력 결과입니다.");
		
		ArrayList<Car> carList = ptc.selectList();
		
		if(carList.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
		}
		else {
		  // carList.forEach(e ->{System.out.println(e);});
			for(Car c : carList) {
				System.out.println(c);
			}
		}
		
		
	}
}
