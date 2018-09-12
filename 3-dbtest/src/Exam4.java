import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class UpdateTest {
	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {}
	}
	
	public Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jspexam";
		String password = "m1234";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {}
		
		return connection;
	}
	
	public void updateArticle() {
		Connection connection = getConnection();
		PreparedStatement ps = null;
		String sql = "update dbtest set age = age + 1 where name like 'ȫ%'";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e) {}
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {}
		}
	}
}
public class Exam4 {
	public static void main(String[] args) {
		UpdateTest updateTest = new UpdateTest();
		updateTest.updateArticle();
	}
}
