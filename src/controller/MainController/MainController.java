package controller.MainController;

import model.User;
import view.Main;

public class MainController {
	private Main mainView;
	private User user;

	public MainController(Main mainView, User user) {
		super();
		this.mainView = mainView;
		this.user = user;
		this.mainView.addOrderActionListener(new OrderActionListener(mainView, user));
		this.mainView.addLogOutMouseListener(new LogOutMouseListener(mainView));
		this.mainView.addBtnBillActionListener(new BillActionListener(mainView));
		this.mainView.addBtnScheduleActionListener(new ScheduleActionListener(mainView, user));
	}
	
}
