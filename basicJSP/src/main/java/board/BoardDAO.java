package board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BoardDAO {
	private ArrayList<BoardVO> bList;
	private int cnt = 0;
	private int count; // 전체 게시글 수
	private int pageSize = 5; // 한 페이지에 보여줄 게시글 수
	private int curPageNum = 1; // 현재 페이지 번호
	private int pageCount = 0; // 전체 페이지 개수
	private int startRow = 0; // 현재 페이지의 게시글 시작 번호
	private int endRow = 0; // 현재 페이지의 게시글 마지막 번호

	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum;
	}

	public int getCount() {
		return count;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public int getCurPageNum() {
		return curPageNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public BoardDAO() {
		this.bList = new ArrayList<BoardVO>();
	}

	public ArrayList<BoardVO> getbList() {
		return bList;
	}

	public int getCnt() {
		return cnt;
	}

	// 더미글 10개 추가
	public void AddDummy() {
		for (int i = 0; i < 10; i++) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			bList.add(new BoardVO(cnt++, "작성자", "제목", "내용", formatter.format(date)));
		}
	}

	// 글 1개 삭제
	public void deleteBoard(int idx) {
		bList.remove(idx);
	}

	// 글 전체 삭제
	public void deleteAllBoard() {
		bList = new ArrayList<BoardVO>();
	}

	// 게시글 추가
	public void addBoard(String write, String subject, String contents) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		bList.add(new BoardVO(cnt++, write, subject, contents, formatter.format(date)));
	}

	// 페이징 게시판
	public void pagingBoard() {
		count = bList.size();
		pageCount = count / pageSize;
		if (count % pageSize > 0)
			pageCount += 1;
		startRow = (curPageNum - 1) * pageSize;
		endRow = startRow + pageSize;
		if (endRow > count)
			endRow = count;
	}

}
