package kr.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;
import kr.board.model.BoardVO;

// 게시글 하나 삭제
public class BoardOneDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String no = req.getParameter("no");
		String ctx = req.getContextPath();
		BoardVO vo = BoardDAO.getInstance().getOneBoard(no);
		String delFileName = vo.getsFileName();
		int cnt = BoardDAO.getInstance().boardOneDelete(Integer.parseInt(no));
		if(cnt > 0) {
			String saveDirectory = req.getServletContext().getRealPath("/image");
			FileUtil.deleteFile(req, saveDirectory, delFileName);
			return "redirect:" + ctx + "/boardList.do";
		}else {
			throw new ServletException("not delete");
		}
	}

}
