import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class P_ClassDialog extends JFrame {
		P_Class pc = new P_Class();
		JDialog d1 = new JDialog(this," �� ��ǰ���� �߰�/���� �� ",true);
		public P_ClassDialog() {
				
					d1.add(pc);
					
					//setExtendedState(JFrame.MAXIMIZED_BOTH);
					d1.setSize(300, 220);
					
					// �������� ����� ���մϴ�.
					Dimension frameSize = this.getSize();
					// �� ������� ũ�⸦ ���մϴ�.
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					
					/*
					* �׷��� �������� ��ġ��
					* (�����ȭ�� ���� - ������ȭ�� ����) / 2,
					* (�����ȭ�� ���� - ������ȭ�� ����) / 2 �̷��� �����Ѵ�.
					*/
					//this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
					this.setLocation(400,400);       
					d1.setResizable(false); // ������ ũ�� ������ �Ҽ� ���� ����ϴ�.
					
					d1.setVisible(true);
					
	}
	
	public static void main(String[] args) {
		new P_ClassDialog();
		
	}

}
