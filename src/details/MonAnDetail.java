package details;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import model.Mon;

public class MonAnDetail extends JPanel {
	private Mon monAn;

	public Mon getMonAn() {
		return monAn;
	}

	public void setMonAn(Mon monAn) {
		this.monAn = monAn;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnMua;
	private JSpinner soLuong;
	public JButton getBtnMua() {
		return btnMua;
	}

	public MonAnDetail(Mon monAn, JButton btnMua, JSpinner soLuong, JLabel giaBan, JLabel tenMon) {
		super();
		this.monAn = monAn;
		this.btnMua = btnMua;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.tenMon = tenMon;
	}

	

	public void setBtnMua(JButton btnMua) {
		this.btnMua = btnMua;
	}

	public JSpinner getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(JSpinner soLuong) {
		this.soLuong = soLuong;
	}

	public JLabel getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(JLabel giaBan) {
		this.giaBan = giaBan;
	}

	public JLabel getTenMon() {
		return tenMon;
	}

	public void setTenMon(JLabel tenMon) {
		this.tenMon = tenMon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private JLabel giaBan;
	private JLabel tenMon;

	/**
	 * Create the panel.
	 */
	public MonAnDetail(Mon monAn) {
		this.monAn = monAn;
		setSize(new Dimension(191, 192));
		setPreferredSize(new Dimension(220, 224));
		setBackground(new Color(149,0,0));
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(16, 10, 200, 64);
		String source = monAn.getAnhMinhHoa();
		ImageIcon icon = new ImageIcon(getClass().getResource(source));
		Image img = icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		
		lblNewLabel.setIcon(new ImageIcon(img));

		add(lblNewLabel);
		
		tenMon = new JLabel();
		tenMon.setText(monAn.getTenMon());
		tenMon.setForeground(new Color(255, 255, 255));
		tenMon.setBackground(new Color(149,0,0));
		tenMon.setHorizontalTextPosition(SwingConstants.CENTER);
		tenMon.setHorizontalAlignment(SwingConstants.CENTER);
		tenMon.setFont(new Font("Tahoma", Font.BOLD, 14));
		tenMon.setOpaque(true);
		tenMon.setBounds(30, 84, 162, 22);
		add(tenMon);
		
		JLabel lblNewLabel_2 = new JLabel("Giá:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(21, 116, 64, 22);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số Lượng");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(21, 141, 64, 22);
		add(lblNewLabel_2_1);
		
		giaBan = new JLabel();
		giaBan.setText(monAn.getDonGia()+"");
		giaBan.setForeground(new Color(255, 255, 255));
		giaBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		giaBan.setBounds(94, 113, 64, 29);
		add(giaBan);
		
		soLuong = new JSpinner();
		soLuong.setBounds(94, 143, 64, 22);
		soLuong.setForeground(new Color(0, 0, 0));
		soLuong.setBackground(new Color(149, 0, 0));
		soLuong.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		soLuong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(soLuong);
		
		JLabel donViTienTe = new JLabel("VND");
		donViTienTe.setForeground(new Color(255, 255, 255));
		donViTienTe.setFont(new Font("Tahoma", Font.BOLD, 14));
		donViTienTe.setBounds(157, 113, 64, 29);
		add(donViTienTe);
		
		btnMua = new JButton("Mua");
		btnMua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMua.setBounds(73, 181, 85, 22);
		add(btnMua);

	}
	
	public void addMuaActionListener(ActionListener action) {
		btnMua.addActionListener(action);
	}
}
