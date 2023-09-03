package model;

//import javax.swing.JPasswordField;
//import javax.swing.JTextField;

public class User {






	private int id;
	private String useName;
	private String passWord;
	private String chucQuyen;
	private int ID_nhanvien;
	
	
	
	
	public User(int id, String useName, String passWord, String chucQuyen, int iD_nhanvien) {
		super();
		this.id = id;
		this.useName = useName;
		this.passWord = passWord;
		this.chucQuyen = chucQuyen;
		ID_nhanvien = iD_nhanvien;
	}
	public String getChucQuyen() {
		return chucQuyen;
	}
	public void setChucQuyen(String chucQuyen) {
		this.chucQuyen = chucQuyen;
	}

//	public User(String useName, String passWord, String email) {
//		super();
//		this.useName = useName;
//		this.passWord = passWord;
//		this.email = email;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User(String useName, String passWord) {
		super();
		this.useName = useName;
		this.passWord = passWord;
	}
	public User(int id, String useName, String passWord) {
		super();
		this.id = id;
		this.useName = useName;
		this.passWord = passWord;
	}
	public String getUseName() {
		return useName;
	}
	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public User(String useName, String passWord,int id_nhanvien, String chucQuyen) {
		super();
		this.useName = useName;
		this.passWord = passWord;
		this.ID_nhanvien = id_nhanvien;
		this.chucQuyen =chucQuyen;
	}
	
	
	


	public User() {
		// TODO Auto-generated constructor stub
		super();
	}

}
