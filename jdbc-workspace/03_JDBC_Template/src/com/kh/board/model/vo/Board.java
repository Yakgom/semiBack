package com.kh.board.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Board {
	// BOARD_NO NUMBER
	// BOARD_TITLE VARCHAR2
	// BOARD_CONTENT VARCHAR2
	// BOARD_WRITER NUMBER FOREIGN KEY(USERNO)
	// CREATE_DATE DATE
	// DELETE_STATUS CHAR(1)
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private Date createDate;
	private String deleteStatus;
	
	
	
	// 기본생성자 / 모든 필드에대한 매개변수 생성자
	// getter
	// equals, hashCode
	public Board(int boardNo, String boardTitle, String content, String boardWriter, Date createDate,
			String deleteStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = content;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
		this.deleteStatus = deleteStatus;
	}
	
	
	
	
	
	
	
	
	
	
	public int getBoardNo() {
		return boardNo;
	}










	public String getBoardTitle() {
		return boardTitle;
	}










	public String getBoardContent() {
		return boardContent;
	}










	public String getBoardWriter() {
		return boardWriter;
	}










	public Date getCreateDate() {
		return createDate;
	}










	public String getDeleteStatus() {
		return deleteStatus;
	}










	@Override
	public int hashCode() {
		return Objects.hash(boardNo, boardTitle, boardWriter, boardContent, createDate, deleteStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return boardNo == other.boardNo && Objects.equals(boardTitle, other.boardTitle)
				&& Objects.equals(boardWriter, other.boardWriter) && Objects.equals(boardContent, other.boardContent)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(deleteStatus, other.deleteStatus);
	}
	
	
	
	
		
}
