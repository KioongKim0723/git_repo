
public class Exam1 {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ��� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ��� ����");
		}
		
		
	}
}
