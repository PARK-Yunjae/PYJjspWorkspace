package kr.basic.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.Member;
import kr.basic.model.MemberDAO;

import java.io.IOException;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath();
		String log = req.getParameter("log");

		if (log == null) {
			res.sendRedirect(ctx + "/memberList.do");
			return;
		}
		Member m = MemberDAO.getInstance().getMemberByNum(Integer.parseInt(log));
		req.setAttribute("log", log);
		req.setAttribute("m", m);
		RequestDispatcher rd = req.getRequestDispatcher("member/memberContent.jsp");
		rd.forward(req, res);
	}
}
