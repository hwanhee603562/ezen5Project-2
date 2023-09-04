package model.dao;

public class SnsDao extends Dao{
	
	// 싱글톤
	private static SnsDao snsDao = new SnsDao();
	public static SnsDao getInstance() {
		return snsDao; 
	}
	private SnsDao() {};
	
	
	
	// 글 출력 - 의선
	/*---------------------------------*/
	
	
	 
	// 글 등록 - 환희
	/*---------------------------------*/
	
	
	
	
	// 글 수정 - 병철
	/*---------------------------------*/
	
	
	
	
	// 글 삭제 - 승우
	/*---------------------------------*/
	public boolean snsDelete( int sno , String spwd) {
		try {
			String sql="delete from sns where sno = ? and spwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sno); ps.setString(2, spwd);
			int row = ps.executeUpdate();
			if( row == 1) return true;
		
		} catch (Exception e) {System.out.println(e);}	
		return false;
	}
}
