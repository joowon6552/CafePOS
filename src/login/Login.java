package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import order.Order;
import javax.swing.JComboBox;

public class Login {

	private JFrame frame;
	private JTextField Tf_id;
	private JPasswordField Tf_password;
	private JTextField tf_Idj;
	private JTextField tf_Permissionj;
	private JPasswordField ptf_Passwordj;
	private String id;
	private String password;
	private String permission;
	private String id2 = "";
	private String password2 = "";
	/**
	 * Launch the application.
	 */
	
	public String getAdminId() {
		id = "admin";
		return id;
	}
	
	public String getAdminPassword() {
		password = "1234";
		return password;
	}
	
	public String getPermission() {
		permission = "jwcafe";
		return permission;
	}
	
	public void setId(String id) {
		this.id2 = id;
	}
	
	public void setPassword(String password) {
		this.password2 = password;
	}
	
	public String getId() {
		return id2;
	}
	
	public String getPassword() {
		return password2;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setTitle("로그인");
		frame.setVisible(true);
		
		JPanel panel_Login = new JPanel();
		panel_Login.setBackground(new Color(222, 184, 135));
		panel_Login.setBounds(0, 0, 595, 485);
		frame.getContentPane().add(panel_Login);
		panel_Login.setLayout(null);
		panel_Login.setVisible(true);
		
		JPanel panel_Join = new JPanel();
		panel_Join.setBackground(new Color(222, 184, 135));
		panel_Join.setBounds(0, 0, 595, 485);
		frame.getContentPane().add(panel_Join);
		panel_Join.setLayout(null);
		panel_Join.setVisible(false);
		
		JLabel lblJwCafeLogin = new JLabel("JW Cafe");
		lblJwCafeLogin.setBounds(24, 10, 525, 95);
		lblJwCafeLogin.setForeground(new Color(160, 82, 45));
		lblJwCafeLogin.setFont(new Font("Chiller", Font.BOLD, 52));
		lblJwCafeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Login.add(lblJwCafeLogin);
		
		JLabel Label_id = new JLabel("ID");
		Label_id.setForeground(new Color(160, 82, 45));
		Label_id.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD, 27));
		Label_id.setBounds(142, 223, 52, 33);
		panel_Login.add(Label_id);
		
		JLabel Label_password = new JLabel("Password");
		Label_password.setForeground(new Color(160, 82, 45));
		Label_password.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD, 27));
		Label_password.setBounds(108, 278, 136, 33);
		panel_Login.add(Label_password);
		
		Tf_id = new JTextField();
		Tf_id.setBounds(244, 223, 255, 33);
		Tf_id.setColumns(10);
		panel_Login.add(Tf_id);
		
		Tf_password = new JPasswordField();
		Tf_password.setBounds(244, 278, 255, 33);
		panel_Login.add(Tf_password);
		
		JButton btn_login = new JButton("Login");
		btn_login.setForeground(new Color(160, 82, 45));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(getAdminId().equals(Tf_id.getText()) && getAdminPassword().equals(Tf_password.getText())) {
					frame.setVisible(false);
					Order order = new Order();
				}
				
				else if(getId().equals(Tf_id.getText()) && getPassword().equals(Tf_password.getText())) {
					if(getId() == "" || getPassword() == "") {
						JOptionPane.showMessageDialog(null, "you have failed to log in");
						Tf_id.setText("");
						Tf_password.setText("");
					}
					else {
						frame.setVisible(false);
						Order order = new Order();
					}
				}
				else { 
					JOptionPane.showMessageDialog(null, "you have failed to log in");
					Tf_id.setText("");
					Tf_password.setText("");
				}
			}
		});
		btn_login.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD, 16));
		btn_login.setBounds(363, 338, 136, 48);
		panel_Login.add(btn_login);
		
		JButton btn_join = new JButton("Join");
		btn_join.setForeground(new Color(160, 82, 45));
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tf_id.setText(null);
				Tf_password.setText(null);
				panel_Login.setVisible(false);
				panel_Join.setVisible(true);
			}
		});
		btn_join.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD, 16));
		btn_join.setBounds(363, 396, 136, 48);
		panel_Login.add(btn_join);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(408, 407, 32, 23);
		panel_Login.add(comboBox);
		
		JLabel lblJwCafeJoin = new JLabel("JW Cafe Join");
		lblJwCafeJoin.setBounds(24, 10, 525, 95);
		lblJwCafeJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblJwCafeJoin.setForeground(new Color(160, 82, 45));
		lblJwCafeJoin.setFont(new Font("Chiller", Font.BOLD, 52));
		panel_Join.add(lblJwCafeJoin);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Adobe Caslon Pro Bold", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(201, 165, 50, 15);
		panel_Join.add(lblNewLabel);
		
		tf_Idj = new JTextField();
		tf_Idj.setText("");
		tf_Idj.setBounds(263, 162, 141, 21);
		panel_Join.add(tf_Idj);
		tf_Idj.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Adobe Caslon Pro Bold", Font.PLAIN, 12));
		lblPassword.setForeground(new Color(160, 82, 45));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(160, 232, 91, 15);
		panel_Join.add(lblPassword);
		
		ptf_Passwordj = new JPasswordField();
		ptf_Passwordj.setBounds(263, 229, 140, 21);
		ptf_Passwordj.setText("");
		panel_Join.add(ptf_Passwordj);
		
		JLabel lb_Permissionj = new JLabel("\uC2B9\uC778 \uCF54\uB4DC");
		lb_Permissionj.setFont(new Font("굴림", Font.BOLD, 12));
		lb_Permissionj.setForeground(new Color(160, 82, 45));
		lb_Permissionj.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Permissionj.setBounds(160, 306, 91, 15);
		panel_Join.add(lb_Permissionj);
		
		tf_Permissionj = new JTextField();
		tf_Permissionj.setColumns(10);
		tf_Permissionj.setBounds(263, 303, 141, 21);
		panel_Join.add(tf_Permissionj);
		
		JButton btn_Joinj = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_Joinj.setFont(new Font("굴림", Font.BOLD, 12));
		btn_Joinj.setForeground(new Color(178, 34, 34));
		btn_Joinj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(getPermission().equals(tf_Permissionj.getText())) {
					if(getAdminId().equals(tf_Idj.getText())) {
						JOptionPane.showMessageDialog(null, "중복된 아이디가 존재합니다");
						tf_Idj.setText(null);
						tf_Permissionj.setText(null);
						ptf_Passwordj.setText(null);
					}
					else {
						setId(tf_Idj.getText());
						setPassword(ptf_Passwordj.getText());
						JOptionPane.showMessageDialog(null, "가입이 완료되었습니다");
						
						tf_Idj.setText(null);
						tf_Permissionj.setText(null);
						ptf_Passwordj.setText(null);
						
						panel_Join.setVisible(false);
						panel_Login.setVisible(true);
					}
				}
				else {
					if(getAdminId().equals(tf_Idj.getText())) {
						JOptionPane.showMessageDialog(null, "중복된 아이디 존재, 승인코드 오류");
						tf_Idj.setText(null);
						tf_Permissionj.setText(null);
						ptf_Passwordj.setText(null);
					}
					else
						JOptionPane.showMessageDialog(null, "승인코드 오류");
					tf_Idj.setText(null);
					tf_Permissionj.setText(null);
					ptf_Passwordj.setText(null);
				}
			}
		});
		btn_Joinj.setBounds(108, 400, 186, 34);
		panel_Join.add(btn_Joinj);
		
		JButton btn_Gotologinj = new JButton("\uB85C\uADF8\uC778\uD558\uAE30");
		btn_Gotologinj.setFont(new Font("굴림", Font.BOLD, 12));
		btn_Gotologinj.setForeground(new Color(178, 34, 34));
		btn_Gotologinj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_Idj.setText(null);
				tf_Permissionj.setText(null);
				ptf_Passwordj.setText(null);
				panel_Join.setVisible(false);
				panel_Login.setVisible(true);
			}
		});
		btn_Gotologinj.setBounds(306, 400, 186, 34);
		panel_Join.add(btn_Gotologinj);
	}
}
