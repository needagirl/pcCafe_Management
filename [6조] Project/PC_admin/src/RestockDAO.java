
import java.util.ArrayList;
import java.util.List;

public class RestockDAO extends DBCON{

	public RestockDAO() {
		
	}
	public List<RestockVO> searchRecord(String startDate, String endDate) {// 이름 기준으로 어샌딩해서 컬렉션에 담은다음에 리턴해줌 //아래에서 List로 리턴되니까 똑같이 써줘야함
		List<RestockVO> list = new ArrayList<RestockVO>(); // 컬렉션에 담아야하니까 컬렉션 객체 생성, 상위 인터페이스로 리턴 //utill import
		try {
			// 1.db연결
			dbConn(); // remark
			String sql = "select pe.e_num, pc.p_class, p.p_name, pe.e_cnt, pe.e_price, pe.e_date, pe.expiry, pe.remark, pe.manager  "
					+ " from p_code pc inner join product p on pc.p_code = p.p_code inner join p_enter pe  "
					+ " on p.p_name = pe.p_name where e_date>=to_date(?,'YYYYMMDD')and e_date<=to_date(?,'YYYYMMDDHH24')";
			// 필드명 배치
			// 2.preparestatement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery(); // 데이터가 변하는게 아니니까 cuteQuery씀
			while (rs.next()) {// resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면
								// false
				RestockVO vo = new RestockVO();// vo 별도로 생성해야되니까 while문에
				vo.setE_Num(rs.getInt(1)); // mem_no(String sql 배열 index 1)
				vo.setP_class(rs.getString(2));
				vo.setP_name(rs.getString(3));
				vo.setE_cnt(rs.getInt(4));
				vo.setE_price(rs.getInt(5));
				vo.setE_date(rs.getString(6));
				vo.setExpiry(rs.getInt(7));
				vo.setRemark(rs.getString(8));
				vo.setManager(rs.getString(9));
				list.add(vo); // 저장순서를 유지하는 list에 저장
			}

		} catch (Exception e) {
			System.out.println("전체입고상품 에러 발생");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	
	
	//전체선택
		public List<RestockVO> allRecord(){//이름 기준으로 어샌딩해서 컬렉션에 담은다음에 리턴해줌 //아래에서 List로 리턴되니까 똑같이 써줘야함
			List<RestockVO> list = new ArrayList<RestockVO>(); //컬렉션에 담아야하니까 컬렉션 객체 생성, 상위 인터페이스로 리턴 //utill import
			try {
				//1.db연결 
				dbConn(); //remark 
				String sql = "select pe.e_num, pc.p_class, p.p_name, pe.e_cnt, pe.e_price, pe.e_date, pe.expiry, pe.remark, pe.manager  "
						+ " from p_code pc inner join product p on pc.p_code = p.p_code inner join p_enter pe  "
						+ " on p.p_name = pe.p_name";
						//필드명 배치
				//2.preparestatement 생성
				pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
				rs = pstmt.executeQuery(); //데이터가 변하는게 아니니까 cuteQuery씀
				while(rs.next()) {//resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면 false
					RestockVO vo = new RestockVO();//vo 별도로 생성해야되니까 while문에
					vo.setE_Num(rs.getInt(1)); //mem_no(String sql 배열 index 1)
					vo.setP_class(rs.getString(2));
					vo.setP_name(rs.getString(3));
					vo.setE_cnt(rs.getInt(4));
					vo.setE_price(rs.getInt(5));
					vo.setE_date(rs.getString(6));
					vo.setExpiry(rs.getInt(7));
					vo.setRemark(rs.getString(8));
					vo.setManager(rs.getString(9));
					list.add(vo); //저장순서를 유지하는 list에 저장
				}
				
			}catch(Exception e) {
				System.out.println("전체입고상품 에러 발생");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return list;
	}
		
		//입고상품추가
			public int insertRecord(RestockVO vo) {
				int cnt=0;
				try {
					//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
					dbConn();
					String sql ="insert into p_enter(e_num, p_name, e_cnt, e_price, expiry, remark, manager ) values(e_num_seq.nextval,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					//pstmt.setInt(1, vo.getU_no());
					pstmt.setString(1, vo.getP_name());
					//pstmt.setString(2, vo.getP_class());
					pstmt.setInt(2, vo.getE_cnt());
					pstmt.setInt(3, vo.getE_price());
					pstmt.setInt(4, vo.getExpiry());
					pstmt.setString(5, vo.getRemark());
					pstmt.setString(6, vo.getManager());
					
					cnt = pstmt.executeUpdate();
					
				}catch(Exception e){
					System.out.println("입고상품 추가 에러 발생...");
					e.printStackTrace();		
					}finally {
					dbClose();
				}
				return cnt;
			}
			//입고상품수정						번호, 연락처, 이메일, 주소
			public int updateRecord(RestockVO vo){
				int cnt=0;
				
				try {
					dbConn();
					//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
					String sql = "update p_enter set p_name=? , e_cnt=?, e_price=?, expiry=?, remark=? where e_num=?";//데이터는 vo에 있음
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, vo.getP_name());
					//pstmt.setString(2, vo.getP_class()); //vo에 데이터가 있으니까
					pstmt.setInt(2, vo.getE_cnt());
					pstmt.setInt(3, vo.getE_price());
					pstmt.setInt(4, vo.getExpiry());
					pstmt.setString(5, vo.getRemark());
					pstmt.setInt(6, vo.getE_Num());
	
					cnt = pstmt.executeUpdate();
					
				}catch(Exception e) {
					System.out.println("입고상품 수정 에러 발생...");
					e.printStackTrace();
				}finally {
					dbClose();
				}
				return cnt;
			}
		
			//입고상품삭제   (membermain 사원삭제에서 누구를 삭제할건지 보내줌)
			public int deleteRecord(String p_name) { //받을 변수 정의
				int cnt =0;//몇개의 레코드가 삭제되었는지 memberDelete()로 다시 리턴
				try {
					dbConn();
					String sql = "delete from p_enter where p_name=?"; //mem_no 기준
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, p_name);
					cnt = pstmt.executeUpdate(); //실행 -> int로 cnt에 결과넣음
					
				}catch(Exception e) {
					System.out.println("입고상품삭제 에러 발생...");
				}finally {
					dbClose();
				}
				return cnt;
			}
			//상품관리에 있는 미니 입고처리 추가
			public int insertRecordMini(RestockVO vo) {
				int cnt=0;
				try {
					//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
					dbConn();
					String sql ="insert into p_enter(e_num, p_name, e_cnt, e_price, expiry, remark, manager ) values(e_num_seq.nextval,?,?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					//pstmt.setInt(1, vo.getU_no());
					pstmt.setString(1, vo.getP_name());
					//pstmt.setString(2, vo.getP_class());
					pstmt.setInt(2, vo.getE_cnt());
					pstmt.setInt(3, vo.getE_price());
					pstmt.setInt(4, vo.getExpiry());
					pstmt.setString(5, vo.getRemark());
					pstmt.setString(6, vo.getManager());
					
					cnt = pstmt.executeUpdate();
					
				}catch(Exception e){
					System.out.println("미니 입고상품 추가 에러 발생...");
					e.printStackTrace();		
					}finally {
					dbClose();
				}
				return cnt;
			}
}