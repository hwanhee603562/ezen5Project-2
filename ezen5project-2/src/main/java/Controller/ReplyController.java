package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		
		ArrayList<ReplyDto> result = ReplyDao.getInstance().printReply();
		
		// 리턴값을 JSON 형식으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}

	// 승우	- 답글 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 병철	- 답글 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
