package kr.basic.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.controller.Controller;

import java.io.IOException;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 실제 경로 따오기
		// uri에서 ctx 만 잘르면 경로가 나온다
		String uri = req.getRequestURI();
		String ctx = req.getContextPath();
		String command = uri.substring(ctx.length());
		
		Controller controller = null;
		String nextPage = null;
		
		// 여기서 controller 를 불러오고 다음으로 갈 주소도 받아온다
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(req, res);
		
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
