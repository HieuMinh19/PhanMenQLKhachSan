package QuanLyKS_GUI;

import java.awt.Button;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;


import com.toedter.calendar.JDateChooser;

import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DTO.NhanVien_DTO;


import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Choice;

public class frmCapNhatNhanVien extends JInternalFrame {
	private JTextField txtTenNhanVien;
	private JTextField txtCMND;
	private JTable table;
	private NhanVien_BUS bus;
	private int selectedMaNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCapNhatNhanVien frame = new frmCapNhatNhanVien();
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
	public frmCapNhatNhanVien() {
		bus=new NhanVien_BUS();
		setBounds(100, 100, 770, 596);
		getContentPane().setLayout(null);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(214, 219, 320, 20);
		getContentPane().add(txtTenNhanVien);
		
		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(214, 277, 320, 20);
		getContentPane().add(txtCMND);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(214, 326, 320, 20);
		getContentPane().add(comboBox);
		
		JLabel label = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		label.setBounds(54, 218, 122, 22);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("CMND");
		label_1.setBounds(54, 276, 75, 22);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Ch\u1EE9c v\u1EE5");
		label_2.setBounds(54, 325, 63, 22);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
		label_3.setBounds(54, 379, 122, 22);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Ng\u00E0y sinh");
		label_4.setBounds(54, 438, 108, 22);
		getContentPane().add(label_4);
		
		
		JButton btnCapNhat = new JButton("Cap Nhat");
		btnCapNhat.setBounds(269, 501, 219, 25);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.setBounds(573, 476, 98, 71);
		getContentPane().add(btnXoa);
		
		JDateChooser date_NgaySinh = new JDateChooser();
		date_NgaySinh.setBounds(214, 438, 320, 25);
		getContentPane().add(date_NgaySinh);
		date_NgaySinh.setDateFormatString("dd/MM/yyyy");
		
		JDateChooser date_NgayVaoLam = new JDateChooser();
		date_NgayVaoLam.setBounds(214, 379, 320, 25);
		getContentPane().add(date_NgayVaoLam);
		date_NgayVaoLam.setDateFormatString("dd/MM/yyyy");

		JScrollPane srcListNhanVien = new JScrollPane();
		srcListNhanVien.setBounds(65, 25, 605, 123);
		getContentPane().add(srcListNhanVien);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MaNhanVien", "TenNhanVien", "NgaySinh", "CMND", "NgayVaoLam"
			}
		);
		table = new JTable(m);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			    int[] selectedRow = table.getSelectedRows();
			    int[] selectedColumns = table.getSelectedColumns();
			
			    for (int i = 0; i < selectedRow.length; i++) {
//			    	System.out.println(selectedColumns.length);
			    	selectedMaNhanVien = (int) table.getValueAt(selectedRow[i], 0);
			        txtTenNhanVien.setText((String) table.getValueAt(selectedRow[i], 1));
			        txtCMND.setText(table.getValueAt(selectedRow[i], 3).toString());
			        date_NgayVaoLam.setDate((Date) table.getValueAt(selectedRow[i], 4));
			        date_NgaySinh.setDate((Date) table.getValueAt(selectedRow[i], 2));   
			    }
			  }

        });
		table.setRowSelectionAllowed(true);
		srcListNhanVien.setViewportView(table);
		JButton btnLoadDanhSach = new JButton("Load Danh Sach Nhan Vien");
		btnLoadDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				ArrayList<NhanVien_DTO> dsnv = bus.LoadListNV();
				dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
			}
		}); 
		btnLoadDanhSach.setBounds(257, 163, 202, 25);
		getContentPane().add(btnLoadDanhSach);
		
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = NhanVien_BUS.Update(new NhanVien_DTO(selectedMaNhanVien, txtTenNhanVien.getText(), new Date(date_NgaySinh.getDate().getTime()), Integer.parseInt(txtCMND.getText()), new Date(date_NgayVaoLam.getDate().getTime()), 0));
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					ArrayList<NhanVien_DTO> dsnv = bus.LoadListNV();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
				}
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = NhanVien_BUS.Delete(selectedMaNhanVien);
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					ArrayList<NhanVien_DTO> dsnv = bus.LoadListNV();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
				}
			}
		});
	}
}