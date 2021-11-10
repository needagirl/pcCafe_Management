import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;



public class RestockDialog extends JFrame {

	RestockCheck rc = new RestockCheck();
	JDialog d1 = new JDialog(this," ★ 입고관리 ★ ",true);
	public RestockDialog() {
			
				d1.add(rc);
				
				//setExtendedState(JFrame.MAXIMIZED_BOTH);
				d1.setSize(1600, 900);
				
				// 프레임의 사이즈를 구합니다.
				Dimension frameSize = this.getSize();
				// 내 모니터의 크기를 구합니다.
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				
				/*
				* 그래서 프레임의 위치를
				* (모니터화면 가로 - 프레임화면 가로) / 2,
				* (모니터화면 세로 - 프레임화면 세로) / 2 이렇게 설정한다.
				*/
				this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
				       
				d1.setResizable(false); // 프레임 크기 조절을 할수 없게 만듭니다.
				
				d1.setVisible(true);
				
				
	}

	public static void main(String[] args) {
		new RestockDialog();
	}

}
