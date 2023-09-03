package Admin.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.NhanVienDAO;
import dao.UserDAO;
import details.MyButton;
import lib.AutoSuggestor;
import model.Mon;
import model.User;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class NhanVien extends JPanel {
	private HomeAdmin homeAdmin;
	private User user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTimKiem;
	private DefaultTableModel dtm;
	private JTable tblKhach;
	private MyButton btnThem ;
	private MyButton btnSua ;
	private MyButton btnXoa ;
	private int row = -1;
	String [] dieuKien = {"Lựa chọn","Sắp xếp từ A - Z", "Lọc theo giới tính Nam", "Lọc theo giới tính nữ"};
	

	public JTextField getTextField() {
		return txtTimKiem;
	}

	public void setTextField(JTextField textField) {
		this.txtTimKiem = textField;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public JTable getTblKhach() {
		return tblKhach;
	}

	public void setTblKhach(JTable tblKhach) {
		this.tblKhach = tblKhach;
	}

	/**
	 * Create the panel.
	 */
	public NhanVien(HomeAdmin homeAdmin, User user) {
		this.homeAdmin = homeAdmin;
		this.user = user;
		setLayout(null);
		setBackground(new Color(126, 177, 236));
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(243, 10, 488, 41);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(48, 84, 170, 26);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lọc theo:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(508, 84, 63, 26);
		add(lblNewLabel_1_1);
		
		 ArrayList<String> words = new ArrayList<>();
        ArrayList<model.NhanVien> listNhanVienAll = NhanVienDAO.getInstance().selectAll();
        for(model.NhanVien nhanVien : listNhanVienAll) {
        	words.add(nhanVien.getTen());
        }
		txtTimKiem = new JTextField();
		AutoSuggestor autoSuggestor = new AutoSuggestor(txtTimKiem,homeAdmin , words, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) ;
		
		txtTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AutoCompleteDecorator.decorate(textField, yourList);
				String ten = txtTimKiem.getText();
				System.out.println(ten);
				
				String condition = "Ten= '"+ten+"'";
				ArrayList<model.NhanVien> listNhanVien = NhanVienDAO.getInstance().selectByCondition(condition);
				if(listNhanVien.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có nhân viên tên "+ten+"!!!");
				}
				else {
					dtm.getDataVector().removeAllElements();
	            	dtm.fireTableDataChanged();
	            	row=-1;
	            	for(model.NhanVien nhanVien: listNhanVien)
					{
					 
						row++;
						dtm.setRowCount(row);
						
						Vector<String> vec = new Vector<String>();
//						vec.add(kh.getName());
						vec.add(row+1 +"");
//						vec.add(kh.getAge());
						vec.add(nhanVien.getTen());
//						vec.add(kh.getAddress());
						vec.add(nhanVien.getGioiTinh());
						vec.add(nhanVien.getSoDienThoai());
						vec.add(nhanVien.getEmail() + "");
						dtm.addRow(vec);
						
						
					}
						
					}
				
				
			}
		});
		txtTimKiem.setBounds(176, 87, 216, 26);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JPanel pnListNhanVien = new JPanel();
		pnListNhanVien.setBounds(31, 182, 900, 250);
		
		
		dtm = new DefaultTableModel();
		
		dtm.addColumn("Số thự tự");
		dtm.addColumn("Tên nhân viên");
		dtm.addColumn("Giới tính");
		dtm.addColumn("Số điện thoại");
		dtm.addColumn("Email");
		
//		dtm.getDataVector().removeAllElements();
//    	dtm.fireTableDataChanged();
//    	row=-1;
		 ArrayList<model.NhanVien> listNhanVien = NhanVienDAO.getInstance().selectAll();
		 for(model.NhanVien nhanVien: listNhanVien)
			{
			 
				row++;
				dtm.setRowCount(row);
				
				Vector<String> vec = new Vector<String>();
//				vec.add(kh.getName());
				vec.add(row+1 +"");
//				vec.add(kh.getAge());
				vec.add(nhanVien.getTen());
//				vec.add(kh.getAddress());
				vec.add(nhanVien.getGioiTinh());
				vec.add(nhanVien.getSoDienThoai());
				vec.add(nhanVien.getEmail() + "");
				dtm.addRow(vec);
				
				
			}
		
		pnListNhanVien.setLayout(new BorderLayout());
		
		tblKhach=new JTable(dtm);
//		tblKhach.setGridColor(Color.RED);
//		tblKhach.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
//		{
//		    @Override
//		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
//		    {
//		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//		        c.setBackground(row % 2 == 0 ? new Color(23, 176, 239) : Color.WHITE);
//		        return c;
//		    }
//		});
		tblKhach.setRowHeight(30);
		JScrollPane scTable = new JScrollPane(tblKhach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnListNhanVien.add(scTable, BorderLayout.CENTER);
		add(pnListNhanVien);
		
		
		JComboBox comboBox = new JComboBox(dieuKien);
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 if (e.getStateChange() == ItemEvent.SELECTED) {
			            Object item = e.getItem();
			            
			            if(item.equals("Sắp xếp từ A - Z")) {
			            	dtm.getDataVector().removeAllElements();
			            	dtm.fireTableDataChanged();
			            	row=-1;
			            	ArrayList<model.NhanVien> listAscNV = NhanVienDAO.getInstance().selectAlphaBetAsc();
			            	for(model.NhanVien nhanVien: listAscNV)
							{
							 
								row++;
								dtm.setRowCount(row);
								
								Vector<String> vec = new Vector<String>();
//								vec.add(kh.getName());
								vec.add(row+1 +"");
//								vec.add(kh.getAge());
								vec.add(nhanVien.getTen());
//								vec.add(kh.getAddress());
								vec.add(nhanVien.getGioiTinh());
								vec.add(nhanVien.getSoDienThoai());
								vec.add(nhanVien.getEmail() + "");
								dtm.addRow(vec);
								
								
							}
			            	
			            }
			            else if(item.equals("Lọc theo giới tính Nam")) {
			            	String condition = "GioiTinh= 'Nam'";
			            	ArrayList<model.NhanVien> listNhanVienNam = NhanVienDAO.getInstance().selectByCondition(condition);
			            	dtm.getDataVector().removeAllElements();
			            	dtm.fireTableDataChanged();
			            	row=-1;
			            	
			            	if(listNhanVienNam.isEmpty()) {
			            		dtm.getDataVector().removeAllElements();
				            	dtm.fireTableDataChanged();
				            	row=-1;
			            	}
			            	else {
			            		for(model.NhanVien nhanVien: listNhanVienNam) {
				            		row++;
									dtm.setRowCount(row);
									
									Vector<String> vec = new Vector<String>();
//									vec.add(kh.getName());
									vec.add(row+1 +"");
//									vec.add(kh.getAge());
									vec.add(nhanVien.getTen());
//									vec.add(kh.getAddress());
									vec.add(nhanVien.getGioiTinh());
									vec.add(nhanVien.getSoDienThoai());
									vec.add(nhanVien.getEmail() + "");
									dtm.addRow(vec);
				            	}
			            	}
			            	
			            }
			            else if(item.equals("Lọc theo giới tính nữ")) {
			            	String condition = "GioiTinh= 'Nữ'";
			            	ArrayList<model.NhanVien> listNhanVienNu = NhanVienDAO.getInstance().selectByCondition(condition);
			            	dtm.getDataVector().removeAllElements();
			            	dtm.fireTableDataChanged();
			            	row=-1;
			            	for(model.NhanVien nhanVien: listNhanVienNu) {
			            		row++;
								dtm.setRowCount(row);
								
								Vector<String> vec = new Vector<String>();
//								vec.add(kh.getName());
								vec.add(row+1 +"");
//								vec.add(kh.getAge());
								vec.add(nhanVien.getTen());
//								vec.add(kh.getAddress());
								vec.add(nhanVien.getGioiTinh());
								vec.add(nhanVien.getSoDienThoai());
								vec.add(nhanVien.getEmail() + "");
								dtm.addRow(vec);
			            	}
			            }
			            
			            else {
			            	
						 }
			            // do something with the selected item
			            
			        }
				
			    
				
			}
		});
		comboBox.setBounds(587, 84, 197, 26);
		add(comboBox);
		
		
		
		
		
		
		btnThem = new MyButton();
		btnThem.setText("Thêm");
		btnThem.setForeground(Color.white);
		btnThem.setRadius(30);
		btnThem.setBorder(null);
		btnThem.setColor(new Color(21, 51, 238));
		btnThem.setBorderColor(new Color(128,149,255));
		btnThem.setColorClick(new Color(77,77,255));
		btnThem.setColorOver(new Color(153,170,255));
		btnThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddNhanVien addNhanVienView = new AddNhanVien(user, homeAdmin);
				addNhanVienView.setVisible(true);
				
				
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(32, 508, 133, 40);
		add(btnThem);
		
		btnSua = new MyButton();
		btnSua.setText("Sửa");
		btnSua.setForeground(Color.white);
		btnSua.setRadius(30);
		btnSua.setBorder(null);
		btnSua.setColor(new Color(21, 51, 238));
		btnSua.setBorderColor(new Color(128,149,255));
		btnSua.setColorClick(new Color(77,77,255));
		btnSua.setColorOver(new Color(153,170,255));
		btnSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int rowSelected = tblKhach.getSelectedRow();
				System.out.println(tblKhach.getSelectedRow());
				if(rowSelected == -1)return ;
				String sdt = (String) tblKhach.getValueAt(rowSelected, 3);
				String conditionSDT = "SoDienThoai= "+sdt+"";
				ArrayList<model.NhanVien> nhanVienWithCondition = NhanVienDAO.getInstance().selectByCondition(conditionSDT);
				for(model.NhanVien nhanVien : nhanVienWithCondition)
				{
					
					SuaNhanVien suaNhanVienView = new SuaNhanVien(nhanVien, user, homeAdmin);
					suaNhanVienView.setVisible(true);
//					homeAdmin.setVisible(false);
//					NhanVienDAO.getInstance().delete(nhanVien);
//					dtm.removeRow(tblKhach.getSelectedRow());
//					
//					int ID_acc = nhanVien.getID_nhanvien();
//					System.out.println(ID_acc);
//					String conditionID_acc = "ID_Acc= "+ID_acc+"";
//					System.out.println(conditionID_acc);
//					ArrayList<User> acc = UserDAO.getInstance().selectByCondition(conditionID_acc);
//					for(User u: acc) {
//						UserDAO.getInstance().delete(u);
//						
//						System.out.println("Da vao day");
//					}
				}
				
				
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBounds(429, 508, 133, 40);
		add(btnSua);
		
		btnXoa = new MyButton();
		btnXoa.setText("Xóa");
		btnXoa.setForeground(Color.white);
		btnXoa.setRadius(30);
		btnXoa.setBorder(null);
		btnXoa.setColor(new Color(21, 51, 238));
		btnXoa.setBorderColor(new Color(128,149,255));
		btnXoa.setColorClick(new Color(77,77,255));
		btnXoa.setColorOver(new Color(153,170,255));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowSelected = tblKhach.getSelectedRow();
				System.out.println(tblKhach.getSelectedRow());
				if(rowSelected == -1)return ;
				String sdt = (String) tblKhach.getValueAt(rowSelected, 3);
				String conditionSDT = "SoDienThoai= "+sdt+"";
				ArrayList<model.NhanVien> nhanVienWithCondition = NhanVienDAO.getInstance().selectByCondition(conditionSDT);
				for(model.NhanVien nhanVien : nhanVienWithCondition)
				{
					
					NhanVienDAO.getInstance().delete(nhanVien);
					dtm.removeRow(tblKhach.getSelectedRow());
					
					int ID_acc = nhanVien.getID_nhanvien();
					System.out.println(ID_acc);
					String conditionID_acc = "ID_Acc= "+ID_acc+"";
					System.out.println(conditionID_acc);
					ArrayList<User> acc = UserDAO.getInstance().selectByCondition(conditionID_acc);
					for(User u: acc) {
						UserDAO.getInstance().delete(u);
						
						System.out.println("Da vao day");
					}
				}
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(798, 508, 133, 40);
		add(btnXoa);
	}
	

}
