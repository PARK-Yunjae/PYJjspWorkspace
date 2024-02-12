package kr.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.member.model.MemberDAO;
import kr.member.model.MemberVO;

// 회원 목록 보여주기
public class MemberListController implements Controller{

	@Override
	public String requesthandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		ArrayList<MemberVO> list = MemberDAO.getInstance().memberList();
		
		req.setAttribute("list", list);
		HttpSession session = req.getSession();
		if(session.getAttribute("log") != null) {
			int num = (int) session.getAttribute("log");
			req.setAttribute("num", num); // 내 목록만 삭제 수정 가능
		}else {
			req.setAttribute("num", null);
		}
		return "memberList";
	}

}
