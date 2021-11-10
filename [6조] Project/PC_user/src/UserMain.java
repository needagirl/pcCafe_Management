import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserMain extends JFrame implements ActionListener {
	JButton foodsBtn = new JButton("¸Ô°Å¸® ÁÖ¹®");
	Font font = new Font("¸¼Àº °íµñ", Font.BOLD, 25);
	Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
	String uNo = "";
	String PcNo = "";
	String userId = "";
	final int DEFAULT_PAYMENT = 2000;
	String result;
	UserMain_UseInfo ui;
	public UserMain() {
		add(foodsBtn);
		foodsBtn.setFont(font);
		foodsBtn.setBackground(new Color(124, 124, 124));
		foodsBtn.setForeground(Color.white);
		foodsBtn.setBorderPainted(false);
		foodsBtn.setFocusable(false);
		setLocation((int)(dimen.getWidth()/2 - 180/2), 50);

		setSize(180, 70);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);

		foodsBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventBtn = e.getActionCommand();
		if (eventBtn.equals("¸Ô°Å¸® ÁÖ¹®")) {
			userOrderDialog();
			ui.sendMessage("*MG$"+userId+"_"+result);
		}
	}
	
	public void userOrderDialog() {
		UserOrder uo = new UserOrder();

		uo.setSize(1250, 650);
		uo.setResizable(false);
		uo.setVisible(true);
		result = uo.result;
	}
	

	public void openDialogs() {
		UserMain_IconTabDialog();
		UserMain_UseInfoDialog();
	}

	public void UserMain_UseInfoDialog() {
		Date currentTime = new Date();		
		PcVo pcVo = new PcVo();
		PcDAO pcDao = new PcDAO();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.HOUR, 2);
		pcVo.setPcNo(1);
		pcVo.setuNo(2);
		pcVo.setPay(DEFAULT_PAYMENT);
		pcVo.setStartTime(currentTime);
		pcVo.setEndTime(cal.getTime());
		pcVo.setManager("Á¤Á÷¿ø");
		pcVo.setPcUse(1);
		pcDao.insertPcInfo(pcVo);
								
		ui = new UserMain_UseInfo(PcNo, userId);
		
		JDialog dl = new JDialog();
		dl.add(ui);
		dl.setBounds((int)dimen.getWidth()-400, 0, 400, 500);
		dl.setUndecorated(true);
		dl.setVisible(true);
	}

	public void UserMain_IconTabDialog() {
		UserMain_IconTab it = new UserMain_IconTab();
		JDialog dl = new JDialog();
		dl.add(it);
		dl.setBounds((int)(dimen.getWidth()/2 - 1300/2), ((int)(dimen.getHeight()-200)), 1300, 100);
		dl.setUndecorated(true);
		dl.setVisible(true);
	}
	public void setUserNo(String uNo) {
		this.uNo = uNo;
	}
	
	public void setPcNo(String PcNo) {
		this.PcNo = PcNo;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static void main(String[] args) {
		new UserMain().openDialogs();
	}

}
