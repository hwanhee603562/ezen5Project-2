package model.dto;

// 회원관리 정보 클래스
public class MemberList {
	private int mno;		// 회원번호 pk
	private String mname;	// 이름
	private String msno;	// 주민번호
	private String mphone;	// 전화번호
	private String memail;	// 이메일
	private String madress;	// 주소
	private String mid;		// 아이디
	private String mpwd;	// 비빌번호
	private int mlevel;		// 칭호
	private int mpoint;		// 포인트
    
    
    // 생성자
    public MemberList() {
		// TODO Auto-generated constructor stub
	}

	public MemberList(int mno, String mname, String msno, String mphone, String memail, String madress, String mid,
			String mpwd, int mlevel, int mpoint) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.msno = msno;
		this.mphone = mphone;
		this.memail = memail;
		this.madress = madress;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mlevel = mlevel;
		this.mpoint = mpoint;
	}
	
	
	// getter setter

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMsno() {
		return msno;
	}

	public void setMsno(String msno) {
		this.msno = msno;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMadress() {
		return madress;
	}

	public void setMadress(String madress) {
		this.madress = madress;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public int getMlevel() {
		return mlevel;
	}

	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	
	
	@Override
	public String toString() {
		return "MemberList [mno=" + mno + ", mname=" + mname + ", msno=" + msno + ", mphone=" + mphone + ", memail="
				+ memail + ", madress=" + madress + ", mid=" + mid + ", mpwd=" + mpwd + ", mlevel=" + mlevel
				+ ", mpoint=" + mpoint + "]";
	}
    
    
    
	
	
}
