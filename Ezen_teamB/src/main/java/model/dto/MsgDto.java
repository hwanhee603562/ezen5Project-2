package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MsgDto {
	
	private String frommid;	// 보낸 사람
	private String msg;	// 보낸 내용
	private String date;		// 보낸시간
	
	public MsgDto() {}

	public MsgDto(String frommid, String msg) {
		super();
		this.frommid = frommid;
		this.msg = msg;
		Date date = new Date();
		// 2-2 날짜 포멧(형식) : SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("aa hh:mm");
			// y연도 M월 d일 h시m분s초 aa오전오후
		this.date = sdf.format(date);	// 현재시간을 정의한형식으로 변환시킴		
	}

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MsgDto [frommid=" + frommid + ", msg=" + msg + ", date=" + date + "]";
	}
	
	

}
