package com.kh.java.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Reply;


@WebServlet("/list.reply")
public class SelectReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SelectReplyController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long boardNo = Long.parseLong(request.getParameter("boardNo"));
		//System.out.println(boardNo);
		List<Reply> reply = new BoardService().selectReply(boardNo);
		
		// 응답
		
		//System.out.println(reply);
		
		response.setContentType("application/json; charset=UTF-8");
		
		Gson gson = new Gson();
		
		gson.toJson(reply,response.getWriter());
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
