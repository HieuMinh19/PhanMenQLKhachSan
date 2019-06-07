	package QuanLyKS_GUI;
	
	import java.awt.EventQueue;
	import javax.swing.ListSelectionModel;
	import javax.swing.JInternalFrame;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.JTextPane;
	import javax.swing.ListSelectionModel;
	import javax.swing.table.DefaultTableModel;
	import java.lang.NumberFormatException;
	import QuanLyKS_BUS.NhanVien_BUS;
	import QuanLyKS_DTO.HoaDon_DTO;
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
	public class frmThanhToan extends JInternalFrame {
	
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
			
			bus=new HoaDon_BUS();
			
			setBounds(100, 100, 972, 692);
			getContentPane().setLayout(null);
			
			
			JTextPane txtTongTien = new JTextPane();
			txtTongTien.setBounds(738, 367, 139, 49);
			getContentPane().add(txtTongTien);
			//txtTongTien.setText("ds");
			JLabel lblTngTin = new JLabel("Tá»•ng Tiá»�n");
			lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTngTin.setBounds(620, 367, 102, 49);
			getContentPane().add(lblTngTin);
			
			JLabel lblInvoicePayment = new JLabel("Thanh Toan");
			lblInvoicePayment.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblInvoicePayment.setBounds(329, 13, 239, 62);
			getContentPane().add(lblInvoicePayment);
			
			JTextPane txtPhong = new JTextPane();
			txtPhong.setBounds(334, 88, 102, 29);
			getContentPane().add(txtPhong);
			
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
				ListSelectionModel cellSelectionModel = table.getSelectionModel();
			    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
					    int[] selectedRow = table.getSelectedRows();
					    for (int i = 0; i < selectedRow.length; i++) {
					    	startDate =	(Date) table.getValueAt(selectedRow[i], 4);
					        endDate = (Date) table.getValueAt(selectedRow[i], 5);
					        long getDiff = endDate.getTime() - startDate.getTime();
					        long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
					        giatien = table.getValueAt(selectedRow[i], 3).toString()  ;
					        giatien1 =  getDaysDiff * Long.parseLong(giatien) ;				      
					        txtTongTien.setText(String.valueOf(giatien1));
					    }
					  }
		        });
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
					int a ;
					ArrayList<HoaDon_DTO> dsnv = bus.SearchNV(Integer.parseInt(txtPhong.getText()));
					dsnv.forEach(nv -> m.addRow(new Object[]{
							nv.getMaCTDatPhong(), 
							nv.getHoTen(),
							nv.getTenLoaiPhong(),
							nv.getGiaPhong(),
							nv.getNgayNhan(),
							nv.getNgayTra()
							}));				
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
					
				
				    }
			});
			btnSearchThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnSearchThanhToan.setBounds(620, 88, 102, 29);
			getContentPane().add(btnSearchThanhToan);
			
			JTextPane txtstartDate = new JTextPane();
			txtstartDate.setBounds(630, 433, 139, 49);
			getContentPane().add(txtstartDate);
			
			
		    
			
			
			
			
	
		}
	}
