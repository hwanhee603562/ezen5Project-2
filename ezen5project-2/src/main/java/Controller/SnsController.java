package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.SnsDao;
import model.dto.SnsDto;


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

	}

}
