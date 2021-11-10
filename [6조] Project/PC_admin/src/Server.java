import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame implements ActionListener {
	// ä���� �� textfield�� area ���� �� ������븦 ���� ���� combo�ڽ� ����
	JTextField msgTf = new JTextField();
	JTextArea msgTa = new JTextArea();
	JScrollPane sp = new JScrollPane(msgTa);
	JPanel pane = new JPanel(new BorderLayout());
	JComboBox<String> combo = new JComboBox<String>();

	// ��Ĺ���� ����� ��ġ ����
	BufferedReader br;
	PrintWriter pw;
	ServerSocket serverSocket;

	// ������� ������ ���� list����

	List<Receiver> connList = new ArrayList<Receiver>();

	public Server() {
		try {
			//�����ӿ� ������Ʈ �߰� �� ������ ����
			add(sp);
			add(BorderLayout.SOUTH, pane);
			pane.add(BorderLayout.WEST, combo);
			pane.add(msgTf);
			msgTf.addActionListener(this);
			//msgTa.setPreferredSize(new Dimension(200,200));
			
			setSize(400, 400);
			setVisible(true);
			//setDefaultCloseOperation(DISPOSE_ON_CLOSE);

			//������ ��� ����ڰ� ���� �� �� �ֵ��� ��
			serverSocket = new ServerSocket(7777);
			while (true) {
				msgTa.append("���� �����\n");
				Socket socket = serverSocket.accept();
				msgTa.append(socket.getInetAddress() + "���� �����Ͽ����ϴ�.\n");
				
				//���� ������� ������ �ޱ����� Receiver �żҵ� ������ 
				Receiver receiver = new Receiver(socket);
				//����� ���� ����
				connList.add(receiver);
				//����� ���� �޺��ڽ��� �߰�
				combo.addItem(receiver.id);
				//���ΰ�ħ������ �־����� �ʿ���� ��� ���� ����
				pane.add(BorderLayout.WEST, combo);
				//Thread ����� start
				receiver.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//enter�� ġ�� ���� �޺��ڽ��� �ִ� index ���� ������
		int idx = combo.getSelectedIndex();
		//index���� ������ list�� �ִ� id�� ������ ���߿� ����� id�� ��ü
		String id = connList.get(idx).id;
		//����� ��ġ�� ���� ������� �ֱ� ������ �� ����ڿ��� ���� �� �ִ� ��ġ �ҷ�����
		Receiver rec = connList.get(idx);
		//textfield�� �ִ� �޼��� �������
		String sendMsg = msgTf.getText();
		//������ ���̰� �ϱ�
		msgTa.append(id + "���� : " + sendMsg + "\n");
		try {
			//������ �����ġ rec�� pw����� �̿��ؼ� �޼��� ������
			rec.pw.println("ī���� : " + sendMsg);
			rec.pw.flush();
		} catch (Exception ea) {
			//����ڰ� ���ٴ� ���ܰ� �� ��� ����� ����
			connList.remove(idx);
		}
		msgTf.setText("");
	}

	//Thread�� ��ӹޱ� ���� Receiver class�� ������
	class Receiver extends Thread {
		//�ʿ��� ������ ��������� ���
		Socket s;
		String id;
		BufferedReader br;
		PrintWriter pw;

		Receiver() {
		}
		//������ �Ű������� �޾Ƽ� �����ϴ� ���
		public Receiver(Socket socket) {
			this.s = socket;
			id = socket.getInetAddress().getHostAddress();
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		//thread�� run�Լ����� �޼����� ��� ������ �ְ� �Է��� �����
		public void run() {
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

	public static void main(String[] args) {
		new Server();
	}

}
