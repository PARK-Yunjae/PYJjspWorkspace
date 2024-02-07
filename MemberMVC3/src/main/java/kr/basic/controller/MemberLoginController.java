package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.MemberDAO;
import kr.basic.model.MemberVO;

// 로그인
public class MemberLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		if (req.getParameter("id") == null) {
			return "memberLogin";
		}
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		int cnt = MemberDAO.getInstance().checkLogin(id, pass);
		if (cnt > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("log", cnt);
			return "redirect:" + ctx + "/memberList.do";
		} else {
			return "redirect:" + ctx + "/memberLogin.do";
		}
	}

}
