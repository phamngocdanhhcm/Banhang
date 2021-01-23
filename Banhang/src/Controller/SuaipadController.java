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
@WebServlet("/SuaipadController")
public class SuaipadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaipadController() {
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
			ThemIpadDAO dao = new ThemIpadDAO();
			String action = request.getParameter("action");
			
			if(action!=null && action.equals("sua"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Ipad ipad = new Ipad();
				ipad = dao.getByID(id);
				request.setAttribute("list",ipad);
				RequestDispatcher rd = request.getRequestDispatcher("SuaIpadForward");
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
		int maipad = Integer.parseInt(request.getParameter("maipad").trim());
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String dungluong = request.getParameter("dungluong");
		String hedieuhanh = request.getParameter("hedieuhanh");
		int ram = Integer.parseInt(request.getParameter("ram"));
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		String detail = request.getParameter("detail");
		
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
		Ipad ipad =new Ipad();
		ipad.setMaipad(maipad);
		ipad.setName(name);
		ipad.setBrand(brand);
		ipad.setDungluong(dungluong);
		ipad.setHedieuhanh(hedieuhanh);
		ipad.setRam(ram);
		ipad.setSoluong(soluong);
		ipad.setGiatien(giatien);
		ipad.setDetail(detail);
		ipad.setInputStream(inputStream);
		ipad.setHinhanh(hinhanh);
		try {
			ThemIpadDAO.Update(ipad, conn);
			String mess = "Cập nhật thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachipadForward");
			rd.forward(request, response);	
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
