package com.kh.start.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.start.member.model.dao.MemberMapper;
import com.kh.start.member.model.dto.MemberDTO;
import com.kh.start.member.model.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("members")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	

	
	// 회원가입 => 일반회원 => ROLE 컬럼에 들어갈 값 필드에 담아주어야함
	//                  => 비밀번호 암호화
	//                  => VO에 담을것
	// VO : ValueObject(값을 담는 역할) ==> 불변해야한다는것이 특징
	// DTO : DataTransferObject(데이터 전송)
	
	// GET
	// GET(/members/멤버번)
	// POST
	// PUT
	// DELETE
	
	// 로그인은 여기다가 안만들것
	
	@PostMapping
	public ResponseEntity<?> signUp(@Valid @RequestBody MemberDTO member){
		log.info("멤버 잘 들어오나 : {} " , member);
		memberService.signUp(member);
		
		return ResponseEntity.status(201).build();
		
	}
	
	
}
