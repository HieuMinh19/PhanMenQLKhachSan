package QuanLyKS_GUI;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JCalendar;

public class Register extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textUname;
	private JPasswordField textPassword;
	private JPasswordField textPasswordRetype;
//	private Account_DTO accountDTO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setBounds(100, 100, 632, 352);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
	 	lblNewLabel.setBounds(52, 52, 69, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 84, 100, 26); 
		getContentPane().add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype password");
		lblRetypePassword.setBounds(52, 121, 120, 26);
		getContentPane().add(lblRetypePassword);
		JCalendar dtNgayLap = new JCalendar();
		dtNgayLap.setBounds(336, 42, 198, 153);
		getContentPane().add(dtNgayLap);
		
		textUname = new JTextField();
		textUname.setText("hieu1");
		textUname.setBounds(208, 52, 86, 20);
		getContentPane().add(textUname);
		textUname.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setToolTipText("123");
		textPassword.setBounds(208, 87, 86, 20);
		getContentPane().add(textPassword);
		
		textPasswordRetype = new JPasswordField();
		textPasswordRetype.setToolTipText("123");
		textPasswordRetype.setBounds(208, 124, 86, 20);
		getContentPane().add(textPasswordRetype);
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				accountDTO = new Account_DTO(); 
//				accountDTO.setUsername( textUname.getText() );
//				boolean isValidPass = Arrays.equals(textPassword.getPassword(),textPasswordRetype.getPassword());
//				if(isValidPass){
//					 accountDTO.setPassword( textPassword.getPassword() );
//					 accountDTO.setRole(2);
//					 
//					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//					 String date = sdf.format( dtNgayLap.getDate() );
//					 accountDTO.setNgayLap(date);
//					 					 
//					 if(  Account_BUS.Insert(accountDTO) == true)
//						 JOptionPane.showMessageDialog(null, "Insert account Success", "Success: " + "Success Mesage", JOptionPane.INFORMATION_MESSAGE);
//					 else
//						 JOptionPane.showMessageDialog(null, "Insert account Fail", "Fail: " + "Success Mesage", JOptionPane.CLOSED_OPTION);
//				 }else {
//					 JOptionPane.showMessageDialog(null, "2 Password is not the same", "Warning: " + "error Mesage", JOptionPane.INFORMATION_MESSAGE);
//				 }
			}
		});
		btnRegister.setBounds(137, 226, 89, 23);
		getContentPane().add(btnRegister);
		
		
	}
}
