package kr.board.frontcontroller;

public class ViewResolver {
	public static String makeView(String nextPage) {
		String uri = null;
		if(nextPage.indexOf("index") != -1) {
			uri = nextPage + ".jsp";
		}else {
			uri = "WEB-INF/board/" + nextPage + ".jsp"; 
		}
		return uri;
	}
}
