package controller.ScheduleController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.KhachHangDAO;
import dao.LichDatDAO;
import model.KhachHang;
import model.LichDat;
import view.PnOrder;
import view.Schedule;

public class DeleteScheduleActionListener implements ActionListener{
	private Schedule scheduleView;
	
	public DeleteScheduleActionListener(Schedule scheduleView) {
		super();
		this.scheduleView = scheduleView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<LichDat> lichDats = LichDatDAO.getInstance().innerJoinWithKhachHangTable();
		
		
		// TODO Auto-generated method stub
		int rowSelected = scheduleView.getTblKhach().getSelectedRow();
		if(rowSelected == -1)return ;
		String tableOfRow = (String) scheduleView.getTblKhach().getValueAt(rowSelected, 2);
		String tenKH = (String)scheduleView.getTblKhach().getValueAt(rowSelected, 0);
		String[] numberTables = tableOfRow.split("\\s");
		Integer [] numtables = new Integer[ numberTables.length ];
		Integer[] arrNum = new Integer[ numberTables.length];
		
		for(LichDat lichdat: lichDats)
		{
			if(lichdat.getTenKH().equals(tenKH) ) {
				KhachHangDAO.getInstance().deleteByMaKH(lichdat.getMaKH());
				scheduleView.getDtm().removeRow(scheduleView.getTblKhach().getSelectedRow());
				
				scheduleView.setRow(scheduleView.getRow()-1);
				String chuoiBan = lichdat.getBan();
				if(chuoiBan!= null)
				{
					String[] arrBan = chuoiBan.split(" ");
					
					for(String ban: arrBan) {
//						System.out.println(ban);
						if(!ban.isEmpty()) {
							
							
							for(int i = 0; i< 12;i++ ) {
								
								if(scheduleView.getArrlbl()[i].getText().equals(ban)) {
									
									scheduleView.getArrlbl()[i].enable(true);;
									scheduleView.getArrlbl()[i].setBackground(new Color(0, 128, 255));
									scheduleView.getSeatSelected()[i] = "0";
									scheduleView.getArrSelected()[i] = "0";
									
								}
								
								else {
									
								}
							}
					
						}
					}
				}
				break;
			}
		}
	}
}




