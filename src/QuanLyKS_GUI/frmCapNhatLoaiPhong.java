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
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JLabel lblCapNhat = new JLabel("Quản lý loại phòng");
		lblCapNhat.setForeground(Color.BLUE);
		lblCapNhat.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCapNhat.setBounds(313, 13, 242, 42);
		getContentPane().add(lblCapNhat);
		
		JLabel TenLoaiPhong = new JLabel("Tên loại phòng");
		TenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TenLoaiPhong.setBounds(367, 126, 125, 23);
		getContentPane().add(TenLoaiPhong);
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenLoaiPhong.setBounds(504, 124, 327, 30);
		getContentPane().add(txtTenLoaiPhong);
		txtTenLoaiPhong.setColumns(10);
		
		JLabel GiaPhong = new JLabel("Giá phòng");
		GiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GiaPhong.setBounds(403, 195, 89, 23);
		getContentPane().add(GiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(504, 193, 327, 30);
		getContentPane().add(txtGiaPhong);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhat.setBounds(503, 445, 150, 40);
		//
		
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(681, 445, 150, 40);
		getContentPane().add(btnXoa);
		///
//		loaiphong_bus = new LoaiPhong_BUS();
		
		JScrollPane srcListLoaiPhong = new JScrollPane();
		srcListLoaiPhong.setBounds(38, 126, 300, 305);
		getContentPane().add(srcListLoaiPhong);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã loại phòng", "Tên loại phòng", "Giá phòng"
				}
		);
		table = new JTable(m);
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		JButton btnLoadDanhSach = new JButton("Danh sách loại phòng");
		btnLoadDanhSach.setBackground(Color.GREEN);
		btnLoadDanhSach.setForeground(Color.BLACK);
		btnLoadDanhSach.setFont(new Font("Tahoma", Font.BOLD, 18));
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
		btnLoadDanhSach.setBounds(77, 445, 242, 40);
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
		
		JLabel lblMoTa = new JLabel("Mô tả");
		lblMoTa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMoTa.setBounds(435, 282, 57, 23);
		getContentPane().add(lblMoTa);
		
		txtMoTa = new JTextField();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMoTa.setBounds(503, 282, 328, 116);
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
