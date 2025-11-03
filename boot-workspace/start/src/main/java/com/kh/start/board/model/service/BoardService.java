package com.kh.start.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kh.start.board.model.dto.BoardDTO;

public interface BoardService {

	
	void save(BoardDTO board, MultipartFile file,String username);
	
	List<BoardDTO> findAll(int pageNo);
	
	BoardDTO findByBoardNo(Long boardNo);
	
	BoardDTO update(BoardDTO board , MultipartFile file);
	
	void deleteByBoardNo(Long boardNo);
	
	
}
