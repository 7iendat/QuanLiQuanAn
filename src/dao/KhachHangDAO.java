package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;
import model.Mon;
import model.User;


public class KhachHangDAO implements DAOInterface<KhachHang>{
	
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	
	@Override
	public int insert(KhachHang t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
			String sql = "INSERT INTO khachhang (TenKH, GioiTinh, DiaChi, SoDienThoai, Ban)" +
						" VALUES ('"+t.getTenKH()+"', '"+t.getGioiTinh()+"', '"+t.getDiaChi()+"', '"+t.getSoDienThoai()+"', '"+t.getBan()+"')";
			String sql2 = "SET FOREIGN_KEY_CHECKS=1;";
			st.execute(sql1);
			
			ketQua = st.executeUpdate(sql);
			
			st.execute(sql2);
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int update(KhachHang t) {
//		// TODO Auto-generated method stub
//		int ketQua = 0;
//		try {
//			Connection con = JDBCUtil.getConnection();
//			Statement st = con.createStatement();
//			
//			String sql = "UPDATE khachhang " + 
//						" SET " + 
//						" TenKH= '" + t.getTenKH()+"'" + 
//						", Ban= '"+t.getBan()+"'" +
//						" WHERE MaKH= '"+t.getMaKH()+"'";
//			
//			ketQua = st.executeUpdate(sql);
//			
//			JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ketQua;
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "DELETE from khachhang " + 
						" WHERE MaKH= '"+t.getMaKH()+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from khachhang";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaKH = rs.getInt("MaKH");
				String TenKH = rs.getString("TenKH");
				String ban = rs.getString("Ban");
				String GioiTinh = rs.getString("GioiTinh");
				String DiaChi = rs.getString("DiaChi");
				String SoDienThoai = rs.getString("SoDienThoai");
				int ID_nhanvien = rs.getInt("ID_nhanvien");
				KhachHang newKhachHang = new KhachHang(MaKH,TenKH, GioiTinh, DiaChi,ban,SoDienThoai, ID_nhanvien);
				
				ketQua.add(newKhachHang);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
		
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from khachhang WHERE " + condition;
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaKH = rs.getInt("MaKH");
				String TenKH = rs.getString("TenKH");
				String ban = rs.getString("Ban");
				String GioiTinh = rs.getString("GioiTinh");
				String DiaChi = rs.getString("DiaChi");
				String SoDienThoai = rs.getString("SoDienThoai");
				int ID_nhanvien = rs.getInt("ID_nhanvien");
				KhachHang kh = new KhachHang(MaKH,TenKH, GioiTinh, DiaChi, ban, SoDienThoai, ID_nhanvien);
				ketQua.add(kh);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int deleteByMaKH(int i) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
			
			String sql = "DELETE from khachhang " + 
						" WHERE MaKH= '"+i+"'";
			
			String sql2 = "SET FOREIGN_KEY_CHECKS=1;";
			
			st.execute(sql1);
			ketQua = st.executeUpdate(sql);
			st.execute(sql2);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int update(String newName, String newBan, int maKH) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "UPDATE khachhang " + 
						" SET " + 
						" TenKH= '" + newName+"'" + 
						", Ban= '"+newBan+"'" +
						" WHERE MaKH= '"+maKH+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
	
	public ArrayList<KhachHang> innerJoinWithHoaDon() {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "select khachhang.MaKH, khachHang.TenKH, khachhang.Ban, hoadon.TinhTrang from khachhang\r\n"
					+ "inner join hoadon on khachhang.MaKH = hoadon.MaKH; " ;
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaKH = rs.getInt("khachhang.MaKH");
				String TenKH = rs.getString("khachHang.TenKH");
				String ban = rs.getString("khachhang.Ban");
				String tinhTrang = rs.getString("hoadon.TinhTrang");
				
				KhachHang kh = new KhachHang(MaKH, TenKH, ban, tinhTrang);
				ketQua.add(kh);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

}
