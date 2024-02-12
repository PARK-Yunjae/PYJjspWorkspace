package kr.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.member.model.MemberDAO;
import kr.member.model.MemberVO;

// 프로필 이미지 삭제 - 비동기용
public class MemberDeleteImgController implements Controller {

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 이미지 파일이 저장되어 있는 경로 받아오기?
		String saveDirectory = req.getServletContext().getRealPath("/image");
		int num = Integer.parseInt(req.getParameter("num"));
		// 맴버에서 변경된 파일명 받아와서 파일 삭제
		MemberVO vo = MemberDAO.getInstance().memberContent(num);
		FileUtil.deleteFile(req, saveDirectory, vo.getsFileName());
		// 맴버에서 이미지 파일 변경된것 업데이트 해주기
		int cnt = MemberDAO.getInstance().memberUploadPhoto(num, null, null);
		if (cnt > 0) {
			res.getWriter().print("success");
		} else {
			res.getWriter().print("fail");
		}

		return null;
	}

}
