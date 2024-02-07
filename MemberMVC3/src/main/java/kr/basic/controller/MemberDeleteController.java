package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;

// 맴버 삭제
public class MemberDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		int cnt = MemberDAO.getInstance().memberDelete(req.getParameter("id"));

		if (cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		} else {
			throw new ServletException("not delete");
		}
	}

}
