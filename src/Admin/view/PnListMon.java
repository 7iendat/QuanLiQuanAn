package Admin.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.DashboardController.DashboardController;
import dao.MonDAO;
import details.MonAnDetail;
import details.MonDetail;
import details.MyButton;
import model.Mon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PnListMon extends JPanel {
	private HomeAdmin homeAdminView;
	private MyButton btnXoa;
	private MyButton btnThemMon;
	private MyButton btnCapNhat;
	/**
	 * Create the panel.
	 */
	public PnListMon(HomeAdmin homeAdminView) {
		this.homeAdminView =homeAdminView;
		setLayout(null);
		setBackground(new Color(126, 177, 236));
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH MÓN ĂN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(234, 10, 582, 42);
		add(lblNewLabel);
		
		JPanel pnListMOn = new JPanel(new GridLayout(4,0,10,10));
		pnListMOn.setBackground(new Color(79, 79, 79));
		pnListMOn.setBorder(new LineBorder(new Color(230, 230, 230), 2));
		pnListMOn.setBounds(10, 80, 1002, 574);
		
		
//		JPanel panel_2 = new JPanel(new GridLayout(4,0,10,10));;
//		panel_2.setBackground(new Color(79, 79, 79));
//		panel_2.setBorder(new LineBorder(new Color(230, 230, 230), 2));
//		panel_2.setBounds(10, 57, 1017, 683);

		
		JScrollPane scrollPane = new JScrollPane(pnListMOn, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

		ArrayList<Mon> listMon = MonDAO.getInstance().selectAll();
		
		for(Mon mon: listMon) {
			MonDetail monAn = new MonDetail(mon);
			
			pnListMOn.add(monAn);
		}
		
		scrollPane.setBounds(10, 80, 1002, 574);
		add(scrollPane);
		
		btnThemMon = new MyButton();
		btnThemMon.setText("Thêm Món");
		
		btnThemMon.setForeground(Color.white);
		btnThemMon.setRadius(30);
		btnThemMon.setBorder(null);
		btnThemMon.setColor(new Color(21, 51, 238));
		btnThemMon.setBorderColor(new Color(128,149,255));
		btnThemMon.setColorClick(new Color(77,77,255));
		btnThemMon.setColorOver(new Color(153,170,255));
		btnThemMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThemMon themMon = new ThemMon(homeAdminView);
				themMon.setVisible(true);
			}
		});
		btnThemMon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemMon.setBounds(48, 692, 147, 40);
		add(btnThemMon);
		
		btnCapNhat = new MyButton();
		btnCapNhat.setText("Cập Nhật");
		btnCapNhat.setForeground(Color.white);
		btnCapNhat.setRadius(30);
		btnCapNhat.setBorder(null);
		btnCapNhat.setColor(new Color(21, 51, 238));
		btnCapNhat.setBorderColor(new Color(128,149,255));
		btnCapNhat.setColorClick(new Color(77,77,255));
		btnCapNhat.setColorOver(new Color(153,170,255));
		btnCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CapNhatMon capNhatMon = new CapNhatMon(homeAdminView);
				capNhatMon.setVisible(true);
				
			}
		});
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCapNhat.setBounds(446, 692, 147, 40);
		add(btnCapNhat);
		
		btnXoa = new MyButton();
		btnXoa.setText("Xóa Món");
		btnXoa.setForeground(Color.white);
		btnXoa.setRadius(30);
		btnXoa.setBorder(null);
		btnXoa.setColor(new Color(21, 51, 238));
		btnXoa.setBorderColor(new Color(128,149,255));
		btnXoa.setColorClick(new Color(77,77,255));
		btnXoa.setColorOver(new Color(153,170,255));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XoaMon xoaMon = new XoaMon(homeAdminView);
				xoaMon.setVisible(true);
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBounds(838, 692, 147, 40);
		add(btnXoa);

	}
}
