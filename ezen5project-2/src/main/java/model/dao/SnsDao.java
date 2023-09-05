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
	
	


	
	// 글 출력 - 의선
	/*---------------------------------*/
	public ArrayList<SnsDto> printContent() {
		ArrayList<SnsDto> list = new ArrayList<>();
		 
		try {
			String sql="select*from sns order by sno desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SnsDto sDto = new SnsDto(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(sDto);
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	
	 
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
	
	// 검색기능
	public ArrayList<SnsDto> searchContent(String searchWord) {
		
		try {
			ArrayList<SnsDto> list = new ArrayList<>();
			
			String sql = "select * from sns where scontent like '%"+searchWord+"%';";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				SnsDto snsDto = new SnsDto(rs.getInt(1), rs.getString(2), 
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(snsDto);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	
	
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
	
	// 기존 게시물 img 호출 함수
	public SnsDto oldimg(int sno) {
		
		try {
			String sql = "select simg from sns where sno = ?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, sno);
			rs=ps.executeQuery();
			if (rs.next()) {
				SnsDto dto = new SnsDto(rs.getString("simg"));
				return dto;
			}
		} catch (Exception e) {System.out.println("기존이미지 가져오기 sql 오류 : " + e);}
		return null;
	}
	
	
	
	// 글 삭제 - 승우
	/*---------------------------------*/

	public boolean snsDelete( int sno) {
		try {
			String sql="delete from sns where sno = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sno);
			int row = ps.executeUpdate();
			if( row == 1) return true;
		
		} catch (Exception e) {System.out.println(e);}	
		return false;
	}

}
