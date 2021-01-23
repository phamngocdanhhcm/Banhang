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
import DAO.ThemDongHoDAO;
import DAO.ThemIpadDAO;
import DAO.ThemLaptopDAO;
import DB.DBConnection;


@WebServlet("/HomeForward")
public class HomeForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HomeForward() {
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
		 	
			request.setAttribute("listdienthoai",ThemDienThoaiDAO.getProductTop());
			request.setAttribute("listlaptop",ThemLaptopDAO.getProductTop());
			request.setAttribute("listdongho",ThemDongHoDAO.getProductTop());
			request.setAttribute("listipad",ThemIpadDAO.getProductTop());


		//	request.setAttribute("list",ThemDienThoaiDAO.getProductTop(conn));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
			rd.forward(request, response);
	}
		
	 catch (SQLException e) {
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
		
		try {
		 	
			request.setAttribute("listdienthoai",ThemDienThoaiDAO.getProductTop());
			request.setAttribute("listlaptop",ThemLaptopDAO.getProductTop());
			request.setAttribute("listdongho",ThemDongHoDAO.getProductTop());
			request.setAttribute("listipad",ThemIpadDAO.getProductTop());

		//	request.setAttribute("list",ThemDienThoaiDAO.getProductTop(conn));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/View/Home.jsp");
			rd.forward(request, response);
	}
		
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
