package com.kh.naver.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.naver.model.dto.NaverProfileDTO;
import com.kh.naver.model.service.NaverLoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("login")
@RequiredArgsConstructor
@Slf4j
public class NaverController {
	
	private final NaverLoginService naverLoginService;
	
	   @GetMapping()
	    public String naverAuth() {
	        String url = naverLoginService.requestNaver();
	        System.out.println("네이버 로그인 URL: " + url); // ✅ 콘솔 확인용
	        return "redirect:" + url; // ✅ 브라우저가 네이버 로그인 화면으로 이동
	    }
	   
	   @GetMapping("naver")
	    public String callBackNaver(@RequestParam("code") String code, @RequestParam("state") String state) {
	      
		   log.info("콜백 code={}, state={}", code, state);

	        // Access Token 발급
	        String accessToken = naverLoginService.getAccessToken(code, state);
	        log.info("Access Token: {}", accessToken);

	        // 프로필 조회
	        NaverProfileDTO profile = naverLoginService.getProfile(accessToken);
	        log.info("네이버 프로필: {}", profile);

	        // TODO: 회원가입/로그인 처리 후 세션/쿠키 저장 가능

	        return "redirect:/"; // 홈으로 이동
	    }
}

