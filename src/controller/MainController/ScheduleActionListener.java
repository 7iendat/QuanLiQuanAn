package controller.MainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ScheduleController.ScheduleController;
import model.User;
import view.Main;
import view.Schedule;

public class ScheduleActionListener implements ActionListener{

	private Main mainView;
	private User user;
	
	public ScheduleActionListener(Main mainView, User user) {
		super();
		this.mainView = mainView;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Schedule pn = new Schedule(user);
		ScheduleController scheduleController = new ScheduleController(pn, user);
		mainView.getPnRight().removeAll();
		mainView.getPnRight().add(pn);
		mainView.getPnRight().validate();
		mainView.getPnRight().repaint();
	}

}
