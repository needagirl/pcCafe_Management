
public class RestockVO { //�԰���� vo
	private int e_num;//����
	private String p_class;//��ǰ����
	private String p_name;//��ǰ��
	private int e_cnt;//�԰����
	private int e_price;//�԰���
	private String e_date;//�԰�¥
	private int expiry ;//�������
	private String remark;//�԰�޸�
	private String manager;//������
	
	public RestockVO() {
		
	}

	public int getE_Num() {
		return e_num;
	}


	public void setE_Num(int e_num) {
		this.e_num = e_num;
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

	public int getE_cnt() {
		return e_cnt;
	}

	public void setE_cnt(int e_cnt) {
		this.e_cnt = e_cnt;
	}

	public int getE_price() {
		return e_price;
	}

	public void setE_price(int e_price) {
		this.e_price = e_price;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}



	public int getExpiry() {
		return expiry;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}
