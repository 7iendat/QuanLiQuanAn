package controller.ScheduleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.DashboardController.DashboardController;
import model.User;
import view.DashboardView;
import view.PnOrder;
import view.Schedule;

public class NextActionListener implements ActionListener{
	private Schedule scheduleView;
	private User user;
	

	public NextActionListener(Schedule scheduleView, User user) {
		super();
		this.scheduleView = scheduleView;
		this.user = user;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		int rowSelected = scheduleView.getTblKhach().getSelectedRow();
		if(rowSelected == -1) return;
		scheduleView.setStringTable((String) scheduleView.getTblKhach().getValueAt(rowSelected, 2));
		scheduleView.setCurrentKH((String)scheduleView.getTblKhach().getValueAt(rowSelected, 0));
		if(scheduleView.getStringTable() != "") {
//			DashboardViewz dashBoard = new DashboardViewz(orderView.getStringTable());
			DashboardView dashBoard = new DashboardView(scheduleView.getStringTable(),scheduleView.getCboTime().getSelectedItem().toString(),scheduleView.getCurrentKH(), user);
			DashboardController dashboardController = new DashboardController(dashBoard);
			dashBoard.setVisible(true);
		}	

		
	}

}
