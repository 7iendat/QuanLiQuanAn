package model;

public class LichDat {
	private int MaKH;
	private String TenKH;
	private String Ban;
	public String getBan() {
		return Ban;
	}
	public void setBan(String ban) {
		Ban = ban;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	private String GioDat;
	public int getMaKH() {
		return MaKH;
	}
	public void setMaKH(int maKH) {
		MaKH = maKH;
	}
	public String getGioDat() {
		return GioDat;
	}
	public LichDat(String tenKH, String ban, String gioDat) {
		super();
		TenKH = tenKH;
		Ban = ban;
		GioDat = gioDat;
	}
	public LichDat(int maKH, String tenKH, String ban, String gioDat) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		Ban = ban;
		GioDat = gioDat;
	}
	public void setGioDat(String gioDat) {
		GioDat = gioDat;
	}
	public LichDat() {
		super();
	}
	public LichDat(int maKH, String gioDat) {
		super();
		MaKH = maKH;
		GioDat = gioDat;
	}
}
