package Admin.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import details.MyButton;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class HomeAdmin extends JFrame {

	User user ; 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  JPanel pnRight = new JPanel();
	private JPanel pnLeft = new JPanel();
	private MyButton nhanVien;
	private MyButton doanhThu;
	private MyButton listMon;
	private MyButton inforApp;
	private MyButton signup;
	
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
	
	public HomeAdmin(User user) {
		
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1300, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		pnLeft.setBackground(new Color(21, 51, 238));
		pnLeft.setForeground(new Color(0, 0, 0));
		pnLeft.setBounds(0, 0, 265, 775);
		contentPane.add(this.getPnLeft());
		pnLeft.setLayout(null);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setForeground(Color.white );
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(0, 5, 265, 37);
		pnLeft.add(lblName);
		
		
		
		
		nhanVien = new MyButton();
		nhanVien.setText("Nhân Viên");
		nhanVien.setFocusPainted(false);
		nhanVien.setBorder(null);
		nhanVien.setBounds(23, 163, 220, 43);
		nhanVien.setRadius(30);
		nhanVien.setForeground(Color.white);
//		btnSchedule.setForeground(new Color(0, 0, 0));
		nhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
//		btnSchedule.setColor(new Color(255, 255, 128));
		nhanVien.setColor(new Color(28, 181, 224));
		pnLeft.add(nhanVien);
		
		doanhThu = new MyButton();
		doanhThu.setText("Doanh Thu");
		doanhThu.setBorder(null);
		doanhThu.setBounds(23, 275, 220, 43);
		doanhThu.setRadius(30);
		doanhThu.setForeground(Color.white);
		doanhThu.setFont(new Font("Tahoma", Font.BOLD, 16));
//		btnC.setColor(new Color(255, 255, 128));
		doanhThu.setColor(new Color(28, 181, 224));
		
		pnLeft.add(doanhThu);
		
		
		listMon = new MyButton();
		
		listMon.setText("Danh Sách Món");
		listMon.setBorder(null);
		listMon.setRadius(30);
		listMon.setFont(new Font("Tahoma", Font.BOLD, 16));
		listMon.setForeground(Color.white);
//		infApp.setColor(new Color(255, 255, 128));
		listMon.setBounds(23, 387, 220, 43);
		listMon.setColor(new Color(28, 181, 224));
		pnLeft.add(listMon);
		
		inforApp = new MyButton();
		inforApp.setText("Thông Tin App");
		inforApp.setBorder(null);
		inforApp.setRadius(30);
		inforApp.setFont(new Font("Tahoma", Font.BOLD, 16));
		inforApp.setForeground(Color.white);
//		infApp.setColor(new Color(255, 255, 128));
		inforApp.setBounds(23, 500, 220, 43);
		inforApp.setColor(new Color(28, 181, 224));
		pnLeft.add(inforApp);
		
		signup = new MyButton();
		signup.setText("SIGN UP");
		signup.setBorder(null);
		signup.setRadius(30);
		signup.setFont(new Font("Tahoma", Font.BOLD, 16));
		signup.setForeground(Color.white);
//		infApp.setColor(new Color(255, 255, 128));
		signup.setBounds(23, 623, 220, 43);
		signup.setColor(new Color(28, 181, 224));
		pnLeft.add(signup);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(28, 181, 224));
		panel.setForeground(new Color(255, 0, 0));
		panel.setBounds(10, 58, 245, 37);
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
		
		
		
		pnRight.setBounds(264, 0, 1022, 775);
		pnRight.setBackground(new Color(126, 177, 236));
		contentPane.add(this.getPnRight());
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.X_AXIS));
		
		

		
		NhanVien initPanel = new NhanVien(this, user);
//		OrderController orderController = new OrderController(initPanel, user);
		pnRight.add(initPanel);
		
		
	}
	
	public JPanel getPnLeft() {
		return pnLeft;
	}

	public void setPnLeft(JPanel pnLeft) {
		this.pnLeft = pnLeft;
	}
	
	public void addBtnNhanVienActionListener(ActionListener action) {
		nhanVien.addActionListener(action);
	}
	
	public void addBtnDoanhThuActionListener(ActionListener action) {
		doanhThu.addActionListener(action);
	}
	
	public void addBtnListMonActionListener(ActionListener action) {
		listMon.addActionListener(action);
	}
	
	public void addBtnInforAppActionListener(ActionListener action) {
		inforApp.addActionListener(action);
	}
	
	public void addBtnSignUPActionListener(ActionListener action) {
		signup.addActionListener(action);
	}
	
	
	

	
}
