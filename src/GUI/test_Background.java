package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class test_Background extends JFrame{
	private JLabel lblTitle, lblImg, lblTaikhoan, lblMatkhau, lblThongbaoTK, lblThongbaoMK;
	private JTextField txtTaikhoan;
	private JPasswordField pwMatkhau;
	private JButton btnDangNhap, btnThoat;
	public test_Background() {
		building();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setTitle("QUẢN LÝ KHÁCH SẠN - TEST");
		setSize(1280, 680);
	}
	
	private void building() {
		//Background Img
        java.awt.GridBagConstraints gridBagConstraints;

        JPanel pnBackground = new javax.swing.JPanel();
        JLabel lblBackground = new javax.swing.JLabel();

        Container con = getContentPane();
        con.setLayout(new java.awt.GridBagLayout());

        pnBackground.setOpaque(false);

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(pnBackground);
        pnBackground.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
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
        
        //UI
		pnBackground.add(lblTitle = new JLabel("ĐĂNG NHẬP"));
		lblTitle.setFont(new Font("Tahoma", 1, 30));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(580, 0, 200, 40);
		
		pnBackground.add(lblTaikhoan = new JLabel("TÀI KHOẢN:"));
		lblTaikhoan.setForeground(Color.WHITE);
		pnBackground.add(txtTaikhoan = new JTextField(20));
		txtTaikhoan.setFont(new Font("Tahoma", 0, 21));
		
		pnBackground.add(lblMatkhau = new JLabel("MẬT KHẨU:"));
		lblMatkhau.setForeground(Color.WHITE);
		pnBackground.add(pwMatkhau = new JPasswordField(20));
		pwMatkhau.setFont(new Font("Tahoma", 0, 21));
		
		pnBackground.add(lblThongbaoTK = new JLabel("*nhập tên tài khoản"));
		lblThongbaoTK.setForeground(Color.RED);
		pnBackground.add(lblThongbaoMK = new JLabel("*nhập mật khẩu"));
		lblThongbaoMK.setForeground(Color.RED);
		
		pnBackground.add(btnDangNhap = new JButton("ĐĂNG NHẬP"));
		pnBackground.add(btnThoat = new JButton("THOÁT"));
	 
	    lblTaikhoan.setBounds(500, 60, 150, 30);
	    txtTaikhoan.setBounds(600, 60, 190, 30);
	    lblThongbaoTK.setBounds(800, 60, 200, 20);
	    lblMatkhau.setBounds(500, 100, 150, 30);
	    pwMatkhau.setBounds(600, 100, 190, 30);
	    lblThongbaoMK.setBounds(800, 100, 200, 20);
	    btnDangNhap.setBounds(550, 140, 150, 40);
	    btnThoat.setBounds(5,600,100,40);	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test_Background().setVisible(true);
	}

}
