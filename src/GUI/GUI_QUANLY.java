package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.DAO_TAIKHOAN;

public class GUI_QUANLY extends JFrame{
	private static JMenu menuHeThong, menuQuanLy, menuThongKe, menuTroGiup;
	private static JMenuItem menuItemExit, menuItemSave, menuItemOpen, menuItemTK,menuItemTroGiup;
	private static JMenuItem menuItemPhong, menuItemDatPhong, menuItemDichVu, menuItemNhanVien, menuItemKhachHang;
	private static JMenuBar menuBar;
	private static JFrame frame;
	private JLabel lblTitle;
	private JTextField txtX;
	private JButton btnThem, btnHuy, btnSua, btnTim, btnThoat, btnTrove;
	private JTable table;
	private static DefaultTableModel model;
	
	
	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_QUANLY() throws ClassNotFoundException {
		try {
			seticonApp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(GUI_DANGNHAP.class.getName()).log(Level.SEVERE, null, e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setTitle("QUẢN LÝ KHÁCH SẠN - NHÂN VIÊN QUẢN LÝ");
		setSize(1280, 680);
		building();
		addActions();					    
	}
	public void building() throws ClassNotFoundException {

		// Menu Bar
		menuHeThong = new JMenu("HỆ THỐNG");
		menuQuanLy = new JMenu("QUẢN LÝ");
		menuThongKe = new JMenu("THỐNG KÊ");
		menuTroGiup = new JMenu("TRỢ GIÚP");
		
		menuItemOpen = new JMenuItem("MỞ File", new ImageIcon("icon/Open/Open_16x16.png"));
		menuItemExit = new JMenuItem("THOÁT", new ImageIcon("icon/Delete/Delete_16x16.png"));
		menuItemSave = new JMenuItem("LƯU File", new ImageIcon("icon/Save/Save_16x16.png"));
		menuItemSave.setEnabled(false);
		menuItemOpen.setEnabled(false);
		
		menuItemPhong = new JMenuItem("PHÒNG", new ImageIcon("icon/Folder/Folder_16x16.png"));
		menuItemDatPhong = new JMenuItem("ĐẶT PHÒNG", new ImageIcon("icon/Search/Search_16x16.png"));
		menuItemDichVu = new JMenuItem("DỊCH VỤ", new ImageIcon("icon/User/User_16x16.png"));
		menuItemNhanVien = new JMenuItem("NHÂN VIÊN", new ImageIcon("icon/User/User_16x16.png"));
		menuItemKhachHang = new JMenuItem("KHÁCH HÀNG", new ImageIcon("icon/Information/Information_16x16.png"));
		
		menuItemTK = new JMenuItem("THỐNG KÊ", new ImageIcon("icon/Information/Information_16x16.png"));
		menuItemTroGiup = new JMenuItem("TRỢ GIÚP", new ImageIcon("icon/User/User_16x16.png"));
		
		menuHeThong.add(menuItemSave);
		menuHeThong.add(menuItemOpen);
		menuHeThong.add(menuItemExit);
		
		menuQuanLy.add(menuItemPhong);
		menuQuanLy.add(menuItemDatPhong);
		menuQuanLy.add(menuItemDichVu);
		menuQuanLy.add(menuItemKhachHang);
		menuQuanLy.add(menuItemNhanVien);
		
		menuThongKe.add(menuItemTK);
		
		menuTroGiup.add(menuItemTroGiup);
		
		menuBar = new JMenuBar();
		menuBar.add(menuHeThong);
		menuBar.add(menuQuanLy);
		menuBar.add(menuThongKe);
		menuBar.add(menuTroGiup);
		setJMenuBar(menuBar);
		
		//UI
		JPanel pnQLPhong = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnQLdatPhong = new JPanel();
		pnQLdatPhong.setLayout(new BoxLayout(pnQLdatPhong, BoxLayout.Y_AXIS));
		JPanel pnQLKhachHang = new JPanel();
		pnQLKhachHang.setLayout(new BoxLayout(pnQLKhachHang, BoxLayout.Y_AXIS));
		JPanel pnQLdichVu = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pnQLNhanVien = new JPanel(new BorderLayout());
		JPanel pnTHONGKE = new JPanel(new BorderLayout());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 1280, 588);
		tabbedPane.addTab("PHÒNG", new ImageIcon("icon/User/User_32x32.png"), pnQLPhong);
		tabbedPane.addTab("ĐẶT PHÒNG", new ImageIcon("icon/User/User_32x32.png"),pnQLdatPhong);
		tabbedPane.addTab("DỊCH VỤ", new ImageIcon("icon/User/User_32x32.png"),pnQLdichVu);
		tabbedPane.addTab("KHÁCH HÀNG", new ImageIcon("icon/User/User_32x32.png"),pnQLKhachHang);
		tabbedPane.addTab("NHÂN VIÊN", new ImageIcon("icon/User/User_32x32.png"),pnQLNhanVien);
		tabbedPane.addTab("THỐNG KÊ", new ImageIcon("icon/User/User_32x32.png"),pnTHONGKE);
		//
		new GUI_QLPHONG(pnQLPhong, tabbedPane);	
		new GUI_QLDATPHONG(pnQLdatPhong, tabbedPane);
	    new GUI_QLDICHVU(pnQLdichVu, tabbedPane);
	    new GUI_QLNHANVIEN(pnQLNhanVien, tabbedPane);
	    new GUI_QLKHACHHANG(pnQLKhachHang, tabbedPane); 
	    new GUI_THONGKE(pnTHONGKE, tabbedPane);     
	    //
		btnThoat = new JButton("THOÁT");
	    btnThoat.setBounds(120,595,100,30);
	    btnThoat.setForeground(Color.RED);
		btnTrove = new JButton("ĐĂNG XUẤT");
	    btnTrove.setBounds(5,595,100,30);
	    btnTrove.setForeground(Color.RED);
	    
	    add(tabbedPane);
	    add(btnThoat);
	    add(btnTrove);    
	}
	public void addActions() {
		btnThoat.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
				if(chon == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnTrove.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất không?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
				if(chon == JOptionPane.YES_OPTION) {
					try {
						new GUI_DANGNHAP().setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					setVisible(false);
				}				
			}
		});
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//Round Buttons
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		//Run
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					new GUI_QUANLY().setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});		
    }
}
