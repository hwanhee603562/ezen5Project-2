package model.dto;

// 게시판 카테고리 and 게시판
public class Board {
	/* 게시판 카테고리 */
	private int cno;			// 카테고리 pk
	private String cname;		// 카테고리명
    /* 게시판 구성 */
	private int bno;			// 게시판 pk
	private String btitle;		// 제목
	private String bcontent;	// 작성내용
	private String bdate;		// 작성일
	private String bfile;		// 첨부파일
	private int mno;			// 작성자
     
	private boolean ishost;		// 작성자 확인변수

    
    // 생성자
    public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(int cno, String cname, int bno, String btitle, String bcontent, String bdate, String bfile, int mno,
			boolean ishost) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bfile = bfile;
		this.mno = mno;
		this.ishost = ishost;
	}


	public int getCno() {
		return cno;
	}


	public void setCno(int cno) {
		this.cno = cno;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public String getBfile() {
		return bfile;
	}


	public void setBfile(String bfile) {
		this.bfile = bfile;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public boolean isIshost() {
		return ishost;
	}


	public void setIshost(boolean ishost) {
		this.ishost = ishost;
	}


	@Override
	public String toString() {
		return "Board [cno=" + cno + ", cname=" + cname + ", bno=" + bno + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bdate=" + bdate + ", bfile=" + bfile + ", mno=" + mno + ", ishost=" + ishost + "]";
	}

	
}