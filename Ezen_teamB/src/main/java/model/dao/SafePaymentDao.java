package model.dao;

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
	
	// 안전결제 진행 현황 조회
	public SafePaymentDto getSafepayLog( int vrequester, int ino ) {
		
		try {
			
			String sql = "select * from vsafepayment where vrequester = ? and ino = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vrequester);
			ps.setInt(2, ino);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				return new SafePaymentDto(
					rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getInt(6), rs.getInt(7)
				);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null; 
	}
	
	
	
}
