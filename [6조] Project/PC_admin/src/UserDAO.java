import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DBCON{

	public UserDAO() {
	}
	//전체선택
	public List<UserVO> allRecord(){
		List<UserVO> list = new ArrayList<UserVO>(); 
		try {
			//1.db연결 
			dbConn(); 
			String sql = "select ud.u_no,ud.sex, ud.name, ud.id, ud.pwd, ud.addr,ud.birth, ud.tel, pc.pc_use, pc.pay, ud.write_date, ud.remark from userdata ud join pc pc on ud.u_no = pc.u_no(+) order by u_no asc";//필드명 배치
			//2.preparestatement 생성
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
				list.add(vo); //저장순서를 유지하는 list에 저장
			}
			
		}catch(Exception e) {
			System.out.println("전체회원선택 에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
}

	//회원추가
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
				System.out.println("회원추가에러 발생...");
				e.printStackTrace();		
				}finally {
				dbClose();
			}
			return cnt;
		}
		//회원수정  (생년월일 빼고 모두 수정가능함, 생년월일은 00:00:00때문에 오류나는 듯)
		public int updateRecord(UserVO vo){
			int cnt=0;
			
			try {
				dbConn();
				
				String sql = "update userdata set sex=?,name=?, id=?, pwd=? , addr=?, tel=?, remark=? where u_no=?";//데이터는 vo에 있음
								
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, vo.getSex());
				pstmt.setString(2, vo.getName()); //vo에 데이터가 있으니까
				pstmt.setString(3, vo.getId());
				pstmt.setString(4, vo.getPwd());
				pstmt.setString(5, vo.getAddr());
				//pstmt.setString(6, vo.getBirth());
				pstmt.setString(6, vo.getTel());
				pstmt.setString(7, vo.getRemark());
				pstmt.setInt(8, vo.getU_no());
				
				cnt = pstmt.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("회원수정 에러 발생...");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return cnt;
		}
	
		//회원삭제   (membermain 사원삭제에서 누구를 삭제할건지 보내줌)
		public int deleteRecord(int u_no) { //받을 변수 정의
			int cnt =0;
			try {
				dbConn();
				String sql = "delete from userdata where u_no=?"; 
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, u_no);
				cnt = pstmt.executeUpdate(); 
				
			}catch(Exception e) {
				System.out.println("회원삭제 에러 발생...");
			}finally {
				dbClose();
			}
			return cnt;
		}
		
		public List<UserVO> searchRecord(String search, String fieldName) { //검색어와 검색키를 받아와야함(vo엔 변수가 없으니까 
			List<UserVO> list = new ArrayList<UserVO>();
			try {
				dbConn();
				//select ud.u_no, ud.name, ud.sex, ud.id, 
				//to_char(ud.write_date, 'YYYY-MM-DD') write_date, pc.pc_use, pc.pay from userdata ud join pc pc on ud.u_no= pc.u_no 
						//and ud.name like '%이%' ;
				String sql = "select ud.u_no, ud.sex, ud.name, ud.id, "
						+ " ud.pwd, ud.addr, ud.birth, ud.tel, pc.pc_use, pc.pay,to_char(ud.write_date, 'YYYY-MM-DD') write_date, ud.remark from userdata ud join pc pc on ud.u_no= pc.u_no(+) "
						+ " and "+fieldName+" like ? ";  //order by name asc
				System.out.println("sql->"+ sql);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"%"+search+"%" ); 
				rs = pstmt.executeQuery();  //select니까 query
				
				while(rs.next()) {//false일 경우 아래 list로 바로 리턴
					UserVO vo = new UserVO(); 
					vo.setU_no(rs.getInt(1)); //mem_no(String sql 배열 index 1)
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
				System.out.println("회원검색 에러 발생");
				e.printStackTrace(); 
			}finally {
				dbClose();
			}
			return list; //searchRecord 함수 호출한 곳으로 리턴
		}
		
	}
	
