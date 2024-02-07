package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 로그아웃
public class MemberLogoutController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("log");
		String ctx = req.getContextPath();
		res.sendRedirect(ctx + "/memberList.do");
		return null;
	}

}
