package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.Ipad;
import BEAN.Items;
import BEAN.Laptop;
import BEAN.Order;
import BEAN.Phone;
import BEAN.Watch;
import DAO.ThemDienThoaiDAO;
import DAO.ThemDongHoDAO;
import DAO.ThemIpadDAO;
import DAO.ThemLaptopDAO;


@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quantity = 1 ;
		int id ; 
		int tonggiatien;
		int tongtien = 0;
		int vat = 0;
		String action = request.getParameter("action");

		int tongtien1 = 0;
		ThemDienThoaiDAO dao = new ThemDienThoaiDAO();
		ThemLaptopDAO daolaptop = new ThemLaptopDAO();
		ThemIpadDAO daoipad = new ThemIpadDAO();
		ThemDongHoDAO daodongho = new ThemDongHoDAO();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("tongtien") == null)
		{
			tongtien = 0;
		}
		else {
			tongtien = (int) session.getAttribute("tongtien");
		}

		
		if(action!=null && action.equals("xoaphone"))
		{
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			
				try {
					Phone phone = dao.getByID(idxoa);
					for(Items items : list)
					{
						if(items.getPhone() !=null && items.getPhone().getIdphone() == phone.getIdphone() ) {
							tongtien = tongtien - items.getTonggiatien();
							list.remove(xoa);
							break;
						}
						xoa = xoa + 1; 
					}
					session.setAttribute("tongtien", tongtien);
					vat = tongtien / 10;
					tongtien1 = tongtien - vat;
					
					
					session.setAttribute("tong", tongtien1);
					request.setAttribute("vat",dao.Dinhdangtiente(vat));
					request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
					request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
					session.setAttribute("order", order);
					RequestDispatcher rd = request.getRequestDispatcher("CartForward");
					rd.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
		else if (action!=null && action.equals("xoalaptop")) {
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			
				try {
					Laptop laptop = daolaptop.getByID(idxoa);
					for(Items items : list)
					{
						if(items.getLaptop() !=null && items.getLaptop().getMalaptop() == laptop.getMalaptop() ) {
							tongtien = tongtien - items.getTonggiatien();
							list.remove(xoa);
							break;
						}
						xoa = xoa + 1; 
					}
					session.setAttribute("tongtien", tongtien);
					vat = tongtien / 10;
					tongtien1 = tongtien - vat;
					
					session.setAttribute("tong", tongtien1);
					request.setAttribute("vat",dao.Dinhdangtiente(vat));
					request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
					request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
					session.setAttribute("order", order);
					RequestDispatcher rd = request.getRequestDispatcher("CartForward");
					rd.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else if (action!=null && action.equals("xoaipad")) {
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			try {
				Ipad ipad = daoipad.getByID(idxoa);
				for(Items items : list)
				{
					if(items.getIpad() !=null && items.getIpad().getMaipad() == ipad.getMaipad() ) {
						tongtien = tongtien - items.getTonggiatien();
						list.remove(xoa);
						break;
					}
					xoa = xoa + 1; 
				}
				session.setAttribute("tongtien", tongtien);
				vat = tongtien / 10;
				tongtien1 = tongtien - vat;
				
				session.setAttribute("tong", tongtien1);
				request.setAttribute("vat",dao.Dinhdangtiente(vat));
				request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
				request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
				session.setAttribute("order", order);
				RequestDispatcher rd = request.getRequestDispatcher("CartForward");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else if (action!=null && action.equals("xoadongho")) {
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			try {
				Watch watch = daodongho.getByID(idxoa);
				for(Items items : list)
				{
					if(items.getWatch() !=null && items.getWatch().getMadongho() == watch.getMadongho() ) {
						tongtien = tongtien - items.getTonggiatien();
						list.remove(xoa);
						break;
					}
					xoa = xoa + 1; 
				}
				session.setAttribute("tongtien", tongtien);
				vat = tongtien / 10;
				tongtien1 = tongtien - vat;
				
				session.setAttribute("tong", tongtien1);
				request.setAttribute("vat",dao.Dinhdangtiente(vat));
				request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
				request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
				session.setAttribute("order", order);
				RequestDispatcher rd = request.getRequestDispatcher("CartForward");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else {
			
		if(request.getParameter("idphone") != null)
		{
			id = Integer.parseInt(request.getParameter("idphone"));
			try {
				Phone phone = ThemDienThoaiDAO.getByID(id);
				if(phone != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * phone.getGiatien();
					tongtien = tongtien + tonggiatien;
					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items = new Items();
					items.setSoluong(quantity);
					items.setPhone(phone);
					items.setGiaca(phone.getGiatien());
					items.setTonggiatien(tonggiatien);
					items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
					items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
					listphone.add(items);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);
					

				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listphone = order.getItems();
					boolean check = false;
					for(Items items : listphone)
					{
						
						if( items.getPhone() !=null && items.getPhone().getIdphone() == phone.getIdphone() ) {
						items.setSoluong(items.getSoluong()+1);
						check = true;
						tonggiatien = items.getSoluong() * phone.getGiatien();
						tongtien = tongtien + phone.getGiatien();
						items.setTonggiatien(tonggiatien);
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						}
						
						
					}
					if(check == false)
					{	tonggiatien = quantity * phone.getGiatien();
			     		tongtien = tongtien + tonggiatien;
						Items items = new Items();
						items.setSoluong(quantity);
						items.setPhone(phone);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(phone.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listphone.add(items);
						
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);
					session.setAttribute("tong", tongtien1);

					
				}
				
			
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		else if(request.getParameter("malaptop") != null)
		{
			id = Integer.parseInt(request.getParameter("malaptop"));
			try {
				Laptop laptop = ThemLaptopDAO.getByID(id);
				if(laptop != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * laptop.getGiatien();
					tongtien = tongtien + tonggiatien;

					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items = new Items();
					items.setSoluong(quantity);
					items.setLaptop(laptop);
					items.setGiaca(laptop.getGiatien());
					items.setTonggiatien(tonggiatien);
					items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
					items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
					listphone.add(items);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);

				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listlaptop = order.getItems();
					boolean check = false;
					for(Items items : listlaptop)
					{
						if( items.getLaptop() !=null) {
						if(items.getLaptop().getMalaptop() == laptop.getMalaptop()) {
							items.setSoluong(items.getSoluong()+1);
							check = true;
							tonggiatien = items.getSoluong() * laptop.getGiatien();
							items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
							items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
							tongtien = tongtien + laptop.getGiatien();
							items.setTonggiatien(tonggiatien);
						}
						
						}
					}
					if(check == false)
					{	tonggiatien = quantity * laptop.getGiatien();
						tongtien = tongtien + tonggiatien;

						Items items = new Items();
						items.setSoluong(quantity);
						items.setLaptop(laptop);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(laptop.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listlaptop.add(items);
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(request.getParameter("maipad") != null)
		{
			id = Integer.parseInt(request.getParameter("maipad"));
			try {
				Ipad ipad = ThemIpadDAO.getByID(id);
				if(ipad != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * ipad.getGiatien();
					tongtien = tongtien + tonggiatien;

					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items = new Items();
					items.setSoluong(quantity);
					items.setIpad(ipad);
					items.setGiaca(ipad.getGiatien());
					items.setTonggiatien(tonggiatien);
					items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
					items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
					listphone.add(items);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);

				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listipad = order.getItems();
					boolean check = false;
					for(Items items : listipad)
					{
						if( items.getIpad() !=null) {
						if(items.getIpad().getMaipad() == ipad.getMaipad()) {
							items.setSoluong(items.getSoluong()+1);
							check = true;
							tonggiatien = items.getSoluong() * ipad.getGiatien();
							items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
							items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
							tongtien = tongtien + ipad.getGiatien();
							items.setTonggiatien(tonggiatien);
						}
						
						}
					}
					if(check == false)
					{	tonggiatien = quantity * ipad.getGiatien();
						tongtien = tongtien + tonggiatien;

						Items items = new Items();
						items.setSoluong(quantity);
						items.setIpad(ipad);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(ipad.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listipad.add(items);
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(request.getParameter("madongho") != null)
		{
			id = Integer.parseInt(request.getParameter("madongho"));
			try {
				Watch watch = ThemDongHoDAO.getByID(id);
				if(watch != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * watch.getGiatien();
					tongtien = tongtien + tonggiatien;

					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items = new Items();
					items.setSoluong(quantity);
					items.setWatch(watch);
					items.setGiaca(watch.getGiatien());
					items.setTonggiatien(tonggiatien);
					items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
					items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
					listphone.add(items);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);

				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listwatch = order.getItems();
					boolean check = false;
					for(Items items : listwatch)
					{
						if( items.getWatch() !=null) {
						if(items.getWatch().getMadongho() == watch.getMadongho()) {
							items.setSoluong(items.getSoluong()+1);
							check = true;
							tonggiatien = items.getSoluong() * watch.getGiatien();
							items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
							items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
							tongtien = tongtien + watch.getGiatien();
							items.setTonggiatien(tonggiatien);
							
						}
						}
					}
					if(check == false)
					{	tonggiatien = quantity * watch.getGiatien();
						tongtien = tongtien + tonggiatien;

						Items items = new Items();
						items.setSoluong(quantity);
						items.setWatch(watch);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(watch.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listwatch.add(items);
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		vat = tongtien / 10;
		tongtien1 = tongtien - vat;
		
		session.setAttribute("tong", tongtien1);
		request.setAttribute("vat",dao.Dinhdangtiente(vat));
		request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
		request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
		RequestDispatcher rd = request.getRequestDispatcher("CartForward");
		rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quantity = 1 ;
		int id ; 
		int tonggiatien;
		int tongtien = 0;
		int vat = 0;
		String action = request.getParameter("action");

		int tongtien1 = 0;
		ThemDienThoaiDAO dao = new ThemDienThoaiDAO();
		ThemLaptopDAO daolaptop = new ThemLaptopDAO();
		ThemIpadDAO daoipad = new ThemIpadDAO();
		ThemDongHoDAO daodongho = new ThemDongHoDAO();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("tongtien") == null)
		{
			tongtien = 0;
		}
		else {
			tongtien = (int) session.getAttribute("tongtien");
		}

		
		if(action!=null && action.equals("xoaphone"))
		{
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			
				try {
					Phone phone = dao.getByID(idxoa);
					for(Items items : list)
					{
						if(items.getPhone() !=null && items.getPhone().getIdphone() == phone.getIdphone() ) {
							tongtien = tongtien - items.getTonggiatien();
							list.remove(xoa);
							break;
						}
						xoa = xoa + 1; 
					}
					session.setAttribute("tongtien", tongtien);
					vat = tongtien / 10;
					tongtien1 = tongtien - vat;
					

					request.setAttribute("vat",dao.Dinhdangtiente(vat));
					request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
					request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
					session.setAttribute("order", order);
					RequestDispatcher rd = request.getRequestDispatcher("CartForward");
					rd.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}	
		else if (action!=null && action.equals("xoalaptop")) {
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			
				try {
					Laptop laptop = daolaptop.getByID(idxoa);
					for(Items items : list)
					{
						if(items.getLaptop() !=null && items.getLaptop().getMalaptop() == laptop.getMalaptop() ) {
							tongtien = tongtien - items.getTonggiatien();
							list.remove(xoa);
							break;
						}
						xoa = xoa + 1; 
					}
					session.setAttribute("tongtien", tongtien);
					vat = tongtien / 10;
					tongtien1 = tongtien - vat;
					

					request.setAttribute("vat",dao.Dinhdangtiente(vat));
					request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
					request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
					session.setAttribute("order", order);
					RequestDispatcher rd = request.getRequestDispatcher("CartForward");
					rd.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else if (action!=null && action.equals("xoaipad")) {
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			try {
				Ipad ipad = daoipad.getByID(idxoa);
				for(Items items : list)
				{
					if(items.getIpad() !=null && items.getIpad().getMaipad() == ipad.getMaipad() ) {
						tongtien = tongtien - items.getTonggiatien();
						list.remove(xoa);
						break;
					}
					xoa = xoa + 1; 
				}
				session.setAttribute("tongtien", tongtien);
				vat = tongtien / 10;
				tongtien1 = tongtien - vat;
				

				request.setAttribute("vat",dao.Dinhdangtiente(vat));
				request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
				request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
				session.setAttribute("order", order);
				RequestDispatcher rd = request.getRequestDispatcher("CartForward");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else if (action!=null && action.equals("xoadongho")) {
			int xoa = 0;
			int idxoa = Integer.parseInt(request.getParameter("idxoa"));
			Order order = (Order) session.getAttribute("order");
			List<Items> list = order.getItems();
			try {
				Watch watch = daodongho.getByID(idxoa);
				for(Items items : list)
				{
					if(items.getWatch() !=null && items.getWatch().getMadongho() == watch.getMadongho() ) {
						tongtien = tongtien - items.getTonggiatien();
						list.remove(xoa);
						break;
					}
					xoa = xoa + 1; 
				}
				session.setAttribute("tongtien", tongtien);
				vat = tongtien / 10;
				tongtien1 = tongtien - vat;
				

				request.setAttribute("vat",dao.Dinhdangtiente(vat));
				request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
				request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
				session.setAttribute("order", order);
				RequestDispatcher rd = request.getRequestDispatcher("CartForward");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else {
			
		if(request.getParameter("idphone") != null)
		{
			id = Integer.parseInt(request.getParameter("idphone"));
			try {
				Phone phone = ThemDienThoaiDAO.getByID(id);
				if(phone != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * phone.getGiatien();
					tongtien = tongtien + tonggiatien;
					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items1 = new Items();
					items1.setSoluong(quantity);
					items1.setPhone(phone);
					items1.setGiaca(phone.getGiatien());
					items1.setTonggiatien(tonggiatien);
					items1.setGiaca1(dao.Dinhdangtiente(items1.getGiaca()));
					items1.setTonggiatien1(dao.Dinhdangtiente(items1.getTonggiatien()));
					listphone.add(items1);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);
				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listphone = order.getItems();
					boolean check = false;
					for(Items items : listphone)
					{
						
						if( items.getPhone() !=null && items.getPhone().getIdphone() == phone.getIdphone() ) {
						items.setSoluong(items.getSoluong()+1);
						check = true;
						tonggiatien = items.getSoluong() * phone.getGiatien();
						tongtien = tongtien + phone.getGiatien();
						items.setTonggiatien(tonggiatien);
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						}
						
						
					}
					if(check == false)
					{	tonggiatien = quantity * phone.getGiatien();
			     		tongtien = tongtien + tonggiatien;
						Items items = new Items();
						items.setSoluong(quantity);
						items.setPhone(phone);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(phone.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listphone.add(items);
						
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);
					
				}
				
			
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		else if(request.getParameter("malaptop") != null)
		{
			id = Integer.parseInt(request.getParameter("malaptop"));
			try {
				Laptop laptop = ThemLaptopDAO.getByID(id);
				if(laptop != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * laptop.getGiatien();
					tongtien = tongtien + tonggiatien;

					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items = new Items();
					items.setSoluong(quantity);
					items.setLaptop(laptop);
					items.setGiaca(laptop.getGiatien());
					items.setTonggiatien(tonggiatien);
					items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
					items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
					listphone.add(items);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);

				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listlaptop = order.getItems();
					boolean check = false;
					for(Items items : listlaptop)
					{
						if( items.getLaptop() !=null) {
						if(items.getLaptop().getMalaptop() == laptop.getMalaptop()) {
							items.setSoluong(items.getSoluong()+1);
							tonggiatien = items.getSoluong() * laptop.getGiatien();
							tongtien = tongtien + laptop.getGiatien();
							items.setTonggiatien(tonggiatien);
							check = true;
						}
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						}
					}
					if(check == false)
					{	tonggiatien = quantity * laptop.getGiatien();
						tongtien = tongtien + tonggiatien;

						Items items = new Items();
						items.setSoluong(quantity);
						items.setLaptop(laptop);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(laptop.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listlaptop.add(items);
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(request.getParameter("maipad") != null)
		{
			id = Integer.parseInt(request.getParameter("maipad"));
			try {
				Ipad ipad = ThemIpadDAO.getByID(id);
				if(ipad != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * ipad.getGiatien();
					tongtien = tongtien + tonggiatien;

					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items = new Items();
					items.setSoluong(quantity);
					items.setIpad(ipad);
					items.setGiaca(ipad.getGiatien());
					items.setTonggiatien(tonggiatien);
					items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
					items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
					listphone.add(items);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);

				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listipad = order.getItems();
					boolean check = false;
					for(Items items : listipad)
					{
						if( items.getIpad() !=null) {
						if(items.getIpad().getMaipad() == ipad.getMaipad()) {
							items.setSoluong(items.getSoluong() + 1);
							check = true;
							tonggiatien = items.getSoluong() * ipad.getGiatien();
							
							tongtien = tongtien + ipad.getGiatien();
							items.setTonggiatien(tonggiatien);
							items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
							items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						}
						
						
						}
					}
					if(check == false)
					{	tonggiatien = quantity * ipad.getGiatien();
						tongtien = tongtien + tonggiatien;

						Items items = new Items();
						items.setSoluong(quantity);
						items.setIpad(ipad);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(ipad.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listipad.add(items);
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(request.getParameter("madongho") != null)
		{
			id = Integer.parseInt(request.getParameter("madongho"));
			try {
				Watch watch = ThemDongHoDAO.getByID(id);
				if(watch != null)
				{
					quantity = Integer.parseInt(request.getParameter("quantity"));
				}
				if(session.getAttribute("order") == null)
				{
					
					tonggiatien = quantity * watch.getGiatien();
					tongtien = tongtien + tonggiatien;

					Order order = new Order();
					List<Items> listphone = new ArrayList<Items>();
					Items items = new Items();
					items.setSoluong(quantity);
					items.setWatch(watch);
					items.setGiaca(watch.getGiatien());
					items.setTonggiatien(tonggiatien);
					items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
					items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
					listphone.add(items);
					order.setItems(listphone);
					session.setAttribute("order", order);
					session.setAttribute("tongtien", tongtien);

				}
				else 
				{
					Order order = (Order) session.getAttribute("order");
					List<Items> listwatch = order.getItems();
					boolean check = false;
					for(Items items : listwatch)
					{
						if( items.getWatch() !=null) {
						if(items.getWatch().getMadongho() == watch.getMadongho()) {
							items.setSoluong(items.getSoluong()+1);
							check = true;
							tonggiatien = items.getSoluong() * watch.getGiatien();
							items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
							items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
							tongtien = tongtien + watch.getGiatien();
							items.setTonggiatien(tonggiatien);
						}
						
						}
					}
					if(check == false)
					{	tonggiatien = quantity * watch.getGiatien();
						tongtien = tongtien + tonggiatien;

						Items items = new Items();
						items.setSoluong(quantity);
						items.setWatch(watch);
						items.setTonggiatien(tonggiatien);
						items.setGiaca(watch.getGiatien());
						items.setGiaca1(dao.Dinhdangtiente(items.getGiaca()));
						items.setTonggiatien1(dao.Dinhdangtiente(items.getTonggiatien()));
						listwatch.add(items);
					}
					session.setAttribute("order",order);
					session.setAttribute("tongtien", tongtien);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		vat = tongtien / 10;
		tongtien1 = tongtien - vat;
		

		request.setAttribute("vat",dao.Dinhdangtiente(vat));
		request.setAttribute("tongtien2",dao.Dinhdangtiente(tongtien));
		request.setAttribute("tongtien1",dao.Dinhdangtiente(tongtien1));
		RequestDispatcher rd = request.getRequestDispatcher("CartForward");
		rd.forward(request, response);
		}
		}
}

