package com.kh.start.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kh.start.configuration.filter.JwtFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfigure {

	private final JwtFilter jwtFilter;
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
		// Example ) 회원가입 , 로그인 => 누구나 다 할 수 있어야함
		//           회원정보수정 , 회원탈퇴 => 로그인된 사용자만 할 수 있어야함
		return httpSecurity.formLogin(AbstractHttpConfigurer::disable).csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(requests -> {
					requests.requestMatchers(HttpMethod.POST,"/auth/login" , "/members").permitAll();
					requests.requestMatchers(HttpMethod.PUT,"/members").authenticated();
					requests.requestMatchers(HttpMethod.DELETE,"/members").authenticated();
					requests.requestMatchers(HttpMethod.POST, "/boards").authenticated();
					})
				/*
				 * 
				 * sessionManagement : 세션을 어떻게 관리할것인지 지정
				 * sessionCreatePolicy : 세션 사용정책을 설정
				 * 
				 * 
				 */
				.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		
		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		
		return authConfig.getAuthenticationManager();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
