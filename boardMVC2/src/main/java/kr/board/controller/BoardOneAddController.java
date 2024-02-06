package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

import java.io.IOException;

// 게시글 하나 추가
@WebServlet("/BoardOneAdd.do")
public class BoardOneAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
	
		BoardDAO.getInstance().addOneBoard(writer, subject, contents);
	
		String ctx = req.getContextPath();	
		res.sendRedirect(ctx + "/BoardList.do");
	
	}

}
