package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;

// 페이지 전환 없이 중복 ID 체크
public class VaildIdAjaxController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// $.ajax();
		String id = req.getParameter("id");
		String passData = MemberDAO.getInstance().isValidId(id) ? "notValid" : "valid";
		
		// ajax() 함수에 만들어 놓은 callback 함수 응답
		res.getWriter().print(passData); // "notValid" : "valid"
		return null;
	}

}
