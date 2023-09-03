package controller.LoginController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.SingUpController.SignUpController;
import view.Login;
import view.SignUp;

public class ShiftSignUpView implements MouseListener{
	private Login loginView;

	public ShiftSignUpView(Login loginView) {
		super();
		this.loginView = loginView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		SignUp signUp = new SignUp();
		signUp.setVisible(true);
		new SignUpController(signUp);
		loginView.setVisible(false);
		
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
