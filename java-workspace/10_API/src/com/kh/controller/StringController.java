package com.kh.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.kh.run.Run;

public class StringController {

	
	// String 클래스 => 불변 (변하지 않음을 의미)
	
	/*
	 * String 클래스 사용방법 
	 * 
	 * 1. new 연산자를 사용해서 String 클래스의 생성자를 호출하는 방법
	 * 2. 대입연산자를 이용해서 문자열 리터럴값을 대입하는 방법
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	// 생성자를 호출해서 문자열 객체를 생성하는 방법
	
	public void method1() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		Run run = new Run();
		// String str3 = "hello";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(run);
		// 1. String 클래스의 toString()의 경우
		// 실제 담겨있는 문자열 리터럴 value값을 변환하도록 오버라이딩
		
		Run run2 = new Run();
		
		System.out.println(run.equals(run2));
		
		
		// equals()
		System.out.println(str1.equals(str2));
		// true ==> 같다
		// 주소값 비교는 물론이고 문자열 값도 비교하도록 오버라이딩
		
		// hashcode()
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		// 3. String클래스의 hashCode()
		// 주소값을 해싱하는 것이 아니라 실제 담긴 문자열값을 기반으로 해시코드 값을 만들도록 오버라이딩
		
		// 진짜 저 참조형 변수들을 식별할 수 있는 값을 알아내는법
		// System.identityHashcode(참조형변수)
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode("hello"));
		
		
		System.out.println(str1==str2);
		
	}
	
	// 문자열 리터럴 대입 방식
	public void method2() {
		
		String str1 = "hello";
		String str2 = "hello";
		
		// toString()
		System.out.println(str1);
		System.out.println(str2);
		
		// equals()
		System.out.println(str1.equals(str2));
		
		// hashCode()
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		// System.identityHashcode
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println(str1==str2);
		
		
	}
	
	// String (Constant) Pool 
	public void method3() {
		
		String exam = new String("hello");
		String str = "hello";
		
		// 문자열 리터럴은 대입 연산자를 사용해 대입할 때 
		// String Constant Pool 영역에 등록함
		// 특 : 동일한 내용의 문자열 리터럴이 존재할 수 없음
		System.out.println(System.identityHashCode(str));
		str = "bye";
		System.out.println(System.identityHashCode(str));
		str += "!!";
		System.out.println(System.identityHashCode(str));

	}
	public void method4() {
		
		//Arrays.toString(new int[2]);
		
		// StringBuffer 
		// Buffer == 임시저장공간
		// 문자열은 불변객체라서 내용물이 변경될 때 마다 새로운 공간을 할당해서 집어넣는다.
		// 이를 해결하기 위해서 임시공간(Buffer)을 준비해서
		// 임시공간에 차곡차곡 담았다가 한번에 처리해주는 클래스
		StringBuffer sb = new StringBuffer();
		
		//System.out.println("Hello" + "World!");
		
		sb.append("Hello");
		sb.append("World!");
		
		System.out.println(sb);
		
		StringBuilder sb2 = new StringBuilder();
		
		sb2.append("Hello");
		sb2.append("World!");
		System.out.println(sb2);
		
		// 동시제어가능(Thread-Safe)이
		// 외부에서 제공이 많이 되고 있기 때문에
		// 충돌환경이 아니라면 굳이 구현할 필요가 없음
		
	}
	
	// 문자열과 관련된 메소드들 
	
	
	public void stringMethod() {
	
		String str1 = "경실련하이텔 아카데미";

		// 1. 문자열.length() : int
		// 문자열의 길이를 반환
		System.out.println("str1의 길이 : " + str1.length());
		

		char ch = str1.charAt(3);
		
		System.out.println("하 : " +ch);
		
		String phoneNumber = "010-1234-5678";
		
		// 3. 문자열.substring(int beginindex) : String
		// => 문자열의 beginindex위치에서 문자열 끝까지의 문자열을 추출해서 반환
		System.out.println(phoneNumber.substring(4));
		System.out.println(phoneNumber.substring(4,8));
		
		// 4. 문자열.indexOf(str) : int 
		System.out.println(str1.indexOf("텔"));
		
		
		String[] emails = {"hong@kh.com","kim@kh.com","hitel@kh.com","hahahahohohoho@kh.com"};
		
		for(int i=0; i<emails.length; i++) {
			System.out.println("아이디 값 : " + emails[i].substring(0,emails[i].indexOf("@")));
		}
		
		// 5. 문자열.toCharArray() : char[]
		// 문자열의 각 문자들을 char[] 로 반환해주는 메소드 
		char[] chArr = emails[0].toCharArray();
		
		for(char c : chArr) {
			System.out.println(c);
		}
		new String(chArr).chars().mapToObj(c-> (char)c).forEach(System.out::println);
		
		// char[] -> String
		System.out.println(String.valueOf(chArr));
		
		
		// 6. 문자열.replace(char old, char new) : String
		System.out.println(emails[0].replace("kh", "naver"));
		
		String str3 = "                   java               ";
		// 7. 문자열.trim();
		System.out.println(str3.trim());
		
		// 8. 문자열.toUpperCase() : String
		//    문자열.toLowerCase() : String
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정말 하시겠어요?(Y/N) > ");
		String answer = sc.nextLine();
		answer = answer.toUpperCase(); // 메서드체이닝 or 콜백함수 
		
		if(answer.equals("Y")) {
			System.out.println("나 찐으로 해야겠다 ");
		}
		
		
	
	}
	
	public void split() {
		
		// 문자열 분리시키기
		String str = "배고파요,졸려요,하기싫어요,즐거워요";
		
		// 문자열.split(String 구분자) : String[]
		String[] arr = str.split(",");
		
		for(int i =0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println();
		
		// 향상된 for 문
		
		for(String s : arr) {
			System.out.println(s);
		}
		
		
		System.out.println();
		// 초기식 , 조건식 , 증감식 안씀
		// for( 값을 받아줄 변수 선언 : 순차적으로 요소에 접근할 배열 || 컬렉션) {}
		// 배열의 요소를 수정할 순 없음
		
		// java.util.StringTokenizer 클래스를 이용하는 방법 
		
		StringTokenizer st = new StringTokenizer(str,",");
		
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());

		while(st.hasMoreTokens()) {
			// 남아있는 토큰이 있다면 true / 토큰 다 뽑았다면 false
			System.out.println(st.nextToken());
		}
		
	}
}
