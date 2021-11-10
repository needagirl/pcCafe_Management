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
			System.out.println("�԰��ǰ �߰� ���� �߻�...");
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	public List<SalesVO> searchRecord(String startDate, String endDate) {
		List<SalesVO> list = new ArrayList<SalesVO>();
		try {
			// 1.db����
			dbConn(); // sql�� �ȶ�
			// select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, pc.u_no,
			// ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code
			// "
			// + " join p_sale ps on pd.p_name = ps.p_name join manager mn on ps.manager =
			// mn.manager join pc pc on mn.manager = pc.manager
			// pc.u_no(�����ڸ� ��������)
			String sql = "select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code\r\n"
					+ "join p_sale ps on pd.p_name = ps.p_name "
					+ "where s_date>=to_date(?,'YYYYMMDD') and s_date<=to_date(?,'YYYYMMDDHH24')";// �ʵ�� ��ġ
			// 2.preparestatement ����
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {// resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������
								// false
				SalesVO vo = new SalesVO();// vo ������ �����ؾߵǴϱ� while����
				// vo.setNum(rs.getInt(1)); //mem_no(String sql �迭 index 1)
				vo.setS_num(rs.getInt(1));
				vo.setP_class(rs.getString(2));
				vo.setP_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_cnt(rs.getInt(5));
				// vo.setU_no(rs.getString(6));
				vo.setS_date(rs.getString(6));
				vo.setManager(rs.getString(7));

				// vo.setRemark(rs.getString(6));
				list.add(vo); // ��������� �����ϴ� list�� ����

			}
		} catch (Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		} finally {
			dbClose();
		}
		return list;

	}
	// ��ü���
	public List<SalesVO> allRecord() {
		List<SalesVO> list = new ArrayList<SalesVO>();
		try {
			// 1.db����
			dbConn(); // sql�� �ȶ�
			// select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, pc.u_no,
			// ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code
			// "
			// + " join p_sale ps on pd.p_name = ps.p_name join manager mn on ps.manager =
			// mn.manager join pc pc on mn.manager = pc.manager
			// pc.u_no(�����ڸ� ��������)
			String sql = "select ps.s_num, co.p_class, ps.p_name, pd.s_price, ps.s_cnt, ps.s_date, ps.manager from p_code co join product pd on co.p_code = pd.p_code\r\n"
					+ "join p_sale ps on pd.p_name = ps.p_name";// �ʵ�� ��ġ
			// 2.preparestatement ����
			pstmt = conn.prepareStatement(sql); // ���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			while (rs.next()) {// resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������
								// false
				SalesVO vo = new SalesVO();// vo ������ �����ؾߵǴϱ� while����
				// vo.setNum(rs.getInt(1)); //mem_no(String sql �迭 index 1)
				vo.setS_num(rs.getInt(1));
				vo.setP_class(rs.getString(2));
				vo.setP_name(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setS_cnt(rs.getInt(5));
				// vo.setU_no(rs.getString(6));
				vo.setS_date(rs.getString(6));
				vo.setManager(rs.getString(7));

				// vo.setRemark(rs.getString(6));
				list.add(vo); // ��������� �����ϴ� list�� ����

			}
		} catch (Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		} finally {
			dbClose();
		}
		return list;

	}

}
