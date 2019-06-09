package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class frmThemPhong extends JInternalFrame {
	private JTextField txtMaPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThemPhong frame = new frmThemPhong();
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
	public frmThemPhong() {
		setBounds(100, 100, 900, 700);
		getContentPane().setLayout(null);
		
		JLabel lblThmPhng = new JLabel("M\u1EDF r\u1ED9ng s\u1ED1 l\u01B0\u1EE3ng ph\u00F2ng");
		lblThmPhng.setForeground(Color.BLUE);
		lblThmPhng.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblThmPhng.setBounds(282, 13, 274, 37);
		getContentPane().add(lblThmPhng);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(348, 105, 200, 30);
		getContentPane().add(txtMaPhong);
		
		JLabel label = new JLabel("M\u00E3 ph\u00F2ng");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(257, 108, 79, 22);
		getContentPane().add(label);
		
		JComboBox cbTenLoaiPhong = new JComboBox();
		cbTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbTenLoaiPhong.setBounds(348, 168, 200, 30);
		getContentPane().add(cbTenLoaiPhong);
		
		JLabel label_1 = new JLabel("T\u00EAn lo\u1EA1i ph\u00F2ng");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(217, 171, 119, 22);
		getContentPane().add(label_1);
		
		JButton btnThemPhong = new JButton("Th\u00EAm ph\u00F2ng");
		btnThemPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThemPhong.setBackground(Color.ORANGE);
		btnThemPhong.setBounds(366, 230, 150, 40);
		getContentPane().add(btnThemPhong);

	}
}
