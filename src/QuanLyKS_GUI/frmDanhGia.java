package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;


import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import QuanLyKS_DTO.CTDatPhong_DTO;
import QuanLyKS_DTO.DanhGia_DTO;
import QuanLyKS_BUS.CTDatPhong_BUS;
import QuanLyKS_BUS.DanhGia_BUS;
import QuanLyKS_GUI.frmDashboard;
import javax.swing.JButton;
import javax.swing.JDesktopPane;


import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import QuanLyKS_GUI.Register;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmDanhGia extends JInternalFrame {
	private JTextField txtMaPhong;
	private DanhGia_DTO danhgiaDTO;
	static frmDanhGia frame = new frmDanhGia();
	public static Register registerForm = new Register();
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
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
	public frmDanhGia() {
		setBounds(100, 100, 797, 521);
		getContentPane().setLayout(null);

		JLabel DanhGia = new JLabel("Tiep nhan danh gia");
		DanhGia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		DanhGia.setBounds(111, 13, 294, 37);
		getContentPane().add(DanhGia);

		JLabel NhanXet = new JLabel("Danh gia");
		NhanXet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		NhanXet.setBounds(108, 286, 84, 14);
		getContentPane().add(NhanXet);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 286, 326, 97);
		getContentPane().add(scrollPane);

		JTextArea txtNoiDungDanhGia = new JTextArea();
		scrollPane.setViewportView(txtNoiDungDanhGia);

		JLabel MaPhong = new JLabel("Ma phong");
		MaPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		MaPhong.setBounds(111, 124, 84, 14);
		getContentPane().add(MaPhong);
		

		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(254, 120, 198, 23);
		getContentPane().add(txtMaPhong);
		txtMaPhong.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(204, 198, 326, 75);
		getContentPane().add(scrollPane_1);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ten khach hang", "CMND"
			}
		);
		table = new JTable(m);
		scrollPane_1.setViewportView(table);
		
		JDateChooser dateNgayDanhGia = new JDateChooser();
		dateNgayDanhGia.setBounds(251, 86, 201, 25);
		getContentPane().add(dateNgayDanhGia);
		dateNgayDanhGia.setDateFormatString("dd-MM-yyyy");

		JButton btnDanhGia = new JButton("GHI NHẬN");
		btnDanhGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDanhGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				danhgiaDTO = new DanhGia_DTO(); 
				danhgiaDTO.setNoiDung(txtNoiDungDanhGia.getText());
				
				danhgiaDTO.setNgayDanhGia(new Date(dateNgayDanhGia.getDate().getTime()));
				
				danhgiaDTO.setMaPhong(Integer.parseInt(txtMaPhong.getText()));

				if(  DanhGia_BUS.Insert(danhgiaDTO) == true)
					JOptionPane.showMessageDialog(null, "Ghi nhan danh gia thanh cong", "thong bao", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Ghi nhan danh gia that bai", "thong bao", JOptionPane.CLOSED_OPTION);




			}

		});
		btnDanhGia.setEnabled(false);
		btnDanhGia.setBounds(305, 396, 214, 37);
		getContentPane().add(btnDanhGia);

		JLabel NgayDanhGia = new JLabel("cho ngay");
		NgayDanhGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		NgayDanhGia.setBounds(111, 86, 84, 23);
		getContentPane().add(NgayDanhGia);
		
		JButton btnNewButton = new JButton("Tim kiem");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (m.getRowCount() > 0) {
				    for (int i = m.getRowCount() - 1; i > -1; i--) {
				        m.removeRow(i);
				    }
				}
				ArrayList<CTDatPhong_DTO> listCTDP =  CTDatPhong_BUS.searchKH(Integer.parseInt(txtMaPhong.getText()), new Date(dateNgayDanhGia.getDate().getTime()));
				btnDanhGia.setEnabled(listCTDP.size() > 0);
				listCTDP.forEach(ctdp -> m.addRow(new Object[] {ctdp.getKhachHang().getTenKH(), ctdp.getKhachHang().getCMND()}));
			}
		});
		btnNewButton.setBounds(315, 160, 97, 25);
		getContentPane().add(btnNewButton);
		
	}
}