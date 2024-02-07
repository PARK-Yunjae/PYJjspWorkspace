package kr.basic.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;
import kr.basic.model.MemberVO;

// 회원 목록 띄우기
public class MemberListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<MemberVO> list = MemberDAO.getInstance().memberList();
		System.out.println(list.size());
		System.out.println(list.get(0).getNum());
		req.setAttribute("list", list);
		return "memberList";
	}

}
