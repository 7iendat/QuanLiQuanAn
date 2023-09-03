package details;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class VoucherDetail extends JPanel {

	/**
	 * Create the panel.
	 */
	public VoucherDetail() {
		setLayout(null);
		
		setSize(new Dimension(293, 130));
		setPreferredSize(new Dimension(293, 130));
		
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 293, 130);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/image_voucher.jpg"));
		Image img = icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);	
		
		
		lblNewLabel.setIcon(new ImageIcon(img));
		add(lblNewLabel);
		
		
		


	}
}
