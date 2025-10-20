package com.kh.library.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.library.model.vo.LibraryMember;

public class LibraryMemberDao {

	
	public LibraryMember login(SqlSession sqlSession,LibraryMember member) {
		
		return sqlSession.selectOne("libraryMapper.login",member);
		
		
		
	};
	
	public int update(SqlSession sqlSession,LibraryMember member) {
		
		return sqlSession.insert("libraryMapper.update",member);
		
	}
}
