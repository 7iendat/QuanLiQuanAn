package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import details.MyButton;
import model.User;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.Color;

public class SignUp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfEmail;
	private JPasswordField tfPass;
	private MyButton btnSignUp;
	private MyButton btnCancel;
	private JLabel lblLogin;
	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JPasswordField getTfPass() {
		return tfPass;
	}

	public void setTfPass(JPasswordField tfPass) {
		this.tfPass = tfPass;
	}


	
	
	public SignUp() {
		setTitle("SIGN UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 150, 750, 530);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 278, 493);
		panel.setBackground(new Color(19, 85, 148));
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel1 = new JLabel("HELLO, FRIEND");
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setFont(new Font("VNI-Centur", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel1.setBounds(10, 65, 242, 112);
		panel.add(lblNewLabel1);
		
		JPanel pnSignUp = new JPanel();
		pnSignUp.setBackground(new Color(158, 199, 238));
		pnSignUp.setBounds(278, 0, 458, 493);
		contentPane.add(pnSignUp);
		pnSignUp.setLayout(null);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSignUp.setBounds(133, 10, 208, 34);
		pnSignUp.add(lblSignUp);
		
		JPanel formSignUp = new JPanel();
		formSignUp.setBackground(new Color(158, 199, 238));
		formSignUp.setBounds(0, 60, 458, 269);
		pnSignUp.add(formSignUp);
		formSignUp.setLayout(null);
		
		JLabel lblName = new JLabel("Tên đăng nhập:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(10, 27, 130, 24);
		formSignUp.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 82, 130, 24);
		formSignUp.add(lblEmail);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMtKhu.setBounds(10, 141, 130, 24);
		formSignUp.add(lblMtKhu);
		
		tfName = new JTextField();
		tfName.setBounds(169, 23, 247, 34);
		formSignUp.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(169, 78, 247, 34);
		formSignUp.add(tfEmail);
		
		tfPass = new JPasswordField();
		tfPass.setEchoChar('*');
		tfPass.setColumns(10);
		tfPass.setBounds(169, 131, 247, 34);
		formSignUp.add(tfPass);
		
		
		btnSignUp = new MyButton();
		btnSignUp.setText("Sign Up");
		btnSignUp.setRadius(30);
		btnSignUp.setBorder(null);
		btnSignUp.setColor(new Color(21, 51, 238));
		btnSignUp.setForeground(Color.white);
		btnSignUp.setColorOver(new Color(68, 173, 239));
		btnSignUp.setColorClick(new Color(27, 100, 213));
		btnSignUp.setBorderColor(new Color(123, 195, 241));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignUp.setBounds(72, 204, 119, 34);
		formSignUp.add(btnSignUp);
		
		btnCancel = new MyButton();
		btnCancel.setText("Cancel");
		btnCancel.setRadius(30);
		btnCancel.setBorder(null);
		btnCancel.setColor(new Color(92, 165, 232));
		btnCancel.setBorderColor(new Color(128,149,255));
		btnCancel.setColorClick(new Color(77,77,255));
		btnCancel.setColorOver(new Color(153,170,255));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(280, 204, 126, 34);
		formSignUp.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Have you a account?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(134, 400, 160, 25);
		pnSignUp.add(lblNewLabel);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setBounds(271, 405, 101, 17);
		pnSignUp.add(lblLogin);
		
		JLabel note = new JLabel("Note: Sử dụng Email đã cấp để đăng kí tài khoản!!!");
		note.setFont(new Font("Tahoma", Font.PLAIN, 13));
		note.setBounds(90, 430, 300, 17);
		pnSignUp.add(note);
	}
	
	public void addLoginMouseListener( MouseListener action) {
		lblLogin.addMouseListener(action);
	}
	
	public void addSignUpAction(ActionListener action) {
		btnSignUp.addActionListener(action);
	}
	
	public void addCancelAction(ActionListener action) {
		btnCancel.addActionListener(action);
	}
	
//	public User getUser() {
//		String name = tfName.getText();
//		@SuppressWarnings("deprecation")
//		String pass = tfPass.getText();
//		String email = tfEmail.getText();
//		
//		return new User(name, pass, email);
//	}

}
