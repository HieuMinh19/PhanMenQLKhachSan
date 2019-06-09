package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;

import QuanLyKS_DTO.BangPhanCong_DTO;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.DichVu_DTO;
import QuanLyKS_DTO.KhachHang_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_BUS.CTDichVu_BUS;
import QuanLyKS_BUS.DichVu_BUS;
import QuanLyKS_BUS.HoaDon_BUS;
import QuanLyKS_BUS.KhachHang_BUS;
import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_BUS.Phong_BUS;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

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
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JScrollPane scrBooking = new JScrollPane();
		scrBooking.setBounds(42, 133, 800, 150);
		DefaultTableModel modelBooking = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Mã phòng", "Tên khách hàng", "Tên loại phòng","Giá phòng", "Ngày nhận", "Ngày trả"
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
		scrDV.setBounds(153, 318, 556, 98);
		DefaultTableModel modelDV = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Tên dịch vụ", "Số lượng", "Tổng tiền dịch vụ"
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
		btnDatPhong.setBackground(Color.ORANGE);
		btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					
					String strTenLoaiPhong = Phong_BUS.getTenLoaiPhong(ctdp.getMaPhong());
					int iGiaPhong = Phong_BUS.getGiaPhong(ctdp.getMaPhong());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			 		String NgayNhan = sdf.format( ctdp.getNgayNhan());
			 	 	String NgayTra = sdf.format( ctdp.getNgayTra() );
					String NgayThucHien = sdf.format( ctdp.getdtNgayThucHien() );
					
					System.err.println("NgayThucHien trong str4" +""+ NgayThucHien);
					
					
				//	dtngaysinh.getDate().getTime()
					modelBooking.addRow(new Object[] {ctdp.getMaPhong(), khDTO.getTenKH(), strTenLoaiPhong, iGiaPhong, NgayNhan, NgayTra});
					
					ctdp.setMaKhachHang(khDTO.getMaKH());
					CTDatPhong_BUS.Insert(ctdp);
					for(int i = 0; i < listCTDV.size(); i++) {
						CTDichVu_BUS.Insert(listCTDV.get(i));
					}
					KhachHang_BUS.Insert(khDTO);
					
					JOptionPane.showMessageDialog(null, "Dat Phong Thanh Cong", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
				
					frmDashboard.frmBooking4.setVisible(false);
				
			}
		});
		btnDatPhong.setBounds(334, 463, 248, 40);
		getContentPane().add(btnDatPhong);
		
		JLabel lblNewLabel = new JLabel("Ki\u1EC3m tra l\u1EA1i th\u00F4ng tin \u0111\u1EB7t ph\u00F2ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(236, 37, 366, 40);
		getContentPane().add(lblNewLabel);

	}
}
