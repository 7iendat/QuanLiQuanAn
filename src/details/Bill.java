package details;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.ChiTietHoaDon;
import dao.HoaDonDAO;
import database.JDBCUtil;
import model.KhachHang;
import view.Schedule;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Bill extends JPanel {
	KhachHang kh;
	model.ChiTietHoaDon chiTietHoaDon;
	
	private  JLabel lblName ;
	private JLabel lblSDT;
	private JLabel lblBan; 
	private	JLabel lblTong;
	
	/**
	 * Create the panel.
	 */
	
//	public Bill(model.ChiTietHoaDon chiTietHoaDon) {
//		this.chiTietHoaDon = chiTietHoaDon;
//		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
//		setLayout(null);
//		setVisible(true);
//		
//		JLabel lblNewLabel = new JLabel("Tên Khách Hàng:");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblNewLabel.setBounds(10, 33, 118, 29);
//		add(lblNewLabel);
//		
//		lblName = new JLabel();
//		lblName.setText(kh.getTenKH());
//		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblName.setBounds(115, 37, 118, 21);
//		add(lblName);
//		
//		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
//		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblSinThoi.setBounds(10, 61, 85, 29);
//		add(lblSinThoi);
//		
//		JLabel lblBnS = new JLabel("Bàn số:");
//		lblBnS.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblBnS.setBounds(10, 89, 58, 29);
//		add(lblBnS);
//		
//		 lblSDT = new JLabel();
//		 lblSDT.setText(kh.getSoDienThoai());
//		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblSDT.setBounds(95, 61, 118, 29);
//		add(lblSDT);
//		
//		lblBan = new JLabel();
//		lblBan.setText(kh.getBan());
//		lblBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblBan.setBounds(70, 89, 58, 29);
//		add(lblBan);
//		
//		JLabel lblTngTin = new JLabel("Tổng tiền:");
//		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblTngTin.setBounds(10, 116, 58, 29);
//		add(lblTngTin);
//		
//		lblTong = new JLabel();
//		lblTong.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblTong.setBounds(78, 116, 69, 29);
//		add(lblTong);
//		
//		JLabel lblVnd = new JLabel("VND");
//		lblVnd.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblVnd.setBounds(130, 116, 58, 29);
//		add(lblVnd);
//		
//		JButton btnNewButton = new JButton("Chi tiết");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				BillDetail billDetail = new BillDetail(chiTietHoaDon);
//				billDetail.setVisible(true);
//			}
//		});
//		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnNewButton.setBounds(10, 165, 102, 29);
//		add(btnNewButton);
//		
//		JButton btnXa = new JButton("Thanh Toán");
//		btnXa.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnXa.setBounds(122, 165, 111, 29);
//		add(btnXa);
//		
//		JLabel lblHan = new JLabel("Hóa Đơn");
//		lblHan.setHorizontalAlignment(SwingConstants.CENTER);
//		lblHan.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblHan.setBounds(58, 0, 118, 29);
//		add(lblHan);
//
//	}
	
	public Bill(KhachHang kh) {
		this.kh = kh;
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Tên Khách Hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 33, 118, 29);
		add(lblNewLabel);
		
		lblName = new JLabel();
		lblName.setText(kh.getTenKH());
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(115, 37, 118, 21);
		add(lblName);
		
		JLabel lblSinThoi = new JLabel("Số Điện Thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSinThoi.setBounds(10, 61, 85, 29);
		add(lblSinThoi);
		
		JLabel lblBnS = new JLabel("Bàn số:");
		lblBnS.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBnS.setBounds(10, 89, 58, 29);
		add(lblBnS);
		
		 lblSDT = new JLabel();
		 lblSDT.setText(kh.getSoDienThoai());
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSDT.setBounds(95, 61, 118, 29);
		add(lblSDT);
		
		lblBan = new JLabel();
		lblBan.setText(kh.getBan());
		lblBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBan.setBounds(70, 89, 58, 29);
		add(lblBan);
		
//		JLabel lblTngTin = new JLabel("Tổng tiền:");
//		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblTngTin.setBounds(10, 116, 58, 29);
//		add(lblTngTin);
//		
//		lblTong = new JLabel();
//		lblTong.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		lblTong.setBounds(78, 116, 69, 29);
//		add(lblTong);
//		
//		JLabel lblVnd = new JLabel("VND");
//		lblVnd.setFont(new Font("Tahoma", Font.BOLD, 12));
//		lblVnd.setBounds(130, 116, 58, 29);
//		add(lblVnd);
		
		JButton btnNewButton = new JButton("Xem Chi Tiết Và Thanh Toán");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillDetail billDetail = new BillDetail(kh);
				billDetail.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 166, 215, 29);
		add(btnNewButton);
		
		JLabel lblHan = new JLabel("Hóa Đơn");
		lblHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblHan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHan.setBounds(58, 0, 118, 29);
		add(lblHan);
		
		JLabel lblTnhTrng = new JLabel("Tình Trạng:");
		lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTnhTrng.setBounds(10, 128, 74, 29);
		add(lblTnhTrng);
		String trangThai = "";
		
		ArrayList<model.ChiTietHoaDon> chiTietHoaDons = ChiTietHoaDon.getInstance().innerJoin();
		for(model.ChiTietHoaDon chitiet: chiTietHoaDons) {
			if(kh.getMaKH() == chitiet.getMaKH()) {
				trangThai = HoaDonDAO.getInstance().selectById(chitiet.getMaHD()).getTinhTrang();
			}
		}
		
		JLabel lblChaThanhTon = new JLabel();
		lblChaThanhTon.setText(trangThai);
		lblChaThanhTon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChaThanhTon.setBounds(95, 128, 138, 29);
		add(lblChaThanhTon);

	}
}
