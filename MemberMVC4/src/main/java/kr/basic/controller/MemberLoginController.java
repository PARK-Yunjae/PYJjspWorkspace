package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.MemberDAO;

// 로그인 페이지 가는 경우와 로그인 확인 할 경우 두가지
public class MemberLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");

		if (req.getParameter("id") == null) {
			return "memberLogin";
		}

		String ctx = req.getContextPath();

		HttpSession session = req.getSession();
		session.setAttribute("log", MemberDAO.getInstance().getMemberNo(id));

		return "redirect:" + ctx + "/memberList.do";
	}

}
