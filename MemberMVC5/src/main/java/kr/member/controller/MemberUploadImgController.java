package kr.member.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.member.model.MemberDAO;

// 이미지 파일 업데이트
public class MemberUploadImgController implements Controller{

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String saveDirectory = req.getServletContext().getRealPath("/image");

		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		System.out.println("saveDirectory = " + saveDirectory);
		// 파일 삭제
		FileUtil.deleteFile(req, saveDirectory, req.getParameter("sName"));

		// 파일 업로드 하기
		String oFileName = FileUtil.uploadFile(req, saveDirectory);
		// 저장된 파일명 변경하기
		String sFileName = FileUtil.renameFile(saveDirectory, oFileName);

		int num = Integer.parseInt(req.getParameter("num"));
		int cnt = MemberDAO.getInstance().memberUploadPhoto(num, oFileName, sFileName);
		if (cnt > 0) {
			res.getWriter().print(sFileName);
		} else {
			res.getWriter().print("fail");
		}
		return null;
	}

}
