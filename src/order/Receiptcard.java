package order;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Receiptcard {

	private JFrame frame;
	JTextArea ta_Order;
	JLabel lb_Allprice;
	JLabel lb_Cardnum;
	JLabel lb_Bank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receiptcard window = new Receiptcard();
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
	public Receiptcard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 614, 512);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Ä«µå°áÁ¦ ¿µ¼öÁõ");
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 600, 469);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lb_Jwmenu = new JLabel("\uC601\uC218\uC99D");
		lb_Jwmenu.setBounds(0, 10, 600, 61);
		lb_Jwmenu.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Jwmenu.setForeground(Color.BLACK);
		lb_Jwmenu.setFont(new Font("HY¿±¼­M", Font.PLAIN, 52));
		panel.add(lb_Jwmenu);
		
		JLabel lblNewLabel = new JLabel("\uCE74\uD398\uBA85 : Jw Cafe");
		lblNewLabel.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(34, 74, 110, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB300\uD45C : \uBC15\uC8FC\uC6D0");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lblNewLabel_1.setBounds(34, 91, 75, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC804\uD654\uBC88\uD638 : 010-4620-6550");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(34, 108, 190, 15);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC8FC\uC18C : \uBD80\uC0B0\uAD11\uC5ED\uC2DC \uB3D9\uB798\uAD6C");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(34, 121, 144, 15);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("------------------------------------------------------");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(34, 133, 410, 15);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel label_Time = new JLabel("\uACB0\uC81C \uC2DC\uAC04");
		label_Time.setHorizontalAlignment(SwingConstants.LEFT);
		label_Time.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		label_Time.setBounds(34, 146, 85, 15);
		panel.add(label_Time);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("------------------------------------------------------");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(34, 158, 410, 15);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lb_Time_1 = new JLabel("\uC8FC\uBB38 \uB0B4\uC5ED");
		lb_Time_1.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Time_1.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lb_Time_1.setBounds(34, 168, 75, 15);
		panel.add(lb_Time_1);
		
		ta_Order = new JTextArea();
		ta_Order.setEditable(false);
		ta_Order.setBounds(34, 183, 522, 209);
		panel.add(ta_Order);
		
		JLabel lblNewLabel_2 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		lblNewLabel_2.setFont(new Font("HY¿±¼­M", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(34, 392, 144, 52);
		panel.add(lblNewLabel_2);
		
		lb_Allprice = new JLabel("0");
		lb_Allprice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Allprice.setFont(new Font("HY¿±¼­M", Font.BOLD, 30));
		lb_Allprice.setBounds(190, 392, 343, 52);
		panel.add(lb_Allprice);
		
		Calendar oCalendar = Calendar.getInstance( );
		JLabel lb_Time = new JLabel();
		lb_Time.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Time.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lb_Time.setBounds(128, 146, 316, 15);
		panel.add(lb_Time);
		
		lb_Bank = new JLabel("KB±¹¹ÎÀºÇà");
		lb_Bank.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Bank.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lb_Bank.setBounds(267, 74, 85, 15);
		panel.add(lb_Bank);
		
		lb_Cardnum = new JLabel();
		lb_Cardnum.setHorizontalAlignment(SwingConstants.LEFT);
		lb_Cardnum.setFont(new Font("HY¿±¼­M", Font.BOLD, 12));
		lb_Cardnum.setBounds(357, 74, 231, 15);
		panel.add(lb_Cardnum);
	}
}
