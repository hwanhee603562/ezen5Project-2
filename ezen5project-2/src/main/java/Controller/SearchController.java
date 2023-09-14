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
import model.dao.SnsDao;
import model.dto.ReplyDto;
import model.dto.SnsDto;
import model.dto.ReponseDto;


@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SearchController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchWord = request.getParameter("searchWord");
		
		ArrayList<SnsDto> list = new ArrayList<>();
		list = SnsDao.getInstance().searchContent( searchWord );
		
		for(int i = 0; i < list.size(); i++) {

			try {
				Date format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(list.get(i).getSdate());
				Date format2 = new Date();
				
				long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
		        long diffMin = (format2.getTime() - format1.getTime()) / 60000; //분 차이
		        long diffHor = (format2.getTime() - format1.getTime()) / 3600000; //시 차이
		        long diffDays = diffSec / (24*60*60); //일자수 차이

		        String datecheck = "" + diffMin;
		        
		        list.get(i).setSdate(datecheck);
				
			} catch (Exception e) {System.out.println(e);}
		}
		
		ArrayList<ReplyDto> result2 = ReplyDao.getInstance().printReply();
		ReponseDto reponseDto = new ReponseDto(list, result2);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString( reponseDto );
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
