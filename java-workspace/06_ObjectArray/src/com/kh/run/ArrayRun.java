package com.kh.run;

import java.util.Scanner;

import com.kh.movel.vo.Restaurant;

public class ArrayRun {

	public static void main(String[] args) {
		
		// 배열의 특징
		//
		// 논리적인 구조와 물리적인 구조가 동일하다.
		// 같은 자료형끼리만 담을 수 있다 => 동종 모음(homogeneous vowels) 
		// 하나의 배열에 여러 값을 담을 수 있음
		// 메모리상에 공간
		// 참조자료형
		// 인덱스개념이 존재함
		// 명확한 크기를 명시해야한다 => 크기를 바꾸는 것은 불가능
		
		//int[] nums = new int[3];
		//String[] str = new String[5];
		
		// 객체배열의 선언 및 할당!
		// [ 표현법 ] 
		// 참조자료형[] 배열식별자 = new 참조자료형[배열크기];
		
		Restaurant[] restaurants = new Restaurant[3];
		
		Scanner sc = new Scanner(System.in);
		
		
		
		for(int i=0; i<restaurants.length; i++) {
			System.out.print("상호명을 입력하세요 > ");
			String storeName = sc.nextLine();
			System.out.print("주소지 입력하세요 > ");
			String address = sc.nextLine();
			System.out.print("대표메뉴를 입력하세요 > ");
			String mainMenu = sc.nextLine();
			
			restaurants[i] = new Restaurant(storeName,address,mainMenu);
			
			
		}
		
		// System.out.println(restaurants[0]);
		// 주소값을 확인하고 싶었던 것은 아님
		// System.out.pritnln(restaurants);
		// 배열의 주소값
		// System.out.println(restaurants[0]);
		// 0번 객체의 주소값
		//System.out.println(restaurants[0].getMainMenu());
		
		
		
		
		
		for(int j=0;j<restaurants.length; j++) {
			System.out.println(restaurants[j].infomation());
		}
		
		
		System.out.print("상호명을 입력해주세요 > ");
		String searchead = sc.nextLine();
		
		for(int i=0; i< restaurants.length; i++) {
			if(searchead.equals(restaurants[i].getStoreName())){
				System.out.println("대표 메뉴 : " + restaurants[i].getMainMenu());
			};
		}
		
	}

}
