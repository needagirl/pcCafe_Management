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
	JLabel notice = new JLabel("                                 아래의 회원가입란에 입력하세요.");

	JPanel jpWest = new JPanel(new BorderLayout());
	JPanel s1 = new JPanel(new GridLayout(8, 2));
	JPanel row1 = new JPanel(new GridLayout(1, 3));
	JPanel idPane = new JPanel();
	JPanel idLabel = new JPanel();
	JLabel id = new JLabel("          *아이디:");
	JPanel passwordPane = new JPanel();
	JLabel password = new JLabel("       *비밀번호:");
	JLabel checkpassword = new JLabel(" *비밀번호 확인:");
	JLabel name = new JLabel("             *이름:");
	JLabel gen = new JLabel("              성별:");
	JLabel tel = new JLabel("            핸드폰:");
	JLabel addr = new JLabel("               주소:");
	JLabel birth = new JLabel("         *생년월일:");

	JPanel jpSouth = new JPanel(new BorderLayout());
	JPanel s2 = new JPanel(new GridLayout(1, 2));
	JButton regi = new JButton("회원가입 완료");
	JButton quit = new JButton("닫기");

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

	JButton repetition = new JButton("중복확인");
	Font fnt = new Font("맑은고딕", Font.BOLD, 6);

	JPanel rBtnGrid = new JPanel(new GridLayout(1, 2));
	JRadioButton rBtn1 = new JRadioButton("남성");
	JRadioButton rBtn2 = new JRadioButton("여성");

	ButtonGroup bg = new ButtonGroup();
	Calendar now = Calendar.getInstance();

	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

	JComboBox<String> monthCombo = new JComboBox<String>();
	DefaultComboBoxModel<String> monthModel;

	JComboBox<String> dayCombo = new JComboBox<String>();
	DefaultComboBoxModel<String> dayModel;

	JLabel idExcep = new JLabel("아이디를 공백 없이 입력하셔야 합니다");
	JLabel pwExcep = new JLabel("비밀번호는 6자리 이상, 20자리 이하만 가능");
	JLabel telExcep = new JLabel("연락처는 숫자만 입력하셔야 합니다");

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
		id.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		s1.add(password);
		password.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		s1.add(checkpassword);
		checkpassword.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		s1.add(name);
		name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		s1.add(gen);
		gen.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		s1.add(tel);
		tel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		s1.add(addr);
		addr.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		s1.add(birth);
		birth.setFont(new Font("맑은 고딕", Font.BOLD, 12));

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
		regi.setFont(new Font("새굴림", Font.BOLD, 14));
		regi.setForeground(Color.WHITE);
		regi.setBackground(Color.gray);

		s2.add(quit);
		quit.setFont(new Font("새굴림", Font.BOLD, 14));
		quit.setForeground(Color.WHITE);
		quit.setBackground(Color.gray);

		regi.addActionListener(this);

		// 년도 리스트
		int nowYear = setNowYear();
		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(nowYear); // 현재 년도 선택
		s3.add(yearCombo);
		yearCombo.setBounds(25, 465, 60, 30);

		// 월 리스트
		String[] items = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		monthModel = new DefaultComboBoxModel<String>(items);
		monthCombo.setModel(monthModel);
		s3.add(monthCombo);
		monthCombo.setBounds(105, 465, 50, 30);

		// 일 리스트
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
		 * //월 리스트 int nowMonth = setNowMonth(); monthCombo.setModel(monthModel);
		 * monthCombo.setSelectedItem(nowMonth+1); bday.add(monthCombo);
		 * 
		 * //일 리스트
		 * 
		 * int nowDay = setNowDay(); dayCombo.setModel(dayModel);
		 * dayCombo.setSelectedItem(nowDay); bday.add(dayCombo);
		 */

		/*
		 * int lastDay = 31; switch(month){ case 4: case 6: case 9: case 11: lastDay=30;
		 * break;
		 * 
		 * case 2: //년도가 4로 나누어지고 100으로 나누어지지 않으면 윤년 //400으로 나누어지면 윤년
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
			JOptionPane.showMessageDialog(this, "아이디는 영문과 숫자만 사용가능합니다");

		} else if (id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하셔야 합니다");

		} else if (pw2.equals("") || pw2 == null) {
			JOptionPane.showMessageDialog(this, "비밀번호를 입력하셔야 합니다");
		} else if (pw2.length() < 6 || pw2.length() > 20) {
			JOptionPane.showMessageDialog(this, "비밀번호는 6자리 이상, 20자리 이하만 가능 합니다.");
//		} else if (!pw2.equals("([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9]")) {
//			JOptionPane.showMessageDialog(this, "비밀번호는 특수문자[$@!%*#?&]를 포함해 입력하셔야 합니다.");
		} else if (!pw2.equals(pw3)) {
			JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다");
		} else if (!name.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
			JOptionPane.showMessageDialog(this, "이름(한글)을 입력하셔야 합니다");
		} else if (tell.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "연락처를 입력하셔야 합니다");
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
		} else if (eventBtn.equals("회원가입 완료")) {
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