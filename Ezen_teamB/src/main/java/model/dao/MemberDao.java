package model.dao;

import model.dto.MemberList;

// 회원기능 클래스
public class MemberDao extends Dao{

	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	private MemberDao() {}
	
	
	// 회원가입
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
			
		} catch (Exception e) {System.out.println("회원가입 Dao 오류 : " + e);}
		
		return false;
	}
	
	
	
	// 로그인
	
	
	
	
	
}
