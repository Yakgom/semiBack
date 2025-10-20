package com.kh.chap06.run;

import java.util.Arrays;

import com.kh.chap06.controller.Human;
import com.kh.chap06.controller.MethodController;
import com.kh.chap06.controller.OverloadingController;

public class Run {

	public static void main(String[] args) {
		
		/*Human human = new Human();
		
		human.hi();
		
		MethodController mc = new MethodController();
		
		int a = mc.add(1, 2);
		int b = mc.add(2, 3);
		int c = mc.add(5, 6);
		int d = mc.add(a, b);
		int e = mc.add(c, d);
		
		System.out.println("총합 : " + e);
		*/
		
		//MethodController mc = new MethodController();
		
		//mc.method1();
		//String retrunValue = mc.method2();
		//System.out.println(retrunValue);
		//System.out.println(mc.method2());
		//System.out.println("method3 호출 결과 : " + mc.method3());
		//mc.method4(5);
		
		//int result = mc.method5(5);
		
		//System.out.println(result);
		
		// mc.test(mc); < 얉은 복사 ★★★★★★중요
		
		// 복습하자 
		
		
		//MethodController.staticMethod();
		
		
		OverloadingController oc = new OverloadingController();
		// 정적 바인딩(Static Binding)
		// 컴파일이 끝난 시점 어떤 메소드가 호출될지 결정
		// 컴파일러가 알아서 코드를 분석하여 메소드 호출 연결
		oc.test();
		
		oc.test(2);
	
		oc.test("hi");
		
		oc.test(4,3);
		
		
		
	}

}
