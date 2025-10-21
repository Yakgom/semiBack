package com.kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dao.BoardDAO;
import com.kh.board.model.dao.BoardRepository;
import com.kh.board.model.dto.BoardDTO;
import com.kh.board.model.vo.Board;
import com.kh.common.JDBCTemplate;
import com.kh.common.Template;
import com.kh.statement.model.service.MemberService;
import com.kh.statement.model.vo.Member;

public class BoardService {

	private Connection conn = null;
	
	public BoardService() {
		conn = JDBCTemplate.getConnection();
		
	}
	
	public int insertBoard(BoardDTO bd) {
		// 내가 입력한 값을 가지고
		// BOARD테이블에 한 행 INSERT해줘~
		int result =0;
		// 1. 값의 유효성 검증
		if("".equals(bd.getBoardTitle().trim())){
			return result;
		}
		
		// 제목 : 안녕하세요, 내용 : 반갑습니다, 아이디 : admin 
		// 2. 인증 / 인가
		//Member member = new MemberDao().findById(conn, bd.getBoardWriter());
		Member member = new MemberService().findById(bd.getBoardWriter());
		
		if(member != null) {
			
			int userNo = member.getUserNo();
			Board board= new Board(0,
									bd.getBoardTitle()
								  ,	bd.getContent()
								  , String.valueOf(userNo)
								  , null
								  , null);
			
			
		result =  new BoardDAO().insertBoard(conn,board);
		}
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		
		JDBCTemplate.close(conn);
		
		
		return result;
		
	}
	
	public List<Board> selectBoardList(){
		
		/*
		List<Board> boards = new BoardDAO().selectBoardList(conn);
		
		//new BoardDAO().outputHTML(conn);
		
		JDBCTemplate.close(conn);
		*/
		
		
		SqlSession session = Template.getSqlSession();
		
		List<Board> boards =  new BoardRepository().selectBoardList(session);
		
		session.close();
		
		
		
		return boards;
		
	}
	
	public Board selectBoard(int boardNo) {
		
	/*	Board board = null;
		
		
		if(boardNo>0) {
		 board = new BoardDAO().selectBoard(conn, boardNo);
		}
		
	    JDBCTemplate.close(conn);*/
		
		
		SqlSession session = Template.getSqlSession();
		
		Board board = new BoardRepository().selectBoard(session,boardNo);
	    
	    return board;

		
	}
	
	public int delete(int baordNo) {
		
		int result = new BoardDAO().delete(conn, baordNo);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		
		return result;
	}
}
