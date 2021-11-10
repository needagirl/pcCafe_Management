
import java.util.ArrayList;
import java.util.List;

public class RestockDAO extends DBCON{

	public RestockDAO() {
		
	}
	public List<RestockVO> searchRecord(String startDate, String endDate) {// �̸� �������� ������ؼ� �÷��ǿ� ���������� �������� //�Ʒ����� List�� ���ϵǴϱ� �Ȱ��� �������
		List<RestockVO> list = new ArrayList<RestockVO>(); // �÷��ǿ� ��ƾ��ϴϱ� �÷��� ��ü ����, ���� �������̽��� ���� //utill import
		try {
			// 1.db����
			dbConn(); // remark
			String sql = "select pe.e_num, pc.p_class, p.p_name, pe.e_cnt, pe.e_price, pe.e_date, pe.expiry, pe.remark, pe.manager  "
					+ " from p_code pc inner join product p on pc.p_code = p.p_code inner join p_enter pe  "
					+ " on p.p_name = pe.p_name where e_date>=to_date(?,'YYYYMMDD')and e_date<=to_date(?,'YYYYMMDDHH24')";
			// �ʵ�� ��ġ
			// 2.preparestatement ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = pstmt.executeQuery(); // �����Ͱ� ���ϴ°� �ƴϴϱ� cuteQuery��
			while (rs.next()) {// resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������
								// false
				RestockVO vo = new RestockVO();// vo ������ �����ؾߵǴϱ� while����
				vo.setE_Num(rs.getInt(1)); // mem_no(String sql �迭 index 1)
				vo.setP_class(rs.getString(2));
				vo.setP_name(rs.getString(3));
				vo.setE_cnt(rs.getInt(4));
				vo.setE_price(rs.getInt(5));
				vo.setE_date(rs.getString(6));
				vo.setExpiry(rs.getInt(7));
				vo.setRemark(rs.getString(8));
				vo.setManager(rs.getString(9));
				list.add(vo); // ��������� �����ϴ� list�� ����
			}

		} catch (Exception e) {
			System.out.println("��ü�԰��ǰ ���� �߻�");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	
	
	//��ü����
		public List<RestockVO> allRecord(){//�̸� �������� ������ؼ� �÷��ǿ� ���������� �������� //�Ʒ����� List�� ���ϵǴϱ� �Ȱ��� �������
			List<RestockVO> list = new ArrayList<RestockVO>(); //�÷��ǿ� ��ƾ��ϴϱ� �÷��� ��ü ����, ���� �������̽��� ���� //utill import
			try {
				//1.db���� 
				dbConn(); //remark 
				String sql = "select pe.e_num, pc.p_class, p.p_name, pe.e_cnt, pe.e_price, pe.e_date, pe.expiry, pe.remark, pe.manager  "
						+ " from p_code pc inner join product p on pc.p_code = p.p_code inner join p_enter pe  "
						+ " on p.p_name = pe.p_name";
						//�ʵ�� ��ġ
				//2.preparestatement ����
				pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
				rs = pstmt.executeQuery(); //�����Ͱ� ���ϴ°� �ƴϴϱ� cuteQuery��
				while(rs.next()) {//resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������ false
					RestockVO vo = new RestockVO();//vo ������ �����ؾߵǴϱ� while����
					vo.setE_Num(rs.getInt(1)); //mem_no(String sql �迭 index 1)
					vo.setP_class(rs.getString(2));
					vo.setP_name(rs.getString(3));
					vo.setE_cnt(rs.getInt(4));
					vo.setE_price(rs.getInt(5));
					vo.setE_date(rs.getString(6));
					vo.setExpiry(rs.getInt(7));
					vo.setRemark(rs.getString(8));
					vo.setManager(rs.getString(9));
					list.add(vo); //��������� �����ϴ� list�� ����
				}
				
			}catch(Exception e) {
				System.out.println("��ü�԰��ǰ ���� �߻�");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return list;
	}
		
		//�԰��ǰ�߰�
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
					System.out.println("�԰��ǰ �߰� ���� �߻�...");
					e.printStackTrace();		
					}finally {
					dbClose();
				}
				return cnt;
			}
			//�԰��ǰ����						��ȣ, ����ó, �̸���, �ּ�
			public int updateRecord(RestockVO vo){
				int cnt=0;
				
				try {
					dbConn();
					//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
					String sql = "update p_enter set p_name=? , e_cnt=?, e_price=?, expiry=?, remark=? where e_num=?";//�����ʹ� vo�� ����
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, vo.getP_name());
					//pstmt.setString(2, vo.getP_class()); //vo�� �����Ͱ� �����ϱ�
					pstmt.setInt(2, vo.getE_cnt());
					pstmt.setInt(3, vo.getE_price());
					pstmt.setInt(4, vo.getExpiry());
					pstmt.setString(5, vo.getRemark());
					pstmt.setInt(6, vo.getE_Num());
	
					cnt = pstmt.executeUpdate();
					
				}catch(Exception e) {
					System.out.println("�԰��ǰ ���� ���� �߻�...");
					e.printStackTrace();
				}finally {
					dbClose();
				}
				return cnt;
			}
		
			//�԰��ǰ����   (membermain ����������� ������ �����Ұ��� ������)
			public int deleteRecord(String p_name) { //���� ���� ����
				int cnt =0;//��� ���ڵ尡 �����Ǿ����� memberDelete()�� �ٽ� ����
				try {
					dbConn();
					String sql = "delete from p_enter where p_name=?"; //mem_no ����
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, p_name);
					cnt = pstmt.executeUpdate(); //���� -> int�� cnt�� �������
					
				}catch(Exception e) {
					System.out.println("�԰��ǰ���� ���� �߻�...");
				}finally {
					dbClose();
				}
				return cnt;
			}
			//��ǰ������ �ִ� �̴� �԰�ó�� �߰�
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
					System.out.println("�̴� �԰��ǰ �߰� ���� �߻�...");
					e.printStackTrace();		
					}finally {
					dbClose();
				}
				return cnt;
			}
}