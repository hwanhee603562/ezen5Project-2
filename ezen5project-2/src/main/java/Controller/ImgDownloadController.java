package Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
		System.out.println("111");
		
		
		String filename = request.getParameter("simg");
		String uploadpath = request.getServletContext().getRealPath("/sns/img");
		String filepath = uploadpath+"/"+filename;
		System.out.println("222");
		response.setHeader(
				"Content-Disposition" ,
				"attachment;filename="+URLEncoder.encode(filepath , "UTF-8"));
		System.out.println("333");
		File file = new File(filepath);
		FileInputStream fin = new FileInputStream(file);
		byte[] bytes = new byte[ (int)file.length()];
		fin.read(bytes);
		System.out.println("444");
		BufferedOutputStream oin = new BufferedOutputStream(response.getOutputStream());
		
		oin.write(bytes);
		System.out.println("555");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
