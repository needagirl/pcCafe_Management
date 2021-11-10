import java.util.ArrayList;
import java.util.List;

public class GoodsDAO extends DBCON{

	public GoodsDAO() {
	
	}
	//��ü��� 
	public List<GoodsVO> allRecord(){
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			//1.db���� 
			dbConn();
			String sql = "select p.p_num, p.p_name, pc.p_class, p.s_price, p.p_stock, p.remark from product p join p_code pc on p.p_code = pc.p_code(+)";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			while(rs.next()) {//resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������ false
				GoodsVO vo = new GoodsVO();//vo ������ �����ؾߵǴϱ� while����
				//vo.setNum(rs.getInt(1)); //mem_no(String sql �迭 index 1)
				vo.setP_num(rs.getInt(1));
				vo.setP_name(rs.getString(2));
				vo.setP_class(rs.getString(3));
				vo.setS_price(rs.getInt(4));
				vo.setP_stock(rs.getInt(5));
				vo.setRemark(rs.getString(6));
				//vo.setRemark(rs.getString(6));
				list.add(vo); //��������� �����ϴ� list�� ����
			
			
			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return list;
	
	
	}

	
	//��ǰ�߰�
	public int insertRecord(GoodsVO vo) {
		int cnt=0;
		
		try { //sales(p_sale.s_num, p_code.p_class, product.p_name, product.s_price, remark
			dbConn(); //num, p_class, p_name, s_price, remark) values(num_sq.nextval,?,?,?,?
			String sql ="insert into product(p_name,s_price,p_code,p_stock,remark) values(?,?,(select p_code from p_code where p_class = ?),?,?)";	
			//GoodsCheck gc = new GoodsCheck();
			//gc.miniRestockInsert();
			//int ps = (Integer.parseInt(gc.twoTf1.getText()));
		
				
			//String sql2="insert into p_code(p_class, p_code) values(?,20)";
			//String sql3 = "insert into p_sale(s_num, p_name, s_cnt) values (num_sq.nextval,	��Ĩ,1)";	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getP_name());
			pstmt.setInt(2, vo.getS_price());
			pstmt.setString(3, vo.getP_class());
			pstmt.setInt(4,vo.getP_stock());
			pstmt.setString(5, vo.getRemark());
			//pstmt.setString(4, vo.getRemark());
			
			cnt = pstmt.executeUpdate();
		
		}catch(Exception e){
			System.out.println("��ǰ�߰����� �߻�...");
			e.printStackTrace();		
			}finally {
			dbClose();
		}
		return cnt;	
	}
	//��ǰ����
	public int deleteRecord(String p_name) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from product where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_name); //�������� ù��° ����ǥ
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("��ǰ���� ���� �߻�...");
		}finally {
			dbClose();
		}
		return cnt;
	}
	 //select p.p_name, pc.p_class, p.s_price from product p join p_code pc on p.p_code = pc.p_code
	//��ǰ����						��ȣ, ����ó, �̸���, �ּ�
	public int updateRecord(GoodsVO vo){
	int cnt=0;
	try {
			dbConn(); ///////?������ �ٽ� �����   //p_code=(select p_code from p_code where p_class=?)
			//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
			String sql = "update product set p_name=?, s_price=?,p_code=(select p_code from p_code where p_class=?), remark=? where p_num=?";//�����ʹ� vo�� ����
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
					
			pstmt.setString(1, vo.getP_name());
			pstmt.setInt(2, vo.getS_price()); //vo�� �����Ͱ� �����ϱ�
			pstmt.setString(3, vo.getP_class());
			//pstmt.setInt(4, vo.getP_stock()); //->�������� �������
			pstmt.setString(4, vo.getRemark());
			pstmt.setInt(5, vo.getP_num());
			//pstmt.setInt(5, vo.getSex());
					
			cnt = pstmt.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("��ǰ���� ���� �߻�...");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return cnt;
			}
	
	//��ǰ���� �߰�
	public int insertRecordPClass(GoodsVO vo) {
		int cnt=0;
		
		try { //sales(p_sale.s_num, p_code.p_class, product.p_name, product.s_price, remark
			dbConn(); //num, p_class, p_name, s_price, remark) values(num_sq.nextval,?,?,?,?
			String sql ="insert into p_code(p_code,p_class) values(p_code_seq.nextval, ?)";	
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getP_class());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("��ǰ���� �߰����� �߻�...");
			e.printStackTrace();		
			}finally {
			dbClose();
		}
		return cnt;	
	}
	//��ǰ���� ��� �ҷ�����
	public List<String> allRecordPClass(){
		List<String> list = new ArrayList<String>();
		try {
			//1.db���� 
			dbConn();
			String sql = "select p_class from p_code";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1)); 
			
			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return list;
	}
	
	//��ǰ���� ����
	public int deleteRecordPClass(String p_class) {
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from p_code where p_class=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p_class); //�������� ù��° ����ǥ
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("��ǰ���� ���� �߻�...");
		}finally {
			dbClose();
		}
		return cnt;
	}	
	
	//������(����������+�԰����-�Ǹż��� �հ�)
	public int updateRecordPstock(GoodsVO vo){
		//�� �� �����������ٰ� ������ ���ָ� ��
		//select p_code from p_code where p_class =?
		int cnt=0;
		try { //select p_code from p_code where p_class =?
			//GoodsCheck gc = new GoodsCheck();
			
			dbConn(); ///////?������ �ٽ� �����
			//select u_no, name, gender, id, to_char(write_date,'YYYY-MM-DD')write_date,pc_use,pay,remark from users
			//update product set p_stock=((select p_stock from product where p_name='�ݶ�') + 5 -(select s_cnt from p_sale where p_name='�ݶ�'))
			//where p_name='�ݶ�';
			
			//update product set final_stock=((select p_stock from product where p_name=?) + ? -(select s_cnt from p_sale where p_name=?))where p_name=?
			
		//	"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='��Ĩ')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='��Ĩ')where p_name='��Ĩ';
					// -(select s_cnt from p_sale where p_name=?)) //�Ǹż��� ���̳ʽ� 
			String sql = "update product set p_stock=((select p_stock from product where p_name=?)"
					+ " + (select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name=?))"
					+ " where p_name=?";//�����ʹ� vo�� ����
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getP_name());
			//pstmt.setInt(2, vo.getE_cnt());
			pstmt.setString(2, vo.getP_name());
			pstmt.setString(3, vo.getP_name());
		
			//int ecnt = Integer.parseInt(gc.twoTf1.getText());
			
			
			
//			pstmt.setInt(1, vo.getP_stock());//ù��° ����ǥ -> pstock(��������)
//			pstmt.setInt(2, vo.getE_cnt());//�ι�° ����ǥ -> e_cnt(�԰����)
//			pstmt.setInt(3, vo.getS_cnt());//����° ����ǥ -> s_cnt(�Ǹż���)
//			pstmt.setString(4, vo.getP_name());
//			
		//pstmt.setString(4, vo.getName());
		//pstmt.setInt(4, vo.getNum());
					
			cnt = pstmt.executeUpdate();
			
			
			System.out.println(vo.getP_stock());
		}catch(Exception e) {
			System.out.println("������ ���� �߻� ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
		
	}	
	public void setStock(String pname, int stock) {
		
		try { 
			dbConn(); ///////?������ �ٽ� �����
		
			//"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='��Ĩ')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='��Ĩ')where p_name='��Ĩ';
					// -(select s_cnt from p_sale where p_name=?)) //�Ǹż��� ���̳ʽ� 
			String sql = "update product set p_stock=? where p_name=?";//�����ʹ� vo�� ����
			//update product set  p_name=? s_price=? p_code=(select p_code from p_code where p_class = ?)? p_stock=0; where p_name=?;
			pstmt = conn.prepareStatement(sql);
			//String pname ;
			pstmt.setInt(1, stock);
			pstmt.setString(2, pname);
			pstmt.executeUpdate();
			
			
			//rs.getInt(1);
		}catch(Exception e) {
			System.out.println("������ ���� �߻� ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}
	
	public int getE_cnt(String pname) {
		int result =0;
		try { 
			dbConn(); ///////?������ �ٽ� �����
		
			//"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='��Ĩ')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='��Ĩ')where p_name='��Ĩ';
					// -(select s_cnt from p_sale where p_name=?)) //�Ǹż��� ���̳ʽ� 
			String sql = "select e_cnt from p_enter where p_name=?";//�����ʹ� vo�� ����
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
			System.out.println("������ ���� �߻� ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}
	
	public int getS_cnt(String pname) {
		int result =0;
		try { 
			dbConn(); ///////?������ �ٽ� �����
		
			//"update product set p_stock=(?+?-?) where p_name=?"
			//update product set p_stock=
					//(select p_stock from product where p_name='��Ĩ')+
					//(select pe.e_cnt from p_enter pe join product pd on pe.p_name=pd.p_name and pd.p_name='��Ĩ')where p_name='��Ĩ';
					// -(select s_cnt from p_sale where p_name=?)) //�Ǹż��� ���̳ʽ� 
			String sql = "select s_cnt from p_sale where p_name=?";//�����ʹ� vo�� ����
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
			System.out.println("������ ���� �߻� ");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return result;
	}
	
	


/*
//1.db���� 
dbConn(); //select pe.p_name,pd.p_stock + pe.e_cnt as revenue from p_enter pe join product pd on pe.p_name = pd.p_name;
String sql = "select pe.p_name,pd.p_stock + pe.e_cnt as revenue from p_enter pe join product pd on pe.p_name = pd.p_name";
		//"select pd.p_stock + pe.e_cnt-ps.s_cnt as revenue from p_enter pe join product pd on pe.p_name = pd.p_name join p_sale ps on pd.p_name = ps.p_name";//�ʵ�� ��ġ
//2.preparestatement ����
pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
rs = pstmt.executeQuery();
while(rs.next()) {//resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������ false
	GoodsVO vo = new GoodsVO();//vo ������ �����ؾߵǴϱ� while����
	//vo.setNum(rs.getInt(1)); //mem_no(String sql �迭 index 1)
	
	
	vo.setP_stock(vo.getP_stock());
	
	
	
	//vo.setRemark(rs.getString(6));
	list.add(vo); //��������� �����ϴ� list�� ����

	
	
	//GoodsVO vo = new GoodsVO();//vo ������ �����ؾߵǴϱ� while����
	//vo.setNum(rs.getInt(1)); //mem_no(String sql �迭 index 1)
	
	//vo.setRemark(rs.getString(6));
	list.add(); //��������� �����ϴ� list�� ����

*/


}
