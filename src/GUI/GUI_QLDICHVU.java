package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import dao.DAO_CTHDDV;
import dao.DAO_DICHVU;
import dao.DAO_LOAIPHONG;
import dao.DAO_PHONG;
import entity.CTHDDV;
import entity.DICHVU;
import entity.LOAIPHONG;
import entity.PHONG;

public class GUI_QLDICHVU extends JFrame{
	
	private JLabel lblPhong_Loai, lblLoai_Loai, lblGia,lblSoLuong, lblTinhtrang, lblSophong, lblKTTT, lblKTLP, lblImg;
	private JTextField txtGia, txtSophong;
	private JComboBox<String> cbbKTLP, cbbKTTT, cbbPhong_Loai, cbbLoai_loai, cbbSoLuong, cbbTinhtrang;
	private JButton btnThemPhong, btnHuyPhong, btnSuaPhong, btnKTPhong, btnXoaPhong, btnThemLoaiPhong, btnHuyLoaiPhong, btnSuaLoaiPhong,btnKTLoaiPhong, btnXoaLoaiPhong, btnHinhAnh;
	private JTable tablePhong, tableLoai;
	private static DefaultTableModel modelDichVu, modelCTHDDV;
	private DAO_DICHVU daoDV = new DAO_DICHVU();
	private DAO_CTHDDV daoCTHDDV = new DAO_CTHDDV();

	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_QLDICHVU(JPanel pnQLPhong, JTabbedPane tabbedPane) throws ClassNotFoundException {
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
	public void building(JPanel pnQLPhong, JTabbedPane tabbedPane) throws ClassNotFoundException {
//		1
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		pnLeft.setBorder(BorderFactory.createTitledBorder("PHÒNG"));
		
		JPanel pnPhong1stComps = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pnPhong1stComps.add(lblSophong = new JLabel("SỐ PHÒNG:"));
		lblSophong.setPreferredSize(new Dimension(100, 30));
		pnPhong1stComps.add(txtSophong = new JTextField());		
		txtSophong.setPreferredSize(new Dimension(250, 30));
		txtSophong.setEditable(false);						
						
		JPanel pnPhong2ndComps = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pnPhong2ndComps.add(lblPhong_Loai = new JLabel("LOẠI PHÒNG:"));
		lblPhong_Loai.setPreferredSize(new Dimension(100, 30));
		pnPhong2ndComps.add(cbbPhong_Loai = new JComboBox<String>());
		cbbPhong_Loai.setPreferredSize(new Dimension(250, 30));				
						
		JPanel pnPhong3rdComps = new JPanel(new FlowLayout(FlowLayout.LEFT));												
		
		pnPhong3rdComps.add(lblTinhtrang = new JLabel("TÌNH TRẠNG:"));
		lblTinhtrang.setPreferredSize(new Dimension(100, 30));
		pnPhong3rdComps.add(cbbTinhtrang = new JComboBox<String>());
		cbbTinhtrang.setPreferredSize(new Dimension(250, 30));							
		
		JPanel pnPhongBtnTim = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		
		pnPhongBtnTim.add(lblKTTT= new JLabel("KIỂM TRA TÌNH TRẠNG:"));
		pnPhongBtnTim.add(cbbKTTT = new JComboBox<String>());
		cbbKTTT.setPreferredSize(new Dimension(160, 25));		
		pnPhongBtnTim.add(btnKTPhong = new JButton("TÌM"));
						
		JPanel pnPhong1stBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pnPhong1stBtn.add(btnThemPhong = new JButton("THÊM PHÒNG"));
		pnPhong1stBtn.add(btnXoaPhong = new JButton("XÓA TRẮNG"));	
		
		JPanel pnPhong2ndBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));		

		pnPhong2ndBtn.add(btnSuaPhong = new JButton("CẬP NHẬT"));
		pnPhong2ndBtn.add(btnHuyPhong = new JButton("XÓA PHÒNG"));
													    	    		    
		JPanel pnPhongTable = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		String[] headPhong = {"MÃ DỊCH VỤ", "TÊN DỊCH VỤ", "ĐƠN GIÁ"};
		JScrollPane scrollpanePhong;
		pnPhongTable.add(scrollpanePhong = new JScrollPane(tablePhong = new JTable(modelDichVu = new DefaultTableModel(headPhong, 0)),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		tabbedPane.setForeground(Color.BLUE);
		scrollpanePhong.setPreferredSize(new Dimension(350, 270));			
		
		//2
		JPanel pnMid = new JPanel();
		pnMid.setLayout(new BoxLayout(pnMid, BoxLayout.Y_AXIS));
		pnMid.setBorder(BorderFactory.createTitledBorder("LOẠI PHÒNG"));
		
		JPanel pnLoaiPhong1stComps = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pnLoaiPhong1stComps.add(lblLoai_Loai = new JLabel("LOẠI PHÒNG:"));
		lblLoai_Loai.setPreferredSize(new Dimension(100, 30));
		pnLoaiPhong1stComps.add(cbbLoai_loai = new JComboBox<String>());
		cbbLoai_loai.setPreferredSize(new Dimension(250, 30));
		
		JPanel pnLoaiPhong3rdComps = new JPanel(new FlowLayout(FlowLayout.LEFT));														
		
		pnLoaiPhong3rdComps.add(lblSoLuong = new JLabel("SỐ LƯỢNG:"));
		lblSoLuong.setPreferredSize(new Dimension(100, 30));
		pnLoaiPhong3rdComps.add(cbbSoLuong = new JComboBox<String>());
		cbbSoLuong.setPreferredSize(new Dimension(250, 30));	
		
		JPanel pnLoaiPhong2ndComps = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pnLoaiPhong2ndComps.add(lblGia = new JLabel("GIÁ PHÒNG:"));
		lblGia.setPreferredSize(new Dimension(100, 30));
		pnLoaiPhong2ndComps.add(txtGia = new JTextField());
		txtGia.setPreferredSize(new Dimension(250, 30));
		
		JPanel pnLoaiPhongBtnTim = new JPanel(new FlowLayout(FlowLayout.LEFT));				
		
		pnLoaiPhongBtnTim.add(lblKTLP = new JLabel("KIỂM TRA LOẠI PHÒNG:"));
		pnLoaiPhongBtnTim.add(cbbKTLP = new JComboBox<String>());
		cbbKTLP.setPreferredSize(new Dimension(160, 25));		
		pnLoaiPhongBtnTim.add(btnKTLoaiPhong = new JButton("TÌM"));
		
		JPanel pnLoaiPhong1stBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pnLoaiPhong1stBtn.add(btnThemLoaiPhong = new JButton("THÊM LOẠI PHÒNG"));
		pnLoaiPhong1stBtn.add(btnXoaLoaiPhong = new JButton("XÓA TRẮNG"));	
		
		JPanel pnLoaiPhong2ndBtn = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		
		pnLoaiPhong2ndBtn.add(btnSuaLoaiPhong = new JButton("CẬP NHẬT"));
		pnLoaiPhong2ndBtn.add(btnHuyLoaiPhong = new JButton("XÓA LOẠI PHÒNG"));
		
		JPanel pnLoaiPhongTable = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		String[] headLoaiPhong = {"MÃ NHÂN VIÊN", "MÃ KHÁCH HÀNG", "MÃ DỊCH VỤ"};
		JScrollPane scrollpaneLoaiPhong;		
		pnLoaiPhongTable.add(scrollpaneLoaiPhong = new JScrollPane(tableLoai = new JTable(modelCTHDDV = new DefaultTableModel(headLoaiPhong, 0)),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);	
		scrollpaneLoaiPhong.setPreferredSize(new Dimension(350, 270));
		
		//3		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		
		JPanel pnRight1st = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnRight1st.add(btnHinhAnh = new JButton("CHỌN HÌNH"));
		
		JPanel pnRight2nd = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnRight2nd.add(lblImg = new JLabel());
		lblImg.setBorder(BorderFactory.createBevelBorder(1));
		lblImg.setPreferredSize(new Dimension(485, 480));	
		
		//btn.set
		btnThemPhong.setPreferredSize(new Dimension(175, 30));
		btnSuaPhong.setPreferredSize(new Dimension(175, 30));
		btnHuyPhong.setPreferredSize(new Dimension(175, 30));
		btnXoaPhong.setPreferredSize(new Dimension(175, 30));
		
		btnThemLoaiPhong.setPreferredSize(new Dimension(175, 30));
		btnSuaLoaiPhong.setPreferredSize(new Dimension(175, 30));
		btnHuyLoaiPhong.setPreferredSize(new Dimension(175, 30));
		btnXoaLoaiPhong.setPreferredSize(new Dimension(175, 30));
		btnHinhAnh.setPreferredSize(new Dimension(140, 30));
		btnKTPhong.setPreferredSize(new Dimension(50, 30));
		btnKTLoaiPhong.setPreferredSize(new Dimension(50, 30));
		
		btnXoaPhong.setForeground(Color.BLUE);
		btnThemPhong.setForeground(Color.BLUE);		
		btnSuaPhong.setForeground(Color.BLUE);
		btnHuyPhong.setForeground(Color.RED);
		
		btnXoaLoaiPhong.setForeground(Color.BLUE);
		btnThemLoaiPhong.setForeground(Color.BLUE);		
		btnSuaLoaiPhong.setForeground(Color.BLUE);
		btnHuyLoaiPhong.setForeground(Color.RED);
		btnKTLoaiPhong.setForeground(Color.BLUE);
		btnKTPhong.setForeground(Color.BLUE);
		btnHinhAnh.setForeground(Color.RED);
		//add
		pnLeft.add(pnPhong1stComps);
		pnLeft.add(pnPhong2ndComps);
		pnLeft.add(pnPhong3rdComps);	
		pnLeft.add(pnPhongBtnTim);
	    pnLeft.add(pnPhong1stBtn);	
	    pnLeft.add(pnPhong2ndBtn);
	    pnLeft.add(pnPhongTable);
	    pnMid.add(pnLoaiPhong1stComps);
	    pnMid.add(pnLoaiPhong2ndComps);
	    pnMid.add(pnLoaiPhong3rdComps);	
	    pnMid.add(pnLoaiPhongBtnTim);
	    pnMid.add(pnLoaiPhong1stBtn);	
	    pnMid.add(pnLoaiPhong2ndBtn);
	    pnMid.add(pnLoaiPhongTable);
	    pnRight.add(pnRight1st);
		pnRight.add(pnRight2nd);
	    pnQLPhong.add(pnLeft);	
	    pnQLPhong.add(pnMid);	
		pnQLPhong.add(pnRight);
	    
	    ConnectDB.getInstance().connect();
	    DocDichVu();
	    DocCTHDDV();
	}
	public void DocDichVu() {

		List<DICHVU> list = daoDV.getalltbDichVu();
		for (DICHVU dv : list) {
			modelDichVu.addRow(new Object[] { dv.getMaDV(), dv.getTenDV(),  dv.getGiaDV()});
		}
	}
	public void DocCTHDDV() {

		List<CTHDDV> list = daoCTHDDV.getalltbCTHDDV();
		for (CTHDDV cthddv : list) {
			modelDichVu.addRow(new Object[] {cthddv.getNhanVien(),cthddv.getHddv(), cthddv.getDichVu()});
		}
	}
//	public void addActions() {
//		btnThanhToan.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					new GUI_HOADONDICHVU().setVisible(true);
//				} catch (ClassNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
//	}		
}

	

