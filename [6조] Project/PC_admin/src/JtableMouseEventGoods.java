
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JtableMouseEventGoods extends MouseAdapter{
	
	JComboBox<String> goodscombo = new JComboBox<String>();
	String givecombo = (String)goodscombo.getSelectedItem();
	JTextField formTf0;
	JTextField formTf1;
	JTextField formTf2;
	JTextField formTf3;
	
	JTable table;
	public JtableMouseEventGoods() {
	
	}
	public JtableMouseEventGoods(JComboBox<String> goodscombo,JTextField formTf0, JTextField formTf1,JTextField formTf2,JTextField formTf3, JTable table) {
		this.goodscombo = goodscombo;
		this.formTf0 = formTf0;
		this.formTf1 = formTf1;
		this.formTf2 = formTf2;
		this.formTf3 = formTf3;
		this.table = table;
	}
	
	public void mouseReleased(MouseEvent me) {
		if(me.getButton()==1){//���ʹ�ư �϶� /����Ʈ�� �ִ� ���� ���õ� ���� �����͸� �����
		//���� Ŭ���� ���� ���Ͽ�
			int row = table.getSelectedRow(); //index 0,1,2,3
			//ĭ�� ����� ������		=table.getColumnCount()
			try {
			formTf0.setText(String.valueOf(table.getValueAt(row,0)));//�̰͸� ���� 
			goodscombo.setSelectedItem((String)table.getValueAt(row, 1));
			formTf1.setText((String)table.getValueAt(row, 2));
			formTf2.setText(String.valueOf(table.getValueAt(row,3)));//�̰͸� ���� 
			formTf3.setText((String)table.getValueAt(row,5));
			
			}catch(NullPointerException ne) {
				
			}

		}
	}
}






