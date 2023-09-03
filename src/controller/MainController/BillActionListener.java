package controller.MainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Main;
import view.PnBill;
import view.Schedule;

public class BillActionListener implements ActionListener{
	private Main mainView;

	public BillActionListener(Main mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PnBill pnNew = new PnBill();
		mainView.getPnRight().removeAll();
		mainView.getPnRight().add(pnNew);
		mainView.getPnRight().validate();
		mainView.getPnRight().repaint();
		
	}

}
