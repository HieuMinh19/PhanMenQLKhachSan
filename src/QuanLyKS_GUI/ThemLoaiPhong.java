package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ibm.icu.text.SimpleDateFormat;

import QuanLyKS_BUS.DanhGia_BUS;
import QuanLyKS_BUS.LoaiPhong_BUS;
import QuanLyKS_DTO.DanhGia_DTO;
import QuanLyKS_DTO.LoaiPhong_DTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemLoaiPhong extends JInternalFrame {
	private JTextField txtTenLoaiPhong;
	private JTextField txtGiaPhong;
	private LoaiPhong_DTO loaiphongDTO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemLoaiPhong frame = new ThemLoaiPhong();
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
	public ThemLoaiPhong() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel LoaiPhong = new JLabel("THÊM LOẠI PHÒNG");
		LoaiPhong.setHorizontalAlignment(SwingConstants.TRAILING);
		LoaiPhong.setBounds(174, 24, 101, 14);
		getContentPane().add(LoaiPhong);
		
		JLabel TenLoaiPhong = new JLabel("Tên Loại Phòng");
		TenLoaiPhong.setBounds(59, 48, 80, 14);
		getContentPane().add(TenLoaiPhong);
		
		JLabel GiaPhong = new JLabel("Giá Phòng");
		GiaPhong.setBounds(59, 94, 80, 14);
		getContentPane().add(GiaPhong);
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setBounds(149, 49, 212, 20);
		getContentPane().add(txtTenLoaiPhong);
		txtTenLoaiPhong.setColumns(10);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setBounds(149, 91, 212, 20);
		getContentPane().add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		JButton txtThemLoaiPhong = new JButton("Thêm Loại Phòng");
		txtThemLoaiPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loaiphongDTO = new LoaiPhong_DTO(); 

				loaiphongDTO.setTenLoaiPhong(txtTenLoaiPhong.getText());
				loaiphongDTO.setGiaPhong(Integer.parseInt(txtGiaPhong.getText()));

				 if(LoaiPhong_BUS.Insert(loaiphongDTO) == true)
					 JOptionPane.showMessageDialog(null, "create new type of room to database successfully", "Notice !", JOptionPane.INFORMATION_MESSAGE);
				 else
					 JOptionPane.showMessageDialog(null, "failed to add new database", "Notice !", JOptionPane.CLOSED_OPTION);
			}
		});
		txtThemLoaiPhong.setBounds(162, 145, 113, 23);
		getContentPane().add(txtThemLoaiPhong);

	}
}
