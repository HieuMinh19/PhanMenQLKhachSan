package QuanLyKS_GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class QLDichVu extends JInternalFrame {
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDichVu frame = new QLDichVu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLDichVu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
//		table = new JTable();
//		table.setBounds(168, 111, 1, 1);
//		getContentPane().add(table);
//		
//		table_1 = new JTable();
//		table_1.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null},
//				{null, null, null},
//			},
//			new String[] {
//				"New column", "abc", "New column"
//			}
//		));
//		table_1.setBounds(269, 135, -158, -71);
		
		JTable table_1;
		setLayout(new FlowLayout() );
		String[] columnName = {"Name", "abc", "xyz"};
		
		Object[] obj = new Object[] {"a", "b","c"};
	    
		ArrayList<Object> nameObj = new ArrayList<Object>(Arrays.asList(obj));
		nameObj.add("new value");
		nameObj.add("new value 2");	
		Object[][] data = {
				{"tt1", "tt2", "tt3"},
				{"tt1", "tt2", "tt3"},
		};
	    
		table_1 = new JTable(data, columnName);
		table_1.setPreferredScrollableViewportSize(new Dimension(500, 50) );
		table_1.setFillsViewportHeight(true);
		
		getContentPane().add(table_1);
		
		JLabel lblTesst = new JLabel("Tesst");
		lblTesst.setBounds(68, 32, 46, 14);
		getContentPane().add(lblTesst);

	}
}
