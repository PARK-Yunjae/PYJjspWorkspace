package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

import java.io.IOException;

// 더미 게시글 생성 
@WebServlet("/BoardAddDummy.do")
public class BoardAddDummyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardDAO.getInstance().createDummies(30);

		res.sendRedirect("board/main.jsp");
	}

}
