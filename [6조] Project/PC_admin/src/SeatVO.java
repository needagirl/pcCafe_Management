
public class SeatVO {
	private String id;//���̵�
	private String pc_start; //���۽ð�
	private String pc_end; //����ð�
	private int pc_use;//���ð�
	private int pay;//�� ���ݾ�(2000+ �Ǹűݾ�)
	private int s_pay;//�Ǹűݾ�
	
	public SeatVO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPc_start() {
		return pc_start;
	}

	public void setPc_start(String pc_start) {
		this.pc_start = pc_start;
	}

	public String getPc_end() {
		return pc_end;
	}

	public void setPc_end(String pc_end) {
		this.pc_end = pc_end;
	}

	public int getPc_use() {
		return pc_use;
	}

	public void setPc_use(int pc_use) {
		this.pc_use = pc_use;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getS_pay() {
		return s_pay;
	}

	public void setS_pay(int s_pay) {
		this.s_pay = s_pay;
	}
	
}
