package com.kh.library.common;

public class Validation {

	
	public int loginCheck(String id,String pwd) {
		
		String idPatten = "^[a-zA-z0-9]{1,12}$";
		String pwdPatten = "^[a-zA-z0-9]{1,8}$";
		
		if(id == null || "".equals(id.trim()) && pwd == null || "".equals(id.trim())) {
			return 0;
		}
		if(!id.matches(idPatten) || !pwd.matches(pwdPatten)) {
			return 0;
		}
		
		return 1;
		
	}
}
