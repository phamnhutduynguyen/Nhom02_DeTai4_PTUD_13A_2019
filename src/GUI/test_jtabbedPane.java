package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//import javax.swing.*;  
public class test_jtabbedPane extends JFrame{  	 
	public test_jtabbedPane(){  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setTitle("QUẢN LÝ KHÁCH SẠN - NHÂN VIÊN TIẾP TÂN");
		setSize(1280, 680);
		
		
		JPanel pnQLdatPhong = new JPanel();
		JPanel pnQLnhanPhong = new JPanel();
		JPanel pnQLPhong = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(50, 50, 800, 800);
		tabbedPane.add("Quản Lý Thuê Phòng", pnQLdatPhong);
		tabbedPane.add("Quản Lý Nhận Phòng", pnQLnhanPhong);
		tabbedPane.add("Quản Lý Phòng", pnQLPhong);
		
		add(tabbedPane);
		 
//	    JPanel p1=new JPanel();  	    
//	    JPanel p2=new JPanel();  
//	    JPanel p3=new JPanel(); 
//	    
//	    JTabbedPane tp=new JTabbedPane();  
//	    tp.setBounds(50,50,200,200);  
//	    tp.add("main",p1);  
//		tp.add("visit",p2);  
//		tp.add("help",p3); 
//		
//		add(tp);  
//	    setSize(400,400);  
//	    setLayout(null); 
	}  
	public static void main(String[] args) {  
	    new test_jtabbedPane().setVisible(true);;  
	}
}  