package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.KhachHangDAO;
import dao.LichDatDAO;
import database.JDBCUtil;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL; //Set icon
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.CustomerInfosModel;
import model.KhachHang;
import model.LichDat;
import model.NhanVien;
import model.User;

import java.awt.Color;


public class CustomerInfosView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	NhanVien nhanVien;
	User user;
	String time;
	String tenKhach;
	String table;
	private JTextField textField_Name;
	private JTextField textField_SDT;
	private JTextField textField_Address;
	private ButtonGroup buttonGroup_GioiTinh;
	private JLabel lblBackgroundImage;
	
	
	public CustomerInfosView (User user, String table) {
		
		this.user = user;
		this.table = table;
		setResizable(false);
		this.setTitle("Thông tin khách hàng");
		this.setSize(535, 285);
		this.setLocationRelativeTo(null); //Cho nó xuất hiện giữa màn hình
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 521, 248);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thông tin khách hàng");
		lblTitle.setBackground(new Color(255, 255, 255));
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(147, 23, 223, 29);
		panel.add(lblTitle);
		
		JLabel lblName = new JLabel("Tên:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(42, 76, 39, 13);
		panel.add(lblName);
		
		JLabel lblAge = new JLabel("Số Điện Thoại:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(42, 100, 39, 21);
		panel.add(lblAge);
		
		JLabel lblGender = new JLabel("Giới tính:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(42, 130, 71, 15);
		panel.add(lblGender);
		
		JLabel lblAddress = new JLabel("Địa chỉ:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(42, 153, 62, 21);
		panel.add(lblAddress);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(120, 74, 282, 19);
		panel.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_SDT = new JTextField();
		textField_SDT.setBounds(120, 101, 282, 19);
		panel.add(textField_SDT);
		textField_SDT.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setActionCommand("Nam");
		rdbtnMale.setOpaque(false);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBounds(170, 127, 76, 21);
		
		JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setActionCommand("Nữ");
		rdbtnFemale.setOpaque(false);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(299, 127, 103, 21);
		
		buttonGroup_GioiTinh = new ButtonGroup(); //Nhóm các radio button lại để chỉ có thể chọn 1 lựa chọn
		buttonGroup_GioiTinh.add(rdbtnMale);
		buttonGroup_GioiTinh.add(rdbtnFemale);
		
		panel.add(rdbtnMale);
		panel.add(rdbtnFemale);
		
		textField_Address = new JTextField();
		textField_Address.setBounds(120, 153, 282, 19);
		panel.add(textField_Address);
		textField_Address.setColumns(10);
		
		
//		customerInf.setTextField_Name(new JTextField());
//		customerInf.setTextField_Age(new JTextField());
//		customerInf.setTextField_Address(new JTextField());
		
		JButton btnSubmit = new JButton("Xác nhận");
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSubmit.setBounds(207, 195, 103, 29);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = textField_Name.getText();
				String soDienThoai = textField_SDT.getText();
				String diaChi = textField_Address.getText();
				
				int ID_nhanvien = user.getId();
				
				String gioiTinh = buttonGroup_GioiTinh.getSelection().getActionCommand();
//				customerInf.getTextField_Name().setText(ten);
//				customerInf.getTextField_Age().setText(tuoi);
//				customerInf.getTextField_Address().setText(diaChi);
//				System.out.println(gioiTinh);
				
				KhachHang khachHang = new KhachHang(ten, gioiTinh, diaChi, table, soDienThoai,ID_nhanvien);
				


				if(ten.isBlank() || soDienThoai.isBlank() || diaChi.isBlank() || buttonGroup_GioiTinh.isSelected(null)) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			        JOptionPane.showMessageDialog(frame,
			                "Hãy nhập đầy đủ thông tin vào!",
			                "Thông tin thiếu",
			                JOptionPane.INFORMATION_MESSAGE);
			        
				}
				else {
					KhachHangDAO.getInstance().insert(khachHang);
					
					
					setVisible(false);
					
				}
				
				
			}
			
		});
		
		panel.add(btnSubmit);
		
		lblBackgroundImage = new JLabel("");
		lblBackgroundImage.setBackground(new Color(0, 0, 0));
		lblBackgroundImage.setBounds(0, 0, 521, 248);
		panel.add(lblBackgroundImage);
		
		setImage();
	}
	
	


	

	public CustomerInfosView (User user,String time,String tenKhach, String table) {
		
		this.user = user;
		this.time = time;
		this.tenKhach = tenKhach;
		this.table = table;
		setResizable(false);
		this.setTitle("Thông tin khách hàng");
		this.setSize(535, 285);
		this.setLocationRelativeTo(null); //Cho nó xuất hiện giữa màn hình
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 521, 248);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Thông tin khách hàng");
		lblTitle.setBackground(new Color(255, 255, 255));
		lblTitle.setForeground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(147, 23, 223, 29);
		panel.add(lblTitle);
		
		JLabel lblName = new JLabel("Tên:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(42, 76, 39, 13);
		panel.add(lblName);
		
		JLabel lblAge = new JLabel("Số Điện Thoại:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(42, 100, 39, 21);
		panel.add(lblAge);
		
		JLabel lblGender = new JLabel("Giới tính:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(42, 130, 71, 15);
		panel.add(lblGender);
		
		JLabel lblAddress = new JLabel("Địa chỉ:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(42, 153, 62, 21);
		panel.add(lblAddress);
		
		textField_Name = new JTextField();
		textField_Name.setText(tenKhach);
		textField_Name.setBounds(120, 74, 282, 19);
		panel.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_SDT = new JTextField();
		textField_SDT.setBounds(120, 101, 282, 19);
		panel.add(textField_SDT);
		textField_SDT.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setActionCommand("Nam");
		rdbtnMale.setOpaque(false);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBounds(170, 127, 76, 21);
		
		JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setActionCommand("Nữ");
		rdbtnFemale.setOpaque(false);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(299, 127, 103, 21);
		
		buttonGroup_GioiTinh = new ButtonGroup(); //Nhóm các radio button lại để chỉ có thể chọn 1 lựa chọn
		buttonGroup_GioiTinh.add(rdbtnMale);
		buttonGroup_GioiTinh.add(rdbtnFemale);
		
		panel.add(rdbtnMale);
		panel.add(rdbtnFemale);
		
		textField_Address = new JTextField();
		textField_Address.setBounds(120, 153, 282, 19);
		panel.add(textField_Address);
		textField_Address.setColumns(10);
		
		
//		customerInf.setTextField_Name(new JTextField());
//		customerInf.setTextField_Age(new JTextField());
//		customerInf.setTextField_Address(new JTextField());
		
		JButton btnSubmit = new JButton("Xác nhận");
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSubmit.setBounds(207, 195, 103, 29);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = textField_Name.getText();
				String soDienThoai = textField_SDT.getText();
				String diaChi = textField_Address.getText();
				
				int ID_nhanvien = user.getId();
				
				String gioiTinh = buttonGroup_GioiTinh.getSelection().getActionCommand();
//				customerInf.getTextField_Name().setText(ten);
//				customerInf.getTextField_Age().setText(tuoi);
//				customerInf.getTextField_Address().setText(diaChi);
//				System.out.println(gioiTinh);
				
				KhachHang khachHang = new KhachHang(ten, gioiTinh, diaChi, table, soDienThoai,ID_nhanvien);
				


				if(ten.isBlank() || soDienThoai.isBlank() || diaChi.isBlank() || buttonGroup_GioiTinh.isSelected(null)) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog example");
			        JOptionPane.showMessageDialog(frame,
			                "Hãy nhập đầy đủ thông tin vào!",
			                "Thông tin thiếu",
			                JOptionPane.INFORMATION_MESSAGE);
			        
				}
				else {
					KhachHangDAO.getInstance().insert(khachHang);
					
					
					setVisible(false);
					
				}
				ArrayList<KhachHang> khachHangs = KhachHangDAO.getInstance().selectByCondition("TenKH= '"+ten+"'");
				
				for(KhachHang kh: khachHangs)
				{
//					System.out.println(kh.getBan().equals(table));
//					System.out.println(kh.);
					if(kh.getBan().equals(table)) {
						System.out.println("ok");
						int MaKH = kh.getMaKH();
						String gioDat = time;
						LichDat lichDat = new LichDat(MaKH, gioDat);
						LichDatDAO.getInstance().insert(lichDat);
					}
					else 
						System.out.println("ko");
					
				}
				
				
			}
			
		});
		
		panel.add(btnSubmit);
		
		lblBackgroundImage = new JLabel("");
		lblBackgroundImage.setBackground(new Color(0, 0, 0));
		lblBackgroundImage.setBounds(0, 0, 521, 248);
		panel.add(lblBackgroundImage);
		
		setImage();
	}
	
	public void setImage() {
		//Set icon
		URL urlIconVoucher = CustomerInfosView.class.getResource("/images/icon_voucher.png");
		Image img_icon = Toolkit.getDefaultToolkit().createImage(urlIconVoucher);
		this.setIconImage(img_icon);
		
		//Set background
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/background_voucher.png"));
		Image img = icon.getImage().getScaledInstance(lblBackgroundImage.getWidth(), lblBackgroundImage.getHeight(), Image.SCALE_SMOOTH);	
		lblBackgroundImage.setIcon(new ImageIcon(img));	
	}

}