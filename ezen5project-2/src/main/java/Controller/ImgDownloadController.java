package Controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImgDownloadController
 */
@WebServlet("/ImgDownloadController")
public class ImgDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImgDownloadController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filename = request.getParameter("simg");
		String uploadpath = request.getServletContext().getRealPath("");
		String filepath = uploadpath+"/"+filename;
		
		response.setHeader(
				"Content-Disposition" ,
				"attachment;filename="+URLEncoder.encode(filepath , "UTF-8"));
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
