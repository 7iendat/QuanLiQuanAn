	package model;

public class HoaDon {


	private int MaHD;
	private float TongGia;
//	private int ID_Mon;
	private int MaKh;
	private String TenKH;
	private String fkBan;
	private String tinhTrang;
	private int date;
	
	public int getDate() {
		return date;
	}



	public void setDate(int date) {
		this.date = date;
	}



	public HoaDon(float tongGia, int date) {
		super();
		TongGia = tongGia;
		this.date = date;
	}



	public String getTinhTrang() {
		return tinhTrang;
	}

	

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public HoaDon(int maHD, float tongGia, int maKh, String tenKH, String fkBan) {
		super();
		MaHD = maHD;
		TongGia = tongGia;
		MaKh = maKh;
		TenKH = tenKH;
		this.fkBan = fkBan;
	}

	public String getFkBan() {
		return fkBan;
	}

	public void setFkBan(String fkBan) {
		this.fkBan = fkBan;
	}
//	public HoaDon() {
//		super();
//	}

	public HoaDon(int maHD, float tongGia, int maKh) {
		super();
		MaHD = maHD;
		TongGia = tongGia;
		MaKh = maKh;
	}
	
//	public HoaDon(int maHD, float tongGia, int maKh, String tenKH) {
//		super();
//		MaHD = maHD;
//		TongGia = tongGia;
//		MaKh = maKh;
//		TenKH = tenKH;
//	}

	
	public HoaDon(int maHD, float tongGia, int maKh, String tinhTrang) {
		super();
		MaHD = maHD;
		TongGia = tongGia;
		MaKh = maKh;
		this.tinhTrang = tinhTrang;
	}




	public String getTenKH() {
		return TenKH;
	}


	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}


	public int getMaHD() {
		return MaHD;
	}


	public void setMaHD(int maHD) {
		MaHD = maHD;
	}



	public float getTongGia() {
		return TongGia;
	}


	public void setTongGia(float tongGia) {
		TongGia = tongGia;
	}



	public int getMaKh() {
		return MaKh;
	}


	public void setMaKh(int maKh) {
		MaKh = maKh;
	}


	public HoaDon() {
		super();
	}


}
