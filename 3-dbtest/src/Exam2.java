import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class InsertTest {
	
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jspexam";
		String password = "m1234";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
		}
		
		return conn;
	}
	
	public void insertArticle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("나이 입력 : ");
		int age = Integer.parseInt(scanner.next());
		System.out.print("키 입력 : ");
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
		
		System.out.println(su + "개의 행이 만들어졌습니다.");
	}
}

public class Exam2 {
	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle();
	}
}
