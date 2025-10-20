package com.kh.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.library.model.service.LibraryMemberService;
import com.kh.library.model.vo.LibraryMember;


@WebServlet("/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateController() {
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
		
		LibraryMember member = new LibraryMember();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		member.setUserName(userName);
		member.setPhone(phone);
		member.setEmail(email);
		
		//System.out.println(member);
		
		int result = new LibraryMemberService().update(member);
		
		//System.out.println(result);
		
		if(result > 0) {
		HttpSession session = request.getSession();
		

		
		String[] emails = member.getEmail().split("@");
		
		
		request.setAttribute("email1", emails[0]);
		request.setAttribute("email2", emails[1]);
		request.setAttribute("msg", "success");
		session.setAttribute("userInfo", member);
		}
		
		request.getRequestDispatcher("WEB-INF/views/library/profilePage.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
