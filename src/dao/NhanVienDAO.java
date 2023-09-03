package dao;

import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.NhanVien;
import model.User;

public class NhanVienDAO implements DAOInterface<NhanVien>{
	
	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert(NhanVien t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO nhanvien (Ten, GioiTinh, SoDienThoai, email)" + 
						" VALUES('"+t.getTen()+"', '"+t.getGioiTinh()+"', '"+t.getSoDienThoai()+"', '"+t.getEmail()+"')";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(NhanVien t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "UPDATE nhanvien " + 
						" SET " + 
						" Ten= '" + t.getTen()+"'" + 
						", GioiTinh= '"+t.getGioiTinh()+"'" +
						", SoDienThoai= '"+t.getSoDienThoai()+"'" +
						", email= '"+t.getEmail()+"'" +
						" WHERE ID_nhanvien= '"+t.getID_nhanvien()+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(NhanVien t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "DELETE from nhanvien " + 
						" WHERE ID_nhanvien= '"+t.getID_nhanvien()+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<NhanVien> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<NhanVien> ketQua = new ArrayList<NhanVien>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from nhanvien";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id_nhanVien = rs.getInt("ID_nhanvien");
				String tenNhanVien = rs.getString("Ten");
				String gioiTinh = rs.getString("GioiTinh");
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("email");
				
				NhanVien nhanVien = new NhanVien(id_nhanVien, tenNhanVien, gioiTinh, sdt, email);
				
				ketQua.add(nhanVien);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public NhanVien selectById(NhanVien t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NhanVien> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<NhanVien> ketQua = new ArrayList<NhanVien>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from nhanvien WHERE " + condition;
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id_nhanVien = rs.getInt("ID_nhanvien");
				String tenNhanVien = rs.getString("Ten");
				String gioiTinh = rs.getString("GioiTinh");
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("email");
				
				NhanVien nhanVien = new NhanVien(id_nhanVien, tenNhanVien, gioiTinh, sdt, email);
				
				ketQua.add(nhanVien);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public ArrayList<NhanVien> selectAlphaBetAsc(){
		ArrayList<NhanVien> listAsc = new ArrayList<NhanVien>();
		
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * FROM nhanvien ORDER BY Ten ASC";
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id_nhanVien = rs.getInt("ID_nhanvien");
				String tenNhanVien = rs.getString("Ten");
				String gioiTinh = rs.getString("GioiTinh");
				String sdt = rs.getString("SoDienThoai");
				String email = rs.getString("email");
				
				NhanVien nhanVien = new NhanVien(id_nhanVien, tenNhanVien, gioiTinh, sdt, email);
				
				listAsc.add(nhanVien);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();	
		}
		
		return listAsc;
	}

}
