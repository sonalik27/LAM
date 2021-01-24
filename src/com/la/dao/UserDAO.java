package com.la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.la.model.User;

public class UserDAO {
	
	public int authenticate(String userName, String password) {
		
		int userId = 0;
		Connection conn = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/academy", "root", "admin");
			
			String sql = "select user_id from user where login_name = ? and password = ? and user_type_id = 1";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            
            
            ResultSet result = stmt.executeQuery();
            
            if(result!=null && result.next()) {
            	userId = result.getInt(1);
            }
                       
            
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(conn != null) {
					try {
					conn.close();
					}catch(SQLException e) {
						System.out.println("Exception closing the connection");
								////////////add support for logging
					}
				}
			}
			
			
		
		return userId;
	}

}
