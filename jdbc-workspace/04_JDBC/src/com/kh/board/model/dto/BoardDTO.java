package com.kh.board.model.dto;

import java.sql.Date;
import java.util.Objects;

public class BoardDTO {
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

	
	
	public BoardDTO(int boardNo, String boardTitle, String content, String boardWriter, Date createDate,
			String deleteStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = content;
		this.boardWriter = boardWriter;
		this.createDate = createDate;
		this.deleteStatus = deleteStatus;
	}

	public BoardDTO() {
		super();
	}
	
	

	public BoardDTO(String boardTitle, String content, String boardWriter) {
		super();
		this.boardTitle = boardTitle;
		this.boardContent = content;
		this.boardWriter = boardWriter;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getContent() {
		return boardContent;
	}

	public void setContent(String content) {
		this.boardContent = content;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
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
		BoardDTO other = (BoardDTO) obj;
		return boardNo == other.boardNo && Objects.equals(boardTitle, other.boardTitle)
				&& Objects.equals(boardWriter, other.boardWriter) && Objects.equals(boardContent, other.boardContent)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(deleteStatus, other.deleteStatus);
	}

}
