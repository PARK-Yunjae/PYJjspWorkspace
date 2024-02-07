package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;
import kr.basic.model.MemberVO;

//회원가입
public class MemberInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();

		if (req.getParameter("id") == null) {
			return "memberInsert";
		}

		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
		int cnt = MemberDAO.getInstance().memberInsert(vo);

		if (cnt > 0) {
			// 가입성공
			// out.println("insert success");
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not insert");
		}
	}

}
