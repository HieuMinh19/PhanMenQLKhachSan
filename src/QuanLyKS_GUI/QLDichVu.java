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
import javax.swing.JComboBox;

public class QLDichVu extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_2;
	private JTextField txtTenDichVu;
	private JTextField txtCTDV;
	public static DichVu_DTO []arrDV;
	private static int lengthArr = 0;
	static DichVu_BUS dvBus = new DichVu_BUS();	
	public static ResultSet DV = dvBus.selectAll();
	private DichVu_DTO dichvu_DTO;
	
	
	

	
	private JTable table;
	private JTextField txtMaDichVu;
	private JTextField txtGiaDichVu;
	
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
		setBounds(100, 100, 1009, 512);
		getContentPane().setLayout(null);
		
		
		
		
		
		
		JScrollPane scrListDV = new JScrollPane();
		JComboBox<Object> cbxMaDV = new javax.swing.JComboBox<>();
		
		scrListDV.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		scrListDV.setBounds(352, 40, 613, 163);
		getContentPane().add(scrListDV);
		
		table_2 = new JTable();
		scrListDV.setViewportView(table_2);
		
		JButton btnLoadData = new JButton("Load list Service");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ResultSet listDV = dvBus.selectAll();
				ResultSet subList = dvBus.selectAll();
				DV = dvBus.selectAll();

				if(listDV != null) {
					table_2.setModel(DbUtils.resultSetToTableModel(listDV));
				}else {
					JOptionPane.showMessageDialog(null, "get List Services not success", "Error: " + "error Mesage", JOptionPane.CLOSED_OPTION);
				}
				//load list MaDV from db
				 try {
			        	while(subList.next()) {
			        		cbxMaDV.addItem(subList.getString("MaDichVu"));
			        		cbxMaDV.getSelectedItem();
			        		lengthArr++;
					   }
			        	//dem so dich vu
			        	arrDV = new DichVu_DTO[lengthArr];
			        	//set gia tri cho tung dich vu
			        	for(int i = 0; i < lengthArr; i++) {
			        		//arrDV[i].setMaDichVu(DV.getInt("MaDichVu"));
			        		arrDV[i].setTenDichVu(DV.getString("TenDichVu"));
			        		arrDV[i].setMaCTDichVu(DV.getInt("MaCTDichVu"));
			        		arrDV[i].setGiaDichVu(DV.getInt("GiaDichVu"));
			        	}
			        		
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnLoadData.setBounds(586, 230, 109, 30);
		getContentPane().add(btnLoadData);
		
		JLabel lblMadichvu = new JLabel("M\u00E3 d\u1ECBch v\u1EE5");
		lblMadichvu.setBounds(27, 59, 109, 29);
		getContentPane().add(lblMadichvu);
		
		JLabel lblTnDchVu = new JLabel("T\u00EAn d\u1ECBch v\u1EE5");
		lblTnDchVu.setBounds(27, 101, 109, 14);
		getContentPane().add(lblTnDchVu);
		
		txtTenDichVu = new JTextField();
		txtTenDichVu.setBounds(152, 98, 169, 20);
		getContentPane().add(txtTenDichVu);
		txtTenDichVu.setColumns(10);
		
		txtCTDV = new JTextField();
		txtCTDV.setBounds(152, 136, 169, 20);
		getContentPane().add(txtCTDV);
		txtCTDV.setColumns(10);
		
		JLabel lblMCtDch = new JLabel("M\u00E3 CT d\u1ECBch v\u1EE5");
		lblMCtDch.setBounds(27, 139, 109, 14);
		getContentPane().add(lblMCtDch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dichvu_DTO = new DichVu_DTO( ); 

				dichvu_DTO.setTenDichVu( txtTenDichVu.getText() );
				dichvu_DTO.setGiaDichVu( Integer.parseInt(txtGiaDichVu.getText()));
				dichvu_DTO.setMaDichVu( Integer.parseInt(txtMaDichVu.getText()));
//				dichvu_DTO.setMaCTDichVu( cbmCTDichVu.getSelectedIndex() );
				
				//boolean isValidPass = Arrays.equals(textPassword.getPassword(),textPasswordRetype.getPassword());

				// int a = Integer.valueOf( txtMaDichVu.getText());
						
					 if(  DichVu_BUS.Update(dichvu_DTO) == true)
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
					 else
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);

				
			}
		});
		btnUpdate.setBounds(27, 226, 134, 38);
		getContentPane().add(btnUpdate);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSelect.setBounds(794, 382, 89, 23);
		getContentPane().add(btnSelect);
		
		
		cbxMaDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valueSelect = cbxMaDV.getSelectedItem().toString();
				for(int i = 0; i < lengthArr; i++) {
					try {
						if( DV.getString("MaDichVu") == valueSelect ) {
							txtTenDichVu.setText( DV.getString("TenDichVu") );
							txtCTDV.setText(DV.getString("TenCTDichVu"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		cbxMaDV.setBounds(576, 352, 169, 20);
		getContentPane().add(cbxMaDV);
		
		txtMaDichVu = new JTextField();
		txtMaDichVu.setColumns(10);
		txtMaDichVu.setBounds(152, 63, 169, 20);
		getContentPane().add(txtMaDichVu);
		
		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setColumns(10);
		txtGiaDichVu.setBounds(152, 169, 169, 20);
		getContentPane().add(txtGiaDichVu);
		
		JLabel lblGiaDichVu = new JLabel("Gia Dich Vu");
		lblGiaDichVu.setBounds(27, 171, 109, 14);
		getContentPane().add(lblGiaDichVu);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dichvu_DTO = new DichVu_DTO( ); 
				//dichvu_DTO.setTenDichVu( txtTenDichVu.getText() );
				//dichvu_DTO.setGiaDichVu( Integer.parseInt(txtGiaDichVu.getText()));
				dichvu_DTO.setMaDichVu( Integer.parseInt(txtMaDichVu.getText()));
//				dichvu_DTO.setMaCTDichVu( cbmCTDichVu.getSelectedIndex() );
				
				//boolean isValidPass = Arrays.equals(textPassword.getPassword(),textPasswordRetype.getPassword());

				// int a = Integer.valueOf( txtMaDichVu.getText());
						
					 if(  DichVu_BUS.Delete(dichvu_DTO) == true)
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
					 else
						 JOptionPane.showMessageDialog(null, "Update Dich Vu Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
			}
		});
		btndelete.setBounds(187, 226, 134, 38);
		getContentPane().add(btndelete);
//		

	}
}
