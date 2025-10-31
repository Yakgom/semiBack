package com.kh.start.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.start.token.model.dao.TokenMapper;
import com.kh.start.token.model.vo.RefreshToken;
import com.kh.start.token.util.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenService {

	private final JwtUtil tokenUtil;
	private final TokenMapper tokenMapper;
	// 인증에 성공했을 때
	// JwtUtil에 정의해놓은
	// getAccessToekn메서드 호출
	// getRefreshToken메서드 호출
	// 두개를 어디다 고이 예쁘게 담아서
	// RefreshToken의 경우 DB의 Token테이블에 만들어진 Token을 INSERT
	// AuthServiceImpl의 login메서드로 반환

	public Map<String, String> generateToken(String username) {

		// String accessToken = tokenUtil.getAccessToken(username);
		// String refreshToken = tokenUtil.getRefreshToken(username);

		// log.info("엑세스 토큰 : {} , 리프레시 토큰 : {} " , accessToken , refreshToken);

		Map<String, String> tokens = createTokens(username);

//		RefreshToken token = RefreshToken.builder().token(refreshToken)
//							.username(username)
//							.expration(System.currentTimeMillis() + 36000000L & 72)
//							.build();
		saveToken(tokens.get("refreshToken"),username);
		
//		tokenMapper.saveToken(token);
//		
		// Map<String,String> tokens = new HashMap();
		// tokens.put("accessToken", accessToken);
		// tokens.put("refreshToken", refreshToken);

		return tokens;

	}

	private Map<String, String> createTokens(String username) {
		String accessToken = tokenUtil.getAccessToken(username);
		String refreshToken = tokenUtil.getRefreshToken(username);

		log.info("엑세스 토큰 : {} , 리프레시 토큰 : {} ", accessToken, refreshToken);

		Map<String, String> tokens = new HashMap();
		tokens.put("accessToken", accessToken);
		tokens.put("refreshToken", refreshToken);

		return tokens;
	}

	private void saveToken(String refreshToken,String username) {

		RefreshToken token = RefreshToken.builder().token(refreshToken).username(username)
				.expration(System.currentTimeMillis() + 36000000L & 72).build();

		tokenMapper.saveToken(token);

	}

	// 추후 AccessToken의 만료기간이 지나서 토큰 갱신 요청이 들어왔을 때
	// 사용자에게 전달받은 RefreshToken이 DB에 존재하면서 만료기간이 지나지않았는지를 검증하는 메소드

}
