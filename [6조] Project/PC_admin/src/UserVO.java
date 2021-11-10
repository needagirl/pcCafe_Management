
public class UserVO {//회원관리 vo
	private int u_no; //회원번호
	private String name;//회원이름
	private int sex;//성별
	private String id;//아이디
	private String write_date;//회원등록일
	private int pc_use;//총 이용시간
	private int pay ;//총 이용금액
	private String remark;//비고
	
	private String pwd;  //비밀번호
	private String addr;		//주소
	private String birth;	//생년월일
	private String tel;	//연락처
		//잔여시간 (종료시간-시작시간-이용시간)
	
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

