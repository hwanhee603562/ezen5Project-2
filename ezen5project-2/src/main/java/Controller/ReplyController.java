package Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		String rcontent = request.getParameter("rcontent");
		String rpwd = request.getParameter("rpwd");
		int sno = Integer.parseInt(request.getParameter("sno"));
		ReplyDto replyDto = new ReplyDto(rpwd, rcontent);
		
		boolean result = ReplyDao.getInstance().replyWord(rcontent, rpwd,sno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 병철	- 답글 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		String rpwd = request.getParameter("rpwd");
		
		// 답글 비밀번호 일치여부 확인
		boolean checkPw = ReplyDao.getInstance().checkReplyPw( rno, rpwd );
		if( !checkPw ) {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(checkPw);
			return;
		}
		boolean result = ReplyDao.getInstance().deletReply( rno );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}


















