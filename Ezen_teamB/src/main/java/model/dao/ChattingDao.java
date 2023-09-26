package model.dao;

// 채팅기능 클래스
public class ChattingDao extends Dao{
	
	private static ChattingDao chattingDao = new ChattingDao();
	public static ChattingDao getInstance() {
		return chattingDao;
	}
	private ChattingDao() {}
	
	// 메시지 받는 사람의 mid를 구하는 메소드(첫 메시지 수신자 mid)
	public String findRMid(String type, int ino) {
		String sql = "";
		
		try {
			if(type.equals("1")) {
				sql = "select m.mid from itemsinfo i, memberlist m where i.mno = m.mno and i.ino = " + ino;	
			}
			else if(type.equals("2")){
				sql = "select m.mid from jchatting j, memberlist m where j.caller = m.mno and ino = " + ino;
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch (Exception e) {System.out.println("findRMid 오류 : " + e);}
		
		return null;
	}
	
	// 아이디로 회원넘버를 구하는 메소드
	public int findMno(String mid) {
		
		try {
			String sql = "select mno from memberlist where mid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {System.out.println("findMno 오류 : " + e);}
		
		return 0;
	}
	
	// 메시지를 보낼때마다 DB에 저장
	public boolean recordMsg(int cmno, int rmno, String msg, int ino) {
		
		try {
			String sql = "insert into jchatting(caller, receiver,jcontent,ino) values(?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cmno);	ps.setInt(2, rmno);
			ps.setString(3, msg);	ps.setInt(4, ino);
			int count = ps.executeUpdate();
			if(count == 1) {return true;}
		
		} catch (Exception e) {System.out.println("recordMsg 오류" + e);}

		return false;
	}
	
	
	
}
