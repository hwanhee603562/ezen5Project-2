package contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.SafePaymentDao;
import model.dto.MemberList;

// 안전결제 Controller
@WebServlet("/SafePaymentController")
public class SafePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SafePaymentController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		
		String type = request.getParameter("type");
		
		// 구매자 pk mno
		int vrequester = ((MemberList)request.getSession().getAttribute("loginSession")).getMno();
		
		// 1 안전결제 요청 단계
		if( type.equals("responseSafepay") ) {
			
			int ino = Integer.parseInt( request.getParameter("ino") );
			int result = SafePaymentDao.getInstance().responseSafepay( vrequester, ino );
			
			json = mapper.writeValueAsString(result);
			
		}

		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( json );
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
