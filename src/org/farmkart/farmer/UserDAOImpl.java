package org.farmkart.farmer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.farmkart.util.ConnectionPool;
import org.farmkart.farmer.*;


public class UserDAOImpl {

	public static User isValidUser(String userId) {
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement preStmt;
		User u=null;
		try
		{
			preStmt = conn.prepareStatement("select * from user where userId=?");
			System.out.println(userId);
			preStmt.setString(1, userId);
			ResultSet result = preStmt.executeQuery();
			if (result.next())
			{
				u=new User();
				u.setUserId(userId);
				u.setName(result.getString("user_name"));
				u.setUserType(result.getString("user_type"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			ConnectionPool.freeConnection(conn);
		}
		
		return u;
	}

	public  static ArrayList<Category> getCategoryList() {
		
		Connection connection = ConnectionPool.getConnection();
		ArrayList<Category> al=new ArrayList<Category>();
		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from category_master");
			Category c=null;
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				c=new Category();
				c.setCategoryId(rs.getString("category_id"));
				c.setCategoryName(rs.getString("category_name"));
				al.add(c);
			}
			System.out.println("--------------->"+al.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.freeConnection(connection);
		}
		return al;
	}
public  static ArrayList<Category> getCropList() {
		
		Connection connection = ConnectionPool.getConnection();
		ArrayList<Category> al=new ArrayList<Category>();
		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from crop_master");
			Category c=null;
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				c=new Category();
				c.setCategoryId(rs.getString("crop_id"));
				c.setCategoryName(rs.getString("crop_name"));
				al.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.freeConnection(connection);
		}
		return al;
	}

}
