
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class GoodsCheck extends JFrame implements ActionListener{
	//JFrame - NORTH
	JPanel formPane = new JPanel(new BorderLayout());
		JToolBar tb = new JToolBar();
		ImageIcon icon1 = new ImageIcon("img/logo.png");
		JLabel lbl1 = new JLabel(icon1);
		JLabel lbl2 = new JLabel("�� BIT PC ��");
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
		
		
	//JFrame - Center (���ʿ� ���̶� �ؽ�Ʈ�ڽ� /�����ʿ� �� �г� ���� ����)
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel centerWestPane = new JPanel(new GridLayout(2,1,30,20));  //2���� �г�(upPane, twoPane)�� ��,���Ϳ� �� ����
			JPanel upPane = new JPanel(new BorderLayout()); //�г� ���Ϳ� ���� ��,������ �ؽ�Ʈ�ڽ� /���ʿ� ��ư 3��/
				JPanel upLTPane = new JPanel(new BorderLayout());
					JPanel lblPane = new JPanel(new GridLayout(5,1,10,15)); //�� 4�� 
						String formLbl[] = {"    ����","   ��ǰ���� ","    ��ǰ�� ","   �Ǹűݾ� ","   ��ǰ�޸� "};
					JPanel textPane = new JPanel(); //�޺��ڽ� 1��, �ؽ�Ʈ�ʵ� 3��   //new GridLayout(4,1)
						JComboBox<String> goodscombo = new JComboBox<String>();
						DefaultComboBoxModel<String>goodsmodel;
						
						JTextField formTf0 = new JTextField(15);
						JTextField formTf1 = new JTextField(15);
						JTextField formTf2 = new JTextField(15);
						JTextField formTf3 = new JTextField(15);
						//����, ����, �����Է�,��ǰ���� ��ư 3��
						JPanel upSouthPane = new JPanel(new FlowLayout(FlowLayout.LEADING, 12,7)); //flowlayout���� ��ư 4��
							JButton b1 = new JButton("�߰�");
							JButton b2 = new JButton("����");
							JButton b3 = new JButton("�����Է�");
							JButton b6 = new JButton("����");
							JButton b5 = new JButton("��ǰ���� �߰�/����");
						
			JPanel twoPane = new JPanel(new BorderLayout()); //���� �߰� �г�
				JPanel twoLTPane = new JPanel(new BorderLayout());// ���� �߰� ��,���� �ؽ�Ʈ�ڽ�
					JPanel twoLblPane = new JPanel(new GridLayout(4,1,10,10)); //���� ��
						String twoLbl[] = {"    �԰���� ","    �԰��� ","    �������","    �԰�޸� "};
						JPanel twotextPane = new JPanel();//������ �ؽ�Ʈ
						JTextField twoTf1 = new JTextField(15);
						JTextField twoTf2 = new JTextField(15);
						JTextField twoTf3 = new JTextField(15);	
						JTextField twoTf4 = new JTextField(15);
//					JPanel twotextPane = new JPanel(new GridLayout(3,1));//������ �ؽ�Ʈ
//						JTextField[] twoTf = {new JTextField(15), new JTextField(15), new JTextField(15)};
				JPanel twoSouthPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 38,40)); //��ư �ϳ� �� �ڸ�
					JButton b4 = new JButton("�԰�ó��");
		
	JPanel centerCentPane = new JPanel(new BorderLayout()); //���� �޴��ٶ� ���Ϳ� jtable�� �� 
		JMenuBar gd = new JMenuBar();
		JMenu goodMenu = new JMenu("��ǰ��Ȳ");
		//JMenu goodsMenu = new JMenu("    ��ǰ����      ");
		JLabel lb = new JLabel(" �� ���ο� ��ǰ�� ����ϰų� ��ϵ� ��ǰ�� �߰�, ����, �԰�ó�� �� �� �ֽ��ϴ� ��  ");

		JTable table;
		JScrollPane sp;
		DefaultTableModel model;
		String title[] = {"����","��ǰ���� ","��ǰ�� "," �Ǹűݾ� ","������","��ǰ�޸�"};
	
	//JFrame = South 
	JPanel southPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,10));
//		JButton b7 = new JButton("���Ρ�");	
//		JButton b8 = new JButton("�Ʒ��Ρ�");	
//		JButton b9 = new JButton("���� ������� ����");	
	
	String pName="";
	String pClass="";
	String pNum;
	public GoodsCheck() {
		super(" �� ��ǰ���� �� ");
		//setBackground(Color.lightGray);
		add(BorderLayout.NORTH, formPane);
		add(BorderLayout.CENTER, centerPane);
		add(BorderLayout.SOUTH, southPane);
		
		centerPane.add(BorderLayout.WEST,centerWestPane);
		centerPane.add(BorderLayout.CENTER,centerCentPane);//add(tp);//���г��� �⺻�гο� ���ִ°���?
		
		centerWestPane.setPreferredSize(new Dimension(300, 1000));
		
		centerWestPane.add(upPane);
		centerWestPane.add(twoPane);
		
		//Frame - North
		setForm();
		//Frame - Center
		setLeft1();
		setLeft2();
		//setLeft3();
		setRight();
		//Frame = South
		setSouth();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//setSize(1000,900);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		restockMenuItem.addActionListener(this);
		userMenuItem.addActionListener(this);
		payMenuItem.addActionListener(this);
		countMenuItem.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		goodMenu.addActionListener(this);
		goodscombo.addActionListener(this);
		formTf1.addActionListener(this);
		formTf2.addActionListener(this);
		formTf3.addActionListener(this);
		
		goodsAllList();
		allRecordPC();
	}
	public void setSouth() {
		southPane.setBackground(Color.WHITE);
//		southPane.add(b7);
//		southPane.add(b8);
//		southPane.add(b9);
	}
	public void setLeft2() {
		twotextPane.setLayout(null);
		twoPane.add(twoLTPane);
		twoLTPane.setPreferredSize(new Dimension(250, 150)); //�г� ������ ���� //250,200
		twoLblPane.setPreferredSize(new Dimension(70, 70)); //�г� ������ ����
		twotextPane.setPreferredSize(new Dimension(100, 130)); //�г� ������ ���� //100,200
		
		twoLTPane.add(BorderLayout.CENTER, twotextPane);
		twoLTPane.add(BorderLayout.WEST, twoLblPane);
		twoPane.add(BorderLayout.SOUTH, twoSouthPane);
		
		twoLTPane.setBackground(Color.white); //���󺯰�
		twoLblPane.setBackground(Color.white);
		twotextPane.setBackground(Color.white);
		twoSouthPane.setBackground(Color.white);
		
		for(int i=0; i<twoLbl.length; i++) {
			JLabel lbl = new JLabel(twoLbl[i]);
			twoLblPane.add(lbl);
			Font fnt = new Font("���� ���",Font.BOLD, 12);
			lbl.setFont(fnt);
		}
		
		twoTf1.setLocation(400,80);
		twoTf1.setBounds(2 ,25 , 190, 30);
		twoTf2.setBounds(2, 99, 190, 30);
		twoTf3.setBounds(2, 174, 190, 30);
		twoTf4.setBounds(2,249,190,30);
		
		
		twotextPane.add(twoTf1);
		twotextPane.add(twoTf2);
		twotextPane.add(twoTf3);
		twotextPane.add(twoTf4);
			
		twoSouthPane.add(b4);
		Font fnt = new Font("���� ���",Font.BOLD, 12);
		b4.setFont(fnt);
		b4.setBackground(Color.LIGHT_GRAY);
		b4.setPreferredSize(new Dimension(100, 40));
		
	}
	
	public void setLeft1() {
		upPane.setBackground(Color.WHITE);
		lblPane.setBackground(Color.white);
		textPane.setBackground(Color.white);
		upSouthPane.setBackground(Color.white);
			
	
	upPane.add(upLTPane);
	upPane.setPreferredSize(new Dimension(400, 500));
	upLTPane.setPreferredSize(new Dimension(250, 150)); //�г� ������ ���� //250,200
	lblPane.setPreferredSize(new Dimension(70, 70)); //�г� ������ ����
	textPane.setPreferredSize(new Dimension(100, 130)); //�г� ������ ���� //100,200
	upSouthPane.setPreferredSize(new Dimension(100, 100));
	upLTPane.add(BorderLayout.WEST, lblPane); //���г� 
	upLTPane.add(BorderLayout.CENTER,textPane);//�ؽ�Ʈ�г�
	upPane.add(BorderLayout.SOUTH, upSouthPane); //��ư�г�
	
		for(int i=0; i<formLbl.length; i++) {
		JLabel lbl = new JLabel(formLbl[i]);
		lblPane.add(lbl);
		Font fnt = new Font("���� ���",Font.BOLD, 12);
		lbl.setFont(fnt);
	}
		
		textPane.setLayout(null);
		//String goodsName[] = {"����/����","��Ʈ/�߽�/Ƣ��","�Ļ��","�н�/���","���/�쵿","Ŀ��/����"};
		goodsmodel = new DefaultComboBoxModel<String>(); 
		goodscombo.setModel(goodsmodel);	
		goodscombo.setPreferredSize(new Dimension(10,10));
		textPane.add(goodscombo);
		
	/*�ؽ�Ʈ �ڽ� �迭�� for�� ������
	 * for(int i=0; i<formTf.length; i++) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(formTf[i]);  //Ȯ��Ǵ� �� �������ؼ� JPanel���� �ѹ� �� ����
		textPane.add(p); 
	}*/
		//JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		formTf0.setBounds(2,15, 40, 30 );
		goodscombo.setBounds(2, 80, 190, 30);
		formTf1.setBounds(2 ,145 , 190, 30);
		formTf2.setBounds(2 ,210 , 190, 30);
		formTf3.setBounds(2,280 , 190, 30);
		
		
		textPane.add(formTf0);
		textPane.add(formTf1);
		textPane.add(formTf2);
		textPane.add(formTf3);

	//��ư 3�� �ֱ�
	b1.setPreferredSize(new Dimension(65, 28));
	b2.setPreferredSize(new Dimension(73, 28));
	b3.setPreferredSize(new Dimension(88, 28));
	b6.setPreferredSize(new Dimension(65, 45));
	b5.setPreferredSize(new Dimension(175, 45));
	
	Font fnt = new Font("���� ���",Font.BOLD, 20);
	
	
	Font fnt2 = new Font("���� ���",Font.BOLD, 13);
	b1.setFont(fnt2);
	b2.setFont(fnt2);
	b3.setFont(fnt2);
	b6.setFont(fnt2);
	b5.setFont(fnt2);
	
	b1.setBackground(Color.LIGHT_GRAY);
	b2.setBackground(Color.LIGHT_GRAY);
	b3.setBackground(Color.LIGHT_GRAY);
	b5.setBackground(Color.darkGray);
	b6.setBackground(Color.LIGHT_GRAY);
	b5.setForeground(Color.white);
	
	upSouthPane.add(b1);
	upSouthPane.add(b2);
	upSouthPane.add(b3);
	upSouthPane.add(b6);
	upSouthPane.add(b5);
	
	
	}
	public void setRight() {
		setJMenuBar(gd);
		
		gd.setPreferredSize(new Dimension(400, 55));
		Font fnt = new Font("���� ���",Font.BOLD, 12);
		lb.setFont(fnt);
		goodMenu.setFont(fnt);
		goodMenu.setHorizontalAlignment(JMenu.CENTER);
		lb.setHorizontalAlignment(JLabel.CENTER);
		gd.add(goodMenu);	gd.add(lb); //gd.add(goodsMenu);  //gd.add(lbl); 
		centerCentPane.add(BorderLayout.NORTH,gd);
		
		model = new DefaultTableModel(title,0);
		table = new JTable(model); 
		sp = new JScrollPane(table);
		
		table.setPreferredScrollableViewportSize(new Dimension(30,50));
		table.setFillsViewportHeight(true);
		centerCentPane.add(BorderLayout.CENTER,sp);
		
		table.addMouseListener(new JtableMouseEventGoods(goodscombo,formTf0,formTf1,formTf2, formTf3, table));//���콺 ���ʹ�ư

	
	}
	public void setForm() {
		setJMenuBar(ad);
		//ad.setBackground(Color.white);
		formPane.setLayout(new GridLayout(1,5));
		
		Font fnt = new Font("���� ���",Font.BOLD, 13);
		lbl2.setFont(fnt);
		countMenu.setFont(fnt);
		mdMenu.setFont(fnt);
		userMenu.setFont(fnt);
		payMenu.setFont(fnt);
		restockMenuItem.setFont(fnt);
		
		tb.add(lbl1);
		tb.add(lbl2);
		tb.add(ad);
		
		//tb.setBackground(Color.white);
		add(BorderLayout.NORTH,tb); 
		ad.add(countMenu); ad.add(mdMenu);	ad.add(userMenu);	ad.add(payMenu); 
		countMenu.add(countMenuItem); userMenu.add(userMenuItem); payMenu.add(payMenuItem);
		 mdMenu.add(mdMenuItem); mdMenu.add(restockMenuItem);
	}
	
	public void goodsAllList() { //ȣ��Ǹ� ȸ�� ��ü��� ���(�̸��������)
		GoodsDAO dao = new GoodsDAO();
		List<GoodsVO> list = dao.allRecord();
		setGoodsModel(list);
		
	}
	
	public void setGoodsModel(List<GoodsVO> list) {
		//���� JTable�� ����� ����� ���� ����Ʈ�� ����Ѵ�.
		model.setRowCount(0); //������ �ִ°� ������� 0���� �ٲ����
		//�÷����� vo�� get�Ͽ� jtable�� ������� �߰��Ѵ�.
		for(int i=0; i<list.size(); i++) {
			GoodsVO vo = list.get(i);
			Object[] obj = {vo.getP_num(), vo.getP_class(), vo.getP_name(), vo.getS_price(), vo.getP_stock(), vo.getRemark()};
			model.addRow(obj);
			
			
		}
	}
	
		public void actionPerformed(ActionEvent ae) {
		
		Object event = ae.getActionCommand();//�̺�Ʈ�� �߻��� ������Ʈ
		if(event.equals("�������")){
			SeatCheck sc = new SeatCheck();
			sc.setVisible(true);
		}else if(event.equals("�԰����")) {
			RestockDialog rd = new RestockDialog();
		 	 //rd.setVisible(true);
		}else if(event.equals("ȸ������")){
			UserCheck uc = new UserCheck();
			uc.setVisible(true);
		}else if(event.equals("�������")) {
			SaleCheck sc = new SaleCheck();
			sc.setVisible(true);
		}
		if(event.equals("�߰�")) {
			goodsInsert();
			goodsAllList();
		}else if(event.equals("����")) {
			goodsDel();
			goodsAllList();
		}else if(event.equals("�����Է�")){
			formTf0.setText("");
			formTf1.setText("");
			formTf2.setText("");
			formTf3.setText("");
			
		}else if(event.equals("����")) {
			goodsUpdate();
			goodsAllList();
			
		}else if(event.equals("��ǰ��Ȳ")) {
			goodsAllList();
		}else if(event.equals("�԰�ó��")) {
			allRecordPs();
			miniRestockInsert();
			goodsAllList();
		}else if(event.equals("��ǰ���� �߰�/����")) {
			P_ClassDialog pc = new P_ClassDialog();
			allRecordPC();
			//pc.setVisible(true);
		}
		
		if(event.equals("�԰����")) {
			setVisible(true);
		}else  {//setVisible(false);
		
		}
		
	}

		//�̴� �԰�ó��
		public void miniRestockInsert() {
			String restockname = twoTf1.getText();
			String restockname2 = twoTf2.getText();
			RestockCheck rc = new RestockCheck();
			RestockDAO rd = new RestockDAO();
			if(restockname==null || restockname.equals("")){
				JOptionPane.showMessageDialog(this, "�԰������ �Է��ϼ���!");
			}else if(restockname2==null ||  restockname2.equals("")) {
				JOptionPane.showMessageDialog(this, "�԰����� �Է��ϼ���!");
			}else {
				String goodsname = formTf1.getText();
				String givecombo = (String)goodscombo.getSelectedItem();
				
				JOptionPane.showMessageDialog(this, goodsname +"��ǰ�� �԰��߽��ϴ�!");
			
				RestockVO vo = new RestockVO();
				GoodsVO vo2 = new GoodsVO();
			
				
				
				vo.setP_name(goodsname);//��ǰ��
				vo.setP_class(givecombo);//��ǰ����
				vo.setE_Num(Integer.parseInt(formTf0.getText())); //����
				vo.setE_cnt(Integer.parseInt(twoTf1.getText())); //�԰����
				//vo2.setP_stock(Integer.parseInt(twoTf1.getText())); //�԰������ �������� 
				vo.setE_price(Integer.parseInt(twoTf2.getText()));//�԰���
				vo.setExpiry(Integer.parseInt(twoTf3.getText()));//�������
				vo.setRemark(twoTf4.getText());//�԰�޸�
			
				RestockDAO dao2 = new RestockDAO();
				int cnt = dao2.insertRecord(vo); //�߰�(�Ȱ��� �����ε� ���� �ٸ� �� �����ϱ�)
				
				if(cnt>0) {//��ǰ�߰�
					esCnt(goodsname);
					formDataClear(); //ȸ���� �߰��Ǹ� ���� �����͸� �����.
					goodsAllList(); //������ Ȯ���� 
					rc.restockAllList();
					rd.allRecord();
					rc.setRestockModel(rd.allRecord());
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
	
	}	
		
		
	//��ǰ�߰�	
	public void goodsInsert() {
		
		String goodsname = formTf1.getText();
		String goodsname2 = formTf2.getText();
		
		if(goodsname==null || goodsname.equals("") ) {
			JOptionPane.showMessageDialog(this, "��ǰ���� �Է��ϼ���!");
		}else if(goodsname2==null || goodsname2.equals("")) {
			JOptionPane.showMessageDialog(this, "��ǰ�ݾ��� �Է��ϼ���!");
		}else {
			
			GoodsVO vo = new GoodsVO();
			
			String givecombo = (String)goodscombo.getSelectedItem();
			vo.setP_name(goodsname);
			vo.setP_class(givecombo);
			vo.setS_price(Integer.parseInt(formTf2.getText()));
			vo.setRemark(formTf3.getText());
			//vo.setRemark(formTf3.getText());
			
			GoodsDAO dao = new GoodsDAO();
			int cnt = dao.insertRecord(vo);
			if(cnt>0) {//��ǰ�߰�
				JOptionPane.showMessageDialog(this, goodsname+"  ��ǰ�� �߰��Ǿ����ϴ�!");
				formDataClear(); //ȸ���� �߰��Ǹ� ���� �����͸� �����.
				goodsAllList();
				
			}else{//�߰����н� �ȳ� �޼��� ǥ�� 
				JOptionPane.showMessageDialog(this,"��ǰ�߰� �����Ͽ����ϴ�"); //�θ������̳�,�޼���
			
			}
			
		}
	}
	//��ǰ����
	
		public void goodsUpdate() {
			String goodsname = formTf1.getText();
			//String goodsname2 = formTf2.getText();
			String givecombo = (String)goodscombo.getSelectedItem();
			
			GoodsVO vo = new GoodsVO();
			vo.setP_name(goodsname);
			vo.setS_price(Integer.parseInt(formTf2.getText()));
			vo.setP_class(givecombo);	
			vo.setRemark(formTf3.getText());
			vo.setP_num(Integer.parseInt(formTf0.getText())); //formTf�� 0��°�� ��ȣ�� �ִ� //���ڸ� int�� �ٲ㼭
		
			GoodsDAO dao = new GoodsDAO(); //DAO ��ü����
			int cnt = dao.updateRecord(vo);
			if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
				JOptionPane.showMessageDialog(this, goodsname+ " ��ǰ�� �����Ǿ����ϴ�!");
				goodsAllList();//��ü��� ���
			}else{//�������н� �ȳ� �޼��� ǥ�� 
				JOptionPane.showMessageDialog(this,"��ǰ���� ���� �����Ͽ����ϴ�"); //�θ������̳�,�޼���
			}
		}
	
	
	
	
	//��ǰ����
	public void goodsDel() {
		//������ ��ǰ��ȣ 
				String delNum = formTf1.getText(); //���� num���� �־���ϴµ� �츮�� �Է¹޴� num�� ���� / ���ڰ� ������ "5", ������ " "
			
				if(delNum==null || delNum.equals("")){
				JOptionPane.showMessageDialog(this, "������ ��ǰ�� ������ ������ư�� Ŭ���ϼ���");
				}else {//������ �ؼ� ���� ���� ��� 
					GoodsDAO dao = new GoodsDAO();
					int result = dao.deleteRecord((delNum)); //������ �����ȣ�� int�� ������Ѽ� deleterecord�� �Ű������� ����
					//result�� ������ ���ڵ� ���� �������
					if(result>0) { //ȸ��������
						JOptionPane.showMessageDialog(this, delNum+"��ǰ�� �����Ͽ����ϴ�.");
						goodsAllList();//����Ʈ �ٽ� ������
						formDataClear();
					}else { //ȸ������ �ȵ�
						JOptionPane.showMessageDialog(this, delNum+"��ǰ������ �����Ͽ����ϴ�.");
					}
				}
	}
	
	//������
	
		public void allRecordPs() {
			String goodsname = formTf1.getText();
			GoodsVO vo = new GoodsVO();
			vo.setP_name(goodsname);
			vo.setP_name(goodsname);
			vo.setP_name(goodsname);
			
			vo.setP_stock(vo.getP_stock());
			vo.setE_cnt(Integer.parseInt(twoTf1.getText()));
			vo.setS_cnt(vo.getS_cnt());
			//vo.setFinal_stock(vo.getP_stock());
			GoodsDAO dao = new GoodsDAO(); //DAO ��ü����
			int cnt = dao.updateRecordPstock(vo);
			if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
				JOptionPane.showMessageDialog(this, goodsname + "�������� �����Ǿ����ϴ�!");
				goodsAllList();//��ü��� ���
			}else{//�������н� �ȳ� �޼��� ǥ�� 
				JOptionPane.showMessageDialog(this,"������ ���� �����Ͽ����ϴ�"); //�θ������̳�,�޼���
			}
			
		}
		
	public void esCnt(String goodsname) {//������ ���� (�԰� �߻� or �Ǹ� �߻�) 
		GoodsDAO gd = new GoodsDAO();
		int result2 = gd.getE_cnt(goodsname);
		int result3 = gd.getS_cnt(goodsname);
		gd.setStock(goodsname,result2-result3);
		
	}
		
	public void formDataClear() {
			formTf1.setText("");//num���� ������ �Ǵµ� ���� �̻���
			formTf2.setText("");
			formTf3.setText("");
	}
	public static void main(String[] args) {
		new GoodsCheck();

	}

}
