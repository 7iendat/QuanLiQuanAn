package Admin.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.MonDAO;
import model.Mon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CapNhatMon extends JFrame {

	private HomeAdmin homeAdminView;
	private JPanel contentPane;
	private JTextField tfTenMon;
	private JTextField tfLoai;
	private JTextField tfGia;
	private JTextField tfAnh;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CapNhatMon(HomeAdmin homeAdminView) {
		this.homeAdminView = homeAdminView;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Mon> listMon = MonDAO.getInstance().selectAll();
		
		JComboBox comboBox = new JComboBox();
		
		for(Mon mon: listMon) {
			comboBox.addItem(mon.getTenMon());
		}
		comboBox.setBounds(202, 10, 274, 35);
		contentPane.add(comboBox);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Tên Món:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(103, 55, 94, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(103, 89, 94, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá cả:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(103, 123, 94, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ảnh minh họa:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(103, 157, 94, 24);
		contentPane.add(lblNewLabel_1_3);
		
		tfTenMon = new JTextField();
		tfTenMon.setBounds(205, 55, 291, 24);
		contentPane.add(tfTenMon);
		tfTenMon.setColumns(10);
		
		tfLoai = new JTextField();
		tfLoai.setColumns(10);
		tfLoai.setBounds(205, 89, 291, 24);
		contentPane.add(tfLoai);
		
		tfGia = new JTextField();
		tfGia.setColumns(10);
		tfGia.setBounds(205, 123, 291, 24);
		contentPane.add(tfGia);
		
		tfAnh = new JTextField();
		tfAnh.setColumns(10);
		tfAnh.setBounds(205, 157, 291, 24);
		contentPane.add(tfAnh);
		
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				 if (e.getStateChange() == ItemEvent.SELECTED) {
			            Object item = e.getItem();
			            System.out.println(item);
			            for(Mon mon: listMon)
			    		{
			    			if(mon.getTenMon().equals(item)) {
			    				tfTenMon.setText(mon.getTenMon());
			    				tfLoai.setText(mon.getLoai());
			    				tfGia.setText(mon.getDonGia() + "");
			    				tfAnh.setText(mon.getAnhMinhHoa());
			    			}
			    		}
			            // do something with the selected item
			        }
			    
				
			}
		});
		
//		for(Mon mon: listMon)
//		{
//			if(mon.getTenMon().equals(comboBox.getSelectedItem())) {
//				tfTenMon.setText(mon.getTenMon());
//				tfLoai.setText(mon.getLoai());
//				tfGia.setText(mon.getDonGia() + "");
//				tfAnh.setText(mon.getAnhMinhHoa());
//			}
//		}
		
		JButton btnNewButton = new JButton("Cập Nhật");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String tenMon = tfTenMon.getText();
				String loai = tfLoai.getText();
				float gia = Float.parseFloat(tfGia.getText());
				String anhMinhHoa = tfAnh.getText();
				
				
				String condition = "TenMon= '"+tenMon+"'";
				ArrayList<Mon> listMon = MonDAO.getInstance().selectByCondition(condition);
				
			
					for(Mon mon: listMon) {
						int id = mon.getId();
						Mon newMon = new Mon(id,tenMon, loai, gia, anhMinhHoa);
						
						MonDAO.getInstance().update(newMon);
						
						PnListMon pnListMon = new PnListMon(homeAdminView);
						homeAdminView.getPnRight().removeAll();
						homeAdminView.getPnRight().add(pnListMon);
						homeAdminView.getPnRight().validate();
						homeAdminView.getPnRight().repaint();
						JOptionPane.showMessageDialog(null, "Cập Nhập Món Thành Công");
					}
				}
//				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(84, 210, 129, 24);
		contentPane.add(btnNewButton);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHy.setBounds(446, 210, 129, 24);
		contentPane.add(btnHy);
		
		JLabel lblNewLabel = new JLabel("Chọn Tên Món:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(84, 12, 115, 24);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	}
}
