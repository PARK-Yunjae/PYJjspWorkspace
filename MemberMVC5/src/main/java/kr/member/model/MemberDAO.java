package kr.member.model;

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
	
	// sql 사용 전용
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 데이터 베이스 로그인
	public void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/mvc05db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "Abcd123@";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
			System.out.println("db 연동성공: " + conn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 데이터 베이스 로그아웃
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
	
	// 회원 가입
	public int memberInsert (MemberVO vo) {
		String SQL = "insert into member(id, pass, name, age, email, phone, oFileName, sFileName) values(?,?,?,?,?,?,?,?)";
		int cnt = -1;
		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			ps.setString(7, vo.getoFileName());
			ps.setString(8, vo.getsFileName());
			cnt = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// 맴버 리스트 데이터 베이스에서 가져오기
	public ArrayList<MemberVO> memberList() {
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
				String oFileName = rs.getString("oFileName");
				String sFileName = rs.getString("sFileName");

				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone, oFileName, sFileName);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	// 이 id의 비밀번호를 보내기
	public boolean isValidId(String id) {
		String SQL = "select pass from member where id=?";

		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
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
	
	// 로그인 시도
	public boolean checkLogin(String id, String pw) {
		String SQL = "select * from member where id=? and pass=?";
		
		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}
	
	// 이 아이디가 중복 아이디인가?
	public int getMemberNo(String id) {
		String SQL = "select num from member where id=?";

		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
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
	
	// 회원 탈퇴 & 맴버 삭제(관리자)
	public int memberDelete(String id) {
		String SQL = "delete from member where id=?";
		int cnt = -1;
		
		try {
			getConnect();
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
	
	// 맴버 수정 시 값 가져가는 메서드
	public MemberVO memberContent(int num) {
		String SQL = "select * from member where num=?";
		MemberVO vo = null;
		
		try {
			getConnect();
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
				String oFileName = rs.getString("oFileName");
				String sFileName = rs.getString("sFileName");

				vo = new MemberVO(num, id, pass, name, age, email, phone, oFileName, sFileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
	// 맴버 업데이트
	public int memberUpdate(MemberVO vo) {
		String SQL = "update member set age=?, email=?, phone=? where num=?";
		int cnt = -1;
		
		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	// 맴버 파일업로드시
	public int memberUploadPhoto(int num, String oFileName, String sFileName) {
		String SQL = "update member set oFileName=?, sFileName=? where num=?";
		int cnt = -1;
		try {
			getConnect();
			ps = conn.prepareStatement(SQL);
			ps.setString(1, oFileName);
			ps.setString(2, sFileName);
			ps.setInt(3, num);
			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
}
