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
import BEAN.Watch;
import DAO.ThemDienThoaiDAO;
import DAO.ThemDongHoDAO;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/SuaDongHoController")
public class SuaDongHoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaDongHoController() {
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
			ThemDongHoDAO dao = new ThemDongHoDAO();
			String action = request.getParameter("action");
			
			if(action!=null && action.equals("sua"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Watch watch = new Watch();
				watch = dao.getByID(id);
				request.setAttribute("list",watch);
				RequestDispatcher rd = request.getRequestDispatcher("SuaDongHoForward");
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
		int madongho = Integer.parseInt(request.getParameter("madongho").trim());
		String name = request.getParameter("name");
		String manhinh = request.getParameter("manhinh");
		String congnghemh = request.getParameter("congnghemh");
		String hedieuhanh = request.getParameter("hedieuhanh");
		String detail = request.getParameter("detail");
		String brand = request.getParameter("brand");

		int giatien = Integer.parseInt(request.getParameter("giatien"));
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		long a = filePart.getSize();
		if(a == 0)
		{
			hinhanh = "1";
		}
		else 
		{
			hinhanh = "2";
		}
		Watch watch =new Watch();
		watch.setMadongho(madongho);
		watch.setName(name);
		watch.setManhinh(manhinh);
		watch.setCongnghemh(congnghemh);
		watch.setHedieuhanh(hedieuhanh);
		watch.setDetail(detail);
		watch.setGiatien(giatien);
		watch.setSoluong(soluong);
		watch.setBrand(brand);
		watch.setInputStream(inputStream);
		watch.setHinhanh(hinhanh);
		try {
			ThemDongHoDAO.Update(watch, conn);
			String mess = "Cập nhật thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachdonghoForward");
			rd.forward(request, response);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
