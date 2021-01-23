package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ThemdonhangDAO;
import DB.DBConnection;

/**
 * Servlet implementation class DanhsachdonhangController
 */
@WebServlet("/DanhsachdonhangController")
public class DanhsachdonhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhsachdonhangController() {
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
			ThemdonhangDAO dao = new ThemdonhangDAO();
			String action = request.getParameter("action");
			
			if(action!=null && action.equals("xacnhan"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				dao.Update(id, conn);
				request.setAttribute("list",dao.getAllChitietdonghang(conn, id));
				RequestDispatcher rd = request.getRequestDispatcher("DanhsachdonhangForward");
				rd.forward(request, response);
			}
			else if(action!=null && action.equals("xoa"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				dao.delete(id, conn);
				request.setAttribute("list",dao.getAllChitietdonghang(conn, id));
				RequestDispatcher rd = request.getRequestDispatcher("DanhsachdonhangForward");
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
		try {
			ThemdonhangDAO dao = new ThemdonhangDAO();
			String action = request.getParameter("action");
			
			if(action!=null && action.equals("xacnhan"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				dao.Update(id, conn);
				request.setAttribute("list",dao.getAllChitietdonghang(conn, id));
				RequestDispatcher rd = request.getRequestDispatcher("DanhsachdonhangForward");
				rd.forward(request, response);
			}
			else if(action!=null && action.equals("xoa"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				dao.delete(id, conn);
				request.setAttribute("list",dao.getAllChitietdonghang(conn, id));
				RequestDispatcher rd = request.getRequestDispatcher("DanhsachdonhangForward");
				rd.forward(request, response);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
