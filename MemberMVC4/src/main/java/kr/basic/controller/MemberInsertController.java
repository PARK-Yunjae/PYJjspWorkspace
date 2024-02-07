package kr.basic.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.basic.model.MemberDAO;
import kr.basic.model.MemberVO;

// 두가지 경우 가입 페이지 갈때 가입 끝날때
public class MemberInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 회원 가입 하러 들어갈때
		if(req.getParameter("id") == null) {
			return "memberInsert";
		}
		// 회원 가입 전부 입력 하고 db에 저장 할 때
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age")); 
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		
		MemberVO vo=new MemberVO(0, id, pass, name, age, email, phone);

		int cnt= MemberDAO.getInstance().memberInsert(vo);
		String ctx = req.getContextPath();
		
		if(cnt > 0) {
			return "redirect:" + ctx + "/memberList.do";
		}else {
			throw new ServletException("not Insert");
		}
	}

}
