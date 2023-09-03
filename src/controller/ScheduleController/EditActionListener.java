package controller.ScheduleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.EditController.EditController;
import view.Edit;
import view.PnOrder;
import view.Schedule;

public class EditActionListener implements ActionListener{
	private Schedule scheduleView;
	public EditActionListener(Schedule scheduleView) {
		super();
		this.scheduleView = scheduleView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rowSelected = scheduleView.getTblKhach().getSelectedRow();
		if(rowSelected == -1)return ;
		Edit editForm = new Edit(rowSelected,scheduleView);
		EditController editController = new EditController(editForm);
//		editForm.getTblKhach()
		editForm.setVisible(true);
	}

}
