package model.dao;

public class ReplyDao extends Dao{

	// 싱글톤
	private static ReplyDao replyDao = new ReplyDao();
	public static ReplyDao getInstance() {return replyDao;}
	private ReplyDao() {};

	
	// 답글등록
	public boolean replyWord( String rcontent , String rpwd , int sno) {
		try {
			String sql ="insert into reply( rcontent , rpwd , sno) values( ? , ? , ?)";
			ps= conn.prepareStatement(sql);
			ps.setString(1, rcontent);
			ps.setString(2, rpwd);
			ps.setInt(3, sno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	
	// 답글삭제
	public boolean deletReply( int rno ) {
		
		try {
			
			String sql = "delete from reply where rno = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rno);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 답글 비밀번호 일치여부 확인
	public boolean checkReplyPw( int rno, String rpwd ) {
		
		try {
			String sql = "select * from reply where rno = ? and rpwd = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rno);
			ps.setString(2, rpwd);
			rs = ps.executeQuery();
			
			if( rs.next() ) return true;
			
			return false;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return false;
	}
	
	
	
	
	
}


















