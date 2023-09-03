package controller.LoginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Login;

public class CancelActionListener implements ActionListener{
	
	private Login loginView;
	public CancelActionListener(Login loginView) {
		super();
		this.loginView = loginView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		loginView.dispose();
	}
	
}
