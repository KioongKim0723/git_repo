import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class InsertTest {
	
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ��� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ��� ����");
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jspexam";
		String password = "m1234";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("���� ����");
		} catch (SQLException e) {
			System.out.println("���� ����");
		}
		
		return conn;
	}
	
	public void insertArticle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("���� �Է� : ");
		int age = Integer.parseInt(scanner.next());
		System.out.print("Ű �Է� : ");
		double height = Double.parseDouble(scanner.next());
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		String sql = "insert into dbtest values (?, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(su + "���� ���� ����������ϴ�.");
	}
}

public class Exam2 {
	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle();
	}
}
