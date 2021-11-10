import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserMain_UseInfo extends JPanel implements ActionListener {
	JPanel centerPane = new JPanel(new GridLayout(2, 1));
	JPanel northPane = new JPanel(new BorderLayout());
	JPanel northGrid = new JPanel(new GridLayout(1, 2));
	JPanel setbtns = new JPanel(new BorderLayout());
	JPanel btns = new JPanel(new GridLayout(1, 2));
	JButton b1 = new JButton("관리자채팅");

	JButton b3 = new JButton("로그아웃");

	JPanel norWeGrid = new JPanel(new GridLayout(5, 2));
	JLabel no = new JLabel(" 좌석번호:");
	JLabel id = new JLabel(" 회원아이디:");
	JLabel usedtime = new JLabel(" 사용시간:");
	JLabel lefttime = new JLabel(" 남은시간:");
	JLabel paid = new JLabel(" 선불요금:");

	JPanel norEaGrid = new JPanel(new GridLayout(5, 2));
	JLabel noinfo = new JLabel("");
	JLabel idinfo = new JLabel("");
	JLabel usedtimeinfo = new JLabel();
	JLabel lefttimeinfo = new JLabel();
	JLabel paidinfo = new JLabel("2000원");

	JPanel ep = new JPanel(new GridLayout(2, 1));
	JPanel p1 = new JPanel(new BorderLayout());

	ImageIcon adIcon = new ImageIcon("img/kart.jpg");
	JButton kart = new JButton(adIcon);

	Socket socket;
	BufferedReader br;
	PrintWriter pw;
	JTextField msgTf = new JTextField();
	JTextArea msgTa = new JTextArea();
	JScrollPane sp = new JScrollPane(msgTa);
	String result;
	String userId;
	public UserMain_UseInfo(String PcNo, String userId) {
		setLayout(new BorderLayout());
		this.userId = userId;
		add(centerPane);
		centerPane.add(BorderLayout.NORTH, northPane);
		northPane.add(BorderLayout.SOUTH, setbtns);
		setbtns.add(btns);
		btns.add(b1);
		b1.setFont(new Font("새굴림", Font.BOLD, 15));
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.gray);
		btns.add(b3);
		b3.setFont(new Font("새굴림", Font.BOLD, 15));
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.gray);

		northPane.add(northGrid);
		northGrid.add(norWeGrid);
		norWeGrid.add(no);
		no.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norWeGrid.add(id);
		id.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norWeGrid.add(usedtime);
		usedtime.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norWeGrid.add(lefttime);
		lefttime.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norWeGrid.add(paid);
		paid.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		northGrid.add(norEaGrid);
		norEaGrid.add(noinfo);
		noinfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norEaGrid.add(idinfo);
		idinfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norEaGrid.add(usedtimeinfo);
		usedtimeinfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norEaGrid.add(lefttimeinfo);
		lefttimeinfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		norEaGrid.add(paidinfo);
		paidinfo.setFont(new Font("맑은 고딕", Font.BOLD, 13));

		centerPane.add(kart);
		b1.addActionListener(this);
		b3.addActionListener(this);

		noinfo.setText(PcNo);
		idinfo.setText(userId);

		MyTimer leftTimer = new MyTimer(2, 0, 0);
		leftTimer.setOutputLabel(this.lefttimeinfo);
		leftTimer.descStart();
		MyTimer timer = new MyTimer(0, 0, 0);
		timer.setOutputLabel(this.usedtimeinfo);
		timer.incStart();

		try {
			socket = new Socket("192.168.7.15", 7777);
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			pw.println(userId);
			Receiver receiver = new Receiver(socket);
			receiver.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		kart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					Desktop.getDesktop().browse(new URI("http://kart.nexon.com/"));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}

		});

	}
	public void sendMessage(String msg) {
		if(!msg.equals("")) {
			pw.println(msg);
			pw.flush();
		}
	}
	class ClientFrame extends JDialog implements ActionListener{
		public ClientFrame() {

			setLayout(new BorderLayout());

			add(sp);
			add(BorderLayout.SOUTH, msgTf);
			msgTf.addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {
			String sendMsg = msgTf.getText();
			msgTa.append(userId +" : " + sendMsg + "\n");
			pw.println(userId+ " : " + sendMsg);
			pw.flush();
			msgTf.setText("");
		}

	}
	
	public void chatDialog() {
		ClientFrame uo = new ClientFrame();

		uo.setSize(400, 400);
		uo.setResizable(false);
		uo.setVisible(true);

	}
	class Receiver extends Thread {
		//필요한 변수를 멤버변수에 등록
		Socket s;
		BufferedReader br;
		PrintWriter pw;

		Receiver() {
		}
		//소켓을 매개변수로 받아서 연결하는 기능
		public Receiver(Socket socket) {
			this.s = socket;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//thread의 run함수에는 메세지를 계속 받을수 있게 입력을 열어둠
		public synchronized void run() {
			while (br != null) {
				try {
					String msg = br.readLine();
					msgTa.append(msg + "\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getActionCommand();
		if (event.equals("관리자채팅")) {
			chatDialog();
		}else if(event.equals("로그아웃")) {
			System.exit(0);
		}

	}
}
