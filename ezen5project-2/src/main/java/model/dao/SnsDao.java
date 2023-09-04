package model.dao;

import java.util.ArrayList;

import model.dto.SnsDto;

public class SnsDao extends Dao{
	
	// 싱글톤
	private static SnsDao snsDao = new SnsDao();
	public static SnsDao getInstance() {
		return snsDao;
	}
	private SnsDao() {};
	
	
	public ArrayList<SnsDto> printContent() {
		ArrayList<SnsDto> sDto = new ArrayList<>();
		
		try {
			String sql="select*from sns";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
			}
			
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
}
