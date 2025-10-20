package com.kh.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.el.model.vo.Person;


@WebServlet("/jstl.do")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public JstlServlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// DB 갔다온척 -> SELECT 해옴
		// List가 들어왔다고 침
		List<Person> list = new ArrayList();
		
		list.add(new Person("홍길동",15,"한양"));
		list.add(new Person("고길동",40,"쌍문동"));
		list.add(new Person("허균",22,"서울"));
		
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("/WEB-INF/views/customaction/JSTL.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
