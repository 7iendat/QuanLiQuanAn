package Admin.view;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import dao.HoaDonDAO;
import model.HoaDon;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import java.awt.BasicStroke;
import java.awt.Color;

public class DoanhThu extends JPanel {
	private HomeAdmin homeAdminView;
	
	 public DoanhThu(HomeAdmin homeAdmin) {
		 this.homeAdminView = homeAdmin;
//			setLayout(null);
			
			setBackground(new Color(126, 177, 236));
	        initUI();
	    }

	    private void initUI() {

	        XYDataset dataset = createDataset();
	        JFreeChart chart = createChart(dataset);
	        setLayout(null);

	        ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setBounds(0, 0, 1022, 775);
	        chartPanel.setBorder(BorderFactory.createEmptyBorder(10,0,35,0));
//	        chartPanel.setBackground(new Color(126, 177, 236));
	        add(chartPanel);
	        chartPanel.setLayout(null);

//	        pack();
//	        setTitle("Line chart");
//	        setLocationRelativeTo(null);
//	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    private XYDataset createDataset() {

	    	ArrayList<HoaDon> listDoanhThu = HoaDonDAO.getInstance().getSumTotal();
	    	var series = new XYSeries("2023");
	    	
	    	for(HoaDon doanhThu: listDoanhThu) {
	    		int total = (int) doanhThu.getTongGia() ;
	    		int date = doanhThu.getDate();
	    		
//	    		series.add(date, total);
	    		series.add(total, date);
	    	}
//	        series.add(18, 567);
//	        series.add(20, 612);
//	        series.add(25, 800);
//	        series.add(30, 980);

	        var dataset = new XYSeriesCollection();
	        dataset.addSeries(series);

	        return dataset;
	    }

	    private JFreeChart createChart(XYDataset dataset) {

	        JFreeChart chart = ChartFactory.createXYLineChart(
	                "DOANH THU THEO NGÀY",
	                "TIỀN (VND)",
	                "NGÀY",
	                dataset,
	                PlotOrientation.VERTICAL,
	                true,
	                true,
	                false
	        );

	        XYPlot plot = chart.getXYPlot();

	        var renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesPaint(0, Color.RED);
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

	        plot.setRenderer(renderer);
	        plot.setBackgroundPaint(new Color(126, 177, 236));

	        plot.setRangeGridlinesVisible(true);
	        plot.setRangeGridlinePaint(Color.BLACK);

	        plot.setDomainGridlinesVisible(true);		
	        plot.setDomainGridlinePaint(Color.BLACK);

	        chart.getLegend().setFrame(BlockBorder.NONE);

	        chart.setTitle(new TextTitle("DOANH THU THEO NGÀY",
	                        new Font("Tahoma", java.awt.Font.BOLD, 25)
	                )
	        );

	        return chart;
	    }
	
//	private HomeAdmin homeAdminView;
//	/**
//	 * Create the panel.
//	 */
//	public DoanhThu(HomeAdmin homeAdmin) {
//		this.homeAdminView = homeAdmin;
//		setLayout(null);
//		
//		setBackground(new Color(126, 177, 236));
//		
//		JLabel lblNewLabel = new JLabel("DANH SÁCH MÓN ĂN");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
//		lblNewLabel.setBounds(234, 10, 582, 42);
//		add(lblNewLabel);
//		
//		JPanel pnListMOn = new JPanel(new GridLayout(4,0,10,10));
//		pnListMOn.setBackground(new Color(79, 79, 79));
//		pnListMOn.setBorder(new LineBorder(new Color(230, 230, 230), 2));
//		pnListMOn.setBounds(10, 80, 1002, 574);
//		
//		
////		JPanel panel_2 = new JPanel(new GridLayout(4,0,10,10));;
////		panel_2.setBackground(new Color(79, 79, 79));
////		panel_2.setBorder(new LineBorder(new Color(230, 230, 230), 2));
////		panel_2.setBounds(10, 57, 1017, 683);
//
//		
//		JScrollPane scrollPane = new JScrollPane(pnListMOn, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
//
//		
//		
//		for(int i = 0; i < 18; i++) {
//			VoucherDetail voucher = new VoucherDetail();
//			
//			pnListMOn.add(voucher);
//		}
//		
//		scrollPane.setBounds(10, 80, 1002, 574);
//		add(scrollPane);
//		
////		JPanel panel = new JPanel();
////		panel.setBackground(new Color(0, 128, 255));
////		panel.setBounds(79, 61, 233, 217);
////		add(panel);
////		panel.setLayout(null);
////		
////		JLabel lblNewLabel_1 = new JLabel("Tổng Doanh Thu");
////		lblNewLabel_1.setBounds(53, 171, 135, 22);
////		panel.add(lblNewLabel_1);
////		lblNewLabel_1.setForeground(new Color(255, 255, 255));
////		lblNewLabel_1.setBackground(new Color(255, 255, 255));
////		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
//
//	}
}
