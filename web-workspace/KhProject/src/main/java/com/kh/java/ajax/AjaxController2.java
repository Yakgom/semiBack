package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonArray;
import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.Member;


@WebServlet("/ajax2.do")
public class AjaxController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjaxController2() {
        super();
       
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 뽑기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Member member = new Member();
		member.setUserId(id);
		member.setUserPwd(pwd);
		
		Member loginMember = new MemberService().login(member);
		
		String name = loginMember.getUserName();
		String email = loginMember.getEmail();
		
		// System.out.println(loginMember);
		// 옛날에는 두개를 한번에 보내기위해 XML 방식으로 보냈음
		
		// AJAX를 활용하는데 실제 값을 여러 개 응답하고 싶음
		// JSON 형태로 데이터를 가공해서 앞단으로 응답해주기
		
		// 1. 배열
		// 2. 객체
		// [name,email]
		// ['홍길동2','hong@kh.com']
		//String responseData = "['"+name+"','"+email +"']";  양쪽이 "" 이 아니라 '' 라서 parse가 불가능
		//String responseData = "[\""+name+"\",\""+email +"\"]";
		
		//System.out.println(responseData);
		//response.setContentType("application/json; charset=UTF-8");
		//response.getWriter().print(responseData);
		
		/*
		 * 라이브러리를 사용해서 JSON형태의 데이터 만들기
		 * 
		 * 1. JSONArray
		 * 2. JSONObject
		 *
		 */
		
		
		// 배열 모양으로 보내는거
		/*JSONArray array = new JSONArray(); // ArrayList 상속
		
		array.add(name);
		array.add(email);
		*/
		
		
		JSONObject obj = new JSONObject(); // HashMap 상속
		
		
		
		obj.put("name", name);
		obj.put("email", email);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(obj);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
