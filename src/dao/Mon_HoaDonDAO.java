package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Mon_Hoadon;

public class Mon_HoaDonDAO implements DAOInterface<Mon_Hoadon>{
	
	public static Mon_HoaDonDAO getInstance() {
		return new Mon_HoaDonDAO();
	}

	@Override
	public int insert(Mon_Hoadon t) {
		// TODO Auto-generated method stub
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
			String sql = "INSERT INTO mon_hoadon (MaHD, ID_Mon, SoLuong)" +
						" VALUES ('"+t.getMaHD()+"', '"+t.getID_Mon()+"', '"+t.getSoluong()+"')";
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
	public int update(Mon_Hoadon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Mon_Hoadon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Mon_Hoadon> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mon_Hoadon selectById(Mon_Hoadon t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mon_Hoadon> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
