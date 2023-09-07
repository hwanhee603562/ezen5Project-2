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

import model.dao.ReplyDao;
import model.dao.SnsDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ReplyDto;
import model.dto.SnsDto;
import model.dto.ReponseDto;


@WebServlet("/SnsController")
public class SnsController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SnsController() {
        
    } 

    
    // 글 출력 - 의선
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<SnsDto> result = SnsDao.getInstance().printContent();
		for(int i = 0; i < result.size(); i++) {
			try {
				Date format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(result.get(i).getSdate());
				Date format2 = new Date();
				
				long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		        long diffMin = (format2.getTime() - format1.getTime()) / 60000; //분 차이
		        long diffHor = (format2.getTime() - format1.getTime()) / 3600000; //시 차이
		        long diffDays = diffSec / (24*60*60); //일자수 차이
		        
		        String datecheck = "" + diffMin;
		        
				result.get(i).setSdate(datecheck);
				
			} catch (Exception e) {System.out.println(e);}
		}
		
		ArrayList<ReplyDto> result2 = ReplyDao.getInstance().printReply();
		for(int i = 0; i < result2.size(); i++) {
			try {
				Date format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(result2.get(i).getRdate());
				Date format2 = new Date();
				
				long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		        long diffMin = (format2.getTime() - format1.getTime()) / 60000; //분 차이
		        long diffHor = (format2.getTime() - format1.getTime()) / 3600000; //시 차이
		        long diffDays = diffSec / (24*60*60); //일자수 차이
		        
		        String datecheck = "" + diffMin;
		        
		        result2.get(i).setRdate(datecheck);
				
			} catch (Exception e) {System.out.println(e);}
		}
		
		ReponseDto rDto = new ReponseDto(result, result2);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(rDto);
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
		System.out.println(request.getServletContext().getRealPath("/sns/img"));
		String sid = multi.getParameter("sid");
		String spw = multi.getParameter("spw");
		String simg = multi.getFilesystemName("simg");
		String scontent = multi.getParameter("scontent");
		scontent=scontent.replace("\r\n","<br>");
		System.out.println(scontent);
		
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
		
		SnsDto dto = new SnsDto(sno, simg , scontent);
		if (dto.getSimg() == null) {
			//기존 게시물 정보 가져오기 ? 어떻게 ?
			dto.setSimg(SnsDao.getInstance().oldimg(sno).getSimg());
		}
		
		boolean result = SnsDao.getInstance().onupdate(dto);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);		
		
		
		
	}// doPut end

	// 글 삭제 - 승우
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		boolean result = SnsDao.getInstance().snsDelete(sno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
				
	
	}

}
