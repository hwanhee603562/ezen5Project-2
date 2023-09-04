package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SnsDao;


@WebServlet("/SnsController")
public class SnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SnsController() {
        
    }

    
    // 글 출력 - 의선
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	// 글 등록 - 환희
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 글 수정 - 병철
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 글 삭제 - 승우
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		String spwd = request.getParameter("spwd"); 
		boolean result = SnsDao.getInstance().snsDelete(sno, spwd);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
				
	
	}

}
