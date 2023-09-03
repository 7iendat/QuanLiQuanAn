package controller.SingUpController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import controller.LoginController.LoginController;
import dao.NhanVienDAO;
import dao.UserDAO;
import model.NhanVien;
import model.User;
import view.Login;
import view.SignUp;

public class SinUpActionListener implements ActionListener {
	private SignUp signUpView;

	String regex = "^[A-Za-z0-9+_.-]+@(.+)$";  
	Pattern pattern = Pattern.compile(regex);
	
	Border border = BorderFactory.createLineBorder(Color.red, 2);
	

	public SinUpActionListener(SignUp signUpView) {
		super();
		this.signUpView = signUpView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<User> arrAccExisted = UserDAO.getInstance().selectAll();
		ArrayList<NhanVien> listNhanVien  = NhanVienDAO.getInstance().selectAll();
		
		
	    Matcher matcher = pattern.matcher(signUpView.getTfEmail().getText()); 
		
		if(signUpView.getTfName().getText().equals("") || signUpView.getTfPass().getText().equals("") || signUpView.getTfEmail().getText().equals("") && (signUpView.getTfName().getText().equals("") && signUpView.getTfPass().getText().equals("") && signUpView.getTfEmail().getText().equals("")))
		{
			
			JOptionPane.showMessageDialog(null, "KHÔNG ĐƯỢC BỎ TRỐNG!!!");
			if(signUpView.getTfName().getText().equals("") && signUpView.getTfPass().getText().equals("") && signUpView.getTfEmail().getText().equals("")) {
				signUpView.getTfName().setBorder(border);
				signUpView.getTfPass().setBorder(border);
				signUpView.getTfEmail().setBorder(border);
			}
			else if(signUpView.getTfName().getText().equals(""))
				signUpView.getTfName().setBorder(border);
			else if(signUpView.getTfPass().getText().equals(""))
				signUpView.getTfPass().setBorder(border);
			else if(signUpView.getTfEmail().getText().equals(""))
				signUpView.getTfEmail().setBorder(border);
			
			signUpView.getTfName().requestFocus();
		}
		else if(!matcher.matches())
		{
			JOptionPane.showMessageDialog(null, "EMAIL KHÔNG ĐÚNG!!!");
			signUpView.getTfEmail().setText("");
			signUpView.getTfEmail().requestFocus();
			
			signUpView.getTfEmail().setBorder(border);
		}
		else if(signUpView.getTfPass().getText().length() < 6) {
			JOptionPane.showMessageDialog(null, "PASSWORD PHẢI HƠN 6 KÍ TỰ!!!");
			signUpView.getTfPass().setText(""); 
			signUpView.getTfPass().requestFocus();
		}
		
		else {
			int flag = 0;
			for(NhanVien nhanVien: listNhanVien) {
				if(nhanVien.getEmail().equals(signUpView.getTfEmail().getText())) {
					int ID_acc = nhanVien.getID_nhanvien();
					String username = signUpView.getTfName().getText();
					String pass = signUpView.getTfPass().getText();
					User updateAcc = new User(ID_acc,username, pass);
					UserDAO.getInstance().update(updateAcc);
					
					JOptionPane.showMessageDialog(null, "ĐĂNG KÍ THÀNH CÔNG!!!");
					
					Login login = new Login();
					
					login.setVisible(true);
					LoginController loginController = new LoginController(login);
					signUpView.setVisible(false);
					break;
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Bạn Không Phải Nhân Viên!!!");
					break;
				}
			}
			
			
		}
		
	}

}
