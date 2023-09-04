package model.dao;

import model.dto.SnsDto;

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
	
	public boolean onupdate(SnsDto dto) {
		
		String sql = "update sns set simg = ? , scontent = ? where sno = ? ";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getSimg());
			ps.setString(2, dto.getScontent());
			ps.setInt(3, dto.getSno());

			
			int count = ps.executeUpdate();
			if (count == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("다오 업데이트 sql 오류 : " + e);
		}return false;
	}
	
	
	// 글 삭제 - 승우
	/*---------------------------------*/
	
}
