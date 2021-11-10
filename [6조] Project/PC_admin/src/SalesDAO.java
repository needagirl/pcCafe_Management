import java.util.ArrayList;
import java.util.List;

public class SalesDAO extends DBCON {

	public SalesDAO() {

	}
	public void insertRecord(SalesVO vo) {
		try {
			dbConn();
			String sql = "insert into p_sale(s_num, p_name, s_cnt, u_no ) values(s_num_seq.nextval,?, ?,2)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getP_name());
			pstmt.setInt(2, vo.getS_cnt());
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("입고상품 추가 에러 발생...");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public List<SalesVO> searchRecord(String startDate, String endDate) {
		List<SalesVO> list = new ArrayList<SalesVO>();
		try {
			// 1.db연결
			dbConn(); // sql이 안뜸
			// select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, pc.u_no,
			// ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code
			// "
			// + " join p_sale ps on pd.p_name = ps.p_name join manager mn on ps.manager =
			// mn.manager join pc pc on mn.manager = pc.manager
			// pc.u_no(구매자만 못데려옴)
			String sql = "select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code\r\n"
					+ "join p_sale ps on pd.p_name = ps.p_name "
					+ "where s_date>=to_date(?,'YYYYMMDD') and s_date<=to_date(?,'YYYYMMDDHH24')";// 필드명 배치
			// 2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {// resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면
								// false
				SalesVO vo = new SalesVO();// vo 별도로 생성해야되니까 while문에
				// vo.setNum(rs.getInt(1)); //mem_no(String sql 배열 index 1)
				vo.setS_num(rs.getInt(1));
				vo.setP_class(rs.getString(2));
				vo.setP_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_cnt(rs.getInt(5));
				// vo.setU_no(rs.getString(6));
				vo.setS_date(rs.getString(6));
				vo.setManager(rs.getString(7));

				// vo.setRemark(rs.getString(6));
				list.add(vo); // 저장순서를 유지하는 list에 저장

			}
		} catch (Exception e) {
			System.out.println("상품현황 에러 발생 ");
		} finally {
			dbClose();
		}
		return list;

	}
	// 전체목록
	public List<SalesVO> allRecord() {
		List<SalesVO> list = new ArrayList<SalesVO>();
		try {
			// 1.db연결
			dbConn(); // sql이 안뜸
			// select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, pc.u_no,
			// ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code
			// "
			// + " join p_sale ps on pd.p_name = ps.p_name join manager mn on ps.manager =
			// mn.manager join pc pc on mn.manager = pc.manager
			// pc.u_no(구매자만 못데려옴)
			String sql = "select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code\r\n"
					+ "join p_sale ps on pd.p_name = ps.p_name";// 필드명 배치
			// 2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); // 레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			while (rs.next()) {// resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면
								// false
				SalesVO vo = new SalesVO();// vo 별도로 생성해야되니까 while문에
				// vo.setNum(rs.getInt(1)); //mem_no(String sql 배열 index 1)
				vo.setS_num(rs.getInt(1));
				vo.setP_class(rs.getString(2));
				vo.setP_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_cnt(rs.getInt(5));
				// vo.setU_no(rs.getString(6));
				vo.setS_date(rs.getString(6));
				vo.setManager(rs.getString(7));

				// vo.setRemark(rs.getString(6));
				list.add(vo); // 저장순서를 유지하는 list에 저장

			}
		} catch (Exception e) {
			System.out.println("상품현황 에러 발생 ");
		} finally {
			dbClose();
		}
		return list;

	}

}
