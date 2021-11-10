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
	JPanel p1 = new JPanel(); //°¡Àå Å« ÆÐ³Î
	
	JPanel p2 = new JPanel(); //»óÀ§ ÆÐ³Î(·Î°í¿Í ¸Þ´º¹Ù°¡ µé¾î°¨)
		JToolBar tb = new JToolBar();
		ImageIcon icon1 = new ImageIcon("img/logo.png");
		JLabel lbl1 = new JLabel(icon1);
		JLabel lbl2 = new JLabel("¡Ú BIT PC ¡Ú");
		JMenuBar ad = new JMenuBar();
		JMenu countMenu = new JMenu("¸ÅÀå°ü¸®");
		JMenuItem countMenuItem = new JMenuItem("¸ÅÀå°ü¸®");
		JMenu mdMenu = new JMenu("»óÇ°°ü¸®");
		JMenuItem mdMenuItem = new JMenuItem("»óÇ°°ü¸®");
		JMenuItem restockMenuItem = new JMenuItem("ÀÔ°í°ü¸®");
		JMenu userMenu = new JMenu("È¸¿ø°ü¸®");
		JMenuItem userMenuItem = new JMenuItem("È¸¿ø°ü¸®");
		JMenu payMenu = new JMenu("¸ÅÃâ°ü¸®");
		JMenuItem payMenuItem = new JMenuItem("¸ÅÃâ°ü¸®");
		
		JPanel jp = new JPanel();
	JSplitPane sp1, sp2; //¿ÞÂÊ ¿À¸¥ÂÊ ³ª´«´ÙÀ½¿¡ / ¿À¸¥ÂÊ ÆÐ³Î¸¸ À§¾Æ·¡·Î ¶Ç ³ª´©±â
		JPanel p3 = new JPanel(new BorderLayout()); //¿ÞÂÊ¿¡ µé¾î°¥ È¸¿øÁ¤º¸ 
			JLabel l00 = new JLabel("¢ºÈ¸¿ø°¡ÀÔ ¹× È¸¿øÁ¤º¸ È®ÀÎ¢¸");
			JLabel l0 = new JLabel("<È¸¿ø¹øÈ£>");
			JLabel l1 = new JLabel("<ÀÌ¸§>");
			JLabel l2 = new JLabel("<¾ÆÀÌµð>");
			JLabel l3 = new JLabel("<ºñ¹Ð¹øÈ£>");
			JLabel l4 = new JLabel("<ÁÖ¼Ò>");
			JLabel l44 = new JLabel("»ý³â¿ùÀÏ");	
			
			JLabel l55 = new JLabel("<¼ºº°>");	
			JRadioButton r1 = new JRadioButton("³²¼º ¡æ1");
			JRadioButton r2 = new JRadioButton("¿©¼º ¡æ2 ");
			
			JLabel l5 = new JLabel("<¿¬¶ôÃ³>");
			JLabel l6 = new JLabel("<ÃÑ ÀÌ¿ë½Ã°£>");
			JLabel l7 = new JLabel("<ÃÑ ÀÌ¿ë±Ý¾×>");
			JLabel l8 = new JLabel("<ÀÜ¿©½Ã°£>");
			
			
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
			
			JLabel lb = new JLabel(" < ºñ °í >");
			JTextField jtt = new JTextField(10);
			

			JPanel p6 = new JPanel();
			JButton b1 = new JButton("Ãß°¡");
			JButton b2 = new JButton("¼öÁ¤");
			JButton b3 = new JButton("»èÁ¦");
			JButton b5 = new JButton("»õ·ÎÀÔ·Â");
			
		JPanel p4 = new JPanel(); //¿À¸¥ÂÊ¿¡ À§¿¡ µé¾î°¥ °Ë»ö, ¹öÆ° ÀÌ°ÍÀú°Í
			JComboBox<String> findcombo = new JComboBox<String>();//°Ë»ö ÄÞº¸¹Ú½º
			DefaultComboBoxModel<String>findmodel = new DefaultComboBoxModel<String>();
			JTextField jt9 = new JTextField(20);
			JButton b4 = new JButton("°Ë»ö");
			JButton b6 = new JButton("ÀüÃ¼¸ñ·Ï");

		
		JPanel p5 = new JPanel(); // ¿À¸¥ÂÊ ¾Æ·¡ JTable(db¿¬°á)
		
		JTable table;
		JScrollPane spp;
		DefaultTableModel model;
		String title[] = {"È¸¿ø¹øÈ£","¼ºº°","È¸¿øÀÌ¸§","¾ÆÀÌµð","ºñ¹Ð¹øÈ£","ÁÖ¼Ò","»ý³â¿ùÀÏ","¿¬¶ôÃ³","ÃÑ ÀÌ¿ë½Ã°£","ÃÑ ÀÌ¿ë±Ý¾×","È¸¿øµî·ÏÀÏ", "ºñ°í"};
		
		
	public UserCheck() {
		super(" ¡Ú È¸¿ø°ü¸® ¡Ú ");
		//p1 Å«ÆÐ³Î¿¡ Åø¹Ù³Ö°í p2¿¡ (·Î°í, ¸Þ´º¹Ù)
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
		
		//°¡¿îµ¥ Á¤·Ä (¶óº§, ÅØ½ºÆ®ÇÊµå ÀüºÎ)
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
		
		
		
		
		Font fnt = new Font("¸¼Àº °íµñ",Font.BOLD, 13);
		Font fnt1 = new Font("¸¼Àº °íµñ",Font.BOLD, 16);
		
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
		
		//p3¿¡ È¸¿ø°¡ÀÔ ¹× È¸¿øÁ¤º¸ È®ÀÎ ³Ö±â
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
		b6.setBackground(Color.getHSBColor(253,100, 250)); //253,220,254-ÃÊ·Ï //152, 135, 100->¿¬ÃÊ·Ï //253,220, 284-Èò»ö  //203,145, 190
		p6.setBackground(Color.white);
		p6.add(b1);
		p6.add(b2);
		p6.add(b3);
		p6.add(b5);
		
		b1.setPreferredSize(new Dimension(90,30));
		b2.setPreferredSize(new Dimension(90,30));
		b3.setPreferredSize(new Dimension(90,30));
		b5.setPreferredSize(new Dimension(90,30));
		
		// p4¿¡ °Ë»ö, ¹öÆ° µîµî ³Ö±â
		
		p4.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		
		String findName[] = {"ÅëÇÕ°Ë»ö","ÀÌ¸§","¾ÆÀÌµð","¼ºº°"};
		findmodel = new DefaultComboBoxModel<String>(findName); //model¿¡ fontname
		findcombo.setModel(findmodel);

		p4.add(findcombo);
		p4.add(jt9);
		jt9.setPreferredSize(new Dimension(70, 30));
		p4.add(b4);
		p4.add(b6);

		model = new DefaultTableModel(title,0);
		table = new JTable(model); 
		spp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1200,700)); //jtable Å©±â ¼³Á¤
		spp.setBackground(Color.WHITE);
		
		table.setPreferredScrollableViewportSize(new Dimension(1200,700));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new JTableMouseEventUser(jt0,jt1,jt2,jt3,jt4,jt44,jt5,jt6,jt7,r1,r2,jtt,table));
		
		p5.add(spp);
		p4.add(p5);
		
		
		//¼öÆò³ª´©±â 
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p3, p4);
		
		//¼öÁ÷³ª´©±â (P3¸¦ À§¾Æ·¡·Î)
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
	//µ¥ÀÌÅÍ º£ÀÌ½º¿¡¼­ È¸¿ø ÀüÃ¼¸ñ·Ï (ÀÌ¸§¼øÀ¸·Î) °¡Á®¿À±â -JTable¸ñ·ÏÀ» º¸¿©ÁÜ
	public void userAllList() { //È£ÃâµÇ¸é È¸¿ø ÀüÃ¼¸ñ·Ï Ãâ·Â(ÀÌ¸§¼ø¼­´ë·Î)
		UserDAO dao = new UserDAO();
		List<UserVO> list = dao.allRecord();
		setUserModel(list);
			
	}
	public void setUserModel(List<UserVO> list) {
			model.setRowCount(0); 
			//ÄÃ·º¼ÇÀÇ vo¸¦ getÇÏ¿© jtable¿¡ ¸ñ·ÏÀ¸·Î Ãß°¡ÇÑ´Ù.
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
		if(event.equals("»óÇ°°ü¸®")){
			GoodsCheck gc = new GoodsCheck();
			gc.setVisible(true);
			
		}else if(event.equals("ÀÔ°í°ü¸®")) {
			RestockDialog rd = new RestockDialog();
			 rd.setVisible(true);
			 
		}else if(event.equals("¸ÅÀå°ü¸®")){
			SeatCheck sc = new SeatCheck();
			sc.setVisible(true);
		}else if(event.equals("¸ÅÃâ°ü¸®")) {
			SaleCheck sc = new SaleCheck();
			sc.setVisible(true);
			
		}
	
		if(event.equals("Ãß°¡")) {
			IF();
			userInsert();
			userAllList();
		}else if(event.equals("»èÁ¦")) {
			userDelete();
			userAllList();
		}else if(event.equals("»õ·ÎÀÔ·Â")) {
			formDataClear();
		}else if(event.equals("¼öÁ¤")) {
			userUpdate();
		}else if(event.equals("°Ë»ö")) {
			userSearch();
		}else if(event.equals("ÀüÃ¼¸ñ·Ï")) {
			userAllList();
		}
	
		if(event.equals("ÀÔ°í°ü¸®")) {
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
		  JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä.");
		  }else if(!name.matches(".*[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+.*")) {JOptionPane.showMessageDialog(this, "ÀÌ¸§(ÇÑ±Û)À» ÀÔ·ÂÇÏ¼¼¿ä"); 
		  }else if(id.equals("") || id.equals("")) { JOptionPane.showMessageDialog(this, "¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼¼¿ä."); 
		  }else if(!id.matches("^[A-Za-z[0-9]]*$")) {
		  JOptionPane.showMessageDialog(this, "¾ÆÀÌµð´Â ¿µ¹® ¶Ç´Â ¼ýÀÚ¸¦ »ç¿ëÇÏ¿© ÀÔ·ÂÇÏ¼¼¿ä ");
	      } else if(pw.equals("") || pw==null) { JOptionPane.showMessageDialog(this, "ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä"); 
	      }else if((pw.length()<6 || pw.length()>20 )){ JOptionPane.showMessageDialog(this, "ºñ¹Ð¹øÈ£´Â 6ÀÚ¸® ÀÌ»ó, 20ÀÚ¸® ÀÌÇÏ¿©¾ß ÇÕ´Ï´Ù.");
	      } else if(addr.equals("") || addr.equals("")) { JOptionPane.showMessageDialog(this, "ÁÖ¼Ò¸¦ ÀÔ·ÂÇÏ¼¼¿ä"); 
		  } else if(birth.equals("") || birth.equals("")) { JOptionPane.showMessageDialog(this, "»ý³â¿ùÀÏÀ» ÀÔ·ÂÇÏ¼¼¿ä"); 
	      } else if(tel.equals("") || tel.equals("")) { JOptionPane.showMessageDialog(this, "¿¬¶ôÃ³¸¦ ÀÔ·ÂÇÏ¼¼¿ä"); 
	      }
			
	}
	
	//·¹ÄÚµå °Ë»ö 
	public void userSearch(){
		//°Ë»ö¾î°¡ ÀÔ·ÂµÇ¾ú´ÂÁö È®ÀÎ
				String search = jt9.getText(); //search->°Ë»ö¾î/ 
				if(search!=null && !search.equals("")) { //°Ë»ö¾î°¡ ÀÖ´Â °æ¿ì
					String searchField = (String)findcombo.getSelectedItem(); 
					String fieldName = "";//ÇÊµå¸íÀ» µ¥ÀÌÅÍ·Î
					if(searchField.equals("ÀÌ¸§")) {
						fieldName = "name";  //¾î¶² ÇÊµå¿¡¼­ °Ë»öÇÒÁö
	
					}else if(searchField.equals("¾ÆÀÌµð")) { 
						fieldName = "id";
					}else if(searchField.equals("¼ºº°")) {
						fieldName = "sex";
					}
					UserDAO dao = new UserDAO();
					  List<UserVO> list =dao.searchRecord(search,fieldName); //°Ë»ö¾î,°Ë»öÇÊµå º¸³»ÁÜ
					
					  setUserModel(list);
					  jt9.setText(""); //°Ë»öÇÑ°Å Áö¿ì±â 
				}
	}
	
	
	//È¸¿øÃß°¡
	public void userInsert() {
		int sex =0;
		//ÆûÀÇ ÀÌ¸§ÀÌ ÀÔ·Â»óÅÂÀÎÁö È®ÀÎ
				String username = jt1.getText(); //ÀÔ·ÂµÈ °ªÀ» ¾ò¾î¿Í¼­ ÀÌ¸§ÀÌ 

					UserVO vo = new UserVO();
					//vo.setWrite_date(vo.getWrite_date());
					if(r1.isSelected()) {
						sex = 1;
					}else if(r2.isSelected()) {
						sex = 2;
					}
					vo.setSex(sex);
					vo.setName(username);//insertµ¥ÀÌÅÍ ¹Þ¾Æ¼­ È£Ãâ
					vo.setId(jt2.getText());
					vo.setPwd(new String(jt3.getPassword()));
					vo.setAddr(jt4.getText());
					vo.setBirth(jt44.getText());

					vo.setTel(jt5.getText());
					vo.setRemark(jtt.getText());
		
					UserDAO dao = new UserDAO();
					int cnt = dao.insertRecord(vo);
					if(cnt>0) {//È¸¿øÃß°¡
						JOptionPane.showMessageDialog(this, jt1.getText()+"È¸¿øÀ» Ãß°¡ÇÏ¿´½À´Ï´Ù.");
						formDataClear(); //È¸¿øÀÌ Ãß°¡µÇ¸é ÆûÀÇ µ¥ÀÌÅÍ¸¦ Áö¿î´Ù.
						userAllList();
						
					}else {//È¸¿øÃß°¡ ½ÇÆÐ
						//JOptionPane.showMessageDialog(this, "È¸¿øÃß°¡ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					}
				}
	//È¸¿ø»èÁ¦
	public void userDelete() {
		//»èÁ¦ÇÒ »ç¿ø¹øÈ£ 
				String delNum = jt0.getText(); //¼ýÀÚ°¡ ÀÖÀ¸¸é "5", ¾øÀ¸¸é " "
				if(delNum==null || delNum.equals("")){
				JOptionPane.showMessageDialog(this, "»èÁ¦ÇÒ »ç¿øÀ» ¼±ÅÃÈÄ »èÁ¦¹öÆ°À» Å¬¸¯ÇÏ¼¼¿ä");
				}else {//¼±ÅÃÀ» ÇØ¼­ °ªÀÌ ÀÖÀ» °æ¿ì 
					UserDAO dao = new UserDAO();
					int result = dao.deleteRecord(Integer.parseInt(delNum)); //»èÁ¦ÇÒ »ç¿ø¹øÈ£¸¦ int·Î º¯°æ½ÃÄÑ¼­ deleterecordÀÇ ¸Å°³º¯¼ö·Î º¸³¿
					//result¿¡ »èÁ¦ÇÑ ·¹ÄÚµå ¼ö°¡ µé¾îÀÖÀ½
					if(result>0) { //È¸¿ø»èÁ¦µÊ
						JOptionPane.showMessageDialog(this, delNum+"»ç¿øÀ» »èÁ¦ÇÏ¿´½À´Ï´Ù.");
						userAllList();//¸®½ºÆ® ´Ù½Ã °¡Á®¿È
						formDataClear();
					}else { //È¸¿ø»èÁ¦ ¾ÈµÊ
						JOptionPane.showMessageDialog(this, delNum+"»ç¿ø»èÁ¦¸¦ ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
					}
				}
	}
	//»õ·ÎÀÔ·Â
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
	//È¸¿ø¼öÁ¤
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
		vo.setU_no(Integer.parseInt(jt0.getText())); //formTfÀÇ 0¹øÂ°¿¡ ¹øÈ£°¡ ÀÖ´Ù //¹®ÀÚ¸¦ int·Î ¹Ù²ã¼­
	

		UserDAO dao = new UserDAO(); //DAO °´Ã¼»ý¼º
		int cnt = dao.updateRecord(vo);
		if(cnt>0){//¼öÁ¤½Ã ¸®½ºÆ® ´Ù½Ã ¼±ÅÃÇÏ±â
			JOptionPane.showMessageDialog(this, jt1.getText()+jt2.getText()+ " È¸¿øÁ¤º¸¸¦ ¼öÁ¤ÇÏ¿´½À´Ï´Ù.");
			userAllList();//ÀüÃ¼¸ñ·Ï Ãâ·Â
		}else{//¼öÁ¤½ÇÆÐ½Ã ¾È³» ¸Þ¼¼Áö Ç¥½Ã 
			JOptionPane.showMessageDialog(this,"È¸¿øÁ¤º¸ ¼öÁ¤ ½ÇÆÐÇÏ¿´½À´Ï´Ù"); //ºÎ¸ðÄÁÅ×ÀÌ³Ê,¸Þ¼¼Áö
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
