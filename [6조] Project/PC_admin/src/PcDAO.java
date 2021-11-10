import java.util.ArrayList;
import java.util.List;

public class PcDAO extends DBCON{

	public PcDAO() {
		
	}
	public List<PcVO> searchRecord(String startDate, String endDate){
		List<PcVO> list = new ArrayList<PcVO>();
		try {
			//1.db���� 
			dbConn();
			String sql = "select pc_num, pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc where pc_start>=to_date(?,'YYYYMMDD') and pc_end<=to_date(?,'YYYYMMDDHH24')";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
			while(rs.next()) {//resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������ false
				PcVO vo = new PcVO();
				
				vo.setPc_num(rs.getInt(1));	
				vo.setPc_no(rs.getInt(2));
				vo.setU_no(rs.getInt(3));
				vo.setPc_use(rs.getInt(4));
				vo.setPay(rs.getInt(5));
				vo.setPc_start(rs.getString(6));
				vo.setPc_end(rs.getString(7));
				vo.setManager(rs.getString(8));
	
				list.add(vo); //��������� �����ϴ� list�� ����
			
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	
	}
	
	//��ü���
	public List<PcVO> allRecord(){
		List<PcVO> list = new ArrayList<PcVO>();
		try {
			//1.db���� 
			dbConn();
			String sql = "select pc_num, pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PcVO vo = new PcVO();//vo ������ �����ؾߵǴϱ� while����
		
				vo.setPc_num(rs.getInt(1));	
				vo.setPc_no(rs.getInt(2));
				vo.setU_no(rs.getInt(3));
				vo.setPc_use(rs.getInt(4));
				vo.setPay(rs.getInt(5));
				vo.setPc_start(rs.getString(6));
				vo.setPc_end(rs.getString(7));
				vo.setManager(rs.getString(8));
				
				list.add(vo); //��������� �����ϴ� list�� ����
			
			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return list;
	
	
	}
}
