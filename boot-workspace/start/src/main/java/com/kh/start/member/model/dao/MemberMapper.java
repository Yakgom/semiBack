package com.kh.start.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.start.member.model.vo.MemberVO;

@Mapper
public interface MemberMapper {

	
	@Insert("INSERT INTO BOOT_MEMBER VALUES(#{memberId},#{memberPwd},#{memberName},#{role})")
	int signUp(MemberVO member);
	
	@Select("SELECT COUNT(*) FROM BOOT_MEMBER WHERE MEMBER_ID = #{memberId}")
	int countByMemberId(String memberId);
}
