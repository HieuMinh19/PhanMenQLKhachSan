	package QuanLyKS_GUI;
	
	import java.awt.EventQueue;
	import javax.swing.ListSelectionModel;
	import javax.swing.JInternalFrame;
	import javax.swing.JLabel;
	import java.sql.Date;
import javax.swing.JOptionPane;

import java.awt.Font;
	import javax.swing.JTextPane;
	import javax.swing.ListSelectionModel;
	import javax.swing.table.DefaultTableModel;

	import com.ibm.icu.text.Edits.Iterator;
import com.ibm.icu.text.NumberFormat;

import java.lang.NumberFormatException;
	import QuanLyKS_BUS.NhanVien_BUS;
import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.CTDichVu_DTO;
import QuanLyKS_DTO.HoaDon_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_BUS.CTDichVu_BUS;
import QuanLyKS_BUS.HoaDon_BUS;
	import javax.swing.JButton;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import java.awt.event.ActionListener;
	import java.sql.Date;
	import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.awt.event.ActionEvent;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	
	import java.util.concurrent.TimeUnit;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
	public class frmThanhToan extends JInternalFrame {
		int tienphong =0;
		int tiendichVu =0;
		int tongtien =0;
		int mactdatphong;
		int selectMaPhong;
		int selectMaCTDP;
		HoaDon_BUS bus;
		private JTable table;
		private JTable table_dich;
		private int selectedRow;
		private String giatien;
		private long giatien1;
		Date startDate = null;
		Date endDate = null;
		ArrayList<CTDatPhong_DTO> listPhongChuaThanhToan;
		ArrayList<CTDichVu_DTO> listctdv;
		CTDatPhong_DTO ctdp;
		private JTable table_phong;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frmThanhToan frame = new frmThanhToan();
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
		
		private void loadPhongChuaThanhToan(Date ng, DefaultTableModel m){
			if (m.getRowCount() > 0) {
			    for (int i = m.getRowCount() - 1; i > -1; i--) {
			        m.removeRow(i);
			    }
			}
			listPhongChuaThanhToan = CTDatPhong_BUS.loadPhongChuaThanhToan(ng);
			listPhongChuaThanhToan.forEach(p -> {
				m.addRow(new Object[] {p.getMaPhong(), p.getKhachHang().getTenKH()});
			});
		}
		
		public frmThanhToan() {
			
			listPhongChuaThanhToan = new ArrayList<CTDatPhong_DTO>();
			bus=new HoaDon_BUS();
			
			setBounds(100, 100, 900, 700);
			getContentPane().setLayout(null);
			JLabel lblTngTin = new JLabel("Ti\u1EC1n ph\u00F2ng");
			lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTin.setBounds(492, 431, 90, 30);
			getContentPane().add(lblTngTin);
			
			JScrollPane scrlistthanhtoan = new JScrollPane();
			scrlistthanhtoan.setBounds(12, 265, 800, 143);
			getContentPane().add(scrlistthanhtoan);
			
			
			DefaultTableModel m = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Ma phong", "Ten khach hang", "Ten loai phong","Gia phong", "Ngay nhan", "Ngay tra"
					}
				);
				table = new JTable(m);
				scrlistthanhtoan.setViewportView(table);
				
					
				JScrollPane scrlisttendichvu = new JScrollPane();
				scrlisttendichvu.setBounds(12, 435, 330, 118);
				getContentPane().add(scrlisttendichvu);
				
				DefaultTableModel n = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"Tên dịch vụ", "Số lượng", "Giá tiền"
						}
					);
					table_dich = new JTable(n);
					scrlisttendichvu.setViewportView(table_dich);
			
			JLabel lblTngTinDich = new JLabel("Ti\u1EC1n d\u1ECBch v\u1EE5");
			lblTngTinDich.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTinDich.setBounds(485, 474, 97, 30);
			getContentPane().add(lblTngTinDich);
			
			JLabel lblTngTinThanh = new JLabel("T\u1ED5ng:");
			lblTngTinThanh.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTinThanh.setBounds(533, 531, 52, 22);
			getContentPane().add(lblTngTinThanh);
			
			JLabel lbTienPhong = new JLabel("");
			lbTienPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbTienPhong.setForeground(Color.GRAY);
			lbTienPhong.setBounds(594, 431, 170, 30);
			getContentPane().add(lbTienPhong);
			
			JLabel lbTienDichVu = new JLabel("");
			lbTienDichVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbTienDichVu.setForeground(Color.GRAY);
			lbTienDichVu.setBounds(594, 474, 170, 30);
			getContentPane().add(lbTienDichVu);
			
			JLabel lbTongTien = new JLabel("");
			lbTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbTongTien.setForeground(Color.RED);
			lbTongTien.setBounds(594, 531, 170, 30);
			getContentPane().add(lbTongTien);
			
			JScrollPane scrlistPhong = new JScrollPane();
			scrlistPhong.setBounds(462, 89, 274, 149);
			getContentPane().add(scrlistPhong);
			DefaultTableModel h = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Mã phòng", "Tên khách hàng"
					}
				);
			table_phong = new JTable(h);
			ListSelectionModel cellSelectionModel = table_phong.getSelectionModel();
		    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if(table_phong.getRowCount() < 1 || table_phong.getSelectedRow() < 0) return;
			    	selectMaPhong = (int) table_phong.getValueAt(table_phong.getSelectedRow(), 0);
			    	
					ctdp = CTDatPhong_BUS.loadTableCTDP(selectMaPhong);
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					}
					m.addRow(new Object[] {ctdp.getMaPhong(), ctdp.getKhachHang().getTenKH(), ctdp.getLoaiPhong().getTenLoaiPhong(), ctdp.getLoaiPhong().getGiaPhong(), ctdp.getNgayNhan(), ctdp.getNgayTra()});
					
					listctdv = CTDichVu_BUS.loadTableDV(ctdp.getMaCTDatPhong());
					if (n.getRowCount() > 0) {
					    for (int i = n.getRowCount() - 1; i > -1; i--) {
					        n.removeRow(i);
					    }
					}
					tienphong = 0;
					tiendichVu = 0;
					tongtien=0;
					listctdv.forEach(ctdv -> {
						n.addRow(new Object[] {ctdv.getDichVu().getTenDichVu(), ctdv.getSoLuong(), ctdv.getTongTienDichVu()});
						tiendichVu += ctdv.getTongTienDichVu();
					});
					int KhoangCachNgay = (int) ctdp.getNgayTra().getTime() / (24 * 60 * 60 * 1000) - (int) ctdp.getNgayNhan().getTime() / (24 * 60 * 60 * 1000);
					tienphong=ctdp.getLoaiPhong().getGiaPhong()*KhoangCachNgay;
					lbTienPhong.setText(String.format("%,d", tienphong));
					lbTienDichVu.setText(String.format("%,d", tiendichVu));
					tongtien=tienphong+tiendichVu;
					lbTongTien.setText(String.format("%,d", tongtien));
					
				}
		    });
		    table_phong.setRowSelectionAllowed(true);
			scrlistPhong.setViewportView(table_phong);
			
			JDateChooser dateNgayDanhGia = new JDateChooser();
			dateNgayDanhGia.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {

					loadPhongChuaThanhToan(new Date(dateNgayDanhGia.getDate().getTime()), h);
					
				}
			});
			dateNgayDanhGia.setBounds(199, 89, 150, 30);
			getContentPane().add(dateNgayDanhGia);
			dateNgayDanhGia.setDateFormatString("dd-MM-yyyy");
			dateNgayDanhGia.setDate(new java.util.Date());
			
			
			Button btnThanhToan = new Button("Thanh to\u00E1n");
			btnThanhToan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HoaDon_DTO hd = new HoaDon_DTO();
					hd.setNgayThuTien(new Date(new java.util.Date().getTime()));
					hd.setSoTienThu(tongtien);
					hd.setMaCTDatPhong(ctdp.getMaCTDatPhong());
					hd.setMaNhanVien(frmDashboard.user.getMaNhanVien());
					boolean a = HoaDon_BUS.Insert(hd);
					if(a==true)
					{
						JOptionPane.showMessageDialog(null, "Thanh toán thành công", "Thanh toán", JOptionPane.CLOSED_OPTION);
						loadPhongChuaThanhToan(new Date(dateNgayDanhGia.getDate().getTime()), h);
						if (m.getRowCount() > 0) {
						    for (int i = m.getRowCount() - 1; i > -1; i--) {
						        m.removeRow(i);
						    }
						}
						if (n.getRowCount() > 0) {
						    for (int i = n.getRowCount() - 1; i > -1; i--) {
						        n.removeRow(i);
						    }
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Thanh toán thất bại", "Thanh toán", JOptionPane.CLOSED_OPTION);
					
				}
			});
			btnThanhToan.setBackground(Color.ORANGE);
			btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnThanhToan.setBounds(338, 590, 211, 40);
			
			getContentPane().add(btnThanhToan);
			
			JLabel lblNewLabel_1 = new JLabel("Thanh to\u00E1n ");
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(310, 23, 150, 30);
			getContentPane().add(lblNewLabel_1);
			

			
			

			loadPhongChuaThanhToan(new Date(dateNgayDanhGia.getDate().getTime()), h);
			
			
			System.out.print("So phong: " + listPhongChuaThanhToan.size());
			
			JLabel lblNewLabel_2 = new JLabel("Ng\u00E0y ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(141, 89, 46, 30);
			getContentPane().add(lblNewLabel_2);
			
			
		}
		    }
