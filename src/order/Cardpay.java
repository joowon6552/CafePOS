package order;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;

public class Cardpay {

	private JFrame frame;
	private JTextField tf_Num1;
	private JTextField tf_Num2;
	private JPasswordField pf_Num1;
	private JPasswordField pf_Num2;
	String bank1 = "";
	String textArea;
	int allprice = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cardpay window = new Cardpay();
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
	public Cardpay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 431, 240);
		frame.getContentPane().setLayout(null);
		frame.setTitle("카드결제");
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 420, 203);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		String bank[] = {"은행 선택", "KB국민은행", "신한은행", "하나은행", "우리은행", "NH농협은행", "카카오뱅크", "부산은행"};
		JComboBox comboBox = new JComboBox(bank);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox)e.getSource();
				
				int index = cb.getSelectedIndex();
				if(index==0) {
					JOptionPane.showMessageDialog(null, "은행을 선택해주세요");
				}
				else
				bank1 = bank[index];
			}
			
		});
		comboBox.setBounds(108, 44, 174, 23);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\uCE74\uB4DC \uC885\uB958");
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setBounds(44, 48, 61, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCE74\uB4DC \uBC88\uD638");
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setBounds(44, 104, 61, 15);
		panel.add(lblNewLabel_1);
		
		tf_Num1 = new JTextField();
		tf_Num1.setBounds(108, 101, 53, 21);
		panel.add(tf_Num1);
		tf_Num1.setColumns(10);
		
		tf_Num2 = new JTextField();
		tf_Num2.setColumns(10);
		tf_Num2.setBounds(178, 101, 53, 21);
		panel.add(tf_Num2);
		tf_Num1.setColumns(10);
		
		pf_Num1 = new JPasswordField();
		pf_Num1.setBounds(248, 101, 53, 21);
		panel.add(pf_Num1);
		
		pf_Num2 = new JPasswordField();
		pf_Num2.setBounds(318, 101, 53, 21);
		panel.add(pf_Num2);
		
		JButton btn_Okay = new JButton("\uC785\uB825 \uC644\uB8CC");
		btn_Okay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = "";
				if( a.equals(bank1) || a.equals(tf_Num1.getText()) || 
						a.equals(tf_Num2.getText()) || 
						a.equals(pf_Num1.getText()) || 
						a.equals(pf_Num2.getText())) {
					JOptionPane.showMessageDialog(null, "은행 선택, 혹은 카드번호를 제대로 입력해 주세요");
				}
				else
				{
					Receiptcard receiptcard = new Receiptcard();
					String cardnum = tf_Num1.getText() + "-" + tf_Num2.getText() + "-" + "****" + "-" + "****";
					receiptcard.lb_Cardnum.setText(cardnum);
					receiptcard.lb_Bank.setText(bank1);
					receiptcard.lb_Allprice.setText("" + allprice);
					receiptcard.ta_Order.setText(textArea);
					
				}
			}
		});
		btn_Okay.setBounds(131, 157, 139, 23);
		panel.add(btn_Okay);
		frame.setVisible(true);
	}
}
