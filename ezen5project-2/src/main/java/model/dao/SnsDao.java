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
	public boolean writeContent( String sid, String spw, String simg, String scontent ) {
		
		try {
			
			String sql = "insert into sns(sid, spwd, simg, scontent) values(?, ?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, sid);
			ps.setString(2, spw);
			ps.setString(3, simg);
			ps.setString(4, scontent);
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	// 글 수정 - 병철
	/*---------------------------------*/
	
	
	
	
	// 글 삭제 - 승우
	/*---------------------------------*/
	
}
