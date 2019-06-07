package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
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
					frmBooking_Step4 frame = new frmBooking_Step4();
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
	public frmBooking_Step4() {
		setBounds(100, 100, 1046, 516);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 44, 932, 164);
		DefaultTableModel m = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Ma phong", "Ten khach hang", "Ten loai phong","Gia phong", "Ngay nhan", "Ngay tra"
				}
			);
		tbThongTinChung = new JTable(m);
		scrollPane.setViewportView(tbThongTinChung);
		getContentPane().add(scrollPane);
		
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 253, 556, 98);
		DefaultTableModel n = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Ten dich vu", "So luong", "Tong tien dich vu"
				}
			);
		tbThongTinDichVu = new JTable(n);
		scrollPane_1.setViewportView(tbThongTinDichVu);
		getContentPane().add(scrollPane_1);
		
		JButton btnDatPhong = new JButton("Dat phong");
		btnDatPhong.setBounds(433, 385, 97, 25);
		getContentPane().add(btnDatPhong);

	}
}
