package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

// 게시글 하나 삭제
public class BoardOneDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		int cnt = BoardDAO.getInstance().boardOneDelete(Integer.parseInt(req.getParameter("no")));
		String ctx = req.getContextPath();
		if(cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		}else {
			throw new ServletException("not delete");
		}
	}

}
