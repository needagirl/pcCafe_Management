import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

	public class SaleCheck extends JFrame implements ActionListener{
	//JFrame - North
		JPanel northPane = new JPanel(new BorderLayout()); // //new GridLayout(1,15,20,20)  //new FlowLayout(FlowLayout.CENTER,10,10)
			JPanel nNorthPane = new JPanel(new GridLayout(1,5));
				JToolBar tb = new JToolBar();
				ImageIcon icon1 = new ImageIcon("img/logo.png");
				JLabel lbi = new JLabel(icon1);
				JLabel lbi2 = new JLabel("�� BIT PC ��");
				JMenuBar ad = new JMenuBar();
				JMenu countMenu = new JMenu("�������");
				JMenuItem countMenuItem = new JMenuItem("�������");
				JMenu mdMenu = new JMenu("��ǰ����");
				JMenuItem mdMenuItem = new JMenuItem("��ǰ����");
				JMenuItem restockMenuItem = new JMenuItem("�԰����");
				JMenu userMenu = new JMenu("ȸ������");
				JMenuItem userMenuItem = new JMenuItem("ȸ������");
				JMenu payMenu = new JMenu("�������");
				JMenuItem payMenuItem = new JMenuItem("�������");
		
		//
			JPanel nCentPane = new JPanel(new FlowLayout(FlowLayout.CENTER,2,0));
				JButton lbl = new JButton("�� �Ⱓ�� ������Ȳ ��");
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
			
	//JFrame - Center
		JPanel centPane = new JPanel(new BorderLayout());
			JPanel leftPane = new JPanel(new BorderLayout());//������ ��,ǥ / �Ʒ��� ���̶� �ؽ�Ʈ �ڽ� 
				JPanel lCentPane = new JPanel(new BorderLayout());
					JPanel lCtitle = new JPanel(new FlowLayout(FlowLayout.LEADING,75,10)); //new FlowLayout(FlowLayout.CENTER,2,2)
						JButton lb1 = new JButton("PC ���");
					JPanel lCtable = new JPanel(new FlowLayout(FlowLayout.CENTER));	
						JTable table;
						JScrollPane sp;
						DefaultTableModel model;
						String title[] = {"����","PC��ȣ "," ����� ","�̿�ð�"," ���ݾ�", " ���۽ð�"," ����ð�"," ������"};
					
				JPanel lSouthPane = new JPanel(new BorderLayout());
					JPanel lStitle = new JPanel(new FlowLayout(FlowLayout.LEADING,75,10));//
						JButton lb3 = new JButton("�ŷ�����");
					JPanel lStext = new JPanel();
						JButton bs1 = new JButton("PC��� ����");
						JButton bs2 = new JButton("��ǰ�Ǹ� ����");
						JButton bs3 = new JButton("�����հ�");
						JButton t1 = new JButton();
						JButton t2 = new JButton();
						JButton t3 = new JButton();
			JPanel rightPane = new JPanel(new BorderLayout()); //������ ��,ǥ / �Ʒ��� ���̶� �ؽ�Ʈ �ڽ�
				JPanel rCentPane = new JPanel(new BorderLayout());
					JPanel rCtitle = new JPanel(new FlowLayout(FlowLayout.LEADING,78,10)); //new FlowLayout(FlowLayout.CENTER,2,2)
						JButton lb2 = new JButton("��ǰ�Ǹ�");
					JPanel rCtable = new JPanel(new FlowLayout(FlowLayout.CENTER));
						JTable table2;
						JScrollPane sp2;
						DefaultTableModel model2;
						String title2[] = {"����","��ǰ���� "," ��ǰ�� ","�Ǹűݾ�"," �Ǹż���", "������"," ���Žð�"," ������"};
					
				JPanel rSouthPane = new JPanel(new BorderLayout());
					JPanel rStitle = new JPanel(new FlowLayout(FlowLayout.LEADING,78,10));//
					JButton lb4 = new JButton("�����Ȳ");
					JPanel rStext = new JPanel(); //pc�̿�ð�, ���Ǽ�  new GridLayout(2,4,2,2)
					JButton lbl2 = new JButton(" PC �̿�ð� ");
					JButton lbl3 = new JButton(" PC ���Ǽ� ");
					//JButton lbl4 = new JButton(" ���� �� ��� ���ϸ��� ");
					JButton t4 = new JButton();
					JButton t5 = new JButton();
					JButton t6 = new JButton("LogOut");
			
					
		public SaleCheck() {
		super("�� ������� �� ");
		add(BorderLayout.NORTH, northPane);
		add(BorderLayout.CENTER, centPane);
		
		northPane.add(BorderLayout.NORTH,nNorthPane);
		northPane.add(BorderLayout.CENTER,nCentPane);
		
		centPane.add(BorderLayout.WEST,leftPane);
		centPane.add(BorderLayout.CENTER, rightPane);
		
		leftPane.add(BorderLayout.CENTER,lCentPane);
		leftPane.add(BorderLayout.SOUTH,lSouthPane);
		
		lCentPane.add(BorderLayout.NORTH,lCtitle);
		lCentPane.add(BorderLayout.CENTER,lCtable);
		
		lSouthPane.add(BorderLayout.NORTH,lStitle);
		lSouthPane.add(BorderLayout.CENTER,lStext);
		
		
		rightPane.add(BorderLayout.CENTER,rCentPane);
		rightPane.add(BorderLayout.SOUTH,rSouthPane);

		rCentPane.add(BorderLayout.NORTH,rCtitle);
		rCentPane.add(BorderLayout.CENTER,rCtable);
		
		rSouthPane.add(BorderLayout.NORTH,rStitle);
		rSouthPane.add(BorderLayout.CENTER,rStext);
		
		//Frame - north
		//northPane.setPreferredSize(new Dimension(400, 100));
		nCentPane.setPreferredSize(new Dimension(1600, 50));
		setNorth();
		setNorth2();
		
		//Frame - center
		//leftPanel
		lCtitle.setPreferredSize(new Dimension(50, 49));
		lCtitle.setBackground(Color.white);
		//lCtable.setBackground(Color.DARK_GRAY);
		
		//lCentPane.setPreferredSize(new Dimension(400, 400));
		//lCtable.setPreferredSize(new Dimension(40, 700));
		setTable();
		
		
	
		//rightPanel
		rCtitle.setPreferredSize(new Dimension(50, 49));
		rCtitle.setBackground(Color.white); //������ ��ǰ�Ǹ� ����
		rCtable.setBackground(Color.white); //������ ���̺� ����
		
		setTable2();
		
		//left southpanel
		setlSouth();
		lStitle.setPreferredSize(new Dimension(850, 55));
		lStitle.setBackground(Color.white);
		lStext.setPreferredSize(new Dimension(850, 150));
				
		//right southPanel
		rStitle.setPreferredSize(new Dimension(850, 55));
		rStext.setPreferredSize(new Dimension(850, 150));
		setrSouth();
		//setSize(1600,900);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		restockMenuItem.addActionListener(this);
		userMenuItem.addActionListener(this);
		countMenuItem.addActionListener(this);
		mdMenuItem.addActionListener(this);
		t6.addActionListener(this);
		findlb.addActionListener(this);
		
		pcAllList();
		salesAllList();
		t3.setText(String.valueOf((Integer.parseInt(t1.getText())+ Integer.parseInt(t2.getText()))));
		
		}
		public void pcAllList() {
			PcDAO dao = new PcDAO();
			List<PcVO> list = dao.allRecord();
			setPcModel(list);
			
			int pay=0;//pc����հ�
			for(int i=0; i<table.getRowCount(); i++) {
				pay = pay + (int)(table.getValueAt(i,4)); //i�ٿ� 4��° ���� �����´�
			}
			t1.setText(String.valueOf(pay));
			
			int pay3=0;//pc�̿�ð�
			for(int i=0; i<table.getRowCount(); i++) {
				pay3 = pay3 + (int)(table.getValueAt(i, 3));
			}
			t4.setText(String.valueOf(pay3));
			
			int pay4=0;//pc ���Ǽ�
			for(int i=0; i<=table.getRowCount(); i++) {
				pay4 = i;
			}
			t5.setText(String.valueOf(pay4));
		}
		public void searchDate() {
			String startDate = (String)yearcombo.getSelectedItem()+makeTwo((String)monthCombo.getSelectedItem())+makeTwo((String)daycombo.getSelectedItem());
			String endDate = (String)yearcombo2.getSelectedItem()+makeTwo((String)monthCombo2.getSelectedItem())+makeTwo((String)daycombo2.getSelectedItem());
			PcDAO dao = new PcDAO();
			List<PcVO>list = dao.searchRecord(startDate,endDate);
			setPcModel(list);
			SalesDAO sDao = new SalesDAO();
			List<SalesVO> sList = sDao.searchRecord(startDate,endDate);
			setSalesModel(sList);
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
		
		
		public void setPcModel(List<PcVO> list) {
			//���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�.
			model.setRowCount(0); //������ �ִ°� ������� 0���� �ٲ����
			//�÷����� vo�� get�Ͽ� jtable�� ������� �߰��Ѵ�.
			for(int i=0; i<list.size(); i++) {
				PcVO vo = list.get(i);
				Object[] obj = {vo.getPc_num(), vo.getPc_no(), vo.getU_no(), vo.getPc_use(), vo.getPay(), vo.getPc_start(), vo.getPc_end(), vo.getManager()};
				model.addRow(obj);
			}
		}
		
		public void salesAllList() {
			SalesDAO dao = new SalesDAO();
			List<SalesVO> list = dao.allRecord();
			setSalesModel(list);
			
			int pay2=0;//��ǰ�Ǹ� ����
			for(int i=0; i<table2.getRowCount(); i++) {
				pay2 = pay2 + (int)(table2.getValueAt(i, 3));
			}
			t2.setText(String.valueOf(pay2));
			
		}
		
		public void setSalesModel(List<SalesVO> list) {
			//���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�.
			model2.setRowCount(0); //������ �ִ°� ������� 0���� �ٲ����
			//�÷����� vo�� get�Ͽ� jtable�� ������� �߰��Ѵ�.
			for(int i=0; i<list.size(); i++) {
				SalesVO vo = list.get(i);
				Object[] obj = {vo.getS_num(), vo.getP_class(), vo.getP_name(), vo.getS_price(), vo.getS_cnt(), vo.getU_no(), vo.getS_date(), vo.getManager()};
				// vo.getU_no(),
				model2.addRow(obj);
			}
		}
		
		
		
	public void setrSouth() {
		//rStitle.setPreferredSize(new Dimension(800, 200));
		lb4.setPreferredSize(new Dimension(130, 20));
		rStitle.add(lb4);
		lb4.setBackground(Color.DARK_GRAY);
		lb4.setForeground(Color.white);
		lb4.setPreferredSize(new Dimension(130, 40));//��ư ������
		Font fnt = new Font("���",Font.CENTER_BASELINE, 15); //��ư ��Ʈ
		lb4.setFont(fnt);
		
		rStitle.setBackground(Color.white);
		rStext.setBackground(Color.LIGHT_GRAY);
		rStext.setLayout(null);
		lbl2.setBounds(78,20,130,30);
		t4.setBounds(211,20,210,30);
		lbl3.setBounds(450,20,130,30);
		t5.setBounds(583,20,195,30);
		//lbl4.setBounds(300,70,170,30);
		//t6.setBounds(473,70,305,30);
		t6.setBounds(780,20,10,10);
		
		t4.setBackground(Color.white);
		t5.setBackground(Color.white);
		t6.setBackground(Color.LIGHT_GRAY);
		
		lbl2.setBackground(Color.LIGHT_GRAY);
		lbl3.setBackground(Color.LIGHT_GRAY);
		//lbl4.setBackground(Color.LIGHT_GRAY);
		Font fnt2 = new Font("���",Font.BOLD, 15); //��ư ��Ʈ
		lb2.setFont(fnt2);
		lb3.setFont(fnt2);
		lb4.setFont(fnt2);
		
		rStext.add(lbl2);
		rStext.add(t4);
		
		rStext.add(lbl3);
		rStext.add(t5);
		//rStext.add(lbl4);
		rStext.add(t6);
	}
	public void setlSouth() {
		lStitle.add(lb3);
		lb3.setBackground(Color.DARK_GRAY);
		lb3.setForeground(Color.white);
		lb3.setPreferredSize(new Dimension(100, 40));//��ư ������
		Font fnt = new Font("���",Font.CENTER_BASELINE, 15); //��ư ��Ʈ
		lb3.setFont(fnt);
		
		lStitle.setBackground(Color.white);
		lStext.setBackground(Color.LIGHT_GRAY);
		lStext.setLayout(null);
		bs1.setBounds(78,20,130,30);
		t1.setBounds(211,20,210,30);
		bs2.setBounds(450,20,130,30);
		t2.setBounds(583,20,195,30);
		bs3.setBounds(340,70,130,30);
		t3.setBounds(473,70,305,30);
		
		bs1.setBackground(Color.LIGHT_GRAY);
		bs2.setBackground(Color.LIGHT_GRAY);
		bs3.setBackground(Color.LIGHT_GRAY);
		
		t1.setBackground(Color.white);
		t2.setBackground(Color.white);
		t3.setBackground(Color.white);
		
		Font fnt2 = new Font("���",Font.BOLD, 12); //��ư ��Ʈ
		bs1.setFont(fnt2);
		bs2.setFont(fnt2);
		bs3.setFont(fnt2);
		
		
		lb3.setPreferredSize(new Dimension(130, 40));
		lStext.add(bs1);
		lStext.add(t1);
		
		lStext.add(bs2);
		lStext.add(t2);
		
		lStext.add(bs3);
		lStext.add(t3);
		
	}
	public void setTable2() {
		rCtitle.add(lb2);
		lb2.setPreferredSize(new Dimension(100, 40));//��ư ������
		Font fnt = new Font("���",Font.CENTER_BASELINE, 15); //��ư ��Ʈ
		lb2.setFont(fnt);
		
		lb2.setBackground(Color.DARK_GRAY);
		lb2.setForeground(Color.white);
		Object[][] data = {};
		model2 = new DefaultTableModel(data,title2);
		table2 = new JTable(model2); 
		sp2 = new JScrollPane(table2);
		
		table2.setPreferredScrollableViewportSize(new Dimension(30,50));
		table2.setFillsViewportHeight(true);
		
		sp2.setPreferredSize(new Dimension(700, 580));
		rCtable.add(BorderLayout.CENTER,sp2);
	}
	public void setTable() {
		
		
		//lCtitle.setLayout(null);
		//lbl.setBounds(100,100,100,30);
		lCtable.setBackground(Color.white);
		lCtitle.add(lb1);
		lb1.setPreferredSize(new Dimension(100, 40));//pc��� ��ưũ��
		
		Font fnt = new Font("���",Font.CENTER_BASELINE, 15); //��ư ��Ʈ
		lb1.setFont(fnt);
		lb1.setBackground(Color.DARK_GRAY);
		lb1.setForeground(Color.white);
		Object[][] data = {};
		model = new DefaultTableModel(data,title);
		table = new JTable(model); 
		sp = new JScrollPane(table);
		
		
		table.setPreferredScrollableViewportSize(new Dimension(30,50));
		table.setFillsViewportHeight(true);
		
		sp.setPreferredSize(new Dimension(700, 580));
		lCtable.add(BorderLayout.CENTER,sp);
		
	}
	
	public void setNorth2() {///������� ���� �����
		nCentPane.setBackground(Color.LIGHT_GRAY);
		nCentPane.setLayout(null);
		lbl.setBounds(210,7,180,35);
		yearcombo.setBounds(450,7,80,35);
		yearlb.setBounds(540,7,80,35);
		monthCombo.setBounds(600,7,50,35);
		monlb.setBounds(670,7,80,35);
		daycombo.setBounds(740,7,50,35);
		daylb.setBounds(810,7,80,35);
		flowlb.setBounds(880,7,80,35);
		
		yearcombo2.setBounds(928,7,80,35);
		yearlb2.setBounds(1020,7,80,35);
		monthCombo2.setBounds(1090,7,50,35);
		monlb2.setBounds(1160,7,80,35);
		daycombo2.setBounds(1230,7,50,35);
		daylb2.setBounds(1310,7,80,35);
		
		findlb.setBounds(1360,7,80,35);
		
		//ù��° �޺��ڽ��� �󺧵�

		northPane.setBackground(Color.white);
		
		nCentPane.add(lbl); //�Ⱓ�� ������Ȳ
		lbl.setBackground(Color.gray);
		lbl.setForeground(Color.white);
		Font fnt = new Font("���",Font.CENTER_BASELINE, 13); //��ư ��Ʈ
		lbl.setFont(fnt);
		//lbl.setBounds(2,100,300,300);
		//�� �޺��ڽ�
		String yearName[] = {"2021","2020"};
		yearmodel = new DefaultComboBoxModel<String>(yearName); //model�� fontname
		yearcombo.setModel(yearmodel);
		nCentPane.add(yearcombo);
		nCentPane.add(yearlb);
		
		//�� �޺��ڽ�
		String[] items = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthModel = new DefaultComboBoxModel<String>(items);
		monthCombo.setModel(monthModel);
		nCentPane.add(monthCombo);
		nCentPane.add(monlb);
		
		//�� �޺��ڽ�
		for(int i=0; i<31; i++) {
			dayName[i]= Integer.toString(i+1);
		}
		daymodel = new DefaultComboBoxModel<String>(dayName); //model�� fontname
		daycombo.setModel(daymodel);
		//findcombo.setSelectedItem("���հ˻�");
		nCentPane.add(daycombo);
		nCentPane.add(daylb);
		
		//����
		nCentPane.add(flowlb);
		
		
		
		
		//�ι�° �޺��ڽ��� �󺧵�
		
		//��
		String yearName2[] = {"2021","2020"};
		yearmodel2 = new DefaultComboBoxModel<String>(yearName2); //model�� fontname
		yearcombo2.setModel(yearmodel2);
		nCentPane.add(yearcombo2);
		nCentPane.add(yearlb2);
		//��		
		String[] items2 = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthModel2 = new DefaultComboBoxModel<String>(items2);
		monthCombo2.setModel(monthModel2);
		nCentPane.add(monthCombo2);
		nCentPane.add(monlb2);
		//��		
		for(int i=0; i<31; i++) {
			dayName2[i]= Integer.toString(i+1);
		}
		daymodel2 = new DefaultComboBoxModel<String>(dayName2); //model�� fontname
		daycombo2.setModel(daymodel2);
		nCentPane.add(daycombo2);
		nCentPane.add(daylb2);
		//�˻� ��ư
		nCentPane.add(findlb);
		findlb.setBackground(Color.gray);
		findlb.setForeground(Color.white);
	}
	
	public void setNorth() {
		//���� �ΰ� �޴���
		
		setJMenuBar(ad);
		tb.add(lbi);
		tb.add(lbi2);
		tb.add(ad);
		tb.setBackground(Color.DARK_GRAY);
		ad.setBackground(Color.DARK_GRAY);
		lbi2.setForeground(Color.white);
		countMenu.setForeground(Color.white);
		mdMenu.setForeground(Color.white);
		userMenu.setForeground(Color.white);
		payMenu.setForeground(Color.white);
		
		nNorthPane.add(BorderLayout.NORTH,tb);//BorderLayout.NORTH,
		ad.add(countMenu); ad.add(mdMenu);	ad.add(userMenu);	ad.add(payMenu); 
		countMenu.add(countMenuItem); userMenu.add(userMenuItem); payMenu.add(payMenuItem);
		mdMenu.add(restockMenuItem); mdMenu.add(mdMenuItem);
	}
	
		public void actionPerformed(ActionEvent ae) {
			Object event = ae.getActionCommand();//�̺�Ʈ�� �߻��� ������Ʈ
			if(event.equals("��ǰ����")){
				GoodsCheck gc = new GoodsCheck();
				gc.setVisible(true);
				
			}else if(event.equals("�԰����")) {
				RestockDialog rd = new RestockDialog();
				// rd.setVisible(true);
				 
			}else if(event.equals("ȸ������")){
				UserCheck uc = new UserCheck();
				uc.setVisible(true);
			}else if(event.equals("�������")) {
				SeatCheck sc = new SeatCheck();
				sc.setVisible(true);
				
			}else if(event.equals("LogOut")) {
//				LoginCheck lc = new LoginCheck();
//				lc.setVisible(true);
				System.exit(0);
			}else if(event.equals("Search")) {
				searchDate();
			}
//			if(event.equals("�԰����")) {
//				setVisible(true);
//			}else setVisible(false);
//		}
		}
	
	
	public static void main(String[] args) {
		new SaleCheck();

		
	}

}
