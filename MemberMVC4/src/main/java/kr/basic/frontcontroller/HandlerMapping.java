package kr.basic.frontcontroller;

import java.util.HashMap;

import kr.basic.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/memberContent.do", new MemberContentController());
		mappings.put("/memberDelete.do", new MemberDeleteController());
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberLogin.do", new MemberLoginController());
		mappings.put("/memberLogout.do", new MemberLogoutController());
		mappings.put("/memberUpdate.do", new MemberUpdateController());
		mappings.put("/vaildIdAjax.do", new VaildIdAjaxController());
		mappings.put("/vaildLoginAjax.do", new VaildLoginAjaxController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
