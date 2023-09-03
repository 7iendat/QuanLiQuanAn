package controller.SingUpController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.LoginController.LoginController;
import view.Login;
import view.SignUp;

public class ShiftLoginView implements MouseListener{
	private SignUp signUpView;

	public ShiftLoginView(SignUp signUpView) {
		super();
		this.signUpView = signUpView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Login login = new Login();
		login.setVisible(true);
		LoginController loginController = new LoginController(login);
		signUpView.setVisible(false);
		
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
