package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseListener;

public class Edit extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField editName;
	private JTextField editTable;
	private JComboBox editTime;
	public JComboBox getEditTime() {
		return editTime;
	}

	public void setEditTime(JComboBox editTime) {
		this.editTime = editTime;
	}

	public JTextField getEditName() {
		return editName;
	}

	public void setEditName(JTextField editName) {
		this.editName = editName;
	}

	public JTextField getEditTable() {
		return editTable;
	}

	public void setEditTable(JTextField editTable) {
		this.editTable = editTable;
	}

	public String[] getTime() {
		return time;
	}

	public void setTime(String[] time) {
		this.time = time;
	}

	private JButton btnHoanTat;
	private JButton btnHuy;
	private Schedule scheduleView;

	public Schedule getScheduleView() {
		return scheduleView;
	}

	public void setScheduleView(Schedule scheduleView) {
		this.scheduleView = scheduleView;
	}

	int rowSelected;
	String [] time = {"7:00pm", "8:00pm", "9:00pm"};

	/**
	 * Create the frame.
	 */
	public Edit(int rowSelected,Schedule scheduleView) {
		this.rowSelected = rowSelected;
		this.scheduleView = scheduleView;
		setResizable(false);
		setBounds(100, 100, 750, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Khách Hàng:");
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 51, 110, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblChnGi = new JLabel("Chọn Giờ:");
		lblChnGi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChnGi.setBounds(10, 112, 63, 29);
		contentPane.add(lblChnGi);
		
		JLabel lblChnBn = new JLabel("Chọn Bàn:");
		lblChnBn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChnBn.setBounds(10, 168, 79, 29);
		contentPane.add(lblChnBn);
		
		editName = new JTextField();
		editName.setText((String) scheduleView.getTblKhach().getValueAt(rowSelected,0 ));
		editName.setBounds(125, 50, 287, 35);
		contentPane.add(editName);
		editName.setColumns(10);
		
		editTime = new JComboBox(time);
		editTime.setBounds(125, 111, 171, 35);
		editTime.setSelectedItem(scheduleView.getTblKhach().getValueAt(rowSelected, 1));;
		contentPane.add(editTime);
		
		editTable = new JTextField();
		editTable.setText((String) scheduleView.getTblKhach().getValueAt(rowSelected,2 ));
		editTable.setColumns(10);
		editTable.setBounds(125, 168, 171, 35);
		contentPane.add(editTable);
		
		btnHoanTat = new JButton("Hoàn Tất");
		btnHoanTat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHoanTat.setBounds(62, 226, 137, 29);
		contentPane.add(btnHoanTat);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHuy.setBounds(483, 226, 137, 29);
		contentPane.add(btnHuy);
	}
	
	public void addHoanTatMouseListener(MouseListener action) {
		btnHoanTat.addMouseListener(action);
	}
	
	public void addHuyMouseListener(MouseListener action) {
		btnHuy.addMouseListener(action);
	}
}
