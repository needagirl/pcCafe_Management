
public class PcVO {
 private int pc_num; //����
 private int pc_no; //PC��ȣ
 private int u_no; //�����(ȸ����ȣ)
 private int pc_use; //�̿�ð�
 private int pay; //���ݾ�
 private String pc_start; //���۽ð�
 private String pc_end; //����ð�
 private String manager; //������
 
	public PcVO() {
		
	}

	public int getPc_num() {
		return pc_num;
	}

	public void setPc_num(int pc_num) {
		this.pc_num = pc_num;
	}

	public int getPc_no() {
		return pc_no;
	}

	public void setPc_no(int pc_no) {
		this.pc_no = pc_no;
	}

	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}