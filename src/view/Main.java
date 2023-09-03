package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import controller.LoginController.LoginController;
import controller.OrderController.OrderController;
import details.MyButton;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {

	User user ; 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  JPanel pnRight = new JPanel();
	private JPanel pnLeft = new JPanel();
	private MyButton order;
	private MyButton btnC;
	private MyButton infApp;
	private MyButton btnBills;
	private MyButton btnSchedule;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	private final JLabel lblName = new JLabel("SHOP NAME");
	

	

	public JPanel getPnRight() {
		return pnRight;
	}
	public void setPnRight(JPanel pnRight) {
		this.pnRight = pnRight;
	}
	
	public Main( User user) {
		
		
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1300, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		pnLeft.setBackground(new Color(255,34,85));
		pnLeft.setForeground(new Color(0, 0, 0));
		pnLeft.setBounds(0, 0, 300, 775);
		contentPane.add(this.getPnLeft());
		pnLeft.setLayout(null);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setForeground(Color.white );
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(18, 5, 265, 37);
		pnLeft.add(lblName);
		
		
		
		
		order = new MyButton();
		order.setText("ORDER");
		order.setFocusPainted(false);
		order.setBorder(null);
		order.setBounds(40, 163, 220, 43);
		order.setRadius(30);
		order.setForeground(Color.white);
//		btnSchedule.setForeground(new Color(0, 0, 0));
		order.setFont(new Font("Tahoma", Font.BOLD, 16));
//		btnSchedule.setColor(new Color(255, 255, 128));
		order.setColor(new Color(28, 181, 224));
		pnLeft.add(order);
		
		 btnC = new MyButton();
		 btnC.setText("LOG OUT");
		 btnC.setBorder(null);
		 btnC.setBounds(40, 623, 220, 43);
		 btnC.setRadius(30);
		 btnC.setForeground(Color.white);
		btnC.setFont(new Font("Tahoma", Font.BOLD, 16));
//		btnC.setColor(new Color(255, 255, 128));
		btnC.setColor(new Color(28, 181, 224));
		
		pnLeft.add(btnC);
		
		
		infApp = new MyButton();
		infApp.setText("INFORMATION OF APP");
		infApp.setBorder(null);
		infApp.setRadius(30);
		infApp.setFont(new Font("Tahoma", Font.BOLD, 16));
		infApp.setForeground(Color.white);
//		infApp.setColor(new Color(255, 255, 128));
		infApp.setBounds(40, 500, 220, 43);
		infApp.setColor(new Color(28, 181, 224));
		pnLeft.add(infApp);
		
		btnBills = new MyButton();
		btnBills.setText("BILLS");
		btnBills.setBorder(null);
		btnBills.setRadius(30);
		btnBills.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBills.setForeground(Color.white);
//		infApp.setColor(new Color(255, 255, 128));
		btnBills.setBounds(40, 387, 220, 43);
		btnBills.setColor(new Color(28, 181, 224));
		pnLeft.add(btnBills);
		
		btnSchedule = new MyButton();
		btnSchedule.setText("SCHEDULE");
		btnSchedule.setBorder(null);
		btnSchedule.setRadius(30);
		btnSchedule.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSchedule.setForeground(Color.white);
//		infApp.setColor(new Color(255, 255, 128));
		btnSchedule.setBounds(40, 275, 220, 43);
		btnSchedule.setColor(new Color(28, 181, 224));
		pnLeft.add(btnSchedule);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(28, 181, 224));
		panel.setForeground(new Color(255, 0, 0));
		panel.setBounds(27, 58, 245, 37);
		pnLeft.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Xin Chào: ");
		lblNewLabel_1.setBounds(23, 0, 81, 37);
		lblNewLabel_1.setForeground(Color.white );
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		JLabel userName = new JLabel();
		
		userName.setFont(new Font("Tahoma", Font.BOLD, 14));
		userName.setBounds(103, 0, 132, 37);
		userName.setText(user.getUseName());
		userName.setForeground(Color.white);
		panel.add(userName);
		
		
		
		pnRight.setBounds(300, 0, 1022, 775);
		pnRight.setBackground(new Color(232, 246, 239));
		contentPane.add(this.getPnRight());
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.X_AXIS));
		
		

		
		PnOrder initPanel = new PnOrder(user);
		OrderController orderController = new OrderController(initPanel, user);
		pnRight.add(initPanel);
		
		
	}
	
	public JPanel getPnLeft() {
		return pnLeft;
	}

	public void setPnLeft(JPanel pnLeft) {
		this.pnLeft = pnLeft;
	}
	
	public void addOrderActionListener(ActionListener action) {
		order.addActionListener(action);
	}
	
	public void addLogOutMouseListener(MouseListener action) {
		btnC.addMouseListener(action);
	}
	
	public void addBtnBillActionListener(ActionListener action)
	{
		btnBills.addActionListener(action);
	}
	
	public void addBtnScheduleActionListener(ActionListener action) {
		btnSchedule.addActionListener(action);
	}
	
}
