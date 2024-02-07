package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;
import kr.basic.model.MemberVO;

// 맴버 수정 페이지 갈때 - 내 아이디만 볼 수 있다 
public class MemberContentController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String ctx = req.getContextPath();
		int num = -1;
		
		if(req.getParameter("num") == null) {
			return "redirect:" + ctx + "/memberLogin.do";
		}else {
			num = Integer.parseInt(req.getParameter("num"));
		}
		MemberVO vo = MemberDAO.getInstance().memberContent(num);
		req.setAttribute("vo", vo);
		return "memberContent";
	}

}
