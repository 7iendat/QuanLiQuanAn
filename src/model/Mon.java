package model;

public class Mon {
	private int id;
	private String tenMon;
	private String loai;
	private float donGia;
	private String anhMinhHoa;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTenMon() {
		return tenMon;
	}


	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}


	public String getLoai() {
		return loai;
	}


	public void setLoai(String loai) {
		this.loai = loai;
	}


	public float getDonGia() {
		return donGia;
	}


	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}


	public String getAnhMinhHoa() {
		return anhMinhHoa;
	}


	public void setAnhMinhHoa(String anhMinhHoa) {
		this.anhMinhHoa = anhMinhHoa;
	}





	public Mon() {
		super();
	}


	public Mon(int id, String tenMon, String loai, float donGia, String anhMinhHoa) {
		super();
		this.id = id;
		this.tenMon = tenMon;
		this.loai = loai;
		this.donGia = donGia;
		this.anhMinhHoa = anhMinhHoa;
	}


	public Mon(String tenMon, String loai, float donGia, String anhMinhHoa) {
		super();
		this.tenMon = tenMon;
		this.loai = loai;
		this.donGia = donGia;
		this.anhMinhHoa = anhMinhHoa;
	}
	
	
}
