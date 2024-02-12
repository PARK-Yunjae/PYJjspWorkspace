package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

// 게시글 업데이트
public class BoardUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		int no = Integer.parseInt(req.getParameter("no"));
		
		int cnt = BoardDAO.getInstance().updateOneBoard(no, subject, contents);
		String ctx = req.getContextPath();
		
		if(cnt > 0) {
			return "redirect:"+ctx+"/boardList.do";
		}else {
			throw new ServletException("not Update");
		}
	}

}
