package com.kh.naver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NaverProfileDTO {

	
	private String id;          
    private String name;        
    private String email;      
    private String nickname;   
    private String birthday;    
    private String birthyear;   
    private String mobile;      
}
