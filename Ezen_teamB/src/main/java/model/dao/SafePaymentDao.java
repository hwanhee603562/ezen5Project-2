package model.dao;

import java.util.ArrayList;

import model.dto.SafePaymentDto;

// 안전결제 클래스
public class SafePaymentDao extends Dao{

	private static SafePaymentDao safePaymentDao = new SafePaymentDao();
	public static SafePaymentDao getInstance() {
		return safePaymentDao;
	}
	private SafePaymentDao() {}
	
	// 구매자가 안전결제 요청 [ 안전결제 필드 최초 생성 ]
	public int responseSafepay( int vrequester, int ino ) {
		
		try {
			
			SafePaymentDto dto = getSafepayLog( vrequester, ino );
			// 신규 필드, 즉 안전결제를 요청하는데 해당 물품과 구매자 간 동일한
			// 안전결제 진행 상태에 있다면( 이미 필드가 있다면 ) 
			// 현재 진행 중인 거래상태를 return
			if( dto != null ) return dto.getVstate();
			
			String sql = "insert into vsafepayment( vrequester, ino ) values ( ?, ? )";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vrequester);
			ps.setInt(2, ino);
			ps.executeUpdate();
			
			return 0;	// 정상
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return -1;
	}
	
	// 개별 결제내역 출력
	public SafePaymentDto getSafepayLog( int vrequester, int ino ) {
		
		try {
			
			String sql = "select a.*, b.mno from vsafepayment a join itemsinfo b "
					   + "on a.ino = b.ino where a.vrequester = ? and a.ino = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vrequester);
			ps.setInt(2, ino);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				return new SafePaymentDto(
					rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)
				);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null; 
	}
	
	// 전체 결제내역 출력
	public ArrayList<SafePaymentDto> getPaymentList( int maxSize, int startRow, String startDate, String endDate, int vstateFilter ){
		
		String dateFilter = "";
		switch (vstateFilter) {
		
			case 1 : dateFilter = "vrespdate";	 break;
			case 2 : dateFilter = "vreqsdate";	 break;
			case 3 : dateFilter = "vgivedate"; 	 break;
			
		}
		
		try {
			
			String sql = ""
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
	
	
	// 집계 함수
	public int getTotalPaymentCount( String startDate, String endDate, int vstateFilter ) {
		
		String dateFilter = "";
		switch (vstateFilter) {
		
			case 1 : dateFilter = "vrespdate";	 break;
			case 2 : dateFilter = "vreqsdate";	 break;
			case 3 : dateFilter = "vgivedate"; 	 break;
			
		}
			
		try {
			
			String sql = "select count(*) from vsafepayment v where date(v."+dateFilter+") between ? and ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString( 1, startDate );
			ps.setString( 2, endDate );
			
			rs = ps.executeQuery();
			if( rs.next() ) return rs.getInt(0);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
