package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;


import com.mysql.cj.jdbc.Blob;


import DB.DBConnection;
import BEAN.Laptop;
import BEAN.Phone;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class ThemLaptopDAO {
	private static Connection con =  DBConnection.CreateConnection();

	public static boolean InsertLaptop(HttpServletRequest request,Connection conn,Laptop laptop)
	{
		
		PreparedStatement ptmt = null;
		try {
			String sql = "insert into laptop(name,Brand,ram,chipdohoa,phangiai,kichthuoc,Series,soluong,detail,giatien,hinhanh,giatien1) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			//String malaptop = laptop.getMalaptop();
			String name = laptop.getName();
			String brand = laptop.getBrand();
			int ram = laptop.getRam();
			String chipdohoa =  laptop.getChipdohoa();
			String phangiai = laptop.getPhangiai();
			String kichthuoc = laptop.getKichthuoc();
			String series = laptop.getSeries();
			int soluong = laptop.getSoluong();
			String detail = laptop.getDetail();
			int giatien = laptop.getGiatien();
			String giatien1 = Dinhdangtiente(giatien);
			
			ptmt = conn.prepareStatement(sql);

			//ptmt.setString(1, malaptop);
			ptmt.setString(1, name);
			ptmt.setString(2, brand);
			ptmt.setInt(3, ram);
			ptmt.setString(4,chipdohoa );
			ptmt.setString(5, phangiai );
			ptmt.setString(6,kichthuoc);
			ptmt.setString(7, series);
			ptmt.setInt(8,soluong);
			ptmt.setString(9,detail);
			ptmt.setInt(10,giatien);
			ptmt.setBlob(11, laptop.getInputStream());	
			ptmt.setString(12,giatien1);
			
			int kt = ptmt.executeUpdate();
			if(kt!= 0 )
			{
				return true;
			}	
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
	
	public static List<Laptop> getAll(Connection conn) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select malaptop,name,Brand,ram,chipdohoa,phangiai,kichthuoc,Series,soluong,detail,giatien,hinhanh,giatien1 from laptop";
        List<Laptop> laptop=new ArrayList<Laptop>();
        ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(12);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
            Laptop laptop1 = new Laptop();
            laptop1.setMalaptop(rs.getInt(1));	
            laptop1.setName(rs.getString(2));
            laptop1.setBrand(rs.getString(3));
            laptop1.setRam(rs.getInt(4));
            laptop1.setChipdohoa(rs.getString(5));
            laptop1.setPhangiai(rs.getString(6));
            laptop1.setKichthuoc(rs.getString(7));
            laptop1.setSeries(rs.getString(8));
            laptop1.setSoluong(rs.getInt(9));
            laptop1.setDetail(rs.getString(10));
            laptop1.setGiatien(rs.getInt(11));
            laptop1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            laptop1.setGiatien1(rs.getString(13));
            laptop.add(laptop1);
        }
        rs.close();
        ptmt.close();
        return laptop;
    }
	
	public static List<Laptop> getProductRandom() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select malaptop,name,Brand,ram,chipdohoa,phangiai,kichthuoc,Series,soluong,detail,giatien,hinhanh,giatien1 from laptop  order by malaptop DESC";
        List<Laptop> laptop=new ArrayList<Laptop>();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(12);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
            Laptop laptop1 = new Laptop();
            laptop1.setMalaptop(rs.getInt(1));	
            laptop1.setName(rs.getString(2));
            laptop1.setBrand(rs.getString(3));
            laptop1.setRam(rs.getInt(4));
            laptop1.setChipdohoa(rs.getString(5));
            laptop1.setPhangiai(rs.getString(6));
            laptop1.setKichthuoc(rs.getString(7));
            laptop1.setSeries(rs.getString(8));
            laptop1.setSoluong(rs.getInt(9));
            laptop1.setDetail(rs.getString(10));
            laptop1.setGiatien(rs.getInt(11));
            laptop1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            laptop1.setGiatien1(rs.getString(13));
            laptop.add(laptop1);
        }
        Collections.shuffle(laptop);

        rs.close();
        ptmt.close();
        return laptop;
    }
	
	public static List<Laptop> getListByPage(List<Laptop> arr,int start,int end) throws SQLException{
		List<Laptop> list = new ArrayList<Laptop>();
		for(int i = start ; i < end ; i++)
		{
			list.add(arr.get(i));
		}
		return list;
    }
	
	
	public static List<Laptop> getProductTop() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select malaptop,name,Brand,ram,chipdohoa,phangiai,kichthuoc,Series,soluong,detail,giatien,hinhanh,giatien1 from laptop order by malaptop DESC LIMIT 4";
        List<Laptop> laptop=new ArrayList<Laptop>();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(12);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
            Laptop laptop1 = new Laptop();
            laptop1.setMalaptop(rs.getInt(1));	
            laptop1.setName(rs.getString(2));
            laptop1.setBrand(rs.getString(3));
            laptop1.setRam(rs.getInt(4));
            laptop1.setChipdohoa(rs.getString(5));
            laptop1.setPhangiai(rs.getString(6));
            laptop1.setKichthuoc(rs.getString(7));
            laptop1.setSeries(rs.getString(8));
            laptop1.setSoluong(rs.getInt(9));
            laptop1.setDetail(rs.getString(10));
            laptop1.setGiatien(rs.getInt(11));
            laptop1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            laptop1.setGiatien1(rs.getString(13));
            laptop.add(laptop1);
        }
        rs.close();
        ptmt.close();
        return laptop;
    }
	
	
	public static Laptop getByID(int id) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select malaptop,name,Brand,ram,chipdohoa,phangiai,kichthuoc,Series,soluong,detail,giatien,hinhanh,giatien1 from laptop where malaptop = "+id+"";
        Laptop laptop1=new Laptop();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(12);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
          
        	 laptop1.setMalaptop(rs.getInt(1));	
             laptop1.setName(rs.getString(2));
             laptop1.setBrand(rs.getString(3));
             laptop1.setRam(rs.getInt(4));
             laptop1.setChipdohoa(rs.getString(5));
             laptop1.setPhangiai(rs.getString(6));
             laptop1.setKichthuoc(rs.getString(7));
             laptop1.setSeries(rs.getString(8));
             laptop1.setSoluong(rs.getInt(9));
             laptop1.setDetail(rs.getString(10));
             laptop1.setGiatien(rs.getInt(11));
             laptop1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
             laptop1.setGiatien1(rs.getString(13));

        }
        rs.close();
        ptmt.close();
        return laptop1;
    }
	
	public void delete (String id,Connection conn) throws SQLException{
		PreparedStatement ptmt = null;
		String sql = "select soluong from laptop where malaptop = "+id+"";
		ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			int soluong = rs.getInt(1);
			rs.close();
		    ptmt.close();
		    ptmt = null;
			if( soluong == 1)
			{
				 
			     String sql1 = "delete from laptop where malaptop = "+id+"";
			     ptmt = conn.prepareStatement(sql1);
			     ptmt.executeUpdate();
			}
			else {
				soluong = soluong - 1 ;
				
				String sql2 = "update laptop set soluong = "+soluong+" where malaptop = "+id+"";
				ptmt = conn.prepareStatement(sql2);
				ptmt.executeUpdate();
			}
		}
		else
		{
			
		}
		ptmt.close();
	}
	
	public static List<Laptop> getProductSeller() throws SQLException{
		ArrayList<ArrayList<Integer>> biDemArrList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product1 = new ArrayList<ArrayList<Integer>>();

		int soluong = 0;
		
		PreparedStatement ptmt = null;
		String sql = "select chitietdonhang.madonhang,chitietdonhang.mamathang, chitietdonhang.soluong from donhang inner join chitietdonhang on chitietdonhang.madonhang = donhang.madonhang where tinhtrang = 'confirm' and mathang = 'laptop' order by chitietdonhang.mamathang ";
        List<Laptop> laptop=new ArrayList<Laptop>();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		temp.add(rs.getInt(1));
    		temp.add(rs.getInt(2));
    		temp.add(rs.getInt(3));
    		
    		biDemArrList.add(temp);
        }
        
        for(int i = 0 ; i < biDemArrList.size(); i++)
        {   
           // ArrayList<Integer> a = biDemArrList.get(i);
        	soluong = soluong + biDemArrList.get(i).get(2);
        	if((i+1) < biDemArrList.size())
        	{
        	//	ArrayList<Integer> b = biDemArrList.get(i+1);
        	 	if( biDemArrList.get(i).get(1) != biDemArrList.get(i+1).get(1)  )
            	{
        	 		ArrayList<Integer> temp = new ArrayList<Integer>();
        	 		temp.add(biDemArrList.get(i).get(0));
        	 		temp.add(biDemArrList.get(i).get(1));
        	 		temp.add(soluong);
        	 		soluong = 0;
        	 		product.add(temp);
            	}
        	}
       
        }
        
        
        
        int max = 0,k = 0 ;
        for(int i = 0 ; i < 3 ; i++)
        {
        	for(int j = 0 ; j < product.size();j++)
        	{
        		if( max < product.get(j).get(2))
        		{
        			k = j;
        			max = product.get(j).get(2);
        		}
        	}
        	product1.add(product.get(k));
        	product.remove(k);
        	k = 0;
        	
        }
        for(int i = 0 ; i < product1.size();i++)
        {
        	laptop.add(getByID(product1.get(i).get(1)));
        }
        
        rs.close();
        ptmt.close();
        return laptop;
    }
	
	public static void Update (Laptop laptop, Connection conn) throws SQLException{
		try {
			if (laptop.getHinhanh().equals("1"))
			{
				String sql = "update laptop set name = ? , Brand = ? , ram = ?, chipdohoa = ?, phangiai = ? , kichthuoc = ?, Series = ?  , soluong = ?, detail = ?, giatien = ?, giatien1 = ?  where malaptop = "+laptop.getMalaptop()+"";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, laptop.getName());
				ptmt.setString(2, laptop.getBrand());
				ptmt.setInt(3, laptop.getRam());
				ptmt.setString(4, laptop.getChipdohoa());
				ptmt.setString(5, laptop.getPhangiai());
				ptmt.setString(6, laptop.getKichthuoc());
				ptmt.setString(7, laptop.getSeries());
				ptmt.setInt(8, laptop.getSoluong());
				ptmt.setString(9, laptop.getDetail());
				ptmt.setInt(10, laptop.getGiatien());
				ptmt.setString(11, Dinhdangtiente(laptop.getGiatien()));
		//		ptmt.setBlob(11, laptop.getInputStream());
				ptmt.executeUpdate();
				ptmt.close();
			}
			else {
			/*	String sql2 = "update phone set Name = '"+phone.getName()+"' , Brand = '"+phone.getBrand()+"' , Quantity = "+phone.getQuantity()+""
						+ ", MoreDetail = '"+phone.getMoredetail()+"', Color = '"+phone.getColor()+"' , Memory = '"+phone.getMemory()+"',"
								+ " giatien = "+phone.getGiatien()+"  , hinhanh = '"+phone.getInputStream()+"' where idPhone = '"+phone.getIdphone()+"'";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql2);
				ptmt.executeUpdate();
				ptmt.close();
				*/
				String sql = "update laptop set name = ? , Brand = ? , ram = ?, chipdohoa = ?, phangiai = ? , kichthuoc = ?, Series = ?  , soluong = ?, detail = ?, giatien = ?,hinhanh = ? , giatien1 = ?  where malaptop = "+laptop.getMalaptop()+"";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, laptop.getName());
				ptmt.setString(2, laptop.getBrand());
				ptmt.setInt(3, laptop.getRam());
				ptmt.setString(4, laptop.getChipdohoa());
				ptmt.setString(5, laptop.getPhangiai());
				ptmt.setString(6, laptop.getKichthuoc());
				ptmt.setString(7, laptop.getSeries());
				ptmt.setInt(8, laptop.getSoluong());
				ptmt.setString(9, laptop.getDetail());
				ptmt.setInt(10, laptop.getGiatien());
				ptmt.setBlob(11, laptop.getInputStream());
				ptmt.setString(12, Dinhdangtiente(laptop.getGiatien()));
				ptmt.executeUpdate();
				ptmt.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	public static String Dinhdangtiente(int giatien) {
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		format.setRoundingMode(RoundingMode.HALF_UP);
		
		return format.format(giatien);
	}
	
	
}
