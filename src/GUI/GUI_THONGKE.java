package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.dnd.Autoscroll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.table.TableColumnModel;

import ConnectDB.ConnectDB;

public class GUI_THONGKE extends JFrame{
	
	private JLabel lblImg, lblTenDV, lblGia, lblMaKH, lblTenKH, lblMaDV_HD, lblTenDV_HD, lblGia_HD, lblSoluong;
	private JTextField txtMaDV, txtTenDV,txtGia, txtMaKH, txtTenKH, txtMaDv_HD, txtGia_HD;
	private JComboBox<Integer> cbbSoluong;
	private JComboBox<String> cbbTenDv_HD;
	private JButton btnThem, btnHuy, btnSua, btnTim, btnThanhToan, btnTrove, btnThoigian;
	private JTable table, table_hd;
	private static DefaultTableModel model, model2;	

	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_THONGKE(JPanel pnQLDichVu, JTabbedPane tabbedPane) throws ClassNotFoundException {
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
		building(pnQLDichVu, tabbedPane);
		addActions();
	}
	public void building(JPanel pnQLDichVu, JTabbedPane tabbedPane) throws ClassNotFoundException {
		JPanel pnComp = new JPanel();
		pnComp.setLayout(new BoxLayout(pnComp, BoxLayout.Y_AXIS));
		
		JPanel pnButton = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnButton.add(btnTim = new JButton("THỐNG KÊ THEO NGÀY"));
		pnButton.add(btnThem = new JButton("THỐNG KÊ THEO TUẦN"));
		pnButton.add(btnSua = new JButton("THỐNG KÊ THEO THÁNG"));
		pnButton.add(btnHuy = new JButton("THỐNG KÊ THEO QUÝ"));
		pnButton.add(btnThanhToan = new JButton("THÔNG KÊ THEO NĂM"));
		btnTim.setPreferredSize(new Dimension(200, 30));
		btnThem.setPreferredSize(new Dimension(200, 30));
		btnSua.setPreferredSize(new Dimension(200, 30));
		btnHuy.setPreferredSize(new Dimension(200, 30));
		btnThanhToan.setPreferredSize(new Dimension(200, 30));
		
		btnThem.setForeground(Color.BLUE);
		btnTim.setForeground(Color.BLUE);
		btnSua.setForeground(Color.BLUE);
		btnHuy.setForeground(Color.BLUE);
		btnThanhToan.setForeground(Color.BLUE);
		
		pnComp.add(pnButton, BorderLayout.NORTH);
		pnQLDichVu.add(pnComp);	
		tabbedPane.setForeground(Color.BLUE);
		
	}
	public void addActions() {
		
	}
}

