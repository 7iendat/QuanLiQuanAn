package controller.EditController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Edit;

public class HuyMouseListener implements MouseListener{
	private Edit editView;

	public HuyMouseListener(Edit editView) {
		super();
		this.editView = editView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		editView.dispose();
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
