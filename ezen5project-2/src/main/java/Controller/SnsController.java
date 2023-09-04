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

import model.dao.SnsDao;
import model.dto.SnsDto;


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
		
	}

	// 글 수정 - 병철
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	// 글 삭제 - 승우
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
