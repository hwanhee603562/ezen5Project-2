package model.dto;

public class ReplyDto {
	// 댓글 테이블 DTO
	
	int rno;			// 댓글 번호 [PK]
    String rpwd;		// 댓글 패스워드
    String rcontent;	// 댓글
    String rdate;		// 작성일자
    int sno;			// 댓글을 작성한 게시물 번호 [FK]
    
    
    
    // 생성자
    public ReplyDto() {}
    
	public ReplyDto(int rno, String rpwd, String rcontent, String rdate, int sno) {
		super();
		this.rno = rno;
		this.rpwd = rpwd;
		this.rcontent = rcontent;
		this.rdate = rdate;
		this.sno = sno;
	}

	
	
	// getter  setter
	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRpwd() {
		return rpwd;
	}

	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "ReplyDto [rno=" + rno + ", rpwd=" + rpwd + ", rcontent=" + rcontent + ", rdate=" + rdate + ", sno="
				+ sno + "]";
	}
	
	
	
	
	
	
	
	
}
