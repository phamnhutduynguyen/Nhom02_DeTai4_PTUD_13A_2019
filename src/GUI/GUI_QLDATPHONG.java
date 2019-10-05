package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import dao.DAO_HDPHONG;
import dao.DAO_KHACHHANG;
import dao.DAO_PHONG;
import entity.KHACHHANG;
import entity.PHONG;

public class GUI_QLDATPHONG extends JFrame{
	
	private JLabel lblTimTen, lblTimPhong, lblTimCMND, lblTimSDT, lblMaHD, lblSDT, lblTenKH, lblMaNV,lblCMND, lblTen, lblNgayden, lblGiothue, lblSophong, lblSoluong, lblLoai, lblTinhtrang;
	private JTextField txtTimTen, txtTimPhong,txtTimCMND, txtTimSDT, txtMa, txtSDT, txtTenKH, txtMaNV,txtCMND, txtTen, txtNgayden, txtGiothue;
	private JComboBox<String> cbbMaHD, cbbSDT, cbbTenKH, cbbTinhtrang, cbbSophong, cbbMaKH,cbbCMND;
	private JComboBox<Integer> cbbSoluong;
	private JButton btnThem, btnThongKe, btnXoaTrang, btnTraPhong,btnHuy, btnSua, btnTimPhong, btnTimTen, btnTimSDT, btnTimCMND, btnThoat, btnTrove, btnGio, btnNgay;
	private JTable table;
	private static DefaultTableModel model;
	private SimpleDateFormat formatday = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date date = new Date();
	private DAO_PHONG phong = new DAO_PHONG();
	private DAO_KHACHHANG khachHang = new DAO_KHACHHANG();
	private DAO_HDPHONG hoaDonPhong = new DAO_HDPHONG();

	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_QLDATPHONG(JPanel pnQLPhong, JTabbedPane tabbedPane) {
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
		addActions();
	}
	public void buildingUI(JPanel pnQLdatPhong, JTabbedPane tabbedPane) {
		
		//comp - north						
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		pnNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1,
		        1, 1, Color.blue), "THÔNG TIN ĐẶT PHÒNG", TitledBorder.LEFT, TitledBorder.TOP));
		
		JPanel pn1stComp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pn1stComp.add(lblMaNV = new JLabel("MÃ NHÂN VIÊN:"));
		lblMaNV.setPreferredSize(new Dimension(130, 30));
		pn1stComp.add(txtMaNV = new JTextField());
		txtMaNV.setPreferredSize(new Dimension(150, 30));
		txtMaNV.setText(GUI_DANGNHAP.nvLogin);
		txtMaNV.setEditable(false);		
		
		pn1stComp.add(lblTen = new JLabel("MÃ KHÁCH HÀNG:"));
		lblTen.setPreferredSize(new Dimension(130, 30));
		pn1stComp.add(cbbMaKH = new JComboBox<String>());
		cbbMaKH.setPreferredSize(new Dimension(200, 30));
		
		pn1stComp.add(lblTenKH = new JLabel("TÊN KHÁCH HÀNG:"));
		lblTenKH.setPreferredSize(new Dimension(130, 30));
		pn1stComp.add(cbbTenKH = new JComboBox<String>());
		cbbTenKH.setPreferredSize(new Dimension(200, 30));							
		
		pn1stComp.add(lblMaHD = new JLabel("MÃ HÓA ĐƠN:"));
		lblMaHD.setPreferredSize(new Dimension(130, 30));
		pn1stComp.add(cbbMaHD = new JComboBox<String>());
		cbbMaHD.setPreferredSize(new Dimension(150, 30));							
		
		pnNorth.add(pn1stComp);
		
		JPanel pn2ndComp = new JPanel();
		pn2ndComp.setLayout(new FlowLayout(FlowLayout.LEFT));	
		
		pn2ndComp.add(lblSophong = new JLabel("SỐ PHÒNG"));		
		lblSophong.setPreferredSize(new Dimension(130, 30));
		pn2ndComp.add(cbbSophong = new JComboBox<String>());
		cbbSophong.setPreferredSize(new Dimension(150, 30));
		
//		pn2ndComp.add(btnNgay = new JButton("NGÀY ĐẶT:"));
//		btnNgay.setPreferredSize(new Dimension(130, 30));	
//		btnNgay.setBorder(new LineBorder(Color.GRAY));
//		btnNgay.setBorderPainted(false);
//		pn2ndComp.add(txtNgayden = new JTextField());	
//		txtNgayden.setPreferredSize(new Dimension(200, 30));		
//		txtNgayden.setEditable(false);
		
		pn2ndComp.add(lblCMND = new JLabel("CMND/PASSPORE:"));
		lblCMND.setPreferredSize(new Dimension(130, 30));
		pn2ndComp.add(cbbCMND = new JComboBox<String>());
		cbbCMND.setPreferredSize(new Dimension(200, 30));				
		
		pn2ndComp.add(lblLoai = new JLabel("SỐ ĐIỆN THOẠI"));
		lblLoai.setPreferredSize(new Dimension(130, 30));
		pn2ndComp.add(cbbSDT = new JComboBox<String>());
		cbbSDT.setPreferredSize(new Dimension(200, 30));					
		
		pn2ndComp.add(lblTinhtrang = new JLabel("TÌNH TRẠNG"));
		lblTinhtrang.setPreferredSize(new Dimension(130, 30));
		pn2ndComp.add(cbbTinhtrang = new JComboBox<String>());
		cbbTinhtrang.setPreferredSize(new Dimension(150, 30));				
		cbbTinhtrang.addItem("ORDERED");
		cbbTinhtrang.addItem("PAID");
		pnNorth.add(pn2ndComp);	
		
		JPanel pnButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
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
		
		pnButtonTim2nd.add(lblTimPhong = new JLabel("TÌM PHÒNG"));
		pnButtonTim2nd.add(txtTimPhong = new JTextField());
		txtTimPhong.setPreferredSize(new Dimension(150, 30));	
		pnButtonTim2nd.add(btnTimPhong = new JButton("TÌM"));
		
		lblTimTen.setPreferredSize(lblTimCMND.getPreferredSize());
		lblTimSDT.setPreferredSize(lblTimPhong.getPreferredSize());
		
		JPanel pnButtonOthers = new JPanel();
		pnButtonOthers.setLayout(new BoxLayout(pnButtonOthers, BoxLayout.Y_AXIS));
		pnButtonOthers.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1,
		        1, 1, Color.blue), "CHỨC NĂNG KHÁC", TitledBorder.LEFT, TitledBorder.TOP));
		
		JPanel pnButton1stOthers = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pnButton1stOthers.add(btnThem = new JButton("THÊM KHÁCH HÀNG"));
		pnButton1stOthers.add(btnXoaTrang = new JButton("XÓA TRẮNG"));
		pnButton1stOthers.add(btnSua = new JButton("CẬP NHẬT"));
		
		JPanel pnButton2ndOthers = new JPanel(new FlowLayout(FlowLayout.LEFT));	
		pnButton2ndOthers.add(btnHuy = new JButton("HỦY ĐĂNG KÝ"));		
		pnButton2ndOthers.add(btnTraPhong = new JButton("TRẢ PHÒNG"));
		pnButton2ndOthers.add(btnThongKe = new JButton("THỐNG KÊ"));
		
		pnButtonTim.add(pnButtonTim1st);
		pnButtonTim.add(pnButtonTim2nd);
		pnButtonOthers.add(pnButton1stOthers);
		pnButtonOthers.add(pnButton2ndOthers);
		pnButton.add(pnButtonTim);
		pnButton.add(pnButtonOthers);
									
		//table
	    JPanel pnTable = new JPanel(new FlowLayout(FlowLayout.LEFT));
		String[] head = {"NGÀY ĐẶT", "MÃ NHÂN VIÊN", "MÃ KHÁCH HÀNG","TÊN KHÁCH HÀNG", "SỐ ĐIỆN THOẠI", "CMND/PASSPORE", "SỐ LƯỢNG KHÁCH", "SỐ PHÒNG", "TÌNH TRẠNG"};
		JScrollPane scrollpane;
		pnTable.add(scrollpane = new JScrollPane(table = new JTable(model = new DefaultTableModel(head, 0)),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.SOUTH);
		tabbedPane.setForeground(Color.BLUE);
		scrollpane.setPreferredSize(new Dimension(1270, 400));
		
		pnQLdatPhong.add(pnNorth);
	    pnQLdatPhong.add(pnButton);
	    pnQLdatPhong.add(pnTable);
		
//		set.button				
		btnTimCMND.setPreferredSize(new Dimension(70, 30));
		btnTimSDT.setPreferredSize(new Dimension(70, 30));
		btnTimPhong.setPreferredSize(new Dimension(70, 30));
		btnTimTen.setPreferredSize(new Dimension(70, 30));
		btnThem.setPreferredSize(new Dimension(200, 30));
		btnSua.setPreferredSize(new Dimension(200, 30));
		btnHuy.setPreferredSize(new Dimension(200, 30));
		btnThongKe.setPreferredSize(new Dimension(200, 30));
		btnTraPhong.setPreferredSize(new Dimension(200, 30));
		btnXoaTrang.setPreferredSize(new Dimension(200, 30));
		
		btnTimPhong.setForeground(Color.BLUE);
		btnThem.setForeground(Color.BLUE);
		btnTimCMND.setForeground(Color.BLUE);
		btnTimSDT.setForeground(Color.BLUE);
		btnTimTen.setForeground(Color.BLUE);
		btnSua.setForeground(Color.BLUE);
		btnHuy.setForeground(Color.BLUE);	
		btnThongKe.setForeground(Color.BLUE);
		btnTraPhong.setForeground(Color.BLUE);
		btnXoaTrang.setForeground(Color.BLUE);	
	    
	    updateCombobox();
	}
	public void addActions() {
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					hoaDonPhong.DatPhong(cbbMaHD.getSelectedItem().toString(), txtMaNV.getText(), cbbMaKH.getSelectedItem().toString(), formatday.format(date), null, cbbTinhtrang.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Thành công");
				}catch (Exception ex) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Không thành công");
				}
			}
		});
//		btnNgay.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub					
//				Date date = new Date();
//				txtNgayden.setText(formatday.format(date));
//			}							
//		});
		cbbMaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<KHACHHANG> dsKhachhang = khachHang.getalltbNhanVien();
				String[] itemsCMND = new String[dsKhachhang.size()];
				String[] itemsSDT = new String[dsKhachhang.size()];
				String[] itemsTen = new String[dsKhachhang.size()];
				int j = 0, k = 0;
				int i = cbbMaKH.getSelectedIndex();
				
				for(KHACHHANG kh: dsKhachhang) {
					if(i == j) {
						itemsCMND[j] = kh.getCMND();
						itemsSDT[j] = kh.getSDT();
						itemsTen[j] = kh.getTenKH();
						cbbTenKH.setSelectedItem(itemsTen[j]);
						cbbSDT.setSelectedItem(itemsSDT[j]);
						cbbCMND.setSelectedItem(itemsCMND[j]);
					}
					j++;
				}
			}
		});		
	}
	private void updateCombobox() {
		ArrayList<PHONG> dsPhong = phong.getAlltbPhong();
		ArrayList<KHACHHANG> dsKhachhang = khachHang.getalltbNhanVien();
		String[] itemsPhong = new String[dsPhong.size()];
		String[] itemsKhachhang = new String[dsKhachhang.size()];
		String[] itemsCMND = new String[dsKhachhang.size()];
		String[] itemsSDT = new String[dsKhachhang.size()];
		String[] itemsTen = new String[dsKhachhang.size()];
		
		int i = 0, j = 0, k = 0;
		for(PHONG p: dsPhong) {
			if(p.getTinhTrang().toString().equalsIgnoreCase("FREE")) {
				itemsPhong[i] = p.getSoPhong();
				i++;
			}			
		}
		for(KHACHHANG kh: dsKhachhang) {
			itemsKhachhang[j] = kh.getMaKH();
			itemsCMND[j] = kh.getCMND();
			itemsSDT[j] = kh.getSDT();
			itemsTen[j] = kh.getTenKH();
			j++;
		}
	
		cbbSophong.setModel(new DefaultComboBoxModel<String>(itemsPhong));
		cbbMaKH.setModel(new DefaultComboBoxModel<String>(itemsKhachhang));
		cbbSDT.setModel(new DefaultComboBoxModel<String>(itemsSDT));
		cbbTenKH.setModel(new DefaultComboBoxModel<String>(itemsTen));
		cbbCMND.setModel(new DefaultComboBoxModel<String>(itemsCMND));
	}
}
