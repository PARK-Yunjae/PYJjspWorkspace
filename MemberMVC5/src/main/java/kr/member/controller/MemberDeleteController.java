package kr.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.member.model.MemberDAO;
import kr.member.model.MemberVO;

// 회원 탈퇴 or 회원 삭제(관리자)
public class MemberDeleteController implements Controller {

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		// 파일명 확인하고 삭제 위해서 맴버 받아옴
		MemberVO vo = MemberDAO.getInstance().memberContent(Integer.parseInt(req.getParameter("num")));
		String delFileName = vo.getsFileName();
		String id = req.getParameter("id");
		int cnt = MemberDAO.getInstance().memberDelete(id);

		if (cnt > 0) {
			if(!id.equals("admin")) {
				HttpSession session = req.getSession();
				session.invalidate();
			}
			String saveDirectory = req.getServletContext().getRealPath("/image");
			FileUtil.deleteFile(req, saveDirectory, delFileName);
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not delete");
		}
	}

}
