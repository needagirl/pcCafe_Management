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
				JLabel plus = new JLabel("추가할 상품구분명");
				JTextField pl = new JTextField(10);
			JPanel dPane = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));	
				JLabel del = new JLabel("삭제할 상품구분명");
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
		
		Font fnt = new Font("맑은 고딕",Font.BOLD, 14); //버튼 폰트
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
	public void pcInsert() { //텍스트를 입력하고 버튼을 누르면 상품구분 p_class에 추가되어야함, 콤보박스에 추가되야함
		//상품구분 추가
		
			String pcname = pl.getText();
			
			if(pcname==null || pcname.equals("")) {
				JOptionPane.showMessageDialog(this, "추가할 상품구분명을 입력하세요!");
			}else {
				JOptionPane.showMessageDialog(this, pcname+"을 추가했습니다!");
				GoodsVO vo = new GoodsVO();
			
				String givecombo=(String)gc.goodscombo.getSelectedItem();
//				String givecombo = (String)goodscombo.getSelectedItem();
				vo.setP_class(pl.getText());

				GoodsDAO dao = new GoodsDAO();
				int cnt = dao.insertRecordPClass(vo);
				if(cnt>0) {//상품추가
					pl.setText("");
					//formDataClear(); //회원이 추가되면 폼의 데이터를 지운다.
					//goodsAllList();
					
				}
			}
	}
	
	//상품구분 목록 불러오기
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
		//상품구분 삭제
	
	public void pcDelete() { //텍스트를 입력하고 버튼을 누르면 상품구분 p_class에서 삭제되고 콤보박스에도 삭제가 되야함...
					String delNum = (String)goodscombo.getSelectedItem(); //원래 num값을 넣어야하는데 우리는 입력받는 num가 없음 / 숫자가 있으면 "5", 없으면 " "
					//if(delNum==null || delNum.equals("")){
					//JOptionPane.showMessageDialog(this, "삭제할 상품구분명을 입력 후 삭제버튼을 클릭하세요");
					//}else {//선택을 해서 값이 있을 경우 
					
				   //gc.goodscombo.setSelectedItem((String)gc.table.getValueAt(row, 1));
						
						GoodsDAO dao = new GoodsDAO();
						int result = dao.deleteRecordPClass((delNum)); //삭제할 사원번호를 int로 변경시켜서 deleterecord의 매개변수로 보냄
						//result에 삭제한 레코드 수가 들어있음
						if(result>0) { //회원삭제됨
							JOptionPane.showMessageDialog(this, delNum+"을 삭제하였습니다.");
							
							//goodsAllList();//리스트 다시 가져옴
							//formDataClear();
						}else { //회원삭제 안됨
							JOptionPane.showMessageDialog(this, delNum+"삭제에 실패하였습니다.");
						}
					//}
		}
	
	public static void main(String[] args) {
		new P_Class();
	}

	
	
}
