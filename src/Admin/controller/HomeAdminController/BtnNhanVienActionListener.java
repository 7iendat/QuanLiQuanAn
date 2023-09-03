package Admin.controller.HomeAdminController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Admin.view.HomeAdmin;
import Admin.view.NhanVien;
import model.User;

public class BtnNhanVienActionListener implements ActionListener{
	private HomeAdmin homeAdminView;
	private User user;

	public BtnNhanVienActionListener(HomeAdmin homeAdminView) {
		super();
		this.homeAdminView = homeAdminView;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		NhanVien nhanvien = new NhanVien(homeAdminView, user);
		homeAdminView.getPnRight().removeAll();
		homeAdminView.getPnRight().add(nhanvien);
		homeAdminView.getPnRight().validate();
		homeAdminView.getPnRight().repaint();
		
		
	}

}
