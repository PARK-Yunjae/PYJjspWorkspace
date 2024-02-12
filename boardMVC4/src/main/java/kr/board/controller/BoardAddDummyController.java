package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

// 더미 게시글 추가
public class BoardAddDummyController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String ctx = req.getContextPath();
		BoardDAO.getInstance().createDummies(30);
		return "redirect:"+ctx+"/boardList.do";
	}

}
