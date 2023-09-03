package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane; //Import vô để dùng được cái hiện thông báo ra màn hình

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date; //Import vô để dùng được những cái liên quan tới thời gian, ngày giờ,...
import java.text.NumberFormat; //Import vô để dùng được định dạng tiền tệ Việt Nam Đồng, nó bổ trợ cho cái Locale
import java.util.Locale; //Import vô để dùng được định dạng tiền tệ Việt Nam Đồng

import javax.swing.border.LineBorder;

import controller.DashboardController.DashboardController;
import dao.MonDAO;
import details.MonAnDetail;
import model.Mon;
import model.User;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.PrinterException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane; //Import vô để dùng được cái ImageIcon

public class DashboardView extends JFrame {
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	User user;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String time;
	String table;
	String tenKhach;
	public String getTenKhach() {
		return tenKhach;
	}

	public void setTenKhach(String tenKhach) {
		this.tenKhach = tenKhach;
	}

	private JButton btnReceipt;
	private int x = 0; //Biến đếm số lượng đồ
	private double tax = 0.000; //Biến thuế lúc ban đầu
	int dX, dY; //Hai biến lấy tọa độ để kéo thả cái menu
	
	private JPanel contentPane;
	private JTextField textFieldTax;
	private JTextField textFieldSubTotal;
	private JTextField textFieldTotal;
	private JLabel lblNewLabel;
	
	private JLabel txTime;
	private JLabel txtDate;
	private JTextArea textArea;
	
	private double total = 0.000;

	private JButton btnTotal;
	private JButton btnExit ;
	private JButton btnReset ;
	private JPanel panel_1;
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public String getTable() {
		return table;
	}

	public JButton getBtnTotal() {
		return btnTotal;
	}

	public void setBtnTotal(JButton btnTotal) {
		this.btnTotal = btnTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	//Phương thức kiểm tra xem số lượng món ăn trong menu có bằng 0 hay không
	public boolean qtyIsZero(int qty) {
		if(qty == 0) {
			JOptionPane.showMessageDialog(null, "Mời tăng số lượng món");
			return false;
		}
		return true;
	}
	
	//Phương thức cho ra thuế má
	public void getTax(double t) {
		Locale locale = new Locale("vi", "VN"); //Khởi tạo locale định dạng kiểu VN
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale); //Định dạng kiểu số cho biến locale phía trên
		if(t >= 10000 && t <= 20000) {
			tax = 0500;
		}else if(t > 20.000 && t <= 40000){
			tax = 1000;
		}else if(t > 40000 && t <= 60000){
			tax = 2000;
		}else if(t > 60000 && t <= 80000){
			tax = 3000;
		}else if(t > 80000 && t <= 100000){
			tax = 4000;
		}else if(t > 100000 && t <= 300000){
			tax = 8000;
		}else if(t > 300000 && t <= 500000){
			tax = 12000;
		}else if(t > 500000) {
			tax = 15000;
		}
	}
	
	//Phương thức khởi tạo thời gian
	public void setTime() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Date date = new Date();
					SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
					SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
					String time = tf.format(date);
					txTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
					txtDate.setText(df.format(date));
				}				
			}
		}).start();
	}
	
	//Phương thức hiện ra thông tin hóa đơn
	public void spicyNoodleSeoul(String table) {
		
		
		int purchaseID = 15020 + (int)(Math.random() * 80800);
		String tableSeleced = table;//Tạo ngẫu nhiên ra một con số để làm mã hóa đơn
		textArea.setText("**************************** Seoul ****************************\n"
				+ "Time: " + txTime.getText() + ", Date: " + txtDate.getText() + "\n"
				+ "Mã thanh toán: " + purchaseID + "\n"
				+ "Bàn số: " + tableSeleced + "\n"
				+ "****************************************************************\n"
				+ "Tên vật phẩm:\t\t\t" + "Giá (VND)\n");
	}
	//Phương thức khởi tạo lại cái menu
	public void reset() {
		total = 0.000; //Set giá trị tổng về là 0.000
		x = 0; //Set số lượng món về là 0
		tax = 0.000; //Set giá trị thuế về là 0.000
		btnTotal.setEnabled(true); //Hiện lại cái nút nhấn cho chúng ta nhấn vào
		
		textFieldTax.setText("0.000"); //Set giá trị thuế lại là 0.000
		textFieldSubTotal.setText("0.000"); //Set giá trị tổng phụ lại là 0.000
		textFieldTotal.setText("0.000"); //Set giá trị tổng lại là 0.000
		textArea.setText(" "); //Reset cái thông tin hóa đơn lại
	}
	
	//Phương thức show ra màn hình thuế, tổng phụ và tổng
	public void duDate() {
		Locale locale = new Locale("vi", "VN"); //Khởi tạo locale định dạng kiểu VN
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale); //Định dạng kiểu số cho biến locale phía trên
		textFieldTax.setText(String.valueOf(numberFormat.format(tax)));
		textFieldSubTotal.setText(String.valueOf(numberFormat.format(total)));
		textFieldTotal.setText(String.valueOf(numberFormat.format(total + tax)));	
	}
	
	//Phương thức khởi tạo
		public void init() {
//			setImage();
			
			setTime();
		}
		public DashboardView(String table,User user) {
			this.table = table;
			this.user = user;
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (contains(e.getPoint())) {
			            dX = e.getLocationOnScreen().x - getX(); //Lấy tọa độ X
			            dY = e.getLocationOnScreen().y - getY(); //Lấy tọa độ Y
			            setVisible(true); //Cho nó giá trị true là hiện lên màn hình khi nhấn chuột vào
			        }
				}
			});
			
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					if (isDisplayable()) { //Nếu nó hiện trên màn hình
						setLocation(e.getLocationOnScreen().x - dX, e.getLocationOnScreen().y - dY); //Set lại vị trí khi mà mình kéo thả
			            dX = e.getLocationOnScreen().x - getX(); //Cập nhật lại tọa độ X
			            dY = e.getLocationOnScreen().y - getY(); //Cập nhật lại tọa độ Y
			        }
				}
			});
			
			//Phương thức chờ một thời gian để ứng dụng hiện lên màn hình
			addWindowListener(new WindowAdapter() {
				public void windowOpened(WindowEvent e) {
					for(double i = 0.0; i <= 1.0; i += 0.1) { //Các con số trong điều kiện vòng lặp for là giá trị độ mờ
						String s = i + ""; //Cho độ mờ chuyển tiếp liên tục
						float f = Float.valueOf(s); //Cho biến f giữ giá trị độ mờ 
						setOpacity(f); //Set độ mờ nhờ biến f
						try {
							Thread.sleep(40);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			
			setUndecorated(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 0, 450, 300);
			this.setSize(1360, 830); //Chỉnh kích thước cho khung giao diện chính
			
			contentPane = new JPanel();	
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(79, 79, 79));
			panel.setBorder(new LineBorder(new Color(230, 230, 230), 2));
			panel.setBounds(0, 0, 1360, 820);
			contentPane.add(panel);
			panel.setLayout(null);

			panel_1 = new JPanel();
			panel_1.setForeground(new Color(0, 0, 0));
			panel_1.setBackground(new Color(0, 0, 0));
			panel_1.setBounds(0, 0, 1360, 53);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			lblNewLabel = new JLabel("");
			// Chèn ảnh logo vào đầu menu
			lblNewLabel.setIcon(new ImageIcon(DashboardView.class.getResource("/images/spicy_noodles_logo.jpg")));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("VNI-Franko", Font.BOLD, 30));
			lblNewLabel.setBounds(0, 0, 520, 53);
			panel_1.add(lblNewLabel);
			
			//Chèn tên quán vào đầu menu
			JLabel lblNewLabel_9 = new JLabel("Mì Cay Seoul");
			lblNewLabel_9.setOpaque(true);
			lblNewLabel_9.setForeground(new Color(255, 255, 255));
			lblNewLabel_9.setBackground(new Color(0, 0, 0));
			lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_9.setFont(new Font("VNI-Couri", Font.BOLD, 20));
			lblNewLabel_9.setBounds(648, 0, 303, 53);
			panel_1.add(lblNewLabel_9);
			
			//Tạo label hiển thị ngày tháng năm
			txtDate = new JLabel("");
			txtDate.setForeground(new Color(255, 255, 255));
			txtDate.setFont(new Font("Times New Roman", Font.BOLD, 16));
			txtDate.setBounds(1181, 0, 179, 53);
			panel_1.add(txtDate);
			
			//Tạo label hiển thị giờ giấc
			txTime = new JLabel("");
			txTime.setForeground(new Color(255, 255, 255));
			txTime.setFont(new Font("Times New Roman", Font.BOLD, 16));
			txTime.setBounds(1023, 0, 116, 53);
			panel_1.add(txTime);
			
			JPanel panel_2 = new JPanel(new GridLayout(4,0,10,10));;
			panel_2.setBackground(new Color(79, 79, 79));
			panel_2.setBorder(new LineBorder(new Color(230, 230, 230), 2));
			panel_2.setBounds(10, 57, 1017, 683);

			
			JScrollPane scrollPane = new JScrollPane(panel_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

			ArrayList<Mon> listMon = MonDAO.getInstance().selectAll();
			
			for(Mon mon: listMon) {
				MonAnDetail monAn = new MonAnDetail(mon);
				DashboardController monAnController = new DashboardController(monAn, this);
				panel_2.add(monAn);
			}
			
			scrollPane.setBounds(10, 57, 1017, 683);
			panel.add(scrollPane);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBorder(new LineBorder(new Color(230, 230, 230), 2));
			panel_4.setBackground(new Color(79, 79, 79));
			panel_4.setBounds(10, 748, 1017, 67);
			panel.add(panel_4);
			panel_4.setLayout(null);
			
			btnTotal = new JButton("Tổng cộng");
			btnTotal.setForeground(new Color(255, 255, 255));
			btnTotal.setBackground(new Color(0, 0, 0));
			btnTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnTotal.setBounds(10, 10, 128, 47);
			panel_4.add(btnTotal);
			
			btnReceipt = new JButton("Biên lai");
			btnReceipt.setForeground(new Color(255, 255, 255));
			btnReceipt.setBackground(new Color(0, 0, 0));
			btnReceipt.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnReceipt.setBounds(148, 10, 128, 47);
			panel_4.add(btnReceipt);
			
			//Nút reset lại
			btnReset = new JButton("Cài đặt lại");
			btnReset.setForeground(new Color(255, 255, 255));
			btnReset.setBackground(new Color(0, 0, 0));
			btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnReset.setBounds(286, 10, 128, 47);
			panel_4.add(btnReset);
			
			//Nút nhập thông tin khách hàng
			JButton btnEnterInfos = new JButton("Nhập thông tin khách hàng");
			btnEnterInfos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CustomerInfosView ci = new CustomerInfosView(user, table);
					
					ci.setVisible(true);
				}
			});
			
			btnEnterInfos.setForeground(Color.WHITE);
			btnEnterInfos.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnEnterInfos.setBackground(Color.BLACK);
			btnEnterInfos.setBounds(424, 10, 280, 47);
			panel_4.add(btnEnterInfos);
			
			//Nút thoát ứng dụng
			btnExit = new JButton("Quay lại");
			btnExit.setForeground(new Color(255, 255, 255));
			btnExit.setBackground(new Color(0, 0, 0));
			btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnExit.setBounds(714, 10, 128, 47);
			panel_4.add(btnExit);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBackground(new Color(204, 204, 204));
			panel_5.setBounds(1037, 125, 313, 690);
			panel.add(panel_5);
			panel_5.setLayout(null);
			
			textArea = new JTextArea();
			textArea.setBounds(0, 0, 313, 512);
			panel_5.add(textArea);
			
			JScrollPane scrollPane1 = new JScrollPane(textArea);
			scrollPane1.setBounds(0, 0, 330, 512);
			panel_5.add(scrollPane1);
			
			textFieldTax = new JTextField();
			textFieldTax.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldTax.setEditable(false);
			textFieldTax.setText("0.000");
			textFieldTax.setFont(new Font("Times New Roman", Font.BOLD, 20));
			textFieldTax.setBounds(140, 522, 153, 35);
			panel_5.add(textFieldTax);
			textFieldTax.setColumns(10);
			
			textFieldSubTotal = new JTextField();
			textFieldSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldSubTotal.setText("0.000");
			textFieldSubTotal.setEditable(false);
			textFieldSubTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
			textFieldSubTotal.setColumns(10);
			textFieldSubTotal.setBounds(140, 584, 153, 35);
			panel_5.add(textFieldSubTotal);
			
			textFieldTotal = new JTextField();
			textFieldTotal.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldTotal.setText("0.000");
			textFieldTotal.setEditable(false);
			textFieldTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
			textFieldTotal.setColumns(10);
			textFieldTotal.setBounds(140, 645, 153, 35);
			panel_5.add(textFieldTotal);
			
			JLabel lblNewLabel_3 = new JLabel("Thuế(VND):");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
			lblNewLabel_3.setBounds(10, 527, 90, 24);
			panel_5.add(lblNewLabel_3);
			
			JLabel lblNewLabel_3_1 = new JLabel("Tổng phụ(VND):");
			lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
			lblNewLabel_3_1.setBounds(10, 587, 120, 29);
			panel_5.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_3_1_1 = new JLabel("Tổng(VND):");
			lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
			lblNewLabel_3_1_1.setBounds(10, 648, 90, 29);
			panel_5.add(lblNewLabel_3_1_1);
			
			init(); //Gọi phương thức khởi tạo "init()" để khởi tạo ra một số thành phần
			
			setVisible(true);
		}
		
		
	//Tạo frame
	public DashboardView(String table,String time,String tenKhach,  User user) {
		this.table = table;
		this.time = time;
		this.tenKhach = tenKhach;
		this.user = user;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (contains(e.getPoint())) {
		            dX = e.getLocationOnScreen().x - getX(); //Lấy tọa độ X
		            dY = e.getLocationOnScreen().y - getY(); //Lấy tọa độ Y
		            setVisible(true); //Cho nó giá trị true là hiện lên màn hình khi nhấn chuột vào
		        }
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (isDisplayable()) { //Nếu nó hiện trên màn hình
					setLocation(e.getLocationOnScreen().x - dX, e.getLocationOnScreen().y - dY); //Set lại vị trí khi mà mình kéo thả
		            dX = e.getLocationOnScreen().x - getX(); //Cập nhật lại tọa độ X
		            dY = e.getLocationOnScreen().y - getY(); //Cập nhật lại tọa độ Y
		        }
			}
		});
		
		//Phương thức chờ một thời gian để ứng dụng hiện lên màn hình
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				for(double i = 0.0; i <= 1.0; i += 0.1) { //Các con số trong điều kiện vòng lặp for là giá trị độ mờ
					String s = i + ""; //Cho độ mờ chuyển tiếp liên tục
					float f = Float.valueOf(s); //Cho biến f giữ giá trị độ mờ 
					setOpacity(f); //Set độ mờ nhờ biến f
					try {
						Thread.sleep(40);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 450, 300);
		this.setSize(1360, 830); //Chỉnh kích thước cho khung giao diện chính
		
		contentPane = new JPanel();	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(79, 79, 79));
		panel.setBorder(new LineBorder(new Color(230, 230, 230), 2));
		panel.setBounds(0, 0, 1360, 820);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1360, 53);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("");
		// Chèn ảnh logo vào đầu menu
		lblNewLabel.setIcon(new ImageIcon(DashboardView.class.getResource("/images/spicy_noodles_logo.jpg")));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("VNI-Franko", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 520, 53);
		panel_1.add(lblNewLabel);
		
		//Chèn tên quán vào đầu menu
		JLabel lblNewLabel_9 = new JLabel("Mì Cay Seoul");
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBackground(new Color(0, 0, 0));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("VNI-Couri", Font.BOLD, 20));
		lblNewLabel_9.setBounds(648, 0, 303, 53);
		panel_1.add(lblNewLabel_9);
		
		//Tạo label hiển thị ngày tháng năm
		txtDate = new JLabel("");
		txtDate.setForeground(new Color(255, 255, 255));
		txtDate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtDate.setBounds(1181, 0, 179, 53);
		panel_1.add(txtDate);
		
		//Tạo label hiển thị giờ giấc
		txTime = new JLabel("");
		txTime.setForeground(new Color(255, 255, 255));
		txTime.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txTime.setBounds(1023, 0, 116, 53);
		panel_1.add(txTime);
		
		JPanel panel_2 = new JPanel(new GridLayout(4,0,10,10));;
		panel_2.setBackground(new Color(79, 79, 79));
		panel_2.setBorder(new LineBorder(new Color(230, 230, 230), 2));
		panel_2.setBounds(10, 57, 1017, 683);

		
		JScrollPane scrollPane = new JScrollPane(panel_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

		ArrayList<Mon> listMon = MonDAO.getInstance().selectAll();
		
		for(Mon mon: listMon) {
			MonAnDetail monAn = new MonAnDetail(mon);
			DashboardController monAnController = new DashboardController(monAn, this);
			panel_2.add(monAn);
		}
		
		scrollPane.setBounds(10, 57, 1017, 683);
		panel.add(scrollPane);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(230, 230, 230), 2));
		panel_4.setBackground(new Color(79, 79, 79));
		panel_4.setBounds(10, 748, 1017, 67);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		btnTotal = new JButton("Tổng cộng");
		btnTotal.setForeground(new Color(255, 255, 255));
		btnTotal.setBackground(new Color(0, 0, 0));
		btnTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTotal.setBounds(10, 10, 128, 47);
		panel_4.add(btnTotal);
		
		btnReceipt = new JButton("Biên lai");
		btnReceipt.setForeground(new Color(255, 255, 255));
		btnReceipt.setBackground(new Color(0, 0, 0));
		btnReceipt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReceipt.setBounds(148, 10, 128, 47);
		panel_4.add(btnReceipt);
		
		//Nút reset lại
		btnReset = new JButton("Cài đặt lại");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(0, 0, 0));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(286, 10, 128, 47);
		panel_4.add(btnReset);
		
		//Nút nhập thông tin khách hàng
		JButton btnEnterInfos = new JButton("Nhập thông tin khách hàng");
		btnEnterInfos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInfosView ci = new CustomerInfosView(user,time,tenKhach, table);
				System.out.println(tenKhach);
				ci.setVisible(true);
			}
		});
		
		btnEnterInfos.setForeground(Color.WHITE);
		btnEnterInfos.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEnterInfos.setBackground(Color.BLACK);
		btnEnterInfos.setBounds(424, 10, 280, 47);
		panel_4.add(btnEnterInfos);
		
		//Nút thoát ứng dụng
		btnExit = new JButton("Quay lại");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnExit.setBounds(714, 10, 128, 47);
		panel_4.add(btnExit);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 204, 204));
		panel_5.setBounds(1037, 125, 313, 690);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 313, 512);
		panel_5.add(textArea);
		
		JScrollPane scrollPane1 = new JScrollPane(textArea);
		scrollPane1.setBounds(0, 0, 330, 512);
		panel_5.add(scrollPane1);
		
		textFieldTax = new JTextField();
		textFieldTax.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTax.setEditable(false);
		textFieldTax.setText("0.000");
		textFieldTax.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textFieldTax.setBounds(140, 522, 153, 35);
		panel_5.add(textFieldTax);
		textFieldTax.setColumns(10);
		
		textFieldSubTotal = new JTextField();
		textFieldSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSubTotal.setText("0.000");
		textFieldSubTotal.setEditable(false);
		textFieldSubTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textFieldSubTotal.setColumns(10);
		textFieldSubTotal.setBounds(140, 584, 153, 35);
		panel_5.add(textFieldSubTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotal.setText("0.000");
		textFieldTotal.setEditable(false);
		textFieldTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(140, 645, 153, 35);
		panel_5.add(textFieldTotal);
		
		JLabel lblNewLabel_3 = new JLabel("Thuế(VND):");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3.setBounds(10, 527, 90, 24);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tổng phụ(VND):");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3_1.setBounds(10, 587, 120, 29);
		panel_5.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Tổng(VND):");
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_3_1_1.setBounds(10, 648, 90, 29);
		panel_5.add(lblNewLabel_3_1_1);
		
		init(); //Gọi phương thức khởi tạo "init()" để khởi tạo ra một số thành phần
		
		setVisible(true);
	}
	
	public void addTotalActionListener(ActionListener action) {
		btnTotal.addActionListener(action);
	}
	
	public void addReceiptActionListener(ActionListener action)
	{
		btnReceipt.addActionListener(action);
	}
	
	public void addResetActionListener(ActionListener action) {
		btnReset.addActionListener(action);
	}
	
	public void addExitActionListener(ActionListener action) {
		btnExit.addActionListener(action);
	}
}