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
import QuanLyKS_DTO.ChucVu_DTO;
import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_DTO.CTDatPhong_DTO;


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

public class frmQLDatPhong extends JInternalFrame {
	private JTable table;
	private CTDatPhong_BUS bus;
	private ChucVu_BUS cv_bus;
	private int selectedRow;
	private int selectedMaNhanVien;
	private int selectedChucVuIndex;
	private ArrayList<CTDatPhong_DTO> ctdp;
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
	public frmQLDatPhong() {
		bus=new CTDatPhong_BUS();
		cv_bus = new ChucVu_BUS();
		ctdp = new ArrayList<CTDatPhong_DTO>();
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JLabel lblNgyTr = new JLabel("Ngày trả");
		lblNgyTr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgyTr.setBounds(443, 399, 108, 22);
		getContentPane().add(lblNgyTr);
		
		JLabel lblNgyNhn = new JLabel("Ngày Nhận");
		lblNgyNhn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgyNhn.setBounds(101, 391, 119, 22);
		getContentPane().add(lblNgyNhn);
		
		
		JButton btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setBounds(252, 473, 150, 40);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(516, 473, 150, 40);
		getContentPane().add(btnXoa);
		
		JDateChooser date_NgaySinh = new JDateChooser();
		date_NgaySinh.setBounds(208, 391, 194, 30);
		getContentPane().add(date_NgaySinh); 
		date_NgaySinh.setDateFormatString("dd/MM/yyyy");
		
		JDateChooser date_NgayVaoLam = new JDateChooser();
		date_NgayVaoLam.setBounds(581, 399, 194, 30);
		getContentPane().add(date_NgayVaoLam);
		date_NgayVaoLam.setDateFormatString("dd/MM/yyyy");

		JScrollPane srcListNhanVien = new JScrollPane();
		srcListNhanVien.setBounds(50, 68, 766, 198);
		getContentPane().add(srcListNhanVien);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Tên Khách Hàng","Ngày Thực Hiện", "Ngày Nhận", "Ngày Trả", "Loại Phòng"
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
			        //txtTenNhanVien.setText((String) table.getValueAt(selectedRowColums[i], 1));
			       // txtCMND.setText(table.getValueAt(selectedRowColums[i], 3).toString());
			        date_NgayVaoLam.setDate((Date) table.getValueAt(selectedRowColums[i], 4));
			        date_NgaySinh.setDate((Date) table.getValueAt(selectedRowColums[i], 2));   
//			        (string) table.getValueAt(selectedRow[i], 5);
			    }
			 //   selectedChucVuIndex = dscv.indexOf(ctdp.get(selectedRow).getChucVu());
		        //cbChucVu.setSelectedIndex(selectedChucVuIndex);//(table.getValueAt(selectedRowColums[i], 5));
			  }

        });
		table.setRowSelectionAllowed(true);
		srcListNhanVien.setViewportView(table);

		//dscv = cv_bus.selectAll();
		//dscv.forEach(cv -> cbChucVu.addItem(cv));
		
//		------------------------------------------------
		
//		------------------------------------------------
		JButton btnLoadDanhSach = new JButton("Load");
		btnLoadDanhSach.setBackground(Color.GREEN);
		btnLoadDanhSach.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoadDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				//ctdp = bus.LoadListNV();
				//ctdp.forEach(nv -> m.addRow(new Object[]{nv.getKhachHang().getHoTen(), nv.getNgayThucHien(),nv.getNgayNhan(),nv.getNgayTra(),nv.getLoaiPhong().getTenLoaiPhong()}));
			}
		}); 
		btnLoadDanhSach.setBounds(325, 284, 236, 40);
		getContentPane().add(btnLoadDanhSach);
		
		JLabel lblQunLNhn = new JLabel("Quản Lý Đặt Phòng");
		lblQunLNhn.setForeground(Color.BLUE);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQunLNhn.setBounds(319, 13, 242, 42);
		getContentPane().add(lblQunLNhn);
		
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				boolean result = NhanVien_BUS.Update(new NhanVien_DTO(selectedMaNhanVien, txtTenNhanVien.getText(), new Date(date_NgaySinh.getDate().getTime()), Integer.parseInt(txtCMND.getText()), new Date(date_NgayVaoLam.getDate().getTime()), ((ChucVu_DTO) cbChucVu.getSelectedItem()).getMaChucVu()));
//				if(result) {
//					if (m.getRowCount() > 0) {
//					    for (int i = m.getRowCount() - 1; i > -1; i--) {
//					        m.removeRow(i);
//					    }
//					}
//					ctdp = bus.LoadListNV();
//					ctdp.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam(),nv.getChucVu().getTenChucVu()}));
//				}
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				boolean result = NhanVien_BUS.Delete(selectedMaNhanVien);
//				if(result) {
//					if (m.getRowCount() > 0) {
//					    for (int i = m.getRowCount() - 1; i > -1; i--) {
//					        m.removeRow(i);
//					    }
//					}
//					ctdp = bus.LoadListNV();
//					ctdp.forEach(nv -> m.addRow(new Object[]{nv.getMaNhanVien(), nv.getTenNhanVien(),nv.getNgaySinh(), nv.getCMND(),nv.getNgayVaoLam()}));
//				}
			}
		});
		
	}
}