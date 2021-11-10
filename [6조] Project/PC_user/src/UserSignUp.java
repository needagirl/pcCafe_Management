import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UserSignUp extends JDialog implements ActionListener {
	JPanel jpNorth = new JPanel(new BorderLayout());
	JLabel notice = new JLabel("                                 ¾Æ·¡ÀÇ È¸¿ø°¡ÀÔ¶õ¿¡ ÀÔ·ÂÇÏ¼¼¿ä.");

	JPanel jpWest = new JPanel(new BorderLayout());
	JPanel s1 = new JPanel(new GridLayout(8, 2));
	JPanel row1 = new JPanel(new GridLayout(1, 3));
	JPanel idPane = new JPanel();
	JPanel idLabel = new JPanel();
	JLabel id = new JLabel("          *¾ÆÀÌµð:");
	JPanel passwordPane = new JPanel();
	JLabel password = new JLabel("       *ºñ¹Ð¹øÈ£:");
	JLabel checkpassword = new JLabel(" *ºñ¹Ð¹øÈ£ È®ÀÎ:");
	JLabel name = new JLabel("             *ÀÌ¸§:");
	JLabel gen = new JLabel("              ¼ºº°:");
	JLabel tel = new JLabel("            ÇÚµåÆù:");
	JLabel addr = new JLabel("               ÁÖ¼Ò:");
	JLabel birth = new JLabel("         *»ý³â¿ùÀÏ:");

	JPanel jpSouth = new JPanel(new BorderLayout());
	JPanel s2 = new JPanel(new GridLayout(1, 2));
	JButton regi = new JButton("È¸¿ø°¡ÀÔ ¿Ï·á");
	JButton quit = new JButton("´Ý±â");

	JPanel jpCenter = new JPanel(new BorderLayout());
	JPanel s3 = new JPanel();
	JTextField tid = new JTextField(20);
	JPasswordField pw = new JPasswordField(20);
	JPasswordField checkpw = new JPasswordField(20);
	JTextField nm = new JTextField();
	JTextField tell = new JTextField(15);
	JTextField ad = new JTextField();

	JPanel bday = new JPanel(new GridLayout(1, 3));
	JTextField b1 = new JTextField();
	JTextField b2 = new JTextField();
	JTextField b3 = new JTextField();

	JButton repetition = new JButton("Áßº¹È®ÀÎ");
	Font fnt = new Font("¸¼Àº°íµñ", Font.BOLD, 6);

	JPanel rBtnGrid = new JPanel(new GridLayout(1, 2));
	JRadioButton rBtn1 = new JRadioButton("³²¼º");
	JRadioButton rBtn2 = new JRadioButton("¿©¼º");

	ButtonGroup bg = new ButtonGroup();
	Calendar now = Calendar.getInstance();

	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

	JComboBox<String> monthCombo = new JComboBox<String>();
	DefaultComboBoxModel<String> monthModel;

	JComboBox<String> dayCombo = new JComboBox<String>();
	DefaultComboBoxModel<String> dayModel;

	JLabel idExcep = new JLabel("¾ÆÀÌµð¸¦ °ø¹é ¾øÀÌ ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù");
	JLabel pwExcep = new JLabel("ºñ¹Ð¹øÈ£´Â 6ÀÚ¸® ÀÌ»ó, 20ÀÚ¸® ÀÌÇÏ¸¸ °¡´É");
	JLabel telExcep = new JLabel("¿¬¶ôÃ³´Â ¼ýÀÚ¸¸ ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù");

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public UserSignUp() {
		setLayout(new BorderLayout());

		add(BorderLayout.NORTH, jpNorth);
		jpNorth.add(notice);

		add(BorderLayout.WEST, jpWest);
		jpWest.add(s1);
		s1.add(id);
		id.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		s1.add(password);
		password.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		s1.add(checkpassword);
		checkpassword.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		s1.add(name);
		name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		s1.add(gen);
		gen.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		s1.add(tel);
		tel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		s1.add(addr);
		addr.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		s1.add(birth);
		birth.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));

		s3.setLayout(null);

		add(BorderLayout.CENTER, jpCenter);
		jpCenter.add(s3);
		s3.add(tid);
		tid.setBounds(25, 25, 150, 30);
		s3.add(pw);
		pw.setBounds(25, 85, 150, 30);
		s3.add(pwExcep);
		pwExcep.setBounds(25, 110, 250, 30);
		s3.add(checkpw);
		checkpw.setBounds(25, 145, 150, 30);
		s3.add(nm);
		nm.setBounds(25, 210, 150, 30);

		bg.add(rBtn1);
		bg.add(rBtn2);

		rBtnGrid.add(rBtn1);
		rBtnGrid.add(rBtn2);

		s3.add(rBtnGrid);
		rBtnGrid.setBounds(25, 273, 150, 30);

		s3.add(tell);
		tell.setBounds(25, 340, 150, 30);

		s3.add(ad);
		ad.setBounds(26, 405, 195, 30);
		s3.add(bday);
		bday.add(b1);
		bday.add(b2);
		bday.add(b3);

		add(BorderLayout.SOUTH, jpSouth);
		jpSouth.add(s2);
		s2.add(regi);
		regi.setFont(new Font("»õ±¼¸²", Font.BOLD, 14));
		regi.setForeground(Color.WHITE);
		regi.setBackground(Color.gray);

		s2.add(quit);
		quit.setFont(new Font("»õ±¼¸²", Font.BOLD, 14));
		quit.setForeground(Color.WHITE);
		quit.setBackground(Color.gray);

		regi.addActionListener(this);

		// ³âµµ ¸®½ºÆ®
		int nowYear = setNowYear();
		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(nowYear); // ÇöÀç ³âµµ ¼±ÅÃ
		s3.add(yearCombo);
		yearCombo.setBounds(25, 465, 60, 30);

		// ¿ù ¸®½ºÆ®
		String[] items = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		monthModel = new DefaultComboBoxModel<String>(items);
		monthCombo.setModel(monthModel);
		s3.add(monthCombo);
		monthCombo.setBounds(105, 465, 50, 30);

		// ÀÏ ¸®½ºÆ®
		String[] dayList = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		dayModel = new DefaultComboBoxModel<String>(dayList);
		dayCombo.setModel(dayModel);
		s3.add(dayCombo);
		dayCombo.setBounds(175, 465, 50, 30);

		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		/*
		 * bday.add(yearLbl);
		 * 
		 * //¿ù ¸®½ºÆ® int nowMonth = setNowMonth(); monthCombo.setModel(monthModel);
		 * monthCombo.setSelectedItem(nowMonth+1); bday.add(monthCombo);
		 * 
		 * //ÀÏ ¸®½ºÆ®
		 * 
		 * int nowDay = setNowDay(); dayCombo.setModel(dayModel);
		 * dayCombo.setSelectedItem(nowDay); bday.add(dayCombo);
		 */

		/*
		 * int lastDay = 31; switch(month){ case 4: case 6: case 9: case 11: lastDay=30;
		 * break;
		 * 
		 * case 2: //³âµµ°¡ 4·Î ³ª´©¾îÁö°í 100À¸·Î ³ª´©¾îÁöÁö ¾ÊÀ¸¸é À±³â //400À¸·Î ³ª´©¾îÁö¸é À±³â
		 * 
		 * if(year%4==0 && year%100!=0 || year%400==0){ lastDay = 29; }else{ lastDay =
		 * 28; } }
		 */
	}

	public int getData() {
		int gender = 0;
		int result = 0;
		UserVO vo = new UserVO();

		vo.setId(tid.getText());
		vo.setPwd(pw.getText());
		vo.setName(nm.getText());
		if (rBtn1.isSelected()) {
			gender = 1;
		} else if (rBtn2.isSelected()) {
			gender = 2;
		}
		vo.setSex(gender);
		vo.setTel(tell.getText());
		vo.setAddr(ad.getText());

		String yc, mc, dc;
		yc = String.valueOf(yearCombo.getSelectedItem());
		mc = String.valueOf(monthCombo.getSelectedItem());
		dc = String.valueOf(dayCombo.getSelectedItem());

		vo.setBirth(yc + mc + dc);

		SignUpDAO dao = new SignUpDAO();
		int cnt = dao.UserInfo(vo);

		String pw2 = new String(pw.getPassword());
		String pw3 = new String(checkpw.getPassword());
		String id = tid.getText();
		String name = nm.getText();

		if (!id.matches("^[A-Za-z[0-9]]*$")) {
			JOptionPane.showMessageDialog(this, "¾ÆÀÌµð´Â ¿µ¹®°ú ¼ýÀÚ¸¸ »ç¿ë°¡´ÉÇÕ´Ï´Ù");

		} else if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù");

		} else if (pw2.equals("") || pw2 == null) {
			JOptionPane.showMessageDialog(this, "ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù");
		} else if (pw2.length() < 6 || pw2.length() > 20) {
			JOptionPane.showMessageDialog(this, "ºñ¹Ð¹øÈ£´Â 6ÀÚ¸® ÀÌ»ó, 20ÀÚ¸® ÀÌÇÏ¸¸ °¡´É ÇÕ´Ï´Ù.");
//		} else if (!pw2.equals("([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]")) {
//			JOptionPane.showMessageDialog(this, "ºñ¹Ð¹øÈ£´Â Æ¯¼ö¹®ÀÚ[$@!%*#?&]¸¦ Æ÷ÇÔÇØ ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù.");
		} else if (!pw2.equals(pw3)) {
			JOptionPane.showMessageDialog(this, "ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù");
		} else if (!name.matches(".*[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+.*")) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§(ÇÑ±Û)À» ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù");
		} else if (tell.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "¿¬¶ôÃ³¸¦ ÀÔ·ÂÇÏ¼Å¾ß ÇÕ´Ï´Ù");
		}else {
			result = 1;
			
		}
		return result;
	}

	public int setNowYear() {
		int year = now.get(Calendar.YEAR);
		// for(int y = year-100; y<=year+20; y++) {
		for (int y = year + 20; y >= year - 100; y--) {
			yearModel.addElement(y);
		}
		return year;
	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		String eventBtn = e.getActionCommand();
		if (event == quit) {
			dispose();
		} else if (eventBtn.equals("È¸¿ø°¡ÀÔ ¿Ï·á")) {
			int result = getData();
			if(result==1) {
				dispose();
			}

			// UserSignUpDialog.setVisible(false);

			/*
			 * String a=String.valueOf(yearCombo.getSelectedItem()); String
			 * b=String.valueOf(monthCombo.getSelectedItem()); String
			 * c=String.valueOf(dayCombo.getSelectedItem()); String result =a+b+c;
			 * 
			 * System.out.println(result);
			 */
		}

	}

}

//		setSize(400, 600);
//		setVisible(true);
//		setLocationRelativeTo(null);
//		setResizable(false);