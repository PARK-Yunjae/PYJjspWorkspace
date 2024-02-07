package kr.board.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.board.controller.Controller;

import java.io.IOException;

@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String ctx = req.getContextPath();
		// 실제로 요청한 명령이 무엇인지 파악
		String command = uri.substring(ctx.length());
		Controller con = null;
		String nextPage = null;
		// 핸들러 매핑 -> HandlerMapping : 우리가 가지고 있는 key 로 불러온다
		HandlerMapping mapping = new HandlerMapping();
		con = mapping.getController(command);
		nextPage = con.requestHandler(req, res);
		
		if(nextPage != null) {
			if(nextPage.indexOf("redirect:") != -1) {
				res.sendRedirect(nextPage.split(":")[1]);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(req, res);
			}
		}
				
	}
}
