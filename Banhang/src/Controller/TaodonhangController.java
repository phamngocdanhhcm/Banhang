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
import javax.servlet.http.HttpSession;

import BEAN.Order;
import BEAN.Users;
import DAO.ThemDienThoaiDAO;
import DAO.ThemdonhangDAO;
import DB.DBConnection;

/**
 * Servlet implementation class TaodonhangController
 */
@WebServlet("/TaodonhangController")
public class TaodonhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TaodonhangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DBConnection.CreateConnection();
		HttpSession session = request.getSession();
 
		try {
				ThemdonhangDAO dao = new ThemdonhangDAO();
				Order orders =(Order) session.getAttribute("order"); 
				Users users = new Users();
				users.setName(request.getParameter("ten"));
				users.setPhone(Integer.parseInt(request.getParameter("sodienthoai")));
				users.setDiachi(request.getParameter("diachi"));
				users.setEmail(request.getParameter("email"));
				
				int tongtien = 0;
				int count = orders.getItems().size() - 1 ;
				for(int i = 0 ; i<= count ; i++)
				{
					tongtien = tongtien + (orders.getItems().get(i).getGiaca() * orders.getItems().get(i).getSoluong());
				}
				
				if(dao.Themdonhang(orders, users, tongtien))
				{
					RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
					rd.forward(request, response);
				}
				
				else {
				request.setAttribute("list",ThemDienThoaiDAO.getAll(conn));
				RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
				rd.forward(request, response);	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
