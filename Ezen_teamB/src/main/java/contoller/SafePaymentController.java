package contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.SafePaymentDao;
import model.dto.MemberList;
import model.dto.SafePaymentDto;

// 안전결제 Controller
@WebServlet("/SafePaymentController")
public class SafePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SafePaymentController() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if( type.equals("getBuyerManage") ) {
			
			int maxSize = Integer.parseInt( request.getParameter("maxSize") );
			int page = Integer.parseInt( request.getParameter("page") );
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			int vstateFilter = Integer.parseInt(request.getParameter("vstateFilter"));
			
			
			// 페이지 레코드 시작번호 ( 0, 11, 22 ... )
			int startRow = (page-1) * maxSize;
			// 안전거래 총 진행현황 건수
			int totalPaymentCount = SafePaymentDao.getInstance().getTotalPaymentCount(startDate, endDate, vstateFilter);
			
			// 마지막 페이지 번호 == 총 페이지 수
			int totalPageCount = 
					totalPaymentCount%maxSize == 0 
					? totalPaymentCount/maxSize 
					: totalPaymentCount/maxSize+1;
			
			// 페이지버튼 번호의 최대개수
			int btnsize = 5;
			// 페이지버튼 번호의 시작번호
			int startBtn = ((page-1)/btnsize)*btnsize+1;
			// 페이지버튼 번호의 마지막 번호
			int endBtn = startBtn+btnsize;
			if( endBtn >= totalPageCount ) endBtn = totalPageCount;
			
			ArrayList<SafePaymentDto> result 
			= SafePaymentDao.getInstance().getPaymentList(maxSize, startRow, startDate, endDate, vstateFilter);
			
			
		}
		
		
		
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
