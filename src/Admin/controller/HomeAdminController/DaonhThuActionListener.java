package Admin.controller.HomeAdminController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Admin.view.DoanhThu;
import Admin.view.HomeAdmin;
import Admin.view.PnListMon;

public class DaonhThuActionListener implements ActionListener{

	private HomeAdmin adminHomeView;
	
	public DaonhThuActionListener(HomeAdmin adminHomeView) {
		super();
		this.adminHomeView = adminHomeView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DoanhThu pndoanhThu = new DoanhThu(adminHomeView);
		adminHomeView.getPnRight().removeAll();
		adminHomeView.getPnRight().add(pndoanhThu);
		adminHomeView.getPnRight().validate();
		adminHomeView.getPnRight().repaint();
	}

}
