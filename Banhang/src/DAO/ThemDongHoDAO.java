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
import BEAN.Phone;
import BEAN.Watch;
import DB.DBConnection;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)
public class ThemDongHoDAO {
	private static Connection con =  DBConnection.CreateConnection();

	
	public static boolean InsertWatch(HttpServletRequest request,Connection conn,Watch watch)
	{
		PreparedStatement ptmt = null;
		try {
			String sql = "insert into watch(name,manhinh,congnghemh,hedieuhanh,soluong,giatien,detail,brand,hinhanh,giatien1) values (?,?,?,?,?,?,?,?,?,?)";
	//		int  madongho = watch.getMadongho();
			String name = watch.getName();
			String manhinh = watch.getManhinh();
			String congnghemh = watch.getCongnghemh();
			String hedieuhanh = watch.getHedieuhanh();
			String detail = watch.getDetail();
			String brand = watch.getBrand();
			int soluong = watch.getSoluong();
			int giatien = watch.getGiatien();
			String giatien1 = Dinhdangtiente(giatien);
			
			
			ptmt = conn.prepareStatement(sql);

//			ptmt.setString(1,madongho);
			ptmt.setString(1,name);
			ptmt.setString(2,manhinh);
			ptmt.setString(3,congnghemh);
			ptmt.setString(4,hedieuhanh);
			ptmt.setInt(5,soluong);
			ptmt.setInt(6,giatien);
			ptmt.setString(7,detail);
			ptmt.setString(8, brand);
			ptmt.setBlob(9, watch.getInputStream());	
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
	
	public static Watch getByID(int id) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select madongho,name,manhinh,congnghemh,hedieuhanh,soluong,giatien,detail,brand,hinhanh,giatien1 from watch where madongho = "+id+"";
		Watch watch1=new Watch();
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
           	watch1.setMadongho(rs.getInt(1));	
        	watch1.setName(rs.getString(2));
        	watch1.setManhinh(rs.getString(3));
        	watch1.setCongnghemh(rs.getString(4));
        	watch1.setHedieuhanh(rs.getString(5));
        	watch1.setSoluong(rs.getInt(6));
        	watch1.setDetail(rs.getString(8));
            watch1.setGiatien(rs.getInt(7));
            watch1.setBrand(rs.getString(9));
            watch1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            watch1.setGiatien1(rs.getString(11));
        }
        rs.close();
        ptmt.close();
        return watch1;
    }

    
	public static List<Watch> getAll(Connection conn) throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select madongho,name,manhinh,congnghemh,hedieuhanh,soluong,giatien,detail,brand,hinhanh,giatien1 from watch order by madongho DESC";
		List<Watch> watch=new ArrayList<Watch>();
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
        	
        	Watch watch1 = new Watch();
        	watch1.setMadongho(rs.getInt(1));	
        	watch1.setName(rs.getString(2));
        	watch1.setManhinh(rs.getString(3));
        	watch1.setCongnghemh(rs.getString(4));
        	watch1.setHedieuhanh(rs.getString(5));
        	watch1.setSoluong(rs.getInt(6));
        	watch1.setDetail(rs.getString(8));
            watch1.setGiatien(rs.getInt(7));
            watch1.setBrand(rs.getString(9));
            watch1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            watch1.setGiatien1(rs.getString(11));
            watch.add(watch1);
        }
        rs.close();
        ptmt.close();
        return watch;
    }
	
	public static List<Watch> getProductRandom() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select madongho,name,manhinh,congnghemh,hedieuhanh,soluong,giatien,detail,brand,hinhanh,giatien1 from watch";
		List<Watch> watch=new ArrayList<Watch>();
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
        	
        	Watch watch1 = new Watch();
        	watch1.setMadongho(rs.getInt(1));	
        	watch1.setName(rs.getString(2));
        	watch1.setManhinh(rs.getString(3));
        	watch1.setCongnghemh(rs.getString(4));
        	watch1.setHedieuhanh(rs.getString(5));
        	watch1.setSoluong(rs.getInt(6));
        	watch1.setDetail(rs.getString(8));
            watch1.setGiatien(rs.getInt(7));
            watch1.setBrand(rs.getString(9));
            watch1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            watch1.setGiatien1(rs.getString(11));
            watch.add(watch1);
        }
        Collections.shuffle(watch);

        rs.close();
        ptmt.close();
        return watch;
    }
	
	public static List<Watch> getProductSeller() throws SQLException{
		ArrayList<ArrayList<Integer>> biDemArrList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> product1 = new ArrayList<ArrayList<Integer>>();

		int soluong = 0;
		
		PreparedStatement ptmt = null;
		String sql = "select chitietdonhang.madonhang,chitietdonhang.mamathang, chitietdonhang.soluong from donhang inner join chitietdonhang on chitietdonhang.madonhang = donhang.madonhang where tinhtrang = 'confirm' and mathang = 'dongho' order by chitietdonhang.mamathang ";
        List<Watch> watch=new ArrayList<Watch>();
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
        	watch.add(getByID(product1.get(i).get(1)));
        }
        
        rs.close();
        ptmt.close();
        return watch;
    }
	
	public static List<Watch> getListByPage(List<Watch> arr,int start,int end) throws SQLException{
		List<Watch> list = new ArrayList<Watch>();
		for(int i = start ; i < end ; i++)
		{
			list.add(arr.get(i));
		}
		return list;
    }
	
	
	
	
	public static List<Watch> getProductTop() throws SQLException{
		Blob blob = null;
		InputStream inputStream = null;
		 ByteArrayOutputStream outputStream = null;
		 byte[] buffer = new byte[4096];
		 int bytesRead = -1;
		 byte[] imageBytes;
		PreparedStatement ptmt = null;
		String sql = "select madongho,name,manhinh,congnghemh,hedieuhanh,soluong,giatien,detail,brand,hinhanh,giatien1 from watch order by madongho DESC LIMIT 4";
		List<Watch> watch=new ArrayList<Watch>();
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
        	
        	Watch watch1 = new Watch();
        	watch1.setMadongho(rs.getInt(1));	
        	watch1.setName(rs.getString(2));
        	watch1.setManhinh(rs.getString(3));
        	watch1.setCongnghemh(rs.getString(4));
        	watch1.setHedieuhanh(rs.getString(5));
        	watch1.setSoluong(rs.getInt(6));
        	watch1.setDetail(rs.getString(8));
            watch1.setGiatien(rs.getInt(7));
            watch1.setBrand(rs.getString(9));
            watch1.setHinhanh(Base64.getEncoder().encodeToString(imageBytes));
            watch1.setGiatien1(rs.getString(11));
            watch.add(watch1);
        }
        rs.close();
        ptmt.close();
        return watch;
    }
	
	
	public void delete (int id,Connection conn) throws SQLException{
		PreparedStatement ptmt = null;
		String sql = "select soluong from watch where madongho = "+id+"";
		ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		if(rs.next()) {
			int soluong = rs.getInt(1);
			rs.close();
		    ptmt.close();
		    ptmt = null;
			if( soluong == 1)
			{
				 
			     String sql1 = "delete from watch where madongho = "+id+"";
			     ptmt = conn.prepareStatement(sql1);
			     ptmt.executeUpdate();
			}
			else {
				soluong = soluong - 1 ;
				
				String sql2 = "update watch set soluong = "+soluong+" where madongho = "+id+"";
				ptmt = conn.prepareStatement(sql2);
				ptmt.executeUpdate();
			}
		}
		else
		{
			
		}
		ptmt.close();
	}
	
	public static void Update (Watch watch, Connection conn) throws SQLException{
		try {
			if (watch.getHinhanh().equals("1"))
			{
				String sql = "update watch set name = ? , manhinh = ? , congnghemh = ?, hedieuhanh = ?, soluong = ? ,  giatien = ?, detail = ?, brand = ? , giatien1 = ?  where madongho = '"+watch.getMadongho()+"'";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, watch.getName());
				ptmt.setString(2, watch.getManhinh());
				ptmt.setString(3, watch.getCongnghemh());
				ptmt.setString(4, watch.getHedieuhanh());
				ptmt.setInt(5, watch.getSoluong());
				ptmt.setInt(6, watch.getGiatien());
				ptmt.setString(7, watch.getDetail());
				ptmt.setString(8, watch.getBrand());
				ptmt.setString(9, Dinhdangtiente(watch.getGiatien()));


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
				String sql = "update watch set name = ? , manhinh = ? , congnghemh = ?, hedieuhanh = ?, soluong = ? ,  giatien = ?, detail = ?, brand = ?,hinhanh = ? , giatien1 = ?  where madongho = '"+watch.getMadongho()+"'";
				PreparedStatement ptmt = null;
				ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, watch.getName());
				ptmt.setString(2, watch.getManhinh());
				ptmt.setString(3, watch.getCongnghemh());
				ptmt.setString(4, watch.getHedieuhanh());
				ptmt.setInt(5, watch.getSoluong());
				ptmt.setInt(6, watch.getGiatien());
				ptmt.setString(7, watch.getDetail());
				ptmt.setString(8, watch.getBrand());
				ptmt.setBlob(9, watch.getInputStream());
				ptmt.setString(10, Dinhdangtiente(watch.getGiatien()));

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
