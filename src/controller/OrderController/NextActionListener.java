package controller.OrderController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.DashboardController.DashboardController;
import dao.KhachHangDAO;
import model.KhachHang;
import model.User;
import view.DashboardView;
import view.PnOrder;

public class NextActionListener implements ActionListener{
	private PnOrder orderView;
	private User user;
	

	public NextActionListener(PnOrder orderView, User user) {
		super();
		this.orderView = orderView;
		this.user = user;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		orderView.setTable(""); 
		
		
		


		for(int i = 0; i< 12;i++ ) {
			if(orderView.getArrlbl()[i].getText() == orderView.getArrBanChonMoi()[i]) {
//				arrTable[i] = orderView.getArrlbl()[i].getText();
				orderView.getArrlbl()[i].enable(false);
				orderView.getArrlbl()[i].setBackground(Color.gray);
				
//				key = 1;
				orderView.getArrSelected()[i] = "-1";
			}
//			
			else if( orderView.getArrSelected()[i] == "1"){
				orderView.getArrlbl()[i].setBackground(new Color(0, 128, 255));
//				arrTable[i] = "";
				orderView.getArrSelected()[i] = "0";
//				key = 0;
			}
		}
		
		for(int i = 0; i < 12; i++)
		{
			if (orderView.getTable() == null )
				orderView.setTable(orderView.getArrBanChonMoi()[i]);
			else if(orderView.getArrBanChonMoi()[i]!= "0" && orderView.getTable() != null)
				orderView.setTable(orderView.getTable() + " " + orderView.getArrBanChonMoi()[i]); 
		}
		
//		System.out.println(orderView.getTable());
		
//		for(int i = 0 ; i < 12; i++)
//		{
//			
//			ArrayList<KhachHang> khachHangs = KhachHangDAO.getInstance().selectAll();
//			
//			for(KhachHang kh: khachHangs)
//			{
//				String chuoiBan = kh.getBan();
//				if(chuoiBan!= null)
//				{
//					String[] arrBan = chuoiBan.split(" ");
//					for(String ban: arrBan) {
//						
//							System.out.println(ban);
//					}
//				}
//			}
			
//			if (orderView.getTable() == null && key == 1)
//				orderView.setTable(arrTable[i]);
//			else if(arrTable[i] != null && orderView.getTable() != null)
//				orderView.setTable(orderView.getTable() + " " + arrTable[i]); 
			
//		}
		// TODO Auto-generated method stub
//		int rowSelected = orderView.getTblKhach().getSelectedRow();
//		if(rowSelected == -1) return;
//		orderView.setStringTable((String) orderView.getTblKhach().getValueAt(rowSelected, 2));
		if(orderView.getTable() != "") {
//			DashboardViewz dashBoard = new DashboardViewz(orderView.getStringTable());
			DashboardView dashBoard = new DashboardView(orderView.getTable(), user);
			DashboardController dashboardController = new DashboardController(dashBoard);
			dashBoard.setVisible(true);
		}	

		
	}

}
