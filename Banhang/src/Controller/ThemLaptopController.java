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

import BEAN.Laptop;
import DAO.ThemDienThoaiDAO;
import DAO.ThemLaptopDAO;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/ThemLaptopController")
public class ThemLaptopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ThemLaptopController() {
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
			ThemLaptopDAO dao = new ThemLaptopDAO();
			String action = request.getParameter("action");
			if(action!=null && action.equals("xoa"))
			{
				String id = request.getParameter("id");
				dao.delete(id, conn);
			}
			
			 
			
			 
			request.setAttribute("list",ThemLaptopDAO.getAll(conn));
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachlaptopForward");
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
		
		//String malaptop = request.getParameter("malaptop");
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		int ram = Integer.parseInt(request.getParameter("ram"));
		String chipdohoa =  request.getParameter("chipdohoa");
		String phangiai = request.getParameter("phangiai");
		String kichthuoc = request.getParameter("kichthuoc");
		String series = request.getParameter("series");
		int soluong = Integer.parseInt(request.getParameter("quantity")); 	
		String detail = request.getParameter("detail");
		int giatien = Integer.parseInt(request.getParameter("giatien"));
		Part filePart = request.getPart("photo");
		if (filePart != null) {
            // prints out some information for debugging
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            
        }
		
		Laptop laptop = new Laptop();
	//	laptop.setMalaptop(malaptop);
		laptop.setName(name);
		laptop.setBrand(brand);
		laptop.setRam(ram);
		laptop.setChipdohoa(chipdohoa);
		laptop.setPhangiai(phangiai);
		laptop.setKichthuoc(kichthuoc);
		laptop.setSeries(series);
		laptop.setSoluong(soluong);
		laptop.setDetail(detail);
		laptop.setGiatien(giatien);
		laptop.setInputStream(inputStream);
		
		boolean kt = ThemLaptopDAO.InsertLaptop(request, conn, laptop);
		if(kt)
		{
			String mess = "Thêm thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemLaptopForward");
			rd.forward(request, response);	
			
			
			
		}
		else {
			String mess = "Thêm thất bại!";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemLaptopForward");
			rd.forward(request, response);
		}
		
	}

}
