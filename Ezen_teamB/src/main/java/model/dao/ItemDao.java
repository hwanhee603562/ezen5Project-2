package model.dao;

import java.util.ArrayList;
import java.util.HashMap;

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
			
			ps = conn.prepareStatement(sql);
			
			// 1 대면거래 위치정보 저장
			ps.setInt( 1, itemsInfo.getIprice() );
			ps.setInt( 2, itemsInfo.getMno() );
			ps.setString( 3, itemsInfo.getItitle() );
			ps.setString( 4, itemsInfo.getIcontent() );
			ps.setInt( 5, itemsInfo.getItrade() );
			ps.setString( 6, itemsInfo.getItradeplace() );
			ps.setInt( 7, itemsInfo.getDno() );
			ps.setInt( 8, itemsInfo.getIsafepayment() );
			
			ps.executeUpdate();
			
			// insert되어진 필드에 대한 autoIncreament 값 대입
			rs = ps.getGeneratedKeys();	
			
			if( rs.next() )	itemsInfo.setIno( rs.getInt(1) );	// autoIncreament 값 반환
			else return false;
			
			// 2 대면거래 이미지 저장
				// 이미지를 등록할 경우에만 DB저장
			if( itemsInfo.getImgList().size() != 0 ) {
				sql = "insert into pimg(pimg,ino) values(?, ?)";
				ps = conn.prepareStatement(sql);
				
				for( int i=0; i<itemsInfo.getImgList().size(); i++ ) {
					 ps.setString( 1, itemsInfo.getImgList().get(i) );
					 ps.setInt( 2, itemsInfo.getIno() );
					 
					 ps.executeUpdate();
				}
			}
			
			// 3 대면거래 위경도 저장
			sql = "insert into dpoint(dlat, dlng, ino) values(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString( 1, dpointDto.getDlat() );
			ps.setString( 2, dpointDto.getDlng() );
			ps.setInt( 3, itemsInfo.getIno() );
			
			return true;
			
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
