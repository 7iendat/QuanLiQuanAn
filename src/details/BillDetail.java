package details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;

import dao.ChiTietHoaDon;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.LichDatDAO;
import model.HoaDon;
import model.KhachHang;
import model.LichDat;
import view.Schedule;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BillDetail extends JFrame {
	KhachHang kh;
	model.ChiTietHoaDon chiTietHoaDon;
	private JLabel TenKH;
	private JLabel SoDienThoai;
	private JLabel ban;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public BillDetail(KhachHang kh) {
		this.kh = kh;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 462, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ArrayList<model.ChiTietHoaDon> chiTietHoaDons = ChiTietHoaDon.getInstance().innerJoin();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(140, 0, 176, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_1.setBounds(73, 30, 321, 1);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Khách Hàng:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(22, 67, 115, 25);
		contentPane.add(lblNewLabel_2_1);
		
		TenKH = new JLabel();
		TenKH.setText(kh.getTenKH());
		TenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TenKH.setBounds(140, 67, 138, 25);
		contentPane.add(TenKH);
		
		JLabel lblNewLabel_2_2 = new JLabel("Số Điện Thoại:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(22, 90, 115, 25);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Bàn số:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3.setBounds(22, 113, 115, 25);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Món ăn:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_4.setBounds(22, 148, 115, 25);
		contentPane.add(lblNewLabel_2_4);
		
		SoDienThoai = new JLabel();
		SoDienThoai.setText(kh.getSoDienThoai());
		SoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SoDienThoai.setBounds(140, 90, 115, 25);
		contentPane.add(SoDienThoai);
		
		ban = new JLabel();
		ban.setText(kh.getBan());
		ban.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ban.setBounds(140, 113, 115, 25);
		contentPane.add(ban);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel_1_1.setBounds(73, 137, 321, 1);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Tổng tiền:");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2.setBounds(181, 538, 71, 25);
		contentPane.add(lblNewLabel_2_3_2);
		
		JLabel lblTongGIa = new JLabel();
		lblTongGIa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTongGIa.setBounds(254, 538, 62, 25);
		contentPane.add(lblTongGIa);
		
		JLabel lblNewLabel_2_3_2_2 = new JLabel("VND");
		lblNewLabel_2_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_3_2_2.setBounds(314, 538, 115, 25);
		contentPane.add(lblNewLabel_2_3_2_2);
		
		JButton btnNewButton = new JButton("Quay Lại");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(314, 573, 115, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_6 = new JLabel("Nhân viên:");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_6.setBounds(22, 43, 115, 25);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblTenNV = new JLabel("Nguyễn Văn B");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNV.setBounds(140, 43, 115, 25);
		contentPane.add(lblTenNV);
		
		JLabel lblNewLabel_2_3_2_3_1 = new JLabel("Thời Gian:");
		lblNewLabel_2_3_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_3_2_3_1.setBounds(203, 113, 71, 25);
		contentPane.add(lblNewLabel_2_3_2_3_1);
		
		JLabel lblTime = new JLabel();
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTime.setBounds(276, 113, 165, 25);
		contentPane.add(lblTime);
		
		JTextArea listMon = new JTextArea();
		
		listMon.setEditable(false);
//		listMon.setRows(10);
		listMon.setText("Số thứ tự\t   Tên Món		Số Lượng	Thành tiền\n");
		int row = 1;
		float sum = 0;
		Date ngayTao = null;
		int maHD = 0;
	    int maKH = 0;
	    String tinhTrang= "Đã Thanh Toán";
//		String textToInsert = "New Row";
		try {
		    int offset = listMon.getLineStartOffset(row);
//		    listMon.insert(textToInsert + "\n", offset);
		    int i = 0;
		    
			for(model.ChiTietHoaDon chitietmonan: chiTietHoaDons)
			{
				i++;
				chitietmonan.setTongThu(chitietmonan.getSoLuong() * chitietmonan.getGiaCa());
				String textToInsert = "  "+i+"\t"+chitietmonan.getTenMon()+"   \t     "+chitietmonan.getSoLuong()+"\t "+chitietmonan.getTongThu()+"";
//				System.out.println(chitietmonan.getTenMon());
				if(kh.getMaKH() == chitietmonan.getMaKH()) {
					listMon.insert(textToInsert + "\n", offset);
					sum = sum+chitietmonan.getTongThu();
					ngayTao = chitietmonan.getNgayTao();
					maHD = chitietmonan.getMaHD();
					maKH = chitietmonan.getMaKH();
				}
				
				
			}
			
		} catch (BadLocationException e) {
		    e.printStackTrace();
		}
		
		lblTongGIa.setText(sum + "");
		lblTime.setText(ngayTao + "");
		
		HoaDon hoadonUpDate = new HoaDon(maHD,sum, maKH, tinhTrang);
		
//		for()
		
		
//		int i = 0;
//		for(model.ChiTietHoaDon chitietmonan: chiTietHoaDons)
//		{
//			System.out.println(chitietmonan.getTenMon());
//			i++;
//			if(kh.getMaKH() == chitietmonan.getMaKH()) {
//				listMon.setText(""+i+"\t "+chitietmonan.getTenMon()+"\t "+chitietmonan.getSoLuong()+"\t "+chitietmonan.getTongThu()+"");
//			}
//		}
		listMon.setBounds(22, 183, 407, 324);
		contentPane.add(listMon);
		
		JButton btnThanhTon = new JButton("Thanh Toán");
		btnThanhTon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HoaDonDAO.getInstance().update(hoadonUpDate);
				JOptionPane.showMessageDialog(null, "ĐÃ THANH TOÁN THÀNH CÔNG!!!");
			}});
		btnThanhTon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThanhTon.setBounds(22, 577, 132, 25);
		contentPane.add(btnThanhTon);
	}
}
