package kr.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

import java.io.IOException;

// 게시글 하나 삭제
@WebServlet("/BoardOneDelete.do")
public class BoardOneDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		String no = req.getParameter("no");

		if (no == null) {
			res.sendRedirect(ctx + "/memberList.do");
			return;
		}
		
		BoardDAO.getInstance().deleteOneMember(Integer.parseInt(no));

		res.sendRedirect(ctx + "/BoardList.do");
	
	}

}
