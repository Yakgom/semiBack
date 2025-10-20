package com.kh.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.library.model.service.LibraryMemberService;
import com.kh.library.model.vo.LibraryMember;


@WebServlet("/signup.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignUpController() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName =request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		email += "@";
		email += request.getParameter("email2");
		
		LibraryMember libarry = new LibraryMember();
		
		libarry.setUserId(userId);
		libarry.setUserPwd(userPwd);
		libarry.setUserName(userName);
		libarry.setPhone(phone);
		libarry.setEmail(email);
		
		System.out.println(libarry);
		
		
		int result = new LibraryMemberService().save(libarry);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
