package order;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import login.Login;

public class Order {

	private JFrame frame;
	private JTextField tf_Amount, tf_Price, tf_Allprice;
	JTextArea textArea;
	private JLabel lb_Selected_Menu, lb_Selected_Size, lb_Selected_Tem, lb_Selected_Shot, lb_Selected_Whip, lb_Selected_Amount;
	private static JCheckBox cb_Shot, cb_Whip;
	private static JRadioButton radio_Small, radio_Regular, radio_Venti, radio_Ice, radio_Hot;
	
	
	//(메소드)선택한 온도, 사이즈, 토핑, 수량 레이블에 출력
	public void setlabelText() {
		
		if(lb_Selected_Menu.getText() == "없음") {
			JOptionPane.showMessageDialog(null, "메뉴를 선택해주세요", "메뉴선택 에러", JOptionPane.WARNING_MESSAGE);
			
			//글자 출력부분 초기화
			lb_Selected_Size.setText(null);
			lb_Selected_Tem.setText(null);
			lb_Selected_Shot.setText(null);
			lb_Selected_Whip.setText(null);
			lb_Selected_Amount.setText(null);
			
			//라디오버튼 초기화
			radio_Small.setSelected(true);
			radio_Ice.setSelected(true);
			cb_Shot.setSelected(false);
			cb_Whip.setSelected(false);
			
			//가격 초기화
			tf_Price.setText("0");
		}
		
		else {
			
		//온도
		if(radio_Ice.isSelected() == true) {
			lb_Selected_Tem.setText("" + radio_Ice.getText());
		}
		
		else
			lb_Selected_Tem.setText("" + radio_Hot.getText());
		
		//추가
		if(cb_Shot.isSelected() == true) {
			lb_Selected_Shot.setText("" + cb_Shot.getText());
		}
		
		if(cb_Shot.isSelected() == false) {
			lb_Selected_Shot.setText(null);
		}
		
		if(cb_Whip.isSelected() == true) {
			lb_Selected_Whip.setText("" + cb_Whip.getText());
		}
		
		if(cb_Whip.isSelected() == false) {
			lb_Selected_Whip.setText(null);
		}
		
		//사이즈
		if(radio_Regular.isSelected() == true) {
			lb_Selected_Size.setText("" + radio_Regular.getText());
		}
		
		else if(radio_Venti.isSelected() == true) {
			lb_Selected_Size.setText("" + radio_Venti.getText());
		}
		
		else
			lb_Selected_Size.setText("" + radio_Small.getText());
		
		//수량
		int amount = Integer.parseInt(tf_Amount.getText());
		
		if(amount>=1) {
			lb_Selected_Amount.setText("" + amount);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "1개 이상의 수량을 입력해주세요", "수량 에러", JOptionPane.WARNING_MESSAGE);
			lb_Selected_Size.setText(null);
			lb_Selected_Tem.setText(null);
			lb_Selected_Shot.setText(null);
			lb_Selected_Whip.setText(null);
			lb_Selected_Amount.setText(null);
			tf_Amount.setText("1");
			tf_Price.setText("0");
			}
		}
	}
	
	//(메소드)커피 온도, 사이즈, 토핑을 더한 가격(아무것도 선택하지 않을 시, 그대로 출력)
	public int subAdd() { 
		
		int price;
		int amount;
		price = MyActionListener.price;
		amount = Integer.parseInt(tf_Amount.getText());
		
		if(lb_Selected_Menu.getText() != "없음") {
		
		//체크박스 토핑 추가
		if(cb_Shot.isSelected() == true) {
			price += 500;
		}
		
		if(cb_Shot.isSelected() == false) {
		}
		
		if(cb_Whip.isSelected() == true) {
			price += 500;
		}
		
		if(cb_Whip.isSelected() == false) {
		}
		
		//사이즈 가격
		if(radio_Regular.isSelected() == true) {
			price += 800;
		}
		else if(radio_Venti.isSelected() == true) {
			price += 1500;
		}
		
		price *= amount;
		
		return price;
		
		}
		
		else
			tf_Amount.setText("1");
			return price;
		
	}
	
	
	
	class MyActionListener implements ActionListener {
		
		static int price = 0;
		  
		
		public void actionPerformed(ActionEvent e) {
			
			// 커메뉴 액션 버튼
			JButton b = (JButton)e.getSource();
			
			// 커피 S사이즈 가격
			if(b.getText() == "아메리카노") {
				price = 4500;
			}
			
			if(b.getText() == "카페라떼" || b.getText() == "카푸치노") {
				price = 5000;
			}
			
			if(b.getText() == "카라멜 마키아토" || b.getText() == "바닐라라떼" || b.getText() == "카페모카") {
				price = 5500;
			}
			
			if(b.getText() == "아포가토") {
				price = 6000;
			}
			
			if(b.getText() == "에스프레소 더블") {
				price = 4000;
			}
			
			if(b.getText() == "마키아토") {
				price = 4300;
			}
			
			if(b.getText() == "에티오피아 구지" || b.getText() == "케냐 칸누구" || b.getText() == "르완다 쿠카무" || b.getText() == "코스타리카 타라주" 
					|| b.getText() == "파나마 팔미라" || b.getText() == "사푼사푼") {
				price = 6800;
			}
			
			//현재 선택된 메뉴이름 글자출력
			lb_Selected_Menu.setText(b.getText());
			
			//글자 출력부분 초기화
			lb_Selected_Size.setText(null);
			lb_Selected_Tem.setText(null);
			lb_Selected_Shot.setText(null);
			lb_Selected_Whip.setText(null);
			lb_Selected_Amount.setText(null);
			
			//라디오버튼 초기화
			radio_Small.setSelected(true);
			radio_Ice.setSelected(true);
			cb_Shot.setSelected(false);
			cb_Whip.setSelected(false);
			
			//수량 초기화
			tf_Amount.setText("1");
			
			//가격 초기화
			tf_Price.setText("0");
			
			
		}
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order window = new Order();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Order() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1142, 765);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("주문");
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 10, 1181, 728);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lb_Jwmenu = new JLabel("JW Cafe Menu");
		lb_Jwmenu.setBounds(0, 10, 1127, 95);
		lb_Jwmenu.setForeground(new Color(160, 82, 45));
		lb_Jwmenu.setFont(new Font("Chiller", Font.BOLD, 52));
		lb_Jwmenu.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb_Jwmenu);
		
		JButton btn_Americano = new JButton("\uC544\uBA54\uB9AC\uCE74\uB178");
		btn_Americano.setForeground(new Color(160, 82, 45));
		btn_Americano.setBounds(76, 100, 193, 76);
		btn_Americano.addActionListener(new MyActionListener());
		panel.add(btn_Americano);
		
		JButton btn_Cafelatte = new JButton("\uCE74\uD398\uB77C\uB5BC");
		btn_Cafelatte.setForeground(new Color(160, 82, 45));
		btn_Cafelatte.setBounds(276, 100, 193, 76);
		btn_Cafelatte.addActionListener(new MyActionListener());
		panel.add(btn_Cafelatte);
		
		JButton btn_Cafuchino = new JButton("\uCE74\uD478\uCE58\uB178");
		btn_Cafuchino.setForeground(new Color(160, 82, 45));
		btn_Cafuchino.setBounds(476, 100, 193, 76);
		btn_Cafuchino.addActionListener(new MyActionListener());
		panel.add(btn_Cafuchino);
		
		JButton btn_Caramel = new JButton("\uCE74\uB77C\uBA5C \uB9C8\uD0A4\uC544\uD1A0");
		btn_Caramel.setForeground(new Color(160, 82, 45));
		btn_Caramel.setBounds(676, 100, 193, 76);
		btn_Caramel.addActionListener(new MyActionListener());
		panel.add(btn_Caramel);
		
		JButton btn_Vanilla = new JButton("\uBC14\uB2D0\uB77C\uB77C\uB5BC");
		btn_Vanilla.setForeground(new Color(160, 82, 45));
		btn_Vanilla.setBounds(876, 100, 193, 76);
		btn_Vanilla.addActionListener(new MyActionListener());
		panel.add(btn_Vanilla);
		
		JButton btn_Cafemoka = new JButton("\uCE74\uD398\uBAA8\uCE74");
		btn_Cafemoka.setForeground(new Color(160, 82, 45));
		btn_Cafemoka.setBounds(76, 176, 193, 76);
		btn_Cafemoka.addActionListener(new MyActionListener());
		panel.add(btn_Cafemoka);
		
		JButton btn_Apogato = new JButton("\uC544\uD3EC\uAC00\uD1A0");
		btn_Apogato.setForeground(new Color(160, 82, 45));
		btn_Apogato.setBounds(276, 176, 193, 76);
		btn_Apogato.addActionListener(new MyActionListener());
		panel.add(btn_Apogato);
		
		JButton btn_Espresso = new JButton("\uC5D0\uC2A4\uD504\uB808\uC18C \uB354\uBE14");
		btn_Espresso.setForeground(new Color(160, 82, 45));
		btn_Espresso.setBounds(476, 176, 193, 76);
		btn_Espresso.addActionListener(new MyActionListener());
		panel.add(btn_Espresso);
		
		JButton btn_Makiatto = new JButton("\uB9C8\uD0A4\uC544\uD1A0");
		btn_Makiatto.setForeground(new Color(160, 82, 45));
		btn_Makiatto.setBounds(676, 176, 193, 76);
		btn_Makiatto.addActionListener(new MyActionListener());
		panel.add(btn_Makiatto);
		
		JButton btn_Guzi = new JButton("\uC5D0\uD2F0\uC624\uD53C\uC544 \uAD6C\uC9C0");
		btn_Guzi.setForeground(new Color(160, 82, 45));
		btn_Guzi.setBounds(876, 176, 193, 76);
		btn_Guzi.addActionListener(new MyActionListener());
		panel.add(btn_Guzi);
		
		JButton btn_Kenya = new JButton("\uCF00\uB0D0 \uCE78\uB204\uAD6C");
		btn_Kenya.setForeground(new Color(160, 82, 45));
		btn_Kenya.setBounds(76, 251, 193, 76);
		btn_Kenya.addActionListener(new MyActionListener());
		panel.add(btn_Kenya);
		
		JButton btn_Ruwanda = new JButton("\uB974\uC644\uB2E4 \uCFE0\uCE74\uBB34");
		btn_Ruwanda.setForeground(new Color(160, 82, 45));
		btn_Ruwanda.setBounds(276, 251, 193, 76);
		btn_Ruwanda.addActionListener(new MyActionListener());
		panel.add(btn_Ruwanda);
		
		JButton btn_Cosutarica = new JButton("\uCF54\uC2A4\uD0C0\uB9AC\uCE74 \uD0C0\uB77C\uC8FC");
		btn_Cosutarica.setForeground(new Color(160, 82, 45));
		btn_Cosutarica.setBounds(476, 251, 193, 76);
		btn_Cosutarica.addActionListener(new MyActionListener());
		panel.add(btn_Cosutarica);
		
		JButton btn_Panama = new JButton("\uD30C\uB098\uB9C8 \uD314\uBBF8\uB77C");
		btn_Panama.setForeground(new Color(160, 82, 45));
		btn_Panama.setBounds(676, 251, 193, 76);
		btn_Panama.addActionListener(new MyActionListener());
		panel.add(btn_Panama);
		
		JButton btn_SafunSafun = new JButton("\uC0AC\uD47C\uC0AC\uD47C");
		btn_SafunSafun.setForeground(new Color(160, 82, 45));
		btn_SafunSafun.setBounds(876, 251, 193, 76);
		btn_SafunSafun.addActionListener(new MyActionListener());
		panel.add(btn_SafunSafun);
		
		JPanel panel_Size = new JPanel();
		panel_Size.setBackground(new Color(222, 184, 135));
		panel_Size.setBounds(197, 352, 107, 112);
		panel.add(panel_Size);
		panel_Size.setLayout(null);
		
		radio_Small = new JRadioButton("Small");
		radio_Small.setBackground(new Color(222, 184, 135));
		radio_Small.setSelected(true);
		radio_Small.setBounds(8, 17, 73, 23);
		panel_Size.add(radio_Small);
		
		radio_Regular = new JRadioButton("Regular");
		radio_Regular.setBackground(new Color(222, 184, 135));
		radio_Regular.setBounds(8, 50, 73, 23);
		panel_Size.add(radio_Regular);
		
		radio_Venti = new JRadioButton("Venti");
		radio_Venti.setBackground(new Color(222, 184, 135));
		radio_Venti.setBounds(8, 83, 73, 23);
		panel_Size.add(radio_Venti);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(radio_Small);
		bg.add(radio_Regular);
		bg.add(radio_Venti);
		Border border = BorderFactory.createTitledBorder("사이즈");
		panel_Size.setBorder(border);
		
		JPanel panel_Tem = new JPanel();
		panel_Tem.setBackground(new Color(222, 184, 135));
		panel_Tem.setBounds(327, 352, 87, 112);
		panel.add(panel_Tem);
		panel_Tem.setLayout(null);
		
		radio_Ice = new JRadioButton("ICE");
		radio_Ice.setBackground(new Color(222, 184, 135));
		radio_Ice.setSelected(true);
		radio_Ice.setBounds(8, 23, 59, 23);
		panel_Tem.add(radio_Ice);
		
		radio_Hot = new JRadioButton("HOT");
		radio_Hot.setBackground(new Color(222, 184, 135));
		radio_Hot.setBounds(8, 64, 59, 23);
		panel_Tem.add(radio_Hot);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(radio_Ice);
		bg2.add(radio_Hot);
		Border border2 = BorderFactory.createTitledBorder("온도");
		panel_Tem.setBorder(border2);
		
		JPanel panel_Add = new JPanel();
		panel_Add.setBackground(new Color(222, 184, 135));
		panel_Add.setBounds(446, 352, 173, 112);
		panel.add(panel_Add);
		panel_Add.setLayout(null);
		
		cb_Shot = new JCheckBox("\uC0F7 \uCD94\uAC00(+500)");
		cb_Shot.setBackground(new Color(222, 184, 135));
		cb_Shot.setBounds(19, 23, 107, 23);
		panel_Add.add(cb_Shot);
		
		cb_Whip = new JCheckBox("\uD718\uD551 \uCD94\uAC00(+500)");
		cb_Whip.setBackground(new Color(222, 184, 135));
		cb_Whip.setBounds(19, 64, 123, 23);
		panel_Add.add(cb_Whip);
		
		ButtonGroup bg3 = new ButtonGroup();
		Border border3 = BorderFactory.createTitledBorder("추가");
		panel_Add.setBorder(border3);
		
		JLabel lb_Amount = new JLabel("\uC218\uB7C9");
		lb_Amount.setBounds(663, 377, 50, 15);
		panel.add(lb_Amount);
		
		tf_Amount = new JTextField();
		tf_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Amount.setEnabled(true);
		tf_Amount.setEditable(true);
		tf_Amount.setText("1");
		tf_Amount.setBounds(713, 374, 96, 21);
		panel.add(tf_Amount);
		tf_Amount.setColumns(10);
		
		JLabel lb_Amount_1 = new JLabel("\uAE08\uC561");
		lb_Amount_1.setBounds(663, 404, 50, 15);
		panel.add(lb_Amount_1);
		
		tf_Price = new JTextField();
		tf_Price.setText("0");
		tf_Price.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Price.setEditable(false);
		tf_Price.setColumns(10);
		tf_Price.setBounds(713, 401, 96, 21);
		panel.add(tf_Price);
		
		JLabel lb_Amount_2 = new JLabel("\uCD1D \uAE08\uC561");
		lb_Amount_2.setBounds(663, 432, 50, 15);
		panel.add(lb_Amount_2);
		
		tf_Allprice = new JTextField();
		tf_Allprice.setText("0");
		tf_Allprice.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Allprice.setEnabled(true);
		tf_Allprice.setEditable(false);
		tf_Allprice.setColumns(10);
		tf_Allprice.setBounds(713, 429, 96, 21);
		panel.add(tf_Allprice);
		
		JButton btn_Check = new JButton("\uD655\uC778");
		btn_Check.setBounds(834, 364, 87, 45);
		btn_Check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tf_Price.setText("" + subAdd());
				setlabelText();
				
			}
			
		});
		panel.add(btn_Check);
		
		JButton btn_Order = new JButton("\uC8FC\uBB38");
		btn_Order.setBounds(947, 364, 87, 45);
		btn_Order.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lb_Selected_Menu.getText() != "없음" && lb_Selected_Size.getText() != null) {
			
				int price = Integer.parseInt(tf_Price.getText());
				int allprice = Integer.parseInt(tf_Allprice.getText());
				
				allprice += price;
				tf_Allprice.setText("" + allprice);
				textArea.append("메뉴: " + lb_Selected_Menu.getText() + " 사이즈: " + lb_Selected_Size.getText() + " 온도: "
				+ lb_Selected_Tem.getText() + " 샷: " + lb_Selected_Shot.getText() + " 휘핑: " + lb_Selected_Whip.getText()
				+ " 수량: " + lb_Selected_Amount.getText() + "\n");
				
				//글자 출력부분 초기화
				lb_Selected_Menu.setText("없음");
				lb_Selected_Size.setText(null);
				lb_Selected_Tem.setText(null);
				lb_Selected_Shot.setText(null);
				lb_Selected_Whip.setText(null);
				lb_Selected_Amount.setText(null);
				
				//라디오버튼 초기화
				radio_Small.setSelected(true);
				radio_Ice.setSelected(true);
				cb_Shot.setSelected(false);
				cb_Whip.setSelected(false);
				
				//수량 초기화
				tf_Amount.setText("1");
				
				//가격 초기화
				tf_Price.setText("0");
				}
			}
				
			
	});
		panel.add(btn_Order);
		
		
		JButton btn_Initial = new JButton("\uCD08\uAE30\uD654");
		btn_Initial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "초기화 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					
					//현재 선택된 메뉴이름 글자출력
					lb_Selected_Menu.setText("없음");
					
					//글자 출력부분 초기화
					lb_Selected_Size.setText(null);
					lb_Selected_Tem.setText(null);
					lb_Selected_Shot.setText(null);
					lb_Selected_Whip.setText(null);
					lb_Selected_Amount.setText(null);
					
					//라디오버튼 초기화
					radio_Small.setSelected(true);
					radio_Ice.setSelected(true);
					cb_Shot.setSelected(false);
					cb_Whip.setSelected(false);
					
					//수량 초기화
					tf_Amount.setText("1");
					
					//가격 초기화
					tf_Price.setText("0");
					tf_Allprice.setText("0");
					
					//주문된 메뉴 초기화
					textArea.setText(null);
				}
				
				
			}
		});
		btn_Initial.setBounds(834, 419, 200, 45);
		panel.add(btn_Initial);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(89, 491, 670, 197);
		
		panel.add(textArea);
		
		JButton btn_Cash = new JButton("\uD604\uAE08 \uACB0\uC81C");
		btn_Cash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int allprice = Integer.parseInt(tf_Allprice.getText());
				if(allprice == 0) {
					JOptionPane.showMessageDialog(null, "메뉴를 주문해주세요");
				}
				else {
					Cashpay cashpay = new Cashpay();
					cashpay.tf_Allprice.setText("" + tf_Allprice.getText());
					cashpay.textArea = textArea.getText();
				}
			}
		});
		btn_Cash.setBounds(818, 519, 251, 65);
		panel.add(btn_Cash);
		
		JButton btn_Card = new JButton("\uCE74\uB4DC \uACB0\uC81C");
		btn_Card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int allprice = Integer.parseInt(tf_Allprice.getText());
				if(allprice == 0) {
					JOptionPane.showMessageDialog(null, "메뉴를 주문해주세요");
				}
				else {
					Cardpay cardpay = new Cardpay();
					cardpay.allprice = allprice;
					cardpay.textArea = textArea.getText();
				}
			}
		});
		btn_Card.setBounds(818, 592, 251, 65);
		panel.add(btn_Card);
		
		JButton btn_Logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_Logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				
				if(result == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					Login login = new Login();
				}
			}
		});
		btn_Logout.setBounds(997, 10, 91, 23);
		btn_Logout.addActionListener(null);
		panel.add(btn_Logout);
		
		lb_Selected_Menu = new JLabel("\uC5C6\uC74C");
		lb_Selected_Menu.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Selected_Menu.setBounds(12, 389, 173, 15);
		panel.add(lb_Selected_Menu);
		
		lb_Selected_Size = new JLabel("");
		lb_Selected_Size.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Selected_Size.setBounds(12, 404, 173, 15);
		panel.add(lb_Selected_Size);
		
		lb_Selected_Tem = new JLabel("");
		lb_Selected_Tem.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Selected_Tem.setBounds(12, 419, 173, 15);
		panel.add(lb_Selected_Tem);
		
		lb_Selected_Shot = new JLabel("");
		lb_Selected_Shot.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Selected_Shot.setBounds(12, 432, 173, 15);
		panel.add(lb_Selected_Shot);
		
		lb_Selected_Whip = new JLabel("");
		lb_Selected_Whip.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Selected_Whip.setBounds(12, 449, 173, 15);
		panel.add(lb_Selected_Whip);
		
		lb_Selected_Amount = new JLabel("");
		lb_Selected_Amount.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Selected_Amount.setBounds(12, 465, 173, 15);
		panel.add(lb_Selected_Amount);
		
		JLabel lb_notify = new JLabel("\uC120\uD0DD\uB41C \uBA54\uB274");
		lb_notify.setBounds(67, 362, 73, 15);
		panel.add(lb_notify);
		
	}
}

