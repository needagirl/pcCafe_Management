
public class GoodsVO {//상품관리 vo
	private int s_num; //구분
	private String p_class;//상품구분
	private String p_name;//상품명
	private int s_price;//판매금액
	private int p_stock;//현재 재고수량
	private String remark;//상품메모
	private int p_num; //상품명번호
	
	
	private int e_cnt; //입고수량
	private int s_cnt;//판매수량
	private int final_stock; //최종재고수량 
	
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
