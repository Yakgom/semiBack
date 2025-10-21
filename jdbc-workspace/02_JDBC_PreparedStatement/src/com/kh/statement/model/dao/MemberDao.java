package com.kh.statement.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.statement.model.dto.PassWordDTO;
import com.kh.statement.model.vo.Member;

public class MemberDao {

	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL ="jdbc:oracle:thin:@115.90.212.20:10000:XE";
	private final String USERNAME = "KBJ01";
	private final String PASSWORD = "KBJ1234";
	
	/*
	 * DAO(Data Access Object)
	 * 
	 * 지금 시점 DAO에서는 DataBase 관련된 작업 (CRUD)를 전문적으로 담당하는 객체
	 * DAO안에 있는 모든 메소드를 데이터베이스 관련된 작업으로 구성할 것
	 * 
	 * SQL
	 * SELECT / INSERT / UPDATE / DELETE
	 * 
	 * 하나의 메소드는 하나의 SQL만 수행해야한다
	 * 
	 * Controller를 통해 호출된 기능을 수행! -> 02번 프로젝트까지만
	 * DB에 직접 접근한 후 해당 SQL문을 실행한 후 결과 받아오기(JDBC)
	 * 
	 * 
	 */
	/*
	 * JDBC용 객체
	 * 
	 * - Connection : DB와의 연결정보를 담는 객체(IP주소 , Port번호 , 사용자명, 비밀번호)
	 * - Statement : Connection에 담겨있는 연결정보 DB에 SQL문을 보내서 실행하고 결과도
	 *               받아오는 다재다능 객체
	 * - ResultSet : 실행한 SQL문이 SELECT문일 경우 조회된 결과가 처음 담겨있는 객체
	 * - PreparedaStatement : SQL문을 미리 준비하는 개념
	 * 						  미완성된 SQL문을 미리 전달하고 실행하기 전 완성형태로 만든 뒤
	 *                        SQL문을 실행함
	 *                        미완성된 SQL문에 사용자가 입력한 값들이 들어갈 수 있도록 공간을
	 *                        확보해놓음 ==> (placeholder/위치폴더)
	 *                        
	 * - Statement와 PreparedStatement는 부모자식 관계
	 * 
	 * - 차이점
	 * 
	 * 1) Statement는 완성된 SQL문 , PreparedStatement는 미완성된 SQL문
	 * 
	 * 2) Statement == 커넥션객체.createStatement();
	 * 	  PreparedStatement == 커넥션객체.PreparedStatement(sql); < 요게 핵심!
	 * 
	 * 3) SQL 문 실행
	 *      Statement == stmt.executeXXX();
	 *      PreparedStatement == pstmt.executeXXX();
	 *      
	 * 	? 위치홀더에 실제 값을 Binding 해준 뒤 실행한다.
	 * pstmt.setString()
	 * pstmt.setInt()
	 * 
	 * -- JDBC 절차 
	 * 
	 * 0) 필요한 변수들 세팅
	 * 1) JDBC Driver 등록 : 해당 DBMS에서 제공하는 클래스를 String형으로 동적으로 등록
	 * 2) Connection 객체 생성 : DB와의 세션연결 연결할 때 필요한 정보를 인자로 전달 (URL,사용자이름,비밀번호)
	 * 3_1) PreparedStatement 객체 생성 : Connection 객체 생성 (미완성된 SQL문을 생성과 동시에 꼭 전달)
	 * 3_2)현재 미완성된 SQL문을 완성형태로 만들엊기
	 * => 미완성일 경우에만 해당
	 * 4)SQL문 실행 : executeXXX() => sql을 절대로 인자로 전달하지 않음
	 * 				> SELECT : executeQuery()
	 * 				> INSERT/UPDATE/DELETE : executeUpdate();
	 * 5) 결과받기 :
	 * 				> SELECT : ResultSet(조회된 데이터들이 담겨있음)
	 * 
	 * 6) SELECT : Result에 담겨있는 컬럼값들을 커서를 옮겨가며 한 행씩 접근해서 하나하나 뽑아서
	 *             VO객체의 필드에 매핑(옮겨담기) VO가 여러 개 일 경우 ->VO들을 List의 요소로 관리
	 *    INSERT/DELETE/UPDATE : 트랜잭션 처리;
	 * 7) 사용이 다 끝난 JDBC용 객체들을 생성의 역순으로 자원 반납 -> close()
	 * 8) 결과 반환
	 *    SELECT -> 6에서 만든거
	 *    INSERT/UPDATE/DELETE -> 처리된 행의 개수
	 * 
	 */
	
	public int save(Member member) {
		
		// 0) 필요한 변수들을 선언해보자!
		Connection conn = null; // DB와의 세션
		PreparedStatement pstmt = null; // SQL문 실행 후 결과 받기
		int result = 0; // 처리된 행의 개수
		
		// SQL문
		/*
		 * INSERT
		 *   INTO
		 *        MEMBER
		 * VALUES
		 *        (
		 *        SEQ_USERNO.NEXTVAL
		 *      , '사용자가 입력한 아이디'
		 *      , '사용자가 입력한 비밀번호' 
		 *      ...SYSDATE
		 *        )  
		 *        
		 */
		
		String sql = """
				        INSERT
				          INTO
				               MEMBER
				        VALUES
				               (
				               SEQ_USERNO.NEXTVAL
				             , ?
				             , ?
				             , ?
				             , ?
				             , SYSDATE
				               )  
			     	 """;
		
		try {
			// 1) JDBC Driver등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2) Connection 객체 생성(DB와 연결하겠다)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@115.90.212.20:10000:XE","KBJ01","KBJ1234");
			
			conn.setAutoCommit(false);
			// 3_1) PreparedStatement (SQL문을 미리 전달해야함)
			
			pstmt = conn.prepareStatement(sql);
			
			// ID,PWD,NAME,EMAIL
			
			// 3_2) 미완성된 SQL문일 경우 완성 시켜주기
			// 위치 홀더에 값 바인딩
			// pstmt.setXXX(?의 위치, 실제값);
		
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getEmali());
			// 위치홀더를 올바르게 다 채우지 못했다.
			// 자료형이 컬럼의 자료형과 맞지않는 값을 Bind
			
			
			// pstmt.setString(홀더순번,값)
			// => '값' (양옆에 홑따음표를 감싼 상태로 알아서 Bind)
			// pstmt.setInt(홀더순번,값)
			// => 값 (알아서 잘 들어감 따옴표 안붙임)
			
			
			
			
			
			
			
			
			// 4,5) DB에 전달된 SQL문을 실행하고 결과(처리된 행 수) 받기
			result = pstmt.executeUpdate();
			
			// 6 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7 다쓴 JDBC용 객체 자원반납 => 생성의 역순으로 close();
			try {
				if(pstmt!=null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				try {
					if(conn!= null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			
		}
		
		return result;
		
		
		
	}
	
	public List<Member> findAll(){
		
		// 0) 필요한 변수 세팅
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		List<Member> members = new ArrayList();
		
		String sql ="""
					SELETE
						   
				      FROM
					   	   MEMBER
				    """;
		
		
		
		try {
			// 1) JDBC Driver등록
			Class.forName(DRIVER);
			// 2) Connection 생성
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			// 3) PrepraedStatement 생성
			pstmt = conn.prepareStatement(
											"""
					                           SELECT
					                                  USERNO
					                                , USERID
					                                , USERPWD
					                                , USERNAME
					                                , EMAIL
					                                , ENROLLDATE
					                             FROM
					                                  MEMBER
					                            ORDER
					                               BY
					                                  ENROLLDATE DESC           
											""" 
					                     );
			
		    // 4.5 SQL(SELETE) 실행후 결과(ResultSet)반환
			rset = pstmt.executeQuery();
			
			// 6)결과값 매핑
			// 조회결과가 존재하는가를 먼저 판단한 뒤
			// 존재할 경우 한 행씩 접근해서 컬럼의 값을 뽑아서 VO필드에다가 매핑
			while(rset.next()) {
				
				members.add(new Member(
						               rset.getInt("USERNO")
						              ,rset.getString("USERID")
						              ,rset.getString("USERPWD")
						              ,rset.getString("USERNAME")
						              ,rset.getString("EMAIL")
						              ,rset.getDate("ENROLLDATE")));
			}
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			// 7 다쓴 JDBC용 객체 자원반납 => 생성의 역순으로 close();
			
			
			try {if(rset!=null) {
				rset.close();
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				if(pstmt!=null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				try {
					if(conn!= null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			
		}
		
		return members;
		
		
	}
	
	
	public Member findById(String userId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		
		Member member = new Member();
		
		
		String sql = """
						SELECT
						       USERNO
						     , USERID
						     , USERPWD
						     , USERNAME
						     , EMAIL
						     , ENROLLDATE
						  FROM 
						       MEMBER
						 WHERE
						       USERID = ?             
				     """;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				
				
				member.setUserNO(rset.getInt("USERNO"));
				member.setUserId(rset.getString("USERID"));
				member.setUserPwd(rset.getString("USERNAME"));
				member.setUserName(rset.getString("USERNAME"));
				member.setEmali(rset.getString("EMAIL"));
				member.setEnrollDate(rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			// 7 다쓴 JDBC용 객체 자원반납 => 생성의 역순으로 close();
			
			try {if(rset!=null) {
				rset.close();
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				if(pstmt!=null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				try {
					if(conn!= null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		
		return member;
	}
	
	
	
	public List<Member> findByKeyword(String keyword){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		List<Member> members = new ArrayList();
		
		String sql = """
					 SELECT
					        USERNO
					      , USERID
					      , USERPWD
					      , USERNAME
					      , EMAIL
					      , ENROLLDATE
					   FROM
					        MEMBER
					  WHERE
					        USERNAME LIKE '%'||?||'%'     
				     """;
		
		
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				
				members.add(new Member(
			               rset.getInt("USERNO")
			              ,rset.getString("USERID")
			              ,rset.getString("USERPWD")
			              ,rset.getString("USERNAME")
			              ,rset.getString("EMAIL")
			              ,rset.getDate("ENROLLDATE")));
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 7 다쓴 JDBC용 객체 자원반납 => 생성의 역순으로 close();
			
			try {if(rset!=null) {
				rset.close();
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				if(pstmt!=null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				try {
					if(conn!= null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return members;
		
		
	}
	/*
	 * PreparedStatement가 Statement보다 좋음
	 * 
	 * 1. 구문분석 및 컴파일 최적화
	 * 
	 * stmt.executeUpdate(sql);
	 * pstmt.executeUpdate();
	 * 
	 * Statement는 매 번 SQL문을 파싱하고 실행하지만
	 * PreparedStatement는 SQL쿼리를 최초 1회만 파싱하고 실행계획을 캐싱(메모리에올림)
	 * 
	 * 재사용적인 측멱면서 훨씬 효율적임
	 * 
	 * 2. DB서버에 대한 트래픽 감소
	 * 
	 * 쿼리 자체는 한 번만 전송하고 이후에는 바인딩할 값만 전송하기 때문에 효율적이다
	 * 
	 * 동일쿼리를 반복 실행할 때, 높은 트래픽이 몰리는 애플리케이션일 때 더욱더 효율적이다.
	 * 
	 * DB작업 -> 계획 세울 때 리소스를 많이 잡아먹음
	 * 
	 * 3. SQL Injection 방지
	 * 
	 * SELECT
	 * 	      EMAIL
	 *   FROM
	 *        MEMBER
	 *  WHERE
	 *        USERID = '" + m.getUserId() +"'"
	 *    AND
	 *        USERPWD = '" + m.getUserPwd() +"'"       
	 *
	 *
	 * 사용자의 입력값 == ' OR '1' =1
	 * 
	 * Statement는 이걸 막을 수가 없음
	 * 
	 * PreparedStatment는 인덕션 방지가 됨 ==> 보안 적인 측면에도 훨씬 좋음
	 * 
	 * 
	 */
	
	
	public int update(PassWordDTO pd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result =0;
		
		
		
		
		String sql ="""
						UPDATE
						       MEMBER
						   SET     
						       USERPWD =?
						 WHERE     
						       USERID =?
						   AND     
				
				    """;  
		
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			conn.setAutoCommit(false);
			
			pstmt.setString(1, pd.getNewPassword());
			pstmt.setString(2, pd.getUserId());
			pstmt.setString(3, pd.getUserPwd());
			
			result = pstmt.executeUpdate();
			
			// 6) 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			// 7 다쓴 JDBC용 객체 자원반납 => 생성의 역순으로 close();
			try {
				if(pstmt!=null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				try {
					if(conn!= null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		
		
		return result;
	}

	public int delete(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		
		String sql = """
					 DELETE
					   FROM
					 	    MEMBER
					  WHERE
					        USERID = ?
					    AND
					        USERPWD = ?      	    	
					 """;
		
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 7 다쓴 JDBC용 객체 자원반납 => 생성의 역순으로 close();
			try {
				if(pstmt!=null) {
				pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
				try {
					if(conn!= null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		

		}
		return result;
	}
	
	
	}
	

