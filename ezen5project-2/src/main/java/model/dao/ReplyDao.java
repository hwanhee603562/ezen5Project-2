package model.dao;


public class ReplyDao extends Dao {

	// 싱글톤
	private static ReplyDao replyDao = new ReplyDao();
	public static ReplyDao getInstance() {return replyDao;}
	private ReplyDao() {};
	
	
	// 답글등록
	public boolean Replyword( String rcontent , String rpwd) {
		try {
			String sql ="insert into reply( rcontent , rpwd ) values( ? , ?)";
			ps= conn.prepareStatement(sql);
			ps.setString(1, rcontent);
			ps.setString(2, rpwd);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
}
