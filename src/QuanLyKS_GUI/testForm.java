package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import QuanLyKS_DAL.DichVu_DAL;
import QuanLyKS_DTO.DichVu_DTO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class testForm extends JInternalFrame {
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void showDichVu() {		
		ArrayList<DichVu_DTO> listDV = DichVu_DAL.getallDV();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] row = new Object[3];
		for(int i = 0; i <listDV.size(); i++) {
			row[0] = listDV.get(i).getMaDichVu();
			row[1] = listDV.get(i).getTenDichVu();
			row[2] = listDV.get(i).getGiaDichVu();
			model.addRow(row);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testForm frame = new testForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				showDichVu();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testForm() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(91, 68, 219, 92);
		getContentPane().add(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<DichVu_DTO> listDV = DichVu_DAL.getallDV();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				Object[] row = new Object[3];
				for(int i = 0; i <listDV.size(); i++) {
					row[0] = listDV.get(i).getMaDichVu();
					row[1] = listDV.get(i).getTenDichVu();
					row[2] = listDV.get(i).getGiaDichVu();
					model.addRow(row);

				}
			}
		});
		btnNewButton.setBounds(118, 215, 89, 23);
		getContentPane().add(btnNewButton);
		
		
	}
	
	
}
