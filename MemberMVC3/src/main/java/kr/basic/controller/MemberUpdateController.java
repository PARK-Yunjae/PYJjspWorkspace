package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;

//맴버 업데이트
public class MemberUpdateController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		if (req.getParameter("num") == null) {
			return "memberContent";
		}
		int num = Integer.parseInt(req.getParameter("num"));
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		int cnt = MemberDAO.getInstance().memberUpdate(num, age, email, phone);

		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not update");
		}
	}

}
