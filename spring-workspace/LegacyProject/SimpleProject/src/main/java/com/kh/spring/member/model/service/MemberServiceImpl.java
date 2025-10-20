package com.kh.spring.member.model.service;

import java.util.function.Function;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.exception.TooLargeValueException;
import com.kh.spring.member.model.dao.MemberRepository;
import com.kh.spring.member.model.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberServiceImpl(SqlSessionTemplate sqlSession) {
		
		this.sqlSession = sqlSession;
		
	}
	
	
	
	
    
	
	@Override
	public MemberDTO login(MemberDTO member) {
		//log.info("나 불렀어?");
		/*
		 * SqlSession session = Template.getSqlSession();
		 * 등등 생략 
		 * 
		 * 
	     */
		
		// ver 0.1 
		return memberRepository.login(sqlSession, member);
	}

	@Override
	public void signUp(MemberDTO member) {
		// 꼼꼼하게 검증
		// 유효값 검증
		if(member==null) {
			return;
		}
		
		//아이디 값이 20자가 넘으면 안된다고 가정해보자
		if(member.getUserId().length()>20) {
			throw new TooLargeValueException("아이디 값이 너무 길어요");
		}
		if(member.getUserId()==null||
				member.getUserId().trim().isEmpty()||
				member.getUserPwd()==null||
				member.getUserPwd().trim().isEmpty()) {
			return;
		}
		
	}

	@Override
	public void update(MemberDTO member) {
	}

	@Override
	public void delete(MemberDTO member) {
	}

}
