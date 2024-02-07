package kr.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

public class BoardOneAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		System.out.println(req.getParameter("no"));
		if (req.getParameter("no") == null) {
			int no = BoardDAO.getInstance().insertAddNo();
			req.setAttribute("no", no);
			return "boardInsert";
		}

		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		System.out.println(writer);
		System.out.println(subject);
		System.out.println(contents);
		

		int cnt = BoardDAO.getInstance().insertOneBoard(writer, subject, contents);

		if (cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		} else {
			throw new ServletException("not Update");
		}
	}

}
