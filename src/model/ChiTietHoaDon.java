package model;

import java.sql.Date;
import java.util.ArrayList;

public class ChiTietHoaDon {
	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	private String tenNhanVien;
	private String tenKhachHang;
	private String soDienThoai;
	private String ban;
	private String tenMon;
	private int soLuong;
	private float giaCa;
	private int id_mon;
	private int maHD;
	private int maKH;
	private Date ngayTao;
	
	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public ChiTietHoaDon() {
		super();
	}
	
	public ChiTietHoaDon(int maKH,String tenKhachHang, String tenMon, int soLuong, float giaCa, int id_mon, int maHD, Date ngayTao) {
		super();
		this.maKH = maKH;
		this.tenKhachHang = tenKhachHang;
		this.tenMon = tenMon;
		this.soLuong = soLuong;
		this.giaCa = giaCa;
		this.id_mon = id_mon;
		this.maHD = maHD;
		this.ngayTao = ngayTao;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public float getGiaCa() {
		return giaCa;
	}
	public void setGiaCa(float giaCa) {
		this.giaCa = giaCa;
	}
	public int getId_mon() {
		return id_mon;
	}
	public void setId_mon(int id_mon) {
		this.id_mon = id_mon;
	}
	public int getMaHD() {
		return maHD;
	}
	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}
	private String trangThai;
	private float tongThu;
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public float getTongThu() {
		return tongThu;
	}
	public void setTongThu(float tongThu) {
		this.tongThu = tongThu;
	}
	public ChiTietHoaDon(String tenNhanVien, String tenKhachHang, String soDienThoai, String ban,
			String trangThai, float tongThu) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.ban = ban;
		this.trangThai = trangThai;
		this.tongThu = tongThu;
	}

	
}
