import java.util.ArrayList;
import java.util.List;

public class SeatDAO extends DBCON{

	public SeatDAO() {
		
	}
	
	//id 가져오기
	public String idGet(){
		String id = "";
		//List<String> list = new ArrayList<String>();
		try {
			//1.db연결 
			dbConn();
			String sql = "select id from userdata where u_no=(select max(u_no) from userdata)";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				id = rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return id;
	}
	
	//시작시간 가져오기
	public String startTime(){
		String start = "";
		//List<String> list = new ArrayList<String>();
		try {
			//1.db연결 
			dbConn();
			String sql = "select pc_start from pc where pc_num=(select max(pc_num) from pc)";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			if(rs.next()){
				start = rs.getString(1).substring(0,19);

			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return start;
	}
	
	//종료시간 가져오기
	public String exitTime(){
		String exit = "";
		try {
			//1.db연결 
			dbConn();
			String sql = "select pc_end from pc where pc_num=(select max(pc_num) from pc)";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			if(rs.next()){//resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면 false
				
				exit= rs.getString(1).substring(0,19);
			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return exit;
	}
	
	//상품판매 -> pc에서 pc_no이 가장 높은 사람의 pay를 가져옴..)
	//상품판매(판매수량 가져오기)
	public String goodsPay(){
		String payed = "";
		//List<String> list = new ArrayList<String>();
		try {
			//1.db연결 
			dbConn();
			String sql = "select pay from pc where pc_num=(select max(pc_num) from pc)";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			if(rs.next()){//resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면 false
			
				int p= (Integer.parseInt(rs.getString(1)));
				int pa = p-2000;
				payed = (String.valueOf(pa));

			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return payed;
	}
	//최종 계산금액
	public String Payed(){
		String payed = "";
		try {
			//1.db연결 
			dbConn();
			String sql = "select pay from pc where pc_num=(select max(pc_num) from pc)";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			if(rs.next()){//resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면 false
			
				int p= (Integer.parseInt(rs.getString(1)));
				//int pa = p-2000;
				payed = (String.valueOf(p));
		
			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return payed;
	}
	
	//계산금액
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
