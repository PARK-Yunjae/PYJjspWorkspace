package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

import java.io.IOException;

// 게시글 전체 삭제
@WebServlet("/BoardAllDelete.do")
public class BoardAllDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BoardDAO.getInstance().deleteAllMember();

		res.sendRedirect("board/main.jsp");
	}

}
