package model;

public class KhachHang {
	private int MaKH;
	private String TenKH;
	private String GioiTinh;
	private String DiaChi;
	private String Ban;
	private String tinhTrang;
	
	public String getTinhTrang() {
		return tinhTrang;
	}



	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}



	public String getBan() {
		return Ban;
	}



	public void setBan(String ban) {
		Ban = ban;
	}



	private String SoDienThoai;
	private int ID_nhanvien;
	
	
	
	public int getMaKH() {
		return MaKH;
	}



	public void setMaKH(int maKH) {
		MaKH = maKH;
	}



	public String getTenKH() {
		return TenKH;
	}



	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}



	public String getGioiTinh() {
		return GioiTinh;
	}



	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}



	public String getDiaChi() {
		return DiaChi;
	}



	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}



	public String getSoDienThoai() {
		return SoDienThoai;
	}



	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}



	public int getID_nhanvien() {
		return ID_nhanvien;
	}



	public void setID_nhanvien(int iD_nhanvien) {
		ID_nhanvien = iD_nhanvien;
	}




	public KhachHang() {
		super();
	}



	public KhachHang(  String tenKH, String gioiTinh, String diaChi, String ban, String soDienThoai,
			int iD_nhanvien) {
		super();
		TenKH = tenKH;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		Ban = ban;
		SoDienThoai = soDienThoai;
		ID_nhanvien = iD_nhanvien;
	}



	public KhachHang(int maKH, String tenKH, String gioiTinh, String diaChi, String ban, String soDienThoai,
			int iD_nhanvien) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		GioiTinh = gioiTinh;
		DiaChi = diaChi;
		Ban = ban;
		SoDienThoai = soDienThoai;
		ID_nhanvien = iD_nhanvien;
	}



	public KhachHang(int maKH, String tenKH, String ban, String tinhTrang) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		Ban = ban;
		this.tinhTrang = tinhTrang;
	}




	
	
	
}
