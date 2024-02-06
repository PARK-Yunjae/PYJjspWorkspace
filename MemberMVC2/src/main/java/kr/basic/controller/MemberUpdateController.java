package kr.basic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;

import java.io.IOException;

@WebServlet("/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		String log = req.getParameter("log");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		if (log == null) {
			res.sendRedirect(ctx + "/memberContent.do");
			return;
		}
		MemberDAO.getInstance().updateOneMember(
				Integer.parseInt(log), Integer.parseInt(age), email, phone);

		res.sendRedirect(ctx + "/memberList.do");
	}
}
