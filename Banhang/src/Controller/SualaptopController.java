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

import BEAN.Laptop;
import BEAN.Phone;
import DAO.ThemDienThoaiDAO;
import DAO.ThemIpadDAO;
import DAO.ThemLaptopDAO;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/SualaptopController")
public class SualaptopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SualaptopController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DBConnection.CreateConnection();
		try {
			ThemLaptopDAO dao = new ThemLaptopDAO();
			String action = request.getParameter("action");
			
			if(action!=null && action.equals("sua"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Laptop laptop = new Laptop();
				laptop = dao.getByID(id);
				request.setAttribute("list",laptop);
				RequestDispatcher rd = request.getRequestDispatcher("SuaLaptopForward");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DBConnection.CreateConnection();
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
		
		if (filePart != null) {
            // prints out some information for debugging
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            
        }
		else {
		}
		
		String hinhanh;
		int malaptop = Integer.parseInt(request.getParameter("malaptop").trim());
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		int ram   = Integer.parseInt(request.getParameter("ram"));
		String chipdohoa = request.getParameter("chipdohoa");
		String phangiai = request.getParameter("phangiai");
		String kichthuoc = request.getParameter("kichthuoc");
		String series  = request.getParameter("series");
		String detail = request.getParameter("detail");
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		int giatien = Integer.parseInt(request.getParameter("giatien"));
		long a = filePart.getSize();
		if(a == 0)
		{
			hinhanh = "1";
		}
		else 
		{
			hinhanh = "2";
		}
		Laptop laptop =new Laptop();
		laptop.setMalaptop(malaptop);
		laptop.setName(name);
		laptop.setBrand(brand);
		laptop.setRam(ram);
		laptop.setChipdohoa(chipdohoa);
		laptop.setPhangiai(phangiai);
		laptop.setKichthuoc(kichthuoc);
		laptop.setSeries(series);
		laptop.setDetail(detail);
		laptop.setSoluong(soluong);
		laptop.setGiatien(giatien);
		laptop.setHinhanh(hinhanh);
		laptop.setInputStream(inputStream);
		try {
			ThemLaptopDAO.Update(laptop, conn);
			String mess = "Cập nhật thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachlaptopForward");
			rd.forward(request, response);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
