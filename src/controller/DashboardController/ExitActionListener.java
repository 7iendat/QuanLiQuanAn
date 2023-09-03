package controller.DashboardController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.KhachHangDAO;
import dao.LichDatDAO;
import model.KhachHang;
import model.LichDat;
import view.DashboardView;

public class ExitActionListener implements ActionListener{
	private DashboardView dashBoardView;

	public ExitActionListener(DashboardView dashBoardView) {
		super();
		this.dashBoardView = dashBoardView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dashBoardView.setVisible(false);
		
		
	}

}
