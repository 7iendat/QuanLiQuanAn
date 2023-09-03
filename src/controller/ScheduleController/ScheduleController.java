package controller.ScheduleController;
import model.User;
import view.Schedule;

public class ScheduleController {
	private Schedule scheduleView;
	private User user;

	public ScheduleController(Schedule scheduleView, User user) {
		super();
		this.scheduleView = scheduleView;
		this.user = user;
		this.scheduleView.addDatBanMouseListener(new DatBanMouseListener(scheduleView));
		this.scheduleView.addNextActionListener(new NextActionListener(scheduleView, user));
		this.scheduleView.addEditActionListener(new EditActionListener(scheduleView));
		this.scheduleView.addCancelActionListener(new DeleteScheduleActionListener(scheduleView));
	}
}
