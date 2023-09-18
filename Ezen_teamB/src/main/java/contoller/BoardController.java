package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.Board;
import model.dto.MemberList;


@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }
    
	// 1. 게시판 등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MultipartRequest multi = new MultipartRequest(
    			request, 
    			request.getServletContext().getRealPath("/jsp/board/upload"),
    			1024*1024*1024 ,
    			"UTF-8",
    			new DefaultFileRenamePolicy());
    	// 경로 확인
    	System.out.println(request.getServletContext().getRealPath("/jsp/board/upload"));
    	
    	String btitle = multi.getParameter("btitle");
    	String bcontent = multi.getParameter("bcontent");
    	String bfile = multi.getFilesystemName("bfile");
    	
    	int cno = Integer.parseInt(multi.getParameter("cno")); 
    	
    	Board boardDto = new Board(cno, btitle, bcontent, bfile);
    	
    	boolean result = BoardDao.getInstance().bwrite(boardDto);
    	
    	response.setContentType("application/json; charset=UTF-8");
    	response.getWriter().print(result);
	}
    
	// 2. 게시판 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	// 3. 게시판 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// 4. 게시판 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
