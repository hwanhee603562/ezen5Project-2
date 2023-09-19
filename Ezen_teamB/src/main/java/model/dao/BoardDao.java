package model.dao;

import java.util.ArrayList;

import model.dto.Board;

// 게시판 클래스
public class BoardDao extends Dao{
	
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {
		return boardDao;
	}
	private BoardDao() {}
	
	
	// 전체 게시물 출력
	public ArrayList<Board> getList( int cno , int listsize , int starrow , String key , String keyword){
		ArrayList<Board> list = new ArrayList<>();
		try {
			String sql = "";
			// 카테고리 선택
			if(cno != 0 ) {}
			// 검색
			if(!key.isEmpty() && !keyword.isEmpty() ) {
				// 카테고리내 검색이면
				if( cno != 0 ) sql+="";
				else sql += "";
			}
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, starrow);
			ps.setInt(2,listsize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board boardDto = new Board(rs.getInt("cno"), 
						rs.getString("cname"), rs.getInt("bno"), 
						rs.getString("btitle"), rs.getString("bcontent"), 
						rs.getString("bdate"), rs.getString("bfile"), 
						rs.getInt("mno"), rs.getString("mid"));
				list.add(boardDto);
			}
		} catch (Exception e) {System.out.println(e);}
		return list;
	}
	
	// 개별 게시물 출력
	
	
	// 개별 게시물 등록
	public boolean bwrite( Board boardDto ) {
		try {
			String sql ="insert into board( btitle , bcontent , bfile , cno )"+"values( ? , ? , ? , ? )";
			ps=conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setString(3, boardDto.getBfile());
			ps.setInt(4, boardDto.getCno());
			
			int count = ps.executeUpdate(); if( count == 1 ) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 개별 게시물 수정
	
	
	// 개별 게시물 삭제
	
	
	
	
}
