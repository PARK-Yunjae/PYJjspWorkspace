package member;

import java.util.ArrayList;

public class MemberDAO {

	private ArrayList<Member> mList;
	private String title = "";
	private int log;

	public MemberDAO() {
		mList = new ArrayList<Member>();
		mList.add(new Member("admin", "admin", "관리자", "남성"));
		mList.add(new Member("qwer", "1111", "이만수", "남성"));
		mList.add(new Member("abcd", "2222", "박영희", "여성"));
		mList.add(new Member("hello", "3333", "이수민", "여성"));
		log = -1;
		title="로그아웃 상태";
	}

	public ArrayList<Member> getmList() {
		return mList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLog() {
		return log;
	}

	public void setLog(int log) {
		this.log = log;
	}

	// 회원 가입 시 ID 중복 체크
	public boolean idCheck(String id) {
		for (int i = 0; i < mList.size(); i++) {
			if (id.equals(mList.get(i).getId())) {
				return false;
			}
		}
		return true;
	}
	
	// 회원 가입 시 ID 중복 체크
	public int pwCheck(String pw) {
		for (int i = 0; i < mList.size(); i++) {
			if (pw.equals(mList.get(i).getPw())) {
				return i;
			}
		}
		return -1;
	}
	// 로그인 시 ID PW 체크
	public int loginCheck(String id, String pw) {
		for (int i = 0; i < mList.size(); i++) {
			if (id.equals(mList.get(i).getId()) &&
				pw.equals(mList.get(i).getPw())) {
				return i;
			}
		}
		return -1;
	}
	
	// 회원 삭제
	public void DeleteMember(int idx) {
		mList.remove(idx);
	}
	
	// 이름 보내기
	public String nameValue(int idx) {
		return mList.get(idx).getName();
	}
}
