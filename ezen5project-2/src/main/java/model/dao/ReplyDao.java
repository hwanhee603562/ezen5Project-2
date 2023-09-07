package model.dao;

import java.util.ArrayList;
import model.dto.ReplyDto;



public class ReplyDao extends Dao{
	
	private static ReplyDao replyDao = new ReplyDao();
	private ReplyDao() {};
	public static ReplyDao getInstance() {
		return replyDao;
	}
	
	// 답글 출력
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


















