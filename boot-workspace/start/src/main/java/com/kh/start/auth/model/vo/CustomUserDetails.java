package com.kh.start.auth.model.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Value;



@Builder
@Value // AllArgsConstructor , Getter , ToString , equals , hashCode
public class CustomUserDetails implements UserDetails {

	private String username; // Member_ID컬럼값 담는 용도
	private String password;
	private String memberName; // Member_NAME
	private Collection<? extends GrantedAuthority> authorities;

}
