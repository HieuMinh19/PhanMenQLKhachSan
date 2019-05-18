package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmThemNhanVien extends JInternalFrame {
	private JTextField txtTenNhanVien;
	private JTextField textCMND;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmThemNhanVien frame = new frmThemNhanVien();
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
	public frmThemNhanVien() {
		setBounds(100, 100, 626, 434);
		getContentPane().setLayout(null);
		
		JLabel lblThmNhnVin = new JLabel("Th\u00EAm nh\u00E2n vi\u00EAn");
		lblThmNhnVin.setFont(new Font("Sylfaen", Font.PLAIN, 22));
		lblThmNhnVin.setBounds(242, 27, 159, 35);
		getContentPane().add(lblThmNhnVin);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblNewLabel.setBounds(23, 72, 75, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(23, 114, 75, 22);
		getContentPane().add(lblCmnd);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setBounds(108, 73, 159, 20);
		getContentPane().add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);
		
		textCMND = new JTextField();
		textCMND.setBounds(108, 115, 159, 20);
		getContentPane().add(textCMND);
		textCMND.setColumns(10);
		
		JLabel lblChcV = new JLabel("Ch\u1EE9c v\u1EE5");
		lblChcV.setBounds(23, 161, 63, 22);
		getContentPane().add(lblChcV);
		
		JComboBox cbxChucVu = new JComboBox();
		cbxChucVu.setBounds(108, 162, 159, 20);
		getContentPane().add(cbxChucVu);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y v\u00E0o l\u00E0m");
		lblNgySinh.setBounds(23, 237, 75, 22);
		getContentPane().add(lblNgySinh);
		
		JCalendar dtNgayVaoLam = new JCalendar();
		dtNgayVaoLam.setBounds(108, 201, 198, 153);
		getContentPane().add(dtNgayVaoLam);
		
		JCalendar dtNgaySinh = new JCalendar();
		dtNgaySinh.setBounds(388, 72, 198, 153);
		getContentPane().add(dtNgaySinh);
		
		JLabel label = new JLabel("Ng\u00E0y sinh");
		label.setBounds(315, 114, 63, 22);
		getContentPane().add(label);
		
		Button button = new Button("Th\u00EAm nh\u00E2n vi\u00EAn");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		button.setBounds(315, 361, 93, 22);
		getContentPane().add(button);

	}
}
