package controller.OrderController;

import model.User;
import view.PnOrder;

public class OrderController {
	private PnOrder orderView;
	private User user;

	public OrderController(PnOrder orderView, User user) {
		super();
		this.orderView = orderView;
		this.user = user;
		
		this.orderView.addNextActionListener(new NextActionListener(orderView, user));
		
	}
}
