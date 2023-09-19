package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	String signAddress = multi.getParameter("signAddress");
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
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
