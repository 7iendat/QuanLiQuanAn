package controller.DashboardController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JOptionPane;

import view.DashboardView;

public class ReceiptActionListener implements ActionListener{
	private DashboardView dashboardView;

	public ReceiptActionListener(DashboardView dashboardView) {
		super();
		this.dashboardView = dashboardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(dashboardView.getTotal() != 0.000) {
			if(!dashboardView.getBtnTotal().isEnabled()) {
				try {
					dashboardView.getTextArea().print(); //Phương thức in ra hóa đơn mua 
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Bạn cần phải tính tổng thành tiền trước!");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Bạn chưa mua món gì cả!");
		}
		
	}

}
