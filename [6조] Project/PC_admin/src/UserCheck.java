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
	JPanel p1 = new JPanel(); //가장 큰 패널
	
	JPanel p2 = new JPanel(); //상위 패널(로고와 메뉴바가 들어감)
		JToolBar tb = new JToolBar();
		ImageIcon icon1 = new ImageIcon("img/logo.png");
		JLabel lbl1 = new JLabel(icon1);
		JLabel lbl2 = new JLabel("★ BIT PC ★");
		JMenuBar ad = new JMenuBar();
		JMenu countMenu = new JMenu("매장관리");
		JMenuItem countMenuItem = new JMenuItem("매장관리");
		JMenu mdMenu = new JMenu("상품관리");
		JMenuItem mdMenuItem = new JMenuItem("상품관리");
		JMenuItem restockMenuItem = new JMenuItem("입고관리");
		JMenu userMenu = new JMenu("회원관리");
		JMenuItem userMenuItem = new JMenuItem("회원관리");
		JMenu payMenu = new JMenu("매출관리");
		JMenuItem payMenuItem = new JMenuItem("매출관리");
		
		JPanel jp = new JPanel();
	JSplitPane sp1, sp2; //왼쪽 오른쪽 나눈다음에 / 오른쪽 패널만 위아래로 또 나누기
		JPanel p3 = new JPanel(new BorderLayout()); //왼쪽에 들어갈 회원정보 
			JLabel l00 = new JLabel("▶회원가입 및 회원정보 확인◀");
			JLabel l0 = new JLabel("<회원번호>");
			JLabel l1 = new JLabel("<이름>");
			JLabel l2 = new JLabel("<아이디>");
			JLabel l3 = new JLabel("<비밀번호>");
			JLabel l4 = new JLabel("<주소>");
			JLabel l44 = new JLabel("생년월일");	
			
			JLabel l55 = new JLabel("<성별>");	
			JRadioButton r1 = new JRadioButton("남성 →1");
			JRadioButton r2 = new JRadioButton("여성 →2 ");
			
			JLabel l5 = new JLabel("<연락처>");
			JLabel l6 = new JLabel("<총 이용시간>");
			JLabel l7 = new JLabel("<총 이용금액>");
			JLabel l8 = new JLabel("<잔여시간>");
			
			
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
			
			JLabel lb = new JLabel(" < 비 고 >");
			JTextField jtt = new JTextField(10);
			

			JPanel p6 = new JPanel();
			JButton b1 = new JButton("추가");
			JButton b2 = new JButton("수정");
			JButton b3 = new JButton("삭제");
			JButton b5 = new JButton("새로입력");
			
		JPanel p4 = new JPanel(); //오른쪽에 위에 들어갈 검색, 버튼 이것저것
			JComboBox<String> findcombo = new JComboBox<String>();//검색 콤보박스
			DefaultComboBoxModel<String>findmodel = new DefaultComboBoxModel<String>();
			JTextField jt9 = new JTextField(20);
			JButton b4 = new JButton("검색");
			JButton b6 = new JButton("전체목록");

		
		JPanel p5 = new JPanel(); // 오른쪽 아래 JTable(db연결)
		
		JTable table;
		JScrollPane spp;
		DefaultTableModel model;
		String title[] = {"회원번호","성별","회원이름","아이디","비밀번호","주소","생년월일","연락처","총 이용시간","총 이용금액","회원등록일", "비고"};
		
		
	public UserCheck() {
		super(" ★ 회원관리 ★ ");
		//p1 큰패널에 툴바넣고 p2에 (로고, 메뉴바)
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
		
		//가운데 정렬 (라벨, 텍스트필드 전부)
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
		
		
		
		
		Font fnt = new Font("맑은 고딕",Font.BOLD, 13);
		Font fnt1 = new Font("맑은 고딕",Font.BOLD, 16);
		
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
		
		//p3에 회원가입 및 회원정보 확인 넣기
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
		b6.setBackground(Color.getHSBColor(253,100, 250)); //253,220,254-초록 //152, 135, 100->연초록 //253,220, 284-흰색  //203,145, 190
		p6.setBackground(Color.white);
		p6.add(b1);
		p6.add(b2);
		p6.add(b3);
		p6.add(b5);
		
		b1.setPreferredSize(new Dimension(90,30));
		b2.setPreferredSize(new Dimension(90,30));
		b3.setPreferredSize(new Dimension(90,30));
		b5.setPreferredSize(new Dimension(90,30));
		
		// p4에 검색, 버튼 등등 넣기
		
		p4.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		
		String findName[] = {"통합검색","이름","아이디","성별"};
		findmodel = new DefaultComboBoxModel<String>(findName); //model에 fontname
		findcombo.setModel(findmodel);

		p4.add(findcombo);
		p4.add(jt9);
		jt9.setPreferredSize(new Dimension(70, 30));
		p4.add(b4);
		p4.add(b6);

		model = new DefaultTableModel(title,0);
		table = new JTable(model); 
		spp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1200,700)); //jtable 크기 설정
		spp.setBackground(Color.WHITE);
		
		table.setPreferredScrollableViewportSize(new Dimension(1200,700));
		table.setFillsViewportHeight(true);
		
		table.addMouseListener(new JTableMouseEventUser(jt0,jt1,jt2,jt3,jt4,jt44,jt5,jt6,jt7,r1,r2,jtt,table));
		
		p5.add(spp);
		p4.add(p5);
		
		
		//수평나누기 
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p3, p4);
		
		//수직나누기 (P3를 위아래로)
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
	//데이터 베이스에서 회원 전체목록 (이름순으로) 가져오기 -JTable목록을 보여줌
	public void userAllList() { //호출되면 회원 전체목록 출력(이름순서대로)
		UserDAO dao = new UserDAO();
		List<UserVO> list = dao.allRecord();
		setUserModel(list);
			
	}
	public void setUserModel(List<UserVO> list) {
			model.setRowCount(0); 
			//컬렉션의 vo를 get하여 jtable에 목록으로 추가한다.
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
		if(event.equals("상품관리")){
			GoodsCheck gc = new GoodsCheck();
			gc.setVisible(true);
			
		}else if(event.equals("입고관리")) {
			RestockDialog rd = new RestockDialog();
			 rd.setVisible(true);
			 
		}else if(event.equals("매장관리")){
			SeatCheck sc = new SeatCheck();
			sc.setVisible(true);
		}else if(event.equals("매출관리")) {
			SaleCheck sc = new SaleCheck();
			sc.setVisible(true);
			
		}
	
		if(event.equals("추가")) {
			IF();
			userInsert();
			userAllList();
		}else if(event.equals("삭제")) {
			userDelete();
			userAllList();
		}else if(event.equals("새로입력")) {
			formDataClear();
		}else if(event.equals("수정")) {
			userUpdate();
		}else if(event.equals("검색")) {
			userSearch();
		}else if(event.equals("전체목록")) {
			userAllList();
		}
	
		if(event.equals("입고관리")) {
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
		  JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
		  }else if(!name.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {JOptionPane.showMessageDialog(this, "이름(한글)을 입력하세요"); 
		  }else if(id.equals("") || id.equals("")) { JOptionPane.showMessageDialog(this, "아이디를 입력하세요."); 
		  }else if(!id.matches("^[A-Za-z[0-9]]*$")) {
		  JOptionPane.showMessageDialog(this, "아이디는 영문 또는 숫자를 사용하여 입력하세요 ");
	      } else if(pw.equals("") || pw==null) { JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요"); 
	      }else if((pw.length()<6 || pw.length()>20 )){ JOptionPane.showMessageDialog(this, "비밀번호는 6자리 이상, 20자리 이하여야 합니다.");
	      } else if(addr.equals("") || addr.equals("")) { JOptionPane.showMessageDialog(this, "주소를 입력하세요"); 
		  } else if(birth.equals("") || birth.equals("")) { JOptionPane.showMessageDialog(this, "생년월일을 입력하세요"); 
	      } else if(tel.equals("") || tel.equals("")) { JOptionPane.showMessageDialog(this, "연락처를 입력하세요"); 
	      }
			
	}
	
	//레코드 검색 
	public void userSearch(){
		//검색어가 입력되었는지 확인
				String search = jt9.getText(); //search->검색어/ 
				if(search!=null && !search.equals("")) { //검색어가 있는 경우
					String searchField = (String)findcombo.getSelectedItem(); 
					String fieldName = "";//필드명을 데이터로
					if(searchField.equals("이름")) {
						fieldName = "name";  //어떤 필드에서 검색할지
	
					}else if(searchField.equals("아이디")) { 
						fieldName = "id";
					}else if(searchField.equals("성별")) {
						fieldName = "sex";
					}
					UserDAO dao = new UserDAO();
					  List<UserVO> list =dao.searchRecord(search,fieldName); //검색어,검색필드 보내줌
					
					  setUserModel(list);
					  jt9.setText(""); //검색한거 지우기 
				}
	}
	
	
	//회원추가
	public void userInsert() {
		int sex =0;
		//폼의 이름이 입력상태인지 확인
				String username = jt1.getText(); //입력된 값을 얻어와서 이름이 

					UserVO vo = new UserVO();
					//vo.setWrite_date(vo.getWrite_date());
					if(r1.isSelected()) {
						sex = 1;
					}else if(r2.isSelected()) {
						sex = 2;
					}
					vo.setSex(sex);
					vo.setName(username);//insert데이터 받아서 호출
					vo.setId(jt2.getText());
					vo.setPwd(new String(jt3.getPassword()));
					vo.setAddr(jt4.getText());
					vo.setBirth(jt44.getText());

					vo.setTel(jt5.getText());
					vo.setRemark(jtt.getText());
		
					UserDAO dao = new UserDAO();
					int cnt = dao.insertRecord(vo);
					if(cnt>0) {//회원추가
						JOptionPane.showMessageDialog(this, jt1.getText()+"회원을 추가하였습니다.");
						formDataClear(); //회원이 추가되면 폼의 데이터를 지운다.
						userAllList();
						
					}else {//회원추가 실패
						//JOptionPane.showMessageDialog(this, "회원추가 실패하였습니다.");
					}
				}
	//회원삭제
	public void userDelete() {
		//삭제할 사원번호 
				String delNum = jt0.getText(); //숫자가 있으면 "5", 없으면 " "
				if(delNum==null || delNum.equals("")){
				JOptionPane.showMessageDialog(this, "삭제할 사원을 선택후 삭제버튼을 클릭하세요");
				}else {//선택을 해서 값이 있을 경우 
					UserDAO dao = new UserDAO();
					int result = dao.deleteRecord(Integer.parseInt(delNum)); //삭제할 사원번호를 int로 변경시켜서 deleterecord의 매개변수로 보냄
					//result에 삭제한 레코드 수가 들어있음
					if(result>0) { //회원삭제됨
						JOptionPane.showMessageDialog(this, delNum+"사원을 삭제하였습니다.");
						userAllList();//리스트 다시 가져옴
						formDataClear();
					}else { //회원삭제 안됨
						JOptionPane.showMessageDialog(this, delNum+"사원삭제를 실패하였습니다.");
					}
				}
	}
	//새로입력
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
	//회원수정
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
		vo.setU_no(Integer.parseInt(jt0.getText())); //formTf의 0번째에 번호가 있다 //문자를 int로 바꿔서
	

		UserDAO dao = new UserDAO(); //DAO 객체생성
		int cnt = dao.updateRecord(vo);
		if(cnt>0){//수정시 리스트 다시 선택하기
			JOptionPane.showMessageDialog(this, jt1.getText()+jt2.getText()+ " 회원정보를 수정하였습니다.");
			userAllList();//전체목록 출력
		}else{//수정실패시 안내 메세지 표시 
			JOptionPane.showMessageDialog(this,"회원정보 수정 실패하였습니다"); //부모컨테이너,메세지
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
