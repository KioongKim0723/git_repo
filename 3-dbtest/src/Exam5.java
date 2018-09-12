import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class DeleteTest {
	public DeleteTest() {
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
	
	public void deleteArticle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = scanner.next();
		
		Connection connection = getConnection();
		PreparedStatement ps = null;
		String sql = "delete dbtest where name = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			try {
				if(ps != null) ps.close();
				if(connection != null) connection.close();
				if(scanner != null) scanner.close();
			} catch (Exception e) {}
		}
	}
}
public class Exam5 {
	public static void main(String[] args) {
		DeleteTest deleteTest = new DeleteTest();
		deleteTest.deleteArticle();
	}
}
