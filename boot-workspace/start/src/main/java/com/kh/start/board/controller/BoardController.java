package com.kh.start.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.start.auth.model.vo.CustomUserDetails;
import com.kh.start.board.model.dto.BoardDTO;
import com.kh.start.board.model.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

	private final BoardService boardService;
	
	// 게시글 작성 + 첨부파일이 있는
	// @AuthenticationPrincipal로 Authentication의 principal에 담아놓은 UserDetails를 매개변수로 받을 수 있음
	// 권장방법임 !!!!!!!!!!!!!!
	@PostMapping
	public ResponseEntity<?> save(@Valid BoardDTO board ,
								  @RequestParam(name="file" , required=false) MultipartFile file,
								  @AuthenticationPrincipal CustomUserDetails userDetails
									){
		
		//log.info("게시글 정보 : {}  , 파일정보 : {} " , board , file.getOriginalFilename());
		//log.info("이게 뭔데 : {} " , userDetails.getUsername());
		boardService.save(board, file,userDetails.getUsername());
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
