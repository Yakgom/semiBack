package com.kh.start.member.model.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.start.exception.IdDuplicateException;
import com.kh.start.member.model.dao.MemberMapper;
import com.kh.start.member.model.dto.MemberDTO;
import com.kh.start.member.model.vo.MemberVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;	
	private final PasswordEncoder passwordEncoder;
	@Override
	public void signUp(MemberDTO member) {
		
		// 유효성 검사 == Validator에게 위임
		
		
		// 아이디 중복 검사
		int count = mapper.countByMemberId(member.getMemberId());
		
		if(1 == count) {
			throw new IdDuplicateException("이미 존재하는 아이디입니다.");
		}
		
		
		// 비밀번호 암호화
		/*
		String encodedPwd = passwordEncoder.encode(member.getMemberPwd());
		
		
		// ROLE주기
		
		MemberVO singUpMember = new MemberVO(member.getMemberId(),encodedPwd,member.getMemberName(),"ROLE_USER");
		*/
		MemberVO memberBuilder = MemberVO.builder().memberId(member.getMemberId()).memberPwd(passwordEncoder.encode(member.getMemberPwd()))
				.memberName(member.getMemberName()).role("ROLE_USER").build();
		// 매퍼 호출
		
		mapper.signUp(memberBuilder);
		
		log.info("사용자 등록 성공 : {}" , memberBuilder);
		
	}

}
