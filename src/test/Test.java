package test;

import java.awt.EventQueue;
import java.sql.Connection;

import controller.LoginController.LoginController;
import database.JDBCUtil;
import view.Login;

public class Test {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame  =  new Login();
					LoginController loginController = new LoginController(frame); 
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
		
	}
}
