package controller.EditController;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import dao.KhachHangDAO;
import dao.LichDatDAO;
import model.KhachHang;
import model.LichDat;
import view.Edit;
import view.PnOrder;

public class HoanTatMouseListener implements MouseListener{
	private Edit editView;

	public HoanTatMouseListener(Edit editView ) {
		super();
		this.editView = editView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		ArrayList<LichDat> lichDats = LichDatDAO.getInstance().innerJoinWithKhachHangTable();
		
		int rowSelected = editView.getScheduleView().getTblKhach().getSelectedRow();
		if(rowSelected == -1) return;
		
		if((String)editView.getScheduleView().getTblKhach().getValueAt(rowSelected, 2)!= null)
		{
			String[] arrBan = ((String) editView.getScheduleView().getTblKhach().getValueAt(rowSelected, 2)).split(" ");
			
			for(String ban: arrBan) {
//				System.out.println(ban);
				if(!ban.isEmpty()) {
					
					
					for(int i = 0; i< 12;i++ ) {
						
						if(editView.getScheduleView().getArrlbl()[i].getText().equals(ban)) {
							
							editView.getScheduleView().getArrlbl()[i].enable(true);;
							editView.getScheduleView().getArrlbl()[i].setBackground(new Color(0, 128, 255));
							editView.getScheduleView().getSeatSelected()[i] = "0";
							editView.getScheduleView().getArrSelected()[i] = "0";
							
						}
					}
				}
			}
		}
		
		for(LichDat lichDat: lichDats)
		{
			if(lichDat.getTenKH().equals(editView.getScheduleView().getTblKhach().getValueAt(rowSelected, 0))) {
				String newName = editView.getEditName().getText();
				String newTime = (String) editView.getEditTime().getSelectedItem();
				
				String newTable = editView.getEditTable().getText();
				
				
				
				editView.getScheduleView().getTblKhach().setValueAt(newName, rowSelected, 0);
				editView.getScheduleView().getTblKhach().setValueAt(newTime, rowSelected, 1);
				editView.getScheduleView().getTblKhach().setValueAt(newTable, rowSelected, 2);
				LichDat newLichDat = new LichDat(lichDat.getMaKH(),newName,newTable, newTime);
				LichDatDAO.getInstance().update(newLichDat);
				KhachHangDAO.getInstance().update(newName, newTable, lichDat.getMaKH());
				
				
				
				editView.dispose();
			}
		}
		
		ArrayList<KhachHang> khachHangs = KhachHangDAO.getInstance().selectAll();
		
		for(KhachHang kh: khachHangs) {
			String chuoiBan = kh.getBan();
			if(chuoiBan!= null)
			{
				String[] arrBan = chuoiBan.split(" ");
				
				for(String ban: arrBan) {
//					System.out.println(ban);
					if(!ban.isEmpty()) {
						
						
						for(int i = 0; i< 12;i++ ) {
							
							if(editView.getScheduleView().getArrlbl()[i].getText().equals(ban)) {
								
								editView.getScheduleView().getArrlbl()[i].enable(false);;
								editView.getScheduleView().getArrlbl()[i].setBackground(Color.gray);
								editView.getScheduleView().getSeatSelected()[i] = ban;
								editView.getScheduleView().getArrSelected()[i] = "-1";
								
							}
							
							else {
								
							}
							

							
						
						}
				
					}
				}
			}
		}
		
//		String newName = editView.getEditName().getText();
//		String newTime = (String) editView.getEditTime().getSelectedItem();
//		
//		String newTable = editView.getEditTable().getText();
//		
//		editView.getTblKhach().setValueAt(newName, rowSelected, 0);
//		editView.getTblKhach().setValueAt(newTime, rowSelected, 1);
//		editView.getTblKhach().setValueAt(newTable, rowSelected, 2);
//		editView.dispose();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
