import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class P_Class extends JPanel implements ActionListener{
	JPanel centPane = new JPanel(new BorderLayout());
		JPanel upPane = new JPanel(new BorderLayout());
			JPanel pPane = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
				JLabel plus = new JLabel("�߰��� ��ǰ���и�");
				JTextField pl = new JTextField(10);
			JPanel dPane = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));	
				JLabel del = new JLabel("������ ��ǰ���и�");
				JComboBox<String> goodscombo = new JComboBox<String>();
				DefaultComboBoxModel<String> goodsmodel;
				
		JPanel downPane = new JPanel();
			JButton plusB = new JButton(new ImageIcon("img/plus2.png"));
			JButton delB = new JButton(new ImageIcon("img/trash1.png"));
			
			GoodsCheck gc = new GoodsCheck();
	public P_Class() {
		add(centPane);
		centPane.add(upPane);
		centPane.add("South",downPane);
		upPane.add("North",pPane);
		upPane.add(dPane);
		pPane.add(plus);
		pPane.add(pl);
		dPane.add(del);
		dPane.add(goodscombo);
		
		goodsmodel = new DefaultComboBoxModel<String>(); 
		goodscombo.setModel(goodsmodel);	
		goodscombo.setPreferredSize(new Dimension(130,25));
		
		downPane.add(plusB);
		downPane.add(delB);
		
		upPane.setBackground(Color.DARK_GRAY);
		downPane.setBackground(Color.DARK_GRAY);
		
		pPane.setBackground(Color.DARK_GRAY);
				
		dPane.setBackground(Color.DARK_GRAY);
		
		centPane.setBackground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		
		Font fnt = new Font("���� ���",Font.BOLD, 14); //��ư ��Ʈ
		plus.setFont(fnt);
		plus.setForeground(Color.white);
		del.setFont(fnt);
		del.setForeground(Color.white);
		pl.setFont(fnt);

		plusB.setBackground(Color.getHSBColor(152, 135, 100));
		delB.setBackground(Color.getHSBColor(253, 380, 100));
		plusB.setPreferredSize(new Dimension(90,70));
		delB.setPreferredSize(new Dimension(90,70));
		
		setVisible(true);
		setSize(300,300);
		
		goodscombo.addActionListener(this);
		plusB.addActionListener(this);
		delB.addActionListener(this);
		
		allRecordPC();
		
	}
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event instanceof JButton) {
			if(event== plusB) {
				pcInsert();
				allRecordPC();
			}else if(event == delB) {
				pcDelete();
				allRecordPC();
				
			}
		}
	}
	public void pcInsert() { //�ؽ�Ʈ�� �Է��ϰ� ��ư�� ������ ��ǰ���� p_class�� �߰��Ǿ����, �޺��ڽ��� �߰��Ǿ���
		//��ǰ���� �߰�
		
			String pcname = pl.getText();
			
			if(pcname==null || pcname.equals("")) {
				JOptionPane.showMessageDialog(this, "�߰��� ��ǰ���и��� �Է��ϼ���!");
			}else {
				JOptionPane.showMessageDialog(this, pcname+"�� �߰��߽��ϴ�!");
				GoodsVO vo = new GoodsVO();
			
				String givecombo=(String)gc.goodscombo.getSelectedItem();
//				String givecombo = (String)goodscombo.getSelectedItem();
				vo.setP_class(pl.getText());

				GoodsDAO dao = new GoodsDAO();
				int cnt = dao.insertRecordPClass(vo);
				if(cnt>0) {//��ǰ�߰�
					pl.setText("");
					//formDataClear(); //ȸ���� �߰��Ǹ� ���� �����͸� �����.
					//goodsAllList();
					
				}
			}
	}
	
	//��ǰ���� ��� �ҷ�����
		public void allRecordPC() {
			GoodsDAO dao = new GoodsDAO();
			List<String>pc = dao.allRecordPClass();
			goodsmodel.addAll(pc);
			pcGoodsModel(pc);
		}
		public void pcGoodsModel(List<String> pc) {
			
			goodsmodel.removeAllElements();
			goodsmodel.addAll(pc);
			gc.allRecordPC();
			gc.pcGoodsModel(pc);
			
			
		}
		//��ǰ���� ����
	
	public void pcDelete() { //�ؽ�Ʈ�� �Է��ϰ� ��ư�� ������ ��ǰ���� p_class���� �����ǰ� �޺��ڽ����� ������ �Ǿ���...
					String delNum = (String)goodscombo.getSelectedItem(); //���� num���� �־���ϴµ� �츮�� �Է¹޴� num�� ���� / ���ڰ� ������ "5", ������ " "
					//if(delNum==null || delNum.equals("")){
					//JOptionPane.showMessageDialog(this, "������ ��ǰ���и��� �Է� �� ������ư�� Ŭ���ϼ���");
					//}else {//������ �ؼ� ���� ���� ��� 
					
				   //gc.goodscombo.setSelectedItem((String)gc.table.getValueAt(row, 1));
						
						GoodsDAO dao = new GoodsDAO();
						int result = dao.deleteRecordPClass((delNum)); //������ �����ȣ�� int�� ������Ѽ� deleterecord�� �Ű������� ����
						//result�� ������ ���ڵ� ���� �������
						if(result>0) { //ȸ��������
							JOptionPane.showMessageDialog(this, delNum+"�� �����Ͽ����ϴ�.");
							
							//goodsAllList();//����Ʈ �ٽ� ������
							//formDataClear();
						}else { //ȸ������ �ȵ�
							JOptionPane.showMessageDialog(this, delNum+"������ �����Ͽ����ϴ�.");
						}
					//}
		}
	
	public static void main(String[] args) {
		new P_Class();
	}

	
	
}
