package kr.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.*;

public class BoardListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<BoardVO> list = BoardDAO.getInstance().getBoardList();
		req.setAttribute("list", list);
		
		return "boardList";
	}

}
