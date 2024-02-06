package kr.board.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.Board;
import kr.board.model.BoardDAO;

import java.io.IOException;
import java.util.ArrayList;

// 게시글 리스트
@WebServlet("/BoardListPaging.do")
public class BoardListPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getParameter("start") != null) {
			BoardDAO.getInstance().setCurPageNum(req.getParameter("start"));
		}
		
		if(req.getParameter("curNum") != null){
			BoardDAO.getInstance().setStartPageNum(req.getParameter("curNum"));
		}
		
		ArrayList<Board> list = BoardDAO.getInstance().getPagingBoardList();
		req.setAttribute("list", list);
		
		// 게시글 시작 페이지 번호
		req.setAttribute("start", BoardDAO.getInstance().startPageNum);
		// 게시글 끝 페이지 번호
		req.setAttribute("end", BoardDAO.getInstance().getEndPageNum());
		// 한페이지에 보여줄 페이징 개수
		req.setAttribute("cnt", BoardDAO.getInstance().pageNumCnt);
		// 전체 페이징 개수
		req.setAttribute("totalCnt", BoardDAO.getInstance().getTotalPageCnt());
		
		RequestDispatcher rd = req.getRequestDispatcher("board/boardListPaging.jsp");
		rd.forward(req, res);
	}

}
