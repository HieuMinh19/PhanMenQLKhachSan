package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_DTO.LoaiPhong_DTO;
import javax.swing.JButton;

public class frmCapNhatLoaiPhong extends JInternalFrame {
	private JTextField txtTenLoaiPhong;
	private JTextField txtGiaPhong;
	private JTable table;
	private int selectMaLoaiPhong;
//	private LoaiPhong_BUS loaiphong_bus;
	private JTextField txtMoTa;
	ArrayList<LoaiPhong_DTO> dslp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCapNhatLoaiPhong frame = new frmCapNhatLoaiPhong();
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
	public frmCapNhatLoaiPhong() {
		setBounds(100, 100, 586, 459);
		getContentPane().setLayout(null);
		
		JLabel lblCapNhat = new JLabel("Quản lý loại phòng");
		lblCapNhat.setBounds(198, 11, 131, 14);
		getContentPane().add(lblCapNhat);
		
		JLabel TenLoaiPhong = new JLabel("Tên loại phòng");
		TenLoaiPhong.setBounds(38, 223, 86, 14);
		getContentPane().add(TenLoaiPhong);
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setBounds(153, 220, 242, 20);
		getContentPane().add(txtTenLoaiPhong);
		txtTenLoaiPhong.setColumns(10);
		
		JLabel GiaPhong = new JLabel("Giá phòng");
		GiaPhong.setBounds(38, 248, 86, 14);
		getContentPane().add(GiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(153, 245, 242, 20);
		getContentPane().add(txtGiaPhong);
		
		JButton btnCapNhat = new JButton("Cập nhât");
		btnCapNhat.setBounds(153, 365, 89, 23);
		//
		
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(306, 365, 89, 23);
		getContentPane().add(btnXoa);
		///
//		loaiphong_bus = new LoaiPhong_BUS();
		
		JScrollPane srcListLoaiPhong = new JScrollPane();
		srcListLoaiPhong.setBounds(65, 41, 375, 123);
		getContentPane().add(srcListLoaiPhong);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã loại phòng", "Tên loại phòng", "Giá phòng"
				}
		);
		table = new JTable(m);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			    int[] selectedRow = table.getSelectedRows();
			    
			
			    for (int i = 0; i < selectedRow.length; i++) {
//			    	System.out.println(selectedColumns.length);
			    	selectMaLoaiPhong = (int) table.getValueAt(selectedRow[i], 0);
			        txtTenLoaiPhong.setText((String) table.getValueAt(selectedRow[i], 1));
			        txtGiaPhong.setText(table.getValueAt(selectedRow[i], 2).toString());
			        txtMoTa.setText(dslp.get(table.getSelectedRow()).getMoTa());
			    }
			  }

        });
		table.setRowSelectionAllowed(true);
		srcListLoaiPhong.setViewportView(table);
		JButton btnLoadDanhSach = new JButton("Load Loai Phong");
		btnLoadDanhSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				dslp = LoaiPhong_BUS.selectAll();
				dslp.forEach(lp -> m.addRow(new Object[]{lp.getMaLoaiPhong(), lp.getTenLoaiPhong(),lp.getGiaPhong()}));
			}
		}); 
		btnLoadDanhSach.setBounds(152, 175, 202, 25);
		getContentPane().add(btnLoadDanhSach);
		
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean result = LoaiPhong_BUS.Update(new LoaiPhong_DTO(selectMaLoaiPhong, txtTenLoaiPhong.getText(),Integer.parseInt(txtGiaPhong.getText()),txtMoTa.getText()));
				if(result) {
					
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dslp = LoaiPhong_BUS.LoadListLP();
					dslp.forEach(lp -> m.addRow(new Object[]{lp.getMaLoaiPhong(),lp.getTenLoaiPhong(),lp.getGiaPhong()}));
				}
			}
		});
		//
		getContentPane().add(btnCapNhat);
		
		JLabel lblMoTa = new JLabel("Mo ta");
		lblMoTa.setBounds(38, 281, 56, 16);
		getContentPane().add(lblMoTa);
		
		txtMoTa = new JTextField();
		txtMoTa.setBounds(153, 278, 242, 74);
		getContentPane().add(txtMoTa);
		txtMoTa.setColumns(10);
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = LoaiPhong_BUS.Delete(selectMaLoaiPhong);
				if(result) {
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					dslp = LoaiPhong_BUS.LoadListLP();
					dslp.forEach(lp -> m.addRow(new Object[]{lp.getMaLoaiPhong(), lp.getTenLoaiPhong(),lp.getGiaPhong()}));
				}
			}
		});
	}
}
