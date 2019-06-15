package QuanLyKS_GUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.ibm.icu.text.SimpleDateFormat;
import com.sun.org.apache.xerces.internal.impl.dv.xs.ListDV;

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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class frmBooking_Step4 extends JInternalFrame {
	private JTable tbThongTinChung;
	private int selectedRow;
	private int selectedMaCTDP;

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
	public frmBooking_Step4(ArrayList<ArrayList<CTDichVu_DTO>> listCTDVs, KhachHang_DTO khDTO) {
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JScrollPane scrBooking = new JScrollPane();
		scrBooking.setBounds(42, 133, 800, 280);
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
		DefaultTableModel modelDV = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Tên dịch vụ", "Số lượng", "Tổng tiền dịch vụ"
				}
			);
		
		ListSelectionModel cellSelectionModel = tbThongTinChung.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedRow = tbThongTinChung.getSelectedRow() < 0 ? 0 : tbThongTinChung.getSelectedRow();
//			    int[] selectedRowColums = tbThongTinChung.getSelectedRows();
			    int maCTDP = frmBooking_Step1.listCTDP.get(selectedRow).getMaCTDatPhong();
//		        ArrayList<DichVu_DTO> _listDV = new ArrayList<DichVu_DTO>();
				if (modelDV.getRowCount() > 0) {
				    for (int i = modelDV.getRowCount() - 1; i > -1; i--) {
				    	modelDV.removeRow(i);
				    }
				}
				for (int i = 0; i < frmBooking_Step1.listBookingDVs.size(); i++) {
		        	ArrayList<CTDichVu_DTO> listDV = frmBooking_Step1.listBookingDVs.get(i);
		        	boolean isMatched = false;
		        	for (int j = 0; j < listDV.size(); j++) {
		        		isMatched = listDV.get(j).getMaCTDatPhong() == maCTDP;
		        		if(isMatched) break;
					}
	        		if(isMatched) {
	        			listDV.forEach(dv -> {
	        				DichVu_DTO _dv = DichVu_BUS.getListDV(dv.getMaDichVu());
		        			modelDV.addRow(new Object[] {_dv != null ? _dv.getTenDichVu() : "", dv.getSoLuong(), dv.getTongTienDichVu()});
	        			});
	        			break;
	        		}
		        }
			  }

        });
	    tbThongTinChung.setRowSelectionAllowed(true);
	    scrBooking.setViewportView(tbThongTinChung);
		
		frmBooking_Step1.listCTDP.forEach(ctdp -> {
			String strTenLoaiPhong = Phong_BUS.getTenLoaiPhong(ctdp.getMaPhong());
			int iGiaPhong = Phong_BUS.getGiaPhong(ctdp.getMaPhong());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 		String NgayNhan = sdf.format( ctdp.getNgayNhan());
	 	 	String NgayTra = sdf.format( ctdp.getNgayTra() );
//			String NgayThucHien = sdf.format( ctdp.getdtNgayThucHien() );
			modelBooking.addRow(new Object[] {ctdp.getMaPhong(), khDTO.getTenKH(), strTenLoaiPhong, iGiaPhong, NgayNhan, NgayTra});
		});
		
		 
		
//		ArrayList<DichVu_DTO> listDV = DichVu_BUS.getListDV();
//		for(int i = 0; i < listCTDV.size(); i++) {
//			for(int j = 0; j < listDV.size(); j++){
//				if(listDV.get(j).getMaDichVu() == listCTDV.get(i).getMaDichVu())
//					modelDV.addRow(new Object[] {listDV.get(j).getTenDichVu(), listCTDV.get(i).getSoLuong(), 
//							listCTDV.get(i).getTongTienDichVu()});
//			}
//			
//		}		
		
		JButton btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
		btnDatPhong.setBackground(Color.ORANGE);
		btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmBooking_Step1.listCTDP.forEach(ctdp -> {
//					String strTenLoaiPhong = Phong_BUS.getTenLoaiPhong(ctdp.getMaPhong());
//					int iGiaPhong = Phong_BUS.getGiaPhong(ctdp.getMaPhong());
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			 		String NgayNhan = sdf.format( ctdp.getNgayNhan());
//			 	 	String NgayTra = sdf.format( ctdp.getNgayTra() );
//					String NgayThucHien = sdf.format( ctdp.getdtNgayThucHien() );
//					
//					System.err.println("NgayThucHien trong str4" +""+ NgayThucHien);
					
					
				//	dtngaysinh.getDate().getTime()
//					modelBooking.addRow(new Object[] {ctdp.getMaPhong(), khDTO.getTenKH(), strTenLoaiPhong, iGiaPhong, NgayNhan, NgayTra});
					
					ctdp.setMaKhachHang(khDTO.getMaKH());
					CTDatPhong_BUS.Insert(ctdp);
					frmBooking_Step1.listBookingDVs.forEach(listCTDV -> {
						listCTDV.forEach(ctdv -> CTDichVu_BUS.Insert(ctdv));
					});
				});
				KhachHang_BUS.Insert(khDTO);
					
				
					
				///delete lisst da save
				frmBooking_Step1.listCTDP.clear();
				frmBooking_Step1.listBookingDVs.clear();
				///
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
