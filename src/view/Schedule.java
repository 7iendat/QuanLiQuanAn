package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import dao.LichDatDAO;
import details.MyButton;
import model.CustomerInfosModel;
import model.KhachHang;
import model.LichDat;
import model.User;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Schedule extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfName = new JTextField();
	private String[] seatSelected = new String [12];
	private JLabel [] arrlbl ; 
	private String[] arrSelected = new String[12];
	private JLabel lblTimeSelected = new JLabel();
	private Vector<CustomerInfosModel> khachHangs ;
	private MyButton btnDatBan;
	private MyButton btnCancel;
	private MyButton btnEdit;
	private MyButton btnNext;
	
	private String table = "";
	private int row = -1;
	public DefaultTableModel getDtm() {
		return dtm;
	}
	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

	private String stringTable ;
	
	private CustomerInfosModel customer;
	private User user;
	private DefaultTableModel dtm;
	private JTable tblKhach;
	public String[] getSeatSelected() {
		return seatSelected;
	}
	public void setSeatSelected(String[] seatSelected) {
		this.seatSelected = seatSelected;
	}

	/**
	 * Create the panel.
	 */
	String [] time = {"7:00pm", "8:00pm", "9:00pm"};
	JComboBox cboTime = new JComboBox(time);
	
	public JTextField getTfName() {
		return tfName;
	}
	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JLabel[] getArrlbl() {
		return arrlbl;
	}
	public void setArrlbl(JLabel[] arrlbl) {
		this.arrlbl = arrlbl;
	}
	public String[] getArrSelected() {
		return arrSelected;
	}
	public void setArrSelected(String[] arrSelected) {
		this.arrSelected = arrSelected;
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}

	
	
	public JComboBox getCboTime() {
		return cboTime;
	}
	public void setCboTime(JComboBox cboTime) {
		this.cboTime = cboTime;
	}
	
	private String currentKH;
	
	
	public String getCurrentKH() {
		return currentKH;
	}
	public void setCurrentKH(String currentKH) {
		this.currentKH = currentKH;
	}
	public Schedule(User user ) {
		this.user = user;
		
		arrlbl = new JLabel[12];
		setLayout(null);
		
		JLabel lblName = new JLabel("Please schedule your day and time:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setBounds(24, 0, 527, 56);
		add(lblName);
		
		JLabel lblNewLabel_4_1 = new JLabel("Chọn Giờ:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(24, 53, 112, 30);
		add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4 = new JLabel("Tên Khách Hàng:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(24, 93, 112, 30);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("LỊCH ĐẶT");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(772, 25, 146, 31);
		add(lblNewLabel_3);
		
		cboTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTimeSelected.setText(cboTime.getSelectedItem().toString());
			}
		});
		cboTime.setBounds(150, 55, 106, 30);
		add(cboTime);
		
		
		tfName.setBounds(150, 93, 225, 30);
		add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Please select your seat");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 152, 308, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(24, 204, 32, 30);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Already Booked");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(66, 210, 119, 24);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(new Color(0, 128, 255));
		lblNewLabel_1_1.setBounds(226, 204, 32, 30);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Seat Available");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(276, 210, 119, 24);
		add(lblNewLabel_2_1);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(34, 266, 594, 221);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 206, 221);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 2, 10, 9));
		
		JLabel lbl1 =  new JLabel("1");
		lbl1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl1.setOpaque(true);
		lbl1.setBackground(new Color(0, 128, 255));
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_1.add(lbl1);
		arrlbl[0] = lbl1;
		
		JLabel lbl2 = new JLabel("2");
		lbl2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl2.setOpaque(true);
		lbl2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl2.setBackground(new Color(0, 128, 255));
		panel_1.add(lbl2);
		
		arrlbl[1] = lbl2;
		
		JLabel lbl3 = new JLabel("3");
		lbl3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl3.setOpaque(true);
		lbl3.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl3.setBackground(new Color(0, 128, 255));
		panel_1.add(lbl3);
		arrlbl[2] = lbl3;
		
		JLabel lbl4 = new JLabel("4");
		lbl4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl4.setOpaque(true);
		lbl4.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl4.setBackground(new Color(0, 128, 255));
		panel_1.add(lbl4);
		
		arrlbl[3] = lbl4;
		
		JLabel lbl5 = new JLabel("5");
		lbl5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl5.setOpaque(true);
		lbl5.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl5.setBackground(new Color(0, 128, 255));
		panel_1.add(lbl5);
		arrlbl[4] = lbl5;
		
		JLabel lbl6 = new JLabel("6");
		
		lbl6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl6.setOpaque(true);
		lbl6.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl6.setBackground(new Color(0, 128, 255));
		panel_1.add(lbl6);
		arrlbl[5] = lbl6;
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(388, 0, 206, 221);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 2, 10, 9));
		
		JLabel lbl7 = new JLabel("7");
		lbl7.setOpaque(true);
		lbl7.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl7.setHorizontalAlignment(SwingConstants.CENTER);
		lbl7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl7.setBackground(new Color(0, 128, 255));
		panel_2.add(lbl7);
		arrlbl[6] = lbl7;
		
		JLabel lbl8 = new JLabel("8");
		lbl8.setOpaque(true);
		lbl8.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl8.setHorizontalAlignment(SwingConstants.CENTER);
		lbl8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl8.setBackground(new Color(0, 128, 255));
		panel_2.add(lbl8);
		arrlbl[7] = lbl8;
		
		JLabel lbl9 = new JLabel("9");
		lbl9.setOpaque(true);
		lbl9.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl9.setBackground(new Color(0, 128, 255));
		panel_2.add(lbl9);
		arrlbl[8] = lbl9;
		
		JLabel lbl10 = new JLabel("10");
		lbl10.setOpaque(true);
		lbl10.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl10.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl10.setBackground(new Color(0, 128, 255));
		panel_2.add(lbl10);
		arrlbl[9] = lbl10;
		
		JLabel lbl11 = new JLabel("11");
		lbl11.setOpaque(true);
		lbl11.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		lbl11.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl11.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl11.setBackground(new Color(0, 128, 255));
		panel_2.add(lbl11);
		arrlbl[10] = lbl11;
		
		JLabel lbl12 = new JLabel("12");
		lbl12.setOpaque(true);
		lbl12.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		lbl12.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl12.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl12.setBackground(new Color(0, 128, 255));
		panel_2.add(lbl12);
		arrlbl[11] = lbl12;
		
		

		btnNext = new MyButton();
		btnNext.setText("Next");
		btnNext.setRadius(30);
		btnNext.setForeground(Color.white);
		btnNext.setBorder(null);
		btnNext.setColor(new Color(253, 89, 30));
		btnNext.setBorderColor(new Color(128,149,255));
		btnNext.setColorClick(new Color(77,77,255));
		btnNext.setColorOver(new Color(153,170,255));
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnNext.setBackground(new Color(0, 128, 255));
		btnNext.setBounds(649, 583, 89, 38);
		add(btnNext);
		
		btnDatBan = new MyButton();
		btnDatBan.setText("Đặt Bàn");
		btnDatBan.setRadius(30);
		btnDatBan.setForeground(Color.white);
		btnDatBan.setBorder(null);
		btnDatBan.setColor(new Color(253, 89, 30));
		btnDatBan.setBorderColor(new Color(128,149,255));
		btnDatBan.setColorClick(new Color(77,77,255));
		btnDatBan.setColorOver(new Color(153,170,255));
		btnDatBan.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnDatBan.setBackground(new Color(128, 255, 128));
		btnDatBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		

		btnDatBan.setBounds(48, 520, 137, 40);
		add(btnDatBan);
		
		
		ArrayList<LichDat> lichDats = LichDatDAO.getInstance().innerJoinWithKhachHangTable();
		
		
		
		JPanel pnLichDat = new JPanel();
		pnLichDat.setLayout(new BorderLayout());
		dtm = new DefaultTableModel();
		dtm.addColumn("Tên");
		dtm.addColumn("Giờ đăt:");
		dtm.addColumn("Bàn đăt:");
		
		for(LichDat lichDat: lichDats)
		{
			row++;
			dtm.setRowCount(row);
			
			Vector<String> vec = new Vector<String>();
//			vec.add(kh.getName());
			vec.add(lichDat.getTenKH());
//			vec.add(kh.getAge());
			vec.add(lichDat.getGioDat());
//			vec.add(kh.getAddress());
			vec.add(lichDat.getBan());
			dtm.addRow(vec);
			
			
		}
//			setRow(getRow()+1);
//			getDtm().setRowCount(getRow());
//			
//			Vector<String> vec = new Vector<String>();
////			vec.add(kh.getName());
//			vec.add(getTfName().getText());
////			vec.add(kh.getAge());
//			vec.add(getCboTime().getSelectedItem().toString());
////			vec.add(kh.getAddress());
//			vec.add(getTable());
//			dtm.addRow(vec);
			
			

		
		
		tblKhach=new JTable(dtm);
		JScrollPane scTable = new JScrollPane(tblKhach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLichDat.add(scTable, BorderLayout.CENTER);
		pnLichDat.setBounds(669, 63, 343, 509);
		add(pnLichDat);
		
		btnEdit = new MyButton();
		btnEdit.setText("EDIT");
		btnEdit.setRadius(30);
		btnEdit.setForeground(Color.white);
		btnEdit.setBorder(null);
		btnEdit.setColor(new Color(253, 89, 30));
		btnEdit.setBorderColor(new Color(128,149,255));
		btnEdit.setColorClick(new Color(77,77,255));
		btnEdit.setColorOver(new Color(153,170,255));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnEdit.setBackground(new Color(0, 128, 255));
		btnEdit.setBounds(784, 583, 89, 38);
		add(btnEdit);
		
		btnCancel = new MyButton();
		btnCancel.setText("CANCEL");
		btnCancel.setRadius(30);
		btnCancel.setForeground(Color.white);
		btnCancel.setBorder(null);
		btnCancel.setColor(new Color(253, 89, 30));
		btnCancel.setBorderColor(new Color(128,149,255));
		btnCancel.setColorClick(new Color(77,77,255));
		btnCancel.setColorOver(new Color(153,170,255));
//		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnCancel.setBackground(new Color(0, 128, 255));
		btnCancel.setBounds(895, 583, 89, 38);
		add(btnCancel);
		
		
		for(int i = 0; i < 12; i++)
		{
			arrSelected[i] = "0";
			seatSelected[i] = "0";
		}
		
		ArrayList<KhachHang> listKH = KhachHangDAO.getInstance().innerJoinWithHoaDon();
		for(KhachHang kh: listKH) {
			String chuoiBan = kh.getBan();
			System.out.println(chuoiBan);
			if(kh.getTinhTrang().equals("Đã Thanh Toán")) {
				if(chuoiBan!= null)
				{
					String[] arrBan = chuoiBan.split(" ");
					
					for(String ban: arrBan) {
//						System.out.println(ban);
						if(!ban.isEmpty()) {
							for(int i = 0; i< 12;i++ ) {
//								System.out.println(arrlbl[i].getText().equals(ban));
//								System.out.println(ban);
								if(arrlbl[i].getText().equals(ban)) {
									arrlbl[i].enable(true);
									arrlbl[i].setBackground(new Color(0, 128, 255));	
									arrSelected[i] = "0";
									seatSelected[i] = "0";
								}
								else {
									System.out.println("KHong thanhcong");
								}
							}
						}
					}
				}
			}
			else {
				if(chuoiBan!= null)
				{
					String[] arrBan = chuoiBan.split(" ");
					
					for(String ban: arrBan) {
//						System.out.println(ban);
						if(!ban.isEmpty()) {
							
							
							for(int i = 0; i< 12;i++ ) {
								
								if(arrlbl[i].getText().equals(ban)) {
									
									arrlbl[i].enable(false);;
									arrlbl[i].setBackground(Color.gray);
									seatSelected[i] = ban;
									arrSelected[i] = "-1";
									
								}
								
								else {
									
								}
							}
					
						}
					}
				}
			}
		}
		
		
		
//		ArrayList<KhachHang> khachHangs = KhachHangDAO.getInstance().selectAll();
//		
//		for(KhachHang kh: khachHangs) {
//			String chuoiBan = kh.getBan();
//			if(chuoiBan!= null)
//			{
//				String[] arrBan = chuoiBan.split(" ");
//				
//				for(String ban: arrBan) {
////					System.out.println(ban);
//					if(!ban.isEmpty()) {
//						for(int i = 0; i< 12;i++ ) {
//							if(arrlbl[i].getText().equals(ban)) {
//								arrlbl[i].enable(false);
//								arrlbl[i].setBackground(Color.gray);
//								seatSelected[i] = ban;
//								arrSelected[i] = "-1";
//							}
//							else {
//							}
//						}
//					}
//				}
//			}
//		}
//		
//		ArrayList<KhachHang> listKH = KhachHangDAO.getInstance().innerJoinWithHoaDon();
//		for(KhachHang kh: listKH) {
//			String chuoiBan = kh.getBan();
//			System.out.println(chuoiBan);
//			if(chuoiBan!= null)
//			{
//				String[] arrBan = chuoiBan.split(" ");
//				
//				for(String ban: arrBan) {
////					System.out.println(ban);
//					if(!ban.isEmpty()) {
//						for(int i = 0; i< 12;i++ ) {
////							System.out.println(arrlbl[i].getText().equals(ban));
////							System.out.println(ban);
//							if(arrlbl[i].getText().equals(ban)) {
//								arrlbl[i].enable(true);
//								arrlbl[i].setBackground(new Color(0, 128, 255));	
//								arrSelected[i] = "0";
//								seatSelected[i] = "0";
//							}
//							else {
//								System.out.println("KHong thanhcong");
//							}
//						}
//					}
//				}
//			}
//		}
		
		for(int i = 0;  i < 12; i++)
		{
			arrlbl[i].addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					for(int i = 0; i < 12; i ++)
					{
						
						if(e.getSource() == arrlbl[i])
						{
							if(seatSelected[i] == "0"  && arrSelected[i] == "0" ) {
								arrlbl[i].setBackground(Color.red);
								arrSelected[i] = "1";
								seatSelected[i] = arrlbl[i].getText();
							}
							else if (seatSelected[i] != "0" && arrSelected[i] != "-1" )
							{
								arrlbl[i].setBackground(new Color(0, 128, 255));	
								arrSelected[i] = "0";
								seatSelected[i] = "0";
							}
							continue;
						}
					}
				}
			});
		}
		
	}
	
	public String getStringTable() {
		return stringTable;
	}
	public void setStringTable(String stringTable) {
		this.stringTable = stringTable;
	}
	public JTable getTblKhach() {
		return tblKhach;
	}
	public void setTblKhach(JTable tblKhach) {
		this.tblKhach = tblKhach;
	}
	public void addDatBanMouseListener(MouseListener action) {
		btnDatBan.addMouseListener(action);
	}
	
	public void addNextActionListener(ActionListener action) {
		btnNext.addActionListener(action);
	}
	
	public void addEditActionListener(ActionListener action) {
		btnEdit.addActionListener(action);
	}
	
	public void addCancelActionListener(ActionListener action) {
		btnCancel.addActionListener(action);
	}

	

}
