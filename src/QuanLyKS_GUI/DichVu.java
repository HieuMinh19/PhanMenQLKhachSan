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
import QuanLyKS_DAL.DichVu_DAL;

import java.sql.ResultSet;
import java.sql.SQLException;




public class DichVu extends JInternalFrame {
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
		DichVu_DAL CTDichVu_DAL = new DichVu_DAL();
        ResultSet rsListCTDichVu = CTDichVu_DAL.getListDV();

		setBounds(100, 100, 776, 481);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("TH\u00CAM D\u1ECACH V\u1EE4");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setBounds(80, 11, 286, 44);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("T\u00EAn d\u1ECBch v\u1EE5");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 113, 103, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gi\u00E1 d\u1ECBch v\u1EE5");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 151, 103, 14);
		getContentPane().add(lblNewLabel_3);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setBounds(108, 111, 124, 20);
		getContentPane().add(txtTenDichVu);
		txtTenDichVu.setColumns(10);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setBounds(108, 149, 124, 20);
		getContentPane().add(txtGiaDichVu);
		txtGiaDichVu.setColumns(10);

		JButton btnThemDichVu = new JButton("Th\u00EAm d\u1ECBch v\u1EE5");
		btnThemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dichvu_DTO = new DichVu_DTO(); 
				dichvu_DTO.setTenDichVu( txtTenDichVu.getText() );
				dichvu_DTO.setGiaDichVu( Integer.parseInt(txtGiaDichVu.getText()));
				
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