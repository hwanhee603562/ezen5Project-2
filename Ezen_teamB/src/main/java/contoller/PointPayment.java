package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ItemDao;
import model.dao.PointPaymentDao;

// 포인트 Controller
@WebServlet("/pointPayment")
public class PointPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PointPayment() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int vrequester = Integer.parseInt( request.getParameter("vrequester") );
    	int ino = Integer.parseInt( request.getParameter("ino") );
    	
    	// 포인트 조회
    	int mpoint = PointPaymentDao.getInstance().getMemeberPoint( vrequester );
    	// 물품 가격 조회
    	int iprice = ItemDao.getInstance().getItemPrice( ino );
    	
    	boolean result = false;
    	if( mpoint >= iprice ) result = true;
    	
    	/*
    	ObjectMapper mapper = new ObjectMapper();
    	String json = mapper.writeValueAsString( safepayPageDto );
    	*/
    	
    	response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( result );
    	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
