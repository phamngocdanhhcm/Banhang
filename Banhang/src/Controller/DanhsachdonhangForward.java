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

import DAO.ThemDienThoaiDAO;
import DAO.ThemdonhangDAO;
import DB.DBConnection;

/**
 * Servlet implementation class DanhsachdonhangForward
 */
@WebServlet("/DanhsachdonhangForward")
public class DanhsachdonhangForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhsachdonhangForward() {
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
			 	
				request.setAttribute("list",ThemdonhangDAO.getAll(conn));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Dondathang.jsp");
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
			 	
				request.setAttribute("list",ThemdonhangDAO.getAll(conn));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Dondathang.jsp");
				rd.forward(request, response);
		}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

}
