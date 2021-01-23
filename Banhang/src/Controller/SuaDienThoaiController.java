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

import BEAN.Phone;
import DAO.ThemDienThoaiDAO;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/SuaDienThoaiController")
public class SuaDienThoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDienThoaiController() {
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
			ThemDienThoaiDAO dao = new ThemDienThoaiDAO();
			String action = request.getParameter("action");
			
			if(action!=null && action.equals("sua"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Phone phone = new Phone();
				phone = dao.getByID(id);
				request.setAttribute("list",phone);
				RequestDispatcher rd = request.getRequestDispatcher("SuaDienThoaiForward");
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
		int idphone = Integer.parseInt(request.getParameter("idphone").trim());
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		int soluong = Integer.parseInt(request.getParameter("quantity"));
		String detail = request.getParameter("moredetail");
		String color = request.getParameter("color");
		int memory = Integer.parseInt(request.getParameter("memory"));
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
		Phone phone =new Phone();
		phone.setIdphone(idphone);
		phone.setName(name);
		phone.setBrand(brand);
		phone.setQuantity(soluong);
		phone.setMoredetail(detail);
		phone.setColor(color);
		phone.setMemory(memory);
		phone.setGiatien(giatien);
		phone.setInputStream(inputStream);
		phone.setHinhanh(hinhanh);
		try {
			ThemDienThoaiDAO.Update(phone, conn);
			String mess = "Cập nhật thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachdienthoaiForward");
			rd.forward(request, response);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
