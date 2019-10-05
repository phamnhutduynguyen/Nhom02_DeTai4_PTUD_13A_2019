package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ConnectDB.ConnectDB;
import dao.DAO_NHANVIEN;
import dao.DAO_TAIKHOAN;
import entity.NHANVIEN;
import entity.TAIKHOAN;

public class GUI_QLNHANVIEN extends JFrame{
	
	private JLabel lblTimTen, lblTimPhong, lblTimCMND, lblTimSDT, lblImg,lblTenDV, lblGioitinh,lblGia, lblMaKH, lblTenKH, lblMaDV_HD, lblTenDV_HD, lblGia_HD, lblSoluong;
	private JTextField txtTimTen, txtTimPhong,txtTimCMND, txtTimSDT, txtMaDV, txtMatKhau, txtTenDV,txtGia, txtMaKH, txtTenKH, txtMaDv_HD, txtGia_HD;
	private JComboBox<Integer> cbbSoluong;
	private JComboBox<String> cbbTenDv_HD;
	private JCheckBox cbGioitinh;
	private JButton btnThem, btnHuy, btnImg, btnXoaTrang, btnSua, btnTimTen, btnThoigian, btnTimCMND, btnTaoTK, btnTimPhong, btnTimSDT;
	private JTable table, table_hd;
	private static DefaultTableModel modelNV, modelTK;	
	private DAO_NHANVIEN daoNV = new DAO_NHANVIEN();
	private DAO_TAIKHOAN daoTK = new DAO_TAIKHOAN();
	
	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_QLNHANVIEN(JPanel pnQLPhong, JTabbedPane tabbedPane) throws ClassNotFoundException {
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
		setTitle("QUẢN LÝ KHÁCH SẠN-ĐĂNG NHẬP");
		setSize(1280, 680);
		building(pnQLPhong, tabbedPane);		
	}
	public void building(JPanel pnQLDichVu, JTabbedPane tabbedPane) throws ClassNotFoundException {
//		COMPONENTS - north
		JPanel pnComp = new JPanel();
		pnComp.setLayout(new BoxLayout(pnComp, BoxLayout.Y_AXIS));
		
		JPanel pn1stComp = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		
		pn1stComp.add(lblTenDV = new JLabel("MÃ NHÂN VIÊN:"));
		lblTenDV.setPreferredSize(new Dimension(100, 30));
		pn1stComp.add(txtTenDV = new JTextField());
		txtTenDV.setPreferredSize(new Dimension(150, 30));
		
		pn1stComp.add(lblMaKH = new JLabel("CHỨNG MINH ND:"));
		lblMaKH.setPreferredSize(new Dimension(130, 30));
		pn1stComp.add(txtMaKH = new JTextField());
		txtMaKH.setPreferredSize(new Dimension(150, 30));
		
		pn1stComp.add(lblGioitinh = new JLabel("NAM:"));
		lblGioitinh.setPreferredSize(new Dimension(60, 30));
		pn1stComp.add(cbGioitinh = new JCheckBox());		
		
		pn1stComp.add(lblTenDV_HD = new JLabel(""));
		lblTenDV_HD.setPreferredSize(new Dimension(160, 30));
		lblTenDV_HD.setBorder(null);
		
		pn1stComp.add(lblMaDV_HD = new JLabel("MÃ NV:"));
		lblMaDV_HD.setPreferredSize(new Dimension(70, 30));
		pn1stComp.add(txtMaDv_HD = new JTextField());
		txtMaDv_HD.setPreferredSize(new Dimension(380, 30));	
		txtMaDv_HD.setBorder(null);
		txtMaDv_HD.setEditable(false);;
						
		JPanel pn2stComp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pn2stComp.add(lblGia = new JLabel("TÊN NHÂN VIÊN:"));
		lblGia.setPreferredSize(new Dimension(100, 30));
		pn2stComp.add(txtGia = new JTextField());
		txtGia.setPreferredSize(new Dimension(150, 30));
		
		pn2stComp.add(lblTenKH = new JLabel("SỐ ĐIỆN THOẠI:"));
		lblTenKH.setPreferredSize(new Dimension(130, 30));
		pn2stComp.add(txtTenKH = new JTextField());
		txtTenKH.setPreferredSize(new Dimension(150, 30));
		
		pn2stComp.add(lblMaKH = new JLabel("CHỨC VỤ:"));
		lblMaKH.setPreferredSize(new Dimension(60, 30));
		pn2stComp.add(cbbTenDv_HD = new JComboBox<String>());
		cbbTenDv_HD.setPreferredSize(new Dimension(190, 30));	
		cbbTenDv_HD.addItem("QUẢN LÝ");
		cbbTenDv_HD.addItem("TIẾP TÂN");
		
		pn2stComp.add(lblSoluong = new JLabel("TÀI KHOẢN:"));
		lblSoluong.setPreferredSize(new Dimension(70, 30));
		pn2stComp.add(txtGia_HD = new JTextField());
		txtGia_HD.setPreferredSize(new Dimension(150, 30));
		
		pn2stComp.add(lblGia_HD = new JLabel("MẬT KHẨU:"));
		lblGia_HD.setPreferredSize(new Dimension(70, 30));
		pn2stComp.add(txtGia_HD = new JTextField());
		txtGia_HD.setPreferredSize(new Dimension(150, 30));
		
		pnQLDichVu.add(pnComp, BorderLayout.NORTH);
		pnComp.add(pn1stComp);
		pnComp.add(pn2stComp);
		
		//TABLE - center
		JPanel pnTable = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
//		Table
		String[] head_nv = {"MÃ","TÊN NHÂN VIÊN", "GIỚI TÍNH", "CMND","SĐT", "CHỨC VỤ", "TÊN TÀI KHOẢN", "MẬT KHẨU"};
		JScrollPane scrollpaneHoadon;		
		pnTable.add(scrollpaneHoadon = new JScrollPane(table_hd = new JTable(modelNV = new DefaultTableModel(head_nv, 0)),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);	
		scrollpaneHoadon.setPreferredSize(new Dimension(905, 380));
		
//		Table
//		String[] head_tk = {"MÃ", "TÊN TÀI KHOẢN", "MẬT KHẨU"};
//		JScrollPane scrollpaneDichvu;
//		pnTable.add(scrollpaneDichvu = new JScrollPane(table = new JTable(modelTK = new DefaultTableModel(head_tk, 0)),
//				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
//		scrollpaneDichvu.setPreferredSize(new Dimension(355, 380));		
		
		//img
		pnTable.add(lblImg = new JLabel());
		lblImg.setBorder(BorderFactory.createBevelBorder(1));
		lblImg.setPreferredSize(new Dimension(355, 340));	
		
		pnQLDichVu.add(pnTable, BorderLayout.CENTER);
		tabbedPane.setForeground(Color.BLUE);
		
		//Thay đổi kích thước các cột trong bảng
//		TableColumnModel columnModel = table.getColumnModel();
//		TableColumnModel columnModel_hd = table_hd.getColumnModel();
		
//		columnModel.getColumn(0).setPreferredWidth(80);
//		columnModel.getColumn(1).setPreferredWidth(135);
//		columnModel.getColumn(2).setPreferredWidth(135);
		
		//BUTTON - south
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
		pnButton1stOthers.add(btnXoaTrang = new JButton("XÓA TRẮNG"));
		pnButton1stOthers.add(btnImg = new JButton("THÊM ẢNH"));
		
		JPanel pnButton2ndOthers = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnButton2ndOthers.add(btnSua = new JButton("CẬP NHẬT"));
		pnButton2ndOthers.add(btnHuy = new JButton("HỦY ĐĂNG KÝ"));		
		pnButton2ndOthers.add(btnTaoTK = new JButton("TẠO TÀI KHOẢN"));
		
		pnButtonTim.add(pnButtonTim1st);
		pnButtonTim.add(pnButtonTim2nd);
		pnButtonOthers.add(pnButton1stOthers);
		pnButtonOthers.add(pnButton2ndOthers);
		pnButton.add(pnButtonTim);
		pnButton.add(pnButtonOthers);
		
		pnButton.add(pnButtonTim);
		pnButton.add(pnButtonOthers);
		pnQLDichVu.add(pnButton, BorderLayout.SOUTH);
		
		btnTimCMND.setPreferredSize(new Dimension(50, 30));
		btnTimSDT.setPreferredSize(new Dimension(50, 30));
//		btnTimPhong.setPreferredSize(new Dimension(50, 30));
		btnTimTen.setPreferredSize(new Dimension(50, 30));
		btnThem.setPreferredSize(new Dimension(150, 30));
		btnSua.setPreferredSize(new Dimension(150, 30));
		btnHuy.setPreferredSize(new Dimension(150, 30));
		btnImg.setPreferredSize(new Dimension(150, 30));
		btnTaoTK.setPreferredSize(new Dimension(150, 30));
		btnXoaTrang.setPreferredSize(new Dimension(150, 30));
		
//		btnTimPhong.setForeground(Color.BLUE);
		btnThem.setForeground(Color.BLUE);
		btnTimCMND.setForeground(Color.BLUE);
		btnTimSDT.setForeground(Color.BLUE);
		btnTimTen.setForeground(Color.BLUE);
		btnSua.setForeground(Color.BLUE);
		btnHuy.setForeground(Color.BLUE);	
		btnImg.setForeground(Color.BLUE);
		btnTaoTK.setForeground(Color.BLUE);
		btnXoaTrang.setForeground(Color.BLUE);	
		
		
		ConnectDB.getInstance().connect();
		DocNhanVien();
//		DocTaiKhoan();
	}
	public void DocNhanVien() {

		List<NHANVIEN> list = daoNV.getalltbNhanVien();
		List<TAIKHOAN> listTK = daoTK.getalltbNhanVien();
		for (NHANVIEN nv : list) {
			for(TAIKHOAN tk : listTK) {
				if(nv.getMaNV().equals(tk.getMa())) {
					if(nv.isGioiTinh()==true)
						modelNV.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh()?"Nam":"Nu", nv.getCMND(), nv.getSdt(), nv.getChucVu(), tk.getTentk(), tk.getMk() });
					else modelNV.addRow(new Object[] { nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh()?"Nam":"Nu", nv.getCMND(), nv.getSdt(), nv.getChucVu(), tk.getTentk(), tk.getMk() });
				}
			}
		}
	}
//	public void DocTaiKhoan() {
//
//		List<TAIKHOAN> list = daoTK.getalltbNhanVien();
//
//		for (TAIKHOAN nv : list) {
//				modelTK.addRow(new Object[] { nv.getMa(), nv.getTentk(), nv.getMk()});
//		}
//	}

}
