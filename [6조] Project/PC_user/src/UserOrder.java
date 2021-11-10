import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class UserOrder extends JDialog implements ActionListener {
	DefaultTableModel model;
	JScrollPane sp;
	
	JTable table;
	List<Object[]> list;
	Font font =new Font("맑은 고딕", Font.BOLD, 30);
	// 테두리
	JPanel edgeEast = new JPanel(new BorderLayout());
	JPanel edgeWest = new JPanel(new BorderLayout());
	JPanel edgeSouth = new JPanel(new BorderLayout());
	JPanel edgeNorth = new JPanel(new BorderLayout());
	JPanel edgeCenter = new JPanel(new BorderLayout());

	// 왼쪽 메뉴 버튼
	JPanel westPane = new JPanel(new BorderLayout());
	JPanel btnContainer = new JPanel(new GridLayout(0, 1, 10, 10));
	List<P_codeVO> btnList = new ArrayList<P_codeVO>();

	// 가운데 음식사진, 왼쪽 빈틈 만들기, 하단 생성
	JPanel centerPane = new JPanel(new BorderLayout());

	JPanel cenGridPane = new JPanel(new GridLayout(0, 4, 10, 10));

	JPanel centerWestPane = new JPanel(new BorderLayout());
	JPanel centerSouthPane = new JPanel(new BorderLayout());

	// 상단 검색
	JPanel northPane = new JPanel(new BorderLayout());

	// setlayout 사용하기 위한 주석
	JPanel northGrid = new JPanel(new GridLayout(1, 5));
	JPanel btnSize = new JPanel(new GridLayout(1, 5));

	JButton findlogo = new JButton();
	JTextField find = new JTextField(50);

	// 하단
	JPanel southPane = new JPanel(new BorderLayout());
	JPanel southGrid = new JPanel(new GridLayout(1, 2, 10, 10));
	JPanel rightGrid = new JPanel(new GridLayout(2, 2, 10, 10));

	// 1. 주문표
	// 2.+/-, 주문요청 사항
	JPanel rightfirUpGrid = new JPanel(new GridLayout(1, 2, 10, 10));
	JPanel extra = new JPanel(new GridLayout(1, 3));
	JPanel rightfirUpBtn = new JPanel(new GridLayout(0, 1, 10, 3));
	JButton plus = new JButton("+");
	Font fnt = new Font("맑은 고딕", Font.BOLD, 15);
	JButton minus = new JButton("-");
	Font fnt2 = new Font("맑은 고딕", Font.BOLD, 9);
	JRadioButton radioBtn = new JRadioButton("선불(현금)");

	JTextArea request = new JTextArea("주문요청내용입력");
	// 3.주문 합계금액, 주문하기 버튼
	JLabel sum = new JLabel("0원  ");
	JButton order = new JButton("상품주문하기");
	String result;
	public UserOrder() {
		super((java.awt.Frame) null, true);
		setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		new setProduct(10);
		

		plus.setFont(fnt2);
		plus.setBackground(new Color(41, 140, 191));
		plus.setForeground(Color.white);
		plus.setBorderPainted(false);
		plus.setFocusable(false);
		minus.setBackground(new Color(41, 140, 191));
		minus.setFont(fnt2);
		minus.setForeground(Color.white);
		minus.setBorderPainted(false);
		minus.setFocusable(false);

		add(BorderLayout.EAST, edgeEast);
		edgeEast.setPreferredSize(new Dimension(20, 1000));
		add(BorderLayout.WEST, edgeWest);
		edgeWest.setPreferredSize(new Dimension(20, 1000));
		add(BorderLayout.SOUTH, edgeSouth);
		edgeSouth.setPreferredSize(new Dimension(1000, 20));
		add(BorderLayout.NORTH, edgeNorth);
		edgeNorth.setPreferredSize(new Dimension(1000, 20));
		add(BorderLayout.CENTER, edgeCenter);

		edgeCenter.add(BorderLayout.WEST, westPane);
		westPane.add(btnContainer);
		setP_classBtn();

		edgeCenter.add(BorderLayout.CENTER, centerPane);
		centerPane.add(BorderLayout.WEST, centerWestPane);
		centerWestPane.setPreferredSize(new Dimension(20, 1000));
		centerPane.add(BorderLayout.NORTH, northPane);
		ImageIcon icon = new ImageIcon("img/searching.png");
		findlogo.setIcon(icon);
		findlogo.setPreferredSize(new Dimension(30, 30));

		northPane.add(northGrid);
		northGrid.add(new JLabel());
		northGrid.add(new JLabel());
		northGrid.add(new JLabel());
		northGrid.add(btnSize);
		btnSize.add(new JLabel());
		btnSize.add(new JLabel());
		btnSize.add(new JLabel());
		btnSize.add(new JLabel());
		btnSize.add(findlogo);
		northGrid.add(find);

		centerPane.add(BorderLayout.SOUTH, southPane);
		southPane.setPreferredSize(new Dimension(1550, 200));
		JPanel wb = new JPanel(new BorderLayout()); // 메뉴 버튼들과 JTable 사이 틈
		southPane.add(BorderLayout.WEST, wb);
		wb.setPreferredSize(new Dimension(20, 200));
		southPane.add(southGrid);

		String title[] = { "상품명", "판매금액", "수량", "최종금액" };
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(30, 50));
		table.setFillsViewportHeight(true);
		southGrid.add(new JScrollPane(table));
		
		southGrid.add(rightGrid);
		rightGrid.add(rightfirUpGrid);
		rightfirUpGrid.add(extra);
		extra.add(rightfirUpBtn);
		extra.add(new JLabel());
		extra.add(new JLabel());
		rightfirUpBtn.add(plus);
		plus.setPreferredSize(new Dimension(20, 20));
		rightfirUpBtn.add(minus);
		rightfirUpBtn.add(new JLabel());
		rightfirUpBtn.add(new JLabel());

		rightfirUpGrid.add(radioBtn);
		radioBtn.setSelected(true);
		radioBtn.setFont(fnt);

		rightGrid.add(sum);
		sum.setHorizontalAlignment(JLabel.RIGHT);
		sum.setFont(font);
		rightGrid.add(request);
		request.setFont(fnt);
		rightGrid.add(order);
		order.setFont(font);
		order.setBackground(new Color(41, 140, 191));
		order.setForeground(Color.white);
		order.setBorderPainted(false);
		order.setFocusable(false);
		JPanel secCenter = new JPanel(new BorderLayout());

		JPanel secCenSouth = new JPanel(new BorderLayout()); // 메뉴들과 아래 틈

		centerPane.add(secCenter);
		secCenter.add(BorderLayout.SOUTH, secCenSouth);
		secCenSouth.setPreferredSize(new Dimension(400, 20));

		JScrollPane fomscroll = new JScrollPane(cenGridPane);
		cenGridPane.setPreferredSize(new Dimension(300, 400));
		secCenter.add(fomscroll);
		
		order.addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		P_codeVO vo = new P_codeVO();
		int p_code = 10;
		if(eventBtn.equals("상품주문하기")) {
			result = request.getText()+"/"+sum.getText();
			for(int i = 0;i<table.getRowCount(); i++) {
				result = result +"^"+ table.getValueAt(i, 0) +" "+ table.getValueAt(i, 2); 
			}
			JOptionPane.showMessageDialog(this, "상품주문이 완료되었습니다.");
			dispose();
		}else if (eventBtn.equals("+")) {
			int row = table.getSelectedRow();
			int howMany = (int)table.getValueAt(row, 2);
			table.setValueAt(++howMany, row, 2);
			table.setValueAt(howMany*(int)table.getValueAt(row, 1), row, 3);
			int sumAll=0;
			for(int i = 0; i<table.getRowCount(); i++) {
				sumAll = sumAll+(int)table.getValueAt(i, 3);
			}
			sum.setText(String.valueOf(sumAll)+"원 ");
		}else if(eventBtn.equals("-")) {
			int row = table.getSelectedRow();
			int howMany = (int)table.getValueAt(row, 2);
			if(howMany>0) {
				table.setValueAt(--howMany, row, 2);
				table.setValueAt(howMany*(int)table.getValueAt(row, 1), row, 3);
				int sumAll=0;
				for(int i = 0; i<table.getRowCount(); i++) {
					sumAll = sumAll+(int)table.getValueAt(i, 3);
				}
				sum.setText(String.valueOf(sumAll)+"원 ");
			}
		}
		
		for (int i = 0; i < btnList.size(); i++) {
			vo = btnList.get(i);
			if (eventBtn.equals(vo.getP_class())) {
				p_code = vo.getP_code();
			}
		}
		new setProduct(p_code);
	}

	public void setP_classBtn() {
		P_codeVO vo = new P_codeVO();
		OrderDAO dao = new OrderDAO();
		btnList = dao.p_classList(vo);
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		for (int i = 0; i < btnList.size(); i++) {
			vo = btnList.get(i);
			JButton btn = new JButton(vo.getP_class());
			btnContainer.add(btn);
			btn.setFont(font);
			btn.setBackground(new Color(124, 124, 124));
			btn.setForeground(Color.white);
			btn.setBorderPainted(false);
			btn.setFocusable(false);
			btn.addActionListener(this);
		}
	}

	

	class setProduct extends JPanel implements ActionListener {
		ProductVO vo = new ProductVO();
		OrderDAO dao = new OrderDAO();
		
		public setProduct(int p_code) {

			cenGridPane.removeAll();
			cenGridPane.setVisible(false);
			setLayout(new BorderLayout());

			List<ProductVO> list = dao.orderInfo(vo);

			int i = 0;
			for (int j = 0; j < list.size(); j++) {
				vo = list.get(j);
				if (vo.getP_code() == p_code) {
					JPanel fomm = new JPanel(new BorderLayout());
					fomm.setBackground(Color.white);
					cenGridPane.add(fomm);
					JPanel top = new JPanel(new GridLayout(1, 2));
					JLabel picLabel = new JLabel("  " + vo.getP_name());
					picLabel.setFont(fnt);
					picLabel.setOpaque(true);
					picLabel.setBackground(Color.white);
					top.add(picLabel);
					JLabel priceLbl = new JLabel(String.valueOf(vo.getS_price()) + " 원  ");
					priceLbl.setHorizontalAlignment(JLabel.RIGHT);
					priceLbl.setFont(fnt);
					priceLbl.setOpaque(true);
					priceLbl.setBackground(Color.white);
					top.add(priceLbl);
					fomm.add(BorderLayout.NORTH, top);
					
					UpdateImg upI = new UpdateImg();
					BufferedImage bi = upI.getDBImage(vo.getP_num());
					MyCanvas mc = new MyCanvas(bi);
					mc.setPreferredSize(new Dimension(250,150));
					fomm.add(mc);
					
					JButton cart = new JButton(vo.getP_name() + " 담기");
					fomm.add(BorderLayout.SOUTH, cart);
					cart.setFont(fnt);
					cart.setForeground(Color.white);
					cart.setBackground(Color.gray);
					cart.setBorderPainted(false);
					cart.setFocusable(false);
					cart.addActionListener(this);
				}
			}
			cenGridPane.setVisible(true);
			
		}
		class MyCanvas extends Canvas {
			BufferedImage bi;
			public MyCanvas(BufferedImage bi) {
				this.bi =bi;
			}
			public void paint(Graphics g) {
				g.drawImage(bi, 0, 0, 250	, 150, this);
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String event = e.getActionCommand();
			vo = dao.getOrder(event.substring(0, event.indexOf(" ")));
			
			Object[] obj = {vo.getP_name(),vo.getS_price(),0,vo.getS_price()*0};
			list = new ArrayList<Object[]>();
			list.add(obj);
			model.addRow(obj);
		}
	}
}
