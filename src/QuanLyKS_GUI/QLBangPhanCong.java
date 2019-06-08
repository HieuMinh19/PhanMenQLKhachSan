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
import QuanLyKS_BUS.BangPhanCong_BUS;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DTO.BangPhanCong_DTO;


import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Choice;

public class QLBangPhanCong extends JInternalFrame {
	private JTextField txtTenCongViec;
	private JTable table;
	private BangPhanCong_BUS bus;
	private NhanVien_BUS cv_bus;
	private int selectedRow;
	private int selectedMaNhanVien;
	private int selectedChucVuIndex;
	private ArrayList<BangPhanCong_DTO> dsnv;
	private ArrayList<NhanVien_DTO> dscv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLBangPhanCong frame = new QLBangPhanCong();
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
	public QLBangPhanCong() {
		bus=new BangPhanCong_BUS();
		cv_bus = new NhanVien_BUS();
		dsnv = new ArrayList<BangPhanCong_DTO>();
		setBounds(100, 100, 770, 596);
		getContentPane().setLayout(null);
		
		txtTenCongViec = new JTextField();
		txtTenCongViec.setColumns(10);
		txtTenCongViec.setBounds(214, 233, 320, 20);
		getContentPane().add(txtTenCongViec);
		
		JComboBox<NhanVien_DTO> cbxTenNhanVien = new JComboBox<NhanVien_DTO>();
		cbxTenNhanVien.setBounds(214, 295, 320, 20);
		getContentPane().add(cbxTenNhanVien);
		
		JLabel lblTnCngVic = new JLabel("Tên Công Việc");
		lblTnCngVic.setBounds(56, 232, 103, 22);
		getContentPane().add(lblTnCngVic);
		
		JLabel lblTnNhnVin = new JLabel("Tên Nhân Viên");
		lblTnNhnVin.setBounds(56, 294, 134, 22);
		getContentPane().add(lblTnNhnVin);
		
		JLabel lblNgyLmVic = new JLabel("Ngày Làm Việc");
		lblNgyLmVic.setBounds(56, 358, 122, 22);
		getContentPane().add(lblNgyLmVic);
		
		
		JButton btnCapNhat = new JButton("Cap Nhat");
		btnCapNhat.setBounds(92, 454, 157, 33);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.setBounds(362, 454, 134, 33);
		getContentPane().add(btnXoa);
		
		JDateChooser dtNgayLamViec = new JDateChooser();
		dtNgayLamViec.setBounds(214, 355, 320, 25);
		getContentPane().add(dtNgayLamViec);
		dtNgayLamViec.setDateFormatString("dd/MM/yyyy");

		JScrollPane srcListNhanVien = new JScrollPane();
		srcListNhanVien.setBounds(65, 25, 605, 123);
		getContentPane().add(srcListNhanVien);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Phân Công", "Ngày Làm Việc", "Tên Công Việc", "Tên Nhân Viên"
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
			        txtTenCongViec.setText((String) table.getValueAt(selectedRowColums[i], 2));
			    //    txtTenCongViec.setText(table.getValueAt(selectedRowColums[i], 3).toString());
			        dtNgayLamViec.setDate((Date) table.getValueAt(selectedRowColums[i], 1));
			        cbxTenNhanVien.setSelectedIndex(selectedChucVuIndex);
			    //    date_NgaySinh.setDate((Date) table.getValueAt(selectedRowColums[i], 2));   
//			        (string) table.getValueAt(selectedRow[i], 5);
			    }
			   selectedChucVuIndex = dscv.indexOf(dsnv.get(selectedRow).getNhanVien());
		        cbxTenNhanVien.setSelectedIndex(selectedChucVuIndex);//(table.getValueAt(selectedRowColums[i], 5));
			  }

        });
		table.setRowSelectionAllowed(true);
		srcListNhanVien.setViewportView(table);

		dscv = cv_bus.selectAll();
		dscv.forEach(cv -> cbxTenNhanVien.addItem(cv));
		
//		------------------------------------------------
		
//		------------------------------------------------
		JButton btnLoadDanhSach = new JButton("Load Danh Sach Phan Cong");
		btnLoadDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				dsnv = bus.LoadListBPC();
				dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaPhanCong(), nv.getNgayPhanCong(),nv.getLoaiCongViec(),nv.getNhanVien().getTenNhanVien()}));
			}
		}); 
		btnLoadDanhSach.setBounds(257, 163, 202, 25);
		getContentPane().add(btnLoadDanhSach);
		
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = BangPhanCong_BUS.Update(new BangPhanCong_DTO(selectedMaNhanVien, txtTenCongViec.getText(), new Date(dtNgayLamViec.getDate().getTime()),((NhanVien_DTO) cbxTenNhanVien.getSelectedItem()).getMaNhanVien()));
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dsnv = bus.LoadListBPC();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaPhanCong(), nv.getNgayPhanCong(),nv.getLoaiCongViec(),nv.getNhanVien().getTenNhanVien()}));
				}
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = BangPhanCong_BUS.Delete(selectedMaNhanVien);
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dsnv = bus.LoadListBPC();
					dsnv.forEach(nv -> m.addRow(new Object[]{nv.getMaPhanCong(), nv.getNgayPhanCong(),nv.getLoaiCongViec(),nv.getNhanVien().getTenNhanVien()}));
				}
			}
		});
		
	}
}