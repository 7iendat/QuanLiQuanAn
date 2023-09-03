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

public class MonDetail extends JPanel {
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

	public MonDetail(Mon monAn, JButton btnMua, JSpinner soLuong, JLabel giaBan, JLabel tenMon) {
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
	public MonDetail(Mon monAn) {
		this.monAn = monAn;
		setSize(new Dimension(191, 140));
		setPreferredSize(new Dimension(220, 180));
		setBackground(new Color(149,0,0));
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(16, 10, 200, 80);
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
		tenMon.setBounds(30, 104, 162, 22);
		add(tenMon);
		
		JLabel lblNewLabel_2 = new JLabel("Giá:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(21, 136, 64, 22);
		add(lblNewLabel_2);
		
		
		
		giaBan = new JLabel();
		giaBan.setText(monAn.getDonGia()+"");
		giaBan.setForeground(new Color(255, 255, 255));
		giaBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		giaBan.setBounds(94, 133, 64, 29);
		add(giaBan);
		
		
		
		JLabel donViTienTe = new JLabel("VND");
		donViTienTe.setForeground(new Color(255, 255, 255));
		donViTienTe.setFont(new Font("Tahoma", Font.BOLD, 14));
		donViTienTe.setBounds(157, 133, 64, 29);
		add(donViTienTe);
		
		

	}
	
	
}
