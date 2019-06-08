package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;

import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.KhachHang_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_BUS.CTDichVu_BUS;
import QuanLyKS_BUS.DichVu_BUS;
import QuanLyKS_BUS.KhachHang_BUS;
import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_BUS.Phong_BUS;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		ArrayList<LoaiPhong_DTO>  listLP = LoaiPhong_BUS.LoadListLP();
		
		String strTenLoaiPhong = Phong_BUS.getTenLoaiPhong(ctdp.getMaPhong());
		int iGiaPhong = Phong_BUS.getGiaPhong(ctdp.getMaPhong());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		String NgayNhan = sdf.format( ctdp.getNgayNhan());
 	 	String NgayTra = sdf.format( ctdp.getNgayTra() );
		String NgayThucHien = sdf.format( ctdp.getdtNgayThucHien() );
		modelBooking.addRow(new Object[] {ctdp.getMaPhong(), khDTO.getTenKH(), strTenLoaiPhong, iGiaPhong, NgayNhan, NgayTra});
		 
		
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
		
		ArrayList<DichVu_DTO> listDV = DichVu_BUS.getListDV();
		for(int i = 0; i < listCTDV.size(); i++) {
			for(int j = 0; j < listDV.size(); j++){
				if(listDV.get(j).getMaDichVu() == listCTDV.get(i).getMaDichVu())
					modelDV.addRow(new Object[] {listDV.get(j).getTenDichVu(), listCTDV.get(i).getSoLuong(), 
							listCTDV.get(i).getTongTienDichVu()});
			}
			
		}		
		
		JButton btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
		btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CTDatPhong_BUS.Insert(ctdp);
				for(int i = 0; i < listCTDV.size(); i++) {
					CTDichVu_BUS.Insert(listCTDV.get(i));
				}
				KhachHang_BUS.Insert(khDTO);
			}
		});
		btnDatPhong.setBounds(433, 385, 97, 25);
		getContentPane().add(btnDatPhong);

	}
}
