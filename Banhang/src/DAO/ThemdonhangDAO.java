package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.jdbc.Blob;

import BEAN.Chitietdonhang;
import BEAN.Donhang;
import BEAN.Order;
import BEAN.Phone;
import BEAN.Users;
import BEAN.Watch;
import DB.DBConnection;

public class ThemdonhangDAO {
	private static Connection conn =  DBConnection.CreateConnection();

	public static boolean Themdonhang(Order orders,Users users,int tongtien) {
		PreparedStatement ptmt = null;

		try {
			String sql = "insert into donhang(tenkhachhang,sodienthoai,diachi,email,tongtien,tinhtrang) values (?,?,?,?,?,?)";
			String name = users.getName();
			int sodienthoai = users.getPhone();
			String diachi     = users.getDiachi();
			String email    = users.getEmail();
			int    phone    = users.getPhone();
			int count = 0 ;
		
			ptmt = conn.prepareStatement(sql);
			
			
			
			ptmt.setString(1, name);
			ptmt.setInt(2, sodienthoai);
			ptmt.setString(3, diachi);
			ptmt.setString(4,email);
			ptmt.setInt(5, tongtien);
			ptmt.setString(6,"notconfirm");
			
			
			int kt = ptmt.executeUpdate();
			if(kt!= 0 )
			{
				ptmt.close();
				count = orders.getItems().size() - 1;
				sql = "select madonhang from donhang order by madonhang DESC LIMIT 1";
				ptmt = conn.prepareStatement(sql);
		        ResultSet rs = ptmt.executeQuery();
		        rs.next();
		        int madonhang = Integer.parseInt(rs.getString("madonhang"));
		        rs.close();
		        	//int madonhang = Integer.parseInt(rs.getString("madonhang"));
		        	for (int i = 0 ; i <= count ; i++)
					{
		        		
						if(orders.getItems().get(i).getPhone() != null)
						{
							sql = "insert into chitietdonhang(madonhang,mathang,mamathang,soluong,tongtien) values (?,?,?,?,?)";
							//int madonhang = Integer.parseInt(rs.getString("madonhang"));
							String mathang = "phone";
							int mamathang = orders.getItems().get(i).getPhone().getIdphone();
							int soluong = orders.getItems().get(i).getSoluong();
							int tongtien1 = orders.getItems().get(i).getPhone().getGiatien() * orders.getItems().get(i).getPhone().getQuantity(); 
						//	rs.close();
							ptmt.close();
							ptmt = conn.prepareStatement(sql);
							ptmt.setInt(1, madonhang);
							ptmt.setString(2, mathang);
							ptmt.setInt(3, mamathang);
							ptmt.setInt(4, soluong);
							ptmt.setInt(5, tongtien1);
							int kt1 = ptmt.executeUpdate();
							if(kt1 == 0)
							{
								return false;
							}
							ptmt.close();
							
						} else if(orders.getItems().get(i).getLaptop() != null)
						{
							sql = "insert into chitietdonhang(madonhang,mathang,mamathang,soluong,tongtien) values (?,?,?,?,?)";
						//	int madonhang = Integer.parseInt(rs.getString("madonhang"));
							String mathang = "laptop";
							int mamathang = orders.getItems().get(i).getLaptop().getMalaptop();
							int soluong = orders.getItems().get(i).getSoluong();
							int giatien = orders.getItems().get(i).getLaptop().getGiatien();
							int tongtien1 = orders.getItems().get(i).getLaptop().getGiatien() * soluong; 
						//	rs.close();
							ptmt.close();
							ptmt = conn.prepareStatement(sql);
							ptmt.setInt(1, madonhang);
							ptmt.setString(2, mathang);
							ptmt.setInt(3, mamathang);
							ptmt.setInt(4, soluong);
							ptmt.setInt(5, tongtien1);
							int kt1 = ptmt.executeUpdate();
							if(kt1 == 0)
							{
								return false;
							}
							ptmt.close();
							
						}
						 else if(orders.getItems().get(i).getIpad() != null)
							{
								sql = "insert into chitietdonhang(madonhang,mathang,mamathang,soluong,tongtien) values (?,?,?,?,?)";
					//	    	int madonhang = Integer.parseInt(rs.getString("madonhang"));
								String mathang = "ipad";
								int mamathang = orders.getItems().get(i).getIpad().getMaipad();
								int soluong = orders.getItems().get(i).getSoluong();
								int tongtien1 = orders.getItems().get(i).getIpad().getGiatien() * orders.getItems().get(i).getIpad().getSoluong(); 
						//		rs.close();
								ptmt.close();
								ptmt = conn.prepareStatement(sql);
								ptmt.setInt(1, madonhang);
								ptmt.setString(2, mathang);
								ptmt.setInt(3, mamathang);
								ptmt.setInt(4, soluong);
								ptmt.setInt(5, tongtien1);
								int kt1 = ptmt.executeUpdate();
								if(kt1 == 0)
								{
									return false;
								}
								ptmt.close();
								
							}
						 else if(orders.getItems().get(i).getWatch() != null)
							{
								sql = "insert into chitietdonhang(madonhang,mathang,mamathang,soluong,tongtien) values (?,?,?,?,?)";
						//		int madonhang = Integer.parseInt(rs.getString("madonhang"));
								String mathang = "dongho";
								int mamathang = orders.getItems().get(i).getWatch().getMadongho();
								int soluong = orders.getItems().get(i).getSoluong();
								int tongtien1 = orders.getItems().get(i).getWatch().getGiatien() * orders.getItems().get(i).getWatch().getSoluong(); 
					//			rs.close();
								ptmt.close();
								ptmt = conn.prepareStatement(sql);
								ptmt.setInt(1, madonhang);
								ptmt.setString(2, mathang);
								ptmt.setInt(3, mamathang);
								ptmt.setInt(4, soluong);
								ptmt.setInt(5, tongtien1);
								int kt1 = ptmt.executeUpdate();
								if(kt1 == 0)
								{
									return false;
								}
								ptmt.close();
								
							}
						
					}
		        
		        
				
				return true;
				
			}
			else {
				return false;
				
			}
			
		} catch (Exception e) {
			
			
			
		}
		return true;
		
	}
	
	
	public static List<Donhang> getAll(Connection conn) throws SQLException{
		PreparedStatement ptmt = null;

		String sql = "select madonhang,tenkhachhang,sodienthoai,diachi,email,tongtien,tinhtrang from donhang order by madonhang DESC";
        List<Donhang> donhang= new ArrayList<Donhang>();
        ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
     
            Donhang donhang1 = new Donhang();
            donhang1.setMadonhang(rs.getInt(1));
            donhang1.setTenkhachhang(rs.getString(2));
            donhang1.setSodienthoai(rs.getInt(3));
            donhang1.setDiachi(rs.getString(4));
            donhang1.setEmail(rs.getString(5));
            donhang1.setTongtien(rs.getInt(6));
            donhang1.setTinhtrang(rs.getString(7));
            donhang.add(donhang1);
        }
        rs.close();
        ptmt.close();
        return donhang;
    }
	
	public static List<Chitietdonhang> getAllChitietdonghang(Connection conn, int madonhang) throws SQLException{
		PreparedStatement ptmt = null;

		String sql = "select machitietdonhang,madonhang,mathang,mamathang,soluong,tongtien from chitietdonhang where madonhang = " + madonhang;
        List<Chitietdonhang> chitietdonhang= new ArrayList<Chitietdonhang>();
        ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
     
        	Chitietdonhang chitietdonhang1 = new Chitietdonhang();
        	chitietdonhang1.setMachitietdonhang(rs.getInt(1));
        	chitietdonhang1.setMadonhang(rs.getInt(2));
        	chitietdonhang1.setMathang(rs.getString(3));
        	chitietdonhang1.setMamathang(rs.getInt(4));
        	chitietdonhang1.setSoluong(rs.getInt(5));
        	chitietdonhang1.setTongtien(rs.getInt(6));
        	chitietdonhang.add(chitietdonhang1);
        }
        rs.close();
        ptmt.close();
        return chitietdonhang;
    }
	
	public void delete(int id,Connection conn) throws SQLException{
		PreparedStatement ptmt = null;
		
		String sql = "delete from donhang where madonhang = "+id+"";
		ptmt = conn.prepareStatement(sql);
		ptmt.executeUpdate();
		ptmt.close();
		String sql1 = "delete from chitietdonhang where madonhang = "+id+"";
		ptmt = conn.prepareStatement(sql1);
		ptmt.executeUpdate();
		ptmt.close();
	}
	
	
	public static void Update (int id, Connection conn) throws SQLException{
		
				int kt = 0;
				PreparedStatement ptmt = null;
				String sql;
				
				
				List<Chitietdonhang> list = getAllChitietdonghang(conn, id);
				for(Chitietdonhang chitietdonghang:list)
				{
					if(chitietdonghang.getMathang().equals("phone"))
					{
						if(ThemDienThoaiDAO.getByID(chitietdonghang.getMamathang()).getQuantity() >= chitietdonghang.getSoluong())
						{
							int soluong = ThemDienThoaiDAO.getByID(chitietdonghang.getMamathang()).getQuantity() - chitietdonghang.getSoluong();
							if(soluong>=0)
							{
								sql = "update phone set Quantity = "+soluong+" where idPhone = "+chitietdonghang.getMamathang()+"";
								ptmt = conn.prepareStatement(sql);
								kt = ptmt.executeUpdate();
								ptmt.close();
								
							}
						}
					}
					else if(chitietdonghang.getMathang().equals("laptop"))
					{
						if(ThemLaptopDAO.getByID(chitietdonghang.getMamathang()).getSoluong() >= chitietdonghang.getSoluong())
						{
							int soluong = ThemLaptopDAO.getByID(chitietdonghang.getMamathang()).getSoluong() - chitietdonghang.getSoluong();
							if(soluong>=0)
							{
								sql = "update laptop set soluong = "+soluong+" where malaptop = "+chitietdonghang.getMamathang()+"";
								ptmt = conn.prepareStatement(sql);
								kt = ptmt.executeUpdate();
								ptmt.close();
							}
						}
					}
					else if(chitietdonghang.getMathang().equals("ipad"))
					{
						if(ThemIpadDAO.getByID(chitietdonghang.getMamathang()).getSoluong() >= chitietdonghang.getSoluong())
						{
							int soluong = ThemIpadDAO.getByID(chitietdonghang.getMamathang()).getSoluong() - chitietdonghang.getSoluong();
							if(soluong>=0)
							{
								sql = "update ipad set soluong = "+soluong+" where maipad = "+chitietdonghang.getMamathang()+"";
								ptmt = conn.prepareStatement(sql);
								kt = ptmt.executeUpdate();
								ptmt.close();
							}
						}
					}
					else if(chitietdonghang.getMathang().equals("dongho"))
					{
						if(ThemDongHoDAO.getByID(chitietdonghang.getMamathang()).getSoluong() >= chitietdonghang.getSoluong())
						{
							int soluong = ThemDongHoDAO.getByID(chitietdonghang.getMamathang()).getSoluong() - chitietdonghang.getSoluong();
							if(soluong>=0)
							{
								sql = "update watch set soluong = "+soluong+" where madongho = "+chitietdonghang.getMamathang()+"";
								ptmt = conn.prepareStatement(sql);
								kt = ptmt.executeUpdate();
								ptmt.close();
							}
						}
					}
				}
				
				if(kt == 1)
				{
					sql = "update donhang set tinhtrang = ?  where madonhang = "+id+"";
					ptmt = conn.prepareStatement(sql);
					ptmt.setString(1, "confirm");
					ptmt.executeUpdate();
					ptmt.close();
						
				}
				
		
	}
}
