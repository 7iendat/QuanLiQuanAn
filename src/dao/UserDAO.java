package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User>{
	
	public static UserDAO getInstance()
	{
		return new UserDAO();
	}

	@Override
	public int insert(User t) {
		// TODO Auto-generated method stub
		
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "INSERT INTO account (userName, passWord)" + 
						" VALUES('"+t.getUseName()+"', '"+t.getPassWord()+"')";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "UPDATE account " + 
						" SET " + 
						" userName= '" + t.getUseName()+"'" + 
						", passWord= '"+t.getPassWord()+"'" +
						" WHERE ID_Acc= '"+t.getId()+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(User t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "DELETE from account " + 
						" WHERE ID_Acc= '"+t.getId()+"'";
			
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from account";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID_Acc");
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				int id_nhanVien = rs.getInt("ID_nhanvien");
				String chucQuyen = rs.getString("ChucQuyen");
				User user = new User(userName, passWord,id_nhanVien, chucQuyen);
				ketQua.add(user);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public User selectById(User t) {
		// TODO Auto-generated method stub
		User ketQua = null;
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from account WHERE ID_Acc = '"+t.getId()+"'";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID_Acc");
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				int id_nhanVien = rs.getInt("ID_nhanvien");
				String chucQuyen = rs.getString("ChucQuyen");
				ketQua = new User(userName, passWord,id_nhanVien, chucQuyen);
				
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			Connection con  = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			
			String sql = "SELECT * from account WHERE " + condition;
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID_Acc");
				String userName = rs.getString("userName");
				String passWord = rs.getString("passWord");
				int id_NhanVien = rs.getInt("ID_nhanvien");
				String chucQuyen = rs.getString("ChucQuyen");
				User user = new User(id, userName, passWord, chucQuyen, id_NhanVien);
				ketQua.add(user);
			}
			
			JDBCUtil.closeConnection(con);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketQua;
	}

	

}
