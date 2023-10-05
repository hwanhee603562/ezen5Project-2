package model.dao;

import java.util.ArrayList;

import model.dto.MemberList;
import model.dto.MemberManageDto;

// 관리자 클래스
public class ManagerDao extends Dao{

	private static ManagerDao manager = new ManagerDao();
	public static ManagerDao getInstance() {
		return manager;
	}
	private ManagerDao() {}
	
	
	// 1. 회원관리
		// 1-1 회원 수 출력 [ 검색기능 포함 ]
	public int getTotalPageCount( String key, String keyword ) {
		
		try {
			
			if( key.isEmpty() || keyword.isEmpty() ) return 0;
			
			String sql = "select count(*) from memberlist where "+key+" like ? '%"+keyword+"%'"; 
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if( rs.next() ) return rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
		// 1-2 페이지에 해당되는 멤버리스트 출력
	public ArrayList<MemberList> getList( int maxSize, int startRow, String key, String keyword ){
		
		try {
			
			ArrayList<MemberList> list = new ArrayList<>();
			
			String sql = "select mno, mname, msno1, mphone, memail, mid, mpoint from memberlist";
			
			if( !key.isEmpty() && !keyword.isEmpty() ) {
				sql = " order by mno desc where "+key+" like ? '%"+keyword+"%'";
			}
			
			sql += " limit ?, ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, maxSize);
			
			rs = ps.executeQuery();
			while( rs.next() ) {
				MemberList memberList = new MemberList(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7)
				);
				list.add(memberList);
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	
	
	
	// 거래내역
	
	
	// 통계
	
	
	// 전체 중개거래소 
	
	
	// 개별 중개거래소 등록
	
	
	// 개별 중개거래소 삭제
	
	
	
	
}
