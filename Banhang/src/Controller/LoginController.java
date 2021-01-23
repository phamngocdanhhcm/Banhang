package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Users;
import DAO.LoginDAO;
import DB.DBConnection;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getCharacterEncoding() == null)
		{
			request.setCharacterEncoding("UTF-8");
		}
		Connection conn = DBConnection.CreateConnection();
		
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		Users users = new Users();
		users.setUsername(user);
		users.setPassword(pass);
		
		boolean kt = LoginDAO.Authenticationmember(request, conn, users);
		String name = LoginDAO.Exportnameuser(request, conn, users);
		
		if(kt)
		{
			int authorization = LoginDAO.Authorizationmember(request, conn, users);
			if(authorization ==1 ) {
				
				HttpSession session = request.getSession(true);
				session.setAttribute("username", user);
				session.setAttribute("sessionuser", name );
				
				RequestDispatcher rd = request.getRequestDispatcher("HomeForward");
				rd.forward(request, response);	
			}
			
			else {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", user);
				session.setAttribute("sessionuser", name );
				
				RequestDispatcher rd = request.getRequestDispatcher("AdminForward");
				rd.forward(request, response);
			}
			
			
		}
		else {
			String mess2 = "Login Fail";
			request.setAttribute("msglogin", mess2);
			
			RequestDispatcher rd = request.getRequestDispatcher("LoginForward");
			rd.forward(request, response);
		}
 	}

}
