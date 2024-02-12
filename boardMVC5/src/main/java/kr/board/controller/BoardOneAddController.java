package kr.board.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.model.BoardDAO;

// 게시글 하나 추가
public class BoardOneAddController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		if (req.getParameter("no") == null) {
			int no = BoardDAO.getInstance().insertAddNo();
			req.setAttribute("no", no);
			return "boardInsert";
		}
		
		String ctx = req.getContextPath();
		String saveDirectory = req.getServletContext().getRealPath("/image"); //add?파일?
		// 해당 경로에 폴더가 없으면 만들어줌 image로 
		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		String oFileName = FileUtil.uploadFile(req, saveDirectory);
		// 저장된 파일명 변경하기
		String sFileName = FileUtil.renameFile(saveDirectory, oFileName);
		String writer = req.getParameter("writer");
		String subject = req.getParameter("subject");
		String contents = req.getParameter("contents");

		int cnt = BoardDAO.getInstance().insertOneBoard(writer, subject, contents, oFileName, sFileName);

		if (cnt > 0) {
			return "redirect:" + ctx + "/boardList.do";
		} else {
			throw new ServletException("not Update");
		}
	}

}
