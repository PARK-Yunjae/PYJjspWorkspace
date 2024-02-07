package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;
import kr.basic.model.MemberVO;

// 맴버 리스트
public class MemberListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// POJO가 해야할 일의 범위
		// 1. Model 연동
		ArrayList<MemberVO> list = MemberDAO.getInstance().getMemberList();
		// 2. 객체바인딩
		req.setAttribute("list", list);
		// member/memberList.jsp
		// 다음페이지는
		// 3.다음페이지정보(View)
		return "memberList";

	}
}
