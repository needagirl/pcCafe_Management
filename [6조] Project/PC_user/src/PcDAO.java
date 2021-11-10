
public class PcDAO extends DBCON{

	public PcDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void insertPcInfo(PcVo vo) {
		try {
			dbConn();
			String sql = "insert into PC (PC_NUM, PC_NO, U_NO, PAY, PC_USE, PC_START, PC_END, MANAGER) Values((select nvl(max(PC_NUM), 0)+1 from PC), ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPcNo());
			pstmt.setInt(2, vo.getuNo());
			pstmt.setInt(3, vo.getPay());
			pstmt.setInt(4, vo.getPcUse());
			pstmt.setTimestamp(5, vo.getStartTimeTimestamp());
			pstmt.setTimestamp(6, vo.getEndTimeTimestamp());
			pstmt.setString(7, vo.getManager());
			int rowCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
	
	public void updatePcInfo(PcVo vo) {
		
	}

}
