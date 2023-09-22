package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberList;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }


    // 회원 가입
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uploadpath = request.getServletContext().getRealPath("/jsp/img");
    	
    	MultipartRequest multi = new MultipartRequest(request, 
    			uploadpath,
    			1024*1024,
    			"UTF-8",
    			new DefaultFileRenamePolicy());
    	
    	
    	
    	String signName = multi.getParameter("signName");
    	System.out.println("이름" +signName);
    	String signResidentNumF = multi.getParameter("signResidentNumF");
    	System.out.println("앞자리" +signResidentNumF);  	
    	String signResidentNumS = multi.getParameter("signResidentNumS");
    	System.out.println("뒷자리" +signResidentNumS);
    	String signPhone = multi.getParameter("signPhone");
    	System.out.println("폰번호" +signPhone);
    	String signEamil = multi.getParameter("signEmail");
    	System.out.println("이메일" +signEamil);
    	String signAddress = multi.getParameter("addr2");
    	String signAddress2 = multi.getParameter("addr3");
    	signAddress= signAddress+" "+signAddress2;
    	System.out.println("주소" +signAddress);
    	String signId = multi.getParameter("signId");
    	System.out.println("아이디" +signId);
    	String signPwd1 = multi.getParameter("signPwd");
    	System.out.println("비밀번호" +signPwd1);  	
    	
    	MemberList memberList = new MemberList(
    			signName , signResidentNumF , signResidentNumS , signPhone ,
    			signEamil , signAddress , signId , signPwd1
    			);
    	boolean result = MemberDao.getInstance().signup(memberList);
    	System.out.println("컨트롤러 result1 : " + result);
    	response.setContentType("application/json; charset=UTF-8");
    	response.getWriter().print(result);
    	System.out.println("컨트롤러 result2 : " + result);  	
    }
    
    
    // 회원정보를 불러오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type.equals("1")) {
			
			int mno = Integer.parseInt(request.getParameter("mno"));
			
			MemberList result = MemberDao.getInstance().memberInfo(mno);
			
			System.out.println(result);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(json);
		}
		
	}

	// 회원정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int mno = Integer.parseInt(request.getParameter("mno"));
		String meamil = request.getParameter("memail");
		String madress = request.getParameter("adress1") + " "
				+ request.getParameter("adress2");
		String mpwd = request.getParameter("mpwd");
		
		boolean result = MemberDao.getInstance().updateInfo(mno, meamil, madress, mpwd);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
