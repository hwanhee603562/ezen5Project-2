package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.ItemsInfo;

public class MyMenuDao extends Dao{
	
	private static MyMenuDao myMenuDao = new MyMenuDao();
	public static MyMenuDao getInstance() {
		return myMenuDao;
	}
	private MyMenuDao() {}
	
	
	// 내 정보 출력
	
	// 판매물품에 해당하는 이미지 출력하는 함수
		public Map<Integer, String> getProductImg(int ino){
			try {
				Map<Integer, String> imglist = new HashMap<>();	// 제품별 여러개 이미지
				String sql = "select*from pimg where ino = " + ino;
				PreparedStatement ps = conn.prepareStatement(sql);	// 다른함수에서 rs를 사용하기 때문에 새로 만듬
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					imglist.put(rs.getInt("pno"),rs.getString("pimg"));
				}
				return imglist;
				
			} catch (Exception e) {System.out.println(e);}
			return null;
		}
	
	// 판매중인 물품 출력
	public List<ItemsInfo> saleList(int mno, int estate){
		
		List<ItemsInfo> list = new ArrayList<>();
		
		try {
			String sql = "select i.*, uc.uno, uc.uname, dc.dname from itemsinfo i natural join umaincategory uc natural join dsubcategory dc where i.mno = ? and ";
			if(estate == 1) {
				sql += "i.iestate = 0";
			}else if(estate == 2) {
				sql += "i.iestate = 1";
			}
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
						rs.getString(16), getProductImg(rs.getInt("ino")));
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
