package kr.basic.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.basic.model.MemberDAO;

import java.io.IOException;

@WebServlet("/memberLogin.do")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		int log = MemberDAO.getInstance().checkLogin(id, pw);

		if (log == 0) {
			res.sendRedirect("member/memberLogin.jsp");
			return;
		}
		session.setAttribute("log", log);
		RequestDispatcher rd = req.getRequestDispatcher("member/header.jsp");
		rd.forward(req, res);
	}
}
