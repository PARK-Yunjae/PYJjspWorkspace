package kr.member.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.member.model.MemberDAO;
import kr.member.model.MemberVO;

// 회원 가입 - 파일 업로드 tomcat10버전
public class MemberAddController implements Controller {

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String saveDirectory = req.getServletContext().getRealPath("/image"); //add?파일?
		// 해당 경로에 폴더가 없으면 만들어줌 Uploads로 
		Path saveDirPath = Paths.get(saveDirectory);
		if (!Files.isDirectory(saveDirPath)) {
			Files.createDirectories(saveDirPath);
		}
		System.out.println("saveDirectory = " + saveDirectory);
		// 파일 업로드 하기
		String oFileName = FileUtil.uploadFile(req, saveDirectory);
		// 저장된 파일명 변경하기
		String sFileName = FileUtil.renameFile(saveDirectory, oFileName);
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		MemberVO vo = null;
		System.out.println("savefileName= " + sFileName);
		System.out.println("orginFileName= " + oFileName);
		vo = new MemberVO(id, pass, name, age, email, phone, oFileName, sFileName);

		String ctx = req.getContextPath();
		int cnt = MemberDAO.getInstance().memberInsert(vo);
		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not insert");
		}
	}
}
