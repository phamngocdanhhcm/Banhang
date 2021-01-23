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

import BEAN.Watch;
import DAO.ThemDienThoaiDAO;
import DAO.ThemDongHoDAO;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/ThemDongHoController")
public class ThemDongHoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ThemDongHoController() {
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
			ThemDongHoDAO dao = new ThemDongHoDAO();
			String action = request.getParameter("action");
			if(action!=null && action.equals("xoa"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				dao.delete(id, conn);
			}
			
			request.setAttribute("list",ThemDienThoaiDAO.getAll(conn));
			RequestDispatcher rd = request.getRequestDispatcher("DanhsachdonghoForward");
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
		
		//int madongho = Integer.parseInt(request.getParameter("madongho"));
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String manhinh = request.getParameter("manhinh");
		String congnghemh =  request.getParameter("congnghemanhinh");
		String hedieuhanh = request.getParameter("hedieuhanh");
		int soluong = Integer.parseInt(request.getParameter("soluong"));
		String detail = request.getParameter("detail");
		int giatien = Integer.parseInt(request.getParameter("gia"));
	
		Part filePart = request.getPart("photo");

		if (filePart != null) {
            // prints out some information for debugging
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            
        }
		
		Watch dongho = new Watch();
	//	dongho.setMadongho(madongho);
		dongho.setName(name);
		dongho.setBrand(brand);
		dongho.setManhinh(manhinh);
		dongho.setCongnghemh(congnghemh);
		dongho.setHedieuhanh(hedieuhanh);
		dongho.setSoluong(soluong);
		dongho.setDetail(detail);
		dongho.setGiatien(giatien);
		dongho.setInputStream(inputStream);

		
		boolean kt = ThemDongHoDAO.InsertWatch(request, conn, dongho);
		if(kt)
		{
			String mess = "Thêm thành công";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemDongHoForward");
			rd.forward(request, response);	
			
			
			
		}
		else {
			String mess = "Thêm thất bại!";
			request.setAttribute("mess", mess);
			RequestDispatcher rd = request.getRequestDispatcher("ThemDongHoForward");
			rd.forward(request, response);
		}
	}

}
