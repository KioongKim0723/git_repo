import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SelectTest {
	public SelectTest() {
		try {
			Class.forName("oracle.jdbc,driver.OracleDriver");
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
	
	public void selectArticle() {
		String sql = "select * from dbtest";
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
		    rs = ps.executeQuery();
			while(rs.next()) {
				int i = 1;
				String name = rs.getString(i++);
				int age = rs.getInt(i++);
				double height = rs.getDouble(i++);
				Date date = rs.getDate(i++);
				System.out.println(name + "\t" + age + "\t" + height + "\t" + date);
			}
		} catch (SQLException e) {
			
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			}catch (Exception e) {}
		}
	}
}
public class Exam3 {
	public static void main(String[] args) {
		SelectTest selectTest = new SelectTest();
		selectTest.selectArticle();
	}
}
