package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;
import kr.board.model.BoardVO;

// 게시글 수정 페이지 이동
public class BoardContentController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String ctx = req.getContextPath();
		String no = req.getParameter("no");
		if(no == null) return "redirect:" + ctx + "/boardList.do";
		
		BoardVO vo = BoardDAO.getInstance().getOneBoard(no);
		req.setAttribute("vo", vo);
		return "boardContent";
	}

}
