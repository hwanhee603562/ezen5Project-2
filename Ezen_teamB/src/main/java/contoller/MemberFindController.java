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
 * Servlet implementation class MemberFindController
 */
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberFindController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");

		String signId = request.getParameter("data");

		
		boolean result = MemberDao.getInstance().findId(type, signId);

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
				
	}

	// 로그인 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 매개변수 호출
		String mid = request.getParameter("signId");
		System.out.println("dopost mid :" + mid);
		String mpwd = request.getParameter("signPwd");
		System.out.println("dopost mpwd :" + mpwd);
		
		
			// 다오 
		boolean result = MemberDao.getInstance().login(mid , mpwd);
		System.out.println("로그인 컨트롤러 result 확인 : " + result);
		// 결과가 true 라면
		if (result == true) {
			MemberList loginDto = MemberDao.getInstance().info(mid);
			//세션 저장
			request.getSession().setAttribute("loginSession" ,loginDto );
			MemberList sessin = (MemberList) request.getSession().getAttribute("loginSession");
			System.out.println("로그인 세션 상태 : " + sessin);
		}
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
		
	}

}
