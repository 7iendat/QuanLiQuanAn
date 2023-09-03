package controller.DashboardController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.MonDAO;
import dao.Mon_HoaDonDAO;
import details.MonAnDetail;
import model.HoaDon;
import model.KhachHang;
import model.Mon;
import model.Mon_Hoadon;
import view.DashboardView;

public class MuaActionListener implements ActionListener{
	private MonAnDetail monAn;
	private DashboardView dashBoardView;
	

	public MuaActionListener(MonAnDetail monAn,DashboardView dashBoardView) {
		super();
		this.monAn = monAn;
		this.dashBoardView = dashBoardView;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		ArrayList<HoaDon> hoaDons = HoaDonDAO.getInstance().innerJoinWithKhachHangTable();
//		ArrayList<KhachHang> khs = KhachHangDAO.getInstance().selectAll();
		
		String condition = "TenMon = '"+monAn.getTenMon().getText()+"' "  ;
		System.out.println(condition);
		ArrayList<Mon> mons = MonDAO.getInstance().selectByCondition(condition);
		int ID_mon = 0 ;
		int soLuong = 0;
		for(Mon mon: mons)
		{
			ID_mon = mon.getId();
			soLuong = (int) monAn.getSoLuong().getValue();
		}
		
		for(HoaDon hoaDon: hoaDons)
		{
			if(hoaDon.getFkBan().equals(dashBoardView.getTable())) {
				int maHD = hoaDon.getMaHD();
				Mon_Hoadon mon_hoaDon = new Mon_Hoadon(maHD, ID_mon, soLuong);
				Mon_HoaDonDAO.getInstance().insert(mon_hoaDon);
				
				System.out.println(ID_mon);
			}
		}
		
//		for(KhachHang khachHang: khs) {
//			if(khachHang.getBan().equals(dashBoardView.getTable())) {
//				for(Mon mon: mons)
//				{
//					int maHD = khachHang.getMaHD();
//					int maMon = mon.getId();
//					int value = (int)monAn.getSoLuong().getValue();
//					Mon_Hoadon mon_hoaDon = new Mon_Hoadon(maHD, maMon, value);
//					Mon_HoaDonDAO.getInstance().insert(mon_hoaDon);
//				}
//			}
//			else {System.out.println(dashBoardView.getTable());
//				System.out.println(hoaDon.getBan());
//			}
//		}
		
		
		int qty = Integer.parseInt(monAn.getSoLuong().getValue().toString());
		if(dashBoardView.qtyIsZero(qty)) {
			dashBoardView.setX(dashBoardView.getX()+1);
			if(dashBoardView.getX() == 1) {
				dashBoardView.spicyNoodleSeoul(dashBoardView.getTable()); //Điều kiện đúng thì xuất ra thông tin hóa đơn
			}
			monAn.getSoLuong().setValue(0); //Set giá trị số lượng món lại là 0
			double price = qty * monAn.getMonAn().getDonGia(); //Giá khởi đầu
			dashBoardView.setTotal(dashBoardView.getTotal() + price) ; 
			dashBoardView.getTax(dashBoardView.getTotal()); //Trả kết quả thuế theo biến tổng
			Locale locale = new Locale("vi", "VN"); //Định dạng kiểu VN
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale); //Định dạng kiểu số theo VN
			dashBoardView.getTextArea().setText(dashBoardView.getTextArea().getText() + dashBoardView.getX() + ". " + monAn.getTenMon().getText() + " \t\t" + numberFormat.format(price) + "\n"); //Xuất ra tên món ăn cùng với giá (có xuống dòng), numberFormat.format là để định dạng lại cho cái biến "price"
			dashBoardView.duDate();
		}
	}
		

}
