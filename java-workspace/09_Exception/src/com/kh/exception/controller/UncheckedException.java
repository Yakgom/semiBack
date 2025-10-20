package com.kh.exception.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.DefaultBoundedRangeModel;

public class UncheckedException  {

	
	
	/* 
	 * 프로그램 실행 시 발생하는 예외들 
	 * RuntimeException
	 * 
	 * - NullPointerException : 주소값 객체를 참조했더니 null 값이 들어있을 경우 발생하는 예외 
	 * - ArrayIndexOutOfBoundsException : 배열의 부적절한 인덱스로 접근했을 때 발생하는 예외
	 * - ClassCastException : 허용할 수 없는 형변환을 진행할 경우 발생하는 예외
	 * - ArithmeticException : 나누기 연산을 0으로 나누면 발생하는 예외
	 * - NegativeArraySizeException : 배열을 할당할 때 크기를 음수로 지정하면 발생하는 예외
	 * ... 수없이 많음 
	 * 
	 * RuntimeException 과 관련된 예외들은 공통점이 있음 
	 * 개발자가 예측이 가능함
	 */
	
	
	// ArithmeticException
	public void method1() {
		// 사용자에게 두 개의 정수값을 입력받아서 나눗셈을 한 뒤 결과를 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력해주세요 > ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수를 입력해주세요(제발 0은 입력하지말아주세요) > ");
		int num2 = sc.nextInt();
		
		// 방법 1. 예외발생 자체를 원천 차단해버림
		/*
		if(num2 != 0) {
		System.out.println("연산 결과 : " + (num1 / num2));
		}
		else {
			System.out.println("너 0넣지 말라했지");
		}
		*/
		
		// 방법 2. 예외처리를 진행 
		// 예외 처리 : 
		// 예외 상황을 감지하고 예외상황이 발생 시 
		// 프로그램이 비정상적인 종료가 되는것을 방지하고 적절한 대응 조치를 취하는 것
		
		/*
		 * try - catch문
		 * 
		 * 
		 * try{
		 *  
		 *  (num1 / num2) // 예외가 발생할수도 있는 구문 
		 * 
		 * } 
		 * catch(발생할예외클래스명 변수명){ => 매개변수 
		 * 	
		 * 		해당 예외가 발생했을 때 실행할 구문
		 * }
		 * 
		 * 
		 * */
		try {
			System.out.println(num1/num2);
			
			System.out.println("올바른 정수 입력!");
			
		} catch (ArithmeticException e) {
			System.out.println("두 번째 정수에 0을 입력하시면 나눌 수가 없습니다.");
		}
		
		
		System.out.println("프로그램 종료");
	}
		
		public void homeWork() {
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				
				System.out.println("메뉴를 선택해주세요");
				System.out.println("1. 추가하기");
				System.out.println("2. 검색하기");
				int menuNo=0;
				try {
				 menuNo = sc.nextInt();
				}
				catch(InputMismatchException e){
					System.out.println(e);
					
					// 예외처리 시 catch문에 적어야하는 내용이 출력문은 아님 
				}
				sc.nextLine();
				System.out.println(menuNo + "번 메뉴를 선택하셨습니다.");
				
			}
		
	}
		
		
		
		
		
		public void method2() {
			
			
			//System.out.println("하이");
			
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("정수를 입력해주세요 (0은 제외) ");
			try {
			int num = sc.nextInt();
			// InputMismatchException
			
			System.out.println( "100을 입력값으로 나눈 결과 : " + (100/num) );
			// AritchmeticException
			}catch(InputMismatchException e) { // 1. 먼저 입력받은 값이 정수인지 판단
				System.out.println("숫자로 된 정수값이 아닙니다.");
				
			}catch(ArithmeticException e) {
				System.out.println("0으로는 나눌수없습니다.");
			}
			
			
			System.out.println("프로그램 종료");
		}
		
		
		public void method3(){
			// 배열
			
			// 사용자에게 정수값을 입력받아서
			// 입력받은 만큼의 크기를 가진 배열을 생성 및 할당하고
			// 100번째 인덱스 값을 출력
			
			Scanner sc = new Scanner(System.in);
			System.out.print("정수값을 입력해주세요 > ");
			
			try {
			// InputMismatchException : 스캐너 메소드의 자료형과 일치하지않음
			int num = sc.nextInt();
			// NegativeArraySizeException : 배열의 크기를 음수로 지정하면 파업
			int[] arr = new int[num];
			// ArrayIndexOutOfBoundsException : 배열의 크기보다 큰 인덱스에 접근하면 파업
			System.out.println(arr[100]);
			} catch(InputMismatchException e) {
				System.out.println("정수넣어라");
			}catch(RuntimeException e) {
				e.printStackTrace(); // 얘는 꼭 계발 단계에서만
				System.out.println("아마도 음수를 입력했거나 100보다 크지않아서?");
			}
			
			
		/*	for(int i=0; i<100; i++) {
				System.out.println(arr[i]);
			}
			*/
			
			
			}
}
