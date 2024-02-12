package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

// 게시글 하나 추가
public class BoardOneAddController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String ctx = req.getContextPath();
		
		if (req.getParameter("no") == null) {
			int no = BoardDAO.getInstance().insertAddNo();
			req.setAttribute("no", no);
			return "boardInsert";
		}

		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		

		int cnt = BoardDAO.getInstance().insertOneBoard(writer, subject, contents);

		if (cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		} else {
			throw new ServletException("not Update");
		}
	}

}
