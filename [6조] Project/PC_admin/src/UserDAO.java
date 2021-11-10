import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBCON{

	public UserDAO() {
	}
	//��ü����
	public List<UserVO> allRecord(){
		List<UserVO> list = new ArrayList<UserVO>(); 
		try {
			//1.db���� 
			dbConn(); 
			String sql = "select ud.u_no,ud.sex, ud.name, ud.id, ud.pwd, ud.addr,ud.birth, ud.tel, pc.pc_use, pc.pay, ud.write_date, ud.remark from userdata ud join pc pc on ud.u_no = pc.u_no(+) order by u_no asc";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setU_no(rs.getInt(1)); 
				vo.setSex(rs.getInt(2));
				vo.setName(rs.getString(3));
				vo.setId(rs.getString(4));
				vo.setPwd(rs.getString(5));
				vo.setAddr(rs.getString(6));
				vo.setBirth(rs.getString(7));
				vo.setTel(rs.getString(8));
				vo.setPc_use(rs.getInt(9));
				vo.setPay(rs.getInt(10));
				vo.setWrite_date(rs.getString(11));
				vo.setRemark(rs.getString(12));
				list.add(vo); //��������� �����ϴ� list�� ����
			}
			
		}catch(Exception e) {
			System.out.println("��üȸ������ ���� �߻�");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
}

	//ȸ���߰�
		public int insertRecord(UserVO vo) {
			int cnt=0;
			try {
				//select u_no, name, gender, id, to_date(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users  //to_date('1996-01-19','YYYY-MM-DD')
				dbConn();  
				String sql ="insert into userdata(u_no,sex, name, id,pwd,addr, birth, tel,remark) values(u_no_seq.nextval,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				//pstmt.setInt(1, vo.getU_no());
				pstmt.setInt(1, vo.getSex());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getId());
				pstmt.setString(4, vo.getPwd());
				pstmt.setString(5, vo.getAddr());
				pstmt.setString(6, vo.getBirth());
				pstmt.setString(7, vo.getTel());
				pstmt.setString(8, vo.getRemark());
			
				cnt = pstmt.executeUpdate();
				
			}catch(Exception e){
				System.out.println("ȸ���߰����� �߻�...");
				e.printStackTrace();		
				}finally {
				dbClose();
			}
			return cnt;
		}
		//ȸ������  (������� ���� ��� ����������, ��������� 00:00:00������ �������� ��)
		public int updateRecord(UserVO vo){
			int cnt=0;
			
			try {
				dbConn();
				
				String sql = "update userdata set sex=?,name=?, id=?, pwd=? , addr=?, tel=?, remark=? where u_no=?";//�����ʹ� vo�� ����
								
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, vo.getSex());
				pstmt.setString(2, vo.getName()); //vo�� �����Ͱ� �����ϱ�
				pstmt.setString(3, vo.getId());
				pstmt.setString(4, vo.getPwd());
				pstmt.setString(5, vo.getAddr());
				//pstmt.setString(6, vo.getBirth());
				pstmt.setString(6, vo.getTel());
				pstmt.setString(7, vo.getRemark());
				pstmt.setInt(8, vo.getU_no());
				
				cnt = pstmt.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("ȸ������ ���� �߻�...");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return cnt;
		}
	
		//ȸ������   (membermain ����������� ������ �����Ұ��� ������)
		public int deleteRecord(int u_no) { //���� ���� ����
			int cnt =0;
			try {
				dbConn();
				String sql = "delete from userdata where u_no=?"; 
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, u_no);
				cnt = pstmt.executeUpdate(); 
				
			}catch(Exception e) {
				System.out.println("ȸ������ ���� �߻�...");
			}finally {
				dbClose();
			}
			return cnt;
		}
		
		public List<UserVO> searchRecord(String search, String fieldName) { //�˻���� �˻�Ű�� �޾ƿ;���(vo�� ������ �����ϱ� 
			List<UserVO> list = new ArrayList<UserVO>();
			try {
				dbConn();
				//select ud.u_no, ud.name, ud.sex, ud.id, 
				//to_char(ud.write_date, 'YYYY-MM-DD') write_date, pc.pc_use, pc.pay from userdata ud join pc pc on ud.u_no= pc.u_no 
						//and ud.name like '%��%' ;
				String sql = "select ud.u_no, ud.sex, ud.name, ud.id, "
						+ " ud.pwd, ud.addr, ud.birth, ud.tel, pc.pc_use, pc.pay,to_char(ud.write_date, 'YYYY-MM-DD') write_date, ud.remark from userdata ud join pc pc on ud.u_no= pc.u_no(+) "
						+ " and "+fieldName+" like ? ";  //order by name asc
				System.out.println("sql->"+ sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%"+search+"%" ); 
				rs = pstmt.executeQuery();  //select�ϱ� query
				
				while(rs.next()) {//false�� ��� �Ʒ� list�� �ٷ� ����
					UserVO vo = new UserVO(); 
					vo.setU_no(rs.getInt(1)); //mem_no(String sql �迭 index 1)
					vo.setSex(rs.getInt(2));
					vo.setName(rs.getString(3));
					vo.setId(rs.getString(4));
					vo.setPwd(rs.getString(5));
					vo.setAddr(rs.getString(6));
					vo.setBirth(rs.getString(7));
					vo.setTel(rs.getString(8));
					vo.setPc_use(rs.getInt(9));
					vo.setPay(rs.getInt(10));
					vo.setWrite_date(rs.getString(11));
					vo.setRemark(rs.getString(12));
					
					list.add(vo);
					
				}
				
			}catch(Exception e) {
				System.out.println("ȸ���˻� ���� �߻�");
				e.printStackTrace(); 
			}finally {
				dbClose();
			}
			return list; //searchRecord �Լ� ȣ���� ������ ����
		}
		
	}
	
