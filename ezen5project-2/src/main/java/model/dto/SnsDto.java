package model.dto;

public class SnsDto {
	private int sno;
	private String simg;
	private String sid;
	private String scontent;
	private String spwd;
	private String sdate;

	
	
	// 생성자
	public SnsDto() {}

	public SnsDto(int sno, String simg, String sid, String scontent, String spwd, String sdate) {
		super();
		this.sno = sno;
		this.simg = simg;
		this.sid = sid;
		this.scontent = scontent;
		this.spwd = spwd;
		this.sdate = sdate;
	}



	// getter setter
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSimg() {
		return simg;
	}

	public void setSimg(String simg) {
		this.simg = simg;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "SnsDto [sno=" + sno + ", simg=" + simg + ", sid=" + sid + ", scontent=" + scontent + ", spwd=" + spwd
				+ ", sdate=" + sdate + "]";
	}
	    
	    
}



