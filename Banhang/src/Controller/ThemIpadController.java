package Controller;

import java.io.IOException;
import java.io.InputStream;
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

import BEAN.Ipad;
import DAO.ThemIpadDAO;
import DAO.ThemLaptopDAO;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

@WebServlet("/ThemIpadController")
public class ThemIpadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ThemIpadController() {
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
			ThemIpadDAO dao = new ThemIpadDAO();
			String action = request.getParameter("action");
			if(action!=null && action.equals("xoa"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				dao.delete(id, conn);
			}
			
			 
			
			 
			request.setAttribute("list",dao.getAll(conn));
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachipadForward");
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
		InputStream inputStream = null;

		
		//String maipad = request.getParameter("maipad");
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String dungluong = request.getParameter("dungluong");
		String hedieuhanh =  request.getParameter("hedieuhanh");
		int ram = Integer.parseInt(request.getParameter("ram"));
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		String detail = request.getParameter("detail");
		int giatien = Integer.parseInt(request.getParameter("giatien"));
		Part filePart = request.getPart("photo");
		if (filePart != null) {
            // prints out some information for debugging
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            
        }
		
		Ipad ipad = new Ipad();
		//ipad.setMaipad(maipad);
		ipad.setName(name);
		ipad.setBrand(brand);
		ipad.setDungluong(dungluong);
		ipad.setHedieuhanh(hedieuhanh);
		ipad.setRam(ram);
		ipad.setSoluong(soluong);
		ipad.setDetail(detail);
		ipad.setGiatien(giatien);
		ipad.setInputStream(inputStream);
		
		boolean kt = ThemIpadDAO.InsertIpad(request, conn, ipad);
		if(kt)
		{
			String mess = "Thêm thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemIpadForward");
			rd.forward(request, response);	
			
			
			
		}
		else {
			String mess = "Thêm thất bại!";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemIpadForward");
			rd.forward(request, response);
		}
	}

}
