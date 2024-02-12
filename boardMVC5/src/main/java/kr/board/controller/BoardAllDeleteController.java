package kr.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

// 게시글 전체 삭제
public class BoardAllDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		String saveDirectory = req.getServletContext().getRealPath("/image");
		BoardDAO.getInstance().boardAllDelete();
		FileUtil.deleteAllFile(req, saveDirectory);
		return "redirect:" + ctx + "/boardList.do";
	}

}
