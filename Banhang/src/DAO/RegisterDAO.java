package DAO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mysql.cj.jdbc.Blob;

import BEAN.Phone;
import BEAN.Users;
import DB.DBConnection;


public class RegisterDAO {
	public static boolean InsertAccount(HttpServletRequest request,Connection conn,Users users) {
		PreparedStatement ptmt = null;
		
		
	
		try {
			String sql = "insert into users(Username,Password,Name,Email,Phone,Categoryid) values (?,?,?,?,?,?)";
			String username = users.getUsername();
			String pass     = users.getPassword();
			String name     = users.getName();
			String email    = users.getEmail();
			int    phone    = users.getPhone();
			int    categoryid = 1;
			
		
			ptmt = conn.prepareStatement(sql);
			
			
			
			ptmt.setString(1, username);
			ptmt.setString(2, pass);
			ptmt.setString(3, name);
			ptmt.setString(4,email);
			ptmt.setInt(5, phone);
			ptmt.setInt(6,categoryid);
			
			
			int kt = ptmt.executeUpdate();
			if(kt!= 0 )
			{
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			
			request.setAttribute("mess", e.getMessage());
			
		}
		return false;
		
	}
	
	public static List<Users> getAll(Connection conn) throws SQLException{
		PreparedStatement ptmt = null;
		String sql = "select idusers,username,password,name,email,phone,categoryid from users";
        List<Users> users=new ArrayList<Users>();
        ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        		
            Users users1 = new Users();
            users1.setIdusers(rs.getInt(1));
            users1.setUsername(rs.getString(2));
            users1.setPassword(rs.getString(3));
            users1.setName(rs.getString(4));
            users1.setEmail(rs.getString(5));
            users1.setPhone(rs.getInt(6));
            users1.setCategoryid(rs.getInt(7));
            users.add(users1);
        }
        rs.close();
        ptmt.close();
        return users;
    }
	
	public static Users getUserById(Connection conn,String username) throws SQLException{
		PreparedStatement ptmt = null;
		String sql = "select idusers,username,password,name,email,phone,categoryid from users where username ='"+username+"'";
        Users users=new Users();
        ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
        		
            users.setIdusers(rs.getInt(1));
            users.setUsername(rs.getString(2));
            users.setPassword(rs.getString(3));
            users.setName(rs.getString(4));
            users.setEmail(rs.getString(5));
            users.setPhone(rs.getInt(6));
            users.setCategoryid(rs.getInt(7));
           
        }
        rs.close();
        ptmt.close();
        return users;
    }
	
	public void delete(int id,Connection conn) throws SQLException{
		PreparedStatement ptmt = null;
		String sql1 = "delete from users where idusers = "+id+"";
	     ptmt = conn.prepareStatement(sql1);
	     ptmt.executeUpdate();
		ptmt.close();
	}
}
