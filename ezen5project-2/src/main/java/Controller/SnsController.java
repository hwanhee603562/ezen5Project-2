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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import model.dao.SnsDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.dto.SnsDto;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.SnsDao;
import model.dto.SnsDto;

import model.dao.SnsDao;


@WebServlet("/SnsController")
public class SnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SnsController() {
        
    }

    
    // 글 출력 - 의선
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<SnsDto> result = SnsDao.getInstance().printContent();
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getSdate());
			try {
				Date format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(result.get(i).getSdate());
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM--dd HH:mm");
				String format = formatter.format(date);
				Date format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(format);
				System.out.println(format1);
				System.out.println(format2);
			} catch (Exception e) {System.out.println(e);}
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
	}

	// 글 등록 - 환희
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/sns/img"),
				1024*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
			);
		
		String sid = multi.getParameter("sid");
		String spw = multi.getParameter("spw");
		String simg = multi.getFilesystemName("simg");
		String scontent = multi.getParameter("scontent");
		
		boolean result = SnsDao.getInstance().writeContent( sid, spw, simg, scontent );
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		
	}

	// 글 수정 - 병철
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getServletContext().getRealPath("/sns/img"),
				1024*1024*1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		// 수정할 게시물 번호
		int sno = Integer.parseInt(multi.getParameter("sno"));
		
		// 수정사항 객체화
		String simg = multi.getFilesystemName("simg");
		String scontent = multi.getParameter("scontent");
		// 본인확인 비밀번호 객체화
		String spwd = multi.getParameter("spwd");
		// 수정할 게시물 번호와 비밀번호가 db 필드값과 같을경우 수정 진행
		
		SnsDto dto = new SnsDto(sno, simg , scontent);
		if (dto.getSimg() == null) {
	//		dto.setSimg(SnsDao.getInstance().getPrintContent(sno).getSimg;
		}
		
		boolean result = SnsDao.getInstance().onupdate(dto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);		
		
		
		
	}// doPut end

	// 글 삭제 - 승우
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		String spwd = request.getParameter("spwd"); 
		boolean result = SnsDao.getInstance().snsDelete(sno, spwd);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
				
	
	}

}
