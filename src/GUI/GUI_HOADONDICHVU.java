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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ConnectDB.ConnectDB;

public class GUI_HOADONDICHVU extends JFrame{
	
	private JLabel lblMaDV,lblTenDV, lblGioitinh,lblGia, lblMaKH, lblTenKH, lblMaDV_HD, lblTenDV_HD, lblGia_HD, lblSoluong;
	private JTextField txtMaDV, txtMatKhau, txtTenDV,txtGia, txtMaKH, txtTenKH, txtMaDv_HD, txtGia_HD;
	private JComboBox<Integer> cbbSoluong;
	private JComboBox<String> cbbTenDv_HD;
	private JCheckBox cbGioitinh;
	private JButton btnThem, btnHuy, btnSua, btnTimTen, btnThoigian, btnTimCMND, btnTaoTK;
	private JTable table, table_hd;
	private static DefaultTableModel modelNV, modelTK;
	
	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_HOADONDICHVU() throws ClassNotFoundException {
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
		setTitle("HÓA ĐƠN");
		setSize(400, 600);
		building();		
	}
	public void building(){
		

	}
}
