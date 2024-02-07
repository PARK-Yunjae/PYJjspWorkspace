package kr.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;
import kr.board.model.BoardVO;

public class BoardContentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		if(req.getParameter("no") == null) {
			return "redirect:"+ctx+"/boardList.do";
		}
		int no = Integer.parseInt(req.getParameter("no"));
		BoardVO vo = BoardDAO.getInstance().getOneBoard(no);
		req.setAttribute("vo", vo);
		return "boardContent";
	}

}
