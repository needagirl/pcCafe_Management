import java.util.ArrayList;
import java.util.List;

public class SeatDAO extends DBCON{

	public SeatDAO() {
		
	}
	
	//id ��������
	public String idGet(){
		String id = "";
		//List<String> list = new ArrayList<String>();
		try {
			//1.db���� 
			dbConn();
			String sql = "select id from userdata where u_no=(select max(u_no) from userdata)";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); 
			rs = pstmt.executeQuery();
			if(rs.next()){
				
				id = rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return id;
	}
	
	//���۽ð� ��������
	public String startTime(){
		String start = "";
		//List<String> list = new ArrayList<String>();
		try {
			//1.db���� 
			dbConn();
			String sql = "select pc_start from pc where pc_num=(select max(pc_num) from pc)";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			if(rs.next()){
				start = rs.getString(1).substring(0,19);

			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return start;
	}
	
	//����ð� ��������
	public String exitTime(){
		String exit = "";
		try {
			//1.db���� 
			dbConn();
			String sql = "select pc_end from pc where pc_num=(select max(pc_num) from pc)";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			if(rs.next()){//resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������ false
				
				exit= rs.getString(1).substring(0,19);
			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return exit;
	}
	
	//��ǰ�Ǹ� -> pc���� pc_no�� ���� ���� ����� pay�� ������..)
	//��ǰ�Ǹ�(�Ǹż��� ��������)
	public String goodsPay(){
		String payed = "";
		//List<String> list = new ArrayList<String>();
		try {
			//1.db���� 
			dbConn();
			String sql = "select pay from pc where pc_num=(select max(pc_num) from pc)";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			if(rs.next()){//resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������ false
			
				int p= (Integer.parseInt(rs.getString(1)));
				int pa = p-2000;
				payed = (String.valueOf(pa));

			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return payed;
	}
	//���� ���ݾ�
	public String Payed(){
		String payed = "";
		try {
			//1.db���� 
			dbConn();
			String sql = "select pay from pc where pc_num=(select max(pc_num) from pc)";//�ʵ�� ��ġ
			//2.preparestatement ����
			pstmt = conn.prepareStatement(sql); //���ڵ� ��ü�����̴ϱ� ����ǥ ����
			rs = pstmt.executeQuery();
			if(rs.next()){//resultset�ȿ� �����Ͱ� ǥ �������� �� ���������, ����Ʈ �̵��޼ҵ�(next)->������ ���� ������ ������ true, ������ false
			
				int p= (Integer.parseInt(rs.getString(1)));
				//int pa = p-2000;
				payed = (String.valueOf(p));
		
			}
		}catch(Exception e) {
			System.out.println("��ǰ��Ȳ ���� �߻� ");
		}finally {
			dbClose();
		}
		return payed;
	}
	
	//���ݾ�
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
