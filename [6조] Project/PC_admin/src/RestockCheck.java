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
		JButton lbl = new JButton("♥ 입 고 관 리 ♥");
		JButton findlb = new JButton("Search");
		//String lbl1[] = {"년","월","일"};	
		
		JLabel yearlb = new JLabel("년");
		JLabel monlb = new JLabel("월");
		JLabel daylb = new JLabel("일");
		
		JLabel yearlb2 = new JLabel("년");
		JLabel monlb2 = new JLabel("월");
		JLabel daylb2 = new JLabel("일");
		
		JLabel flowlb = new JLabel(" ~ ");
		
		//첫번째 콤보박스 -> 같은 콤보박스를 한번 더 넣으면 들어가지 않거나 순서가 바뀜!!	
		JComboBox<String> yearcombo = new JComboBox<String>();//검색 콤보박스
		DefaultComboBoxModel<String>yearmodel;
		
		JComboBox<String> monthCombo = new JComboBox<String>();//검색 콤보박스
		DefaultComboBoxModel<String>monthModel;
		String monthName[] = new String[12];
		
		JComboBox<String> daycombo = new JComboBox<String>();//검색 콤보박스
		DefaultComboBoxModel<String>daymodel;
		String dayName[]= new String[31];	
		
		//두번째 콤보박스
		JComboBox<String> yearcombo2 = new JComboBox<String>();//검색 콤보박스
		DefaultComboBoxModel<String>yearmodel2;
		
		JComboBox<String> monthCombo2 = new JComboBox<String>();//검색 콤보박스
		DefaultComboBoxModel<String>monthModel2;
		String monthName2[] = new String[12];
		
		JComboBox<String> daycombo2 = new JComboBox<String>();//검색 콤보박스
		DefaultComboBoxModel<String>daymodel2;
		String dayName2[]= new String[31];	
		
	
	//JFrame - West
	JPanel westPane = new JPanel(new BorderLayout());
		JPanel westUpPane = new JPanel(new BorderLayout());
			JPanel wWestPane = new JPanel(new FlowLayout(FlowLayout.LEADING,233,0));//new GridLayout(7,1,20,20)
			String lbl1[] = {"<구분>","<상품구분>","<상품명> ","<입고수량> ","<입고가격>"," <유통기한>","<입고메모>"};
			//~(*º vº*)/♥   ///♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥♡♥
			JPanel wCentPane = new JPanel();
			
				JComboBox<String> goodscombo = new JComboBox<String>();
				DefaultComboBoxModel<String>goodsmodel;
				
				JLabel l1 = new JLabel("~(*º vº*)/♥ ♡♥♡♥♡♥♡♥♡♥");
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
				
				JButton b0 = new JButton("수정");
				JButton b1 = new JButton("추가");
				JButton b2 = new JButton("삭제");
				JButton b3 = new JButton("새로입력");
			
	//JFrame - Center
	JPanel centPane = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
		JTable table;
		JScrollPane sp;
		DefaultTableModel model;
		String title[] = {"구분","상품구분","상품명","입고수량","입고가격","입고날짜","유통기한","입고메모","관리자"};
	
		
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
		setWestUp(); //왼쪽 라벨, 오른쪽 텍스트필드 
		setWestDown();
		
		
		//setSize(1600,900);
		setVisible(true);
		
		restockAllList();
		
	}
		public void setWestUp() {
			//왼쪽 라벨
			for(int i=0; i<lbl1.length; i++) {
				JLabel lbl2 = new JLabel(lbl1[i]);
				lbl2.setPreferredSize(new Dimension(100, 80)); //100,80
				
				//lbl2.setBackground(Color.DARK_GRAY);
				Font fnt = new Font("고딕",Font.BOLD, 14);
				lbl2.setFont(fnt);
				//lbl2.setForeground(Color.white);
				//l1.setForeground(Color.white);
				wWestPane.add(lbl2);
				
				//lbl2.setBackground(Color.LIGHT_GRAY);
				
			//오른쪽 텍스트필드
				wCentPane.setLayout(null);
				wCentPane.add(t0);
				//wCentPane.setBackground(Color.LIGHT_GRAY);
				String goodsName[] = {"스낵/과자","세트/중식/튀김","식사류","분식/양식","라면/우동","커피/음료"};
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
	
	public void setNorth() {///매출관리 맨위 년월일
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
		
		yearcombo.setBackground(Color.white); //콤보박스 배경색
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
		
		//첫번째 콤보박스와 라벨들

		//northPane.setBackground(Color.LIGHT_GRAY);
		
		northPane.add(lbl); //입고관리
		
		lbl.setBackground(Color.DARK_GRAY);
		lbl.setForeground(Color.white);
		Font fnt = new Font("맑은 고딕",Font.BOLD, 13); //버튼 폰트
		lbl.setFont(fnt);
		//lbl.setBounds(2,100,300,300);
		//년 콤보박스
		String yearName[] = {"2021","2020"};
		yearmodel = new DefaultComboBoxModel<String>(yearName); //model에 fontname
		yearcombo.setModel(yearmodel);
		northPane.add(yearcombo);
		northPane.add(yearlb);
		
		//월 콤보박스
		String[] items = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthModel = new DefaultComboBoxModel<String>(items);
		monthCombo.setModel(monthModel);
		northPane.add(monthCombo);
		northPane.add(monlb);
		
		//일 콤보박스
		for(int i=0; i<31; i++) {
			dayName[i]= Integer.toString(i+1);
		}
		daymodel = new DefaultComboBoxModel<String>(dayName); //model에 fontname
		daycombo.setModel(daymodel);
		//findcombo.setSelectedItem("통합검색");
		northPane.add(daycombo);
		northPane.add(daylb);
		
		//물결
		northPane.add(flowlb);
		
		///////
		
		//두번째 콤보박스와 라벨들
		
		//년
		String yearName2[] = {"2021","2020"};
		yearmodel2 = new DefaultComboBoxModel<String>(yearName2); //model에 fontname
		yearcombo2.setModel(yearmodel2);
		northPane.add(yearcombo2);
		northPane.add(yearlb2);
		//월		
		String[] items2 = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthModel2 = new DefaultComboBoxModel<String>(items2);
		monthCombo2.setModel(monthModel2);
		northPane.add(monthCombo2);
		northPane.add(monlb2);
		//일		
		for(int i=0; i<31; i++) {
			dayName2[i]= Integer.toString(i+1);
		}
		daymodel2 = new DefaultComboBoxModel<String>(dayName2); //model에 fontname
		daycombo2.setModel(daymodel2);
		northPane.add(daycombo2);
		northPane.add(daylb2);
		//검색 버튼
		northPane.add(findlb);
		findlb.setBackground(Color.gray);
		findlb.setForeground(Color.white);
		
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		findlb.addActionListener(this);
	
	}
	
	public void restockAllList() { //호출되면 회원 전체목록 출력(이름순서대로)
		RestockDAO dao = new RestockDAO();
		List<RestockVO> list = dao.allRecord();
		setRestockModel(list);
		
	}
	public void setRestockModel(List<RestockVO> list) {
		//기존 JTable의 목록을 지우고 새로 리스트를 출력한다.
		model.setRowCount(0); //기존에 있는거 다지우고 0으로 바꿔버림
		//컬렉션의 vo를 get하여 jtable에 목록으로 추가한다.
		for(int i=0; i<list.size(); i++) {
			RestockVO vo = list.get(i);
			Object[] obj = {vo.getE_Num(), vo.getP_class(), vo.getP_name(), vo.getE_cnt(), vo.getE_price(), vo.getE_date(), vo.getExpiry(),vo.getRemark(),vo.getManager()};
			model.addRow(obj);
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		String event = ae.getActionCommand();
		if(event.equals("추가")) {
			restockInsert();
			restockAllList();
		}else if(event.equals("삭제")) {
			restockDel();
			restockAllList();
		}else if(event.equals("새로입력")){
			formDataClear();
			
		}else if(event.equals("수정")) {
			restockUpdate();
			restockAllList();
			
		}else if(event.equals("Search")) {
			searchDate();
		}
	}
	//입고상품추가	
		public void restockInsert() {
			
			String goodsname = t1.getText();
			String goodsname2 = t2.getText();
			String goodsname3 = t3.getText();
			if(goodsname==null || goodsname.equals("") ) {
				JOptionPane.showMessageDialog(this, "입고할 상품명을 정확히 입력하세요!");
			}else if(goodsname2==null || goodsname2.equals("")) {
				JOptionPane.showMessageDialog(this, "입고할 수량을 정확히 입력하세요!");
			}else if(goodsname3==null || goodsname3.equals("")) {
				JOptionPane.showMessageDialog(this, "입고할 상품금액을 정확히 입력하세요!");
			
			}else {
				JOptionPane.showMessageDialog(this, goodsname +"  상품이 추가되었습니다!!");
				
				RestockVO vo = new RestockVO();
				
				String givecombo = (String)goodscombo.getSelectedItem();
				vo.setP_name(goodsname);
				vo.setP_class(givecombo);
				vo.setE_cnt(Integer.parseInt(t2.getText())); //formTf의 0번째에 번호가 있다 //문자를 int로 바꿔서
				vo.setE_price(Integer.parseInt(t3.getText()));
				vo.setExpiry(Integer.parseInt(t4.getText()));
				vo.setRemark(t5.getText());
				
				
				RestockDAO dao = new RestockDAO();
				int cnt = dao.insertRecord(vo);
				if(cnt>0) {//상품추가
					esCnt(goodsname);
					formDataClear(); //회원이 추가되면 폼의 데이터를 지운다.
					restockAllList();
				}
				
			}
		}
		//상품수정
		
			public void restockUpdate() {
				String goodsname = t1.getText();
				
				String givecombo = (String)goodscombo.getSelectedItem();
				
				RestockVO vo = new RestockVO();
				vo.setE_Num(Integer.parseInt(t0.getText()));
				vo.setP_name(goodsname);
				vo.setP_class(givecombo);	
				vo.setE_cnt(Integer.parseInt(t2.getText())); //formTf의 0번째에 번호가 있다 //문자를 int로 바꿔서
				vo.setE_price(Integer.parseInt(t3.getText()));
				vo.setExpiry(Integer.parseInt(t4.getText()));
				vo.setRemark(t5.getText());
				//vo.setE_Num(ABORT);
			
				RestockDAO dao = new RestockDAO(); //DAO 객체생성
				int cnt = dao.updateRecord(vo);
				if(cnt>0){//수정시 리스트 다시 선택하기
					restockAllList();//전체목록 출력
				}else{//수정실패시 안내 메세지 표시 
					JOptionPane.showMessageDialog(this,"상품정보 수정 실패하였습니다"); //부모컨테이너,메세지
				}
			}
		
		
		
		
		//상품삭제
		public void restockDel() {
			//삭제할 상품번호 
					String delNum = t1.getText(); //원래 num값을 넣어야하는데 우리는 입력받는 num가 없음 / 숫자가 있으면 "5", 없으면 " "
				
					if(delNum==null || delNum.equals("")){
					JOptionPane.showMessageDialog(this, "삭제할 입고상품을 선택후 삭제버튼을 클릭하세요");
					}else {//선택을 해서 값이 있을 경우 
						RestockDAO dao = new RestockDAO();
						int result = dao.deleteRecord((delNum)); //삭제할 사원번호를 int로 변경시켜서 deleterecord의 매개변수로 보냄
						//result에 삭제한 레코드 수가 들어있음
						if(result>0) { //회원삭제됨
							JOptionPane.showMessageDialog(this, delNum+"상품을 삭제하였습니다.");
							restockAllList();//리스트 다시 가져옴
							formDataClear();
						}else { //회원삭제 안됨
							JOptionPane.showMessageDialog(this, delNum+"상품삭제에 실패하였습니다.");
						}
					}
		}
		
		public void esCnt(String goodsname) {//재고수량 수정 (입고 발생 or 판매 발생) 
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
				t1.setText("");//num값을 지워야 되는데 뭔가 이상함
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			
		}
	
	public static void main(String[] args) {
		new RestockCheck();
	}

}
