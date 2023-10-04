package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		
		String json="";
		ObjectMapper mapper = new ObjectMapper();
		
		if(type.equals("id")) {
			
			MemberList dto = new MemberList(mname, mphone);
			MemberList result = MemberDao.getInstance().idSearch(dto);
			
			if (result == null) {
				String mid2 = "null";
				json = mapper.writeValueAsString(mid2);
			}else if(result != null) {
				String mid2 = String.valueOf(result.getMid());
				json = mapper.writeValueAsString(mid2);
		
			}
			
		}else if(type.equals("pwd")) {
			
			MemberList dto = new MemberList(mid, memail);
			MemberList result = MemberDao.getInstance().pwdSearch(dto);

			if (result == null) {
				String mpwd = "null";
				json = mapper.writeValueAsString(mpwd);
			}else if(result != null) {
				String mpwd = String.valueOf(result.getMid());
				json = mapper.writeValueAsString(mpwd);
		
			}
		
		}
		System.out.println("반환할때 json " +json);		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(json);
	
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
