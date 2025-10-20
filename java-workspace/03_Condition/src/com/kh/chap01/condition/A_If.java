package com.kh.chap01.condition;

import java.util.Scanner;

public class A_If {

	
	/*
	 * 
	 *  (단일) if문
	 *  
	 *  [ 표현법 ]
	 *  
	 *  if(조건식){
	 *  
	 *  	조건식이 true일 경우 실행하고자 하는 코드;
	 *  
	 *  
	 *  }
	 *  
	 *  => 조건식의 결과가 true일 경우 : if문 Scope({})안의 코드가 수행
	 *  => 조건식의 결과가 false일 경우 : if문 Scope({})를 건너뜀
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	public void method() {
		
		
		//System.out.println("모범시민");
		
		if(0 < 1) {
			System.out.println("0이 1보다 작아요");
		}
		
		// if문의 조건식자리에는 결론적으로 true 아니면 false 값이 들어가도록 만들어야함!
		
		
		if(false) {
			System.out.println("얘는 죽었다 깨나도 안나옴");
		}
		
		if(true) {
			System.out.println("조건식 자리에는 최종적으로 true가 와야함");
		}
		
	}
	
	public void method2() {
		
		boolean loginCheck = false; // 로그인 상태를 저장해둔 변수 
		
		if(loginCheck == false) {
			System.out.println("네이버를 더 안전하고 편리하게 이용해보세요.");
			System.out.println("NAVER 로그인");
			System.out.println("아이디 찾기 | 비밀번호 찾기 | 회원가입");
		}
		
		
		if(loginCheck) {
			System.out.println("홍길동님 환영합니다 :) ");
			System.out.println("메일 | 카페 | 블로그 | 쇼핑 | 예약");
		}
	}
	
	public void lunchMenu() {
		
		// 오늘의 날씨를 입력받아서
		Scanner sc = new Scanner(System.in);
		
		
		//  더움 / 맑음 / 비옴
		
		System.out.print("오늘의 날씨는 어떤가요(더움 / 맑음 / 비옴) > ");
		
		String weather = sc.nextLine();
		
		
		
		
		
		// 점심메뉴를 추천해주는 프로그램
		// 비옴을 입력했다면 김밥천국을 가라고하자
		
		// 사용자가 입력한 값과 "비옴"이라는 문자열값을 동등비교해서 일치하는지 비교
		// weather 동등비교 "비옴" 
		//System.out.println(weather == "비옴");
		// 문자열값 비교
		// 동등비교연산자(==)를 사용할 수 없음
		// .equals()를 호출해야함
		
		//System.out.println(System.identityHashCode(weather));
		//System.out.println(System.identityHashCode("비옴"));
		
		
		//조건
		// 만약에 사용자가 입력한 문자열 이 "비옴"과 일치하다면
		if(weather.equals("비옴")){
			System.out.println("김밥천국 스페셜정식드세요");
		}
		
		// 만약에 사용자가 입력한 문자열이 "더움"과 일치하다면
		
		if(weather.equals("더움")) {
			System.out.println("김밥일번가에서 냉모밀 드세요");
		}
		// 만약에 사용자가 입력한 문자열이 "맑음"과 일치하다면
		if(weather.equals("맑음")) {
			System.out.println("등촌샤브칼국수에서 버섯샤브칼국수 드세요");
		}
		
		
	}
	public void method3() {
	
		
		// 사용자에게 정수값을 입력받아서 홀 / 짝을 판별 => 출력
		// if문을 이용해서 출력!
		// 단, 입력받은 정수가 0 보다 클경우에만 조건문을 실행!
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값을 입력해주세요 > ");
		int number= sc.nextInt();
		
		
		// if
		
		// 조건식
		// 비교연산
		// 1. 입력받은 정수가 0보다 클경우에만
		// number <0
		
		// 2. 홀/짝
		// 입력받은 정수를 2로 나눈 나머지를 0과 동등비교해서
		// number % 2 == 0;
		
		if( 0<number ) {
			System.out.println( (number%2==0)? "짝" : "홀" );
		}

		
	}
	
	//원섬 후레이스
	public void method4() {
		
		// 1. 메뉴판 보여주기
		// 출력문 == System.out.println()
		
		System.out.println("🍻🍻🍻 술집술집 메뉴판 🍻🍻🍻");
		System.out.println("1. 맥주(5000)");
		System.out.println("2. 소주(3000)");
		System.out.print("🍻메뉴를 선택해주세요 > ");
		// 2. 메뉴번호로 메뉴 입력받기
		// Scanner 사용해서 nextInt()
		
		Scanner sc = new Scanner(System.in);
		int orderNo = sc.nextInt();
		//System.out.println("선택한 메뉴 번호 : " + orderNo);
		
		
		// 3. 수량 입력받기
		// Scanner사용해서 nextInt()
		System.out.print("몇 잔 주문하실건가요 > ");
		int cup = sc.nextInt();
		//System.out.println("시킨 잔 개수" + cup);
		
		// 4. 조건문
		// if문을 이용해서 입력한 메뉴번호에 따라 메뉴명 대입하기
		// 혹시 없는 메뉴 번호를 입력했다면 없는 메뉴라고 대입하기
		String menuName = "";
		
		if(orderNo == 1) {
			menuName = "맥주";
		}
		if(orderNo == 2) {
			menuName = "소주";
		}
		if( orderNo != 1 && orderNo != 2) {
			menuName = "없는 메뉴";
			//System.out.println("없는 메뉴를 시키셨습니다.");
			//System.exit(0);
		}
		System.out.println(menuName);
		//
		// 5. XXXX메뉴를 XXX잔 주문하셨습니다. print()

		System.out.println(menuName + "을(를)" + cup + "잔 주문하셨습니다.");
		
		// 6. 진짜 주문할건지 물어보기
		// Y / N 입력받아서 확인하기
		
		System.out.print("\n위 주문내역으로 주문하시겠습니까? (Y / N) > ");
		sc.nextLine();
		char c = sc.nextLine().charAt(0);
		
		// 7. 6번에서 입력받은 단일 문자가 'Y' 또는 'y' 와 일치하다면 
		// 메뉴명과 수량과 가격 출력하기 if문 + 중첩 if문 + 출력문
		if(c == 'y' || c == 'Y') {
			if(orderNo == 1 ) {
				System.out.println(menuName +" " + cup + "잔 " + cup * 5000   );
			}
			if(orderNo == 2) {
				System.out.println(menuName +" " + cup + "잔 " + " 총액 :" + cup * 3000  );
			}
		}
		if(c == 'n' || c == 'N') {
			System.out.println("주문을 취소하셨습니다.");
		}
		
	}
	
	
	
}
