package kr.member.frontController;

import java.util.HashMap;

import kr.member.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberContent.do", new MemberContentController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberLogin.do", new MemberLoginController());
		mappings.put("/memberLogout.do", new MemberLogoutController());
		mappings.put("/vaildIdAjax.do", new VaildIdAjaxController());

		// 파일 업로드
		mappings.put("/memberAdd.do", new MemberAddController());
		mappings.put("/memberUploadImg.do", new MemberUploadImgController());
		mappings.put("/memberDeleteImg.do", new MemberDeleteImgController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
