package controller.MainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.OrderController.OrderController;
import model.User;
import view.Main;
import view.PnOrder;

public class OrderActionListener implements ActionListener{
	private Main mainView;
	private User user;

	public OrderActionListener(Main mainView, User user) {
		super();
		this.mainView = mainView;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PnOrder pnNew = new PnOrder(mainView.getUser());
		OrderController orderController = new OrderController(pnNew, user);
		mainView.getPnRight().removeAll();
		mainView.getPnRight().add(pnNew);
		mainView.getPnRight().validate();
		mainView.getPnRight().repaint();
		
	}

}
