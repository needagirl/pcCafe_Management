
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
		
		
	//JFrame - Center (왼쪽엔 라벨이랑 텍스트박스 /오른쪽엔 탭 패널 넣을 예정)
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel centerWestPane = new JPanel(new GridLayout(2,1,30,20));  //2개의 패널(upPane, twoPane)이 위,센터에 들어갈 예정
			JPanel upPane = new JPanel(new BorderLayout()); //패널 센터에 왼쪽 라벨,오른쪽 텍스트박스 /남쪽에 버튼 3개/
				JPanel upLTPane = new JPanel(new BorderLayout());
					JPanel lblPane = new JPanel(new GridLayout(5,1,10,15)); //라벨 4개 
						String formLbl[] = {"    구분","   상품구분 ","    상품명 ","   판매금액 ","   상품메모 "};
					JPanel textPane = new JPanel(); //콤보박스 1개, 텍스트필드 3개   //new GridLayout(4,1)
						JComboBox<String> goodscombo = new JComboBox<String>();
						DefaultComboBoxModel<String>goodsmodel;
						
						JTextField formTf0 = new JTextField(15);
						JTextField formTf1 = new JTextField(15);
						JTextField formTf2 = new JTextField(15);
						JTextField formTf3 = new JTextField(15);
						//저장, 삭제, 새로입력,상품구분 버튼 3개
						JPanel upSouthPane = new JPanel(new FlowLayout(FlowLayout.LEADING, 12,7)); //flowlayout으로 버튼 4개
							JButton b1 = new JButton("추가");
							JButton b2 = new JButton("삭제");
							JButton b3 = new JButton("새로입력");
							JButton b6 = new JButton("수정");
							JButton b5 = new JButton("상품구분 추가/삭제");
						
			JPanel twoPane = new JPanel(new BorderLayout()); //왼쪽 중간 패널
				JPanel twoLTPane = new JPanel(new BorderLayout());// 왼쪽 중간 라벨,센터 텍스트박스
					JPanel twoLblPane = new JPanel(new GridLayout(4,1,10,10)); //왼쪽 라벨
						String twoLbl[] = {"    입고수량 ","    입고가격 ","    유통기한","    입고메모 "};
						JPanel twotextPane = new JPanel();//오른쪽 텍스트
						JTextField twoTf1 = new JTextField(15);
						JTextField twoTf2 = new JTextField(15);
						JTextField twoTf3 = new JTextField(15);	
						JTextField twoTf4 = new JTextField(15);
//					JPanel twotextPane = new JPanel(new GridLayout(3,1));//오른쪽 텍스트
//						JTextField[] twoTf = {new JTextField(15), new JTextField(15), new JTextField(15)};
				JPanel twoSouthPane = new JPanel(new FlowLayout(FlowLayout.RIGHT, 38,40)); //버튼 하나 들어갈 자리
					JButton b4 = new JButton("입고처리");
		
	JPanel centerCentPane = new JPanel(new BorderLayout()); //위에 메뉴바랑 센터에 jtable들어갈 탭 
		JMenuBar gd = new JMenuBar();
		JMenu goodMenu = new JMenu("상품현황");
		//JMenu goodsMenu = new JMenu("    상품관리      ");
		JLabel lb = new JLabel(" ▶ 새로운 상품을 등록하거나 등록된 상품을 추가, 수정, 입고처리 할 수 있습니다 ◀  ");

		JTable table;
		JScrollPane sp;
		DefaultTableModel model;
		String title[] = {"구분","상품구분 ","상품명 "," 판매금액 ","재고수량","상품메모"};
	
	//JFrame = South 
	JPanel southPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 10 ,10));
//		JButton b7 = new JButton("위로↑");	
//		JButton b8 = new JButton("아래로↓");	
//		JButton b9 = new JButton("현재 순서대로 저장");	
	
	String pName="";
	String pClass="";
	String pNum;
	public GoodsCheck() {
		super(" ★ 상품관리 ★ ");
		//setBackground(Color.lightGray);
		add(BorderLayout.NORTH, formPane);
		add(BorderLayout.CENTER, centerPane);
		add(BorderLayout.SOUTH, southPane);
		
		centerPane.add(BorderLayout.WEST,centerWestPane);
		centerPane.add(BorderLayout.CENTER,centerCentPane);//add(tp);//탭패널을 기본패널에 못넣는건지?
		
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
		twoLTPane.setPreferredSize(new Dimension(250, 150)); //패널 사이즈 지정 //250,200
		twoLblPane.setPreferredSize(new Dimension(70, 70)); //패널 사이즈 지정
		twotextPane.setPreferredSize(new Dimension(100, 130)); //패널 사이즈 지정 //100,200
		
		twoLTPane.add(BorderLayout.CENTER, twotextPane);
		twoLTPane.add(BorderLayout.WEST, twoLblPane);
		twoPane.add(BorderLayout.SOUTH, twoSouthPane);
		
		twoLTPane.setBackground(Color.white); //색상변경
		twoLblPane.setBackground(Color.white);
		twotextPane.setBackground(Color.white);
		twoSouthPane.setBackground(Color.white);
		
		for(int i=0; i<twoLbl.length; i++) {
			JLabel lbl = new JLabel(twoLbl[i]);
			twoLblPane.add(lbl);
			Font fnt = new Font("맑은 고딕",Font.BOLD, 12);
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
		Font fnt = new Font("맑은 고딕",Font.BOLD, 12);
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
	upLTPane.setPreferredSize(new Dimension(250, 150)); //패널 사이즈 지정 //250,200
	lblPane.setPreferredSize(new Dimension(70, 70)); //패널 사이즈 지정
	textPane.setPreferredSize(new Dimension(100, 130)); //패널 사이즈 지정 //100,200
	upSouthPane.setPreferredSize(new Dimension(100, 100));
	upLTPane.add(BorderLayout.WEST, lblPane); //라벨패널 
	upLTPane.add(BorderLayout.CENTER,textPane);//텍스트패널
	upPane.add(BorderLayout.SOUTH, upSouthPane); //버튼패널
	
		for(int i=0; i<formLbl.length; i++) {
		JLabel lbl = new JLabel(formLbl[i]);
		lblPane.add(lbl);
		Font fnt = new Font("맑은 고딕",Font.BOLD, 12);
		lbl.setFont(fnt);
	}
		
		textPane.setLayout(null);
		//String goodsName[] = {"스낵/과자","세트/중식/튀김","식사류","분식/양식","라면/우동","커피/음료"};
		goodsmodel = new DefaultComboBoxModel<String>(); 
		goodscombo.setModel(goodsmodel);	
		goodscombo.setPreferredSize(new Dimension(10,10));
		textPane.add(goodscombo);
		
	/*텍스트 박스 배열로 for문 돌린거
	 * for(int i=0; i<formTf.length; i++) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(formTf[i]);  //확장되는 걸 막기위해서 JPanel에다 한번 더 넣음
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

	//버튼 3개 넣기
	b1.setPreferredSize(new Dimension(65, 28));
	b2.setPreferredSize(new Dimension(73, 28));
	b3.setPreferredSize(new Dimension(88, 28));
	b6.setPreferredSize(new Dimension(65, 45));
	b5.setPreferredSize(new Dimension(175, 45));
	
	Font fnt = new Font("맑은 고딕",Font.BOLD, 20);
	
	
	Font fnt2 = new Font("맑은 고딕",Font.BOLD, 13);
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
		Font fnt = new Font("맑은 고딕",Font.BOLD, 12);
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
		
		table.addMouseListener(new JtableMouseEventGoods(goodscombo,formTf0,formTf1,formTf2, formTf3, table));//마우스 왼쪽버튼

	
	}
	public void setForm() {
		setJMenuBar(ad);
		//ad.setBackground(Color.white);
		formPane.setLayout(new GridLayout(1,5));
		
		Font fnt = new Font("맑은 고딕",Font.BOLD, 13);
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
	
	public void goodsAllList() { //호출되면 회원 전체목록 출력(이름순서대로)
		GoodsDAO dao = new GoodsDAO();
		List<GoodsVO> list = dao.allRecord();
		setGoodsModel(list);
		
	}
	
	public void setGoodsModel(List<GoodsVO> list) {
		//기존 JTable의 목록을 지우고 새로 리스트를 출력한다.
		model.setRowCount(0); //기존에 있는거 다지우고 0으로 바꿔버림
		//컬렉션의 vo를 get하여 jtable에 목록으로 추가한다.
		for(int i=0; i<list.size(); i++) {
			GoodsVO vo = list.get(i);
			Object[] obj = {vo.getP_num(), vo.getP_class(), vo.getP_name(), vo.getS_price(), vo.getP_stock(), vo.getRemark()};
			model.addRow(obj);
			
			
		}
	}
	
		public void actionPerformed(ActionEvent ae) {
		
		Object event = ae.getActionCommand();//이벤트가 발생한 컴포넌트
		if(event.equals("매장관리")){
			SeatCheck sc = new SeatCheck();
			sc.setVisible(true);
		}else if(event.equals("입고관리")) {
			RestockDialog rd = new RestockDialog();
		 	 //rd.setVisible(true);
		}else if(event.equals("회원관리")){
			UserCheck uc = new UserCheck();
			uc.setVisible(true);
		}else if(event.equals("매출관리")) {
			SaleCheck sc = new SaleCheck();
			sc.setVisible(true);
		}
		if(event.equals("추가")) {
			goodsInsert();
			goodsAllList();
		}else if(event.equals("삭제")) {
			goodsDel();
			goodsAllList();
		}else if(event.equals("새로입력")){
			formTf0.setText("");
			formTf1.setText("");
			formTf2.setText("");
			formTf3.setText("");
			
		}else if(event.equals("수정")) {
			goodsUpdate();
			goodsAllList();
			
		}else if(event.equals("상품현황")) {
			goodsAllList();
		}else if(event.equals("입고처리")) {
			allRecordPs();
			miniRestockInsert();
			goodsAllList();
		}else if(event.equals("상품구분 추가/삭제")) {
			P_ClassDialog pc = new P_ClassDialog();
			allRecordPC();
			//pc.setVisible(true);
		}
		
		if(event.equals("입고관리")) {
			setVisible(true);
		}else  {//setVisible(false);
		
		}
		
	}

		//미니 입고처리
		public void miniRestockInsert() {
			String restockname = twoTf1.getText();
			String restockname2 = twoTf2.getText();
			RestockCheck rc = new RestockCheck();
			RestockDAO rd = new RestockDAO();
			if(restockname==null || restockname.equals("")){
				JOptionPane.showMessageDialog(this, "입고수량을 입력하세요!");
			}else if(restockname2==null ||  restockname2.equals("")) {
				JOptionPane.showMessageDialog(this, "입고가격을 입력하세요!");
			}else {
				String goodsname = formTf1.getText();
				String givecombo = (String)goodscombo.getSelectedItem();
				
				JOptionPane.showMessageDialog(this, goodsname +"상품을 입고했습니다!");
			
				RestockVO vo = new RestockVO();
				GoodsVO vo2 = new GoodsVO();
			
				
				
				vo.setP_name(goodsname);//상품명
				vo.setP_class(givecombo);//상품구분
				vo.setE_Num(Integer.parseInt(formTf0.getText())); //구분
				vo.setE_cnt(Integer.parseInt(twoTf1.getText())); //입고수량
				//vo2.setP_stock(Integer.parseInt(twoTf1.getText())); //입고수량을 재고수량에 
				vo.setE_price(Integer.parseInt(twoTf2.getText()));//입고가격
				vo.setExpiry(Integer.parseInt(twoTf3.getText()));//유통기한
				vo.setRemark(twoTf4.getText());//입고메모
			
				RestockDAO dao2 = new RestockDAO();
				int cnt = dao2.insertRecord(vo); //추가(똑같은 과자인데 가격 다를 수 있으니까)
				
				if(cnt>0) {//상품추가
					esCnt(goodsname);
					formDataClear(); //회원이 추가되면 폼의 데이터를 지운다.
					goodsAllList(); //재고수량 확인차 
					rc.restockAllList();
					rd.allRecord();
					rc.setRestockModel(rd.allRecord());
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
	
	}	
		
		
	//상품추가	
	public void goodsInsert() {
		
		String goodsname = formTf1.getText();
		String goodsname2 = formTf2.getText();
		
		if(goodsname==null || goodsname.equals("") ) {
			JOptionPane.showMessageDialog(this, "상품명을 입력하세요!");
		}else if(goodsname2==null || goodsname2.equals("")) {
			JOptionPane.showMessageDialog(this, "상품금액을 입력하세요!");
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
			if(cnt>0) {//상품추가
				JOptionPane.showMessageDialog(this, goodsname+"  상품이 추가되었습니다!");
				formDataClear(); //회원이 추가되면 폼의 데이터를 지운다.
				goodsAllList();
				
			}else{//추가실패시 안내 메세지 표시 
				JOptionPane.showMessageDialog(this,"상품추가 실패하였습니다"); //부모컨테이너,메세지
			
			}
			
		}
	}
	//상품수정
	
		public void goodsUpdate() {
			String goodsname = formTf1.getText();
			//String goodsname2 = formTf2.getText();
			String givecombo = (String)goodscombo.getSelectedItem();
			
			GoodsVO vo = new GoodsVO();
			vo.setP_name(goodsname);
			vo.setS_price(Integer.parseInt(formTf2.getText()));
			vo.setP_class(givecombo);	
			vo.setRemark(formTf3.getText());
			vo.setP_num(Integer.parseInt(formTf0.getText())); //formTf의 0번째에 번호가 있다 //문자를 int로 바꿔서
		
			GoodsDAO dao = new GoodsDAO(); //DAO 객체생성
			int cnt = dao.updateRecord(vo);
			if(cnt>0){//수정시 리스트 다시 선택하기
				JOptionPane.showMessageDialog(this, goodsname+ " 상품이 수정되었습니다!");
				goodsAllList();//전체목록 출력
			}else{//수정실패시 안내 메세지 표시 
				JOptionPane.showMessageDialog(this,"상품정보 수정 실패하였습니다"); //부모컨테이너,메세지
			}
		}
	
	
	
	
	//상품삭제
	public void goodsDel() {
		//삭제할 상품번호 
				String delNum = formTf1.getText(); //원래 num값을 넣어야하는데 우리는 입력받는 num가 없음 / 숫자가 있으면 "5", 없으면 " "
			
				if(delNum==null || delNum.equals("")){
				JOptionPane.showMessageDialog(this, "삭제할 상품을 선택후 삭제버튼을 클릭하세요");
				}else {//선택을 해서 값이 있을 경우 
					GoodsDAO dao = new GoodsDAO();
					int result = dao.deleteRecord((delNum)); //삭제할 사원번호를 int로 변경시켜서 deleterecord의 매개변수로 보냄
					//result에 삭제한 레코드 수가 들어있음
					if(result>0) { //회원삭제됨
						JOptionPane.showMessageDialog(this, delNum+"상품을 삭제하였습니다.");
						goodsAllList();//리스트 다시 가져옴
						formDataClear();
					}else { //회원삭제 안됨
						JOptionPane.showMessageDialog(this, delNum+"상품삭제에 실패하였습니다.");
					}
				}
	}
	
	//재고수량
	
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
			GoodsDAO dao = new GoodsDAO(); //DAO 객체생성
			int cnt = dao.updateRecordPstock(vo);
			if(cnt>0){//수정시 리스트 다시 선택하기
				JOptionPane.showMessageDialog(this, goodsname + "재고수량이 수정되었습니다!");
				goodsAllList();//전체목록 출력
			}else{//수정실패시 안내 메세지 표시 
				JOptionPane.showMessageDialog(this,"재고수량 수정 실패하였습니다"); //부모컨테이너,메세지
			}
			
		}
		
	public void esCnt(String goodsname) {//재고수량 수정 (입고 발생 or 판매 발생) 
		GoodsDAO gd = new GoodsDAO();
		int result2 = gd.getE_cnt(goodsname);
		int result3 = gd.getS_cnt(goodsname);
		gd.setStock(goodsname,result2-result3);
		
	}
		
	public void formDataClear() {
			formTf1.setText("");//num값을 지워야 되는데 뭔가 이상함
			formTf2.setText("");
			formTf3.setText("");
	}
	public static void main(String[] args) {
		new GoodsCheck();

	}

}
