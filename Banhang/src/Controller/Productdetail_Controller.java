package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Ipad;
import BEAN.Laptop;
import BEAN.Phone;
import BEAN.Watch;
import DAO.ThemDienThoaiDAO;
import DAO.ThemDongHoDAO;
import DAO.ThemIpadDAO;
import DAO.ThemLaptopDAO;
import DB.DBConnection;


@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
@WebServlet("/Productdetail_Controller")
public class Productdetail_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productdetail_Controller() {
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
			ThemDienThoaiDAO daophone = new ThemDienThoaiDAO();
			ThemLaptopDAO daolaptop = new ThemLaptopDAO();
			ThemIpadDAO daoipad = new ThemIpadDAO();
			ThemDongHoDAO daodongho = new ThemDongHoDAO();
			String action = request.getParameter("action");
			String sanpham ;
			if(action!=null && action.equals("phone"))
			{
				sanpham = "phone";
				request.setAttribute("sanpham", sanpham);
				int id = Integer.parseInt(request.getParameter("id"));
				Phone phone= new Phone();
				phone = daophone.getByID(id);
				request.setAttribute("listphone",phone);
				request.setAttribute("listdienthoai1",ThemDienThoaiDAO.getProductTop());
				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
				rd.forward(request, response);
			}
			else if (action.equals("laptop"))
			{
				sanpham = "laptop";
				request.setAttribute("sanpham", sanpham);

				int id = Integer.parseInt(request.getParameter("id"));
				Laptop laptop= new Laptop();
				laptop = daolaptop.getByID(id);
				request.setAttribute("listlaptop",laptop);
				
				request.setAttribute("listlaptop1",ThemLaptopDAO.getProductTop());

				
				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
				rd.forward(request, response);
			}
			else if (action.equals("ipad"))
			{
				sanpham = "ipad";
				request.setAttribute("sanpham", sanpham);

				int id = Integer.parseInt(request.getParameter("id"));
				Ipad ipad= new Ipad();
				ipad = daoipad.getByID(id);
				request.setAttribute("listipad",ipad);
				request.setAttribute("listipad1",ThemIpadDAO.getProductTop());

				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
				rd.forward(request, response);
			}
			else if (action.equals("dongho"))
			{
				sanpham = "dongho";
				request.setAttribute("sanpham", sanpham);
				int id = Integer.parseInt(request.getParameter("id"));
				Watch dongho= new Watch();
				dongho = daodongho.getByID(id);
				request.setAttribute("listdongho",dongho);
				request.setAttribute("listdongho1",ThemDongHoDAO.getProductTop());

				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
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
			ThemDienThoaiDAO daophone = new ThemDienThoaiDAO();
			ThemLaptopDAO daolaptop = new ThemLaptopDAO();
			ThemIpadDAO daoipad = new ThemIpadDAO();
			ThemDongHoDAO daodongho = new ThemDongHoDAO();
			String action = request.getParameter("action");
			String sanpham ;
			if(action!=null && action.equals("phone"))
			{
				sanpham = "phone";
				request.setAttribute("sanpham", sanpham);
				int id = Integer.parseInt(request.getParameter("id"));
				Phone phone= new Phone();
				phone = daophone.getByID(id);
				request.setAttribute("listphone",phone);
				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
				rd.forward(request, response);
			}
			else if (action.equals("laptop"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Laptop laptop= new Laptop();
				laptop = daolaptop.getByID(id);
				request.setAttribute("listlaptop",laptop);
				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
				rd.forward(request, response);
			}
			else if (action.equals("ipad"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Ipad ipad= new Ipad();
				ipad = daoipad.getByID(id);
				request.setAttribute("listipad",ipad);
				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
				rd.forward(request, response);
			}
			else if (action.equals("watch"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Watch watch= new Watch();
				watch = daodongho.getByID(id);
				request.setAttribute("listwatch	",watch);
				RequestDispatcher rd = request.getRequestDispatcher("Productdetail_iphoneForward");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
