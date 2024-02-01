package board;

public class BoardVO {
	private int no; // 게시글 번호
	private String write; // 작성자
	private String subject; // 제목
	private String contents; // 내용
	private String regDate; // 작성일

	public BoardVO(int no, String write, String subject, String contents, String regDate) {
		this.no = no;
		this.write = write;
		this.subject = subject;
		this.contents = contents;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public String getWrite() {
		return write;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegDate() {
		return regDate;
	}

}
