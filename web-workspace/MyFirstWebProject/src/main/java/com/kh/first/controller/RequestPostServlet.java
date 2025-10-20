package com.kh.first.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/post.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RequestPostServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("여기서 작업");
		
		
		// 1. 데이터 값 뽑기
		// 2. 요청처리 --> 오늘은 패스 ( 아마 내일까
		// 3. 응답화면 지정
		
		// 0단계 )
		// POST방식일 경우 인코딩 설정이 ISO-8859-1방식으로 바뀌기 때문에
		// 값을 뽑기전에 미리 UTF-8방식으로 바꿔야함
		request.setCharacterEncoding("UTF-8"); 
		
		// 1단계 ) 값 뽑아서 변수에 대입하고 출력해보기
		// request.getParameter("키값") 또는 request.getParameterValues("키값")
		
		String name = request.getParameter("name");
		System.out.println(name);
		
		String gender = request.getParameter("gender");
		System.out.println(gender);
		
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println(age);
		
		String city = request.getParameter("city");
		System.out.println(city);
		
		int height = Integer.parseInt(request.getParameter("height"));
		System.out.println(height);
		
		String[] foods = request.getParameterValues("food");
		//System.out.println(Arrays.toString(foods));
		
		if(foods != null) {
			Arrays.stream(foods).map(e -> 
				e+ "/"
			).forEach(System.out::print);;
		}else {
			System.out.println("없음");
		}
		
		// 2단계
		// 요청처리
		// Service -> DAO -> DB
		// List / VO / int
		
		// 3단계
		// 응답데이터
		
		// 3_1. JSP를 이용해서 응답 페이지 만들기
		
		// JSP(Java Server Page -> 2017년도 까지
		//     Jakarta Server Page -> 2017년도 부터)
		// JAVA기반의 서버 사이드 웹 페이지 생성 기술 
		// 특징 : 서버에서 실행되어 동적으로 웹페이지를 생성할 수 있음 
		// PHP , ASP
		
		// --------------------------------------------------
		// 응답화면(JSP)에서 필요한 데이터를 넘겨줄 것(request에 담아서)
		// parameter는 getParameter("키값") / setter는 존재하지 않음
		// attritube => 키 - 밸류 세트로 묶어서 값을 만들어낼 수 있음
		// request.setAttribute("키","밸류");
		
		
		
		// 응답 데이터 생성과정을 JSP에게 위임 (배정)
		
		// 배정 시 필요한 객체 : RequestDispatcher 
		// request.getRequestDispatcher("JSP파일의 경로");

		
		
		// /로 시작시 webapp/ 을 의미함
		RequestDispatcher view = request.getRequestDispatcher("/views/response_page.jsp");
		
		request.setAttribute("msg", "요청처리에 성공했습니다.");
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("foods", foods);
		
		view.forward(request, response);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); // doGet에서 작업해도 상관없음
		
		//System.out.println("나 부름?");
		
	}

}
