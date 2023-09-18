package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.dto.ItemsInfo;

public class MyMenuDao extends Dao{
	
	private static MyMenuDao myMenuDao = new MyMenuDao();
	public static MyMenuDao getInstance() {
		return myMenuDao;
	}
	private MyMenuDao() {}
	
	
	// 내 정보 출력
	
	
	// 판매중인 물품 출력
	public List<ItemsInfo> saleList(int mno){
		
		List<ItemsInfo> list = new ArrayList<>();
		
		try {
			String sql = "select i.*, uc.uno, uc.uname, dc.dname from itemsinfo i natural join umaincategory uc natural join dsubcategory dc where i.mno = ? and i.iestate = 0";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mno);
			rs = ps.executeQuery();
			while(rs.next()) {
				ItemsInfo idto = new ItemsInfo(
						rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getString(4), rs.getString(5), rs.getInt(6),
						rs.getString(7), rs.getString(8), rs.getInt(9),
						rs.getInt(10), rs.getInt(11), rs.getInt(12),
						rs.getInt(13), rs.getInt(14), rs.getString(15),
						rs.getString(16), null);
				list.add(idto);
			}
			return list;
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	
	// 나의 거래내역
	
	
	// 개인정보변경
	
	
	// 회원탈퇴
	
	
	// 찜 기능
	
	
	

}
