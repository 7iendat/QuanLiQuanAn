package controller.DashboardController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

import view.DashboardView;

public class TotalActionListener implements ActionListener{
	private DashboardView dashboardView;

	public TotalActionListener(DashboardView dashboardView) {
		super();
		this.dashboardView = dashboardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(dashboardView.getTotal() == 0.000) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn món nào cả!");
		}else {
			Locale locale = new Locale("vi", "VN");
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
			dashboardView.getTextArea().setText(dashboardView.getTextArea().getText() 
							+ "\n****************************************************************\n"
							+ "Thuế: \t\t\t" + numberFormat.format(dashboardView.getTax()) + "\n"
							+ "Tổng phụ: \t\t\t" + numberFormat.format(dashboardView.getTotal()) + "\n"
							+ "Tổng: \t\t\t" + numberFormat.format(dashboardView.getTotal() + dashboardView.getTax()) + "\n"
							+ "********************* Cảm ơn quý khách *********************\n"
							);
			dashboardView.getBtnTotal().setEnabled(false); //Khi đã nhấn vào thì sẽ không nhấn được nữa
		}
	}

}
