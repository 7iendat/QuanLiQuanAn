package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;

public class ChiTietHoaDon {
	public static ChiTietHoaDon getInstance() {
		return new ChiTietHoaDon();
	}
	
	public ArrayList<model.ChiTietHoaDon> innerJoin(){
		ArrayList<model.ChiTietHoaDon> ketQua = new ArrayList<model.ChiTietHoaDon>();
		try {
			Connection con =JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT monan.TenMon, mon_hoadon.SoLuong, hoadon.MaHD, monan.ID_Mon, monan.GiaCa, khachhang.TenKH, khachhang.MaKH, hoadon.NgayTao from mon_hoadon \r\n"
					+ "INNER join monan on mon_hoadon.ID_mon = monan.ID_Mon\r\n"
					+ "inner join hoadon on mon_hoadon.MaHD = hoadon.MaHD\r\n"
					+ "inner join khachhang on hoadon.MaKH = khachhang.MaKH;";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
	
				int maKH = rs.getInt("khachhang.MaKH");
				String tenMon = rs.getString("monan.TenMon");
				int soLuong = rs.getInt("mon_hoadon.SoLuong");
				int maHD = rs.getInt("hoadon.MaHD");
				int ID_Mon = rs.getInt("monan.ID_Mon");
				float giaCa = rs.getFloat("monan.GiaCa");
				String tenKH = rs.getString("khachhang.TenKH");
				Date NgayTao = rs.getDate("hoadon.NgayTao");
				
				model.ChiTietHoaDon chiTiet = new model.ChiTietHoaDon(maKH, tenKH, tenMon, soLuong, giaCa, ID_Mon, maHD, NgayTao);
				ketQua.add(chiTiet);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}
}
