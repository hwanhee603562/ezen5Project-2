package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.dto.ItemsInfo;
import model.dto.Mymenu;

public class MyMenuDao extends Dao{
	
	private static MyMenuDao myMenuDao = new MyMenuDao();
	public static MyMenuDao getInstance() {
		return myMenuDao;
	}
	private MyMenuDao() {}
	
	
	// 내 정보 출력
	public Mymenu printMemberInfo(int mno){
		
		Mymenu mDto = new Mymenu();
		
		try {
			String sql = "select m.mid, m.mlevel, count(i.ino) as 판매물품, m.mpoint, m.mname, m.madress, m.memail "
					+ "from memberlist m, itemsinfo i "
					+ "where m.mno = i.mno and i.iestate = 0 "
					+ "group by m.mno "
					+ "having m.mno = " + mno;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				mDto = new Mymenu(
						rs.getString(1), rs.getInt(2), 0,
						rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}
			return mDto;
			
		} catch (Exception e) {System.out.println("내 정보 출력함수 오류 " + e);}
		
		
		return null;
	}
	
	// 거래활동수 구하는 함수
	public int tradeCount(int mno) {
		
		try {
			String sql = "select count(t.tno) as 거래내역, i.mno "
					+ "from itemsinfo i, tradelog t "
					+ "where i.ino = t.ino "
					+ "group by i.ino "
					+ "having i.mno = " + mno;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {System.out.println("거래활동함수 오류" + e);}
		
		return 0;
		
	}
	
	
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
			
		} catch (Exception e) {System.out.println("판매중인 물품 오류 : " + e);}
		
		return null;
	}
	
	
	// 나의 거래내역
	
	
	// 개인정보변경
	
	
	// 회원탈퇴
	
	
	// 찜 기능
	
	
	

}
