package model.dao;

// 채팅기능 클래스
public class ChattingDao extends Dao{
	
	private static ChattingDao chattingDao = new ChattingDao();
	public static ChattingDao getInstance() {
		return chattingDao;
	}
	private ChattingDao() {}
	
	
	
	
	
}
