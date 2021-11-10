import java.util.ArrayList;
import java.util.List;

public class GoodsDAO extends DBCON{

	public GoodsDAO() {
	
	}
	//전체목록 
	public List<GoodsVO> allRecord(){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			//1.db연결 
			dbConn();
			String sql = "select p.p_num, p.p_name, pc.p_class, p.s_price, p.p_stock, p.remark from product p join p_code pc on p.p_code = pc.p_code(+)";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			while(rs.next()) {//resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면 false
				GoodsVO vo = new GoodsVO();//vo 별도로 생성해야되니까 while문에
				//vo.setNum(rs.getInt(1)); //mem_no(String sql 배열 index 1)
				vo.setP_num(rs.getInt(1));
				vo.setP_name(rs.getString(2));
				vo.setP_class(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setP_stock(rs.getInt(5));
				vo.setRemark(rs.getString(6));
				//vo.setRemark(rs.getString(6));
				list.add(vo); //저장순서를 유지하는 list에 저장
			
			
			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return list;
	
	
	}

	
	//상품추가
	public int insertRecord(GoodsVO vo) {
		int cnt=0;
		
		try { //sales(p_sale.s_num, p_code.p_class, product.p_name, product.s_price, remark
			dbConn(); //num, p_class, p_name, s_price, remark) values(num_sq.nextval,?,?,?,?
			String sql ="insert into product(p_name,s_price,p_code,p_stock,remark) values(?,?,(select p_code from p_code where p_class = ?),?,?)";	
			//GoodsCheck gc = new GoodsCheck();
			//gc.miniRestockInsert();
			//int ps = (Integer.parseInt(gc.twoTf1.getText()));
		
				
			//String sql2="insert into p_code(p_class, p_code) values(?,20)";
			//String sql3 = "insert into p_sale(s_num, p_name, s_cnt) values (num_sq.nextval,	콘칩,1)";	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getP_name());
			pstmt.setInt(2, vo.getS_price());
			pstmt.setString(3, vo.getP_class());
			pstmt.setInt(4,vo.getP_stock());
			pstmt.setString(5, vo.getRemark());
			//pstmt.setString(4, vo.getRemark());
			
			cnt = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("상품추가에러 발생...");
			e.printStackTrace();		
			}finally {
			dbClose();
		}
		return cnt;	
	}
	//상품삭제
	public int deleteRecord(String p_name) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from product where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_name); //쿼리문에 첫번째 물음표
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("상품삭제 에러 발생...");
		}finally {
			dbClose();
		}
		return cnt;
	}
	 //select p.p_name, pc.p_class, p.s_price from product p join p_code pc on p.p_code = pc.p_code
	//상품수정						번호, 연락처, 이메일, 주소
	public int updateRecord(GoodsVO vo){
	int cnt=0;
	try {
			dbConn(); ///////?수정문 다시 써야함   //p_code=(select p_code from p_code where p_class=?)
			//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
			String sql = "update product set p_name=?, s_price=?,p_code=(select p_code from p_code where p_class=?), remark=? where p_num=?";//데이터는 vo에 있음
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
					
			pstmt.setString(1, vo.getP_name());
			pstmt.setInt(2, vo.getS_price()); //vo에 데이터가 있으니까
			pstmt.setString(3, vo.getP_class());
			//pstmt.setInt(4, vo.getP_stock()); //->재고수량을 써줘야함
			pstmt.setString(4, vo.getRemark());
			pstmt.setInt(5, vo.getP_num());
			//pstmt.setInt(5, vo.getSex());
					
			cnt = pstmt.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("상품수정 에러 발생...");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return cnt;
			}
	
	//상품구분 추가
	public int insertRecordPClass(GoodsVO vo) {
		int cnt=0;
		
		try { //sales(p_sale.s_num, p_code.p_class, product.p_name, product.s_price, remark
			dbConn(); //num, p_class, p_name, s_price, remark) values(num_sq.nextval,?,?,?,?
			String sql ="insert into p_code(p_code,p_class) values(p_code_seq.nextval, ?)";	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getP_class());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("상품구분 추가에러 발생...");
			e.printStackTrace();		
			}finally {
			dbClose();
		}
		return cnt;	
	}
	//상품구분 목록 불러오기
	public List<String> allRecordPClass(){
		List<String> list = new ArrayList<String>();
		try {
			//1.db연결 
			dbConn();
			String sql = "select p_class from p_code";//필드명 배치
			//2.preparestatement 생성
			pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1)); 
			
			}
		}catch(Exception e) {
			System.out.println("상품현황 에러 발생 ");
		}finally {
			dbClose();
		}
		return list;
	}
	
	//상품구분 삭제
	public int deleteRecordPClass(String p_class) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from p_code where p_class=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_class); //쿼리문에 첫번째 물음표
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("상품삭제 에러 발생...");
		}finally {
			dbClose();
		}
		return cnt;
	}	
	
	//재고수량(현재재고수량+입고수량-판매수량 합계)
	public int updateRecordPstock(GoodsVO vo){
		//맨 위 전역변수에다가 지정을 해주면 됨
		//select p_code from p_code where p_class =?
		int cnt=0;
		try { //select p_code from p_code where p_class =?
			//GoodsCheck gc = new GoodsCheck();
			
			dbConn(); ///////?수정문 다시 써야함
			//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
			//update product set p_stock=((select p_stock from product where p_name='콜라') + 5 -(select s_cnt from p_sale where p_name='콜라'))
			//where p_name='콜라';
			
			//update product set final_stock=((select p_stock from product where p_name=?) + ? -(select s_cnt from p_sale where p_name=?))where p_name=?
			
		//	"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='콘칩')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='콘칩')where p_name='콘칩';
					// -(select s_cnt from p_sale where p_name=?)) //판매수량 마이너스 
			String sql = "update product set p_stock=((select p_stock from product where p_name=?)"
					+ " + (select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name=?))"
					+ " where p_name=?";//데이터는 vo에 있음
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getP_name());
			//pstmt.setInt(2, vo.getE_cnt());
			pstmt.setString(2, vo.getP_name());
			pstmt.setString(3, vo.getP_name());
		
			//int ecnt = Integer.parseInt(gc.twoTf1.getText());
			
			
			
//			pstmt.setInt(1, vo.getP_stock());//첫번째 물음표 -> pstock(현재고수량)
//			pstmt.setInt(2, vo.getE_cnt());//두번째 물음표 -> e_cnt(입고수량)
//			pstmt.setInt(3, vo.getS_cnt());//세번째 물음표 -> s_cnt(판매수량)
//			pstmt.setString(4, vo.getP_name());
//			
		//pstmt.setString(4, vo.getName());
		//pstmt.setInt(4, vo.getNum());
					
			cnt = pstmt.executeUpdate();
			
			
			System.out.println(vo.getP_stock());
		}catch(Exception e) {
			System.out.println("재고수량 에러 발생 ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
		
	}	
	public void setStock(String pname, int stock) {
		
		try { 
			dbConn(); ///////?수정문 다시 써야함
		
			//"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='콘칩')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='콘칩')where p_name='콘칩';
					// -(select s_cnt from p_sale where p_name=?)) //판매수량 마이너스 
			String sql = "update product set p_stock=? where p_name=?";//데이터는 vo에 있음
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
			//String pname ;
			pstmt.setInt(1, stock);
			pstmt.setString(2, pname);
			pstmt.executeUpdate();
			
			
			//rs.getInt(1);
		}catch(Exception e) {
			System.out.println("재고수량 에러 발생 ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}
	
	public int getE_cnt(String pname) {
		int result =0;
		try { 
			dbConn(); ///////?수정문 다시 써야함
		
			//"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='콘칩')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='콘칩')where p_name='콘칩';
					// -(select s_cnt from p_sale where p_name=?)) //판매수량 마이너스 
			String sql = "select e_cnt from p_enter where p_name=?";//데이터는 vo에 있음
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
			//String pname ;
			pstmt.setString(1, pname);

			rs = pstmt.executeQuery();
			while(rs.next()) {
			 result = result + rs.getInt(1);
			//rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("재고수량 에러 발생 ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}
	
	public int getS_cnt(String pname) {
		int result =0;
		try { 
			dbConn(); ///////?수정문 다시 써야함
		
			//"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='콘칩')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='콘칩')where p_name='콘칩';
					// -(select s_cnt from p_sale where p_name=?)) //판매수량 마이너스 
			String sql = "select s_cnt from p_sale where p_name=?";//데이터는 vo에 있음
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
			//String pname ;
			pstmt.setString(1, pname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			 result = result + rs.getInt(1);
			//rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("재고수량 에러 발생 ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}
	
	


/*
//1.db연결 
dbConn(); //select pe.p_name,pd.p_stock + pe.e_cnt as revenue from p_enter pe join product pd on pe.p_name = pd.p_name;
String sql = "select pe.p_name,pd.p_stock + pe.e_cnt as revenue from p_enter pe join product pd on pe.p_name = pd.p_name";
		//"select pd.p_stock + pe.e_cnt-ps.s_cnt as revenue from p_enter pe join product pd on pe.p_name = pd.p_name join p_sale ps on pd.p_name = ps.p_name";//필드명 배치
//2.preparestatement 생성
pstmt = conn.prepareStatement(sql); //레코드 전체선택이니까 물음표 없음
rs = pstmt.executeQuery();
while(rs.next()) {//resultset안에 데이터가 표 형식으로 다 담겨져있음, 포인트 이동메소드(next)->선택한 행의 정보가 있으면 true, 없으면 false
	GoodsVO vo = new GoodsVO();//vo 별도로 생성해야되니까 while문에
	//vo.setNum(rs.getInt(1)); //mem_no(String sql 배열 index 1)
	
	
	vo.setP_stock(vo.getP_stock());
	
	
	
	//vo.setRemark(rs.getString(6));
	list.add(vo); //저장순서를 유지하는 list에 저장

	
	
	//GoodsVO vo = new GoodsVO();//vo 별도로 생성해야되니까 while문에
	//vo.setNum(rs.getInt(1)); //mem_no(String sql 배열 index 1)
	
	//vo.setRemark(rs.getString(6));
	list.add(); //저장순서를 유지하는 list에 저장

*/


}
