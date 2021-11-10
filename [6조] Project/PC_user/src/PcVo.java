import java.util.Date;
import java.sql.Timestamp;

public class PcVo {
	private int pcNo;
	private int uNo;
	private int pay = 0;
	private int pcUse;
	private Date startTime;
	private Date endTime;
	private String manager;
		
	public int getPcNo() {
		return pcNo;
	}

	public void setPcNo(int pcNo) {
		this.pcNo = pcNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getPcUse() {
		return pcUse;
	}

	public void setPcUse(int pcUse) {
		this.pcUse = pcUse;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public Timestamp getStartTimeTimestamp() {
		return new java.sql.Timestamp(this.startTime.getTime());
	}
	
	public Timestamp getEndTimeTimestamp() {
		return new java.sql.Timestamp(this.endTime.getTime());
	}

	public PcVo() {
	}

}
