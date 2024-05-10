package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// bno, title, content 3개 파라미터. 목록으로 이동.
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(bno));
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.modifyBoard(board)) {
			resp.sendRedirect("main.do");
		}else {
			System.out.println("처리중 에러");
		}
	}

}
