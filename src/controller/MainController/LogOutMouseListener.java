package controller.MainController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.LoginController.LoginController;
import view.Login;
import view.Main;

public class LogOutMouseListener implements MouseListener{
	private Main mainView ;

	public LogOutMouseListener(Main mainView) {
		super();
		this.mainView = mainView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Login login = new Login();
		login.setVisible(true);
		LoginController loginController = new LoginController(login);
		mainView.setVisible(false);
		
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
