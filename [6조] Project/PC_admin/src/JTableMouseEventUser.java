import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableMouseEventUser extends MouseAdapter{
	JTextField jt0;
	JTextField jt1;
	JTextField jt2;
	JTextField jt3;
	JTextField jt4;
	JTextField jt44;
	JTextField jt5;
	JTextField jt6;
	JTextField jt7;
	JTextField jtt;
	JRadioButton r1;
	JRadioButton r2;
	
	JTable table;
	public JTableMouseEventUser() {
	
	}
	public JTableMouseEventUser(JTextField jt0,JTextField jt1,JTextField jt2,JTextField jt3,JTextField jt4,JTextField jt44,JTextField jt5, JTextField jt6,JTextField jt7,JRadioButton r1,JRadioButton r2,JTextField jtt, JTable table) {
		this.jt0= jt0; //
		this.jt1 = jt1;
		this.jt2 = jt2;
		this.jt3 = jt3;
		this.jt4 = jt4;
		this.jt44 = jt44;
		this.jt5 = jt5;
		this.jt6 = jt6;
		this.jt7 = jt7;
		this.jtt = jtt;
		this.table = table;
		this.r1 = r1;
		this.r2 =r2;
	}
	public void mouseReleased(MouseEvent me) {
		if(me.getButton()==1){//���ʹ�ư �϶� /����Ʈ�� �ִ� ���� ���õ� ���� �����͸� �����
		//���� Ŭ���� ���� ���Ͽ�
			int row = table.getSelectedRow(); //index 0,1,2,3
			try {
			jt0.setText(String.valueOf(table.getValueAt(row, 0))); //ȸ����ȣ(����)
			//����(����)
			if((table.getValueAt(row, 1).equals(1))){
				r1.doClick();
			}else if(table.getValueAt(row, 1).equals(2)){
				r2.doClick();
			}
			
			jt1.setText((String)table.getValueAt(row, 2));//�̸�(����)
			jt2.setText((String)table.getValueAt(row, 3));//���̵�(����)
			jt3.setText((String)table.getValueAt(row, 4));//��й�ȣ(����)
			jt4.setText((String)table.getValueAt(row, 5));//�ּ�(����)
			jt44.setText((String)table.getValueAt(row, 6));//�������(����)
			jt5.setText((String)table.getValueAt(row, 7));//����ó(����)
			jt6.setText(String.valueOf(table.getValueAt(row, 8)));//���̿�ð�(����)
			jt7.setText(String.valueOf(table.getValueAt(row, 9)));//���̿�ݾ�	(����)
			jtt.setText((String)table.getValueAt(row, 11));//���(����)
			
		
			}catch(ArrayIndexOutOfBoundsException e) {
			
			}
		}

		}
	
}
