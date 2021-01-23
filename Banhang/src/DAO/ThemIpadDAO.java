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

import BEAN.Ipad;
import BEAN.Laptop;
import BEAN.Phone;
import DB.DBConnection;


@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class ThemIpadDAO {
	private static Connection con =  DBConnection.CreateConnection();

	public static boolean InsertIpad(HttpServletRequest request,Connection conn,Ipad ipad)
	{
		PreparedStatement ptmt = null;
		try {
			String sql = "insert into Ipad(ten,brand,dungluong,hedieuhanh,ram,soluong,detail,giatien,hinhanh,giatien1) values (?,?,?,?,?,?,?,?,?,?)";
		//	String malaptop = ipad.getMaipad();
			String name     = ipad.getName();
			String brand    = ipad.getBrand();
			String dungluong = ipad.getDungluong();
			String hedieuhanh = ipad.getHedieuhanh();
			int ram = ipad.getRam();
			int soluong = ipad.getSoluong();
			String detail = ipad.getDetail();
			int giatien = ipad.getGiatien();
			String giatien1 = Dinhdangtiente(giatien);
			
			ptmt = conn.prepareStatement(sql);

		//	ptmt.setString(1, malaptop);
			ptmt.setString(1, name);
			ptmt.setString(2, brand);
			ptmt.setString(3, dungluong);
			ptmt.setString(4,hedieuhanh);
			ptmt.setInt(5, ram);
			ptmt.setInt(6,soluong);
			ptmt.setString(7,detail);
			ptmt.setInt(8,giatien);
			ptmt.setBlob(9, ipad.getInputStream());	
			ptmt.setString(10,giatien1);

			
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
	
	
	public static Ipad getByID(int id) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select maipad,ten,brand,dungluong,hedieuhanh,ram,soluong,detail,giatien,hinhanh,giatien1 from ipad where maipad = "+id+"";
        Ipad ipad1=new Ipad();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(10);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
          
        	ipad1.setMaipad(rs.getInt(1));	
            ipad1.setName(rs.getString(2));
            ipad1.setBrand(rs.getString(3));
            ipad1.setDungluong(rs.getString(4));
            ipad1.setHedieuhanh(rs.getString(5));
            ipad1.setRam(rs.getInt(6));
            ipad1.setSoluong(rs.getInt(7));
            ipad1.setDetail(rs.getString(8));
            ipad1.setGiatien(rs.getInt(9));
            ipad1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            ipad1.setGiatien1(rs.getString(11));
         
        }
        rs.close();
        ptmt.close();
        return ipad1;
    }

    
	public static List<Ipad> getAll(Connection conn) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select maipad,ten,brand,dungluong,hedieuhanh,ram,soluong,detail,giatien,hinhanh,giatien1 from ipad order by maipad DESC";
		List<Ipad> ipad=new ArrayList<Ipad>();
        ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(10);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
        	Ipad ipad1 = new Ipad();
        	ipad1.setMaipad(rs.getInt(1));	
            ipad1.setName(rs.getString(2));
            ipad1.setBrand(rs.getString(3));
            ipad1.setDungluong(rs.getString(4));
            ipad1.setHedieuhanh(rs.getString(5));
            ipad1.setRam(rs.getInt(6));
            ipad1.setSoluong(rs.getInt(7));
            ipad1.setDetail(rs.getString(8));
            ipad1.setGiatien(rs.getInt(9));
            ipad1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            ipad1.setGiatien1(rs.getString(11));
            ipad.add(ipad1);
        }
        rs.close();
        ptmt.close();
        return ipad;
    }
	
	public static List<Ipad> getProductRandom() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select maipad,ten,brand,dungluong,hedieuhanh,ram,soluong,detail,giatien,hinhanh,giatien1 from ipad";
		List<Ipad> ipad=new ArrayList<Ipad>();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(10);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
        	Ipad ipad1 = new Ipad();
        	ipad1.setMaipad(rs.getInt(1));	
            ipad1.setName(rs.getString(2));
            ipad1.setBrand(rs.getString(3));
            ipad1.setDungluong(rs.getString(4));
            ipad1.setHedieuhanh(rs.getString(5));
            ipad1.setRam(rs.getInt(6));
            ipad1.setSoluong(rs.getInt(7));
            ipad1.setDetail(rs.getString(8));
            ipad1.setGiatien(rs.getInt(9));
            ipad1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            ipad1.setGiatien1(rs.getString(11));
            ipad.add(ipad1);
        }
        Collections.shuffle(ipad);

        rs.close();
        ptmt.close();
        return ipad;
    }
	
	public static List<Ipad> getProductSeller() throws SQLException{
		ArrayList<ArrayList<Integer>> biDemArrList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product1 = new ArrayList<ArrayList<Integer>>();

		int soluong = 0;
		
		PreparedStatement ptmt = null;
		String sql = "select chitietdonhang.madonhang,chitietdonhang.mamathang, chitietdonhang.soluong from donhang inner join chitietdonhang on chitietdonhang.madonhang = donhang.madonhang where tinhtrang = 'confirm' and mathang = 'ipad' order by chitietdonhang.mamathang ";
        List<Ipad> ipad=new ArrayList<Ipad>();
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
        	ipad.add(getByID(product1.get(i).get(1)));
        }
        
        rs.close();
        ptmt.close();
        return ipad;
    }
	
	public static List<Ipad> getListByPage(List<Ipad> arr,int start,int end) throws SQLException{
		List<Ipad> list = new ArrayList<Ipad>();
		for(int i = start ; i < end ; i++)
		{
			list.add(arr.get(i));
		}
		return list;
    }
	
	
	public static List<Ipad> getProductTop() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select maipad,ten,brand,dungluong,hedieuhanh,ram,soluong,detail,giatien,hinhanh,giatien1 from ipad order by maipad DESC LIMIT 4";
		List<Ipad> ipad=new ArrayList<Ipad>();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(10);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
        	Ipad ipad1 = new Ipad();
        	ipad1.setMaipad(rs.getInt(1));	
            ipad1.setName(rs.getString(2));
            ipad1.setBrand(rs.getString(3));
            ipad1.setDungluong(rs.getString(4));
            ipad1.setHedieuhanh(rs.getString(5));
            ipad1.setRam(rs.getInt(6));
            ipad1.setSoluong(rs.getInt(7));
            ipad1.setDetail(rs.getString(8));
            ipad1.setGiatien(rs.getInt(9));
            ipad1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            ipad1.setGiatien1(rs.getString(11));
            ipad.add(ipad1);
        }
        rs.close();
        ptmt.close();
        return ipad;
    }
	
	public void delete (int id,Connection conn) throws SQLException{
		PreparedStatement ptmt = null;
		String sql = "select soluong from ipad where maipad = "+id+"";
		ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			int soluong = rs.getInt(1);
			rs.close();
		    ptmt.close();
		    ptmt = null;
			if( soluong == 1)
			{
				 
			     String sql1 = "delete from ipad where maipad = "+id+"";
			     ptmt = conn.prepareStatement(sql1);
			     ptmt.executeUpdate();
			}
			else {
				soluong = soluong - 1 ;
				
				String sql2 = "update ipad set soluong = "+soluong+" where maipad = "+id+"";
				ptmt = conn.prepareStatement(sql2);
				ptmt.executeUpdate();
			}
		}
		else
		{
			
		}
		ptmt.close();
	}
	
	
	public static void Update (Ipad ipad, Connection conn) throws SQLException{
		try {
			if (ipad.getHinhanh().equals("1"))
			{
				String sql = "update ipad set ten = ? , brand = ? , dungluong = ?, hedieuhanh = ?, ram = ? ,  soluong = ?, detail = ?, giatien = ? , giatien1 = ?  where maipad = "+ipad.getMaipad()+"";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, ipad.getName());
				ptmt.setString(2, ipad.getBrand());
				ptmt.setString(3, ipad.getDungluong());
				ptmt.setString(4, ipad.getHedieuhanh());
				ptmt.setInt(5, ipad.getRam());
				ptmt.setInt(6, ipad.getSoluong());
				ptmt.setString(7, ipad.getDetail());
				ptmt.setInt(8, ipad.getGiatien());
		//		ptmt.setBlob(11, laptop.getInputStream());
				ptmt.setString(9,Dinhdangtiente(ipad.getGiatien()));
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
				String sql = "update ipad set ten = ? , brand = ? , dungluong = ?, hedieuhanh = ?, ram = ? ,  soluong = ?, detail = ?, giatien = ?,hinhanh = ?,giatien1 = ?  where maipad = "+ipad.getMaipad()+"";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql);
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, ipad.getName());
				ptmt.setString(2, ipad.getBrand());
				ptmt.setString(3, ipad.getDungluong());
				ptmt.setString(4, ipad.getHedieuhanh());
				ptmt.setInt(5, ipad.getRam());
				ptmt.setInt(6, ipad.getSoluong());
				ptmt.setString(7, ipad.getDetail());
				ptmt.setInt(8, ipad.getGiatien());
				ptmt.setBlob(9, ipad.getInputStream());
				ptmt.setString(10,Dinhdangtiente(ipad.getGiatien()));

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
