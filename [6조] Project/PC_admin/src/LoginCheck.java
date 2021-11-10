import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginCheck extends JFrame implements ActionListener {

	JPanel centPane = new JPanel();
	JLabel b1 = new JLabel("ADMIN LOGIN");
	JLabel j1 = new JLabel("ID : ");
	JLabel j2 = new JLabel("PASSWORD : ");
	JTextField t1 = new JTextField(30);
	JPasswordField t2 = new JPasswordField(30);
	JButton b2 = new JButton("CLICK");
	JButton b3 = new JButton("X");

	public LoginCheck() {
		super("★ 관리자 로그인 ★");
		add(centPane);
		centPane.setBackground(Color.DARK_GRAY);
		centPane.setLayout(null);

		j1.setBounds(680, 400, 300, 50);
		j2.setBounds(620, 450, 300, 50);
		t1.setBounds(710, 400, 300, 45);
		t2.setBounds(710, 450, 300, 45);
		b1.setBounds(410, 400, 150, 95);
		b2.setBounds(1030, 399, 110, 95);
		b3.setBounds(493, 442, 10, 10);

		b3.setBackground(Color.DARK_GRAY);
		b2.setBackground(Color.gray);
		b1.setBackground(Color.DARK_GRAY);
		b2.setForeground(Color.white);
		j1.setForeground(Color.white);
		j2.setForeground(Color.white);
		b1.setForeground(Color.red);

		centPane.add(t1);
		centPane.add(t2);
		centPane.add(b1);
		centPane.add(b2);
		centPane.add(b3);
		centPane.add(j1);
		centPane.add(j2);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		t1.addActionListener(this);
		t2.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		JOptionPane op = new JOptionPane();
		String str = ae.getActionCommand();
		if (str.equals("CLICK")) {
			String data = new String(t2.getPassword());

			if (t1.getText().equals("6bit") && data.equals("6666")) {
				JOptionPane.showMessageDialog(this, "관리자 로그인 되었습니다.");
				SeatCheck sc = new SeatCheck();
				sc.setSize(1250, 650);
				sc.setResizable(false);
				sc.setVisible(true);
				setVisible(false);
			} else if (t1.getText().equals("bit6") && data.equals("6636")) {
				JOptionPane.showMessageDialog(this, "매니저 로그인 되었습니다.");
				
				SeatCheck sc = new SeatCheck();
				sc.setVisible(true);
				
//				if(ae.equals(JOptionPane.OK_OPTION)) {
//				dispose();
//				}
//				int mk = op.showConfirmDialog(this,"매니저 로그인 되었습니다.","★로그인 성공★",JOptionPane.OK_OPTION);
//				if(mk == JOptionPane.OK_OPTION ) {
				setVisible(false);
//				}

			} else {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 제대로 입력하세요!");
				t1.setText("");
				t2.setText("");
//				int no = op.showConfirmDialog(this,"이름과 비밀번호를 제대로 입력하세요!","★로그인 실패★",JOptionPane.OK_OPTION);
//				if(no != JOptionPane.OK_OPTION) {
//					
//				}
			}

		}
		if (str.equals("X")) {
			System.exit(0);
		}

	}

	public void startAdminMenu() {
		SeatCheck sc = new SeatCheck();
		
	}

	public static void main(String[] args) {
		new LoginCheck();
	}
}
