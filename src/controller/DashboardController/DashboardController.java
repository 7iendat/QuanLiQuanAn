package controller.DashboardController;

import details.MonAnDetail;
import view.DashboardView;

public class DashboardController {
	private DashboardView dashBoardView ;
	private MonAnDetail monan;

	public DashboardController(MonAnDetail monan,DashboardView dashBoardView) {
		super();
		this.monan = monan;
		this.dashBoardView = dashBoardView;
		this.monan.addMuaActionListener(new MuaActionListener(monan, dashBoardView));
	}
	
	public DashboardController(DashboardView dashBoardView) {
		super();
		this.dashBoardView = dashBoardView;
		this.dashBoardView.addExitActionListener(new ExitActionListener(dashBoardView));
		this.dashBoardView.addTotalActionListener(new TotalActionListener(dashBoardView));
		this.dashBoardView.addReceiptActionListener(new ReceiptActionListener(dashBoardView));
		this.dashBoardView.addResetActionListener(new ResetActionListener(dashBoardView));
	}
}
