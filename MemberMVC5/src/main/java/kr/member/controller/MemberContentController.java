package kr.member.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.member.model.MemberDAO;
import kr.member.model.MemberVO;

// 회원 수정 창으로
public class MemberContentController implements Controller{

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ctx = req.getContextPath(); // 파일 경로 받아오고
		int num = -1; // 몇번 글인지 확인
		// 맴버 수정으로 가는데 인데 번호를 받아오지 못했다면 
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
