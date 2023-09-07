package model.dto;

public class UserCheckDto {
	int uno;		// pk
	String uip;		// 유저 ip
	int ucheck;		// 유저 반응
	int sno;		// 게시물 번호
	
	
	// 생성자
	public UserCheckDto() {}
	
	public UserCheckDto(int uno, String uip, int ucheck, int sno) {
		super();
		this.uno = uno;
		this.uip = uip;
		this.ucheck = ucheck;
		this.sno = sno;
	}

	
	// getter setter
	public int getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getUip() {
		return uip;
	}

	public void setUip(String uip) {
		this.uip = uip;
	}

	public int getUcheck() {
		return ucheck;
	}

	public void setUcheck(int ucheck) {
		this.ucheck = ucheck;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "UuserCheck [uno=" + uno + ", uip=" + uip + ", ucheck=" + ucheck + ", sno=" + sno + "]";
	}
	
	
	
	
}
