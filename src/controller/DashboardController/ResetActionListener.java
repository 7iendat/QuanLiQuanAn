package controller.DashboardController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DashboardView;

public class ResetActionListener implements ActionListener{
	private DashboardView dashboardView;

	public ResetActionListener(DashboardView dashboardView) {
		super();
		this.dashboardView = dashboardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dashboardView.reset();
		
	}

}
