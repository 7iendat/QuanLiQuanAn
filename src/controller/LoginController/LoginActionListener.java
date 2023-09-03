package controller.LoginController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import Admin.controller.HomeAdminController.HomeAdminController;
import Admin.view.HomeAdmin;
import controller.MainController.MainController;
import dao.UserDAO;
import model.User;
import view.Login;
import view.Main;

public class LoginActionListener implements ActionListener{
	private Login loginView;
	Border border = BorderFactory.createLineBorder(new Color(255,51,51), 2);

	public LoginActionListener(Login loginView) {
		super();
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int key = 0;
		
		ArrayList<User> arrAccount = UserDAO.getInstance().selectAll();
		
		if (loginView.getTfName().getText().equals("") || loginView.getTfPass().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "KHÔNG ĐƯỢC BỎ TRỐNG!!!");
			if(loginView.getTfName().getText().equals("")) {
				loginView.getTfName().requestFocus();
				loginView.getTfName().setBorder(border);
			
			}
				
				
			else if(loginView.getTfPass().getText().equals("")) {
				loginView.getTfPass().requestFocus();
				loginView.getTfPass().setBorder(border);
				
			}
		}
		
		else {
			int check = 0;
			for(User acc: arrAccount) {
					
					if(acc.getUseName().equals(loginView.getTfName().getText()) && acc.getPassWord().equals(loginView.getTfPass().getText()))
					{
						User userinput = new User(loginView.getTfName().getText(), loginView.getTfPass().getText());
						if(acc.getChucQuyen().toLowerCase().equals("nhân viên")) {
							System.out.println("Da vao nhan vien");
							Main main = new Main(userinput);
							MainController mainController = new MainController(main, userinput);
							main.setVisible(true);
							loginView.setVisible(false);
							check = 1;
							break;
						}
						else if(acc.getChucQuyen().toLowerCase().equals("admin"))
						{
							System.out.println("Da vao admin");
							HomeAdmin homeAdmin = new HomeAdmin(userinput);
							HomeAdminController homeAdminController = new HomeAdminController(homeAdmin);
							homeAdmin.setVisible(true);
							loginView.setVisible(false);
							check = 1;
							break;
						}

						
					}
					
					else  {
						
					}
			}
			
			if(check == 0)
				JOptionPane.showMessageDialog(null, "Tên hoặc mật khẩu không đúng!!!");

			
		}
	}
}
		

			
		
		


