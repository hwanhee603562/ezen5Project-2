package model.dao;

import java.util.ArrayList;

import model.dto.ReplyDto;

public class ReplyDao extends Dao{
	
	private static ReplyDao replyDao = new ReplyDao();
	private ReplyDao() {}
	public static ReplyDao getInstance() {
		return replyDao;
	}
	
	public ArrayList<ReplyDto> printReply(){
		ArrayList<ReplyDto> list = new ArrayList<>();
		
		try {
			String sql = "select*from reply";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReplyDto rDto = new ReplyDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(rDto);
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}

}
