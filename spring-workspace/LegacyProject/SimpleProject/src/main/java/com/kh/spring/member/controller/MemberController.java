package com.kh.spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.member.model.vo.Member;

@Controller
public class MemberController {

	@RequestMapping("login")
	public void login(Member member) {

		// 1. 값뽑기
		// 2. 데이터가공
		System.out.println(member);
		
	}
	
	
	
	
	
	
}
