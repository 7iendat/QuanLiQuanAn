package controller.LoginController;

import view.Login;

public class LoginController {
	private Login loginView ;

	public LoginController(Login loginView) {
		super();
		this.loginView = loginView;
		this.loginView.addActionLogin(new LoginActionListener(loginView));
		this.loginView.addActionCancel(new CancelActionListener(loginView));
		this.loginView.addActionSignUp(new ShiftSignUpView(loginView));
	}
	
}
