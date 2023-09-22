package model.dao;

import java.util.ArrayList;

import model.dto.CategoryDto;
import model.dto.DpointDto;
import model.dto.ItemsInfo;

// 판매물품 클래스
public class ItemDao extends Dao {

	private static ItemDao itemDao = new ItemDao();
	public static ItemDao getInstance() {
		return itemDao;
	}
	private ItemDao() {}
	
	
	// 1 판매물품등록
		// 1-1 대면거래 물품 저장
	public boolean uploadItem( ItemsInfo itemsInfo, DpointDto dpointDto ) {
		
		try {
			// 물품저장
			String sql = "insert into itemsinfo"
					+ "(iprice, mno, ititle, icontent, itrade, itradeplace, dno, isafepayment) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			// 대면거래 위치정보 저장
			
			// 대면거래 이미지 저장 
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	// 2 판매물품조회
		// 2-1 카테고리 조회 ( 대분류 )
	public ArrayList<CategoryDto> getMainCategory(){
		
		try {
			ArrayList<CategoryDto> categoryList = new ArrayList<>();
			String sql = "select * from umaincategory";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				CategoryDto categoryDto = new CategoryDto( 
					rs.getInt(1), rs.getString(2), 0, null 
				);
				categoryList.add(categoryDto);
			}
			return categoryList;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
		// 2-1 카테고리 조회 ( 소분류 )
	public ArrayList<CategoryDto> getSubCategory( int uno ){
		
		try {
			ArrayList<CategoryDto> categoryList = new ArrayList<>();
			String sql = "select d.uno, u.uname, d.dno, d.dname "
						+ "from umaincategory u join dsubcategory d "
						+ "on d.uno = u.uno where u.uno = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uno);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				CategoryDto categoryDto = new CategoryDto( 
					rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)
				);
				categoryList.add(categoryDto);
			}
			return categoryList;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	
	// 판매물품수정
	
	
	
	//판매물품삭제
	
	
	
	// 물품거래내역조회
	
	
	
	// 중개거래소 선정
	
	
	
	
}
