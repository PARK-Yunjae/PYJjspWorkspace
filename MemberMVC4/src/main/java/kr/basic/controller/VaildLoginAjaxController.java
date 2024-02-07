package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;

public class VaildLoginAjaxController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// $.ajax();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		boolean pass = MemberDAO.getInstance().checkLogin(id, pw);
		// ajax() 함수에 만들어 놓은 callback 함수 응답
		res.getWriter().print(pass); // true : false
		return null;
	}

}
