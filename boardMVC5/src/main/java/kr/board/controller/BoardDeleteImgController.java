package kr.board.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;
import kr.board.model.BoardVO;

public class BoardDeleteImgController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String saveDirectory = req.getServletContext().getRealPath("/image");
		String no = req.getParameter("no");
		// 보드에서 변경된 파일명 받아와서 파일 삭제
		BoardVO vo = BoardDAO.getInstance().getOneBoard(no);
		FileUtil.deleteFile(req, saveDirectory, vo.getsFileName());
		// 보드에서 이미지 파일 변경된것 업데이트 해주기
		int cnt = BoardDAO.getInstance().boardUploadPhoto(Integer.parseInt(no), null, null);
		if (cnt > 0) {
			res.getWriter().print("success");
		} else {
			res.getWriter().print("fail");
		}
		return null;
	}

}
