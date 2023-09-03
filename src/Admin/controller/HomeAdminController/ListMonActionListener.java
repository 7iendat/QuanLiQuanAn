package Admin.controller.HomeAdminController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Admin.view.HomeAdmin;
import Admin.view.PnListMon;

public class ListMonActionListener implements ActionListener{
	private HomeAdmin homeAdminView;
	public ListMonActionListener(HomeAdmin homeAdminView) {
		super();
		this.homeAdminView = homeAdminView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PnListMon pnListMon = new PnListMon(homeAdminView);
		homeAdminView.getPnRight().removeAll();
		homeAdminView.getPnRight().add(pnListMon);
		homeAdminView.getPnRight().validate();
		homeAdminView.getPnRight().repaint();
		
	}

}
