package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SchoolDAO {
	
	public SchoolDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jspexam";
		String password = "m1234";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {}
		
		return conn;
	}
	
	public int insertArticle(String name, String value, int code) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String sql = "insert into school values(?, ?, ?)";
		int su = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, value);
			ps.setInt(3, code);
			su = ps.executeUpdate();
		} catch (SQLException e) {
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {}
		}
		
		return su;
	}
	
	public void selectArticleByName(String name) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from school where name = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name1 = rs.getString("name");
				String value = rs.getString("value");
				int code = rs.getInt("code");
				
				System.out.println(name1 + "\t" + value + "\t" + code + "\t");
			}
		} catch (SQLException e) {
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {}
		}
	}
	
	public void selectArticle() {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from school";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String value = rs.getString("value");
				int code = rs.getInt("code");
				
				System.out.println(name + "\t" + value + "\t" + code + "\t");
			}
		} catch (SQLException e) {
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {}
		}
	}
	
	public int deleteArticle(String name) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		String sql = "delete school where name = ?";
		int su = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			su = ps.executeUpdate();
		} catch (SQLException e) {
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {}
		}
		
		return su;
	}
}
