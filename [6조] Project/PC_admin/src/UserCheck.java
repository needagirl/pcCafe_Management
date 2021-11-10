import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import javax.swing.ButtonGroup;
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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class UserCheck extends JFrame implements ActionListener {
	Scanner sc = new Scanner(System.in);
	JPanel p1 = new JPanel(); //���� ū �г�
	
	JPanel p2 = new JPanel(); //���� �г�(�ΰ�� �޴��ٰ� ��)
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
		
		JPanel jp = new JPanel();
	JSplitPane sp1, sp2; //���� ������ ���������� / ������ �гθ� ���Ʒ��� �� ������
		JPanel p3 = new JPanel(new BorderLayout()); //���ʿ� �� ȸ������ 
			JLabel l00 = new JLabel("��ȸ������ �� ȸ������ Ȯ�΢�");
			JLabel l0 = new JLabel("<ȸ����ȣ>");
			JLabel l1 = new JLabel("<�̸�>");
			JLabel l2 = new JLabel("<���̵�>");
			JLabel l3 = new JLabel("<��й�ȣ>");
			JLabel l4 = new JLabel("<�ּ�>");
			JLabel l44 = new JLabel("�������");	
			
			JLabel l55 = new JLabel("<����>");	
			JRadioButton r1 = new JRadioButton("���� ��1");
			JRadioButton r2 = new JRadioButton("���� ��2 ");
			
			JLabel l5 = new JLabel("<����ó>");
			JLabel l6 = new JLabel("<�� �̿�ð�>");
			JLabel l7 = new JLabel("<�� �̿�ݾ�>");
			JLabel l8 = new JLabel("<�ܿ��ð�>");
			
			
			JTextField jt0 = new JTextField(10);
			JTextField jt00 = new JTextField(10);
			JTextField jt1 = new JTextField(10);
			JTextField jt2 = new JTextField(10);
			JPasswordField jt3 = new JPasswordField(10);
			JTextField jt4 = new JTextField(10);
			JTextField jt44 = new JTextField(10);
			JTextField jt5 = new JTextField(10);
			JTextField jt6 = new JTextField(10);
			JTextField jt7 = new JTextField(10);
			JTextField jt8 = new JTextField(10);
			
			JLabel lb = new JLabel(" < �� �� >");
			JTextField jtt = new JTextField(10);
			

			JPanel p6 = new JPanel();
			JButton b1 = new JButton("�߰�");
			JButton b2 = new JButton("����");
			JButton b3 = new JButton("����");
			JButton b5 = new JButton("�����Է�");
			
		JPanel p4 = new JPanel(); //�����ʿ� ���� �� �˻�, ��ư �̰�����
			JComboBox<String> findcombo = new JComboBox<String>();//�˻� �޺��ڽ�
			DefaultComboBoxModel<String>findmodel = new DefaultComboBoxModel<String>();
			JTextField jt9 = new JTextField(20);
			JButton b4 = new JButton("�˻�");
			JButton b6 = new JButton("��ü���");

		
		JPanel p5 = new JPanel(); // ������ �Ʒ� JTable(db����)
		
		JTable table;
		JScrollPane spp;
		DefaultTableModel model;
		String title[] = {"ȸ����ȣ","����","ȸ���̸�","���̵�","��й�ȣ","�ּ�","�������","����ó","�� �̿�ð�","�� �̿�ݾ�","ȸ�������", "���"};
		
		
	public UserCheck() {
		super(" �� ȸ������ �� ");
		//p1 ū�гο� ���ٳְ� p2�� (�ΰ�, �޴���)
		add(p1);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.white);
		
		
		
		p1.setLayout(new BorderLayout());
		p1.add(BorderLayout.NORTH, p2);
		p1.add(jp);
		setJMenuBar(ad);
		ad.setBackground(Color.white);
		p2.setLayout(new GridLayout(1,5));
		tb.add(lbl1);
		tb.add(lbl2);
		tb.add(ad);
		//tb.add(l9);
		tb.setBackground(Color.white);
		add(BorderLayout.NORTH,tb);
		ad.add(countMenu); ad.add(mdMenu);	ad.add(userMenu);	ad.add(payMenu); 
		countMenu.add(countMenuItem); userMenu.add(userMenuItem); payMenu.add(payMenuItem);
		mdMenu.add(restockMenuItem); mdMenu.add(mdMenuItem);
		//p3
		p3.setLayout(new GridLayout(30,1,0,2));//
		
		//��� ���� (��, �ؽ�Ʈ�ʵ� ����)
		l00.setHorizontalAlignment(JLabel.CENTER);
		l0.setHorizontalAlignment(JLabel.CENTER);
		l1.setHorizontalAlignment(JLabel.CENTER);
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4.setHorizontalAlignment(JLabel.CENTER);
		l44.setHorizontalAlignment(JLabel.CENTER);
		l5.setHorizontalAlignment(JLabel.CENTER);
		l55.setHorizontalAlignment(JLabel.CENTER);
		l6.setHorizontalAlignment(JLabel.CENTER);
		l7.setHorizontalAlignment(JLabel.CENTER);
		l8.setHorizontalAlignment(JLabel.CENTER);
		r1.setHorizontalAlignment(JRadioButton.CENTER);
		r2.setHorizontalAlignment(JRadioButton.CENTER);
		lb.setHorizontalAlignment(JLabel.CENTER);
		r1.setBackground(Color.WHITE);
		r2.setBackground(Color.WHITE);
		
		
		
		
		Font fnt = new Font("���� ���",Font.BOLD, 13);
		Font fnt1 = new Font("���� ���",Font.BOLD, 16);
		
		l00.setFont(fnt);
		l0.setFont(fnt);
		l1.setFont(fnt);
		l2.setFont(fnt);
		l3.setFont(fnt);
		l4.setFont(fnt);
		l44.setFont(fnt);
		l5.setFont(fnt);
		l55.setFont(fnt);
		l7.setFont(fnt);
		l8.setFont(fnt);
		l6.setFont(fnt);
		r1.setFont(fnt);
		r2.setFont(fnt);
		lb.setFont(fnt);
		r1.setFont(fnt);
		r2.setFont(fnt);
		b1.setFont(fnt);
		b2.setFont(fnt);
		b3.setFont(fnt);
		b4.setFont(fnt);
		b5.setFont(fnt);
		b6.setFont(fnt);
		findcombo.setFont(fnt);
		
		jt0.setHorizontalAlignment(JTextField.CENTER);
		jt00.setHorizontalAlignment(JTextField.CENTER);
		jt1.setHorizontalAlignment(JTextField.CENTER);
		jt2.setHorizontalAlignment(JTextField.CENTER);
		jt3.setHorizontalAlignment(JPasswordField.CENTER);
		jt4.setHorizontalAlignment(JTextField.CENTER);
		jt44.setHorizontalAlignment(JTextField.CENTER);
		jt5.setHorizontalAlignment(JTextField.CENTER);
		jt6.setHorizontalAlignment(JTextField.CENTER);
		jt7.setHorizontalAlignment(JTextField.CENTER);
		jt8.setHorizontalAlignment(JTextField.CENTER);
		jtt.setHorizontalAlignment(JTextField.CENTER);
		
		//p3�� ȸ������ �� ȸ������ Ȯ�� �ֱ�
		p3.add(l00);
		p3.add(l0);
		p3.add(jt0);
		
		p3.add(l1);
		p3.add(jt1);
		
		p3.add(l2);
		p3.add(jt2);
		
		p3.add(l3);
		p3.add(jt3);
		
		p3.add(l4);
		p3.add(jt4);
		p3.add(l44);
		p3.add(jt44);
		
		p3.add(l55);
		ButtonGroup bg = new ButtonGroup();
		
		
		bg.add(r1); bg.add(r2);	
		p3.add(r1);
		p3.add(r2);
		
		p3.add(l5);
		p3.add(jt5);
		
		p3.add(l6);
		p3.add(jt6);
		
		p3.add(l7);
		p3.add(jt7);
		
		p3.add(l8);
		p3.add(jt8);
		
		p3.add(lb);
		jtt.setPreferredSize(new Dimension(10,200));
		p3.add(jtt);
		
		b1.setBackground(Color.getHSBColor(203, 145, 190)); //183,79,254 // 152,128,100
		b2.setBackground(Color.getHSBColor(152, 135, 100));
		b3.setBackground(Color.getHSBColor(253, 220, 254)); //253,380,100
		b4.setBackground(Color.getHSBColor(253, 220, 254));
		b5.setBackground(Color.getHSBColor(253, 100, 250));
		b6.setBackground(Color.getHSBColor(253,100, 250)); //253,220,254-�ʷ� //152, 135, 100->���ʷ� //253,220, 284-���  //203,145, 190
		p6.setBackground(Color.white);
		p6.add(b1);
		p6.add(b2);
		p6.add(b3);
		p6.add(b5);
		
		b1.setPreferredSize(new Dimension(90,30));
		b2.setPreferredSize(new Dimension(90,30));
		b3.setPreferredSize(new Dimension(90,30));
		b5.setPreferredSize(new Dimension(90,30));
		
		// p4�� �˻�, ��ư ��� �ֱ�
		
		p4.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		
		String findName[] = {"���հ˻�","�̸�","���̵�","����"};
		findmodel = new DefaultComboBoxModel<String>(findName); //model�� fontname
		findcombo.setModel(findmodel);

		p4.add(findcombo);
		p4.add(jt9);
		jt9.setPreferredSize(new Dimension(70, 30));
		p4.add(b4);
		p4.add(b6);

		model = new DefaultTableModel(title,0);
		table = new JTable(model); 
		spp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1200,700)); //jtable ũ�� ����
		spp.setBackground(Color.WHITE);
		
		table.setPreferredScrollableViewportSize(new Dimension(1200,700));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new JTableMouseEventUser(jt0,jt1,jt2,jt3,jt4,jt44,jt5,jt6,jt7,r1,r2,jtt,table));
		
		p5.add(spp);
		p4.add(p5);
		
		
		//���򳪴��� 
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p3, p4);
		
		//���������� (P3�� ���Ʒ���)
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, p3, p6);
		
		//p4.add(sp2);
		p3.setPreferredSize(new Dimension (320,700));
		sp2.setDividerLocation(810);
		sp2.setDividerSize(0);
		
		p1.add(sp1);
		p1.add(BorderLayout.WEST,sp2);
		
		sp1.setDividerLocation(320);
		sp1.setDividerSize(10);
		//sp1.setOneTouchExpandable(true);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setSize(1000,900);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		

		restockMenuItem.addActionListener(this);
		payMenuItem.addActionListener(this);
		mdMenuItem.addActionListener(this);
		countMenuItem.addActionListener(this);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		
		
		userAllList();
	}
	//������ ���̽����� ȸ�� ��ü��� (�̸�������) �������� -JTable����� ������
	public void userAllList() { //ȣ��Ǹ� ȸ�� ��ü��� ���(�̸��������)
		UserDAO dao = new UserDAO();
		List<UserVO> list = dao.allRecord();
		setUserModel(list);
			
	}
	public void setUserModel(List<UserVO> list) {
			model.setRowCount(0); 
			//�÷����� vo�� get�Ͽ� jtable�� ������� �߰��Ѵ�.
			for(int i=0; i<list.size(); i++) {
				UserVO vo = list.get(i);
				//SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("y-MM-dd");
				//String format1 =  simpleDateFormat1.format(vo.getBirth());
				String format1 = vo.getBirth().substring(0,10);


				Object[] obj = {vo.getU_no(), vo.getSex(), vo.getName(), vo.getId(),vo.getPwd(),vo.getAddr(),format1,vo.getTel(), vo.getPc_use(), vo.getPay(),vo.getWrite_date(),vo.getRemark()};
				model.addRow(obj);
		}
	}	
	
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getActionCommand();
		if(event.equals("��ǰ����")){
			GoodsCheck gc = new GoodsCheck();
			gc.setVisible(true);
			
		}else if(event.equals("�԰����")) {
			RestockDialog rd = new RestockDialog();
			 rd.setVisible(true);
			 
		}else if(event.equals("�������")){
			SeatCheck sc = new SeatCheck();
			sc.setVisible(true);
		}else if(event.equals("�������")) {
			SaleCheck sc = new SaleCheck();
			sc.setVisible(true);
			
		}
	
		if(event.equals("�߰�")) {
			IF();
			userInsert();
			userAllList();
		}else if(event.equals("����")) {
			userDelete();
			userAllList();
		}else if(event.equals("�����Է�")) {
			formDataClear();
		}else if(event.equals("����")) {
			userUpdate();
		}else if(event.equals("�˻�")) {
			userSearch();
		}else if(event.equals("��ü���")) {
			userAllList();
		}
	
		if(event.equals("�԰����")) {
			setVisible(true);
		}else //setVisible(false);
		{
			
		}
	
	
	}
	public void IF() {
		String name = jt1.getText();
		String id = jt2.getText();
		String pw = new String(jt3.getPassword());
		String addr = new String(jt4.getText());
		String birth = new String(jt44.getText());
		String tel = new String(jt5.getText());
	      //String pw3 = new String(checkpw.getPassword());
	      
		  if(name==null || name.equals("")){
		  JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���.");
		  }else if(!name.matches(".*[��-����-�Ӱ�-�R]+.*")) {JOptionPane.showMessageDialog(this, "�̸�(�ѱ�)�� �Է��ϼ���"); 
		  }else if(id.equals("") || id.equals("")) { JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���."); 
		  }else if(!id.matches("^[A-Za-z[0-9]]*$")) {
		  JOptionPane.showMessageDialog(this, "���̵�� ���� �Ǵ� ���ڸ� ����Ͽ� �Է��ϼ��� ");
	      } else if(pw.equals("") || pw==null) { JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���"); 
	      }else if((pw.length()<6 || pw.length()>20 )){ JOptionPane.showMessageDialog(this, "��й�ȣ�� 6�ڸ� �̻�, 20�ڸ� ���Ͽ��� �մϴ�.");
	      } else if(addr.equals("") || addr.equals("")) { JOptionPane.showMessageDialog(this, "�ּҸ� �Է��ϼ���"); 
		  } else if(birth.equals("") || birth.equals("")) { JOptionPane.showMessageDialog(this, "��������� �Է��ϼ���"); 
	      } else if(tel.equals("") || tel.equals("")) { JOptionPane.showMessageDialog(this, "����ó�� �Է��ϼ���"); 
	      }
			
	}
	
	//���ڵ� �˻� 
	public void userSearch(){
		//�˻�� �ԷµǾ����� Ȯ��
				String search = jt9.getText(); //search->�˻���/ 
				if(search!=null && !search.equals("")) { //�˻�� �ִ� ���
					String searchField = (String)findcombo.getSelectedItem(); 
					String fieldName = "";//�ʵ���� �����ͷ�
					if(searchField.equals("�̸�")) {
						fieldName = "name";  //� �ʵ忡�� �˻�����
	
					}else if(searchField.equals("���̵�")) { 
						fieldName = "id";
					}else if(searchField.equals("����")) {
						fieldName = "sex";
					}
					UserDAO dao = new UserDAO();
					  List<UserVO> list =dao.searchRecord(search,fieldName); //�˻���,�˻��ʵ� ������
					
					  setUserModel(list);
					  jt9.setText(""); //�˻��Ѱ� ����� 
				}
	}
	
	
	//ȸ���߰�
	public void userInsert() {
		int sex =0;
		//���� �̸��� �Է»������� Ȯ��
				String username = jt1.getText(); //�Էµ� ���� ���ͼ� �̸��� 

					UserVO vo = new UserVO();
					//vo.setWrite_date(vo.getWrite_date());
					if(r1.isSelected()) {
						sex = 1;
					}else if(r2.isSelected()) {
						sex = 2;
					}
					vo.setSex(sex);
					vo.setName(username);//insert������ �޾Ƽ� ȣ��
					vo.setId(jt2.getText());
					vo.setPwd(new String(jt3.getPassword()));
					vo.setAddr(jt4.getText());
					vo.setBirth(jt44.getText());

					vo.setTel(jt5.getText());
					vo.setRemark(jtt.getText());
		
					UserDAO dao = new UserDAO();
					int cnt = dao.insertRecord(vo);
					if(cnt>0) {//ȸ���߰�
						JOptionPane.showMessageDialog(this, jt1.getText()+"ȸ���� �߰��Ͽ����ϴ�.");
						formDataClear(); //ȸ���� �߰��Ǹ� ���� �����͸� �����.
						userAllList();
						
					}else {//ȸ���߰� ����
						//JOptionPane.showMessageDialog(this, "ȸ���߰� �����Ͽ����ϴ�.");
					}
				}
	//ȸ������
	public void userDelete() {
		//������ �����ȣ 
				String delNum = jt0.getText(); //���ڰ� ������ "5", ������ " "
				if(delNum==null || delNum.equals("")){
				JOptionPane.showMessageDialog(this, "������ ����� ������ ������ư�� Ŭ���ϼ���");
				}else {//������ �ؼ� ���� ���� ��� 
					UserDAO dao = new UserDAO();
					int result = dao.deleteRecord(Integer.parseInt(delNum)); //������ �����ȣ�� int�� ������Ѽ� deleterecord�� �Ű������� ����
					//result�� ������ ���ڵ� ���� �������
					if(result>0) { //ȸ��������
						JOptionPane.showMessageDialog(this, delNum+"����� �����Ͽ����ϴ�.");
						userAllList();//����Ʈ �ٽ� ������
						formDataClear();
					}else { //ȸ������ �ȵ�
						JOptionPane.showMessageDialog(this, delNum+"��������� �����Ͽ����ϴ�.");
					}
				}
	}
	//�����Է�
	public void userReset() {
		jt0.setText("");
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
		jt4.setText("");
		jt5.setText("");
		jt6.setText("");
		jt7.setText("");
		jt8.setText("");
		jt44.setText("");
		jtt.setText("");
	}
	//ȸ������
	public void userUpdate() {
		int sex=0;
		UserVO vo = new UserVO();
		if(r1.isSelected()) {
			sex = 1;
		}else if(r2.isSelected()) {
			sex = 2;
		}
		vo.setSex(sex);
		vo.setName(jt1.getText());
		vo.setId(jt2.getText());	
		vo.setPwd(new String(jt3.getPassword()));
		vo.setAddr(jt4.getText());
		//vo.setBirth(jt44.getText());
		vo.setTel(jt5.getText());
		vo.setRemark(jtt.getText());
		vo.setU_no(Integer.parseInt(jt0.getText())); //formTf�� 0��°�� ��ȣ�� �ִ� //���ڸ� int�� �ٲ㼭
	

		UserDAO dao = new UserDAO(); //DAO ��ü����
		int cnt = dao.updateRecord(vo);
		if(cnt>0){//������ ����Ʈ �ٽ� �����ϱ�
			JOptionPane.showMessageDialog(this, jt1.getText()+jt2.getText()+ " ȸ�������� �����Ͽ����ϴ�.");
			userAllList();//��ü��� ���
		}else{//�������н� �ȳ� �޼��� ǥ�� 
			JOptionPane.showMessageDialog(this,"ȸ������ ���� �����Ͽ����ϴ�"); //�θ������̳�,�޼���
		}
	}
	public void formDataClear() {
		jt0.setText("");
		jt1.setText("");
		jt2.setText("");
		jt3.setText("");
		jt4.setText("");
		jt5.setText("");
		jt6.setText("");
		jt7.setText("");
		jt8.setText("");
		jt44.setText("");
		jtt.setText("");
	}
	public static void main(String[] args) {
		new UserCheck();
	}

}
