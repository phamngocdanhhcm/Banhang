package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Users;
import DAO.RegisterDAO;
import DB.DBConnection;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterController() {
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
		String username = request.getParameter("username");
		String pass     = request.getParameter("password");
		String name     = request.getParameter("name");
		String email    = request.getParameter("email");
		int    phone    = Integer.parseInt(request.getParameter("phone"));
		//int    categoryid = Integer.parseInt(request.getParameter("categoryid"));
		Users users 	= new Users();
		users.setUsername(username);
		users.setPassword(pass);
		users.setName(name);
		users.setEmail(email);
		users.setPhone(phone);
		//users.setCategoryid(categoryid);
		
		Boolean kt = RegisterDAO.InsertAccount(request, conn, users);
		if(kt == true) {
			request.setAttribute("mess", "Dang Ky Thanh Cong");
			RequestDispatcher rd = request.getRequestDispatcher("LoginForward");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("mess", "Dang Ky That Bai");
			RequestDispatcher rd = request.getRequestDispatcher("LoginForward");
			rd.forward(request, response);
			
			
		}
	}

}
