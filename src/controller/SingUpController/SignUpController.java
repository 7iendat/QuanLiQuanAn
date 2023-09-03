package controller.SingUpController;

import view.SignUp;

public class SignUpController {
	private SignUp signUpView;

	public SignUpController(SignUp signUpView) {
		super();
		this.signUpView = signUpView;
		this.signUpView.addSignUpAction(new SinUpActionListener(signUpView));
		this.signUpView.addCancelAction(new CancelActionListener(signUpView));
		this.signUpView.addLoginMouseListener(new ShiftLoginView(signUpView));
	}
	
}
