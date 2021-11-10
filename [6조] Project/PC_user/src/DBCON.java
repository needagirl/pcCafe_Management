import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCON {
	//드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//스트링 전달받으면 그걸가지고 클래스 객체로 만들어서 jvm에 알려줌
		}catch(Exception e) {
			System.out.println("jdbc 드라이브 로딩 실패");
			e.printStackTrace();
		}
	}
	//
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String name ="c##scott";
	String pwd = "tiger";
	
	public DBCON() {
		 
	}
	public void dbConn() { //db연결 메소드	
		try {
			conn = DriverManager.getConnection(url, name, pwd);
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패...");
			e.printStackTrace();
		}
	}
	public void dbClose() {
		try {
			if(rs!=null)rs.close();//제일 마지막 실행하는 객체부터
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			System.out.println("데이터 베이스 닫기 실패");
			e.printStackTrace();
		}
	}
}
