package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.dnd.Autoscroll;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
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

public class test_divideUI extends JFrame{
	
	private JLabel lblMa, lblTen, lblNgaynhan, lblGionhan, lblSoluong, lblLoai, lblSophong;
	private JTextField txtMa, txtTen, txtNgaynhan, txtGionhan;
	private JComboBox<String> cbbLoai, cbbSophong;
	private JComboBox<Integer> cbbSoluong;
	private JButton btnThem, btnHuy, btnSua, btnTim, btnThoat, btnTrove;
	private JTable table, table2;
	private static DefaultTableModel model, model2;

	private void seticonApp() throws IOException {
        Image i = ImageIO.read(getClass().getResource("/img/icon_home.jpg"));
        setIconImage(i);
    }
	
	public test_divideUI() {
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
		setTitle("DICH VU");
		setSize(1280, 680);
		building();
	}
	public void building() {
		JPanel pnQLDichVu = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 1280, 588);
		tabbedPane.add("Quản Lý DỊCH VỤ", pnQLDichVu);
		add(tabbedPane);
//		comp - north
//		table - center
		JPanel pnTable = new JPanel();
		JPanel pnTable2 = new JPanel();
		
		String[] head = {"MÃ DỊCH VỤ", "TÊN DỊCH VỤ", "GIÁ DỊCH VỤ"};
		JScrollPane scrollpane;
		
		pnTable.add(scrollpane = new JScrollPane(table = new JTable(model = new DefaultTableModel(head, 0)),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		scrollpane.setPreferredSize(new Dimension(480, 300));
		
		
		String[] head2 = {"MÃ DỊCH VỤ", "TÊN DỊCH VỤ", "GIÁ"};
		JScrollPane scrollpane2;		
		pnTable.add(scrollpane2 = new JScrollPane(table2 = new JTable(model2 = new DefaultTableModel(head2, 0)),
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);	
		scrollpane2.setPreferredSize(new Dimension(680, 300));
		
		pnQLDichVu.add(pnTable);
//		pnQLDichVu.add(pnTable2, BorderLayout.EAST);
		tabbedPane.setForeground(Color.BLUE);		
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		//Round Buttons
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		//Run
		java.awt.EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new test_divideUI().setVisible(true);
			}
		});
		
    }
}
