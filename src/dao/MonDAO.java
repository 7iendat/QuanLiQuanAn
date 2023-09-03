package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Mon;
import model.User;

public class MonDAO implements DAOInterface<Mon>{

	public static MonDAO getInstance() {
		return new MonDAO();
	}
	
	@Override
	public int insert(Mon t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO monan(TenMon, LoaiMon, GiaCa, AnhMinhHoa, NgayThem)" + 
						" VALUES ('"+t.getTenMon()+"','"+t.getLoai()+"','"+t.getDonGia()+"','"+t.getAnhMinhHoa()+"', NOW())";
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(Mon t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "UPDATE monan" + 
						" SET " +
						" TenMon= '"+ t.getTenMon() +"'" +
						", LoaiMon= ' "+ t.getLoai()+"'" +
						", GiaCa= '"+t.getDonGia()+"'" +
						", AnhMinhHoa= '"+t.getAnhMinhHoa()+"'" +
						"WHERE ID_Mon= '"+t.getId()+"'";
			
			ketQua = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(Mon t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "DELETE from monan " + 
						" WHERE ID_Mon= '"+t.getId()+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<Mon> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Mon> ketQua = new ArrayList<Mon>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from monan";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID_Mon");
				String tenMon = rs.getString("TenMon");
				String loai = rs.getString("LoaiMon");
				Float donGia = rs.getFloat("GiaCa");
				String anhMinhHoa = rs.getString("AnhMinhHoa");
				Mon monAn = new Mon(id, tenMon, loai, donGia, anhMinhHoa);
				
				ketQua.add(monAn);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Mon selectById(Mon t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mon> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<Mon> ketQua = new ArrayList<Mon>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from monan WHERE " + condition;
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID_Mon");
				String tenMon = rs.getString("TenMon");
				String loai = rs.getString("LoaiMon");
				Float donGia = rs.getFloat("GiaCa");
				String anhMinhHoa = rs.getString("AnhMinhHoa");
				Mon monAn = new Mon(id, tenMon, loai, donGia, anhMinhHoa);
				
				ketQua.add(monAn);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public int getNumberRow() {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT COUNT(*) FROM monan";
			ResultSet sr = st.executeQuery(sql);
			while(sr.next())
				ketQua++;
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

}
