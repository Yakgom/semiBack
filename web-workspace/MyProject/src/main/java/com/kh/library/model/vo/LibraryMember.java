package com.kh.library.model.vo;

import java.sql.Date;

public class LibraryMember {
	private Long userNo;
	private String userId;
	private String userPwd;
	private String userName; 
	private String phone; 
	private String email; 
	private String checkOut;
	private Date enrollDate; 
	private String status;
	
	
	
	
	
	
	public LibraryMember() {
		super();
	}






	public LibraryMember(Long userNo, String userId, String userPwd, String userName, String phone, String email,
			String checkOut) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.checkOut = checkOut;
	}






	public LibraryMember(Long userNo, String userId, String userPwd, String userName, String phone, String email,
			String checkOut, Date enrollDate, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.checkOut = checkOut;
		this.enrollDate = enrollDate;
		this.status = status;
	}






	public Long getUserNo() {
		return userNo;
	}






	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}






	public String getUserId() {
		return userId;
	}






	public void setUserId(String userId) {
		this.userId = userId;
	}






	public String getUserPwd() {
		return userPwd;
	}






	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}






	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}






	public String getPhone() {
		return phone;
	}






	public void setPhone(String phone) {
		this.phone = phone;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public String getCheckOut() {
		return checkOut;
	}






	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}






	public Date getEnrollDate() {
		return enrollDate;
	}






	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}






	public String getStatus() {
		return status;
	}






	public void setStatus(String status) {
		this.status = status;
	}






	@Override
	public String toString() {
		return "Library [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", phone=" + phone + ", email=" + email + ", checkOut=" + checkOut + ", enrollDate=" + enrollDate
				+ ", status=" + status + "]";
	}
	
	
	
	
	
	
}
