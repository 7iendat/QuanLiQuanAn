package model;

public class Mon_Hoadon {
	private int MaHD;
	private int ID_Mon;
	private int Soluong;
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	public int getID_Mon() {
		return ID_Mon;
	}
	public void setID_Mon(int iD_Mon) {
		ID_Mon = iD_Mon;
	}
	public int getSoluong() {
		return Soluong;
	}
	public void setSoluong(int soluong) {
		Soluong = soluong;
	}
	
	
	public Mon_Hoadon() {
		super();
	}
	public Mon_Hoadon(int maHD, int iD_Mon, int soluong) {
		super();
		MaHD = maHD;
		ID_Mon = iD_Mon;
		Soluong = soluong;
	}
}
