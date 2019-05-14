package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import QuanLyKS_DTO.DichVu_DTO;
import javax.swing.JOptionPane;
import QuanLyKS_BUS.DichVu_BUS;
import javax.swing.JPasswordField;
import java.util.Arrays;
import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JCalendar;




public class DichVu extends JInternalFrame {
	private JTextField txtMaDichVu;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private DichVu_DTO dichvu_DTO;
	// private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVu frame = new DichVu();
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
	public DichVu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("th\u00EAm dich vu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(80, 11, 286, 44);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("MÃƒ Dá»ŠCH Vá»¤");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 77, 103, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TÃŠN Dá»ŠCH Vá»¤");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 113, 103, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("GIÃ� Dá»ŠCH Vá»¤");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 151, 103, 14);
		getContentPane().add(lblNewLabel_3);

		txtMaDichVu = new JTextField();
		txtMaDichVu.setBounds(108, 75, 124, 20);
		getContentPane().add(txtMaDichVu);
		txtMaDichVu.setColumns(10);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setBounds(108, 111, 124, 20);
		getContentPane().add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBounds(108, 149, 124, 20);
		getContentPane().add(txtGiaDichVu);
		txtGiaDichVu.setColumns(10);

		JButton btnThemDichVu = new JButton("ThÃªm Dich Vá»¥");
		btnThemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dichvu_DTO = new DichVu_DTO(); 

				dichvu_DTO.setTenDichVu( txtTenDichVu.getText() );
				dichvu_DTO.setGiaDichVu( Integer.parseInt(txtGiaDichVu.getText()));
				//boolean isValidPass = Arrays.equals(textPassword.getPassword(),textPasswordRetype.getPassword());




					 if(  DichVu_BUS.Insert(dichvu_DTO) == true)
						 JOptionPane.showMessageDialog(null, "Insert account Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
					 else
						 JOptionPane.showMessageDialog(null, "Insert account Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);

			}
		});
		btnThemDichVu.setBounds(121, 198, 140, 23);
		getContentPane().add(btnThemDichVu);




		JButton btnNewButton = new JButton("THÃŠM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


		}
		});

	}
}