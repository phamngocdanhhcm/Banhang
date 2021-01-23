package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;
import DAO.ThemDongHoDAO;
import DAO.ThemdonhangDAO;
import DB.DBConnection;

/**
 * Servlet implementation class DanhsachtaikhoanController
 */
@WebServlet("/DanhsachtaikhoanController")
public class DanhsachtaikhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhsachtaikhoanController() {
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
			    RegisterDAO dao = new RegisterDAO();
			    String action = request.getParameter("action");
			    if(action!=null && action.equals("xoa"))
			    {
			    	int id = Integer.parseInt(request.getParameter("id"));
					dao.delete(id, conn);
					
			    }
				request.setAttribute("list",RegisterDAO.getAll(conn));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Danhsachtaikhoan.jsp");
				rd.forward(request, response);
		}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		 try {
			    RegisterDAO dao = new RegisterDAO();
			    String action = request.getParameter("action");
			    if(action!=null && action.equals("xoa"))
			    {
			    	int id = Integer.parseInt(request.getParameter("id"));
					dao.delete(id, conn);
					
			    }
				request.setAttribute("list",RegisterDAO.getAll(conn));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Danhsachtaikhoan.jsp");
				rd.forward(request, response);
		}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
