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
import java.awt.Font;
import java.awt.Color;

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
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		txtTenCongViec = new JTextField();
		txtTenCongViec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenCongViec.setColumns(10);
		txtTenCongViec.setBounds(303, 350, 300, 30);
		getContentPane().add(txtTenCongViec);
		
		JComboBox<NhanVien_DTO> cbxTenNhanVien = new JComboBox<NhanVien_DTO>();
		cbxTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbxTenNhanVien.setBounds(303, 406, 300, 30);
		getContentPane().add(cbxTenNhanVien);
		
		JLabel lblTnCngVic = new JLabel("Tên công việc");
		lblTnCngVic.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnCngVic.setBounds(178, 352, 113, 22);
		getContentPane().add(lblTnCngVic);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(178, 408, 113, 22);
		getContentPane().add(lblTnNhnVin);
		
		JLabel lblNgyLmVic = new JLabel("Ngày làm việc");
		lblNgyLmVic.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgyLmVic.setBounds(182, 463, 110, 22);
		getContentPane().add(lblNgyLmVic);
		
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setBounds(298, 540, 150, 40);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setBounds(482, 540, 150, 40);
		getContentPane().add(btnXoa);
		
		JDateChooser dtNgayLamViec = new JDateChooser();
		dtNgayLamViec.setBounds(303, 463, 300, 30);
		getContentPane().add(dtNgayLamViec);
		dtNgayLamViec.setDateFormatString("dd/MM/yyyy");

		JScrollPane srcListNhanVien = new JScrollPane();
		srcListNhanVien.setBounds(126, 74, 626, 123);
		getContentPane().add(srcListNhanVien);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã phân công", "Ngày làm việc", "Tên công việc", "Tên nhân viên"
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
		JButton btnLoadDanhSach = new JButton("Danh sách phân công");
		btnLoadDanhSach.setBackground(Color.GREEN);
		btnLoadDanhSach.setFont(new Font("Tahoma", Font.BOLD, 18));
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
		btnLoadDanhSach.setBounds(303, 210, 270, 40);
		getContentPane().add(btnLoadDanhSach);
		
		JLabel label = new JLabel("Tra c\u1EE9u th\u00F4ng tin nh\u00E2n vi\u00EAn");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(271, 13, 322, 37);
		getContentPane().add(label);
		
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