package view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import details.MyButton;
import model.CustomerInfosModel;
import model.User;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	User user = new User();
	
	private JPasswordField tfPass;
	private JPanel contentPane;
	private MyButton btnLogin;
	private MyButton btnCancel;
	private  JLabel lblSignUp;
	
	public JLabel getLblSignUp() {
		return lblSignUp;
	}

	public void setLblSignUp(JLabel lblSignUp) {
		this.lblSignUp = lblSignUp;
	}

	private JTextField tfName;

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JPasswordField getTfPass() {
		return tfPass;
	}

	public void setTfPass(JPasswordField tfPass) {
		this.tfPass = tfPass;
	}


	/**
	 * Create the panel.
	 */
	public Login() {
		setTitle("SIGN IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 750, 550);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 262, 530);
		panel.setBackground(new Color(19, 85, 148));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("HELLO, FRIEND");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("VNI-Centur", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(10, 65, 242, 112);
		panel.add(lblNewLabel);
		
		JPanel pnLoginR = new JPanel();
		pnLoginR.setBackground(new Color(158, 199, 238) );
		pnLoginR.setBounds(260, 0, 490, 530);
		getContentPane().add(pnLoginR);
		pnLoginR.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Not a member?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(170, 476, 114, 28);
		pnLoginR.add(lblNewLabel_1);
		
		 lblSignUp = new JLabel("Sign up now");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSignUp.setBounds(269, 480, 100, 21);
		pnLoginR.add(lblSignUp);
		
		JPanel formLogin = new JPanel();
		formLogin.setBackground(new Color(158, 199, 238));
		formLogin.setBounds(0, 87, 490, 255);
		pnLoginR.add(formLogin);
		formLogin.setLayout(null);
		
		JLabel lblName = new JLabel("Tên đăng nhập:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(24, 51, 130, 28);
		formLogin.add(lblName);
		
		JLabel lblPass = new JLabel("Mật khẩu:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPass.setBounds(27, 117, 130, 28);
		formLogin.add(lblPass);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfName.setColumns(10);
		tfName.setBounds(168, 51, 265, 28);
		formLogin.add(tfName);
		
		tfPass = new JPasswordField();
		tfPass.setEchoChar('*');
		tfPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPass.setColumns(10);
		tfPass.setBounds(168, 114, 265, 28);
		formLogin.add(tfPass);
		

		
		btnLogin = new MyButton();
		btnLogin.setText("Sign In");
		btnLogin.setRadius(30);
		btnLogin.setBorder(null);
		btnLogin.setColor(new Color(21, 51, 238));
		btnLogin.setForeground(Color.white);
		btnLogin.setColorOver(new Color(68, 173, 239));
		btnLogin.setColorClick(new Color(27, 100, 213));
		btnLogin.setBorderColor(new Color(123, 195, 241));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(53, 165, 163, 39);
		formLogin.add(btnLogin);
		
		btnCancel = new MyButton();
		btnCancel.setText("Cancel");
		btnCancel.setRadius(30);
		btnCancel.setBorder(null);
		btnCancel.setColor(new Color(92, 165, 232));
		btnCancel.setBorderColor(new Color(128,149,255));
		btnCancel.setColorClick(new Color(77,77,255));
		btnCancel.setColorOver(new Color(153,170,255));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(262, 167, 163, 39);
		formLogin.add(btnCancel);
		
		JLabel lblLogin = new JLabel("SIGN IN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLogin.setBounds(90, 30, 313, 39);
		pnLoginR.add(lblLogin);
		
	}
	
	public void addActionLogin(ActionListener action)
	{
		btnLogin.addActionListener(action);
	}
	
	public void addActionCancel(ActionListener action)
	{
		btnCancel.addActionListener(action);
	}
	
	public void addActionSignUp(MouseListener action)
	{
		lblSignUp.addMouseListener(action);
	}
	
//	public User userInput() {
//		String name = tfName.getText();
//		String pass = tfPass.getText();
//		return new User(name, pass);
//	}
	
	
}
