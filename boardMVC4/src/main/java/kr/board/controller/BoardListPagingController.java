package kr.board.controller;

import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;
import kr.board.model.BoardVO;

// 페이징 게시판
public class BoardListPagingController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		if (req.getParameter("start") != null) {
			BoardDAO.getInstance().setCurPageNum(req.getParameter("start"));
		}

		if (req.getParameter("curNum") != null) {
			BoardDAO.getInstance().setStartPageNum(req.getParameter("curNum"));
		}

		ArrayList<BoardVO> list = BoardDAO.getInstance().getPagingBoardList();
		req.setAttribute("list", list);

		// 게시글 시작 페이지 번호
		req.setAttribute("start", BoardDAO.getInstance().getStartPageNum());
		// 게시글 끝 페이지 번호
		req.setAttribute("end", BoardDAO.getInstance().getEndPageNum());
		// 한 페이지에 보여줄 페이징 개수
		req.setAttribute("cnt", BoardDAO.getInstance().getPageNumCnt());
		// 전체 페이징 개수
		req.setAttribute("totalCnt", BoardDAO.getInstance().getTotalPageCnt());
		return "boardListPaging";
	}

}
