package contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.ItemDao;
import model.dto.CategoryDto;


@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ItemController() {
        super();
    }

    // 제품 정보 가져오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		
		// 1. 물품 등록 시 카테고리 대분류 반환
		if( type.equals("getMainCategory") ) {
			
			ArrayList<CategoryDto> categoryList = ItemDao.getInstance().getMainCategory();
			json = mapper.writeValueAsString(categoryList);
			
		}
		// 2. 대분류 선택 시 대분류에 대한 카테고리 소분류 반환 
		else if ( type.equals("getSubCategory") ) {
			
			int uno = Integer.parseInt(request.getParameter("uno"));
			ArrayList<CategoryDto> categoryList = ItemDao.getInstance().getSubCategory( uno );
			json = mapper.writeValueAsString(categoryList);
		}
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print( json );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
