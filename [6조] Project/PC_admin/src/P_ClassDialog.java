import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class P_ClassDialog extends JFrame {
		P_Class pc = new P_Class();
		JDialog d1 = new JDialog(this," ★ 상품구분 추가/삭제 ★ ",true);
		public P_ClassDialog() {
				
					d1.add(pc);
					
					//setExtendedState(JFrame.MAXIMIZED_BOTH);
					d1.setSize(300, 220);
					
					// 프레임의 사이즈를 구합니다.
					Dimension frameSize = this.getSize();
					// 내 모니터의 크기를 구합니다.
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					
					/*
					* 그래서 프레임의 위치를
					* (모니터화면 가로 - 프레임화면 가로) / 2,
					* (모니터화면 세로 - 프레임화면 세로) / 2 이렇게 설정한다.
					*/
					//this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
					this.setLocation(400,400);       
					d1.setResizable(false); // 프레임 크기 조절을 할수 없게 만듭니다.
					
					d1.setVisible(true);
					
	}
	
	public static void main(String[] args) {
		new P_ClassDialog();
		
	}

}
