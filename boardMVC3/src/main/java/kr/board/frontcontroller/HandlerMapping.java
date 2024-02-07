package kr.board.frontcontroller;

import java.util.HashMap;

import kr.board.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;

	// 생성자
	public HandlerMapping() {
		this.mappings = new HashMap<String, Controller>();
		this.mappings.put("/boardAddDummy.do", new BoardAddDummyController());
		this.mappings.put("/boardAllDelete.do", new BoardAllDeleteController());
		this.mappings.put("/boardContent.do", new BoardContentController());
		this.mappings.put("/boardIndex.do", new BoardIndexController());
		this.mappings.put("/boardList.do", new BoardListController());
		this.mappings.put("/boardListPaging.do", new BoardListPagingController());
		this.mappings.put("/boardOneAdd.do", new BoardOneAddController());
		this.mappings.put("/boardOneDelete.do", new BoardOneDeleteController());
		this.mappings.put("/boardUpdate.do", new BoardUpdateController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
