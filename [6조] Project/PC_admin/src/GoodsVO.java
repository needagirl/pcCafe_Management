
public class GoodsVO {//��ǰ���� vo
	private int s_num; //����
	private String p_class;//��ǰ����
	private String p_name;//��ǰ��
	private int s_price;//�Ǹűݾ�
	private int p_stock;//���� ������
	private String remark;//��ǰ�޸�
	private int p_num; //��ǰ���ȣ
	
	
	private int e_cnt; //�԰����
	private int s_cnt;//�Ǹż���
	private int final_stock; //���������� 
	
	public GoodsVO() {
	}
	
	
	public int getFinal_stock() {
		return final_stock;
	}


	public void setFinal_stock(int final_stock) {
		this.final_stock = final_stock;
	}


	public int getS_num() {
		return s_num;
	}


	public void setS_num(int s_num) {
		this.s_num = s_num;
	}


	public String getP_class() {
		return p_class;
	}

	public void setP_class(String p_class) {
		this.p_class = p_class;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	public int getP_stock() {
		return p_stock;
	}

	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getE_cnt() {
		return e_cnt;
	}


	public void setE_cnt(int e_cnt) {
		this.e_cnt = e_cnt;
	}


	public int getS_cnt() {
		return s_cnt;
	}


	public void setS_cnt(int s_cnt) {
		this.s_cnt = s_cnt;
	}
	
}
