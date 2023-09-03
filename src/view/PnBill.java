package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import controller.DashboardController.DashboardController;
import dao.KhachHangDAO;
import dao.MonDAO;
import database.JDBCUtil;
import details.Bill;
import details.MonAnDetail;
import model.KhachHang;
import model.Mon;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

public class PnBill extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnBill() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 992, 755);
		panel.setLayout(new GridLayout(0,4,10,10));
		
		ArrayList<KhachHang> khachHangs = KhachHangDAO.getInstance().selectAll();
		
		
		
//		JPanel panel = new JPanel(new GridLayout(7,0,10,10));;
//		panel.setBackground(new Color(79, 79, 79));
//		panel.setBorder(new LineBorder(new Color(230, 230, 230), 2));
//		panel.setBounds(0, 0, 1022, 775);
		
		JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		
//		for(int i = 0;i < 10; i++) {
//			Bill bill = new Bill();
//			panel.add(bill);
//		}
		
		for(KhachHang kh: khachHangs)
		{
			Bill bill = new Bill(kh);
			panel.add(bill);
		}
		
		scrollPane.setBounds(10, 10, 970, 683);
		add(scrollPane);
//
////		ArrayList<Mon> listMon = MonDAO.getInstance().selectAll();
//		
//		for(int i = 0; i < 10; i++) {
////			MonAnDetail monAn = new MonAnDetail(mon);
////			DashboardController monAnController = new DashboardController(monAn, this);
//			Bill bill = new Bill();
//			add(bill);
//		}
//		
//		scrollPane.setBounds(0,0, 1017, 683);
//		add(scrollPane);

	}
}
