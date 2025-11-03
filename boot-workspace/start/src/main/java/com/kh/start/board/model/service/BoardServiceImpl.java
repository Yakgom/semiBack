package com.kh.start.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.start.board.model.dao.BoardMapper;
import com.kh.start.board.model.dto.BoardDTO;
import com.kh.start.board.model.vo.BoardVO;
import com.kh.start.file.service.FileSerivce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

	private final BoardMapper boardMapper;
	private final FileSerivce fileService;
	
	@Override
	public void save(BoardDTO board, MultipartFile file,String username) {
		
		// 유효성 검증 valid로 퉁
		// 권한검증 -> ROLE로함 
		BoardVO b = null;
		// 첨부파일 관련 값
		if(file != null && !file.isEmpty()) {
			// 이름 바꾸기
			// 원본파일명에서 확장자 뽑기
			// 저장위치 정해야함
			// 파일 올리는 메소드 호출
			String filePath = fileService.store(file);
			
			b = BoardVO.builder().boardTitle(board.getBoardTitle())
										.boardContent(board.getBoardContent())
										.boardWriter(username)
										.fileUrl(filePath)
										.build();
			
			
		}else {
			
			// title , content ,writer ,file INSERT
			 b = BoardVO.builder().boardTitle(board.getBoardTitle())
					.boardContent(board.getBoardContent())
					.boardWriter(username)
					.build();
			
		}
		
		boardMapper.save(b);
		
	}

	@Override
	public List<BoardDTO> findAll(int pageNo) {

		return null;
	}

	@Override
	public BoardDTO findByBoardNo(Long boardNo) {

		return null;
	}

	@Override
	public BoardDTO update(BoardDTO board, MultipartFile file) {

		return null;
	}

	@Override
	public void deleteByBoardNo(Long boardNo) {
	}

	
}
