import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class UserDAO extends DBCON{

	public void UserDAO() {}

	public String IdPwd(String Id, String Pwd) {
		String uNo = "";
			try {
				dbConn();
				String sql = "SELECT * FROM userdata WHERE ID = ? AND PWD = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, Id);
				pstmt.setString(2, Pwd);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					uNo = rs.getString("U_NO");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				dbClose();
			}
		return uNo;
	}

}