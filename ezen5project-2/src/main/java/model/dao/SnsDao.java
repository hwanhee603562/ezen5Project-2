package model.dao;

public class SnsDao {
	
	// 싱글톤
	private static SnsDao snsDao = new SnsDao();
	public static SnsDao getInstance() {
		return snsDao;
	}
	private SnsDao() {};
	
	
}
