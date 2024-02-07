package kr.basic.model;

//JDBC->myBatis, JPA
import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	// db용
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// db에 연결
	public void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
			System.out.println("db 연동성공: " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// db에서 테이블 불러오기
	public ArrayList<MemberVO> getMemberList() {
		String SQL = "select * from member";
		getConnect();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 맴버 한명 가져가기
	public MemberVO getOneMember(int num) {
		MemberVO vo = null;
		String sql = "select * from member where num = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				vo = new MemberVO(num, id, pass, name, age, email, phone);
			}
		} catch (Exception e) {

		} finally {
			dbClose();
		}

		return vo;
	}

	// 맴버 업데이트
	public int memberUpdate(int num, int age, String email, String phone) {
		int cnt = 0;
		String sql = "update member set age = ?, email = ?, phone = ? where num = ?";
		// 물음표 4개
		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, age);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setInt(4, num);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 맴버 삭제
	public int memberDelete(String id) {
		int cnt = 0;
		String sql = "delete from member where id = ?";
		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 회원 가입
	public int memberInsert(MemberVO vo) {
		int cnt = 0;
		String sql = "insert into member(id, pass, name, age, email, phone) value(?,?,?,?,?,?)";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return cnt;
	}

	// 로그인 체크
	public int checkLogin(String id, String pass) {
		int cnt = 0;
		String sql = "select * from member where id = ? and pass = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("num");
				System.out.println(rs.getInt("num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		System.out.println(cnt);
		return cnt;
	}

	// db 닫기
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
