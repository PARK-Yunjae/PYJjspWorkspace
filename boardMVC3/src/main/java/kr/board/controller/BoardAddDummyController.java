package kr.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

public class BoardAddDummyController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		BoardDAO.getInstance().createDummues(30);
		return "redirect:"+ctx+"/boardList.do";
	}

}
