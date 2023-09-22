package model.dao;

import java.time.LocalDateTime;

import model.dto.MemberList;

// 회원기능 클래스
public class MemberDao extends Dao{

	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	private MemberDao() {}
	
	
	// 회원가입 함수
	public boolean signup(MemberList dto) {
		
		try {
			
			String sql = "insert into memberlist(mname, msno1, msno2, mphone, memail, madress, mid, mpwd, mlevel, mpoint) \r\n"
					+ "values( ? , ? , ? , ? , ? , ? , ? , ? , 1 , 0 );";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getMname());
			ps.setString(2, dto.getMsno1());
			ps.setString(3, dto.getMsno2());
			ps.setString(4, dto.getMphone());
			ps.setString(5, dto.getMemail());
			ps.setString(6, dto.getMadress());
			ps.setString(7, dto.getMid());
			ps.setString(8, dto.getMpwd());
			
			int row = ps.executeUpdate();
			
			if (row == 1 ) {
				return true;
			}return false;
			
		} catch (Exception e) {System.out.println("signup Dao 오류 : " + e);}
		return false;
	}
	
	
	
	// 아이디 중복검사 함수
	public boolean findId(String type , String signId) {	

		try {
			
			String sql="select * from memberlist where "+type+" = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, signId);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {return true;}
			
		} catch (Exception e) {System.out.println("findId Dao 오류 : " + e);}
		return false;
	}//findId
	
	
	// 로그인 함수
	
	public boolean login(String mid , String mpwd) {
		
		try {
			
			String sql = "";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, sql);
			ps.setString(2, sql);
			rs=ps.executeQuery();
			
			if(rs.next()) {return true;}
			
			
		} catch (Exception e) {System.out.println("findId Dao 오류 : " + e);}
		
		return false;
		
	}//login
	
	
	// 로그인 정보 호출
	
	public  MemberList info(String mid) {
		
		try {
			
			String sql = "select mno from memberlist where mid = ?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, mid);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				MemberList memberList = new MemberList(rs.getInt(1));
				return memberList;
			}			
		} catch (Exception e) {System.out.println("findId Dao 오류 : " + e);}
			return null;
	}
	
	
	
	
	
}//class
