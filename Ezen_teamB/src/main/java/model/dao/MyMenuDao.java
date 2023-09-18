package model.dao;

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
		
		try {
			
			
		} catch (Exception e) {System.out.println(e);}
		
		return null;
	}
	
	
	// 나의 거래내역
	
	
	// 개인정보변경
	
	
	// 회원탈퇴
	
	
	// 찜 기능
	
	
	

}
