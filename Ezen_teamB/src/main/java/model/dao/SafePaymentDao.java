package model.dao;

import java.awt.List;
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
			
			String sql = "select a.*, b.mno, b.ititle from vsafepayment a join itemsinfo b "
					   + "on a.ino = b.ino where a.vrequester = ? and a.ino = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, vrequester);
			ps.setInt(2, ino);
			rs = ps.executeQuery();
			
			if( rs.next() ) {
				return new SafePaymentDto(
					rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(9)
				);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null; 
	}
	
	
	// 전체 결제내역 출력
	public ArrayList<SafePaymentDto> getPaymentList( int maxSize, int startRow, int vstateFilter ){
		
		ArrayList<SafePaymentDto> list = new ArrayList<>();
		
		System.out.println(maxSize);
		System.out.println(startRow);
		
		try {
			
			String sql = "select a.*, b.mno, b.ititle "
					+ "from vsafepayment a join itemsinfo b on a.ino = b.ino ";
			
			// 필터가 존재하지 않으면 모두 출력
			if( vstateFilter != 0 ) {
				sql += "where vstate = "+vstateFilter;
			}
			sql += " ORDER BY a.vno DESC limit ?, ?";
			
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, maxSize);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				SafePaymentDto dto = new SafePaymentDto(
						rs.getInt("vno"),
						rs.getInt("vrequester"),
						rs.getString("vrespdate"),
						rs.getString("vreqsdate"),
						rs.getString("vgivedate"),
						rs.getInt("vstate"),
						rs.getInt("ino"),
						rs.getInt("mno"),
						rs.getString("ititle")
				);
				list.add( dto );
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
	// 집계 함수
	public int getTotalPaymentCount( int vstateFilter ) {
			
		try {
			
			String sql = "select count(*) from vsafepayment v where vstate = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, vstateFilter );
			
			rs = ps.executeQuery();
			if( rs.next() ) return rs.getInt(1);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
