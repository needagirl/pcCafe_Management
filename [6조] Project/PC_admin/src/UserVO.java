
public class UserVO {//ȸ������ vo
	private int u_no; //ȸ����ȣ
	private String name;//ȸ���̸�
	private int sex;//����
	private String id;//���̵�
	private String write_date;//ȸ�������
	private int pc_use;//�� �̿�ð�
	private int pay ;//�� �̿�ݾ�
	private String remark;//���
	
	private String pwd;  //��й�ȣ
	private String addr;		//�ּ�
	private String birth;	//�������
	private String tel;	//����ó
		//�ܿ��ð� (����ð�-���۽ð�-�̿�ð�)
	
	public UserVO() {

	}


	public int getU_no() {
		return u_no;
	}

	public void setU_no(int u_no) {
		this.u_no = u_no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSex() {
		return sex;
	}


	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getWrite_date() {
		return write_date;
	}


	public void setWrite_date(String write_date) {
		this.write_date = write_date;
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


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}

