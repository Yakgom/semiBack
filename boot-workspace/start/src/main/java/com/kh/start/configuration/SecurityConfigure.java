package com.kh.start.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigure {

	// 우리의 문제점 : 시큐리티의 formLogin 필터가 자꾸만 인증이 안됐다고 회원가입도 못하게함
	// 해결방법 : form 로그인 안쓸래 하고 filterChain을 빈으로 등록
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		
		//return httpSecurity.formLogin().disable().build();
		/*
		return httpSecurity.formLogin(new Customizer<FormLoginConfigurer<HttpSecurity>>() {
			@Override
			public void customize(FormLoginConfigurer<HttpSecurity> t) {
				t.disable();
			}
		}).build();
		*/
		// formLogin 필터를 사용안함으로써 401은 지나갔는데 == 403이 뜸??
		// CSRF(Cross-Site Request Forgery) 필터가 튀어나옴
		// <img src="www.naver.com"/> 
		return httpSecurity.formLogin(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable).build();
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
