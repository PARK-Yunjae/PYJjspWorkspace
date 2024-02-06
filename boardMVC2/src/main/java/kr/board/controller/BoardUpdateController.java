package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

import java.io.IOException;

// 게시글 업데이트
@WebServlet("/BoardUpdate.do")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		
		String no = req.getParameter("no");
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");
		
		BoardDAO.getInstance().updateOneBoard(no, subject, contents);
		
		res.sendRedirect(ctx + "/BoardList.do");
	}

}
