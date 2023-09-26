package model.dto;

import javax.websocket.Session;

public class ClientDto {
	
	private Session session;		// 세션
	private String cmid;				// 발신자
	private String rmid;				// 수신자
	private int ino;					// 물품번호
	private int rno;					// 채팅방번호
	
	public ClientDto() {}

	public ClientDto(Session session, String cmid, String rmid, int ino, int rno) {
		super();
		this.session = session;
		this.cmid = cmid;
		this.rmid = rmid;
		this.ino = ino;
		this.rno = rno;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getCmid() {
		return cmid;
	}

	public void setCmid(String cmid) {
		this.cmid = cmid;
	}

	public String getRmid() {
		return rmid;
	}

	public void setRmid(String rmid) {
		this.rmid = rmid;
	}
	

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	@Override
	public String toString() {
		return "ClientDto [session=" + session + ", cmid=" + cmid + ", rmid=" + rmid + ", ino=" + ino + ", rno=" + rno
				+ "]";
	}


}
