package controller.ScheduleController;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import dao.KhachHangDAO;
import dao.LichDatDAO;
import model.KhachHang;
import model.LichDat;
import view.Schedule;

public class DatBanMouseListener implements MouseListener{
	private Schedule scheduleView;

	public DatBanMouseListener(Schedule scheduleView) {
		super();
		this.scheduleView = scheduleView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String[] arrTable = new String[12];
		scheduleView.setTable(""); 
		System.out.println(scheduleView.getTfName().getText());
		int key = 0;
		

		for(int i = 0; i< 12;i++ ) {
			if(scheduleView.getArrSelected()[i] == "1" && scheduleView.getTfName().getText().length()!= 0  ) {
				arrTable[i] = scheduleView.getArrlbl()[i].getText();
				scheduleView.getArrlbl()[i].enable(false);
				scheduleView.getArrlbl()[i].setBackground(Color.gray);
				
				key = 1;
				scheduleView.getArrSelected()[i] = "-1";
			}
			
			else if( scheduleView.getArrSelected()[i] == "1" && scheduleView.getTfName().getText().length()== 0){
				scheduleView.getArrlbl()[i].setBackground(new Color(0, 128, 255));
				arrTable[i] = "";
				scheduleView.getArrSelected()[i] = "0";
				key = 0;
			}
		}
		
		for(int i = 0 ; i < 12; i++)
		{
			
			if (scheduleView.getTable() == null && key == 1)
				scheduleView.setTable(arrTable[i]);
			else if(arrTable[i] != null && scheduleView.getTable() != null)
				scheduleView.setTable(scheduleView.getTable() + " " + arrTable[i]); 
			
		}
		
//		String[] arrBan = scheduleView.getTable().split(" ");
		
		
		
		
		for(int i = 0; i < 12; i++)
		{
			
				if(scheduleView.getArrSelected()[i] == "0" && scheduleView.getTfName().getText().length() != 0 && scheduleView.getTable() != ""  && scheduleView.getCboTime().getSelectedItem() != null)
				{
					scheduleView.setRow(scheduleView.getRow()+1);
					scheduleView.getDtm().setRowCount(scheduleView.getRow());
					
					Vector<String> vec = new Vector<String>();
//					vec.add(kh.getName());
					vec.add(scheduleView.getTfName().getText());
//					vec.add(kh.getAge());
					vec.add(scheduleView.getCboTime().getSelectedItem().toString());
//					vec.add(kh.getAddress());
					vec.add(scheduleView.getTable());
					scheduleView.getDtm().addRow(vec);
					
					
					break;
				}
			
			
//				lblTableSelected.setText(table);
				
		}
		scheduleView.getTfName().setText("");
		
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
