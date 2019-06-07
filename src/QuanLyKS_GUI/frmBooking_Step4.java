package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.KhachHang_DTO;

import javax.swing.JLabel;
import javax.swing.JButton;

public class frmBooking_Step4 extends JInternalFrame {
	private JTable tbThongTinChung;
	private JTable tbThongTinDichVu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmBooking_Step4(CTDatPhong_DTO ctdp, ArrayList<CTDichVu_DTO> listCTDV, KhachHang_DTO khDTO) {
		setBounds(100, 100, 1046, 516);
		getContentPane().setLayout(null);
		
		JScrollPane scrBooking = new JScrollPane();
		scrBooking.setBounds(40, 39, 932, 164);
		DefaultTableModel modelBooking = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Ma phong", "Ten khach hang", "Ten loai phong","Gia phong", "Ngay nhan", "Ngay tra"
				}
			);
		tbThongTinChung = new JTable(modelBooking);
		scrBooking.setViewportView(tbThongTinChung);
		getContentPane().add(scrBooking);
		
		modelBooking.addRow(new Object[] {ctdp.getMaPhong(),khDTO.getTenKH(), ctdp.getMaNhanVien(), ctdp.getdtNgayThucHien(), ctdp.getNgayTra(), ctdp.getNgayTra()});
		
		
		JScrollPane scrDV = new JScrollPane();
		scrDV.setBounds(40, 253, 556, 98);
		DefaultTableModel modelDV = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Ten dich vu", "So luong", "Tong tien dich vu"
				}
			);
		tbThongTinDichVu = new JTable(modelDV);
		scrDV.setViewportView(tbThongTinDichVu);
		getContentPane().add(scrDV);
		
		listCTDV.forEach(ctdv->modelDV.addRow(new Object[] {ctdv.getMaDichVu(), ctdv.getSoLuong(), ctdv.getTongTienDichVu()}));
		
		
		JButton btnDatPhong = new JButton("Dat phong");
		btnDatPhong.setBounds(433, 385, 97, 25);
		getContentPane().add(btnDatPhong);

	}
}
