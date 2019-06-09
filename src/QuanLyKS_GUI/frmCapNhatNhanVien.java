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

import QuanLyKS_BUS.ChucVu_BUS;
import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DTO.ChucVu_DTO;
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
import java.awt.Font;
import java.awt.Color;

public class frmCapNhatNhanVien extends JInternalFrame {
	private JTextField txtTenNhanVien;
	private JTextField txtCMND;
	private JTable table;
	private NhanVien_BUS bus;
	private ChucVu_BUS cv_bus;
	private int selectedRow;
	private int selectedMaNhanVien;
	private int selectedChucVuIndex;
	private ArrayList<NhanVien_DTO> dsnv;
	private ArrayList<ChucVu_DTO> dscv;

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
		cv_bus = new ChucVu_BUS();
		dsnv = new ArrayList<NhanVien_DTO>();
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(217, 364, 349, 30);
		getContentPane().add(txtTenNhanVien);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(217, 432, 170, 30);
		getContentPane().add(txtCMND);
		
		JComboBox<ChucVu_DTO> cbChucVu = new JComboBox<ChucVu_DTO>();
		cbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbChucVu.setBounds(217, 496, 170, 30);
		getContentPane().add(cbChucVu);
		
		JLabel lblHTn = new JLabel("Họ tên");
		lblHTn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHTn.setBounds(156, 367, 53, 22);
		getContentPane().add(lblHTn);
		
		JLabel label_1 = new JLabel("CMND");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(156, 435, 49, 22);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Ch\u1EE9c v\u1EE5");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(140, 498, 65, 22);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(458, 496, 108, 22);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Ng\u00E0y sinh");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(488, 432, 78, 22);
		getContentPane().add(label_4);
		
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setBounds(252, 573, 150, 40);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(515, 573, 150, 40);
		getContentPane().add(btnXoa);
		
		JDateChooser date_NgaySinh = new JDateChooser();
		date_NgaySinh.setBounds(578, 432, 150, 30);
		getContentPane().add(date_NgaySinh); 
		date_NgaySinh.setDateFormatString("dd/MM/yyyy");
		
		JDateChooser date_NgayVaoLam = new JDateChooser();
		date_NgayVaoLam.setBounds(578, 496, 150, 30);
		getContentPane().add(date_NgayVaoLam);
		date_NgayVaoLam.setDateFormatString("dd/MM/yyyy");

		JScrollPane srcListNhanVien = new JScrollPane();
		srcListNhanVien.setBounds(50, 68, 766, 198);
		getContentPane().add(srcListNhanVien);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã nhân viên", "Tên nhân viên", "Ngày sinh", "CMND", "Ngày vào làm", "Tên chức vụ"
			}
		);
		table = new JTable(m);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedRow = table.getSelectedRow() < 0 ? 0 : table.getSelectedRow();
			    int[] selectedRowColums = table.getSelectedRows();
			
			    for (int i = 0; i < selectedRowColums.length; i++) {
//			    	System.out.println(selectedColumns.length);
			    	selectedMaNhanVien = (int) table.getValueAt(selectedRowColums[i], 0);
			        txtTenNhanVien.setText((String) table.getValueAt(selectedRowColums[i], 1));
			        txtCMND.setText(table.getValueAt(selectedRowColums[i], 3).toString());
			        date_NgayVaoLam.setDate((Date) table.getValueAt(selectedRowColums[i], 4));
			        date_NgaySinh.setDate((Date) table.getValueAt(selectedRowColums[i], 2));   
//			        (string) table.getValueAt(selectedRow[i], 5);
			    }
			    selectedChucVuIndex = dscv.indexOf(dsnv.get(selectedRow).getChucVu());
		        cbChucVu.setSelectedIndex(selectedChucVuIndex);//(table.getValueAt(selectedRowColums[i], 5));
			  }

        });
		table.setRowSelectionAllowed(true);
		srcListNhanVien.setViewportView(table);

		dscv = cv_bus.selectAll();
		dscv.forEach(cv -> cbChucVu.addItem(cv));
		
//		------------------------------------------------
		
//		------------------------------------------------
		JButton btnLoadDanhSach = new JButton("Danh sách nhân viên");
		btnLoadDanhSach.setBackground(Color.GREEN);
		btnLoadDanhSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoadDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				dsnv = bus.LoadListNV();
				dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam(),nv.getChucVu().getTenChucVu()}));
			}
		}); 
		btnLoadDanhSach.setBounds(325, 284, 236, 40);
		getContentPane().add(btnLoadDanhSach);
		
		JLabel lblQunLNhn = new JLabel("Quản lý nhân viên");
		lblQunLNhn.setForeground(Color.BLUE);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQunLNhn.setBounds(319, 13, 242, 42);
		getContentPane().add(lblQunLNhn);
		
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = NhanVien_BUS.Update(new NhanVien_DTO(selectedMaNhanVien, txtTenNhanVien.getText(), new Date(date_NgaySinh.getDate().getTime()), Integer.parseInt(txtCMND.getText()), new Date(date_NgayVaoLam.getDate().getTime()), ((ChucVu_DTO) cbChucVu.getSelectedItem()).getMaChucVu()));
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dsnv = bus.LoadListNV();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam(),nv.getChucVu().getTenChucVu()}));
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
					dsnv = bus.LoadListNV();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
				}
			}
		});
		
	}
}