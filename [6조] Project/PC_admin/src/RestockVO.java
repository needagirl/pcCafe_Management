
public class RestockVO { //입고관리 vo
	private int e_num;//구분
	private String p_class;//상품구분
	private String p_name;//상품명
	private int e_cnt;//입고수량
	private int e_price;//입고가격
	private String e_date;//입고날짜
	private int expiry ;//유통기한
	private String remark;//입고메모
	private String manager;//관리자
	
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
