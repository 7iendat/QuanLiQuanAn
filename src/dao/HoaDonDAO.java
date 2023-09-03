package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.HoaDon;
import model.LichDat;
import model.User;

public class HoaDonDAO implements DAOInterface<HoaDon>{
	
	public static HoaDonDAO getInstance() {
		return new HoaDonDAO();
	}

	@Override
	public int insert(HoaDon t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
			String sql = "INSERT INTO hoadon (TongGia, MaKH)" +
						" VALUES ('"+t.getTongGia()+"','"+t.getMaKh()+"')";
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
	public int update(HoaDon t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "UPDATE hoadon " + 
						" SET " + 
						" TongGia= '"+t.getTongGia()+"'" +
						", TinhTrang= '"+t.getTinhTrang()+"'" +
						" WHERE MaHD= '"+t.getMaHD()+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(HoaDon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<HoaDon> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<HoaDon> ketQua = new ArrayList<HoaDon>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from hoadon";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaHD = rs.getInt("MaHD");
				float TongGia = rs.getFloat("TongGia");
//				int ID_Mon = rs.getInt("ID_Mon");
				int MaKH = rs.getInt("MaKH");
				HoaDon hoaDon = new HoaDon(MaHD, TongGia, MaKH);
				ketQua.add(hoaDon);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public HoaDon selectById(HoaDon t) {
		// TODO Auto-generated method stub
		HoaDon ketQua = null;
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from hoadon WHERE MaHD = '"+t.getMaKh()+"'";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaHD = rs.getInt("MaHD");
				float  TongGia = rs.getFloat("TongGia");
//				int ID_Mon = rs.getInt("ID_Mon");
				int MaKH  = rs.getInt("MaKH");
				ketQua = new HoaDon(MaHD, TongGia,  MaKH);
				
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<HoaDon> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HoaDon> innerJoinWithKhachHangTable(){
		ArrayList<HoaDon> ketQua = new ArrayList<HoaDon>();
		try {
			Connection con =JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT  khachhang.MaKH,khachhang.TenKH, hoadon.MaHD ,khachhang.Ban,hoadon.TongGia  FROM hoadon INNER JOIN khachhang ON hoadon.MaKH = khachhang.MaKH";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaKH = rs.getInt("khachhang.MaKH");
				
				String TenKH = rs.getString("khachhang.TenKH");
				int MaHD = rs.getInt("hoadon.MaHD");
				String Ban = rs.getString("khachhang.Ban");
				float TongGia = rs.getFloat("hoadon.TongGia");
				HoaDon hoaDon = new HoaDon(MaHD, TongGia, MaKH, TenKH, Ban);
				ketQua.add(hoaDon);
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	public HoaDon selectById(int id) {
		// TODO Auto-generated method stub
		HoaDon ketQua = null;
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from hoadon WHERE MaHD = '"+id+"'";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaHD = rs.getInt("MaHD");
				float  TongGia = rs.getFloat("TongGia");
//				int ID_Mon = rs.getInt("ID_Mon");
				int MaKH  = rs.getInt("MaKH");
				String tinhTrang = rs.getString("TinhTrang");
				ketQua = new HoaDon(MaHD, TongGia,  MaKH, tinhTrang);
				
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public ArrayList<HoaDon> getSumTotal(){
		ArrayList<HoaDon> ketQua = new ArrayList<HoaDon>();
		try {
			Connection con =JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT day(NgayTao), sum(TongGia) as DoanhThu from hoadon GROUP BY day(NgayTao)";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				float TongGia = rs.getFloat("DoanhThu");
				int date = rs.getInt("day(NgayTao)");
				HoaDon hoaDon = new HoaDon(TongGia, date);
				ketQua.add(hoaDon);
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
}
