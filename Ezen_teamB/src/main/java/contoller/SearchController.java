package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;
import model.dto.MemberList;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		
		String mid = request.getParameter("mid");
		String memail = request.getParameter("memail");
		
		
		if(type.equals("id")) {
			
			MemberList dto = new MemberList(mname, mphone);
			MemberList result = MemberDao.getInstance().idSearch(dto);
			System.out.println("아이디찾기 컨트롤러 리턴 아이디 : "+result);
			
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(result);
			
		}else if(type.equals("pwd")) {
			
			MemberList dto = new MemberList(mid, memail);
			MemberList result = MemberDao.getInstance().pwdSearch(dto);
			
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(result);
 		}
		
	
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
