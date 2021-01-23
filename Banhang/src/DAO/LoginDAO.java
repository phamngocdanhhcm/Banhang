package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;


import BEAN.Users;

public class LoginDAO {
	public static boolean Authenticationmember(HttpServletRequest request,Connection conn,Users users) {
		
		PreparedStatement ptmt = null;
		String sql = "select * from users ";
		try {
			
			
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			
			while(rs.next()) {
				
				
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				if(username.equalsIgnoreCase(users.getUsername()) && password.equalsIgnoreCase( users.getPassword()))
				{
					return true;
				}
				
			}
			ptmt.close();
			rs.close();
			
			
		} catch (Exception e) {
			
		}
		return false;
		
	}
	
	public static int Authorizationmember(HttpServletRequest request,Connection conn,Users users) {
		int categoryid =0;
		PreparedStatement ptmt = null;
		String sql = "select * from users where username='"+users.getUsername()+"' AND password='"+users.getPassword()+"'";
		try {
			
			
			
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				categoryid = rs.getInt("categoryid");
				
				return categoryid;
			}
			
			
		} catch (Exception e) {
			
		}
		return categoryid;
		
	}
	
	public static String Exportnameuser(HttpServletRequest request,Connection conn,Users users)
	{
		String nameuser = null;
		PreparedStatement ptmt = null;
		String sql = "select * from users where username='"+users.getUsername()+"' AND password='"+users.getPassword()+"'";
		try {
			
			
			
			ptmt = conn.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next()) {
				
				nameuser = rs.getString("name");
				
				return nameuser;
			}
			
			
		} catch (Exception e) {
			
		}
		return nameuser;
	}
	
}
