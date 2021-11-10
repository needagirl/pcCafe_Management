
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTableMouseEventRestock extends MouseAdapter{
	
	JComboBox<String> goodscombo = new JComboBox<String>();
	String givecombo = (String)goodscombo.getSelectedItem();
	
	JTextField t0;
	JTextField t1 ;
	JTextField t2;
	JTextField t3;
	JTextField t4;
	JTextField t5;
	JTable table;
	public JTableMouseEventRestock() {
	
	}
	public JTableMouseEventRestock(JComboBox<String>goodscombo,JTextField t0, JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5, JTable table) {
		this.goodscombo = goodscombo;
		this.t0 = t0;
		this.t1= t1; 
		this.t2= t2; 
		this.t3= t3; 
		this.t4= t4; 
		this.t5= t5;
		this.table = table;
	}
	public void mouseReleased(MouseEvent me) {
		if(me.getButton()==1){//왼쪽버튼 일때 /리스트에 있는 현재 선택된 행의 데이터를 찍어줌
		//현재 클릭한 행을 구하여
			int row = table.getSelectedRow(); //index 0,1,2,3
			try {
				t0.setText(String.valueOf(table.getValueAt(row, 0))); //입고수량(숫자)
				goodscombo.setSelectedItem((String)table.getValueAt(row, 1));//상품구분 콤보
				t1.setText((String)table.getValueAt(row, 2));//상품명(문자)
				t2.setText(String.valueOf(table.getValueAt(row, 3))); //입고수량(숫자)
				t3.setText(String.valueOf(table.getValueAt(row, 4)));//입고가격(숫자)
				t4.setText(String.valueOf(table.getValueAt(row, 6)));//유통기한	(숫자)												  //총 이용금액
				t5.setText((String)table.getValueAt(row, 7));//입고메모(문자)
				
			}catch(ArrayIndexOutOfBoundsException e) {
			
			}
		}
			
			
		}
	
}
