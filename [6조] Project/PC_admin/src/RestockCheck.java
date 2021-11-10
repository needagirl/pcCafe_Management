import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RestockCheck extends JPanel implements ActionListener{
	//JFrame - North
	JPanel northPane = new JPanel(new FlowLayout(FlowLayout.CENTER,20,100));
		JButton lbl = new JButton("�� �� �� �� �� ��");
		JButton findlb = new JButton("Search");
		//String lbl1[] = {"��","��","��"};	
		
		JLabel yearlb = new JLabel("��");
		JLabel monlb = new JLabel("��");
		JLabel daylb = new JLabel("��");
		
		JLabel yearlb2 = new JLabel("��");
		JLabel monlb2 = new JLabel("��");
		JLabel daylb2 = new JLabel("��");
		
		JLabel flowlb = new JLabel(" ~ ");
		
		//ù��° �޺��ڽ� -> ���� �޺��ڽ��� �ѹ� �� ������ ���� �ʰų� ������ �ٲ�!!	
		JComboBox<String> yearcombo = new JComboBox<String>();//�˻� �޺��ڽ�
		DefaultComboBoxModel<String>yearmodel;
		
		JComboBox<String> monthCombo = new JComboBox<String>();//�˻� �޺��ڽ�
		DefaultComboBoxModel<String>monthModel;
		String monthName[] = new String[12];
		
		JComboBox<String> daycombo = new JComboBox<String>();//�˻� �޺��ڽ�
		DefaultComboBoxModel<String>daymodel;
		String dayName[]= new String[31];	
		
		//�ι�° �޺��ڽ�
		JComboBox<String> yearcombo2 = new JComboBox<String>();//�˻� �޺��ڽ�
		DefaultComboBoxModel<String>yearmodel2;
		
		JComboBox<String> monthCombo2 = new JComboBox<String>();//�˻� �޺��ڽ�
		DefaultComboBoxModel<String>monthModel2;
		String monthName2[] = new String[12];
		
		JComboBox<String> daycombo2 = new JComboBox<String>();//�˻� �޺��ڽ�
		DefaultComboBoxModel<String>daymodel2;
		String dayName2[]= new String[31];	
		
	
	//JFrame - West
	JPanel westPane = new JPanel(new BorderLayout());
		JPanel westUpPane = new JPanel(new BorderLayout());
			JPanel wWestPane = new JPanel(new FlowLayout(FlowLayout.LEADING,233,0));//new GridLayout(7,1,20,20)
			String lbl1[] = {"<����>","<��ǰ����>","<��ǰ��> ","<�԰����> ","<�԰���>"," <�������>","<�԰�޸�>"};
			//~(*�� v��*)/��   ///������������������������������������
			JPanel wCentPane = new JPanel();
			
				JComboBox<String> goodscombo = new JComboBox<String>();
				DefaultComboBoxModel<String>goodsmodel;
				
				JLabel l1 = new JLabel("~(*�� v��*)/�� ��������������������");
				JTextField t0 = new JTextField(10);
				JTextField t1 = new JTextField(20);
				JTextField t2 = new JTextField(20);
				JTextField t3 = new JTextField(20);
				JTextField t4 = new JTextField(20);
				
		JPanel wSouthPane = new JPanel(new BorderLayout());  
			JPanel wSupPane = new JPanel(new FlowLayout(FlowLayout.LEADING,250,0));
				//JTextArea ta2 = new JTextArea();
				//JScrollPane sp2 = new JScrollPane(ta2);
				JTextField t5 = new JTextField(200);
			JPanel wSdownPane = new JPanel(); //new FlowLayout(FlowLayout.LEADING,70,2)
				
				JButton b0 = new JButton("����");
				JButton b1 = new JButton("�߰�");
				JButton b2 = new JButton("����");
				JButton b3 = new JButton("�����Է�");
			
	//JFrame - Center
	JPanel centPane = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
		JTable table;
		JScrollPane sp;
		DefaultTableModel model;
		String title[] = {"����","��ǰ����","��ǰ��","�԰����","�԰���","�԰�¥","�������","�԰�޸�","������"};
	
		
		public RestockCheck() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH,northPane);
		add(BorderLayout.WEST,westPane);
		add(BorderLayout.CENTER,centPane);
		
		westPane.add(BorderLayout.CENTER, westUpPane);
		westPane.add(BorderLayout.SOUTH, wSouthPane);
		
		westUpPane.add(BorderLayout.WEST,wWestPane);
		westUpPane.add(BorderLayout.CENTER,wCentPane);
		
		wSouthPane.add(BorderLayout.CENTER, wSupPane);
		wSouthPane.add(BorderLayout.SOUTH, wSdownPane);
		
		
		//north
		northPane.setPreferredSize(new Dimension(1600, 50));
		setNorth();
		
		//center
		centPane.setBackground(Color.white);
		setCent();
		
		//west
		//westPane.setPreferredSize(new Dimension(400, 150));
		//westPane.setBackground(Color.DARK_GRAY);
		//wWestPane.setBackground(Color.DARK_GRAY);
		northPane.setPreferredSize(new Dimension(600, 70));
		westUpPane.setPreferredSize(new Dimension(600, 400));
		wWestPane.setPreferredSize(new Dimension(310, 350)); 
		wCentPane.setPreferredSize(new Dimension(300, 350));
		wSouthPane.setPreferredSize(new Dimension(300, 250));
		wSdownPane.setPreferredSize(new Dimension(300, 120));
		setWestUp(); //���� ��, ������ �ؽ�Ʈ�ʵ� 
		setWestDown();
		
		
		//setSize(1600,900);
		setVisible(true);
		
		restockAllList();
		
	}
		public void setWestUp() {
			//���� ��
			for(int i=0; i<lbl1.length; i++) {
				JLabel lbl2 = new JLabel(lbl1[i]);
				lbl2.setPreferredSize(new Dimension(100, 80)); //100,80
				
				//lbl2.setBackground(Color.DARK_GRAY);
				Font fnt = new Font("���",Font.BOLD, 14);
				lbl2.setFont(fnt);
				//lbl2.setForeground(Color.white);
				//l1.setForeground(Color.white);
				wWestPane.add(lbl2);
				
				//lbl2.setBackground(Color.LIGHT_GRAY);
				
			//������ �ؽ�Ʈ�ʵ�
				wCentPane.setLayout(null);
				wCentPane.add(t0);
				//wCentPane.setBackground(Color.LIGHT_GRAY);
				String goodsName[] = {"����/����","��Ʈ/�߽�/Ƣ��","�Ļ��","�н�/���","���/�쵿","Ŀ��/����"};
				goodsmodel = new DefaultComboBoxModel<String>(goodsName); 
				goodscombo.setModel(goodsmodel);	
				goodscombo.setPreferredSize(new Dimension(10,10));
				wCentPane.add(goodscombo);
				
				goodscombo.setBackground(Color.LIGHT_GRAY);
			
				
				t0.setBounds(30, 28, 40, 30);
				l1.setBounds(75, 28, 180,30);
				t1.setBounds(30, 190, 210, 30);
				goodscombo.setBounds(30, 108, 210, 30);
				t2.setBounds(30, 268, 210, 30);
				t3.setBounds(30, 348, 210, 30);
				t4.setBounds(30, 428, 210, 30);
				
				wCentPane.add(l1);
				wCentPane.add(t0);
				wCentPane.add(t1);
				wCentPane.add(t2);
				wCentPane.add(t3);
				wCentPane.add(t4);
				
			}
			
		}
		public void setWestDown() {
		
			wSupPane.setLayout(null);
			wSupPane.add(t5);  
			t5.setBounds(250,0,300,150);
			
			table.addMouseListener(new JTableMouseEventRestock(goodscombo,t0,t1,t2,t3,t4,t5,table));
		
			wSdownPane.setLayout(null);
			
			b1.setBackground(Color.gray);
			b2.setBackground(Color.gray);
			b3.setBackground(Color.gray);
			b0.setBackground(Color.gray);
			
			
			b1.setForeground(Color.white);
			b2.setForeground(Color.white);
			b3.setForeground(Color.white);
			b0.setForeground(Color.white);
			
			b0.setBounds(350, 20, 90, 30);
			b1.setBounds(250, 20, 90, 30);
			b2.setBounds(450, 20, 90, 30);
			b3.setBounds(250, 60, 290, 30);
			
			wSdownPane.add(b1);
			wSdownPane.add(b0);
			wSdownPane.add(b2);
			wSdownPane.add(b3);
		}
		
		
	public void setCent() {
		Object[][] data = {};
		model = new DefaultTableModel(data,title);
		table = new JTable(model); 
		sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(900, 700));
		centPane.add(BorderLayout.CENTER,sp);
	}
	
	public void setNorth() {///������� ���� �����
		northPane.setBackground(Color.LIGHT_GRAY);
		northPane.setLayout(null);
		lbl.setBounds(245,0,140,69);
		yearcombo.setBounds(450,18,80,35);
		yearlb.setBounds(540,18,80,35);
		monthCombo.setBounds(600,18,50,35);
		monlb.setBounds(670,18,80,35);
		daycombo.setBounds(740,18,50,35);
		daylb.setBounds(810,18,80,35);
		flowlb.setBounds(880,18,80,35);
		
		yearcombo.setBackground(Color.white); //�޺��ڽ� ����
		monthCombo.setBackground(Color.white);
		daycombo.setBackground(Color.white);
		yearcombo2.setBackground(Color.white);
		monthCombo2.setBackground(Color.white);
		daycombo2.setBackground(Color.white);
		
	
		//yearcombo.setForeground(Color.white);
		
		yearcombo2.setBounds(928,18,80,35);
		yearlb2.setBounds(1020,18,80,35);
		monthCombo2.setBounds(1090,18,50,35);
		monlb2.setBounds(1160,18,80,35);
		daycombo2.setBounds(1230,18,50,35);
		daylb2.setBounds(1310,18,80,35);
		
		findlb.setBounds(1360,15,85,40);
		
		//ù��° �޺��ڽ��� �󺧵�

		//northPane.setBackground(Color.LIGHT_GRAY);
		
		northPane.add(lbl); //�԰����
		
		lbl.setBackground(Color.DARK_GRAY);
		lbl.setForeground(Color.white);
		Font fnt = new Font("���� ���",Font.BOLD, 13); //��ư ��Ʈ
		lbl.setFont(fnt);
		//lbl.setBounds(2,100,300,300);
		//�� �޺��ڽ�
		String yearName[] = {"2021","2020"};
		yearmodel = new DefaultComboBoxModel<String>(yearName); //model�� fontname
		yearcombo.setModel(yearmodel);
		northPane.add(yearcombo);
		northPane.add(yearlb);
		
		//�� �޺��ڽ�
		String[] items = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthModel = new DefaultComboBoxModel<String>(items);
		monthCombo.setModel(monthModel);
		northPane.add(monthCombo);
		northPane.add(monlb);
		
		//�� �޺��ڽ�
		for(int i=0; i<31; i++) {
			dayName[i]= Integer.toString(i+1);
		}
		daymodel = new DefaultComboBoxModel<String>(dayName); //model�� fontname
		daycombo.setModel(daymodel);
		//findcombo.setSelectedItem("���հ˻�");
		northPane.add(daycombo);
		northPane.add(daylb);
		
		//����
		northPane.add(flowlb);
		
		///////
		
		//�ι�° �޺��ڽ��� �󺧵�
		
		//��
		String yearName2[] = {"2021","2020"};
		yearmodel2 = new DefaultComboBoxModel<String>(yearName2); //model�� fontname
		yearcombo2.setModel(yearmodel2);
		northPane.add(yearcombo2);
		northPane.add(yearlb2);
		//��		
		String[] items2 = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthModel2 = new DefaultComboBoxModel<String>(items2);
		monthCombo2.setModel(monthModel2);
		northPane.add(monthCombo2);
		northPane.add(monlb2);
		//��		
		for(int i=0; i<31; i++) {
			dayName2[i]= Integer.toString(i+1);
		}
		daymodel2 = new DefaultComboBoxModel<String>(dayName2); //model�� fontname
		daycombo2.setModel(daymodel2);
		northPane.add(daycombo2);
		northPane.add(daylb2);
		//�˻� ��ư
		northPane.add(findlb);
		findlb.setBackground(Color.gray);
		findlb.setForeground(Color.white);
		
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		findlb.addActionListener(this);
	
	}
	
	public void restockAllList() { //ȣ��Ǹ� ȸ�� ��ü��� ���(�̸��������)
		RestockDAO dao = new RestockDAO();
		List<RestockVO> list = dao.allRecord();
		setRestockModel(list);
		
	}
	public void setRestockModel(List<RestockVO> list) {
		//���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�.
		model.setRowCount(0); //������ �ִ°� ������� 0���� �ٲ����
		//�÷����� vo�� get�Ͽ� jtable�� ������� �߰��Ѵ�.
		for(int i=0; i<list.size(); i++) {
			RestockVO vo = list.get(i);
			Object[] obj = {vo.getE_Num(), vo.getP_class(), vo.getP_name(), vo.getE_cnt(), vo.getE_price(), vo.getE_date(), vo.getExpiry(),vo.getRemark(),vo.getManager()};
			model.addRow(obj);
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		String event = ae.getActionCommand();
		if(event.equals("�߰�")) {
			restockInsert();
			restockAllList();
		}else if(event.equals("����")) {
			restockDel();
			restockAllList();
		}else if(event.equals("�����Է�")){
			formDataClear();
			
		}else if(event.equals("����")) {
			restockUpdate();
			restockAllList();
			
		}else if(event.equals("Search")) {
			searchDate();
		}
	}
	//�԰��ǰ�߰�	
		public void restockInsert() {
			
			String goodsname = t1.getText();
			String goodsname2 = t2.getText();
			String goodsname3 = t3.getText();
			if(goodsname==null || goodsname.equals("") ) {
				JOptionPane.showMessageDialog(this, "�԰��� ��ǰ���� ��Ȯ�� �Է��ϼ���!");
			}else if(goodsname2==null || goodsname2.equals("")) {
				JOptionPane.showMessageDialog(this, "�԰��� ������ ��Ȯ�� �Է��ϼ���!");
			}else if(goodsname3==null || goodsname3.equals("")) {
				JOptionPane.showMessageDialog(this, "�԰��� ��ǰ�ݾ��� ��Ȯ�� �Է��ϼ���!");
			
			}else {
				JOptionPane.showMessageDialog(this, goodsname +"  ��ǰ�� �߰��Ǿ����ϴ�!!");
				
				RestockVO vo = new RestockVO();
				
				String givecombo = (String)goodscombo.getSelectedItem();
				vo.setP_name(goodsname);
				vo.setP_class(givecombo);
				vo.setE_cnt(Integer.parseInt(t2.getText())); //formTf�� 0��°�� ��ȣ�� �ִ� //���ڸ� int�� �ٲ㼭
				vo.setE_price(Integer.parseInt(t3.getText()));
				vo.setExpiry(Integer.parseInt(t4.getText()));
				vo.setRemark(t5.getText());
				
				
				RestockDAO dao = new RestockDAO();
				int cnt = dao.insertRecord(vo);
				if(cnt>0) {//��ǰ�߰�
					esCnt(goodsname);
					formDataClear(); //ȸ���� �߰��Ǹ� ���� �����͸� �����.
					restockAllList();
				}
				
			}
		}
		//��ǰ����
		
			public void restockUpdate() {
				String goodsname = t1.getText();
				
				String givecombo = (String)goodscombo.getSelectedItem();
				
				RestockVO vo = new RestockVO();
				vo.setE_Num(Integer.parseInt(t0.getText()));
				vo.setP_name(goodsname);
				vo.setP_class(givecombo);	
				vo.setE_cnt(Integer.parseInt(t2.getText())); //formTf�� 0��°�� ��ȣ�� �ִ� //���ڸ� int�� �ٲ㼭
				vo.setE_price(Integer.parseInt(t3.getText()));
				vo.setExpiry(Integer.parseInt(t4.getText()));
				vo.setRemark(t5.getText());
				//vo.setE_Num(ABORT);
			
				RestockDAO dao = new RestockDAO(); //DAO ��ü����
				int cnt = dao.updateRecord(vo);
				if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
					restockAllList();//��ü��� ���
				}else{//�������н� �ȳ� �޼��� ǥ�� 
					JOptionPane.showMessageDialog(this,"��ǰ���� ���� �����Ͽ����ϴ�"); //�θ������̳�,�޼���
				}
			}
		
		
		
		
		//��ǰ����
		public void restockDel() {
			//������ ��ǰ��ȣ 
					String delNum = t1.getText(); //���� num���� �־���ϴµ� �츮�� �Է¹޴� num�� ���� / ���ڰ� ������ "5", ������ " "
				
					if(delNum==null || delNum.equals("")){
					JOptionPane.showMessageDialog(this, "������ �԰��ǰ�� ������ ������ư�� Ŭ���ϼ���");
					}else {//������ �ؼ� ���� ���� ��� 
						RestockDAO dao = new RestockDAO();
						int result = dao.deleteRecord((delNum)); //������ �����ȣ�� int�� ������Ѽ� deleterecord�� �Ű������� ����
						//result�� ������ ���ڵ� ���� �������
						if(result>0) { //ȸ��������
							JOptionPane.showMessageDialog(this, delNum+"��ǰ�� �����Ͽ����ϴ�.");
							restockAllList();//����Ʈ �ٽ� ������
							formDataClear();
						}else { //ȸ������ �ȵ�
							JOptionPane.showMessageDialog(this, delNum+"��ǰ������ �����Ͽ����ϴ�.");
						}
					}
		}
		
		public void esCnt(String goodsname) {//������ ���� (�԰� �߻� or �Ǹ� �߻�) 
			GoodsDAO gd = new GoodsDAO();
			int result2 = gd.getE_cnt(goodsname);
			int result3 = gd.getS_cnt(goodsname);
			gd.setStock(goodsname,result2-result3);
			
			
		}
		
		public void searchDate() {
			String startDate = (String)yearcombo.getSelectedItem()+makeTwo((String)monthCombo.getSelectedItem())+makeTwo((String)daycombo.getSelectedItem());
			String endDate = (String)yearcombo2.getSelectedItem()+makeTwo((String)monthCombo2.getSelectedItem())+makeTwo((String)daycombo2.getSelectedItem())+"23";
			RestockDAO dao = new RestockDAO();
			List<RestockVO> list = dao.searchRecord(startDate, endDate);
			setRestockModel(list);
		}
		public String makeTwo(String date) {
			String result;
			if(date.length()<2) {
				result = "0"+date;
			}else {
				result = date;
			}
			return result;
		}
		
		public void formDataClear() {
				t1.setText("");//num���� ������ �Ǵµ� ���� �̻���
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			
		}
	
	public static void main(String[] args) {
		new RestockCheck();
	}

}
