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
import java.awt.Color;

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
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);

		JLabel NhanXet = new JLabel("Nội dung phản hồi");
		NhanXet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NhanXet.setBounds(68, 372, 154, 30);
		getContentPane().add(NhanXet);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 372, 439, 129);
		getContentPane().add(scrollPane);
		
				JTextArea txtNoiDungDanhGia = new JTextArea();
				txtNoiDungDanhGia.setFont(new Font("Monospaced", Font.PLAIN, 14));
				scrollPane.setViewportView(txtNoiDungDanhGia);

		JLabel lbPhong = new JLabel("Phòng");
		lbPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbPhong.setBounds(164, 157, 58, 23);
		getContentPane().add(lbPhong);
		

		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaPhong.setBounds(234, 155, 150, 30);
		getContentPane().add(txtMaPhong);
		txtMaPhong.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(470, 112, 297, 68);
		getContentPane().add(scrollPane_1);
		
		DefaultTableModel m = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tên khách hàng", "CMND"
			}
		);
		table = new JTable(m);
		scrollPane_1.setViewportView(table);
		
		JDateChooser dateNgayDanhGia = new JDateChooser();
		dateNgayDanhGia.setBounds(234, 112, 150, 30);
		getContentPane().add(dateNgayDanhGia);
		dateNgayDanhGia.setDateFormatString("dd-MM-yyyy");

		JButton btnDanhGia = new JButton("GHI NHẬN");
		btnDanhGia.setBackground(Color.ORANGE);
		btnDanhGia.setFont(new Font("Tahoma", Font.BOLD, 18));
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
		btnDanhGia.setBounds(336, 525, 214, 37);
		getContentPane().add(btnDanhGia);

		JLabel NgayDanhGia = new JLabel("Phản hồi cho ngày");
		NgayDanhGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NgayDanhGia.setBounds(64, 112, 156, 23);
		getContentPane().add(NgayDanhGia);
		
		JButton btnNewButton = new JButton("Kiểm tra");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
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
		btnNewButton.setBounds(354, 206, 166, 37);
		getContentPane().add(btnNewButton);
		
		JLabel lblTipNhnPhn = new JLabel("Tiếp nhận phản hồi từ khách hàng");
		lblTipNhnPhn.setForeground(Color.BLUE);
		lblTipNhnPhn.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTipNhnPhn.setBounds(240, 13, 439, 42);
		getContentPane().add(lblTipNhnPhn);
		
	}
}