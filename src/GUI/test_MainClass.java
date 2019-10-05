package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class test_MainClass extends JFrame{
	private JLabel lblTitle, lblTaikhoan, lblMatkhau, lblThongbao;
	private JTextField txtTaikhoan, txtMatkhau;
	private JButton btnDangnhap, btnThoat;
	public test_MainClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("QUAN LY KHACH SAN");
		buiding();
		addActions();
	}
	public void buiding(){		
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));

		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnTitle.add(lblTitle = new JLabel("DANG NHAP"));
		pnTitle.setBackground(Color.GREEN);
		lblTitle.setFont(new Font("arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		pnNorth.add(pnTitle);		
		
		JPanel pnTaikhoan = new JPanel();
		pnTaikhoan.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnTaikhoan.add(lblTaikhoan = new JLabel("TAI KHOAN:"));		
		pnTaikhoan.add(txtTaikhoan = new JTextField(30));
		pnNorth.add(pnTaikhoan);		
		
		JPanel pnMatkhau = new JPanel();
		pnMatkhau.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnMatkhau.add(lblMatkhau = new JLabel("MAT KHAU:"));		
		pnMatkhau.add(txtMatkhau = new JTextField(30));
		pnNorth.add(pnMatkhau);		
		
		JPanel pnDangnhap = new JPanel();
		pnDangnhap.setLayout(new FlowLayout(FlowLayout.CENTER));	
		pnDangnhap.add(btnDangnhap = new JButton("DANG NHAP"));
		pnNorth.add(pnDangnhap);	
		
		JPanel pnThongbao = new JPanel();
		pnThongbao.setLayout(new FlowLayout(FlowLayout.CENTER));	
		pnThongbao.add(lblThongbao = new JLabel(""));
		pnThongbao.setEnabled(false);		
		pnNorth.add(pnThongbao);
		
		JPanel pnThoat = new JPanel();
		pnThoat.setLayout(new FlowLayout(FlowLayout.CENTER));	
		pnThoat.add(btnThoat = new JButton("Thoat"));
		pnThoat.setBackground(Color.GREEN);
		pnThoat.setFont(new Font("arial", Font.BOLD, 30));
		pnThoat.setForeground(Color.BLUE);
		pnNorth.add(pnThoat);
		
		con.add(pnNorth);	
	}
	public void addActions() {
		btnDangnhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtTaikhoan.getText().equals("nv1")) {
					if(txtMatkhau.getText().equals("nv1")) {
						setVisible(false);
						try {
							new GUI_TIEPTAN().setVisible(true);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						lblThongbao.setText("*Tai khoan/Mat khau khong dung!");
						lblThongbao.setForeground(Color.RED);
					}
				}else {
					lblThongbao.setText("*Tai khoan/Mat khau khong dung!");
					lblThongbao.setForeground(Color.RED);
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
		
	public static void main(String[] args) {
		new test_MainClass().setVisible(true);;
	}
}
