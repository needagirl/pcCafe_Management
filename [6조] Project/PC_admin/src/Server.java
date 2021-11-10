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
	// 채팅을 할 textfield와 area 생성 및 보낼상대를 고르기 위한 combo박스 생성
	JTextField msgTf = new JTextField();
	JTextArea msgTa = new JTextArea();
	JScrollPane sp = new JScrollPane(msgTa);
	JPanel pane = new JPanel(new BorderLayout());
	JComboBox<String> combo = new JComboBox<String>();

	// 소캣에서 사용할 장치 생성
	BufferedReader br;
	PrintWriter pw;
	ServerSocket serverSocket;

	// 사용자의 정보를 담을 list생성

	List<Receiver> connList = new ArrayList<Receiver>();

	public Server() {
		try {
			//프레임에 컴포넌트 추가 및 프레임 설정
			add(sp);
			add(BorderLayout.SOUTH, pane);
			pane.add(BorderLayout.WEST, combo);
			pane.add(msgTf);
			msgTf.addActionListener(this);
			//msgTa.setPreferredSize(new Dimension(200,200));
			
			setSize(400, 400);
			setVisible(true);
			//setDefaultCloseOperation(DISPOSE_ON_CLOSE);

			//소켓을 열어서 사용자가 접근 할 수 있도록 함
			serverSocket = new ServerSocket(7777);
			while (true) {
				msgTa.append("접속 대기중\n");
				Socket socket = serverSocket.accept();
				msgTa.append(socket.getInetAddress() + "에서 접속하였습니다.\n");
				
				//여러 사용자의 정보를 받기위한 Receiver 매소드 생성함 
				Receiver receiver = new Receiver(socket);
				//사용자 정보 저장
				connList.add(receiver);
				//사용자 정보 콤보박스에 추가
				combo.addItem(receiver.id);
				//새로고침용으로 넣었으나 필요없을 경우 제거 가능
				pane.add(BorderLayout.WEST, combo);
				//Thread 실행용 start
				receiver.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//enter를 치면 현재 콤보박스에 있는 index 값을 가져옴
		int idx = combo.getSelectedIndex();
		//index값을 가지고 list에 있는 id를 가져옴 나중에 사용자 id로 교체
		String id = connList.get(idx).id;
		//입출력 장치가 따로 만들어져 있기 때문에 그 사용자에게 보낼 수 있는 장치 불러오기
		Receiver rec = connList.get(idx);
		//textfield에 있는 메세지 가져요기
		String sendMsg = msgTf.getText();
		//나한테 보이게 하기
		msgTa.append(id + "에게 : " + sendMsg + "\n");
		try {
			//가져온 출력장치 rec의 pw출력을 이용해서 메세지 보내기
			rec.pw.println("카운터 : " + sendMsg);
			rec.pw.flush();
		} catch (Exception ea) {
			//사용자가 없다는 예외가 뜰 경우 사용자 삭제
			connList.remove(idx);
		}
		msgTf.setText("");
	}

	//Thread를 상속받기 위해 Receiver class를 생성함
	class Receiver extends Thread {
		//필요한 변수를 멤버변수에 등록
		Socket s;
		String id;
		BufferedReader br;
		PrintWriter pw;

		Receiver() {
		}
		//소켓을 매개변수로 받아서 연결하는 기능
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
		//thread의 run함수에는 메세지를 계속 받을수 있게 입력을 열어둠
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
