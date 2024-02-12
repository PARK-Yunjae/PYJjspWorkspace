package kr.board.model;

public class BoardVO {
	private int no;
	private String writer;
	private String subject;
	private String contents;
	private String regDate;
	private String oFileName;
	private String sFileName;

	public BoardVO(int no, String writer, String subject, String contents, String regDate, String oFileName,
			String sFileName) {
		this.no = no;
		this.writer = writer;
		this.subject = subject;
		this.contents = contents;
		this.regDate = regDate;
		this.oFileName = oFileName;
		this.sFileName = sFileName;
	}

	public String getoFileName() {
		return oFileName;
	}

	public void setoFileName(String oFileName) {
		this.oFileName = oFileName;
	}

	public String getsFileName() {
		return sFileName;
	}

	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", writer=" + writer + ", subject=" + subject + ", contents=" + contents
				+ ", regDate=" + regDate + ", oFileName=" + oFileName + ", sFileName=" + sFileName + "]";
	}


}
