package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import net.proteanit.sql.DbUtils;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmDanhSachPhong extends JInternalFrame {
	private JTable table;
	private LoaiPhong_BUS bus;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDanhSachPhong frame = new frmDanhSachPhong();
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
	public frmDanhSachPhong() {
		bus = new LoaiPhong_BUS();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 45, 336, 206);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblDanhSachPhong = new JLabel("Danh Sach Phong");
		lblDanhSachPhong.setBounds(143, 16, 150, 16);
		getContentPane().add(lblDanhSachPhong);
		
		DefaultTableModel m = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"MaLoaiPhong", "TenLoaiPhong", "GiaPhong"
				}
			);
		table = new JTable(m);
		scrollPane.setViewportView(table);
		
		ArrayList<LoaiPhong_DTO> ds = bus.selectAll();
		ds.forEach(p -> m.addRow(new Object[]{p.getMaLoaiPhong(), p.getTenLoaiPhong(),p.getGiaPhong()}));
		
	}
}
