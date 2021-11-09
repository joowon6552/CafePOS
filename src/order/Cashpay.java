package order;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cashpay {

	private JFrame frame;
	JTextField tf_Allprice;
	private JTextField tf_Getprice;
	private JTextField tf_Change;
	String textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cashpay window = new Cashpay();
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
	public Cashpay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 539);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Çö±Ý°áÁ¦");
		frame.setResizable(false);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 10, 847, 482);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lb_Jwmenu = new JLabel("JW Cafe");
		lb_Jwmenu.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Jwmenu.setForeground(new Color(160, 82, 45));
		lb_Jwmenu.setFont(new Font("Chiller", Font.BOLD, 52));
		lb_Jwmenu.setBounds(223, 10, 418, 95);
		panel.add(lb_Jwmenu);
		
		
		JLabel lb_Getprice = new JLabel("\uBC1B\uC740 \uAE08\uC561");
		lb_Getprice.setForeground(new Color(160, 82, 45));
		lb_Getprice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Getprice.setFont(new Font("Adobe °íµñ Std B", Font.BOLD, 16));
		lb_Getprice.setBounds(185, 158, 95, 46);
		panel.add(lb_Getprice);
		
		tf_Getprice = new JTextField();
		tf_Getprice.setText("0");
		tf_Getprice.setFont(new Font("±¼¸²", Font.BOLD, 12));
		tf_Getprice.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Getprice.setColumns(10);
		tf_Getprice.setBounds(292, 158, 225, 29);
		panel.add(tf_Getprice);
		
		JLabel lb_Allprice = new JLabel("\uACB0\uC81C \uAE08\uC561");
		lb_Allprice.setForeground(new Color(160, 82, 45));
		lb_Allprice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Allprice.setFont(new Font("Adobe °íµñ Std B", Font.BOLD, 16));
		lb_Allprice.setBounds(185, 258, 95, 46);
		panel.add(lb_Allprice);
		
		tf_Allprice = new JTextField();
		tf_Allprice.setFont(new Font("±¼¸²", Font.BOLD, 12));
		tf_Allprice.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Allprice.setText("0");
		tf_Allprice.setEditable(false);
		tf_Allprice.setColumns(10);
		tf_Allprice.setBounds(292, 258, 225, 29);
		panel.add(tf_Allprice);
		
		
		JLabel lb_Change = new JLabel("\uAC70\uC2A4\uB984 \uB3C8");
		lb_Change.setForeground(new Color(160, 82, 45));
		lb_Change.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Change.setFont(new Font("Adobe °íµñ Std B", Font.BOLD, 16));
		lb_Change.setBounds(185, 358, 95, 46);
		panel.add(lb_Change);
		
		tf_Change = new JTextField();
		tf_Change.setFont(new Font("±¼¸²", Font.BOLD, 12));
		tf_Change.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Change.setText("0");
		tf_Change.setEditable(false);
		tf_Change.setColumns(10);
		tf_Change.setBounds(292, 358, 225, 29);
		panel.add(tf_Change);
		
		JButton btnNewButton = new JButton("\uACB0\uC81C");
		btnNewButton.setForeground(new Color(160, 82, 45));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getprice = Integer.parseInt(tf_Getprice.getText());
				int allprice = Integer.parseInt(tf_Allprice.getText());
				if(getprice >= allprice) {
					tf_Change.setText("" + (getprice - allprice));
					Receipt receipt = new Receipt();
					receipt.lb_Allprice.setText("" + allprice);
					receipt.ta_Order.setText(textArea);
					
					
				}
				else
				JOptionPane.showMessageDialog(null, "¹ÞÀº ±Ý¾×ÀÌ Àû½À´Ï´Ù", "°è»ê¿¡·¯", JOptionPane.WARNING_MESSAGE);
			}
			
		});
		btnNewButton.setFont(new Font("Adobe °íµñ Std B", Font.BOLD, 24));
		btnNewButton.setBounds(561, 158, 157, 229);
		panel.add(btnNewButton);
	}
}
