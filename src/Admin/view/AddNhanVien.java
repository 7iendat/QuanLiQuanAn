package Admin.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.controller.HomeAdminController.HomeAdminController;
import dao.NhanVienDAO;
import model.NhanVien;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AddNhanVien extends JFrame {
	private User user;
	private HomeAdmin homeAdminView;

	private JPanel contentPane;
	private JTextField tfTenNhanVien;
	private JTextField tfSDt;
	private JTextField tfEmail;
	private ButtonGroup buttonGroup_GioiTinh;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddNhanVien frame = new AddNhanVien();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddNhanVien(User user, HomeAdmin homeAdminView) {
		this.user =user;
		this.homeAdminView = homeAdminView;
		setBounds(100, 100, 645, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập Thông Tin  Nhân Viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(67, 10, 485, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Nhân Viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(85, 60, 103, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giới Tính:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(85, 100, 103, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(85, 140, 103, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(85, 180, 103, 30);
		contentPane.add(lblNewLabel_1_3);
		
		tfTenNhanVien = new JTextField();
		tfTenNhanVien.setBounds(202, 63, 350, 30);
		contentPane.add(tfTenNhanVien);
		tfTenNhanVien.setColumns(10);
		
		tfSDt = new JTextField();
		tfSDt.setColumns(10);
		tfSDt.setBounds(202, 140, 350, 30);
		contentPane.add(tfSDt);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(202, 183, 350, 30);
		contentPane.add(tfEmail);
		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
//		rdbtnNewRadioButton.setBounds(118, 107, 103, 21);
//		contentPane.add(rdbtnNewRadioButton);
//		
//		JRadioButton rdbtnN = new JRadioButton("Nữ");
//		rdbtnN.setBounds(247, 107, 103, 21);
//		contentPane.add(rdbtnN);
		
		JRadioButton rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setActionCommand("Nam");
		rdbtnMale.setOpaque(false);
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnMale.setBounds(202, 105, 103, 21);
		
		JRadioButton rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setActionCommand("Nữ");
		rdbtnFemale.setOpaque(false);
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnFemale.setBounds(330, 105, 103, 21);
		
		buttonGroup_GioiTinh = new ButtonGroup(); //Nhóm các radio button lại để chỉ có thể chọn 1 lựa chọn
		buttonGroup_GioiTinh.add(rdbtnMale);
		buttonGroup_GioiTinh.add(rdbtnFemale);
		contentPane.add(rdbtnMale);
		contentPane.add(rdbtnFemale);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<NhanVien> dsNhanVien = NhanVienDAO.getInstance().selectAll();
				String ten = tfTenNhanVien.getText();
				String gioiTinh = buttonGroup_GioiTinh.getSelection().getActionCommand();
				String sdt = tfSDt.getText();
				String email = tfEmail.getText();
//				int check =0;
				
				String conditionSDT = "SoDienThoai= "+sdt+"";
				String conditionEmail = "email= '"+email+"'";
//				System.out.println(condition);
				ArrayList<NhanVien> nhanVienWithCondition = NhanVienDAO.getInstance().selectByCondition(conditionSDT);
				ArrayList<NhanVien> nhanVienWithCondition1 = NhanVienDAO.getInstance().selectByCondition(conditionEmail);
				if(nhanVienWithCondition.isEmpty() && nhanVienWithCondition1.isEmpty())
				{
					NhanVien newNhanVien = new NhanVien(ten, gioiTinh, sdt, email);
					NhanVienDAO.getInstance().insert(newNhanVien);
					
					Admin.view.NhanVien pnNhanVien = new Admin.view.NhanVien(homeAdminView, user);
					homeAdminView.getPnRight().removeAll();
					homeAdminView.getPnRight().add(pnNhanVien);
					homeAdminView.getPnRight().validate();
					homeAdminView.getPnRight().repaint();
					JOptionPane.showMessageDialog(null, "Thêm Nhân Viên Thành Công!!!");
					dispose();
//					HomeAdmin homeAdmin = new HomeAdmin(user);
//					HomeAdminController homeAdminController = new HomeAdminController(homeAdmin);
//					homeAdmin.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Nhân Viên Đã Tồn Tại!!!");
					dispose();
				}
				
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(64, 230, 134, 33);
		contentPane.add(btnAdd);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				HomeAdmin homeAdmin = new HomeAdmin(user);
//				HomeAdminController homeAdminController = new HomeAdminController(homeAdmin);
//				homeAdmin.setVisible(true);
				dispose();
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuy.setBounds(431, 230, 134, 33);
		contentPane.add(btnHuy);
	}
}
