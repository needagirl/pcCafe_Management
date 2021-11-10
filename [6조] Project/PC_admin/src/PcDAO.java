import java.util.ArrayList;
import java.util.List;

public class PcDAO extends DBCON{

	public PcDAO() {
		
	}
	public List<PcVO> searchRecord(String startDate, String endDate){
		List<PcVO> list = new ArrayList<PcVO>();
		try {
			//1.db연결 
			dbConn();
			String sql = "select pc_num, pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc where pc_start>=to_date(?,'YYYYMMDD') and pc_end<=to_date(?,'YYYYMMDDHH24')";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
			while(rs.next()) {//resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면 false
				PcVO vo = new PcVO();
				
				vo.setPc_num(rs.getInt(1));	
				vo.setPc_no(rs.getInt(2));
				vo.setU_no(rs.getInt(3));
				vo.setPc_use(rs.getInt(4));
				vo.setPay(rs.getInt(5));
				vo.setPc_start(rs.getString(6));
				vo.setPc_end(rs.getString(7));
				vo.setManager(rs.getString(8));
	
				list.add(vo); //저장순서를 유지하는 list에 저장
			
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	
	}
	
	//전체목록
	public List<PcVO> allRecord(){
		List<PcVO> list = new ArrayList<PcVO>();
		try {
			//1.db연결 
			dbConn();
			String sql = "select pc_num, pc_no, u_no, pc_use, pay, pc_start, pc_end, manager from pc";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PcVO vo = new PcVO();//vo 별도로 생성해야되니까 while문에
		
				vo.setPc_num(rs.getInt(1));	
				vo.setPc_no(rs.getInt(2));
				vo.setU_no(rs.getInt(3));
				vo.setPc_use(rs.getInt(4));
				vo.setPay(rs.getInt(5));
				vo.setPc_start(rs.getString(6));
				vo.setPc_end(rs.getString(7));
				vo.setManager(rs.getString(8));
				
				list.add(vo); //저장순서를 유지하는 list에 저장
			
			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return list;
	
	
	}
}
