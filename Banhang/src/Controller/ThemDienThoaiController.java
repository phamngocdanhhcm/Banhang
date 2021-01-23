package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.UploadContext;

import BEAN.Phone;
import DAO.ThemDienThoaiDAO;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/ThemDienThoaiController")
public class ThemDienThoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final String  UPLOAD_DIR = "images";
       
 
    public ThemDienThoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DBConnection.CreateConnection();
		
		 try {
			ThemDienThoaiDAO dao = new ThemDienThoaiDAO();
			String action = request.getParameter("action");
			if(action!=null && action.equals("xoa"))
			{
				String id = request.getParameter("id");
				dao.delete(id, conn);
			}
			
			 
			
			 
			request.setAttribute("list",ThemDienThoaiDAO.getAll(conn));
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachdienthoaiForward");
			rd.forward(request, response);	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DBConnection.CreateConnection();
		ThemDienThoaiDAO dao = new ThemDienThoaiDAO();
		InputStream inputStream = null;
		
	//	String idphone = request.getParameter("idphone");
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		int soluong = Integer.parseInt(request.getParameter("quantity"));
		String detail = request.getParameter("moredetail");
		String color = request.getParameter("color");
		int memory = Integer.parseInt(request.getParameter("memory"));
		int giatien = Integer.parseInt(request.getParameter("giatien"));
		Part filePart = request.getPart("photo");
		
		if (filePart != null) {
            // prints out some information for debugging
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            
        }
		
		
	//	part.write(savePath + File.separator);
		
		
		Phone phone =new Phone();
	//	phone.setIdphone(idphone);
		phone.setName(name);
		phone.setBrand(brand);
		phone.setQuantity(soluong);
		phone.setMoredetail(detail);
		phone.setColor(color);
		phone.setMemory(memory);
		phone.setGiatien(giatien);
		phone.setInputStream(inputStream);
		
		
		
		//phone.setHinhanh(dao.uploadFile(request));
		
		boolean kt = ThemDienThoaiDAO.InsertPhone(request, conn, phone);
		if(kt)
		{
			String mess = "Thêm thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemDienThoaiForward");
			rd.forward(request, response);	
			
			
			
		}
		else {
			String mess = "Thêm thất bại!";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemDienThoaiForward");
			rd.forward(request, response);
		}
		
		
	}
	
	
   

}
