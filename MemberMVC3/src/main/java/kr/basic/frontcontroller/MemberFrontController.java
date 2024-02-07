package kr.basic.frontcontroller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.controller.Controller;

@SuppressWarnings("serial")
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String url = req.getRequestURI();
		String ctx = req.getContextPath();
		// 실제로 요청한 명령이 무엇이지 파악
		String command = url.substring(ctx.length());
		Controller controller = null;
		String nextPage = null;
		// 핸들러매핑->HandlerMapping : 우리가 가지고 있는
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(req, res);
		// forward, redirect

		if (nextPage != null) {
			if (nextPage.indexOf("redirect:") != -1) {
				// redirect:/MemberMVC3/memberList.do
				res.sendRedirect(nextPage.split(":")[1]); // redirect
			} else {
				RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextPage)); // forward
				rd.forward(req, res);
			}
		}
	}
}
