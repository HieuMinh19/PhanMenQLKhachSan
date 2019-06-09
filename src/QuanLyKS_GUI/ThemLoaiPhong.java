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
import java.awt.Font;
import java.awt.Color;

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
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JLabel TenLoaiPhong = new JLabel("Tên loại phòng");
		TenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TenLoaiPhong.setBounds(177, 89, 119, 22);
		getContentPane().add(TenLoaiPhong);
		
		JLabel GiaPhong = new JLabel("Gía Phòng");
		GiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GiaPhong.setBounds(215, 149, 81, 22);
		getContentPane().add(GiaPhong);
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenLoaiPhong.setBounds(314, 86, 300, 30);
		getContentPane().add(txtTenLoaiPhong);
		txtTenLoaiPhong.setColumns(10);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaPhong.setBounds(315, 146, 300, 30);
		getContentPane().add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		JButton txtThemLoaiPhong = new JButton("Thêm loại phòng");
		txtThemLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtThemLoaiPhong.setBackground(Color.GREEN);
		txtThemLoaiPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loaiphongDTO = new LoaiPhong_DTO(); 

				loaiphongDTO.setTenLoaiPhong(txtTenLoaiPhong.getText());
				loaiphongDTO.setGiaPhong(Integer.parseInt(txtGiaPhong.getText()));

				 if(LoaiPhong_BUS.Insert(loaiphongDTO) == true)
					 JOptionPane.showMessageDialog(null, "tạo loại phòng thành công", "Notice !", JOptionPane.INFORMATION_MESSAGE);
				 else
					 JOptionPane.showMessageDialog(null, "Tạo loại phòng thất bại", "Notice !", JOptionPane.CLOSED_OPTION);
			}
		});
		txtThemLoaiPhong.setBounds(373, 214, 200, 40);
		getContentPane().add(txtThemLoaiPhong);
		
		JLabel lblThmLoiPhng = new JLabel("Thêm loại phòng");
		lblThmLoiPhng.setForeground(Color.BLUE);
		lblThmLoiPhng.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThmLoiPhng.setBounds(357, 13, 188, 37);
		getContentPane().add(lblThmLoiPhng);

	}
}
