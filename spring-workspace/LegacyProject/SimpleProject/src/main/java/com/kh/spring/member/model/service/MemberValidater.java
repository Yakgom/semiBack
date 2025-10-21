package com.kh.spring.member.model.service;

import org.springframework.stereotype.Component;

import com.kh.spring.exception.AuthenticationException;
import com.kh.spring.exception.InvalidArgumentsException;
import com.kh.spring.exception.TooLargeValueException;
import com.kh.spring.member.model.dao.MemberMapper;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberValidater {

	private final MemberMapper memberMapper;
	
	
	
	private void checkNull(MemberDTO member) {
		if(member==null) {
			throw new NullPointerException("잘못된 접근입니다.");
		}
	}
	
	private void checkLength(MemberDTO member) {
		if(member.getUserId().length()>20) {
			throw new TooLargeValueException("아이디 값이 너무 길어요");
		}
	}
	
	private void checkBlank(MemberDTO member) {
		if(member.getUserId()==null||
				member.getUserId().trim().isEmpty()||
				member.getUserPwd()==null||
				member.getUserPwd().trim().isEmpty()) {
			throw new InvalidArgumentsException("유효하지 않는 값입니다.");
		}
	}
	
	
	
	public void validatedMember(MemberDTO member) {
		
		checkNull(member);
		
		//아이디 값이 20자가 넘으면 안된다고 가정해보자
		checkLength(member);
		
		checkBlank(member);
		
		
		
	}
	
	public void validatedUpdateMember(MemberDTO member , MemberDTO sessionMember) {
		
		checkNull(member);
		checkNull(sessionMember);
		
		if(!member.getUserId().equals(sessionMember.getUserId())) {
			throw new AuthenticationException("권한없는 접근입니다");
		}
		
		checkNull(memberMapper.login(member));
		
	}
	
	
}
