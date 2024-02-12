package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

// 게시글 전체 삭제
public class BoardAllDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String ctx = req.getContextPath();
		BoardDAO.getInstance().boardAllDelete();
		return "redirect:" + ctx + "/boardList.do";
	}

}
