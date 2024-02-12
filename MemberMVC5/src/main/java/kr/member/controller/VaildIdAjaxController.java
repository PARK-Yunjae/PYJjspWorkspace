package kr.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.member.model.MemberDAO;

// 중복 id 검사 - 비동기?
public class VaildIdAjaxController implements Controller{

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// $.ajax();
		String id=req.getParameter("id"); // { "id" : id  }
		String passData = MemberDAO.getInstance().isValidId(id)? "notValid" : "valid";
	
		// ajax() 함수에 만들어놓은 callback함수 응답
		res.getWriter().print(passData); // "notValid" : "valid";
		
		return null;
	}

}
