package model.dto;

import javax.websocket.Session;

public class ClientDto {
	
	private Session session;
	private String cmid;
	private String rmid;
	private int ino;
	
	public ClientDto() {}

	public ClientDto(Session session, String cmid, String rmid, int ino) {
		super();
		this.session = session;
		this.cmid = cmid;
		this.rmid = rmid;
		this.ino = ino;
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

	@Override
	public String toString() {
		return "ClientDto [session=" + session + ", cmid=" + cmid + ", rmid=" + rmid +  ", ino="+ ino + "]";
	}


}
