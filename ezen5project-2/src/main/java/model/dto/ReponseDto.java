package model.dto;

import java.util.ArrayList;

public class ReponseDto {
	
	ArrayList<SnsDto> snsList;
	ArrayList<ReplyDto> replyList;
	
	// 생성자
	public ReponseDto() {}
	
	public ReponseDto(ArrayList<SnsDto> snsList, ArrayList<ReplyDto> replyList) {
		this.snsList = snsList;
		this.replyList = replyList;
	}

	public ArrayList<SnsDto> getSnsList() {
		return snsList;
	}

	public void setSnsList(ArrayList<SnsDto> snsList) {
		this.snsList = snsList;
	}

	public ArrayList<ReplyDto> getReplyList() {
		return replyList;
	}

	public void setReplyList(ArrayList<ReplyDto> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "reponseDto [snsList=" + snsList + ", replyList=" + replyList + "]";
	}
	
	

}
