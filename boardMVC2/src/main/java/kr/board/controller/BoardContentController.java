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

// 게시글 클릭
@WebServlet("/BoardContent.do")
public class BoardContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	int no = Integer.parseInt(req.getParameter("no"));
    	
    	Board b = BoardDAO.getInstance().getOneBoard(no);
    	req.setAttribute("b", b);
		RequestDispatcher rd = req.getRequestDispatcher("board/boardContent.jsp?no="+no);
		rd.forward(req, res);
	}

}
