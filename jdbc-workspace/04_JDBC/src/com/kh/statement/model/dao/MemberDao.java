package com.kh.statement.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.statement.model.dto.PassWordDTO;
import com.kh.statement.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	
	// 메소드 호출할 때마다
	// xml 파일로부터 Properties객체로 입력받는 코드를 써야함 중복이다
	// new MemberDao().XXX
	
	public MemberDao() {
		
		try {
			prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int save(Connection conn,Member member) {
		
		PreparedStatement pstmt = null;
		int result =0;
		
		
		
//		try {
//		prop.loadFromXML(new FileInputStream("resources/member-mapper.xml"));
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		String sql = prop.getProperty("save");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getEmali());
			
			// 4,5)  DB에 완성된 SQL문을 실행한 결과(int) 받기
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7) 할 일이 다 끝난 PreparedStatement 객체만 반남
			JDBCTemplate.close(pstmt);
			
		}
		// 8) 결과반환
		return result;
		
		
		
		
	
		
		
	}
	
	
	
	public List<Member> findAll(Connection conn){
		
		
		
		// 0) 필요한 변수 선언 먼저!
		// PreparedStatement , ResultSet ,sql, List
		
		List<Member> members = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		try {
//			prop.loadFromXML(new FileInputStream("resources/member-mampper.xml"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
		
		String sql = prop.getProperty("findAll");

		
		
		
	try {	
		// 3_1) 객체 생성 (sql문을 인자로 전달하기)
		pstmt = conn.prepareStatement(sql);
		
		rset = pstmt.executeQuery();
		
		// 6) 조회결과 여부 판단 후 => rset.next()
		//  컬럼값을 객체 필드에 매핑
		
		while(rset.next()) {
			
			Member member = new Member(
					        rset.getInt("USERNO")
					       ,rset.getString("USERID")
					       ,rset.getString("USERPWD")
					       ,rset.getString("USERNAME")
					       ,rset.getString("EMAIL")
					       ,rset.getDate("ENROLLDATE")
					
					);
			
			members.add(member);
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	return members;
	
	
	}
	
	public Member findById(Connection conn , String userId) {
		
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findById");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				member = new Member(
						                    rset.getInt("USERNO")
					                      ,	rset.getString("USERID")
					                      , rset.getString("USERPWD")
					                      , rset.getString("USERNAME")
					                      , rset.getString("EMAIL")
					                      , rset.getDate("ENROLLDATE")
			
						);
						
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
			
		}
		
		
		return member;
		
	}
	
	
	
	public List<Member> findByKeyword(Connection conn,String keyword){
		
		List<Member> members = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		
		String sql = prop.getProperty("findByKeyword");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Member member = new Member(
						  rset.getInt("USERNO")
						, rset.getString("USERID")
						, rset.getString("USERPWD")
						, rset.getString("USERNAME")
						, rset.getString("EMAIL")
						, rset.getDate("ENROLLDATE")
						);
				
				
				
				members.add(member);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
			
			
		}
		
		return members;
		
		
		
	}
	
	public int update(Connection conn , PassWordDTO pd) {
		
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("update");
		
				try {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pd.getNewPassword());
					pstmt.setString(2, pd.getUserId());
					pstmt.setString(3, pd.getUserPwd());
					
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					
					
					JDBCTemplate.close(pstmt);
					
				}
				
				
				return result;
		
	}
	
	public int delete(Connection conn , Member member) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("delete");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			
			
			result = pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
			
		}
		
		return result;
		
		
	}
	
	
	}
	
	
	
	

