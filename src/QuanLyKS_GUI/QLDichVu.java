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
	private JTable table_2;

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
		
		//create JTable
		JTable table_1;
		String[] columnName = {"Name", "abc", "xyz"};
		Object[] obj = new Object[] {"a", "b","c"};
		ArrayList<Object> nameObj = new ArrayList<Object>(Arrays.asList(obj));
		nameObj.add("new value");
		nameObj.add("new value 2");	
		String a = "abc";
		//
		Object data1[][] = new Object[10][5];
		for(int i = 0; i < 4; i++){
		    data1[i][0] = "abc";
		    data1[i][1] = "xyz";
		    data1[i][2] = "tt2";
		     
		}
		
		
		
		//
		Object[][] data = {
				{a, "tt2", "tt3"},
				{"tt1", "tt2", "tt3"},
				{"tt1", "tt2", "tt3"},
		};
		getContentPane().setLayout(null);
	    
		table_1 = new JTable(data, columnName);
		table_1.setSize(225, 32);
		table_1.setLocation(84, 96);
		table_1.setPreferredScrollableViewportSize(new Dimension(500, 50) );
		table_1.setFillsViewportHeight(true);
		
		getContentPane().add(table_1);
		
		JLabel lblTesst = new JLabel("Ma DV");
		lblTesst.setBounds(84, 71, 69, 14);
		getContentPane().add(lblTesst);
		
		JLabel lblTnDv = new JLabel("T\u00EAn DV");
		lblTnDv.setBounds(163, 71, 71, 14);
		getContentPane().add(lblTnDv);
		
		JLabel lblChiTietDv = new JLabel("Chi tiet DV");
		lblChiTietDv.setBounds(238, 71, 71, 14);
		getContentPane().add(lblChiTietDv);
		
		table_2 = new JTable();
		table_2.setBounds(59, 166, 323, 93);
		getContentPane().add(table_2);

	}
}
