package kr.board.frontcontroller;

import java.util.HashMap;

import kr.board.controller.*;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/boardAddDummy.do", new BoardAddDummyController());
		mappings.put("/boardAllDelete.do", new BoardAllDeleteController());
		mappings.put("/boardContent.do", new BoardContentController());
		mappings.put("/boardDeleteImg.do", new BoardDeleteImgController());
		mappings.put("/boardIndex.do", new BoardIndexController());
		mappings.put("/boardList.do", new BoardListController());
		mappings.put("/boardOneAdd.do", new BoardOneAddController());
		mappings.put("/boardOneDelete.do", new BoardOneDeleteController());
		mappings.put("/boardListPaging.do", new BoardListPagingController());
		mappings.put("/boardUpdate.do", new BoardUpdateController());
		mappings.put("/boardUploadImg.do", new BoardUploadImgController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
