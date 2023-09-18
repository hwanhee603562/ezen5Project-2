package model.dao;

import model.dto.Board;

// 게시판 클래스
public class BoardDao extends Dao{
	
	private static BoardDao boardDao = new BoardDao();
	public static BoardDao getInstance() {
		return boardDao;
	}
	private BoardDao() {}
	
	
	// 전체 게시물 출력
	
	
	// 개별 게시물 출력
	
	
	// 개별 게시물 등록
	public boolean bwrite( Board boardDto ) {
		try {
			String sql ="insert into board( btitle , bcontent , bfile , mno , cno ) "+" values( ? , ? , ? , ? , ? )";
			ps=conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setString(3, boardDto.getBfile());
			ps.setInt(4, boardDto.getMno());
			ps.setInt(5, boardDto.getCno());
			int count = ps.executeUpdate(); if( count == 1 ) return true;
		} catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 개별 게시물 수정
	
	
	// 개별 게시물 삭제
	
	
	
	
}
