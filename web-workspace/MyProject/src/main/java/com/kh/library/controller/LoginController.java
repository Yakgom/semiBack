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


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		LibraryMember member = new LibraryMember();
		
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		LibraryMember loginUser = new LibraryMemberService().login(member);
		
		//System.out.println(login);
		
		if(loginUser!=null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("userInfo", loginUser);
			
			
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
