package kr.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	// 데이터베이스 연결용 클래스
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 데이터베이스 접속
	private void getConnect() {
		String uri = "jdbc:mysql://localhost:3306/board?useSSL=false&allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "Abcd123@";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(uri, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 로그아웃
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

	// 전체 게시글 확인하기
	public ArrayList<BoardVO> getBoardList() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String SQL = "select * from boardMv5";

		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String contents = rs.getString("contents");
				String regDate = rs.getString("regDate");
				String oFileName = rs.getString("oFileName");
				String sFileName = rs.getString("sFileName");
				BoardVO vo = new BoardVO(no, writer, subject, contents, regDate, oFileName, sFileName);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 게시글 하나 가져오기
	public BoardVO getOneBoard(String no) {
		int num = Integer.parseInt(no);
		BoardVO vo = null;
		String sql = "select * from boardMv5 where no = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String contents = rs.getString("contents");
				String regDate = rs.getString("regDate");
				String oFileName = rs.getString("oFileName");
				String sFileName = rs.getString("sFileName");
				vo = new BoardVO(num, writer, subject, contents, regDate, oFileName, sFileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return vo;
	}

	// 게시글 하나 삭제
	public int boardOneDelete(int no) {
		int cnt = 0;
		String sql = "delete from boardMv5 where no = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 게시글 업데이트
	public int updateOneBoard(int no, String subject, String contents) {
		int cnt = 0;

		String sql = "update boardMv5 set subject=?, contents=? where no = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, subject);
			ps.setString(2, contents);
			ps.setInt(3, no);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return cnt;
	}

	// 더미 게시글 만들기
	public int createDummies(int size) {
		int cnt = 0;
		LocalDate date = LocalDate.now();
		String sql = "insert into boardMv5 value(null,?,?,?,?,null,null);";

		try {
			getConnect();
			for (int i = 0; i < size; i++) {
				ps = conn.prepareStatement(sql);
				ps.setString(1, "작성자" + i);
				ps.setString(2, "제목" + i);
				ps.setString(3, "내용" + i);
				ps.setString(4, date.toString());
				cnt = ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return cnt;
	}

	// 데이터 전체 삭제
	public int boardAllDelete() {
		int cnt = 0;
		String sql1 = "delete from boardMv5";
		String sql2 = "alter table boardMv5 auto_increment=1";

		try {
			getConnect();
			ps = conn.prepareStatement(sql1);
			cnt = ps.executeUpdate();
			ps = conn.prepareStatement(sql2);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return cnt;
	}

	// 게시글 작성시 넘버 넘겨주기
	public int insertAddNo() {
		ArrayList<BoardVO> list = getBoardList();
		return list.size();
	}

	// 게시글 새로 하나 추가
	public int insertOneBoard(String writer, String subject, String contents, String oFileName, String sFileName) {
		int cnt = 0;
		LocalDate date = LocalDate.now();
		String sql = "insert into boardMv5 value(null,?,?,?,?,?,?)";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, writer);
			ps.setString(2, subject);
			ps.setString(3, contents);
			ps.setString(4, date.toString());
			ps.setString(5, oFileName);
			ps.setString(6, sFileName);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return cnt;
	}

	// 보드 이미지 변경시 
	public int boardUploadPhoto(int no, String oFileName, String sFileName) {
		String SQL = "update boardMv5 set oFileName=?, sFileName=? where no=?";
		int cnt = -1;
		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, oFileName);
			ps.setString(2, sFileName);
			ps.setInt(3, no);
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	// 페이징 게시판

	private int boardCnt = 5; // 한 페이지에 보여줄 게시글 수
	private int curPageNum = 1; // 현재 페이지 번호
	private int pageNumCnt = 3; // 한 페이지에 보여줄 페이지 번호 개수
	private int startPageNum = 1; // 한 페이지에 보여줄 페이지 시작 번호

	public int getPageNumCnt() {
		return pageNumCnt;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	// 페이지 시작 번호
	public void setCurPageNum(String start) {
		curPageNum = Integer.parseInt(start);
	}

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

	// 전체 페이징 카운트
	public int getTotalPageCnt() {
		ArrayList<BoardVO> list = getBoardList();
		return list.size() % boardCnt == 0 ? list.size() / boardCnt : list.size() / boardCnt + 1;
	}

	// 페이징게시판용 리스트 받아오기
	public ArrayList<BoardVO> getPagingBoardList() {
		int startNum = (curPageNum - 1) * boardCnt;

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from boardMv5 orders limit ? offset ?;";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			System.out.println(boardCnt);
			System.out.println(startNum + 1);
			ps.setInt(1, boardCnt);
			ps.setInt(2, startNum);
			rs = ps.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String contents = rs.getString("contents");
				String regDate = rs.getString("regDate");
				String oFileName = rs.getString("oFileName");
				String sFileName = rs.getString("sFileName");
				BoardVO vo = new BoardVO(no, writer, subject, contents, regDate, oFileName, sFileName);
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return list;
	}
}
