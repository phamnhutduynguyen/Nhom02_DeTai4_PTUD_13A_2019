package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import ConnectDB.ConnectDB;
import dao.DAO_TAIKHOAN;
import entity.TAIKHOAN;

import javax.swing.UnsupportedLookAndFeelException;

public class GUI_DANGNHAP extends JFrame{
	private JLabel lblTitle, lblImg, lblTaikhoan, lblMatkhau;
	public static JLabel lblThongbaoTK;
	public static JLabel lblThongbaoMK;
	private JTextField txtTaikhoan;
	private JPasswordField pwMatkhau;
	private JButton btnDangNhap, btnThoat;
	private DAO_TAIKHOAN daoTK = new DAO_TAIKHOAN();
	public static String nvLogin;
	
	// read and set icon_img of Home
	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public GUI_DANGNHAP() throws ClassNotFoundException {
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
		building();
		addActions();	
		
	}
	private void building() throws ClassNotFoundException {
		//Background Img
		//GridBagLayout
		//GridBagConstraints
		
		ConnectDB.getInstance().connect();
		
        java.awt.GridBagConstraints gridBagConstraints;

        JPanel pnBackground = new javax.swing.JPanel();
        JLabel lblBackground = new javax.swing.JLabel();

        Container con = getContentPane();
        con.setLayout(new java.awt.GridBagLayout());

        pnBackground.setOpaque(false);

        javax.swing.GroupLayout Layout = new javax.swing.GroupLayout(pnBackground);
        pnBackground.setLayout(Layout);
        Layout.setHorizontalGroup(
            Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 495, Short.MAX_VALUE)
        );
        Layout.setVerticalGroup(
            Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 495, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        con.add(pnBackground, gridBagConstraints);

        lblBackground.setIcon(new ImageIcon(getClass().getResource("/img/dangnhap.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        con.add(lblBackground, gridBagConstraints);

        pack();
        
        String tk = "<html> nhập tên tài khoản";
        String mk = "<html> nhập mật khẩu";
 
        //UI Sign in
		pnBackground.add(lblTitle = new JLabel("ĐĂNG NHẬP"));
		lblTitle.setFont(new Font("Tahoma", 1, 30));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(150, 10, 200, 40);
		
		pnBackground.add(lblTaikhoan = new JLabel("TÀI KHOẢN:"));
		lblTaikhoan.setForeground(Color.WHITE);
		lblTaikhoan.setFont(new Font("Tahoma", 0, 21));
		pnBackground.add(txtTaikhoan = new JTextField(20));
		txtTaikhoan.setFont(new Font("Tahoma", 0, 21));
		txtTaikhoan.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.blue));
		txtTaikhoan.setToolTipText(tk);
		
		pnBackground.add(lblMatkhau = new JLabel("MẬT KHẨU:"));
		lblMatkhau.setForeground(Color.WHITE);
		lblMatkhau.setFont(new Font("Tahoma", 0, 21));
		pnBackground.add(pwMatkhau = new JPasswordField(20));
		pwMatkhau.setFont(new Font("Tahoma", 0, 21));
		pwMatkhau.setBorder(BorderFactory.createBevelBorder(1, Color.green, Color.orange, Color.red, Color.blue));
		pwMatkhau.setToolTipText(mk);
		
		pnBackground.add(lblThongbaoTK = new JLabel("*nhập tên tài khoản"));
		lblThongbaoTK.setForeground(Color.RED);
		lblThongbaoTK.setFont(new Font("Tahoma", 0, 18));
		pnBackground.add(lblThongbaoMK = new JLabel("*nhập mật khẩu"));
		lblThongbaoMK.setForeground(Color.RED);
		lblThongbaoMK.setFont(new Font("Tahoma", 0, 18));
		
		pnBackground.add(btnDangNhap = new JButton("ĐĂNG NHẬP"));
//		btnDangNhap.setBackground(Color.WHITE);
		btnDangNhap.setFont(new Font("Tahoma", 1, 13));
		btnDangNhap.setForeground(Color.BLUE);
//		btnDangNhap.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.blue));
//		btnDangNhap.setBorder(new RoundedBorder(30));
//		btnDangNhap.setBorderPainted(false);
//		btnDangNhap.setContentAreaFilled(false);
//		btnDangNhap.setOpaque(true);
		
		pnBackground.add(btnThoat = new JButton("THOÁT"));
		btnThoat.setFont(new Font("Tahoma", 1, 18));
		btnThoat.setForeground(Color.BLUE);
//		btnThoat.setBorder(BorderFactory.createBevelBorder(1, Color.green, Color.orange, Color.red, Color.blue));
	 
	    lblTaikhoan.setBounds(20, 80, 150, 40);
	    txtTaikhoan.setBounds(150, 80, 190, 40);
	    lblThongbaoTK.setBounds(350, 80, 300, 30);
	    lblMatkhau.setBounds(20, 150, 150, 40);
	    pwMatkhau.setBounds(150, 150, 190, 40);
	    lblThongbaoMK.setBounds(350, 150, 300, 30);
	    btnDangNhap.setBounds(150, 220, 150, 40);
	    btnThoat.setBounds(5,600,100,40);	
    }
	public void addActions() {
		btnDangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub			
				if(daoTK.DocTaiKhoan(txtTaikhoan.getText(), pwMatkhau.getText())==1) {
					nvLogin = txtTaikhoan.getText();
					setVisible(false);
					try {
						new GUI_QUANLY().setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(daoTK.DocTaiKhoan(txtTaikhoan.getText(), pwMatkhau.getText())==2){
					setVisible(false);
					nvLogin = txtTaikhoan.getText();
					try {
						new GUI_TIEPTAN().setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
				}
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
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
					new GUI_DANGNHAP().setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
    }
	
	
}
