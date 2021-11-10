
import javax.swing.JOptionPane;

public class SignUpDAO extends DBCON {

	public void SignUpDAO() {}

	public int UserInfo(UserVO vo) {
		int cnt = 0;

		try {
			dbConn();
			String sql = "insert into userdata(u_no,name,id,pwd,tel,sex,addr,birth) values (U_NO_SEQ.nextval,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getTel());
			pstmt.setInt(5, vo.getSex());
			pstmt.setString(6, vo.getAddr());
			pstmt.setString(7, vo.getBirth());
			
			cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
				//dispose();
			}else {
				JOptionPane.showMessageDialog(null, "ȸ�������� �����Ͽ����ϴ�.");
				//dispose();		
	};
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return cnt;
	}

	}
