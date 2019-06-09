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
			
			setBounds(100, 100, 972, 692);
			getContentPane().setLayout(null);
			
			JTextPane txtTongTienThanhToan = new JTextPane();
			txtTongTienThanhToan.setBounds(792, 430, 139, 36);
			getContentPane().add(txtTongTienThanhToan);
			
			
			JTextPane txtTongTienPhong = new JTextPane();
			txtTongTienPhong.setBounds(792, 332, 139, 36);
			getContentPane().add(txtTongTienPhong);
			//txtTongTien.setText("ds");
			JLabel lblTngTin = new JLabel("T\u1ED5ng Ti\u1EC1n Ph\u00F2ng");
			lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTngTin.setBounds(580, 332, 142, 49);
			getContentPane().add(lblTngTin);
			
			JLabel lblInvoicePayment = new JLabel("Thanh Toan");
			lblInvoicePayment.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblInvoicePayment.setBounds(329, 13, 239, 62);
			getContentPane().add(lblInvoicePayment);
			
			JTextPane txtPhong = new JTextPane();
			txtPhong.setBounds(334, 88, 102, 29);
			getContentPane().add(txtPhong);
			
			JTextPane txtTongTienDichVu = new JTextPane();
			txtTongTienDichVu.setBounds(792, 381, 139, 36);
			getContentPane().add(txtTongTienDichVu);
			
			JLabel lblNewLabel = new JLabel("Room");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(208, 88, 52, 29);
			getContentPane().add(lblNewLabel);
			
			JScrollPane scrlistthanhtoan = new JScrollPane();
			scrlistthanhtoan.setBounds(12, 155, 932, 164);
			getContentPane().add(scrlistthanhtoan);
			
			DefaultTableModel m = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
							"Ma phong", "Ten khach hang", "Ten loai phong","Gia phong", "Ngay nhan", "Ngay tra"
					}
				);
				table = new JTable(m);
//				ListSelectionModel cellSelectionModel = table.getSelectionModel();
//			    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
//					public void valueChanged(ListSelectionEvent e) {
//					    int[] selectedRow = table.getSelectedRows();
//					    for (int i = 0; i < selectedRow.length; i++) {
//					    	startDate =	(Date) table.getValueAt(selectedRow[i], 4);
//					        endDate = (Date) table.getValueAt(selectedRow[i], 5);
//					        long getDiff = endDate.getTime() - startDate.getTime();
//					        long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
//					        giatien = table.getValueAt(selectedRow[i], 3).toString()  ;
//					        giatien1 =  getDaysDiff * Long.parseLong(giatien) ;				      
//					        txtTongTien.setText(String.valueOf(giatien1));
//					    }
//					  }
//		        });
				scrlistthanhtoan.setViewportView(table);
				JScrollPane scrlisttendichvu = new JScrollPane();
				scrlisttendichvu.setBounds(12, 332, 556, 98);
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
			JButton btnSearchThanhToan = new JButton("Search");
			btnSearchThanhToan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					if (m.getRowCount() > 0) {
					    for (int i = m.getRowCount() - 1; i > -1; i--) {
					        m.removeRow(i);
					    }
					};
					
					ArrayList<HoaDon_DTO> dsnv = bus.SearchNV(Integer.parseInt(txtPhong.getText()));
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
					ArrayList<HoaDon_DTO> tendv = bus.SearchTenDV(Integer.parseInt(txtPhong.getText()));
					tendv.forEach(nv -> n.addRow(new Object[]{ 
							nv.getTenDichVu(),
							nv.getSoLuong(), 
							nv.getTongTienDichVu()
							}));
				    /////
					dsnv.forEach((element) -> {
				         // a =  element.getMaCTDatPhong();
//				          System.out.println("ma pg"+a);
//				            System.out.println(element.getHoTen());
//				            System.out.println(element.getTenLoaiPhong());
//				            System.out.println(element.getGiaPhong());
//				            System.out.println(element.getNgayNhan());
//				            System.out.println(element.getNgayTra());
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
				            //startDate =	(Date) table.getValueAt(selectedRow[i], 4);
					      //  endDate = (Date) table.getValueAt(selectedRow[i], 5);
					       // long getDiff = endDate.getTime() - startDate.getTime();
					       // long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
					       // giatien = table.getValueAt(selectedRow[i], 3).toString()  ;
					       // giatien1 =  getDaysDiff * Long.parseLong(giatien) ;				      
					       // txtTongTien.setText(String.valueOf(giatien1));
				           txtTongTienPhong.setText(String.valueOf(tienPhong));
				        });
					tendv.forEach((element) -> {
			         // a =  element.getMaCTDatPhong();
//			          System.out.println("ma pg"+a);
//			            System.out.println(element.getHoTen());
//			            System.out.println(element.getTenLoaiPhong());
//			            System.out.println(element.getGiaPhong());
//			            System.out.println(element.getNgayNhan());
//			            System.out.println(element.getNgayTra());
						
						tiendichVu += element.getTongTienDichVu();
			            //startDate =	(Date) table.getValueAt(selectedRow[i], 4);
				      //  endDate = (Date) table.getValueAt(selectedRow[i], 5);
				       // long getDiff = endDate.getTime() - startDate.getTime();
				       // long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
				       // giatien = table.getValueAt(selectedRow[i], 3).toString()  ;
				       // giatien1 =  getDaysDiff * Long.parseLong(giatien) ;				      
				       // txtTongTien.setText(String.valueOf(giatien1));
						txtTongTienDichVu.setText(String.valueOf(tiendichVu));
			        });
					txtTongTienThanhToan.setText(String.valueOf(tiendichVu+tienPhong));
					tienPhong = 0;
					tiendichVu = 0;
					tongtien = 0;
				}
				
			});
			btnSearchThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSearchThanhToan.setBounds(620, 88, 102, 29);
			getContentPane().add(btnSearchThanhToan);
			
			JLabel lblTngTinDich = new JLabel("T\u1ED5ng Ti\u1EC1n Dich Vu");
			lblTngTinDich.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTngTinDich.setBounds(580, 375, 164, 49);
			getContentPane().add(lblTngTinDich);
			
			JLabel lblTngTinThanh = new JLabel("T\u1ED5ng Ti\u1EC1n Thanh To\u00E1n");
			lblTngTinThanh.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTinThanh.setBounds(580, 425, 183, 49);
			getContentPane().add(lblTngTinThanh);
			
			Button btnThanhToan = new Button("Thanh To\u00E1n");
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

					
         		HoaDon_DTO nvDTO = new HoaDon_DTO(date,SoTienThu1,mactdatphong,MaNhanVien);
	        		if(HoaDon_BUS.Insert(nvDTO) == true) {
	        			JOptionPane.showMessageDialog(null, "Thanh Toan Thanh Cong", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
	        		}else {
	        			JOptionPane.showMessageDialog(null, "Thanh Toan That Bai", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
	        		}
			}
			});
			btnThanhToan.setBounds(522, 527, 164, 24);
			getContentPane().add(btnThanhToan);
			
		}
	}
