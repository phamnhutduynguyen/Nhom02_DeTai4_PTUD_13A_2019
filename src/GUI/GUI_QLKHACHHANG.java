package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import dao.DAO_KHACHHANG;
import entity.KHACHHANG;

public class GUI_QLKHACHHANG extends JFrame{
	
	private JLabel lblMa, lblTamtinh, lblTimTen, lblTimPhong, lblTimCMND, lblTimSDT, lblCMND, lblTen, lblGioitinh, lblSophong, lblSoluong, lblLoai, lblTinhtrang;
	private JTextField txtMa, txtTimTen, txtTimPhong,txtTimCMND, txtTimSDT, txtTamtinh,txtCMND, txtTen, txtNgayden, txtGiothue;
	private JComboBox<String> cbbLoai, cbbTinhtrang, cbbSophong;
	private JComboBox<Integer> cbbSoluong;
	private JCheckBox cbGioitinh;
	private JButton btnThem, btnHuy, btnSua, btnTim, btnXoaTrang, btnTimTen, btnTimSDT, btnTimCMND;
	private JTable table;
	private static DefaultTableModel model;
	private DAO_KHACHHANG daoKH = new DAO_KHACHHANG();

	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_QLKHACHHANG(JPanel pnQLPhong, JTabbedPane tabbedPane) throws ClassNotFoundException {
		//call function set_icon_Img of Home
		try {
			seticonApp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(GUI_DANGNHAP.class.getName()).log(Level.SEVERE, null, e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setTitle("QUẢN LÝ KHÁCH SẠN - ĐĂNG NHẬP");
		setSize(1280, 680);
		buildingUI(pnQLPhong, tabbedPane);	
//		addActions();
	}
	public void buildingUI(JPanel pnQLdatPhong, JTabbedPane tabbedPane) throws ClassNotFoundException {						
		
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		pnNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1,
		        1, 1, Color.blue), "THÔNG TIN KHÁCH HÀNG", TitledBorder.LEFT, TitledBorder.TOP));
		
		JPanel pn1stComp = new JPanel();
		pn1stComp.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		pn1stComp.add(lblMa = new JLabel("MÃ KHÁCH HÀNG:"));
		lblMa.setPreferredSize(new Dimension(130, 30));
		pn1stComp.add(txtMa = new JTextField());
		txtMa.setPreferredSize(new Dimension(200, 30));						
		
		pn1stComp.add(lblSoluong = new JLabel("SỐ ĐIỆN THOẠI:"));
		lblSoluong.setPreferredSize(new Dimension(130, 30));
		pn1stComp.add(txtCMND = new JTextField());
		txtCMND.setPreferredSize(new Dimension(200, 30));
		
		pn1stComp.add(lblGioitinh = new JLabel("NAM:"));
		lblGioitinh.setPreferredSize(new Dimension(60, 30));
		pn1stComp.add(cbGioitinh = new JCheckBox());
		
		pnNorth.add(pn1stComp);
		
		JPanel pn2ndComp = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		
		pn2ndComp.add(lblTen = new JLabel("TÊN KHÁCH HÀNG:"));
		lblTen.setPreferredSize(new Dimension(130, 30));
		pn2ndComp.add(txtTen = new JTextField());
		txtTen.setPreferredSize(new Dimension(200, 30));
		
		pn2ndComp.add(lblCMND = new JLabel("CMND/PASSPORE:"));
		lblCMND.setPreferredSize(new Dimension(130, 30));
		pn2ndComp.add(txtCMND = new JTextField());
		txtCMND.setPreferredSize(new Dimension(200, 30));
							
		pnNorth.add(pn2ndComp);
		
		JPanel pnButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//
		JPanel pnButtonTim = new JPanel();
		pnButtonTim.setLayout(new BoxLayout(pnButtonTim, BoxLayout.Y_AXIS));
		pnButtonTim.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1,
		        1, 1, Color.blue), "TÌM KIẾM", TitledBorder.LEFT, TitledBorder.TOP));		
		JPanel pnButtonTim1st = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		pnButtonTim1st.add(lblTimTen = new JLabel("TÌM TÊN"));
		pnButtonTim1st.add(txtTimTen = new JTextField());
		txtTimTen.setPreferredSize(new Dimension(150, 30));	
		pnButtonTim1st.add(btnTimTen = new JButton("TÌM"));
		
		pnButtonTim1st.add(lblTimSDT = new JLabel("TÌM SDT"));
		pnButtonTim1st.add(txtTimSDT = new JTextField());
		txtTimSDT.setPreferredSize(new Dimension(150, 30));	
		pnButtonTim1st.add(btnTimSDT = new JButton("TÌM"));	
		
		JPanel pnButtonTim2nd = new JPanel(new FlowLayout(FlowLayout.LEFT));				
		
		pnButtonTim2nd.add(lblTimCMND = new JLabel("TÌM CMND"));
		pnButtonTim2nd.add(txtTimCMND = new JTextField());
		txtTimCMND.setPreferredSize(new Dimension(150, 30));	
		pnButtonTim2nd.add(btnTimCMND = new JButton("TÌM"));		
		
//		pnButtonTim2nd.add(lblTimPhong = new JLabel("TÌM PHÒNG"));
//		pnButtonTim2nd.add(txtTimPhong = new JTextField());
//		txtTimPhong.setPreferredSize(new Dimension(150, 30));	
//		pnButtonTim2nd.add(btnTimPhong = new JButton("TÌM"));
		
		lblTimTen.setPreferredSize(lblTimCMND.getPreferredSize());
		lblTimSDT.setPreferredSize(lblTimCMND.getPreferredSize());
		
		JPanel pnButtonOthers = new JPanel();
		pnButtonOthers.setLayout(new BoxLayout(pnButtonOthers, BoxLayout.Y_AXIS));
		pnButtonOthers.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1,
		        1, 1, Color.blue), "CHỨC NĂNG KHÁC", TitledBorder.LEFT, TitledBorder.TOP));
		
		JPanel pnButton1stOthers = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pnButton1stOthers.add(btnThem = new JButton("THÊM KHÁCH HÀNG"));
		
		pnButton1stOthers.add(btnSua = new JButton("CẬP NHẬT"));
		
		JPanel pnButton2ndOthers = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pnButton2ndOthers.add(btnXoaTrang = new JButton("XÓA TRẮNG"));
		pnButton2ndOthers.add(btnHuy = new JButton("HỦY ĐĂNG KÝ"));		
		
		pnButtonTim.add(pnButtonTim1st);
		pnButtonTim.add(pnButtonTim2nd);
		pnButtonOthers.add(pnButton1stOthers);
		pnButtonOthers.add(pnButton2ndOthers);
		pnButton.add(pnButtonTim);
		pnButton.add(pnButtonOthers);
		
		pnQLdatPhong.add(pnNorth, BorderLayout.NORTH);
		pnQLdatPhong.add(pnButton, BorderLayout.CENTER);	
		//table
		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.Y_AXIS));
		
		String[] head = {"MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG","CMND/PASSPORE","SỐ ĐIỆN THOẠI", "GIỚI TÍNH"};
		JScrollPane scrollpane;
		pnTable.add(scrollpane = new JScrollPane(table = new JTable(model = new DefaultTableModel(head, 0)),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.SOUTH);
		scrollpane.setPreferredSize(new Dimension(1250, 300));
		tabbedPane.setForeground(Color.BLUE);
		
		pnQLdatPhong.add(pnTable);
		
		btnTimCMND.setPreferredSize(new Dimension(50, 30));
		btnTimSDT.setPreferredSize(new Dimension(50, 30));
		btnTimTen.setPreferredSize(new Dimension(50, 30));
		btnThem.setPreferredSize(new Dimension(150, 30));
		btnSua.setPreferredSize(new Dimension(150, 30));
		btnHuy.setPreferredSize(new Dimension(150, 30));
		btnXoaTrang.setPreferredSize(new Dimension(150, 30));
		
		btnThem.setForeground(Color.BLUE);
		btnTimCMND.setForeground(Color.BLUE);
		btnTimSDT.setForeground(Color.BLUE);
		btnTimTen.setForeground(Color.BLUE);
		btnSua.setForeground(Color.BLUE);
		btnHuy.setForeground(Color.BLUE);	
		btnXoaTrang.setForeground(Color.BLUE);	
	        
	    
	    ConnectDB.getInstance().connect();
	    DocNhanVien();
	}
	public void DocNhanVien() {

		List<KHACHHANG> list = daoKH.getalltbNhanVien();

		for (KHACHHANG nv : list) {
			model.addRow(new Object[] { nv.getMaKH(), nv.getTenKH(), nv.getCMND(), nv.getSDT(), nv.isGioiTinh()?"Nam":"Nu"});
		}
	}
}
