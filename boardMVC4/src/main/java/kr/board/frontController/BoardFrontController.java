package kr.board.frontController;

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
       
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 실제 경로 따오기
		String uri = req.getRequestURI();
		String ctx = req.getContextPath();
		String command = uri.substring(ctx.length());
		
		// 컨트롤러 가져와서 실행 - 경로에 맞는
		Controller controller = null;
		String nextPage = null;
		// .do 를 주면 controller 를 받아온다
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(req, res); // 실행하고 다음 경로 반환
		
		if(nextPage != null) {
			// redirect면 이동만
			if(nextPage.indexOf("redirect:") != -1) {
				res.sendRedirect(nextPage.split(":")[1]);
			}else {// 값을 가져가야 되면 - ViewResolver에서 경로 받아서 옴
				RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(req, res);
			}
		}
	}

}
