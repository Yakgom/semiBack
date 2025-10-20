package com.kh.library.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.library.common.Template;
import com.kh.library.common.Validation;
import com.kh.library.model.dao.LibraryMemberDao;
import com.kh.library.model.vo.LibraryMember;

public class LibraryMemberService {

	private LibraryMemberDao lmd = new LibraryMemberDao();
	private Validation vd = new Validation();
	
	public int save(LibraryMember member) {
		
		return 0;
		
		
	}
	
	public LibraryMember login(LibraryMember member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		LibraryMember library = null;
		
		if(vd.loginCheck(member.getUserId(), member.getUserPwd())> 0) {
			
			 library = lmd.login(sqlSession,member);
			 //System.out.println("로그인 성공");
		}
		
		sqlSession.close();
		
		return library;
		
	}
	
	public int update(LibraryMember member) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = lmd.update(sqlSession , member);
		
		if(result >0) {
			sqlSession.commit();
		}
		
	
		
		sqlSession.close();
		
		return result;
	}
	
}
