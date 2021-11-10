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
	JButton b1 = new JButton("������ä��");

	JButton b3 = new JButton("�α׾ƿ�");

	JPanel norWeGrid = new JPanel(new GridLayout(5, 2));
	JLabel no = new JLabel(" �¼���ȣ:");
	JLabel id = new JLabel(" ȸ�����̵�:");
	JLabel usedtime = new JLabel(" ���ð�:");
	JLabel lefttime = new JLabel(" �����ð�:");
	JLabel paid = new JLabel(" ���ҿ��:");

	JPanel norEaGrid = new JPanel(new GridLayout(5, 2));
	JLabel noinfo = new JLabel("");
	JLabel idinfo = new JLabel("");
	JLabel usedtimeinfo = new JLabel();
	JLabel lefttimeinfo = new JLabel();
	JLabel paidinfo = new JLabel("2000��");

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
		b1.setFont(new Font("������", Font.BOLD, 15));
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.gray);
		btns.add(b3);
		b3.setFont(new Font("������", Font.BOLD, 15));
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.gray);

		northPane.add(northGrid);
		northGrid.add(norWeGrid);
		norWeGrid.add(no);
		no.setFont(new Font("���� ���", Font.BOLD, 13));
		norWeGrid.add(id);
		id.setFont(new Font("���� ���", Font.BOLD, 13));
		norWeGrid.add(usedtime);
		usedtime.setFont(new Font("���� ���", Font.BOLD, 13));
		norWeGrid.add(lefttime);
		lefttime.setFont(new Font("���� ���", Font.BOLD, 13));
		norWeGrid.add(paid);
		paid.setFont(new Font("���� ���", Font.BOLD, 13));

		northGrid.add(norEaGrid);
		norEaGrid.add(noinfo);
		noinfo.setFont(new Font("���� ���", Font.BOLD, 13));
		norEaGrid.add(idinfo);
		idinfo.setFont(new Font("���� ���", Font.BOLD, 13));
		norEaGrid.add(usedtimeinfo);
		usedtimeinfo.setFont(new Font("���� ���", Font.BOLD, 13));
		norEaGrid.add(lefttimeinfo);
		lefttimeinfo.setFont(new Font("���� ���", Font.BOLD, 13));
		norEaGrid.add(paidinfo);
		paidinfo.setFont(new Font("���� ���", Font.BOLD, 13));

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
		//�ʿ��� ������ ��������� ���
		Socket s;
		BufferedReader br;
		PrintWriter pw;

		Receiver() {
		}
		//������ �Ű������� �޾Ƽ� �����ϴ� ���
		public Receiver(Socket socket) {
			this.s = socket;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//thread�� run�Լ����� �޼����� ��� ������ �ְ� �Է��� �����
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
		if (event.equals("������ä��")) {
			chatDialog();
		}else if(event.equals("�α׾ƿ�")) {
			System.exit(0);
		}

	}
}
