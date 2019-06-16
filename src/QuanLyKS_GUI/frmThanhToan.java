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

import java.lang.NumberFormatException;
	import QuanLyKS_BUS.NhanVien_BUS;
	import QuanLyKS_DTO.HoaDon_DTO;
import QuanLyKS_DTO.NhanVien_DTO;
import QuanLyKS_BUS.HoaDon_BUS;
	import javax.swing.JButton;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import java.awt.event.ActionListener;
	import java.sql.Date;
	import java.util.ArrayList;
	import java.awt.event.ActionEvent;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	
	import java.util.concurrent.TimeUnit;
import java.awt.Button;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
	public class frmThanhToan extends JInternalFrame {
		int tienPhong =0;
		int tiendichVu =0;
		int tongtien =0;
		int mactdatphong;
		private HoaDon_BUS bus;
		private JTable table;
		private JTable table_dich;
		private int selectedRow;
		private String giatien;
		private long giatien1;
		Date startDate = null;
		Date endDate = null;
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
		public frmThanhToan() {
			
			ArrayList<Integer> TienPhong = new ArrayList<>();
			ArrayList<Integer> TienDichVu = new ArrayList<>();
			bus=new HoaDon_BUS();
			
			setBounds(100, 100, 900, 700);
			getContentPane().setLayout(null);
			
			JTextPane txtTongTienThanhToan = new JTextPane();
			txtTongTienThanhToan.setEditable(false);
			txtTongTienThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTongTienThanhToan.setBounds(594, 456, 170, 30);
			getContentPane().add(txtTongTienThanhToan);
			
			
			JTextPane txtTongTienPhong = new JTextPane();
			txtTongTienPhong.setEditable(false);
			txtTongTienPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTongTienPhong.setBounds(594, 339, 170, 30);
			getContentPane().add(txtTongTienPhong);
			//txtTongTien.setText("ds");
			JLabel lblTngTin = new JLabel("T\u1ED5ng ti\u1EC1n ph\u00F2ng");
			lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTin.setBounds(443, 332, 142, 40);
			getContentPane().add(lblTngTin);
			
			JTextPane txtPhong = new JTextPane();
			txtPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPhong.setBounds(253, 88, 150, 30);
			getContentPane().add(txtPhong);
			
			JTextPane txtTongTienDichVu = new JTextPane();
			txtTongTienDichVu.setEditable(false);
			txtTongTienDichVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtTongTienDichVu.setBounds(594, 400, 170, 30);
			getContentPane().add(txtTongTienDichVu);
			
			JLabel lblNewLabel = new JLabel("Room");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(165, 88, 52, 29);
			getContentPane().add(lblNewLabel);
			
			JScrollPane scrlistthanhtoan = new JScrollPane();
			scrlistthanhtoan.setBounds(12, 155, 860, 164);
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
				scrlisttendichvu.setBounds(12, 332, 369, 98);
				getContentPane().add(scrlisttendichvu);
				
				DefaultTableModel n = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
								"Ten dich vu", "So luong", "Tong tien dich vu"
						}
					);
					table_dich = new JTable(n);
					scrlisttendichvu.setViewportView(table_dich);
			JButton btnSearchThanhToan = new JButton("T\u00ECm ki\u1EBFm");
			btnSearchThanhToan.setBackground(Color.GREEN);
			btnSearchThanhToan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					System.err.println("ffffffffffffffffff");
//					System.err.println("frm Thanh Toan theo ngay"+" "+ dtNgayTra.getDate());
//					System.err.println("frm Thanh Toan theo ngay co get time"+" "+ dtNgayTra.getDate().getTime());
//					System.err.println("ffffffffffffffffff");
					
					long millis = System.currentTimeMillis();
					 java.sql.Date date = new java.sql.Date(millis);
					 System.out.println("Ngay Hien tai"+" "+date);
					
					
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					};
					
					ArrayList<HoaDon_DTO> dsnv = bus.SearchNV(Integer.parseInt(txtPhong.getText()), date);
					dsnv.forEach(nv -> m.addRow(new Object[]{
							nv.getMaCTDatPhong(), 
							nv.getHoTen(),
							nv.getTenLoaiPhong(),
							nv.getGiaPhong(),
							nv.getNgayNhan(),
							nv.getNgayTra()
							}));
					//
					if (n.getRowCount() > 0) {
					    for (int i = n.getRowCount() - 1; i > -1; i--) {
					        n.removeRow(i);
					    }
					};
					ArrayList<HoaDon_DTO> tendv = bus.SearchTenDV(Integer.parseInt(txtPhong.getText()),date);
					tendv.forEach(nv -> n.addRow(new Object[]{ 
							nv.getTenDichVu(),
							nv.getSoLuong(), 
							nv.getTongTienDichVu()
							}));
				    /////
					dsnv.forEach((element) -> {

						mactdatphong = element.getMaCTDatPhong();
				            startDate = element.getNgayNhan();
				            System.out.println("Ngay Nhan"+startDate);
				            endDate = element.getNgayTra();
				            System.out.println("Ngay Tra"+endDate);
				            long getDiff = endDate.getTime() - startDate.getTime();
				            System.out.println("so ngay"+getDiff);
				            long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
				            System.out.println("ngay"+getDaysDiff);
				            tienPhong +=  getDaysDiff * element.getGiaPhong();	
				            System.out.println("tien phogn"+tienPhong);
				     
				           txtTongTienPhong.setText(String.valueOf(tienPhong));
				        });
					tendv.forEach((element) -> {

						
						tiendichVu += element.getTongTienDichVu();
			
						txtTongTienDichVu.setText(String.valueOf(tiendichVu));
			        });
					txtTongTienThanhToan.setText(String.valueOf(tiendichVu+tienPhong));
					tienPhong = 0;
					tiendichVu = 0;
					tongtien = 0;
				}
				
			});
			btnSearchThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnSearchThanhToan.setBounds(473, 81, 132, 36);
			getContentPane().add(btnSearchThanhToan);
			
			JLabel lblTngTinDich = new JLabel("T\u1ED5ng ti\u1EC1n d\u1ECBch v\u1EE5");
			lblTngTinDich.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTinDich.setBounds(443, 394, 139, 36);
			getContentPane().add(lblTngTinDich);
			
			JLabel lblTngTinThanh = new JLabel("T\u1ED5ng:");
			lblTngTinThanh.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTinThanh.setBounds(533, 456, 52, 30);
			getContentPane().add(lblTngTinThanh);
			
			Button btnThanhToan = new Button("Thanh to\u00E1n");
			btnThanhToan.setBackground(Color.ORANGE);
			btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnThanhToan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String SoTienThu = txtTongTienThanhToan.getText();
					int SoTienThu1 = Integer.parseInt(SoTienThu);
					System.out.println("So tien thu" + " "+SoTienThu);
					String SoPhong = txtPhong.getText();
					int SoPhong1 = Integer.parseInt(SoPhong);
					System.out.println("So Phong" + " "+SoPhong);
				int MaNhanVien = frmDashboard.user.getMaNhanVien();
					
					System.out.println("So tien thu" + " "+MaNhanVien);
					
					
					System.out.println("Ngay Hien Tại localDate"+" "+java.time.LocalDate.now()); 
					 long millis = System.currentTimeMillis();
					 java.sql.Date date = new java.sql.Date(millis);
					 System.out.println("Ngay Hien Tại Date"+" "+date); 
				if(SoTienThu1 > 0) {
					HoaDon_DTO nvDTO = new HoaDon_DTO(date,SoTienThu1,mactdatphong,MaNhanVien);
	        		if(HoaDon_BUS.Insert(nvDTO) == true) {
//	        			tienPhong = 0;
//						tiendichVu = 0;
//						tongtien = 0;
	        			JOptionPane.showMessageDialog(null, "Thanh Toan Thanh Cong", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
	        			txtTongTienThanhToan.setText(String.valueOf(0));
	        			txtTongTienPhong.setText(String.valueOf(0));
	        			txtTongTienDichVu.setText(String.valueOf(0));
	        		}else {
	        			JOptionPane.showMessageDialog(null, "Thanh Toan That Bai", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
	        		}
				}else {
					
					JOptionPane.showMessageDialog(null, "Phong Trong Nen Khong THanh Toan", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
				}
					
         		
			}
			});
			btnThanhToan.setBounds(336, 536, 211, 40);
			getContentPane().add(btnThanhToan);
			
			JLabel lblNewLabel_1 = new JLabel("Thanh to\u00E1n ");
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel_1.setBounds(310, 23, 150, 30);
			getContentPane().add(lblNewLabel_1);
			
			
		}
	}
