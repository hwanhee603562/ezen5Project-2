package contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MyMenuDao;
import model.dto.ItemsInfo;
import model.dto.Mymenu;


@WebServlet("/MyMenuController")
public class MyMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public MyMenuController() {

    }

    // 마이메뉴 출력함수
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		// 판매중인 물품 출력
		if(type.equals("1")) {
			
			int mno = Integer.parseInt(request.getParameter("mno"));
			int estate = Integer.parseInt(request.getParameter("estate"));
			
			List<ItemsInfo> result = MyMenuDao.getInstance().saleList(mno, estate);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(json);
		}
		// 회원 정보 출력
		else if(type.equals("2")) {
			int mno = Integer.parseInt(request.getParameter("mno"));
			int tradeCount = MyMenuDao.getInstance().tradeCount(mno);
			
			System.out.println(mno + " " + tradeCount);
			
			Mymenu result = MyMenuDao.getInstance().printMemberInfo(mno);
			result.setTradelog(tradeCount);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(result);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(json);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
