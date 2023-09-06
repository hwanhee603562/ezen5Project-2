package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReplyDao;
import model.dto.ReplyDto;

@WebServlet("/ReplyController")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReplyController() {
        super();
    }


    // 병철	- 답글 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 승우	- 답글 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rcontent = request.getParameter("rcontent");
		String rpwd = request.getParameter("rpwd");
		int sno = Integer.parseInt(request.getParameter("sno"));
		ReplyDto replyDto = new ReplyDto(rpwd, rcontent);
		
		boolean result = ReplyDao.getInstance().Replyword(rcontent, rpwd,sno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 병철	- 답글 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
