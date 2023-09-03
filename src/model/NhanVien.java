package model;

public class NhanVien {
	private int ID_nhanvien;
	private String Ten;
	private String GioiTinh;
	private String SoDienThoai;
	private String email;
	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getID_nhanvien() {
		return ID_nhanvien;
	}



	public void setID_nhanvien(int iD_nhanvien) {
		ID_nhanvien = iD_nhanvien;
	}



	public String getTen() {
		return Ten;
	}



	public void setTen(String ten) {
		Ten = ten;
	}



	public String getGioiTinh() {
		return GioiTinh;
	}



	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}



	public String getSoDienThoai() {
		return SoDienThoai;
	}



	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}



	



	public NhanVien() {
		super();
	}

	


	public NhanVien(String ten, String gioiTinh, String soDienThoai, String email) {
		super();
		Ten = ten;
		GioiTinh = gioiTinh;
		SoDienThoai = soDienThoai;
		this.email = email;
	}



	public NhanVien(int iD_nhanvien, String ten, String gioiTinh, String soDienThoai,  String email) {
		super();
		ID_nhanvien = iD_nhanvien;
		Ten = ten;
		GioiTinh = gioiTinh;
		SoDienThoai = soDienThoai;
		this.email = email;
	}
	
	
}
