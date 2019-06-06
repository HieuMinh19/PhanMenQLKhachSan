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

import QuanLyKS_DTO.DanhGia_DTO;
import QuanLyKS_BUS.DanhGia_BUS;
import QuanLyKS_GUI.frmMain;
import javax.swing.JButton;
import javax.swing.JDesktopPane;


import java.awt.event.ActionListener;
import QuanLyKS_GUI.Register;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class DanhGia extends JInternalFrame {
	private JTextField txtMaPhong;
	private DanhGia_DTO danhgiaDTO;
	static DanhGia frame = new DanhGia();
	public static Register registerForm = new Register();
	

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
	public DanhGia() {
		setBounds(100, 100, 550, 461);
		getContentPane().setLayout(null);

		JLabel DanhGia = new JLabel("ĐÁNH GIÁ");
		DanhGia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		DanhGia.setBounds(174, 11, 188, 37);
		getContentPane().add(DanhGia);

		JLabel NhanXet = new JLabel("NHẬN XÉT");
		NhanXet.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		NhanXet.setBounds(68, 95, 124, 14);
		getContentPane().add(NhanXet);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(202, 90, 198, 97);
		getContentPane().add(scrollPane);

		JTextArea txtNoiDungDanhGia = new JTextArea();
		scrollPane.setViewportView(txtNoiDungDanhGia);
		txtNoiDungDanhGia.setText("Ã½ kiáº¿n");

		JLabel MaPhong = new JLabel("MÃ PHÒNG");
		MaPhong.setFont(new Font("Tahoma", Font.BOLD, 13));
		MaPhong.setBounds(68, 59, 124, 14);
		getContentPane().add(MaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setText("AUTO LOAD");
		txtMaPhong.setBounds(202, 56, 198, 23);
		getContentPane().add(txtMaPhong);
		txtMaPhong.setColumns(10);

		JCalendar ngayDanhGia = new JCalendar();
		ngayDanhGia.setBounds(202, 205, 198, 153);
		getContentPane().add(ngayDanhGia);

		JButton btnGuiDanhGia = new JButton("GHI NHẬN");
		btnGuiDanhGia.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnGuiDanhGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				danhgiaDTO = new DanhGia_DTO(); 
				danhgiaDTO.setNoiDung(txtNoiDungDanhGia.getText());


					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					 String date = sdf.format( ngayDanhGia.getDate() );

//					 danhgiaDTO.setNgayDanhGia(date);



					 if(  DanhGia_BUS.Insert(danhgiaDTO) == true)
						 JOptionPane.showMessageDialog(null, "thÃªm Ä‘Ã¡nh giÃ¡ thÃ nh cÃ´ng", "thÃ´ng bÃ¡o", JOptionPane.INFORMATION_MESSAGE);
					 else
						 JOptionPane.showMessageDialog(null, "thÃªm Ä‘Ã¡nh giÃ¡ tháº¥t báº¡i", "thÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);




			}

		});
		btnGuiDanhGia.setBounds(120, 379, 129, 23);
		getContentPane().add(btnGuiDanhGia);

		JButton btnThoat = new JButton("THOÁT");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMain.controlFrame(frmMain.FRM_BOOKING1);	
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThoat.setBounds(326, 379, 89, 23);
		getContentPane().add(btnThoat);

		JLabel NgayDanhGia = new JLabel("NGÀY ĐÁNH GIÁ");
		NgayDanhGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		NgayDanhGia.setBounds(68, 274, 124, 14);
		getContentPane().add(NgayDanhGia);

	}
}