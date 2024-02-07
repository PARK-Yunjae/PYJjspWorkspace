package kr.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

public class BoardUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		int no = Integer.parseInt(req.getParameter("no"));
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		
		int cnt = BoardDAO.getInstance().updateOneBoard(no, subject, contents);
		
		if(cnt > 0) {
			return "redirect:"+ctx+"/boardList.do";
		}else {
			throw new ServletException("not Update");
		}
	}

}
