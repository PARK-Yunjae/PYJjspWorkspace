package kr.board.controller;

import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;
import kr.board.model.BoardVO;

// 페이징 없는 게시글 목록 보기
public class BoardListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		ArrayList<BoardVO> list = BoardDAO.getInstance().getBoardList();
		req.setAttribute("list", list);
		return "boardList";
	}

}
