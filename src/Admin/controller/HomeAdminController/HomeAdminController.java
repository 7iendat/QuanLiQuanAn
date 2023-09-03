package Admin.controller.HomeAdminController;

import Admin.view.HomeAdmin;

public class HomeAdminController {
	private HomeAdmin homeAdminView;

	public HomeAdminController(HomeAdmin homeAdminView) {
		super();
		this.homeAdminView = homeAdminView;
		this.homeAdminView.addBtnSignUPActionListener(new SignUpControler(homeAdminView));
		this.homeAdminView.addBtnNhanVienActionListener(new BtnNhanVienActionListener(homeAdminView));
		this.homeAdminView.addBtnListMonActionListener(new ListMonActionListener(homeAdminView));
		this.homeAdminView.addBtnDoanhThuActionListener(new DaonhThuActionListener(homeAdminView));
	}
	
	
}
