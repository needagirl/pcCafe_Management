
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLogin extends JFrame implements ActionListener, KeyListener {
	JPanel c = new JPanel(new BorderLayout());
	JPanel s = new JPanel(new GridLayout(1, 2));
	JPanel l = new JPanel(new GridLayout(1, 2));
	JPanel r = new JPanel(new GridLayout(1, 4));
	JPanel lbs = new JPanel(new GridLayout(4, 1));
	JLabel id = new JLabel("아이디");
	JLabel pw = new JLabel("비밀번호");
	//JLabel card = new JLabel("비회원(카드번호)");

	JPanel tfs = new JPanel(new GridLayout(4, 1));
	JTextField idtf = new JTextField("", 10);
	JPasswordField pwtf = new JPasswordField("", 20);
	
	//JTextField cdtf = new JTextField("", 12);

	JPanel li = new JPanel();
	JButton login = new JButton("로그인");

	JPanel su = new JPanel();
	JButton signup = new JButton("회원가입");

	JLabel lo = new JLabel();
	
	final String PC_NO = "1";
	Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int)(dimen.getWidth());
	int h = (int)(dimen.getHeight());
	public UserLogin() {
		
		

		
		
		MyPanel mp = new MyPanel();
		mp.setBounds(0, 0, w, h);
		
		add(mp);

		add(BorderLayout.CENTER, c);
		c.add(mp);
		c.setBackground(Color.BLACK);

		ImageIcon icon2 = new ImageIcon("img/logo.png");
		c.add(BorderLayout.SOUTH, s);
		s.add(l);
		l.setBackground(Color.BLACK);
		l.add(lo);
		lo.setIcon(icon2);

		s.add(r);
		r.add(lbs);
		lbs.setBackground(Color.BLACK);
		lbs.add(new JLabel());
		lbs.add(id);
		id.setForeground(Color.WHITE);
		lbs.add(pw);
		pw.setForeground(Color.WHITE);
		lbs.add(new JLabel());
//		lbs.add(card);
//		card.setForeground(Color.WHITE);

		lbs.setOpaque(true);
		
		r.add(tfs);
		tfs.setBackground(Color.black);
		tfs.add(new JLabel());
		tfs.add(idtf);
		tfs.add(pwtf);
		tfs.add(new JLabel());
//		tfs.add(cdtf);

		r.add(li);
		li.setBackground(Color.BLACK);
		li.add(login);
		login.setFont(new Font("새굴림", Font.BOLD, 15));
		login.setForeground(Color.WHITE);
		login.setBackground(Color.gray);
		login.setPreferredSize(new Dimension(100, 100));

		r.add(su);
		su.setBackground(Color.BLACK);
		su.add(signup);
		signup.setFont(new Font("새굴림", Font.BOLD, 15));
		signup.setForeground(Color.WHITE);
		signup.setBackground(Color.gray);
		signup.setPreferredSize(new Dimension(100, 100));

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		signup.addActionListener(this);
		login.addActionListener(this);
		pwtf.addKeyListener(this);


	}

	class MyPanel extends JPanel {
		ImageIcon icon = new ImageIcon("img/003.png");

		Image img = icon.getImage();

		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(img, 0, 0, w,h-170,this); // 1300, 580

		}	
	}
	   
	public void Login() {
		String id = idtf.getText();
		String pwd = pwtf.getText();
		UserDAO dao = new UserDAO();
//		String uNo = dao.IdPwd(id, pwd);
		String uNo = "21";
		if(uNo.equals("")) {
			javax.swing.JOptionPane.showMessageDialog(null, "아이디, 비밀번호가 틀렸습니다.");
		}else {
			UserMain main = new UserMain();
			main.setUserNo(uNo);
			main.setUserId(id);
			main.setPcNo(PC_NO);
			this.setVisible(false);
			main.openDialogs();
		}
	}

	public void SignUpDialog() {
		UserSignUp gu = new UserSignUp();

		gu.setSize(400, 600);
		gu.setVisible(true);
		gu.setResizable(false);
		gu.setLocation(450, 20);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String eventBtn = e.getActionCommand();
		if (eventBtn.equals("회원가입")) {
			SignUpDialog();
		} else if (eventBtn.equals("로그인")) {
			Login();

		}

	}

	public static void main(String[] args) {
		new UserLogin();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int key = e.getKeyCode();
	     if (key == KeyEvent.VK_ENTER) {
	        //Toolkit.getDefaultToolkit().beep(); 
	     Login(); 

	        }

	     }
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
