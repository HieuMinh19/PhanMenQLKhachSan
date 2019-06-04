package QuanLyKS_GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class frmBooking_Step1 extends JInternalFrame {
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBooking_Step1 frame = new frmBooking_Step1();
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
	public frmBooking_Step1() {
		setBounds(100, 100, 729, 593);
		getContentPane().setLayout(null);
		
		JDateChooser date_NgayNhanPhong = new JDateChooser();
		date_NgayNhanPhong.setBounds(208, 121, 142, 25);
		getContentPane().add(date_NgayNhanPhong);
		date_NgayNhanPhong.setDateFormatString("dd/MM/yyyy");
		
		
		JDateChooser date_NgayTraPhong = new JDateChooser();
		date_NgayTraPhong.setBounds(420, 121, 133, 25);
		getContentPane().add(date_NgayTraPhong);
		date_NgayTraPhong.setDateFormatString("dd/MM/yyyy");
		
		JLabel lblNewLabel = new JLabel("Ng\u00E0y nh\u1EADn ph\u00F2ng");
		lblNewLabel.setBounds(224, 85, 110, 25);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNgyTrPhng = new JLabel("Ng\u00E0y tr\u1EA3 ph\u00F2ng");
		lblNgyTrPhng.setBounds(435, 85, 110, 25);
		getContentPane().add(lblNgyTrPhng);
		
		JLabel lblNewLabel_1 = new JLabel("CH\u00C0O M\u1EEANG B\u1EA0N \u0110\u1EB6T PH\u00D2NG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(249, 27, 296, 37);
		getContentPane().add(lblNewLabel_1);
		
		JEditorPane dtrpnCjbsjk = new JEditorPane();
		dtrpnCjbsjk.setText("c,jbsjk");
		dtrpnCjbsjk.setBounds(208, 237, 277, 68);
		getContentPane().add(dtrpnCjbsjk);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00F4 t\u1EA3");
		lblNewLabel_2.setBounds(88, 237, 110, 25);
		getContentPane().add(lblNewLabel_2);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(495, 237, 58, 68);
		getContentPane().add(editorPane);
		
		JButton btnNewButton = new JButton("Ti\u1EBFp t\u1EE5c");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(368, 459, 161, 37);
		getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(300, 195, 253, 20);
		getContentPane().add(comboBox);
		
		JLabel lblDchV = new JLabel("Lo\u1EA1i ph\u00F2ng");
		lblDchV.setBounds(399, 167, 110, 25);
		getContentPane().add(lblDchV);
		
		table = new JTable();
		table.setBounds(208, 332, 321, 62);
		getContentPane().add(table);
		
		textField = new JTextField();
		textField.setBounds(204, 195, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblNewLabel_3.setBounds(208, 172, 46, 14);
		getContentPane().add(lblNewLabel_3);
	}
}
