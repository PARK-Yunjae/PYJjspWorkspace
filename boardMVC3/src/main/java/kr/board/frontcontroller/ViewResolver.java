package kr.board.frontcontroller;

public class ViewResolver {
	public static String makeView(String nextPage) {
		String str = "";
		if(nextPage.equals("index")) {
			str = "index.jsp";
		}else {
			str = "/WEB-INF/board/" + nextPage + ".jsp";
		}
		return str;
	}}
