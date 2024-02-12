package kr.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.member.model.MemberDAO;
import kr.member.model.MemberVO;

public class MemberUpdateController implements Controller {

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("num") == null) {
			return "memberContent";
		}
		int num = Integer.parseInt(req.getParameter("num"));
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		MemberVO vo = new MemberVO();
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		String ctx = req.getContextPath();
		int cnt = MemberDAO.getInstance().memberUpdate(vo);

		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not update");
		}
	}

}
