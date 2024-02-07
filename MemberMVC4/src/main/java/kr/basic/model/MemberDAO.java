package kr.basic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	// 데이터 베이스에 연결
	private void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/testdb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 가입
	public int memberInsert(MemberVO vo) {
		String sql = "insert into member(id, pass, name, age, email, phone) value(?,?,?,?,?,?)";
		int cnt = -1;

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

	// 회원 목록
	public ArrayList<MemberVO> memberList() {
		String sql = "select * from member";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
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

	// ID 중복 체크
	public boolean isValidId(String id) {
		String sql = "select pass from member where id = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return false;
	}

	// 로그인시 id, pw 일치 체크
	public boolean checkLogin(String id, String pw) {
		String sql ="select * from member where id = ? and pass = ?";
		System.out.println("id=" +id);
		System.out.println("pw=" +pw);
		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			//System.out.println(rs.next());
			
			boolean check = rs.next();
			System.out.println("check=" + check);
			return check;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return false;
	}

	// 맴버의 num을 반환 로그인 session에 활용?
	public int getMemberNo(String id) {
		String sql = "select num from member where id = ?";

		try {
			getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return -1;
	}

	// 맴버 1개 삭제
	public int memberDelete(String id) {
		String SQL = "delete from member where id=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 로그인 맴버 수정용 1개의 행 반환
	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num=?";
		getConnect();
		MemberVO vo = null;
		try {
			ps = conn.prepareStatement(SQL);
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
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
	
	// 맴버 업데이트
	public int memberUpdate(int num, int age, String email, String phone) {
		String SQL = "update member set age=?, email=?, phone=? where num=?";
		int cnt = -1;
		
		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
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
}
