package model;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class CustomerInfosModel {
	private JTextField textField_Name;
	private JTextField textField_Age;
	private JTextField textField_Address;
	private ButtonGroup buttonGroup_GioiTinh;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	private String name;
	public CustomerInfosModel(String name, String age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	private String age;
	private String address;
	private String sex;
	public JTextField getTextField_Name() {
		return textField_Name;
	}
	public void setTextField_Name(JTextField textField_Name) {
		this.textField_Name = textField_Name;
	}
	public CustomerInfosModel(JTextField textField_Name, JTextField textField_Age, JTextField textField_Address,
			ButtonGroup buttonGroup_GioiTinh) {
		super();
		this.textField_Name = textField_Name;
		this.textField_Age = textField_Age;
		this.textField_Address = textField_Address;
		this.buttonGroup_GioiTinh = buttonGroup_GioiTinh;
	}
	public JTextField getTextField_Age() {
		return textField_Age;
	}
	public void setTextField_Age(JTextField textField_Age) {
		this.textField_Age = textField_Age;
	}
	public JTextField getTextField_Address() {
		return textField_Address;
	}
	public void setTextField_Address(JTextField textField_Address) {
		this.textField_Address = textField_Address;
	}
	public ButtonGroup getButtonGroup_GioiTinh() {
		return buttonGroup_GioiTinh;
	}
	public void setButtonGroup_GioiTinh(ButtonGroup buttonGroup_GioiTinh) {
		this.buttonGroup_GioiTinh = buttonGroup_GioiTinh;
	}
	public CustomerInfosModel() {
		super();
	}
	
	
}