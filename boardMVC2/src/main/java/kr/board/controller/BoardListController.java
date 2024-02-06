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
@WebServlet("/BoardList.do")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Board> list = BoardDAO.getInstance().getBoardList();
		req.setAttribute("list", list);
		
		RequestDispatcher rd = req.getRequestDispatcher("board/boardList.jsp");
		rd.forward(req, res);
	}

}
