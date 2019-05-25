package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Button;

public class DatDichVu extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatDichVu frame = new DatDichVu();
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
	public DatDichVu() {
		setBounds(100, 100, 667, 491);
		getContentPane().setLayout(null);
		
		JLabel lblMPhng = new JLabel("M\u00E3 ph\u00F2ng");
		lblMPhng.setBounds(20, 88, 63, 14);
		getContentPane().add(lblMPhng);
		
		JComboBox cbxMaPhong = new JComboBox();
		cbxMaPhong.setBounds(128, 85, 464, 20);
		getContentPane().add(cbxMaPhong);
		
		JLabel lblNewLabel = new JLabel("Th\u1EDDi gian \u0111\u1EB7t");
		lblNewLabel.setBounds(20, 204, 81, 14);
		getContentPane().add(lblNewLabel);
		
		JCalendar dtTuNgay = new JCalendar();
		dtTuNgay.setBounds(128, 143, 198, 153);
		getContentPane().add(dtTuNgay);
		
		JCalendar dtDenNgay = new JCalendar();
		dtDenNgay.setBounds(394, 143, 198, 153);
		getContentPane().add(dtDenNgay);
		
		JComboBox cbxMaDichVu = new JComboBox();
		cbxMaDichVu.setBounds(130, 317, 464, 20);
		getContentPane().add(cbxMaDichVu);
		
		JLabel lblDchV = new JLabel("D\u1ECBch v\u1EE5");
		lblDchV.setBounds(20, 320, 63, 14);
		getContentPane().add(lblDchV);
		
		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSLng.setBounds(20, 361, 63, 14);
		getContentPane().add(lblSLng);
		
		JLabel lbltDchV = new JLabel("\u0110\u1EB6T D\u1ECACH V\u1EE4");
		lbltDchV.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbltDchV.setBounds(321, 24, 207, 32);
		getContentPane().add(lbltDchV);
		
		TextField txtSoLuong = new TextField();
		txtSoLuong.setBounds(128, 361, 464, 22);
		getContentPane().add(txtSoLuong);
		
		Button btnDatDichVu = new Button("Booking");
		btnDatDichVu.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDatDichVu.setBounds(328, 409, 108, 22);
		getContentPane().add(btnDatDichVu);

	}
}
