package QuanLyKS_GUI;

import java.awt.Dimension;
import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.impl.UResource.Array;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import QuanLyKS_DAL.MyConnection;
import QuanLyKS_DTO.DichVu_DTO;
import net.proteanit.sql.DbUtils;

import QuanLyKS_BUS.DichVu_BUS;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;

public class QLDichVu extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_2;
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtCTDV;
	public static ResultSet DV;
	private JTable table;
	
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
		setBounds(100, 100, 584, 300);
		getContentPane().setLayout(null);
		
		
		
		
		
		
		JScrollPane scrListDV = new JScrollPane();
		
		
		scrListDV.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		scrListDV.setBounds(276, 40, 270, 163);
		getContentPane().add(scrListDV);
		
		table_2 = new JTable();
		scrListDV.setViewportView(table_2);
		
		JButton btnLoadData = new JButton("Load list Service");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DichVu_BUS dvBus = new DichVu_BUS();
				ResultSet listDV = dvBus.selectAll();
				DV = dvBus.selectAll();
				if(DV != null) {
					table_2.setModel(DbUtils.resultSetToTableModel(listDV));
				}else {
					JOptionPane.showMessageDialog(null, "get List Services not success", "Error: " + "error Mesage", JOptionPane.CLOSED_OPTION);
				}
				
			}
		});
		btnLoadData.setBounds(341, 214, 109, 30);
		getContentPane().add(btnLoadData);
		
		JLabel lblMadichvu = new JLabel("M\u00E3 d\u1ECBch v\u1EE5");
		lblMadichvu.setBounds(27, 59, 59, 14);
		getContentPane().add(lblMadichvu);
		
		txtMaDV = new JTextField();
		txtMaDV.setBounds(101, 56, 86, 20);
		getContentPane().add(txtMaDV);
		txtMaDV.setColumns(10);
		
		JLabel lblTnDchVu = new JLabel("T\u00EAn d\u1ECBch v\u1EE5");
		lblTnDchVu.setBounds(27, 101, 59, 14);
		getContentPane().add(lblTnDchVu);
		
		txtTenDV = new JTextField();
		txtTenDV.setBounds(101, 98, 86, 20);
		getContentPane().add(txtTenDV);
		txtTenDV.setColumns(10);
		
		txtCTDV = new JTextField();
		txtCTDV.setBounds(101, 136, 86, 20);
		getContentPane().add(txtCTDV);
		txtCTDV.setColumns(10);
		
		JLabel lblMCtDch = new JLabel("M\u00E3 CT d\u1ECBch v\u1EE5");
		lblMCtDch.setBounds(27, 139, 67, 14);
		getContentPane().add(lblMCtDch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ResultSet abc = DV;
			
			DichVu_DTO dv = new DichVu_DTO();
			try {
				while (DV.next()) {
					
					String temp = DV.getString("TenDichVu");
					txtTenDV.setText(temp);
					System.out.println(temp);
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			int m = 10;
			}
		});
		btnUpdate.setBounds(81, 203, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSelect.setBounds(198, 218, 89, 23);
		getContentPane().add(btnSelect);

	}
}
