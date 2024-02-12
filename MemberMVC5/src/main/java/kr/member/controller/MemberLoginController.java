package kr.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.member.model.MemberDAO;

// 로그인 페이지 갈때와 로그인 시도할때
public class MemberLoginController implements Controller {

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 값이 안넘어오고 페이지 이동시엔 로그인 창으로
		if (req.getParameter("id") == null) {
			return "memberLogin";
		}
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String ctx = req.getContextPath();
		
		if(MemberDAO.getInstance().checkLogin(id, pw)) {
			HttpSession session = req.getSession();
			session.setAttribute("log", MemberDAO.getInstance().getMemberNo(id));
			session.setAttribute("loginId", id);
			return "redirect:" + ctx + "/memberList.do";
		}else {
			return "redirect:" + ctx + "/memberLogin.do";
		}
	}
}
