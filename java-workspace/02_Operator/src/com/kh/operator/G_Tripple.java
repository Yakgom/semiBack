package com.kh.operator;

import java.util.Scanner;

public class G_Tripple {

	
	/*
	 * 삼항 연산자 : 피 연산자가 3개 => 값 3개의 1개의 연산자로 이루어진(조건문의 형식으로 쓰임)
	 * 
	 * 조건문 : 값에 따라 연산을 처리하는 방식
	 * 		  결과값이 true일 경우 첫 번째 문장을 처리
	 * 		  결과값이 false일 경우 두 번째 문장을 처리
	 * 
	 * 
	 * [ 표현식 ] 
	 * 조건식 ? 조건식이 true일 경우 결과값 : 조건식이 false일 경우 결과값
	 * 
	 * 
	 * */
	
	
	
	
	// 원섬후레이스
	public void method1() {
		System.out.println("시즌 메뉴판 : ");
		System.out.println("1. 더 멜론 오브 멜론 프라푸치노");
		System.out.println("2. 자몽 망고 코코 프라푸치노");
		System.out.println("3. 카페 브륄레 프라푸치노");
		
		// Ctrl + Shift + o
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("메뉴 번호를 입력해주세요 > ");
		int menuNo = sc. nextInt();
		
		String selectedMenu = (menuNo == 1) ? "더 멜론 오브 멜론 프라푸치노를 주문하셨습니다 ." 
											: (menuNo == 2) ? "자몽 망고 코코 프라푸치노를 주문하셨습니다" 
											: (menuNo == 3) ? "카페 브륄레 프라푸치노를 주문하셨습니다." 
											: "없는 메뉴를 주문하셨습니다.";
		

		// 조건식 ? 조건식이 true일 경우 결과값 : 조건식이 false일 경우 결과 값
		
		// 1번 입력 시 == " 더 멜론 오브 멜론 프라푸치노를 주문하셨습니다. " 
		
		System.out.println(selectedMenu);
		
		
		
	}
	
	
	//홀짝 구하기
	public void method2() {
		
		
		
		// 사용자에게 정수 값을 하나 입력받아서
		
		// 입력도구 별칭 짓기
		Scanner sc = new Scanner(System.in);
		
		// 필요한 값을 입력받을 수 있도록 메세지 출력
		System.out.print("숫자를 입력하세요 > ");
		
		// 정수형 변수를 선언한 뒤 스캐너의 메소드를 호출해서 입력 버퍼에 있는 정수값을 받아와서
		// 정수형 변수 공간에 초기화
		int number = sc.nextInt();
		//System.out.println("변수값 찍어보기 > " + number);
		
		
		// 입력받은 정수가 홀 / 짝 판별해서 출력
		// num % 2 ! =0
		// num % 2 = =1
		// num % 2 == 0

		char oddEven = ((number % 2) == 0 ) ? '짝' : '홀'; 
		
		System.out.println("입력하신 " + number + "은(는) " + oddEven + "수 입니다");
		
		
		
	}
	
	public void method3() {
		
		// 사용자에게 알파벳 한 글자를 입력받아서
		// 입력받은 알파벳이소문자인지 / 대문자인지 판별 후 출력해주세요.
		
		
		Scanner sc = new Scanner(System.in);
		
		char ch = sc.nextLine().charAt(0);
		
		//System.out.println((int)ch);
		// a 97 
		// z 122
		// A
		// 출력형식
		// XXX(사용자가 입력한 알파벳)은(는) 소문자 / 대문자 입니다.
		
		//String str = (65<=ch && ch<=90) ? ("대문자 입니다") : "소문자 입니다";
					//'A'<=ch && 'ch'<='Z'
		String str = (65<=ch && ch<=90) ? ("사용자가 입력한 알파벳" + ch + "은(는) " + "대문자 입니다") 
					////'a'<=ch && 'ch'<='z'
				: (97 <= ch &&  ch<= 122 ) ? ("사용자가 입력한 알파벳" + ch + "은(는) " + "소문자 입니다")
						: "정확한 값을 입력해주세요 ";
		
	
		
		
		
		
		
		
		
	}
}
