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
import java.util.Random;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;


import com.mysql.cj.jdbc.Blob;

import BEAN.Phone;
import DB.DBConnection;
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class ThemDienThoaiDAO {
	private static Connection con =  DBConnection.CreateConnection();

	
	
	public static boolean InsertPhone(HttpServletRequest request,Connection conn,Phone phone)
	{
		PreparedStatement ptmt = null;
		try {
			String sql = "insert into phone(Name,Brand,Quantity,MoreDetail,Color,Memory,giatien,hinhanh,giatien1) values (?,?,?,?,?,?,?,?,?)";
		//	String idphone = phone.getIdphone();
			String name = phone.getName();
			String brand = phone.getBrand();
			int soluong = phone.getQuantity();
			String detail =  phone.getMoredetail();
			String color = phone.getColor();
			int memory = phone.getMemory();
			int giatien = phone.getGiatien();
			String giatien1 = Dinhdangtiente(giatien);
			
			ptmt = conn.prepareStatement(sql);

		//	ptmt.setString(1, idphone);
			ptmt.setString(1, name);
			ptmt.setString(2, brand);
			ptmt.setInt(3, soluong);
			ptmt.setString(4,detail );
			ptmt.setString(5, color );
			ptmt.setInt(6, memory);
			ptmt.setInt(7, giatien);
			ptmt.setBlob(8, phone.getInputStream());
			ptmt.setString(9,giatien1);
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
	
	public static List<Phone> getAll(Connection conn) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select idPhone,Name,Brand,Quantity,MoreDetail,Color,Memory,giatien,hinhanh,giatien1 from phone order by idPhone DESC";
        List<Phone> phone=new ArrayList<Phone>();
        ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(9);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
            Phone phone1 = new Phone();
            phone1.setIdphone(rs.getInt(1));
            phone1.setName(rs.getString(2));
            phone1.setBrand(rs.getString(3));
            phone1.setQuantity(rs.getInt(4));
            phone1.setMoredetail(rs.getString(5));
            phone1.setColor(rs.getString(6));
            phone1.setMemory(rs.getInt(7));
            phone1.setGiatien(rs.getInt(8));
            phone1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            phone1.setGiatien1(rs.getString(10));
            phone.add(phone1);
        }
        rs.close();
        ptmt.close();
        return phone;
    }
	
	
	public static List<Phone> getListByPage(List<Phone> arr,int start,int end) throws SQLException{
		List<Phone> list = new ArrayList<Phone>();
		for(int i = start ; i < end ; i++)
		{
			list.add(arr.get(i));
		}
		return list;
    }
	
	public static Phone getByID(int id) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select idPhone,Name,Brand,Quantity,MoreDetail,Color,Memory,giatien,hinhanh,giatien1 from phone where idPhone = "+id+"";
        Phone phone1=new Phone();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(9);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
          
            phone1.setIdphone(rs.getInt(1));
            phone1.setName(rs.getString(2));
            phone1.setBrand(rs.getString(3));
            phone1.setQuantity(rs.getInt(4));
            phone1.setMoredetail(rs.getString(5));
            phone1.setColor(rs.getString(6));
            phone1.setMemory(rs.getInt(7));
            phone1.setGiatien(rs.getInt(8));
            phone1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            phone1.setInputStream(inputStream);
            phone1.setGiatien1(rs.getString(10));

        }
        rs.close();
        ptmt.close();
        return phone1;
    }
	
	public void delete (String id,Connection conn) throws SQLException{
		PreparedStatement ptmt = null;
		String sql = "select Quantity from phone where idPhone = "+id+"";
		ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			int soluong = rs.getInt(1);
			rs.close();
		    ptmt.close();
		    ptmt = null;
			if( soluong == 1)
			{
				 
			     String sql1 = "delete from phone where idPhone = "+id+"";
			     ptmt = conn.prepareStatement(sql1);
			     ptmt.executeUpdate();
			}
			else {
				soluong = soluong - 1 ;
				
				String sql2 = "update phone set Quantity = "+soluong+" where idPhone = "+id+"";
				ptmt = conn.prepareStatement(sql2);
				ptmt.executeUpdate();
			}
		}
		else
		{
			
		}
		ptmt.close();
	}
	
	public static void Update (Phone phone, Connection conn) throws SQLException{
		try {
			if (phone.getHinhanh().equals("1"))
			{
				String sql2 = "update phone set Name = '"+phone.getName()+"' , Brand = '"+phone.getBrand()+"' , Quantity = "+phone.getQuantity()+""
						+ ", MoreDetail = '"+phone.getMoredetail()+"', Color = '"+phone.getColor()+"' , Memory = '"+phone.getMemory()+"',"
								+ " giatien = "+phone.getGiatien()+" ,giatien1='"+Dinhdangtiente(phone.getGiatien())+"'  where idPhone = "+phone.getIdphone()+"";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql2);
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
				String sql = "update phone set Name = ? , Brand = ? , Quantity = ?, MoreDetail = ?, Color = ? , Memory = ?, giatien = ?  , hinhanh = ?,giatien1=? where idPhone = "+phone.getIdphone()+"";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, phone.getName());
				ptmt.setString(2, phone.getBrand());
				ptmt.setInt(3, phone.getQuantity());
				ptmt.setString(4, phone.getMoredetail());
				ptmt.setString(5, phone.getColor());
				ptmt.setInt(6, phone.getMemory());
				ptmt.setInt(7, phone.getGiatien());
				ptmt.setBlob(8, phone.getInputStream());
				ptmt.setString(9,Dinhdangtiente(phone.getGiatien()));
				ptmt.executeUpdate();
				ptmt.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	public static List<Phone> getProductTop() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select idPhone,Name,Brand,Quantity,MoreDetail,Color,Memory,giatien,hinhanh,giatien1 from phone order by idPhone DESC LIMIT 4";
        List<Phone> phone=new ArrayList<Phone>();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(9);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
            Phone phone1 = new Phone();
            phone1.setIdphone(rs.getInt(1));
            phone1.setName(rs.getString(2));
            phone1.setBrand(rs.getString(3));
            phone1.setQuantity(rs.getInt(4));
            phone1.setMoredetail(rs.getString(5));
            phone1.setColor(rs.getString(6));
            phone1.setMemory(rs.getInt(7));
            phone1.setGiatien(rs.getInt(8));
            phone1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            phone1.setGiatien1(rs.getString(10));
            phone.add(phone1);
        }
        rs.close();
        ptmt.close();
        return phone;
    }
	
	public static List<Phone> getProductRandom() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select idPhone,Name,Brand,Quantity,MoreDetail,Color,Memory,giatien,hinhanh,giatien1 from phone ";
        List<Phone> phone=new ArrayList<Phone>();
        ptmt = con.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        	
        	blob = (Blob) rs.getBlob(9);
        	inputStream = blob.getBinaryStream();
        	outputStream = new ByteArrayOutputStream();
        	
        	try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				    outputStream.write(buffer, 0, bytesRead);                  
				}
			} catch (IOException e) {
				
			}
        	imageBytes = outputStream.toByteArray();
        	
            Phone phone1 = new Phone();
            phone1.setIdphone(rs.getInt(1));
            phone1.setName(rs.getString(2));
            phone1.setBrand(rs.getString(3));
            phone1.setQuantity(rs.getInt(4));
            phone1.setMoredetail(rs.getString(5));
            phone1.setColor(rs.getString(6));
            phone1.setMemory(rs.getInt(7));
            phone1.setGiatien(rs.getInt(8));
            phone1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            phone1.setGiatien1(rs.getString(10));
            phone.add(phone1);
        }

        Collections.shuffle(phone);

        rs.close();
        ptmt.close();
        return phone;
    }
	
	public static List<Phone> getProductSeller() throws SQLException{
		ArrayList<ArrayList<Integer>> biDemArrList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product1 = new ArrayList<ArrayList<Integer>>();

		int soluong = 0;
		
		PreparedStatement ptmt = null;
		String sql = "select chitietdonhang.madonhang,chitietdonhang.mamathang, chitietdonhang.soluong from donhang inner join chitietdonhang on chitietdonhang.madonhang = donhang.madonhang where tinhtrang = 'confirm' and mathang = 'phone' order by chitietdonhang.mamathang ";
        List<Phone> phone=new ArrayList<Phone>();
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
        	phone.add(getByID(product1.get(i).get(1)));
        }
        
        rs.close();
        ptmt.close();
        return phone;
    }
	
	
	public static String Dinhdangtiente(int giatien) {
		Locale locale = new Locale("vi","VN");
		NumberFormat format = NumberFormat.getCurrencyInstance(locale);
		format.setRoundingMode(RoundingMode.HALF_UP);
		
		return format.format(giatien);
	}
	
	
	
	
}
