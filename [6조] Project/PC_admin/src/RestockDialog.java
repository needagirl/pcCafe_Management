import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;



public class RestockDialog extends JFrame {

	RestockCheck rc = new RestockCheck();
	JDialog d1 = new JDialog(this," �� �԰���� �� ",true);
	public RestockDialog() {
			
				d1.add(rc);
				
				//setExtendedState(JFrame.MAXIMIZED_BOTH);
				d1.setSize(1600, 900);
				
				// �������� ����� ���մϴ�.
				Dimension frameSize = this.getSize();
				// �� ������� ũ�⸦ ���մϴ�.
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				
				/*
				* �׷��� �������� ��ġ��
				* (�����ȭ�� ���� - ������ȭ�� ����) / 2,
				* (�����ȭ�� ���� - ������ȭ�� ����) / 2 �̷��� �����Ѵ�.
				*/
				this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
				       
				d1.setResizable(false); // ������ ũ�� ������ �Ҽ� ���� ����ϴ�.
				
				d1.setVisible(true);
				
				
	}

	public static void main(String[] args) {
		new RestockDialog();
	}

}
