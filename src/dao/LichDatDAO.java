package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.LichDat;
import model.User;

public class LichDatDAO implements DAOInterface<LichDat>{
	
	public static LichDatDAO getInstance() {
		return new LichDatDAO();
	}

	@Override
	public int insert(LichDat t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
			
			String sql =  "INSERT INTO lichdat (MaKH, GioDat)" + 
						" VALUES('"+t.getMaKH()+"', '"+t.getGioDat()+"') ; " ;
			String sql2 = "SET FOREIGN_KEY_CHECKS=1;";
			
			System.out.println(sql);
			st.execute(sql1);
			
			ketQua = st.executeUpdate(sql);
			st.execute(sql2);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
		// TODO Auto-generated method stub
	}

	@Override
	public int update(LichDat t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "UPDATE lichdat " + 
						" SET " + 
						" GioDat= '"+t.getGioDat()+"'" +
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
	public int delete(LichDat t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<LichDat> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<LichDat> ketQua = new ArrayList<LichDat>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from lichdat";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaKH = rs.getInt("MaKH");
				String GioDat = rs.getString("GioDat");
				LichDat lichdat = new LichDat(MaKH, GioDat);
				ketQua.add(lichdat);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public LichDat selectById(LichDat t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LichDat> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<LichDat> innerJoinWithKhachHangTable(){
		ArrayList<LichDat> ketQua = new ArrayList<LichDat>();
		try {
			Connection con =JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT  khachhang.MaKH,khachhang.TenKH, khachhang.Ban, lichdat.GioDat FROM lichdat INNER JOIN khachhang ON lichdat.MaKH = khachhang.MaKH";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int MaKH = rs.getInt("khachhang.MaKH");
				String TenKH = rs.getString("khachhang.TenKH");
				String Ban = rs.getString("khachhang.Ban");
				String GioDat = rs.getString("lichdat.GioDat");
				LichDat lichdat = new LichDat(MaKH,TenKH, Ban, GioDat);
				ketQua.add(lichdat);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	

}
