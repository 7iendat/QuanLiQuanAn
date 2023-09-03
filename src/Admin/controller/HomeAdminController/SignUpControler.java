package Admin.controller.HomeAdminController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Admin.view.HomeAdmin;
import controller.LoginController.LoginController;
import view.Login;

public class SignUpControler implements ActionListener{
	private HomeAdmin homeAdminView;
	public SignUpControler(HomeAdmin homeAdminView) {
		super();
		this.homeAdminView = homeAdminView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Login login = new Login();
		LoginController loginController = new LoginController(login);
		login.setVisible(true);
		homeAdminView.setVisible(false);
		
	}

}
