package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_BUS.Phong_BUS;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_DTO.Phong_DTO;
import net.proteanit.sql.DbUtils;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmDanhSachPhong extends JInternalFrame {
	private JTable table;
	private LoaiPhong_BUS bus;
	private Phong_BUS pbus;
	private JTextField txtMaPhong;
	private JTextField txtLoaiPhong;
	private ArrayList<Phong_DTO> dsp;
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
		pbus = new Phong_BUS();
		setBounds(100, 100, 623, 446);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 42, 336, 159);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		JLabel lblDanhSachPhong = new JLabel("Danh Sach Phong");
		lblDanhSachPhong.setBounds(206, 13, 150, 16);
		getContentPane().add(lblDanhSachPhong);

		DefaultTableModel m = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Ma Phong", "Loai Phong"
				}
			);
		table = new JTable(m);
		scrollPane.setViewportView(table);
		
		JButton btnLoadListPhong = new JButton("Load Danh Sach Phong");
		btnLoadListPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsp = pbus.LoadListPhong();
				dsp.forEach(p -> m.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong().getTenLoaiPhong()}));
				
			}
		});
		btnLoadListPhong.setBounds(181, 214, 185, 25);
		getContentPane().add(btnLoadListPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(163, 266, 276, 22);
		getContentPane().add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBounds(163, 301, 276, 22);
		getContentPane().add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);
		
		JLabel lblMaphong = new JLabel("MaPhong");
		lblMaphong.setBounds(35, 269, 56, 16);
		getContentPane().add(lblMaphong);
		
		JLabel lblLoaiPhong = new JLabel("Loai Phong");
		lblLoaiPhong.setBounds(35, 304, 116, 16);
		getContentPane().add(lblLoaiPhong);
		
		JButton btnCapNhat = new JButton("Cap Nhat");
		btnCapNhat.setBounds(103, 336, 97, 25);
		getContentPane().add(btnCapNhat);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.setBounds(342, 336, 97, 25);
		getContentPane().add(btnXoa);

	}
}