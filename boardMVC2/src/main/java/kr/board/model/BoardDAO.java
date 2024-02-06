package kr.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BoardDAO {
	ArrayList<Board> list;

	private static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();

		return instance;
	}

	private Connection conn; // db 객체
	private PreparedStatement ps; // 쿼리문 객체
	private ResultSet rs; // 뷰테이블 객체

	// 데이터베이스 연동하기
	private void getConnect() {
		String url = "jdbc:mysql://localhost:3306/board?useSSL=false&allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 데이터 베이스 연결 끊기
	private void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 데이터 베이스에서 리스트 불러오기
	public ArrayList<Board> getBoardList() {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from board";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("no");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String contents = rs.getString("contents");
				String regDate = rs.getString("regDate");

				Board b = new Board(num, writer, subject, contents, regDate);
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 더미 게시글 생성
	public int createDummies(int size) {
		LocalDate date = LocalDate.now();
		String sql = "insert into board value(null,?,?,?,?)";
		int num = 0;
		getConnect();
		try {
			for (int i = 0; i < size; i++) {
				ps = conn.prepareStatement(sql);
				ps.setString(1, "작성자" + i);
				ps.setString(2, "제목" + i);
				ps.setString(3, "내용" + i);
				ps.setString(4, date.toString());
				num = ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return num;
	}

	// 게시글 하나 가져오기
	public Board getOneBoard(int no) {
		ArrayList<Board> list = getBoardList();
		for (Board b : list) {
			if (b.getNo() == no) {
				return b;
			}
		}
		return null;
	}

	// 게시글 업데이트
	public int updateOneBoard(String no, String subject, String contents) {
		int idx = 0;
		String sql = "update board set subject=?, contents=? where no=?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, subject);
			ps.setString(2, contents);
			ps.setInt(3, Integer.parseInt(no));
			idx = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return idx;
	}

	// 게시글 하나 삭제
	public int deleteOneMember(int no) {
		int cnt = 0;

		String sql = "delete from board where no = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {

		} finally {
			dbClose();
		}
		return cnt;
	}

	// 게시글 전체 삭제 - 유니크키 초기화
	public int deleteAllMember() {
		int cnt = 0;

		String sql1 = "delete from board";
		String sql2 = "alter table board auto_increment=1";

		try {
			getConnect();
			ps = conn.prepareStatement(sql1);
			cnt = ps.executeUpdate();
			ps = conn.prepareStatement(sql2);
			cnt = ps.executeUpdate();
		} catch (SQLException e) {

		} finally {
			dbClose();
		}
		return cnt;
	}

	// 게시글 하나 추가
	public int addOneBoard(String writer, String subject, String contents) {
		int cnt = 0;
		LocalDate date = LocalDate.now();
		String sql = "insert into board value(null,?,?,?,?)";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, writer);
			ps.setString(2, subject);
			ps.setString(3, contents);
			ps.setString(4, date.toString());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return cnt;
	}

	// 페이징 게시판

	public int boardCnt = 5; // 한페이지에 보여줄 게시글 수
	public int curPageNum = 1; // 현재 페이지 번호

	// 페이지 시작 번호
	public void setCurPageNum(String start) {
		curPageNum = Integer.parseInt(start);
	}
	
	public int[] getRowData() {
		ArrayList<Board> list = getBoardList();
		int startNum = (curPageNum - 1) * boardCnt;
		int endNum = startNum + boardCnt;
		endNum = endNum > list.size() ? list.size() : endNum;
		int[] arr = { startNum, endNum };

		return arr;
	}

	public int pageNumCnt = 3;// 한페이지에 보여줄 페이지 번호 개수
	public int startPageNum = 1; // 한페이지에 보여줄 페이지 시작 번호

	// 페이지 전환시 페이징 시작 번호
	public void setStartPageNum(String end) {
		startPageNum = Integer.parseInt(end);
	}
	// 현제 페이징 끝 번호
	public int getEndPageNum() {
		int endPageNum = startPageNum + pageNumCnt - 1;
		endPageNum = endPageNum > getTotalPageCnt() ? getTotalPageCnt() : endPageNum;
		return endPageNum;
	}

	// 전체 페이지 카운트
	public int getTotalPageCnt() {
		ArrayList<Board> list = getBoardList();
		return list.size() % boardCnt == 0 ? list.size() / boardCnt : list.size() / boardCnt + 1;
	}
	
	// 데이터 베이스에서 페이징 보드용
	public ArrayList<Board> getPagingBoardList() {
		int[] row = getRowData();
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from board orders limit ? offset ?;";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardCnt);
			ps.setInt(2, row[0]);
			rs = ps.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("no");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String contents = rs.getString("contents");
				String regDate = rs.getString("regDate");

				Board b = new Board(num, writer, subject, contents, regDate);
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
}
