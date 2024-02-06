package kr.board.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.board.model.Board;
import kr.board.model.BoardDAO;

import java.io.IOException;
import java.util.ArrayList;

// 리스트 세션에 추가
@WebServlet("/BoardSetAttribute.do")
public class BoardSetAttributeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<Board> list = BoardDAO.getInstance().getBoardList();
		session.setAttribute("list", list);		
		
		RequestDispatcher rd = req.getRequestDispatcher("board/main.jsp");
		rd.forward(req, res);
	}
}
