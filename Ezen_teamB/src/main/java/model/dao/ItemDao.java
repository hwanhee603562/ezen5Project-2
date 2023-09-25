package model.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.dto.CategoryDto;
import model.dto.DetailedItems;
import model.dto.DpointDto;
import model.dto.Emediation;
import model.dto.ItemsInfo;

// 판매물품 클래스
public class ItemDao extends Dao {

	private static ItemDao itemDao = new ItemDao();
	public static ItemDao getInstance() {
		return itemDao;
	}
	private ItemDao() {}
	
	
	// 1 판매물품등록
	public boolean uploadItem( ItemsInfo itemsInfo, DpointDto dpointDto ) {
		
		try {
			
			String sql = "";
			
			// 거래방식이 중개거래소일 경우에만 중개거래소 필드를 추가하여 삽입
			if( itemsInfo.getItrade() == 3 ) {
				
				Emediation emediation = ( getEmediationInfo( itemsInfo.getEno() ) );
				
				// 물품저장
				sql = "insert into itemsinfo"
						+ "(iprice, mno, ititle, icontent, itrade, itradeplace, eno, dno, isafepayment) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
				
				// DB에 저장된 autoIncreament 값을 찾기 위해 ps에 'Statement.RETURN_GENERATED_KEYS' 추가
				ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				// 1 대면거래 위치정보 저장
				ps.setInt( 1, itemsInfo.getIprice() );
				ps.setInt( 2, itemsInfo.getMno() );
				ps.setString( 3, itemsInfo.getItitle() );
				ps.setString( 4, itemsInfo.getIcontent() );
				ps.setInt( 5, itemsInfo.getItrade() );
				ps.setString( 6, emediation.getEadress() );
				ps.setInt( 7, itemsInfo.getEno() );
				ps.setInt( 8, itemsInfo.getDno() );
				ps.setInt( 9, itemsInfo.getIsafepayment() );
				
			} else {
				
				// 물품저장
				sql = "insert into itemsinfo"
						+ "(iprice, mno, ititle, icontent, itrade, itradeplace, dno, isafepayment) "
						+ "values(?, ?, ?, ?, ?, ?, ?, ?);";
				
				// DB에 저장된 autoIncreament 값을 찾기 위해 ps에 'Statement.RETURN_GENERATED_KEYS' 추가
				ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				// 1 대면거래 위치정보 저장
				ps.setInt( 1, itemsInfo.getIprice() );
				ps.setInt( 2, itemsInfo.getMno() );
				ps.setString( 3, itemsInfo.getItitle() );
				ps.setString( 4, itemsInfo.getIcontent() );
				ps.setInt( 5, itemsInfo.getItrade() );
				ps.setString( 6, itemsInfo.getItradeplace() );
				ps.setInt( 7, itemsInfo.getDno() );
				ps.setInt( 8, itemsInfo.getIsafepayment() );
				
			}
			
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
			
			if( itemsInfo.getItrade() == 2 ) {
				
				// 3 대면거래 시 위경도 저장
				sql = "insert into dpoint(dlat, dlng, ino) values(?, ?, ?)";
				ps = conn.prepareStatement(sql);
				
				ps.setString( 1, dpointDto.getDlat() );
				ps.setString( 2, dpointDto.getDlng() );
				ps.setInt( 3, itemsInfo.getIno() );
				
				ps.executeUpdate();
				
			}

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
	
		// 2-2 카테고리 조회 ( 소분류 )
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
	
		// 2-3 전체 중개거래소 조회
	public ArrayList<Emediation> getEmediation(){
		
		try {
			
			ArrayList<Emediation> list = new ArrayList<>();
			
			String sql = "select * from emediation";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Emediation emediation = new Emediation( 
					rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) 
				);
				
				list.add(emediation);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
		// 2-4 개별 중개거래소 조회
	public Emediation getEmediationInfo( int eno ) {
		
		try {
			
			String sql = "select * from emediation where eno = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eno);
			rs = ps.executeQuery();			
			
			if( rs.next() ) {
				return new Emediation( 
					rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) 
				);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
		// 2-5 개별 대면거래 위치 조회
	public DpointDto getDpointInfo( int ino ) {
		
		
		return null;
	}
	
		// 2-6 전체 물품 조회
	public ArrayList<ItemsInfo> getItemList( String filterCategory, int filterNum, String searchWord ){
		
		try {
			ArrayList<ItemsInfo> list = new ArrayList<>();
			
			String sql = "select distinct a.ino, a.iprice, a.mno, a.ititle, a.icontent, "
						+ "a.itrade, a.itradeplace, a.idate, a.eno, a.iestate, a.dno, a.isafepayment, a.keepstate, b.pimg " 
						+ "from itemsinfo a left outer join pimg b on a.ino = b.ino ";
			
			
			// 기본 물품 정보에 대표 이미지 1개만 조회
			if( filterCategory.equals("dno") ) {

				 sql += "where (ititle like '%"+searchWord+"%' or itradeplace like '%"+searchWord+"%')"
					  + " and dno = "+filterNum+" order by idate desc";
			
			} 
			
			else if( filterCategory.equals("uno") ) {
				
				// 대분류 pk를 통해 소분류 정보 반환
				ArrayList<CategoryDto> dsubCategory = getSubCategory(filterNum);
				
				sql += "where (ititle like '%"+searchWord+"%' or itradeplace like '%"+searchWord+"%') and (";
				
				for( int i=0; i<dsubCategory.size(); i++ ) {
					
					sql += " dno = "+dsubCategory.get(i).getDno();
					if( i == dsubCategory.size()-1) break;
					sql += " or ";
						
				}
				sql += " ) order by idate desc";
				
			}
				
			else {
				sql += "where ititle like '%"+searchWord+"%' or itradeplace like '%"+searchWord+"%' order by idate desc";
			}
			
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Map<Integer, String> map = new HashMap<>();
				map.put(1, rs.getString(14));
				
				ItemsInfo itemsInfo = new ItemsInfo(
					rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10),
					rs.getInt(11), rs.getInt(12), rs.getInt(13), map
				);
				
				list.add(itemsInfo);
				
			}
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
		// 2-7 개별 물품 조회
	public DetailedItems getDetailedItems( int ino, int itrade ) {
		
		try {
			
			String sql = "";
			
			// 거래방식에 따른 조회방법
				// 1. 거래방식 : 배송 - 단순 물품정보 조회
			if( ino == 1 ) {
				sql = "select * from itemsinfo where ino = "+ino;
			}
				// 2. 거래방식 : 대면거래 - 물품정보와 대면거래 위치 테이블 조인하여 조회
			else if( ino == 2 ) {
				sql = "select a.*, b.dlat, b.dlng, c.mid "
						+ "from itemsinfo a join dpoint b join memberlist c"
						+ " on a.ino = b.ino where a.ino = "+ino+" and a.mno = c.mno";
			}
				// 3. 거래방식 : 중개거래 - 물품정보와 중개거래소 위치 테이블 조인하여 조회
			else if( ino == 3 ) {
				sql = "select a.*, b.elat, b.elng, c.mid "
						+ "from itemsinfo a join emediation b join memberlist c"
						+ " on a.eno = b.eno where a.ino = "+ino+" and a.mno = c.mno";
			}
			
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				ItemsInfo itemsInfo = new ItemsInfo();
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	

	
	
	
	// 판매물품수정
	
	
	
	//판매물품삭제
	
	
	
	// 물품거래내역조회
	
	
	


	
	
	
	
}















