package com.kh.chap05.constructor.run;

import com.kh.chap05.constructor.model.vo.Member;

public class Run {
	

 public static void main(String[] args) {
	
	 Member member = new Member();
	 System.out.println(member.info());
	 System.out.println();
	 
	 
	 Member member2 = new Member("하하호호");
	 System.out.println(member2.info());
	 System.out.println();
	 
	 
	 Member member3 = new Member("user01", "1234");
	 System.out.println(member3.info());
	 System.out.println();
	 
	 
	 
	 Member member4 = new Member("user02","pass02","qweqwe");
	 System.out.println(member4.info());
	 
	 
	 System.out.println((int)'e'-'a');
}
}
