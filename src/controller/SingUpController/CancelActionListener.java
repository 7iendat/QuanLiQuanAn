package controller.SingUpController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SignUp;

public class CancelActionListener implements ActionListener{
	
	private SignUp sinUpView;
	public CancelActionListener(SignUp sinUpView) {
		super();
		this.sinUpView = sinUpView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		sinUpView.dispose();
	}
	
}
